package com.example.musicapp.demo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Author: alex askerov
 * Date: 9/6/13
 * Time: 12:31 PM
 */
public class DynamicGridView extends GridView {
    private static final int INVALID_ID = -1;

    private static final int MOVE_DURATION = 300;
    private static final int SMOOTH_SCROLL_AMOUNT_AT_EDGE = 8;

    private BitmapDrawable mHoverCell;
    private Rect mHoverCellCurrentBounds;
    private Rect mHoverCellOriginalBounds;

    private int mTotalOffsetY = 0;
    private int mTotalOffsetX = 0;

    private int mDownX = -1;
    private int mDownY = -1;
    private int mLastEventY = -1;
    private int mLastEventX = -1;

    //used to distinguish straight line and diagonal switching
    private int mOverlapIfSwitchStraightLine;

    private List<Long> idList = new ArrayList<Long>();

    private long mMobileItemId = INVALID_ID;

    private boolean mCellIsMobile = false;
    private int mActivePointerId = INVALID_ID;

    private boolean mIsMobileScrolling;
    private int mSmoothScrollAmountAtEdge = 0;
    private boolean mIsWaitingForScrollFinish = false;
    private int mScrollState = OnScrollListener.SCROLL_STATE_IDLE;

    private boolean mIsEditMode = false;
    private List<ObjectAnimator> mWobbleAnimators = new LinkedList<ObjectAnimator>();
    private boolean mHoverAnimation;
    private boolean mReorderAnimation;
    private boolean mWobbleInEditMode = true;
    private boolean mIsEditModeEnabled = true;

    private OnScrollListener mUserScrollListener;
    private OnDropListener mDropListener;
    private OnDragListener mDragListener;
    private OnEditModeChangeListener mEditModeChangeListener;

    private OnItemClickListener mUserItemClickListener;
    private OnItemClickListener mLocalItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (!isEditMode() && isEnabled() && mUserItemClickListener != null) {
                mUserItemClickListener.onItemClick(parent, view, position, id);
            }
        }
    };

    private boolean mUndoSupportEnabled;
    private Stack<DynamicGridModification> mModificationStack;
    private DynamicGridModification mCurrentModification;

    private OnSelectedItemBitmapCreationListener mSelectedItemBitmapCreationListener;
    private View mMobileView;
