package com.lindroid.thirdpartylibrariesstudy.activity.checkversionlib;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.allenliu.versionchecklib.callback.APKDownloadListener;
import com.allenliu.versionchecklib.core.VersionDialogActivity;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.lindroid.thirdpartylibrariesstudy.R;

import java.io.File;

/**
 * @author linyulong
 * @function 自定义版本更新对话框
 */
public class CheckVersionDialogActivity extends VersionDialogActivity {

    public static boolean isCustomDownloading = false;
    private View loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_version_dialog);

        setApkDownloadListener(new APKDownloadListener() {
            @Override
            public void onDownloading(int progress) {

            }

            @Override
            public void onDownloadSuccess(File file) {
                finish();
            }

            @Override
            public void onDownloadFail() {
                Toast.makeText(CheckVersionDialogActivity.this, "下載失敗", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showLoadingDialog(int currentProgress) {
        if (!isCustomDownloading) {
            super.showLoadingDialog(currentProgress);
        } else {
            if (loadingDialog == null) {
                loadingView = View.inflate(this, R.layout.dialog_download_number_progress, null);
                loadingDialog = new AlertDialog.Builder(this).setTitle("").setView(loadingView).create();
                loadingDialog.setCancelable(false);
                loadingDialog.setCanceledOnTouchOutside(false);
                loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        finish();
                    }
                });
            }

            NumberProgressBar pb = (NumberProgressBar) loadingView.findViewById(R.id.progress_bar);
            pb.setProgress(currentProgress);
            loadingDialog.show();
//            TextView tvProgress = (TextView) loadingView.findViewById(R.id.tv_progress);
        }

    }
}
