package com.xiaolei.exretrofitcallbackexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xiaolei.exretrofitcallback.network.common.SCallBack;
import com.xiaolei.exretrofitcallbackexample.Net.DataBean;
import com.xiaolei.exretrofitcallbackexample.Net.Net;
import com.xiaolei.exretrofitcallbackexample.Net.RetrofitBase;

import retrofit2.Call;

public class MainActivity extends Activity
{
    RetrofitBase retrofitBase;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Click();
            }
        });

    }


    private void Click()
    {
        retrofitBase = new RetrofitBase(this);
        Net net = retrofitBase.getRetrofit().create(Net.class);
        Call<DataBean> call = net.getIndex("兰州市");
        call.enqueue(new SCallBack<DataBean>(this)
        {
            @Override
            public void onSuccess(DataBean result) throws Exception
            {
                Log.d("MainActivity", "onSuccess");
            }

            @Override
            public void onCache(DataBean result) throws Exception
            {
                Log.d("MainActivity", "onCache");
            }

            @Override
            public void onFail(Throwable t)
            {
                super.onFail(t);
                Log.d("MainActivity", "onFail:");
            }

            @Override
            public void onFinally()
            {
                Log.d("MainActivity", "onFinally");
            }
        });
    }
}
