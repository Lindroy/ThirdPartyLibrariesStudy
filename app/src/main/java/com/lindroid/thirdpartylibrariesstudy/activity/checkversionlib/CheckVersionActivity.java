package com.lindroid.thirdpartylibrariesstudy.activity.checkversionlib;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.allenliu.versionchecklib.core.AllenChecker;
import com.allenliu.versionchecklib.core.VersionParams;
import com.lindroid.thirdpartylibrariesstudy.R;


/**
 * @author linyulong
 * @function : 版本更新
 */
public class CheckVersionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_version);
    }

    public void versionUpdate(View view) {
        VersionParams.Builder builder = new VersionParams.Builder()
                .setRequestUrl("http://www.baidu.com");
        //如果仅使用下载功能，downloadUrl是必须的
        builder.setOnlyDownload(true)
                .setDownloadUrl("http://down1.uc.cn/down2/zxl107821.uc/miaokun1/UCBrowser_V11.5.8.945_android_pf145_bi800_(Build170627172528).apk")
                .setTitle("检测到新版本")
                .setDownloadAPKPath(Environment.getExternalStorageDirectory() + "/CheckVersionPath/")
                .setCustomDownloadActivityClass(CheckVersionDialogActivity.class)
                .setUpdateMsg("发现新版本了，快来更新吧")
        ;
        CheckVersionDialogActivity.isCustomDownloading = true;
        AllenChecker.startVersionCheck(this, builder.build());
    }
}
