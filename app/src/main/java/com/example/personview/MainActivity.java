package com.example.personview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.personview.base.BaseActivity;
import com.example.personview.impl.ActionBarClickListener;
import com.example.personview.widget.TranslucentActionBar;
import com.example.personview.widget.TranslucentScrollView;


/**
 * Created by Administrator
 * time:2019/8/13
 */

public class MainActivity extends BaseActivity implements ActionBarClickListener, TranslucentScrollView.TranslucentChangedListener, View.OnClickListener {

    private TranslucentScrollView translucentScrollView;
    private TranslucentActionBar actionBar;
    private View zoomView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initClick();//初始化点击事件
    }

    private void init() {
        actionBar = (TranslucentActionBar) findViewById(R.id.actionbar);
        //初始actionBar
        actionBar.setData("个人中心", 0, null, 0, null, null);
        //开启渐变
        actionBar.setNeedTranslucent();
        //设置状态栏高度
        actionBar.setStatusBarHeight(getStatusBarHeight());

        translucentScrollView = (TranslucentScrollView) findViewById(R.id.pullzoom_scrollview);
        //设置透明度变化监听
        translucentScrollView.setTranslucentChangedListener(this);
        //关联需要渐变的视图
        translucentScrollView.setTransView(actionBar);

        zoomView = findViewById(R.id.lay_header);
        //关联伸缩的视图
        translucentScrollView.setPullZoomView(zoomView);
    }

    @Override
    public void onLeftClick() {

    }

    @Override
    public void onRightClick() {

    }

    @Override
    public void onTranslucentChanged(int transAlpha) {
        actionBar.tvTitle.setVisibility(transAlpha > 48 ? View.VISIBLE : View.GONE);
    }

    /**
     * 初始化点击事件
     * 获取布局文件toast_signtoday.xml里的控件
     **/
    private void initClick() {
        LinearLayout person_sign = (LinearLayout) findViewById(R.id.person_sign);
        person_sign.setOnClickListener(this);
        LinearLayout person_footprint = (LinearLayout) findViewById(R.id.person_footprint);
        person_footprint.setOnClickListener(this);
        LinearLayout person_publish = (LinearLayout) findViewById(R.id.person_publish);
        person_publish.setOnClickListener(this);
        LinearLayout person_photowall = (LinearLayout) findViewById(R.id.person_photowall);
        person_photowall.setOnClickListener(this);
        LinearLayout person_lucky = (LinearLayout) findViewById(R.id.person_lucky);
        person_lucky.setOnClickListener(this);
        LinearLayout person_invite = (LinearLayout) findViewById(R.id.person_invite);
        person_invite.setOnClickListener(this);
        LinearLayout person_set = (LinearLayout) findViewById(R.id.person_set);
        person_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.person_sign:
                //签到
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.activity_toast_signtoday, null);
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
                break;
            case R.id.person_footprint:
                //足迹
                Toast.makeText(this,"足迹",Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_publish:
                //我发布的
                Toast.makeText(this,"我发布的",Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_photowall:
                //照片墙
                Toast.makeText(this,"照片墙",Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_lucky:
                //开始抽奖
                Toast.makeText(this,"开始抽奖",Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_invite:
                //邀请奖励
                Toast.makeText(this,"邀请奖励",Toast.LENGTH_SHORT).show();
                break;
            case R.id.person_set:
                //设置
                Toast.makeText(this,"设置",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
