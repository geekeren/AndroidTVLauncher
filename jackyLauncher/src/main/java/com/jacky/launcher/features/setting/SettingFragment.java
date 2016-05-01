
package com.jacky.launcher.features.setting;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.jacky.uikit.fragment.BaseFragment;
import com.jacky.launcher.R;
import com.jacky.launcher.features.app.AppAutoRun;
import com.jacky.launcher.features.app.AppUninstall;
import com.jacky.launcher.features.eliminateprocess.EliminateMainActivity;
import com.jacky.launcher.features.garbageclear.GarbageClear;
import com.jacky.launcher.features.speedtest.SpeedTestActivity;

import java.util.List;

/**
 * Created by Administrator on 2014/9/9.
 */
public class SettingFragment extends BaseFragment implements
        View.OnClickListener {
    private ImageButton Setting_Clean;// 垃圾清理
    private ImageButton Setting_Accelerate;// 一键加速
    private ImageButton appUninstall;
    private ImageButton setNet;
    private ImageButton setMore;
    private ImageButton netSpeed;
    private ImageButton sysUpdate;
    private ImageButton fileManage;
    private ImageButton about;
    private ImageButton autoRun;
    private View view;// 视图
    private Intent JumpIntent;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this.getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(
                R.layout.fragment_setting, null);
        initView(view);
        setListener();
        // Bundle bundle = this.getArguments();
        // String data = bundle.getString("url_data");
        // UIResponseParam uiResponseParam = null;
        // try {
        // uiResponseParam = new UIResponseParam(data);
        // datas = uiResponseParam.getUIInfo();
        // showImages();
        // } catch (JSONException e) {
        // e.printStackTrace();
        // }
        return view;
    }

    private void initView(View view) {

        // FocusedRelativeLayout focus = (FocusedRelativeLayout) view
        // .findViewById(R.id.setting_focus_rl);
        // focus.setFocusResId(R.drawable.focus_bg);
        // focus.setFocusShadowResId(R.drawable.focus_shadow);
        // focus.setFocusable(true);
        // focus.setFocusableInTouchMode(true);
        // focus.requestFocus();
        // focus.requestFocusFromTouch();

        appUninstall = (ImageButton) view.findViewById(R.id.setting_uninstall);
        setNet = (ImageButton) view.findViewById(R.id.setting_net);
        setMore = (ImageButton) view.findViewById(R.id.setting_more);
        netSpeed = (ImageButton) view.findViewById(R.id.setting_net_speed);
        sysUpdate = (ImageButton) view.findViewById(R.id.setting_update);
        fileManage = (ImageButton) view.findViewById(R.id.setting_file);
        about = (ImageButton) view.findViewById(R.id.setting_about);
        Setting_Clean = (ImageButton) view.findViewById(R.id.setting_clean);
        Setting_Accelerate = (ImageButton) view.findViewById(R.id.setting_accelerate);
        autoRun = (ImageButton) view.findViewById(R.id.setting_autorun);

        appUninstall.setOnFocusChangeListener(mFocusChangeListener);
        setNet.setOnFocusChangeListener(mFocusChangeListener);
        setMore.setOnFocusChangeListener(mFocusChangeListener);
        netSpeed.setOnFocusChangeListener(mFocusChangeListener);
        sysUpdate.setOnFocusChangeListener(mFocusChangeListener);
        fileManage.setOnFocusChangeListener(mFocusChangeListener);
        about.setOnFocusChangeListener(mFocusChangeListener);
        Setting_Clean.setOnFocusChangeListener(mFocusChangeListener);
        Setting_Accelerate.setOnFocusChangeListener(mFocusChangeListener);
        autoRun.setOnFocusChangeListener(mFocusChangeListener);

    }

    private void setListener() {
        Setting_Clean.setOnClickListener(this);
        Setting_Accelerate.setOnClickListener(this);
        about.setOnClickListener(this);
        setMore.setOnClickListener(this);
        appUninstall.setOnClickListener(this);
        setNet.setOnClickListener(this);
        fileManage.setOnClickListener(this);
        netSpeed.setOnClickListener(this);
        sysUpdate.setOnClickListener(this);
        autoRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting_clean:
                JumpIntent = new Intent(context, GarbageClear.class);
                startActivity(JumpIntent);
                break;
            case R.id.setting_accelerate:
                JumpIntent = new Intent(context, EliminateMainActivity.class);
                startActivity(JumpIntent);
                break;
            case R.id.setting_about:
                break;
            case R.id.setting_more:
                try {
                    JumpIntent = new Intent(Settings.ACTION_SETTINGS);
                    startActivity(JumpIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.setting_file:
                break;
            case R.id.setting_update:
                break;
            case R.id.setting_net:
                JumpIntent = new Intent(context, SettingCustom.class);
                startActivity(JumpIntent);
                break;
            case R.id.setting_uninstall:
                JumpIntent = new Intent(context, AppUninstall.class);
                startActivity(JumpIntent);
                break;
            case R.id.setting_autorun:
                JumpIntent = new Intent(context, AppAutoRun.class);
                startActivity(JumpIntent);
                break;
            case R.id.setting_net_speed:
                JumpIntent = new Intent(context, SpeedTestActivity.class);
                startActivity(JumpIntent);
                break;
            default:
                break;
        }
    }
}
