package com.winnie.widget.drag;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.winnie.widget.R;
import com.winnie.widget.ScreenUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author winnie
 */
public class DragDelActivity extends AppCompatActivity implements ItemTouchCallBack {
    @BindView(R.id.rv_video_list)
    RecyclerView mRvVideoList;

    /**
     * 移除窗口提示
     */
    private ImageView mDelImage;

    private GridLayoutManager mLayoutManager;
    private VideoAdapter mAdapter;

    /**
     * 每行的item个数
     */
    private int mColumnCount = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_del);
        ButterKnife.bind(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mLayoutManager = new GridLayoutManager(this, mColumnCount);
        mAdapter = new VideoAdapter(this);

        mRvVideoList.setLayoutManager(mLayoutManager);
        mRvVideoList.setAdapter(mAdapter);

        //先实例化Callback
        ItemTouchHelper.Callback callback = new ItemTouchHelperCallbackImpl(this, mColumnCount);
        //用Callback构造ItemTouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mRvVideoList);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (mAdapter != null) {
            mAdapter.onItemSwap(fromPosition, toPosition);
        }
    }

    @Override
    public void onItemRemove(int position) {
        if (mAdapter != null) {
            mAdapter.onItemRemove(position);
        }
    }

    @Override
    public void onItemCanDelete() {
        initDelImageView();
        mDelImage.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        mDelImage.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemDropTop() {
        initDelImageView();
        mDelImage.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mDelImage.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemReset() {
        mDelImage.setVisibility(View.GONE);
    }

    /**
     * 创建删除图标
     */
    private void initDelImageView() {
        int statusBarHeight = ScreenUtils.getStatusBarHeight();
        int tabLayoutHeight = ScreenUtils.dp2px(48);
        if (mDelImage == null) {
            mDelImage = new ImageView(this);
            FrameLayout decorView = (FrameLayout) getWindow().getDecorView();

            mDelImage.setImageResource(R.drawable.vector_drawable_del);
            mDelImage.setScaleType(ImageView.ScaleType.CENTER);

            FrameLayout.LayoutParams params;
            params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    statusBarHeight + tabLayoutHeight);
            mDelImage.setPadding(0, statusBarHeight, 0, 0);
            decorView.addView(mDelImage, params);
        }
    }

    @OnClick(R.id.tv_title)
    public void onViewClicked() {
        finish();
    }
}
