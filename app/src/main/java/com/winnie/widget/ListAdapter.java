package com.winnie.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author : winnie
 * @date : 2018/10/22
 * @desc
 */
public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements ItemTouchHelperAdapter{
    /**
     * 上下文
     */
    private Context mContext;

    /**
     * 选中的item
     */
    private int mSelectedPos = -1;

    /**
     * 数据
     */
    private List<String> mData;

    public ListAdapter(Context context) {
        mContext = context;
        mData = new ArrayList<>();
        for(int i=0; i<= 20; i++){
            mData.add("Item Data" + i);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_list_item, parent, false);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String data = mData.get(position);
        if(holder instanceof ViewHolder){
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.mTvText.setText(data);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mData, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        if(mData.size() > position) {
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private View mItemView;

        TextView mTvText;
        ImageView mIvDel;
        TextView mTvDel;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            mTvText = mItemView.findViewById(R.id.tv_text);
            mIvDel = mItemView.findViewById(R.id.iv_del_img);
            mTvDel = mItemView.findViewById(R.id.tv_del_text);
        }
    }
}
