package com.lindroid.thirdpartylibrariesstudy.activity.materialedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lindroid.thirdpartylibrariesstudy.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author linyulong
 */
public class MaterialEditTextActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    MaterialEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_edit_text);
        ButterKnife.bind(this);
    }
}
