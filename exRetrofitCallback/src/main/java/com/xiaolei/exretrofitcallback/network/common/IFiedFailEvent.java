package com.xiaolei.exretrofitcallback.network.common;

import android.content.Context;

/**
 * 统一的失败提示接口
 * Created by xiaolei on 2017/11/14.
 */

public interface IFiedFailEvent
{
    public abstract void onFail(SICallBack callBack, Throwable t, Context context);
}
