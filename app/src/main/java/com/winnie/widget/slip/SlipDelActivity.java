package com.winnie.widget.slip;

import android.os.Bundle;

import com.winnie.widget.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author winnie
 */
public class SlipDelActivity extends AppCompatActivity {

    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private LinearLayoutManager mLayoutManager;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slip_del);
        ButterKnife.bind(this);

        initRecyclerView();
    }

    private void initRecyclerView(){
        mLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        mAdapter = new ListAdapter(this);

        mRvList.setLayoutManager(mLayoutManager);
        mRvList.setAdapter(mAdapter);

        //添加Android自带的分割线
        mRvList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //先实例化Callback
        ItemTouchHelper.Callback callback = new ItemTouchHelperCallbackImpl(mAdapter);
        //用Callback构造ItemTouchHelper
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        //调用ItemTouchHelper的attachToRecyclerView方法建立联系
        touchHelper.attachToRecyclerView(mRvList);
    }
}
