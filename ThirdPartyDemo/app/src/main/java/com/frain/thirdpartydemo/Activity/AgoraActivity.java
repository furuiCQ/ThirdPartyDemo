package com.frain.thirdpartydemo.Activity;

import android.app.Activity;
import android.os.Bundle;

import com.frain.thirdpartydemo.R;

import io.agora.rtc.RtcEngine;

/**
 * Created by admin on 2016/12/28.
 */
public class AgoraActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agora);
    }

    public void demo(){
//        RtcEngine rtcEngine=new RtcEngine(AgoraActivity.this,
//                    ""
//                );
    }
}
