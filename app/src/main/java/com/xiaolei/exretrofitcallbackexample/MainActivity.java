package com.xiaolei.exretrofitcallbackexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Button;

import com.xiaolei.exretrofitcallback.network.Config;
import com.xiaolei.exretrofitcallback.network.common.SCallBack;
import com.xiaolei.exretrofitcallbackexample.Net.DataBean;
import com.xiaolei.exretrofitcallbackexample.Net.Net;
import com.xiaolei.exretrofitcallbackexample.Net.RetrofitBase;

import retrofit2.Call;

public class MainActivity extends Activity
{
    RetrofitBase retrofitBase;
    Button button;
    Button button2;
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button.setOnClickListener(v -> Click("兰州市"));
        button2.setOnClickListener(v -> Click("深圳市"));
        button3.setOnClickListener(v -> Click("南昌市"));
        
        Config.setFailedEventClass(MyFailEvent.class);
        Config.registResponseBean(DataBean.class,MyRegister.class);
    }


    private void Click(String city)
    {
        retrofitBase = new RetrofitBase(this);
        Net net = retrofitBase.getRetrofit().create(Net.class);
        Call<DataBean> call = net.getIndex(city);
        call.enqueue(new SCallBack<DataBean>(this)
        {
            @Override
            public void onSuccess(@NonNull DataBean result) throws Exception
            {
                Log.d("MainActivity", "onSuccess:"+result.getLat());
            }
            
            @Override
            public void onCache(@NonNull DataBean result) throws Exception
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
