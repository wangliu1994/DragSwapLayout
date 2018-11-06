package com.winnie.widget;

import android.content.Intent;
import android.os.Bundle;

import com.winnie.widget.drag.DragDelActivity;
import com.winnie.widget.slip.SlipDelActivity;
import com.winnie.widget.swap.SwapActivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author winnie
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.slip_del_button)
    public void onSlipClicked() {
        startActivity(new Intent(this, SlipDelActivity.class));
    }

    @OnClick(R.id.drag_del_button)
    public void onDragClicked() {
        startActivity(new Intent(this, DragDelActivity.class));
    }

    @OnClick(R.id.slip_swap_button)
    public void onSwapClicked() {
        startActivity(new Intent(this, SwapActivity.class));
    }
}
