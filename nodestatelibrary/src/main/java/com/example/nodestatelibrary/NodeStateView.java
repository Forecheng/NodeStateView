package com.example.nodestatelibrary;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lpc.nodestatelibrary.R;


/**
 * Description:
 * Created by L02465 on 2016/7/20.
 */
public class NodeStateView extends RelativeLayout {

    /**
     * 四个节点
     */
    private ImageView mImageFirstNode;
    private ImageView mImageSecondNode;
    private ImageView mImageThirdNode;
    private ImageView mImageFourNode;

    /**
     * 节点进度的文本
     */
    private TextView mTextCurrentStatus;

    /**
     * 下面的四个文本
     */
    private TextView mTextFirstNode;
    private TextView mTextSecondNode;
    private TextView mTextThirdNode;
    private TextView mTextFourNode;

    private LayoutInflater mInflater;

    private RelativeLayout mRelativeDown;
    private View mViewUp;

    public NodeStateView(Context context) {
        this(context, null);
    }

    public NodeStateView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NodeStateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);


        View view = mInflater.inflate(R.layout.nodestate_layout, this);
        mImageFirstNode = (ImageView) view.findViewById(R.id.firstNode);
        mImageSecondNode = (ImageView) view.findViewById(R.id.secondNode);
        mImageThirdNode = (ImageView) view.findViewById(R.id.thirdNode);
        mImageFourNode = (ImageView) view.findViewById(R.id.fourNode);
        mTextFirstNode = (TextView) view.findViewById(R.id.firstNodeText);
        mTextSecondNode = (TextView) view.findViewById(R.id.secondNodeText);
        mTextThirdNode = (TextView) view.findViewById(R.id.thirdNodeText);
        mTextFourNode = (TextView) view.findViewById(R.id.fourNodeText);
        mTextCurrentStatus = (TextView) view.findViewById(R.id.current_maintain_status);

        mRelativeDown = (RelativeLayout) view.findViewById(R.id.down);
        mViewUp =  view.findViewById(R.id.up);

    }

    public void setCurrentMaintainStatus(String status) {
        mTextCurrentStatus.setText(status);
    }

    public void setFirstNodeText(String text){
        mTextFirstNode.setText(text);
    }

    public void setSecondNodeText(String text){
        mTextSecondNode.setText(text);
    }

    public void setThirdNodeText(String text){
        mTextThirdNode.setText(text);
    }

    public void setFourNodeText(String text){
        mTextFourNode.setText(text);
    }

    public void setCurrentMaintainStatus(int intValue) {
        mTextCurrentStatus.setText(intValue);
    }

    public void setFirstNodeBg(int drawable) {
        mImageFirstNode.setImageResource(drawable);
    }

    public void setSecondNodeBg(int resId) {
        mImageSecondNode.setImageResource(resId);
    }

    public void setThirdNodeBg(int resId) {
        mImageThirdNode.setImageResource(resId);
    }

    public void setFourNodeBg(int resId) {
        mImageFourNode.setImageResource(resId);
    }

    public void setFirstNodeTextVisible(int isVisible) {
        mTextFirstNode.setVisibility(isVisible);
    }

    public void setSecondTextVisible(int isVisible) {
        mTextSecondNode.setVisibility(isVisible);
    }

    public void setThirdTextVisible(int isVisible) {
        mTextThirdNode.setVisibility(isVisible);
    }

    public void setFourTextVisible(int isVisible) {
        mTextFourNode.setVisibility(isVisible);
    }

    public void setNodeRightLineHide(int nodeIndex) {
        switch (nodeIndex) {
            case 1:     //将第一个节点右边的线从蓝色变为白色，下同
                mTextFirstNode.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.tip_line_w),null,getResources().getDrawable(R.drawable.tip_line_w),null);
                break;
            case 2:
                mTextSecondNode.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.tip_line_b),null,getResources().getDrawable(R.drawable.tip_line_w),null);
                break;
            case 3:
                mTextThirdNode.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.tip_line_b),null,getResources().getDrawable(R.drawable.tip_line_w),null);
                break;
            case 4:
                mTextFourNode.setCompoundDrawablesRelativeWithIntrinsicBounds(getResources().getDrawable(R.drawable.tip_line_b),null,getResources().getDrawable(R.drawable.tip_line_w),null);
                break;
            default:
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setUpBackgroundColor(Context context, int resId){
        Drawable drawable = context.getDrawable(resId) ;
        mViewUp.setBackground(drawable);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setDownBackgroundColor(Context context, int resId){
        Drawable drawable = context.getDrawable(resId) ;
        mRelativeDown.setBackground(drawable);
    }

    public void firstNodeReported(){
        mImageFirstNode.setImageResource(R.drawable.blue_ball);
        mTextFirstNode.setVisibility(View.VISIBLE);
        mTextCurrentStatus.setText(mTextFirstNode.getText().toString());
    }

    public void secondNodeConfirmed(){
        mImageSecondNode.setImageResource(R.drawable.blue_ball);
        mTextSecondNode.setVisibility(View.VISIBLE);
        mTextCurrentStatus.setText(mTextSecondNode.getText().toString());
    }

    public void thirdNodeMaintain(){
        mImageThirdNode.setImageResource(R.drawable.blue_ball);
        mTextThirdNode.setVisibility(View.VISIBLE);
        mTextCurrentStatus.setText(mTextThirdNode.getText().toString());
    }

    public void fourNodeFinish(){
        mImageFourNode.setImageResource(R.drawable.blue_ball);
        mTextFourNode.setVisibility(View.VISIBLE);
        mTextCurrentStatus.setText(mTextFourNode.getText().toString());
    }

    //根据维护状态更新维护进度
    public void setNodeProgressByStatus(int nodeIndex){
        switch (nodeIndex){
            //已上报
            case 1:
                firstNodeReported();
                setNodeRightLineHide(nodeIndex);
                break;
            //已确定
            case 2:
                firstNodeReported();
                secondNodeConfirmed();
                setNodeRightLineHide(nodeIndex);
                break;
            //维护中
            case 3:
                firstNodeReported();
                secondNodeConfirmed();
                thirdNodeMaintain();
                setNodeRightLineHide(nodeIndex);
                break;
            case 4:
                firstNodeReported();
                secondNodeConfirmed();
                thirdNodeMaintain();
                fourNodeFinish();
                setNodeRightLineHide(nodeIndex);
                break;

        }
    }

}
