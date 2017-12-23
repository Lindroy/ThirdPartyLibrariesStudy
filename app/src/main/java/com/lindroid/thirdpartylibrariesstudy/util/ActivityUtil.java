package com.lindroid.thirdpartylibrariesstudy.util;

import android.app.Activity;
import android.content.Intent;

/**
 *
 * @author linyulong
 * @funciton Activity工具类
 */

public class ActivityUtil {
    //不用finish当前Activity时直接调用此方法
    public static void startActivity(Activity activity, Class classes){
        startActivity(activity,classes,false);
    }

    //函数的重载
    //需要finish当前Activity时调用此方法，布尔值参数传入true
    public static void startActivity(Activity activity,Class classes,boolean isFinish){
        Intent intent = new Intent(activity,classes);
        activity.startActivity(intent);
        if (isFinish){
            activity.finish();
        }
    }
}
