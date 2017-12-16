package com.xiaolei.exretrofitcallbackexample;

import android.content.Context;
import android.widget.Toast;

import com.xiaolei.exretrofitcallback.network.common.IFailEvent;
import com.xiaolei.exretrofitcallback.network.common.SICallBack;

/**
 * Created by xiaolei on 2017/12/15.
 */

public class MyFailEvent implements IFailEvent
{
    @Override
    public void onFail(SICallBack callBack, Throwable t, Context context)
    {
        Toast.makeText(context, "哇哦~,您的网络有问题哦~", Toast.LENGTH_SHORT).show();
    }
}
