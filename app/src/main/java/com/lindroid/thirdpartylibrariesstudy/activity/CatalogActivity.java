package com.lindroid.thirdpartylibrariesstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lindroid.thirdpartylibrariesstudy.R;
import com.lindroid.thirdpartylibrariesstudy.util.ActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author linyulong
 */
public class CatalogActivity extends AppCompatActivity {

    @BindView(R.id.list_catalog)
    ListView listCatalog;
//    public static String[] items = {"仿饿了么加入购物车旋转控件",
//            "PasscodeView",
//            "NumberProgressBar",
//            "CountdownView倒计时"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        ButterKnife.bind(this);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.libraries, android.R.layout.simple_list_item_1);
        listCatalog.setAdapter(arrayAdapter);
        listCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        ActivityUtil.startActivity(CatalogActivity.this, AnimShopButtonActivity.class);
                        break;
                    case 1:
                        ActivityUtil.startActivity(CatalogActivity.this, PasscodeViewActivity.class);
                        break;
                    case 2:
                        ActivityUtil.startActivity(CatalogActivity.this, AutoSystemBarActivity.class);
                        break;
                    case 3:
                        ActivityUtil.startActivity(CatalogActivity.this, CountdownViewActivity.class);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
