package com.xiaolei.exretrofitcallback.network.regist;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;

import java.lang.reflect.Method;

/**
 * Created by xiaolei on 2017/7/12.
 */

public abstract class ResponseBeanRegister<ResponseBeanType>
{
    private Method[] methods;
    private ArrayMap<String, Method> arrayMap = new ArrayMap<>();

    private Method[] getMethods()
    {
        if (methods == null)
        {
            methods = this.getClass().getDeclaredMethods();
        }
        return methods;
    }

    public Method getMethod(String callBackStr)
    {
        if (arrayMap.isEmpty())
        {
            Method[] methods = getMethods();
            if (methods != null)
            {
                for (Method method : methods)
                {
                    OnCallBack callBack = method.getAnnotation(OnCallBack.class);
                    if (callBack != null)
                    {
                        String defValue = callBack.value();
                        arrayMap.put(defValue, method);
                    }
                }
            }
        }
        return arrayMap.get(callBackStr);
    }

    /**
     * 过滤器，作为一个结果过滤器，返回的结果应该是个字符串
     * 如果不需要过滤，则返回的是一个 null
     *
     * @param bean
     * @return
     */
    public abstract
    @Nullable
    String filter(ResponseBeanType bean);
}
