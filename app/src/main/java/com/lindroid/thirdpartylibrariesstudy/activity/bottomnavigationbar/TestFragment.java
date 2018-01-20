package com.lindroid.thirdpartylibrariesstudy.activity.bottomnavigationbar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lindroid.thirdpartylibrariesstudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {


    @BindView(R.id.text)
    TextView tvName;
    Unbinder unbinder;

    public String name;

    public TestFragment() {
        // Required empty public constructor
    }

    public TestFragment(String text) {
        name = text;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        unbinder = ButterKnife.bind(this, view);
        tvName.setText(name);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
