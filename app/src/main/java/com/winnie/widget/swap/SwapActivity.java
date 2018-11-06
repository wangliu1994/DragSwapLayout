package com.winnie.widget.swap;

import android.os.Bundle;

import com.winnie.widget.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author winnie
 */
public class SwapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_title)
    public void onViewClicked() {
        finish();
    }
}
