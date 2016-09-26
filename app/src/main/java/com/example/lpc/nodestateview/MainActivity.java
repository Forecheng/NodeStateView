package com.example.lpc.nodestateview;


import android.os.Bundle;

import com.example.nodestatelibrary.NodeStateView;

public class MainActivity extends BaseActivity {

    private NodeStateView stateView1;
    private NodeStateView stateView2;
    private NodeStateView stateView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initViews() {
        setContentView(R.layout.activity_main);
        stateView1 = (NodeStateView) findViewById(R.id.nodeState1);
        stateView2 = (NodeStateView) findViewById(R.id.nodeState2);
        stateView3 = (NodeStateView) findViewById(R.id.nodeState3);

    }

    @Override
    public void loadData() {

        stateView1.setNodeProgressByStatus(1);

        stateView2.setNodeProgressByStatus(3);
        stateView2.setUpBackgroundColor(this,R.color.nice_color);

        stateView3.setNodeProgressByStatus(4);
        stateView3.setDownBackgroundColor(this,R.color.nice_color);
        stateView3.setUpBackgroundColor(this,R.color.colorAccent);

    }

    @Override
    public void initVariable() {

    }
}
