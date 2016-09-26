package com.example.lpc.nodestateview;

import android.app.Activity;
import android.os.Bundle;

/**
 * Description:
 * Created by lpc on 2016/9/26.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initViews();
        initVariable();
        loadData();
    }

    public abstract void initViews();
    public abstract void loadData();
    public abstract void initVariable();
}