/*---------------------------------------------------------------------------------------------------------------------------------------------*/
public static boolean DEBUG = false;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    /**
     * A class that represents a fixed view in a list, for example a header at the top
     * or a footer at the bottom.
     */
    private static class FixedViewInfo {
        /**
         * The view to add to the grid
         */
        public View view;
        public ViewGroup viewContainer;
        /**
         * The data backing the view. This is returned from {@link ListAdapter#getItem(int)}.
         */
        public Object data;
        /**
         * <code>true</code> if the fixed view should be selectable in the grid
         */
        public boolean isSelectable;
    }

    private int mNumColumns = AUTO_FIT;
    private View mViewForMeasureRowHeight = null;
    private int mRowHeight = -1;
    //log tag can be at most 23 characters
    private static final String LOG_TAG = "GridViewHeaderAndFooter";

    private ArrayList<FixedViewInfo> mHeaderViewInfos = new ArrayList<FixedViewInfo>();
    private ArrayList<FixedViewInfo> mFooterViewInfos = new ArrayList<FixedViewInfo>();
    private ListAdapter mOriginalAdapter;
    private ItemClickHandler mItemClickHandler;

    private void initHeaderGridView() {
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ListAdapter adapter = getAdapter();
        if (adapter != null && adapter instanceof HeaderViewGridAdapter) {
            ((HeaderViewGridAdapter) adapter).setNumColumns(getNumColumnsCompatible());
            ((HeaderViewGridAdapter) adapter).setRowHeight(getRowHeight());
        }
    }

    @Override
    public void setClipChildren(boolean clipChildren) {
        // Ignore, since the header rows depend on not being clipped
    }

    /**
     * Do not call this method unless you know how it works.
     *
     * @param clipChildren
     */
    public void setClipChildrenSupper(boolean clipChildren) {
        super.setClipChildren(false);
    }

    /**
     * Add a fixed view to appear at the top of the grid. If addHeaderView is
     * called more than once, the views will appear in the order they were
     * added. Views added using this call can take focus if they want.
     * <p/>
     * NOTE: Call this before calling setAdapter. This is so HeaderGridView can wrap
     * the supplied cursor with one that will also account for header views.
     *
     * @param v The view to add.
     */
    public void addHeaderView(View v) {
        addHeaderView(v, null, true);
    }

    /**
     * Add a fixed view to appear at the top of the grid. If addHeaderView is
     * called more than once, the views will appear in the order they were
     * added. Views added using this call can take focus if they want.
     * <p/>
     * NOTE: Call this before calling setAdapter. This is so HeaderGridView can wrap
     * the supplied cursor with one that will also account for header views.
     *
     * @param v            The view to add.
     * @param data         Data to associate with this view
     * @param isSelectable whether the item is selectable
     */
    public void addHeaderView(View v, Object data, boolean isSelectable) {
        ListAdapter adapter = getAdapter();
        if (adapter != null && !(adapter instanceof HeaderViewGridAdapter)) {
            throw new IllegalStateException(
                    "Cannot add header view to grid -- setAdapter has already been called.");
        }

        ViewGroup.LayoutParams lyp = v.getLayoutParams();

        FixedViewInfo info = new FixedViewInfo();
        FrameLayout fl = new FullWidthFixedViewLayout(getContext());

        if (lyp != null) {
            v.setLayoutParams(new FrameLayout.LayoutParams(lyp.width, lyp.height));
            fl.setLayoutParams(new AbsListView.LayoutParams(lyp.width, lyp.height));
        }
        fl.addView(v);
        info.view = v;
        info.viewContainer = fl;
        info.data = data;
        info.isSelectable = isSelectable;
        mHeaderViewInfos.add(info);
        // in the case of re-adding a header view, or adding one later on,
        // we need to notify the observer
        if (adapter != null) {
            ((HeaderViewGridAdapter) adapter).notifyDataSetChanged();
        }
    }

    public void addFooterView(View v) {
        addFooterView(v, null, true);
    }

    public void addFooterView(View v, Object data, boolean isSelectable) {
        ListAdapter mAdapter = getAdapter();
        if (mAdapter != null && !(mAdapter instanceof HeaderViewGridAdapter)) {
            throw new IllegalStateException(
                    "Cannot add header view to grid -- setAdapter has already been called.");
        }

        ViewGroup.LayoutParams lyp = v.getLayoutParams();

        FixedViewInfo info = new FixedViewInfo();
        FrameLayout fl = new FullWidthFixedViewLayout(getContext());

        if (lyp != null) {
            v.setLayoutParams(new FrameLayout.LayoutParams(lyp.width, lyp.height));
            fl.setLayoutParams(new AbsListView.LayoutParams(lyp.width, lyp.height));
        }
        fl.addView(v);
        info.view = v;
        info.viewContainer = fl;
        info.data = data;
        info.isSelectable = isSelectable;
        mFooterViewInfos.add(info);

        if (mAdapter != null) {
            ((HeaderViewGridAdapter) mAdapter).notifyDataSetChanged();
        }
    }

    public int getHeaderViewCount() {
        return mHeaderViewInfos.size();
    }

    public int getFooterViewCount() {
        return mFooterViewInfos.size();
    }

    /**
     * Removes a previously-added header view.
     *
     * @param v The view to remove
     * @return true if the view was removed, false if the view was not a header
     * view
     */
    public boolean removeHeaderView(View v) {
        if (mHeaderViewInfos.size() > 0) {
            boolean result = false;
            ListAdapter adapter = getAdapter();
            if (adapter != null && ((HeaderViewGridAdapter) adapter).removeHeader(v)) {
                result = true;
            }
            removeFixedViewInfo(v, mHeaderViewInfos);
            return result;
        }
        return false;
    }

    /**
     * Removes a previously-added footer view.
     *
     * @param v The view to remove
     * @return true if the view was removed, false if the view was not a header
     * view
     */
    public boolean removeFooterView(View v) {
        if (mFooterViewInfos.size() > 0) {
            boolean result = false;
            ListAdapter adapter = getAdapter();
            if (adapter != null && ((HeaderViewGridAdapter) adapter).removeFooter(v)) {
                result = true;
            }
            removeFixedViewInfo(v, mFooterViewInfos);
            return result;
        }
        return false;
    }

    private void removeFixedViewInfo(View v, ArrayList<FixedViewInfo> where) {
        int len = where.size();
        for (int i = 0; i < len; ++i) {
            FixedViewInfo info = where.get(i);
            if (info.view == v) {
                where.remove(i);
                break;
            }
        }
    }

    @TargetApi(11)
    private int getNumColumnsCompatible() {
        if (Build.VERSION.SDK_INT >= 11) {
            return super.getNumColumns();
        } else {
            try {
                Field numColumns = GridView.class.getDeclaredField("mNumColumns");
                numColumns.setAccessible(true);
                return numColumns.getInt(this);
            } catch (Exception e) {
                if (mNumColumns != -1) {
                    return mNumColumns;
                }
                throw new RuntimeException("Can not determine the mNumColumns for this API platform, please call setNumColumns to set it.");
            }
        }
    }

    @TargetApi(16)
    private int getColumnWidthCompatible() {
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getColumnWidth();
        } else {
            try {
                Field numColumns = GridView.class.getDeclaredField("mColumnWidth");
                numColumns.setAccessible(true);
                return numColumns.getInt(this);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mViewForMeasureRowHeight = null;
    }

    public void invalidateRowHeight() {
        mRowHeight = -1;
    }

    public int getHeaderHeight(int row) {
        if (row >= 0) {
            return mHeaderViewInfos.get(row).view.getMeasuredHeight();
        }

        return 0;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public int getVerticalSpacing() {
        int value = 0;

        try {
            int currentapiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentapiVersion < Build.VERSION_CODES.JELLY_BEAN) {
                Field field = GridView.class.getDeclaredField("mVerticalSpacing");
                field.setAccessible(true);
                value = field.getInt(this);
            } else {
                value = super.getVerticalSpacing();
            }

        } catch (Exception ignore) {
        }

        return value;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public int getHorizontalSpacing() {
        int value = 0;

        try {
            int currentapiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentapiVersion < Build.VERSION_CODES.JELLY_BEAN) {
                Field field = GridView.class.getDeclaredField("mHorizontalSpacing");
                field.setAccessible(true);
                value = field.getInt(this);
            } else {
                value = super.getHorizontalSpacing();
            }

        } catch (Exception ignore) {
        }

        return value;
    }

    public int getRowHeight() {
        if (mRowHeight > 0) {
            return mRowHeight;
        }
        ListAdapter adapter = getAdapter();
        int numColumns = getNumColumnsCompatible();

        // adapter has not been set or has no views in it;
        if (adapter == null || adapter.getCount() <= numColumns * (mHeaderViewInfos.size() + mFooterViewInfos.size())) {
            return -1;
        }
        int mColumnWidth = getColumnWidthCompatible();
        View view = getAdapter().getView(numColumns * mHeaderViewInfos.size(), mViewForMeasureRowHeight, this);
        AbsListView.LayoutParams p = (AbsListView.LayoutParams) view.getLayoutParams();
        if (p == null) {
            p = new AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(p);
        }
        int childHeightSpec = getChildMeasureSpec(
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 0, p.height);
        int childWidthSpec = getChildMeasureSpec(
                MeasureSpec.makeMeasureSpec(mColumnWidth, MeasureSpec.EXACTLY), 0, p.width);
        view.measure(childWidthSpec, childHeightSpec);
        mViewForMeasureRowHeight = view;
        mRowHeight = view.getMeasuredHeight();
        return mRowHeight;
    }

    @TargetApi(11)
    public void tryToScrollToBottomSmoothly() {
        int lastPos = getAdapter().getCount() - 1;
        if (Build.VERSION.SDK_INT >= 11) {
            smoothScrollToPositionFromTop(lastPos, 0);
        } else {
            setSelection(lastPos);
        }
    }

    @TargetApi(11)
    public void tryToScrollToBottomSmoothly(int duration) {
        int lastPos = getAdapter().getCount() - 1;
        if (Build.VERSION.SDK_INT >= 11) {
            smoothScrollToPositionFromTop(lastPos, 0, duration);
        } else {
            setSelection(lastPos);
        }
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        mOriginalAdapter = adapter;
        if (mHeaderViewInfos.size() > 0 || mFooterViewInfos.size() > 0) {
            HeaderViewGridAdapter headerViewGridAdapter = new HeaderViewGridAdapter(mHeaderViewInfos, mFooterViewInfos, adapter);
            int numColumns = getNumColumnsCompatible();
            if (numColumns > 1) {
                headerViewGridAdapter.setNumColumns(numColumns);
            }
            headerViewGridAdapter.setRowHeight(getRowHeight());
            super.setAdapter(headerViewGridAdapter);
        } else {
            super.setAdapter(adapter);
        }
    }

    /**
     * Return original adapter for convenience.
     *
     * @return
     */
    public ListAdapter getOriginalAdapter() {
        return mOriginalAdapter;
    }

    /**
     * full width
     */
    private class FullWidthFixedViewLayout extends FrameLayout {

        public FullWidthFixedViewLayout(Context context) {
            super(context);
        }

        @Override
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            int realLeft = DynamicGridView.this.getPaddingLeft() + getPaddingLeft();
            // Try to make where it should be, from left, full width
            if (realLeft != left) {
                offsetLeftAndRight(realLeft - left);
            }
            super.onLayout(changed, left, top, right, bottom);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int targetWidth = DynamicGridView.this.getMeasuredWidth()
                    - DynamicGridView.this.getPaddingLeft()
                    - DynamicGridView.this.getPaddingRight();
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(targetWidth,
                    MeasureSpec.getMode(widthMeasureSpec));
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public void setNumColumns(int numColumns) {
        super.setNumColumns(numColumns);
        mNumColumns = numColumns;
        ListAdapter adapter = getAdapter();
        if (adapter != null && adapter instanceof HeaderViewGridAdapter) {
            ((HeaderViewGridAdapter) adapter).setNumColumns(numColumns);
        }
    }

    /**
     * ListAdapter used when a HeaderGridView has header views. This ListAdapter
     * wraps another one and also keeps track of the header views and their
     * associated data objects.
     * <p>This is intended as a base class; you will probably not need to
     * use this class directly in your own code.
     */
    private static class HeaderViewGridAdapter implements WrapperListAdapter, Filterable {
        // This is used to notify the container of updates relating to number of columns
        // or headers changing, which changes the number of placeholders needed
        private final DataSetObservable mDataSetObservable = new DataSetObservable();
        private final ListAdapter mAdapter;
        static final ArrayList<FixedViewInfo> EMPTY_INFO_LIST =
                new ArrayList<FixedViewInfo>();

        // This ArrayList is assumed to NOT be null.
        ArrayList<FixedViewInfo> mHeaderViewInfos;
        ArrayList<FixedViewInfo> mFooterViewInfos;
        private int mNumColumns = 1;
        private int mRowHeight = -1;
        boolean mAreAllFixedViewsSelectable;
        private final boolean mIsFilterable;
        private boolean mCachePlaceHoldView = true;
        // From Recycle Bin or calling getView, this a question...
        private boolean mCacheFirstHeaderView = false;

        public HeaderViewGridAdapter(ArrayList<FixedViewInfo> headerViewInfos, ArrayList<FixedViewInfo> footViewInfos, ListAdapter adapter) {
            mAdapter = adapter;
            mIsFilterable = adapter instanceof Filterable;
            if (headerViewInfos == null) {
                mHeaderViewInfos = EMPTY_INFO_LIST;
            } else {
                mHeaderViewInfos = headerViewInfos;
            }

            if (footViewInfos == null) {
                mFooterViewInfos = EMPTY_INFO_LIST;
            } else {
                mFooterViewInfos = footViewInfos;
            }
            mAreAllFixedViewsSelectable = areAllListInfosSelectable(mHeaderViewInfos)
                    && areAllListInfosSelectable(mFooterViewInfos);
        }

        public void setNumColumns(int numColumns) {
            if (numColumns < 1) {
                return;
            }
            if (mNumColumns != numColumns) {
                mNumColumns = numColumns;
                notifyDataSetChanged();
            }
        }

        public void setRowHeight(int height) {
            mRowHeight = height;
        }

        public int getHeadersCount() {
            return mHeaderViewInfos.size();
        }

        public int getFootersCount() {
            return mFooterViewInfos.size();
        }

        /**
         * @return true if this adapter doesn't contain any data.  This is used to determine
         * whether the empty view should be displayed.  A typical implementation will return
         * getCount() == 0 but since getCount() includes the headers and footers, specialized
         * adapters might want a different behavior.
         */
        @Override
        public boolean isEmpty() {
            return (mAdapter == null || mAdapter.isEmpty());
        }

        private boolean areAllListInfosSelectable(ArrayList<FixedViewInfo> infos) {
            if (infos != null) {
                for (FixedViewInfo info : infos) {
                    if (!info.isSelectable) {
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean removeHeader(View v) {
            for (int i = 0; i < mHeaderViewInfos.size(); i++) {
                FixedViewInfo info = mHeaderViewInfos.get(i);
                if (info.view == v) {
                    mHeaderViewInfos.remove(i);
                    mAreAllFixedViewsSelectable =
                            areAllListInfosSelectable(mHeaderViewInfos) && areAllListInfosSelectable(mFooterViewInfos);
                    mDataSetObservable.notifyChanged();
                    return true;
                }
            }
            return false;
        }

        public boolean removeFooter(View v) {
            for (int i = 0; i < mFooterViewInfos.size(); i++) {
                FixedViewInfo info = mFooterViewInfos.get(i);
                if (info.view == v) {
                    mFooterViewInfos.remove(i);
                    mAreAllFixedViewsSelectable =
                            areAllListInfosSelectable(mHeaderViewInfos) && areAllListInfosSelectable(mFooterViewInfos);
                    mDataSetObservable.notifyChanged();
                    return true;
                }
            }
            return false;
        }

        @Override
        public int getCount() {
            if (mAdapter != null) {
                return (getFootersCount() + getHeadersCount()) * mNumColumns + getAdapterAndPlaceHolderCount();
            } else {
                return (getFootersCount() + getHeadersCount()) * mNumColumns;
            }
        }

        @Override
        public boolean areAllItemsEnabled() {
            return mAdapter == null || mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled();
        }

        private int getAdapterAndPlaceHolderCount() {
            return (int) (Math.ceil(1f * mAdapter.getCount() / mNumColumns) * mNumColumns);
        }

        @Override
        public boolean isEnabled(int position) {
            // Header (negative positions will throw an IndexOutOfBoundsException)
            int numHeadersAndPlaceholders = getHeadersCount() * mNumColumns;
            if (position < numHeadersAndPlaceholders) {
                return position % mNumColumns == 0
                        && mHeaderViewInfos.get(position / mNumColumns).isSelectable;
            }

            // Adapter
            final int adjPosition = position - numHeadersAndPlaceholders;
            int adapterCount = 0;
            if (mAdapter != null) {
                adapterCount = getAdapterAndPlaceHolderCount();
                if (adjPosition < adapterCount) {
                    return adjPosition < mAdapter.getCount() && mAdapter.isEnabled(adjPosition);
                }
            }

            // Footer (off-limits positions will throw an IndexOutOfBoundsException)
            final int footerPosition = adjPosition - adapterCount;
            return footerPosition % mNumColumns == 0
                    && mFooterViewInfos.get(footerPosition / mNumColumns).isSelectable;
        }

        @Override
        public Object getItem(int position) {
            // Header (negative positions will throw an ArrayIndexOutOfBoundsException)
            int numHeadersAndPlaceholders = getHeadersCount() * mNumColumns;
            if (position < numHeadersAndPlaceholders) {
                if (position % mNumColumns == 0) {
                    return mHeaderViewInfos.get(position / mNumColumns).data;
                }
                return null;
            }

            // Adapter
            final int adjPosition = position - numHeadersAndPlaceholders;
            int adapterCount = 0;
            if (mAdapter != null) {
                adapterCount = getAdapterAndPlaceHolderCount();
                if (adjPosition < adapterCount) {
                    if (adjPosition < mAdapter.getCount()) {
                        return mAdapter.getItem(adjPosition);
                    } else {
                        return null;
                    }
                }
            }

            // Footer (off-limits positions will throw an IndexOutOfBoundsException)
            final int footerPosition = adjPosition - adapterCount;
            if (footerPosition % mNumColumns == 0) {
                return mFooterViewInfos.get(footerPosition).data;
            } else {
                return null;
            }
        }

        @Override
        public long getItemId(int position) {
            int numHeadersAndPlaceholders = getHeadersCount() * mNumColumns;
            if (mAdapter != null && position >= numHeadersAndPlaceholders) {
                int adjPosition = position - numHeadersAndPlaceholders;
                int adapterCount = mAdapter.getCount();
                if (adjPosition < adapterCount) {
                    return mAdapter.getItemId(adjPosition);
                }
            }
            return -1;
        }

        @Override
        public boolean hasStableIds() {
            return mAdapter != null && mAdapter.hasStableIds();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (DEBUG) {
                Log.d(LOG_TAG, String.format("getView: %s, reused: %s", position, convertView == null));
            }
            // Header (negative positions will throw an ArrayIndexOutOfBoundsException)
            int numHeadersAndPlaceholders = getHeadersCount() * mNumColumns;
            if (position < numHeadersAndPlaceholders) {
                View headerViewContainer = mHeaderViewInfos
                        .get(position / mNumColumns).viewContainer;
                if (position % mNumColumns == 0) {
                    return headerViewContainer;
                } else {
                    if (convertView == null) {
                        convertView = new View(parent.getContext());
                    }
                    // We need to do this because GridView uses the height of the last item
                    // in a row to determine the height for the entire row.
                    convertView.setVisibility(View.INVISIBLE);
                    convertView.setMinimumHeight(headerViewContainer.getHeight());
                    return convertView;
                }
            }
            // Adapter
            final int adjPosition = position - numHeadersAndPlaceholders;
            int adapterCount = 0;
            if (mAdapter != null) {
                adapterCount = getAdapterAndPlaceHolderCount();
                if (adjPosition < adapterCount) {
                    if (adjPosition < mAdapter.getCount()) {
                        return mAdapter.getView(adjPosition, convertView, parent);
                    } else {
                        if (convertView == null) {
                            convertView = new View(parent.getContext());
                        }
                        convertView.setVisibility(View.INVISIBLE);
                        convertView.setMinimumHeight(mRowHeight);
                        return convertView;
                    }
                }
            }
            // Footer
            final int footerPosition = adjPosition - adapterCount;
            if (footerPosition < getCount()) {
                View footViewContainer = mFooterViewInfos
                        .get(footerPosition / mNumColumns).viewContainer;
                if (position % mNumColumns == 0) {
                    return footViewContainer;
                } else {
                    if (convertView == null) {
                        convertView = new View(parent.getContext());
                    }
                    // We need to do this because GridView uses the height of the last item
                    // in a row to determine the height for the entire row.
                    convertView.setVisibility(View.INVISIBLE);
                    convertView.setMinimumHeight(footViewContainer.getHeight());
                    return convertView;
                }
            }
            throw new ArrayIndexOutOfBoundsException(position);
        }

        @Override
        public int getItemViewType(int position) {

            final int numHeadersAndPlaceholders = getHeadersCount() * mNumColumns;
            final int adapterViewTypeStart = mAdapter == null ? 0 : mAdapter.getViewTypeCount() - 1;
            int type = AdapterView.ITEM_VIEW_TYPE_HEADER_OR_FOOTER;
            if (mCachePlaceHoldView) {
                // Header
                if (position < numHeadersAndPlaceholders) {
                    if (position == 0) {
                        if (mCacheFirstHeaderView) {
                            type = adapterViewTypeStart + mHeaderViewInfos.size() + mFooterViewInfos.size() + 1 + 1;
                        }
                    }
                    if (position % mNumColumns != 0) {
                        type = adapterViewTypeStart + (position / mNumColumns + 1);
                    }
                }
            }

            // Adapter
            final int adjPosition = position - numHeadersAndPlaceholders;
            int adapterCount = 0;
            if (mAdapter != null) {
                adapterCount = getAdapterAndPlaceHolderCount();
                if (adjPosition >= 0 && adjPosition < adapterCount) {
                    if (adjPosition < mAdapter.getCount()) {
                        type = mAdapter.getItemViewType(adjPosition);
                    } else {
                        if (mCachePlaceHoldView) {
                            type = adapterViewTypeStart + mHeaderViewInfos.size() + 1;
                        }
                    }
                }
            }

            if (mCachePlaceHoldView) {
                // Footer
                final int footerPosition = adjPosition - adapterCount;
                if (footerPosition >= 0 && footerPosition < getCount() && (footerPosition % mNumColumns) != 0) {
                    type = adapterViewTypeStart + mHeaderViewInfos.size() + 1 + (footerPosition / mNumColumns + 1);
                }
            }
            if (DEBUG) {
                Log.d(LOG_TAG, String.format("getItemViewType: pos: %s, result: %s", position, type, mCachePlaceHoldView, mCacheFirstHeaderView));
            }
            return type;
        }

        /**
         * content view, content view holder, header[0], header and footer placeholder(s)
         *
         * @return
         */
        @Override
        public int getViewTypeCount() {
            int count = mAdapter == null ? 1 : mAdapter.getViewTypeCount();
            if (mCachePlaceHoldView) {
                int offset = mHeaderViewInfos.size() + 1 + mFooterViewInfos.size();
                if (mCacheFirstHeaderView) {
                    offset += 1;
                }
                count += offset;
            }
            if (DEBUG) {
                Log.d(LOG_TAG, String.format("getViewTypeCount: %s", count));
            }
            return count;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {
            mDataSetObservable.registerObserver(observer);
            if (mAdapter != null) {
                mAdapter.registerDataSetObserver(observer);
            }
        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {
            mDataSetObservable.unregisterObserver(observer);
            if (mAdapter != null) {
                mAdapter.unregisterDataSetObserver(observer);
            }
        }

        @Override
        public Filter getFilter() {
            if (mIsFilterable) {
                return ((Filterable) mAdapter).getFilter();
            }
            return null;
        }

        @Override
        public ListAdapter getWrappedAdapter() {
            return mAdapter;
        }

        public void notifyDataSetChanged() {
            mDataSetObservable.notifyChanged();
        }
    }



    @Override
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
        super.setOnItemLongClickListener(getItemClickHandler());
    }

    private ItemClickHandler getItemClickHandler() {
        if (mItemClickHandler == null) {
            mItemClickHandler = new ItemClickHandler();
        }
        return mItemClickHandler;
    }

    private class ItemClickHandler implements android.widget.AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (mOnItemClickListener != null) {
                int resPos = position - getHeaderViewCount() * getNumColumnsCompatible();
                if (resPos >= 0) {
                    mOnItemClickListener.onItemClick(parent, view, resPos, id);
                }
            }
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            if (mOnItemLongClickListener != null) {
                int resPos = position - getHeaderViewCount() * getNumColumnsCompatible();
                if (resPos >= 0) {
                    mOnItemLongClickListener.onItemLongClick(parent, view, resPos, id);
                }
            }
            return true;
        }
    }
/*----------------------------------------------------------------------------------------------------------------------------------------------*/
    public DynamicGridView(Context context) {
        super(context);
        init(context);
        initHeaderGridView();
    }

    public DynamicGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        initHeaderGridView();
    }

    public DynamicGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
        initHeaderGridView();
    }

    @Override
    public void setOnScrollListener(OnScrollListener scrollListener) {
        this.mUserScrollListener = scrollListener;
    }

    public void setOnDropListener(OnDropListener dropListener) {
        this.mDropListener = dropListener;
    }

    public void setOnDragListener(OnDragListener dragListener) {
        this.mDragListener = dragListener;
    }

    /**
     * Start edit mode without starting drag;
     */
    public void startEditMode() {
        startEditMode(-1);
    }

    /**
     * Start edit mode with position. Useful for start edit mode in
     * {@link android.widget.AdapterView.OnItemClickListener}
     * or {@link android.widget.AdapterView.OnItemLongClickListener}
     */
    public void startEditMode(int position) {
        if (!mIsEditModeEnabled)
            return;
        requestDisallowInterceptTouchEvent(true);
        if (isPostHoneycomb() && mWobbleInEditMode)
            startWobbleAnimation();
        if (position != -1) {
            startDragAtPosition(position);
        }
        mIsEditMode = true;
        if (mEditModeChangeListener != null)
            mEditModeChangeListener.onEditModeChanged(true);
    }

    public void stopEditMode() {
        mIsEditMode = false;
        requestDisallowInterceptTouchEvent(false);
        if (isPostHoneycomb() && mWobbleInEditMode)
            stopWobble(true);
        if (mEditModeChangeListener != null)
            mEditModeChangeListener.onEditModeChanged(false);
    }

    public boolean isEditModeEnabled() {
        return mIsEditModeEnabled;
    }

    public void setEditModeEnabled(boolean enabled) {
        this.mIsEditModeEnabled = enabled;
    }

    public void setOnEditModeChangeListener(OnEditModeChangeListener editModeChangeListener) {
        this.mEditModeChangeListener = editModeChangeListener;
    }

    public boolean isEditMode() {
        return mIsEditMode;
    }

    public boolean isWobbleInEditMode() {
        return mWobbleInEditMode;
    }

    public void setWobbleInEditMode(boolean wobbleInEditMode) {
        this.mWobbleInEditMode = wobbleInEditMode;
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener l) {
        mOnItemClickListener = l;
        super.setOnItemClickListener(getItemClickHandler());
    }

    public boolean isUndoSupportEnabled() {
        return mUndoSupportEnabled;
    }

    public void setUndoSupportEnabled(boolean undoSupportEnabled) {
        if (this.mUndoSupportEnabled != undoSupportEnabled) {
            if (undoSupportEnabled) {
                this.mModificationStack = new Stack<DynamicGridModification>();
            } else {
                this.mModificationStack = null;
            }
        }

        this.mUndoSupportEnabled = undoSupportEnabled;
    }

    public void undoLastModification() {
        if (mUndoSupportEnabled) {
            if (mModificationStack != null && !mModificationStack.isEmpty()) {
                DynamicGridModification modification = mModificationStack.pop();
                undoModification(modification);
            }
        }
    }

    public void undoAllModifications() {
        if (mUndoSupportEnabled) {
            if (mModificationStack != null && !mModificationStack.isEmpty()) {
                while (!mModificationStack.isEmpty()) {
                    DynamicGridModification modification = mModificationStack.pop();
                    undoModification(modification);
                }
            }
        }
    }

    public boolean hasModificationHistory() {
        if (mUndoSupportEnabled) {
            if (mModificationStack != null && !mModificationStack.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void clearModificationHistory() {
        mModificationStack.clear();
    }

    public void setOnSelectedItemBitmapCreationListener(OnSelectedItemBitmapCreationListener selectedItemBitmapCreationListener) {
        this.mSelectedItemBitmapCreationListener = selectedItemBitmapCreationListener;
    }

    private void undoModification(DynamicGridModification modification) {
        for (Pair<Integer, Integer> transition : modification.getTransitions()) {
            reorderElements(transition.second, transition.first);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void startWobbleAnimation() {
        for (int i = 0; i < getChildCount(); i++) {
            View v = getChildAt(i);
            if (v != null && Boolean.TRUE != v.getTag(R.id.dgv_wobble_tag)) {
                if (i % 2 == 0)
                    animateWobble(v);
                else
                    animateWobbleInverse(v);
                v.setTag(R.id.dgv_wobble_tag, true);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void stopWobble(boolean resetRotation) {
        for (Animator wobbleAnimator : mWobbleAnimators) {
            wobbleAnimator.cancel();
        }
        mWobbleAnimators.clear();
        for (int i = 0; i < getChildCount(); i++) {
            View v = getChildAt(i);
            if (v != null) {
                if (resetRotation) v.setRotation(0);
                v.setTag(R.id.dgv_wobble_tag, false);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void restartWobble() {
        stopWobble(false);
        startWobbleAnimation();
    }

    public void init(Context context) {
        super.setOnScrollListener(mScrollListener);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        mSmoothScrollAmountAtEdge = (int) (SMOOTH_SCROLL_AMOUNT_AT_EDGE * metrics.density + 0.5f);
        mOverlapIfSwitchStraightLine = getResources().getDimensionPixelSize(R.dimen.dgv_overlap_if_switch_straight_line);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void animateWobble(View v) {
        ObjectAnimator animator = createBaseWobble(v);
        animator.setFloatValues(-2, 2);
        animator.start();
        mWobbleAnimators.add(animator);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void animateWobbleInverse(View v) {
        ObjectAnimator animator = createBaseWobble(v);
        animator.setFloatValues(2, -2);
        animator.start();
        mWobbleAnimators.add(animator);
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private ObjectAnimator createBaseWobble(final View v) {

        if (!isPreLollipop())
            v.setLayerType(LAYER_TYPE_SOFTWARE, null);

        ObjectAnimator animator = new ObjectAnimator();
        animator.setDuration(180);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setPropertyName("rotation");
        animator.setTarget(v);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                v.setLayerType(LAYER_TYPE_NONE, null);
            }
        });
        return animator;
    }


    private void reorderElements(int originalPosition, int targetPosition) {
        if (mDragListener != null)
            mDragListener.onDragPositionsChanged(originalPosition, targetPosition);
        getAdapterInterface().reorderItems(originalPosition, targetPosition);
    }

    private int getColumnCount() {
        return getAdapterInterface().getColumnCount();
    }

    private DynamicGridAdapterInterface getAdapterInterface() {
        return ((DynamicGridAdapterInterface) getAdapter());
    }

    /**
     * Creates the hover cell with the appropriate bitmap and of appropriate
     * size. The hover cell's BitmapDrawable is drawn on top of the bitmap every
     * single time an invalidate call is made.
     */
    private BitmapDrawable getAndAddHoverView(View v) {

        int w = v.getWidth();
        int h = v.getHeight();
        int top = v.getTop();
        int left = v.getLeft();

        Bitmap b = getBitmapFromView(v);

        BitmapDrawable drawable = new BitmapDrawable(getResources(), b);

        mHoverCellOriginalBounds = new Rect(left, top, left + w, top + h);
        mHoverCellCurrentBounds = new Rect(mHoverCellOriginalBounds);

        drawable.setBounds(mHoverCellCurrentBounds);

        return drawable;
    }

    /**
     * Returns a bitmap showing a screenshot of the view passed in.
     */
    private Bitmap getBitmapFromView(View v) {
        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        v.draw(canvas);
        return bitmap;
    }


    private void updateNeighborViewsForId(long itemId) {
        idList.clear();
        int draggedPos = getPositionForID(itemId);
        for (int pos = getFirstVisiblePosition(); pos <= getLastVisiblePosition(); pos++) {
            if (draggedPos != pos && getAdapterInterface().canReorder(pos)) {
                idList.add(getId(pos));
            }
        }
    }

    /**
     * Retrieves the position in the grid corresponding to <code>itemId</code>
     */
    public int getPositionForID(long itemId) {
        View v = getViewForId(itemId);
        if (v == null) {
            return -1;
        } else {
            return getPositionForView(v);
        }
    }

    public View getViewForId(long itemId) {
        int firstVisiblePosition = getFirstVisiblePosition();
        ListAdapter adapter = getAdapter();
        for (int i = 0; i < getChildCount(); i++) {
            View v = getChildAt(i);
            int position = firstVisiblePosition + i;
            long id = adapter.getItemId(position);
            if (id == itemId) {
                return v;
            }
        }
        return null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                mDownX = (int) event.getX();
                mDownY = (int) event.getY();
                mActivePointerId = event.getPointerId(0);
                if (mIsEditMode && isEnabled()) {
                    layoutChildren();
                    int position = pointToPosition(mDownX, mDownY);
                    startDragAtPosition(position);
                } else if (!isEnabled()) {
                    return false;
                }

                break;

            case MotionEvent.ACTION_MOVE:
                if (mActivePointerId == INVALID_ID) {
                    break;
                }

                int pointerIndex = event.findPointerIndex(mActivePointerId);

                mLastEventY = (int) event.getY(pointerIndex);
                mLastEventX = (int) event.getX(pointerIndex);
                int deltaY = mLastEventY - mDownY;
                int deltaX = mLastEventX - mDownX;

                if (mCellIsMobile) {
                    mHoverCellCurrentBounds.offsetTo(mHoverCellOriginalBounds.left + deltaX + mTotalOffsetX,
                            mHoverCellOriginalBounds.top + deltaY + mTotalOffsetY);
                    mHoverCell.setBounds(mHoverCellCurrentBounds);
                    invalidate();
                    handleCellSwitch();
                    mIsMobileScrolling = false;
                    handleMobileCellScroll();
                    return false;
                }
                break;

            case MotionEvent.ACTION_UP:
                touchEventsEnded();

                if (mUndoSupportEnabled) {
                    if (mCurrentModification != null && !mCurrentModification.getTransitions().isEmpty()) {
                        mModificationStack.push(mCurrentModification);
                        mCurrentModification = new DynamicGridModification();
                    }
                }

                if (mHoverCell != null) {
                    if (mDropListener != null) {
                        mDropListener.onActionDrop();
                    }
                }
                break;

            case MotionEvent.ACTION_CANCEL:
                touchEventsCancelled();

                if (mHoverCell != null) {
                    if (mDropListener != null) {
                        mDropListener.onActionDrop();
                    }
                }
                break;

            case MotionEvent.ACTION_POINTER_UP:
                /* If a multitouch event took place and the original touch dictating
                 * the movement of the hover cell has ended, then the dragging event
                 * ends and the hover cell is animated to its corresponding position
                 * in the listview. */
                pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                        MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                final int pointerId = event.getPointerId(pointerIndex);
                if (pointerId == mActivePointerId) {
                    touchEventsEnded();
                }
                break;

            default:
                break;
        }

        return super.onTouchEvent(event);
    }

    private void startDragAtPosition(int position) {
        mTotalOffsetY = 0;
        mTotalOffsetX = 0;
        int itemNum = position - getFirstVisiblePosition();
        View selectedView = getChildAt(itemNum);
        if (selectedView != null) {
            mMobileItemId = getAdapter().getItemId(position);
            if (mSelectedItemBitmapCreationListener != null)
                mSelectedItemBitmapCreationListener.onPreSelectedItemBitmapCreation(selectedView, position, mMobileItemId);
            mHoverCell = getAndAddHoverView(selectedView);
            if (mSelectedItemBitmapCreationListener != null)
                mSelectedItemBitmapCreationListener.onPostSelectedItemBitmapCreation(selectedView, position, mMobileItemId);
            if (isPostHoneycomb())
                selectedView.setVisibility(View.INVISIBLE);
            mCellIsMobile = true;
            updateNeighborViewsForId(mMobileItemId);
            if (mDragListener != null) {
                mDragListener.onDragStarted(position);
            }
        }
    }

    private void handleMobileCellScroll() {
        mIsMobileScrolling = handleMobileCellScroll(mHoverCellCurrentBounds);
    }

    public boolean handleMobileCellScroll(Rect r) {
        int offset = computeVerticalScrollOffset();
        int height = getHeight();
        int extent = computeVerticalScrollExtent();
        int range = computeVerticalScrollRange();
        int hoverViewTop = r.top;
        int hoverHeight = r.height();

        if (hoverViewTop <= 0 && offset > 0) {
            smoothScrollBy(-mSmoothScrollAmountAtEdge, 0);
            return true;
        }

        if (hoverViewTop + hoverHeight >= height && (offset + extent) < range) {
            smoothScrollBy(mSmoothScrollAmountAtEdge, 0);
            return true;
        }

        return false;
    }

   /* @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
    }*/

    private void touchEventsEnded() {
        final View mobileView = getViewForId(mMobileItemId);
        if (mobileView != null && (mCellIsMobile || mIsWaitingForScrollFinish)) {
            mCellIsMobile = false;
            mIsWaitingForScrollFinish = false;
            mIsMobileScrolling = false;
            mActivePointerId = INVALID_ID;

            // If the autoscroller has not completed scrolling, we need to wait for it to
            // finish in order to determine the final location of where the hover cell
            // should be animated to.
            if (mScrollState != OnScrollListener.SCROLL_STATE_IDLE) {
                mIsWaitingForScrollFinish = true;
                return;
            }

            mHoverCellCurrentBounds.offsetTo(mobileView.getLeft(), mobileView.getTop());

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
                animateBounds(mobileView);
            } else {
                mHoverCell.setBounds(mHoverCellCurrentBounds);
                invalidate();
                reset(mobileView);
            }
        } else {
            touchEventsCancelled();
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void animateBounds(final View mobileView) {
        TypeEvaluator<Rect> sBoundEvaluator = new TypeEvaluator<Rect>() {
            public Rect evaluate(float fraction, Rect startValue, Rect endValue) {
                return new Rect(interpolate(startValue.left, endValue.left, fraction),
                        interpolate(startValue.top, endValue.top, fraction),
                        interpolate(startValue.right, endValue.right, fraction),
                        interpolate(startValue.bottom, endValue.bottom, fraction));
            }

            public int interpolate(int start, int end, float fraction) {
                return (int) (start + fraction * (end - start));
            }
        };


        ObjectAnimator hoverViewAnimator = ObjectAnimator.ofObject(mHoverCell, "bounds",
                sBoundEvaluator, mHoverCellCurrentBounds);
        hoverViewAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                invalidate();
            }
        });
        hoverViewAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                mHoverAnimation = true;
                updateEnableState();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mHoverAnimation = false;
                updateEnableState();
                reset(mobileView);
            }
        });
        hoverViewAnimator.start();
    }

    private void reset(View mobileView) {
        idList.clear();
        mMobileItemId = INVALID_ID;
        mobileView.setVisibility(View.VISIBLE);
        mHoverCell = null;
        if (isPostHoneycomb() && mWobbleInEditMode) {
            if (mIsEditMode) {
                restartWobble();
            } else{
                stopWobble(true);
            }
        }
        //ugly fix for unclear disappearing items after reorder
        for (int i = 0; i < getLastVisiblePosition() - getFirstVisiblePosition(); i++) {
            View child = getChildAt(i);
            if (child != null) {
                child.setVisibility(View.VISIBLE);
            }
        }
        invalidate();
    }

    private void updateEnableState() {
        setEnabled(!mHoverAnimation && !mReorderAnimation);
    }

    /**
     * Seems that GridView before HONEYCOMB not support stable id in proper way.
     * That cause bugs on view recycle if we will animate or change visibility state for items.
     *
     * @return
     */
    private boolean isPostHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    /**
     * The GridView from Android Lollipoop requires some different
     * setVisibility() logic when switching cells.
     *
     * @return true if OS version is less than Lollipop, false if not
     */
    public static boolean isPreLollipop() {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP;
    }

    private void touchEventsCancelled() {
        View mobileView = getViewForId(mMobileItemId);
        if (mCellIsMobile) {
            reset(mobileView);
        }
        mCellIsMobile = false;
        mIsMobileScrolling = false;
        mActivePointerId = INVALID_ID;

    }

    private void handleCellSwitch() {
        final int deltaY = mLastEventY - mDownY;
        final int deltaX = mLastEventX - mDownX;
        final int deltaYTotal = mHoverCellOriginalBounds.centerY() + mTotalOffsetY + deltaY;
        final int deltaXTotal = mHoverCellOriginalBounds.centerX() + mTotalOffsetX + deltaX;
        mMobileView = getViewForId(mMobileItemId);
        View targetView = null;
        float vX = 0;
        float vY = 0;
        Point mobileColumnRowPair = getColumnAndRowForView(mMobileView);
        for (Long id : idList) {
            View view = getViewForId(id);
            if (view != null) {
                Point targetColumnRowPair = getColumnAndRowForView(view);
                if ((aboveRight(targetColumnRowPair, mobileColumnRowPair)
                        && deltaYTotal < view.getBottom() && deltaXTotal > view.getLeft()
                        || aboveLeft(targetColumnRowPair, mobileColumnRowPair)
                        && deltaYTotal < view.getBottom() && deltaXTotal < view.getRight()
                        || belowRight(targetColumnRowPair, mobileColumnRowPair)
                        && deltaYTotal > view.getTop() && deltaXTotal > view.getLeft()
                        || belowLeft(targetColumnRowPair, mobileColumnRowPair)
                        && deltaYTotal > view.getTop() && deltaXTotal < view.getRight()
                        || above(targetColumnRowPair, mobileColumnRowPair)
                        && deltaYTotal < view.getBottom() - mOverlapIfSwitchStraightLine
                        || below(targetColumnRowPair, mobileColumnRowPair)
                        && deltaYTotal > view.getTop() + mOverlapIfSwitchStraightLine
                        || right(targetColumnRowPair, mobileColumnRowPair)
                        && deltaXTotal > view.getLeft() + mOverlapIfSwitchStraightLine
                        || left(targetColumnRowPair, mobileColumnRowPair)
                        && deltaXTotal < view.getRight() - mOverlapIfSwitchStraightLine)) {
                    float xDiff = Math.abs(DynamicGridUtils.getViewX(view) - DynamicGridUtils.getViewX(mMobileView));
                    float yDiff = Math.abs(DynamicGridUtils.getViewY(view) - DynamicGridUtils.getViewY(mMobileView));
                    if (xDiff >= vX && yDiff >= vY) {
                        vX = xDiff;
                        vY = yDiff;
                        targetView = view;
                    }
                }
            }
        }
        if (targetView != null) {
            final int originalPosition = getPositionForView(mMobileView);
            int targetPosition = getPositionForView(targetView);

            final DynamicGridAdapterInterface adapter = getAdapterInterface();
            if (targetPosition == INVALID_POSITION || !adapter.canReorder(originalPosition) || !adapter.canReorder(targetPosition)) {
                updateNeighborViewsForId(mMobileItemId);
                return;
            }
            reorderElements(originalPosition, targetPosition);

            if (mUndoSupportEnabled) {
                mCurrentModification.addTransition(originalPosition, targetPosition);
            }

            mDownY = mLastEventY;
            mDownX = mLastEventX;

            SwitchCellAnimator switchCellAnimator;

            if (isPostHoneycomb() && isPreLollipop())   //Between Android 3.0 and Android L
                switchCellAnimator = new KitKatSwitchCellAnimator(deltaX, deltaY);
            else if (isPreLollipop())                   //Before Android 3.0
                switchCellAnimator = new PreHoneycombCellAnimator(deltaX, deltaY);
            else                                //Android L
                switchCellAnimator = new LSwitchCellAnimator(deltaX, deltaY);

            updateNeighborViewsForId(mMobileItemId);

            switchCellAnimator.animateSwitchCell(originalPosition, targetPosition);
        }
    }

    private interface SwitchCellAnimator {
        void animateSwitchCell(final int originalPosition, final int targetPosition);
    }

    private class PreHoneycombCellAnimator implements SwitchCellAnimator {
        private int mDeltaY;
        private int mDeltaX;

        public PreHoneycombCellAnimator(int deltaX, int deltaY) {
            mDeltaX = deltaX;
            mDeltaY = deltaY;
        }

        @Override
        public void animateSwitchCell(int originalPosition, int targetPosition) {
            mTotalOffsetY += mDeltaY;
            mTotalOffsetX += mDeltaX;
        }
    }

    /**
     * A {@link org.askerov.dynamicgrid.DynamicGridView.SwitchCellAnimator} for versions KitKat and below.
     */
    private class KitKatSwitchCellAnimator implements SwitchCellAnimator {

        private int mDeltaY;
        private int mDeltaX;

        public KitKatSwitchCellAnimator(int deltaX, int deltaY) {
            mDeltaX = deltaX;
            mDeltaY = deltaY;
        }

        @Override
        public void animateSwitchCell(final int originalPosition, final int targetPosition) {
            assert mMobileView != null;
            getViewTreeObserver().addOnPreDrawListener(new AnimateSwitchViewOnPreDrawListener(mMobileView, originalPosition, targetPosition));
            mMobileView = getViewForId(mMobileItemId);
        }

        private class AnimateSwitchViewOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {

            private final View mPreviousMobileView;
            private final int mOriginalPosition;
            private final int mTargetPosition;

            AnimateSwitchViewOnPreDrawListener(final View previousMobileView, final int originalPosition, final int targetPosition) {
                mPreviousMobileView = previousMobileView;
                mOriginalPosition = originalPosition;
                mTargetPosition = targetPosition;
            }

            @Override
            public boolean onPreDraw() {
                getViewTreeObserver().removeOnPreDrawListener(this);

                mTotalOffsetY += mDeltaY;
                mTotalOffsetX += mDeltaX;

                animateReorder(mOriginalPosition, mTargetPosition);

                mPreviousMobileView.setVisibility(View.VISIBLE);

                if (mMobileView != null) {
                    mMobileView.setVisibility(View.INVISIBLE);
                }
                return true;
            }
        }
    }

    /**
     * A {@link org.askerov.dynamicgrid.DynamicGridView.SwitchCellAnimator} for versions L and above.
     */
    private class LSwitchCellAnimator implements SwitchCellAnimator {

        private int mDeltaY;
        private int mDeltaX;

        public LSwitchCellAnimator(int deltaX, int deltaY) {
            mDeltaX = deltaX;
            mDeltaY = deltaY;
        }

        @Override
        public void animateSwitchCell(final int originalPosition, final int targetPosition) {
            getViewTreeObserver().addOnPreDrawListener(new AnimateSwitchViewOnPreDrawListener(originalPosition, targetPosition));
        }

        private class AnimateSwitchViewOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
            private final int mOriginalPosition;
            private final int mTargetPosition;

            AnimateSwitchViewOnPreDrawListener(final int originalPosition, final int targetPosition) {
                mOriginalPosition = originalPosition;
                mTargetPosition = targetPosition;
            }

            @Override
            public boolean onPreDraw() {
                getViewTreeObserver().removeOnPreDrawListener(this);

                mTotalOffsetY += mDeltaY;
                mTotalOffsetX += mDeltaX;

                animateReorder(mOriginalPosition, mTargetPosition);

                assert mMobileView != null;
                mMobileView.setVisibility(View.VISIBLE);
                mMobileView = getViewForId(mMobileItemId);
                assert mMobileView != null;
                mMobileView.setVisibility(View.INVISIBLE);
                return true;
            }
        }
    }

    private boolean belowLeft(Point targetColumnRowPair, Point mobileColumnRowPair) {
        return targetColumnRowPair.y > mobileColumnRowPair.y && targetColumnRowPair.x < mobileColumnRowPair.x;
    }

    private boolean belowRight(Point targetColumnRowPair, Point mobileColumnRowPair) {
        return targetColumnRowPair.y > mobileColumnRowPair.y && targetColumnRowPair.x > mobileColumnRowPair.x;
    }

    private boolean aboveLeft(Point targetColumnRowPair, Point mobileColumnRowPair) {
        return targetColumnRowPair.y < mobileColumnRowPair.y && targetColumnRowPair.x < mobileColumnRowPair.x;
    }

    private boolean aboveRight(Point targetColumnRowPair, Point mobileColumnRowPair) {
        return targetColumnRowPair.y < mobileColumnRowPair.y && targetColumnRowPair.x > mobileColumnRowPair.x;
    }

    private boolean above(Point targetColumnRowPair, Point mobileColumnRowPair) {
        return targetColumnRowPair.y < mobileColumnRowPair.y && targetColumnRowPair.x == mobileColumnRowPair.x;
    }

    private boolean below(Point targetColumnRowPair, Point mobileColumnRowPair) {
        return targetColumnRowPair.y > mobileColumnRowPair.y && targetColumnRowPair.x == mobileColumnRowPair.x;
    }

    private boolean right(Point targetColumnRowPair, Point mobileColumnRowPair) {
        return targetColumnRowPair.y == mobileColumnRowPair.y && targetColumnRowPair.x > mobileColumnRowPair.x;
    }

    private boolean left(Point targetColumnRowPair, Point mobileColumnRowPair) {
        return targetColumnRowPair.y == mobileColumnRowPair.y && targetColumnRowPair.x < mobileColumnRowPair.x;
    }

    private Point getColumnAndRowForView(View view) {
        int pos = getPositionForView(view);
        int columns = getColumnCount();
        int column = pos % columns;
        int row = pos / columns;
        return new Point(column, row);
    }

    private long getId(int position) {
        return getAdapter().getItemId(position);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void animateReorder(final int oldPosition, final int newPosition) {
        boolean isForward = newPosition > oldPosition;
        List<Animator> resultList = new LinkedList<Animator>();
        if (isForward) {
            for (int pos = Math.min(oldPosition, newPosition); pos < Math.max(oldPosition, newPosition); pos++) {
                View view = getViewForId(getId(pos));
                if ((pos + 1) % getColumnCount() == 0) {
                    resultList.add(createTranslationAnimations(view, -view.getWidth() * (getColumnCount() - 1), 0,
                            view.getHeight(), 0));
                } else {
                    resultList.add(createTranslationAnimations(view, view.getWidth(), 0, 0, 0));
                }
            }
        } else {
            for (int pos = Math.max(oldPosition, newPosition); pos > Math.min(oldPosition, newPosition); pos--) {
                View view = getViewForId(getId(pos));
                if ((pos + getColumnCount()) % getColumnCount() == 0) {
                    resultList.add(createTranslationAnimations(view, view.getWidth() * (getColumnCount() - 1), 0,
                            -view.getHeight(), 0));
                } else {
                    resultList.add(createTranslationAnimations(view, -view.getWidth(), 0, 0, 0));
                }
            }
        }

        AnimatorSet resultSet = new AnimatorSet();
        resultSet.playTogether(resultList);
        resultSet.setDuration(MOVE_DURATION);
        resultSet.setInterpolator(new AccelerateDecelerateInterpolator());
        resultSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                mReorderAnimation = true;
                updateEnableState();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mReorderAnimation = false;
                updateEnableState();
            }
        });
        resultSet.start();
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private AnimatorSet createTranslationAnimations(View view, float startX, float endX, float startY, float endY) {
        ObjectAnimator animX = ObjectAnimator.ofFloat(view, "translationX", startX, endX);
        ObjectAnimator animY = ObjectAnimator.ofFloat(view, "translationY", startY, endY);
        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.playTogether(animX, animY);
        return animSetXY;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (mHoverCell != null) {
            mHoverCell.draw(canvas);
        }
    }


    public interface OnDropListener {
        void onActionDrop();
    }

    public interface OnDragListener {

        public void onDragStarted(int position);

        public void onDragPositionsChanged(int oldPosition, int newPosition);
    }

    public interface OnEditModeChangeListener {
        public void onEditModeChanged(boolean inEditMode);
    }

    public interface OnSelectedItemBitmapCreationListener {
        public void onPreSelectedItemBitmapCreation(View selectedView, int position, long itemId);

        public void onPostSelectedItemBitmapCreation(View selectedView, int position, long itemId);
    }


    /**
     * This scroll listener is added to the gridview in order to handle cell swapping
     * when the cell is either at the top or bottom edge of the gridview. If the hover
     * cell is at either edge of the gridview, the gridview will begin scrolling. As
     * scrolling takes place, the gridview continuously checks if new cells became visible
     * and determines whether they are potential candidates for a cell swap.
     */
    private OnScrollListener mScrollListener = new OnScrollListener() {

        private int mPreviousFirstVisibleItem = -1;
        private int mPreviousVisibleItemCount = -1;
        private int mCurrentFirstVisibleItem;
        private int mCurrentVisibleItemCount;
        private int mCurrentScrollState;

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                             int totalItemCount) {
            mCurrentFirstVisibleItem = firstVisibleItem;
            mCurrentVisibleItemCount = visibleItemCount;

            mPreviousFirstVisibleItem = (mPreviousFirstVisibleItem == -1) ? mCurrentFirstVisibleItem
                    : mPreviousFirstVisibleItem;
            mPreviousVisibleItemCount = (mPreviousVisibleItemCount == -1) ? mCurrentVisibleItemCount
                    : mPreviousVisibleItemCount;

            checkAndHandleFirstVisibleCellChange();
            checkAndHandleLastVisibleCellChange();

            mPreviousFirstVisibleItem = mCurrentFirstVisibleItem;
            mPreviousVisibleItemCount = mCurrentVisibleItemCount;
            if (isPostHoneycomb() && mWobbleInEditMode) {
                updateWobbleState(visibleItemCount);
            }
            if (mUserScrollListener != null) {
                mUserScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
        }

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        private void updateWobbleState(int visibleItemCount) {
            for (int i = 0; i < visibleItemCount; i++) {
                View child = getChildAt(i);

                if (child != null) {
                    if (mMobileItemId != INVALID_ID && Boolean.TRUE != child.getTag(R.id.dgv_wobble_tag)) {
                        if (i % 2 == 0)
                            animateWobble(child);
                        else
                            animateWobbleInverse(child);
                        child.setTag(R.id.dgv_wobble_tag, true);
                    } else if (mMobileItemId == INVALID_ID && child.getRotation() != 0) {
                        child.setRotation(0);
                        child.setTag(R.id.dgv_wobble_tag, false);
                    }
                }

            }
        }

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            mCurrentScrollState = scrollState;
            mScrollState = scrollState;
            isScrollCompleted();
            if (mUserScrollListener != null) {
                mUserScrollListener.onScrollStateChanged(view, scrollState);
            }
        }

        /**
         * This method is in charge of invoking 1 of 2 actions. Firstly, if the gridview
         * is in a state of scrolling invoked by the hover cell being outside the bounds
         * of the gridview, then this scrolling event is continued. Secondly, if the hover
         * cell has already been released, this invokes the animation for the hover cell
         * to return to its correct position after the gridview has entered an idle scroll
         * state.
         */
        private void isScrollCompleted() {
            if (mCurrentVisibleItemCount > 0 && mCurrentScrollState == SCROLL_STATE_IDLE) {
                if (mCellIsMobile && mIsMobileScrolling) {
                    handleMobileCellScroll();
                } else if (mIsWaitingForScrollFinish) {
                    touchEventsEnded();
                }
            }
        }

        /**
         * Determines if the gridview scrolled up enough to reveal a new cell at the
         * top of the list. If so, then the appropriate parameters are updated.
         */
        public void checkAndHandleFirstVisibleCellChange() {
            if (mCurrentFirstVisibleItem != mPreviousFirstVisibleItem) {
                if (mCellIsMobile && mMobileItemId != INVALID_ID) {
                    updateNeighborViewsForId(mMobileItemId);
                    handleCellSwitch();
                }
            }
        }

        /**
         * Determines if the gridview scrolled down enough to reveal a new cell at the
         * bottom of the list. If so, then the appropriate parameters are updated.
         */
        public void checkAndHandleLastVisibleCellChange() {
            int currentLastVisibleItem = mCurrentFirstVisibleItem + mCurrentVisibleItemCount;
            int previousLastVisibleItem = mPreviousFirstVisibleItem + mPreviousVisibleItemCount;
            if (currentLastVisibleItem != previousLastVisibleItem) {
                if (mCellIsMobile && mMobileItemId != INVALID_ID) {
                    updateNeighborViewsForId(mMobileItemId);
                    handleCellSwitch();
                }
            }
        }
    };

    private static class DynamicGridModification {

        private List<Pair<Integer, Integer>> transitions;

        DynamicGridModification() {
            super();
            this.transitions = new Stack<Pair<Integer, Integer>>();
        }

        public boolean hasTransitions() {
            return !transitions.isEmpty();
        }

        public void addTransition(int oldPosition, int newPosition) {
            transitions.add(new Pair<Integer, Integer>(oldPosition, newPosition));
        }

        public List<Pair<Integer, Integer>> getTransitions() {
            Collections.reverse(transitions);
            return transitions;
        }
    }
}

