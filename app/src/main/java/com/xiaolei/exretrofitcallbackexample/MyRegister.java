package com.xiaolei.exretrofitcallbackexample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.xiaolei.exretrofitcallback.network.regist.OnCallBack;
import com.xiaolei.exretrofitcallback.network.regist.ResponseBeanRegister;
import com.xiaolei.exretrofitcallbackexample.Net.DataBean;

/**
 * Created by xiaolei on 2017/12/15.
 */

public class MyRegister extends ResponseBeanRegister<DataBean>
{
    @Nullable
    @Override
    public String filter(DataBean bean)
    {
        return bean.getLat();
    }
    
    @OnCallBack(value = "36.06108")//兰州市
    public void onInLanzhou(Context context)
    {
        Log.d("MainActivity", "拦截：兰州市");
    }

    @OnCallBack(value = "22.54309",stopNextStep = false)//深圳市
    public void onInShenzhen(Context context)
    {
        Log.d("MainActivity", "拦截：深圳市");
    }
    
}
