package com.lindroid.thirdpartylibrariesstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hanks.passcodeview.PasscodeView;
import com.lindroid.thirdpartylibrariesstudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author linyulong
 *         PasscodeView：一个简单的密码设置和输入界面
 *         https://github.com/hanks-zyh/PasscodeView
 */
public class PasscodeViewActivity extends AppCompatActivity {

    @BindView(R.id.passcodeView)
    PasscodeView passcodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode_view);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        passcodeView
                //设置密码长度
                .setPasscodeLength(6)
                //设置正确密码
                .setLocalPasscode("654321")
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail() {
                        Log.e("Tag", "onFail");
                    }

                    @Override
                    public void onSuccess(String number) {
                        Log.e("Tag", "number=" + number);
                    }
                });
    }
}
