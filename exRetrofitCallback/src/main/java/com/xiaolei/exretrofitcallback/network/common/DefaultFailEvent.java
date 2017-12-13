package com.xiaolei.exretrofitcallback.network.common;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.xiaolei.exretrofitcallback.network.Config;

/**
 * 默认的统一的失败提示接口
 * Created by xiaolei on 2017/11/14.
 */
public class DefaultFailEvent implements IFiedFailEvent
{
    private long lastToastTime = -1;
    private String klassName = DefaultFailEvent.class.getName();
    private String configKlassName = Config.class.getName();

    @Override
    public void onFail(SICallBack callBack, Throwable t, Context context)
    {
        Log.e("FailEvent", "发生异常回调处:" + new StackTraceElement(klassName,"onFail","klassName",20) + "\n如果要修改，则可以调用:" + configKlassName + ".fiedFailEventClass=你的自己定义的统一失败处理方式。");
        long nowTime = System.currentTimeMillis();
        if (nowTime - lastToastTime > 10 * 1000)// 超过十秒
        {
            Toast.makeText(context, "网络异常.", Toast.LENGTH_SHORT).show();
        }
    }
}
