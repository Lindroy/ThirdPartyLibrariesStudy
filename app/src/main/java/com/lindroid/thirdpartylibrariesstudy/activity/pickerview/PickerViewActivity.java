package com.lindroid.thirdpartylibrariesstudy.activity.pickerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bigkoo.pickerview.OptionsPickerView;
import com.lindroid.thirdpartylibrariesstudy.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author linyulong
 */
public class PickerViewActivity extends AppCompatActivity {

    @BindView(R.id.btn_multiple_option)
    Button btnMultipleOption;

    private OptionsPickerView multipleOp;
    private List<String> optionData1 = new ArrayList<>();
    private List<List<String>> optionData2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker_view);
        ButterKnife.bind(this);
        initData();
        multipleOp = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

            }
        }).build();
        multipleOp.setPicker(optionData1, optionData2);
    }

    private void initData() {
        List<String> monthList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            monthList.add(String.valueOf(i));
        }

        for (int i = 0; i < 10; i++) {
            List<String> strings = new ArrayList<>();
            if (i == 0) {
                optionData1.add("至今");
                strings.add("至今");
                optionData2.add(strings);
            } else {
                optionData1.add(String.valueOf(i + 2009));
                optionData2.add(monthList);
            }
        }
    }

    @OnClick(R.id.btn_multiple_option)
    public void onViewClicked() {
        multipleOp.show();
    }
}
