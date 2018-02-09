package com.lindroid.thirdpartylibrariesstudy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lindroid.thirdpartylibrariesstudy.R;
import com.lindroid.thirdpartylibrariesstudy.activity.alphatabsindicator.AlphaTabActivity;
import com.lindroid.thirdpartylibrariesstudy.activity.bottomnavigationbar.BottomBarActivity;
import com.lindroid.thirdpartylibrariesstudy.activity.checkversionlib.CheckVersionActivity;
import com.lindroid.thirdpartylibrariesstudy.activity.materialedittext.MaterialEditTextActivity;
import com.lindroid.thirdpartylibrariesstudy.activity.mzbanner.MZBannerActivity;
import com.lindroid.thirdpartylibrariesstudy.activity.simplebehavior.SimpleBehaviorActivity;
import com.lindroid.thirdpartylibrariesstudy.util.ActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author linyulong
 */
public class CatalogActivity extends AppCompatActivity {

    @BindView(R.id.list_catalog)
    ListView listCatalog;

    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        ButterKnife.bind(this);
        context = CatalogActivity.this;
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.libraries, android.R.layout.simple_list_item_1);
        listCatalog.setAdapter(arrayAdapter);
        listCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        ActivityUtil.startActivity(context, AnimShopButtonActivity.class);
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
                    case 4:
                        ActivityUtil.startActivity(CatalogActivity.this, CheckVersionActivity.class);
                        break;
                    case 5:
                        ActivityUtil.startActivity(CatalogActivity.this, SimpleBehaviorActivity.class);
                        break;
                    case 6:
                        ActivityUtil.startActivity(context, MaterialEditTextActivity.class);
                        break;
                    case 7:
                        ActivityUtil.startActivity(context, BottomBarActivity.class);
                        break;
                    case 8:
                        ActivityUtil.startActivity(context, MZBannerActivity.class);
                        break;
                    case 9:
                        ActivityUtil.startActivity(context, AlphaTabActivity.class);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
