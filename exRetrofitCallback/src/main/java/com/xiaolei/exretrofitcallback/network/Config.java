package com.xiaolei.exretrofitcallback.network;

import com.xiaolei.exretrofitcallback.network.common.DefaultFailEvent;
import com.xiaolei.exretrofitcallback.network.common.IFiedFailEvent;

/**
 * Created by xiaolei on 2017/12/13.
 */

public class Config
{
    public static Class<? extends IFiedFailEvent> fiedFailEventClass = DefaultFailEvent.class;
}
