package com.accentelsoft.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    MainAdapter mainAdapter;
    private TabLayout tabLayout;
    private List<MainModel> finalAdapterData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        finalAdapterData = new ArrayList<>();
        finalAdapterData.add(new MainModel("fruits","organic fruits"));
        finalAdapterData.add(new MainModel("vegetables","organic vegetables"));
        finalAdapterData.add(new MainModel("pizza","Italian food"));
        finalAdapterData.add(new MainModel("milkshake","milkshake"));
        finalAdapterData.add(new MainModel("soft drink","soft drink"));
        finalAdapterData.add(new MainModel("fast food","burgers"));
        finalAdapterData.add(new MainModel("south indian","south indian"));



        mainAdapter = new MainAdapter(getSupportFragmentManager(),MainActivity.this,finalAdapterData.size(),finalAdapterData);
        viewPager.setAdapter(mainAdapter);
        tabLayout.setupWithViewPager(viewPager);
        for(int i=0;i<tabLayout.getTabCount();i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(mainAdapter.getTabView(i));
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if(view != null){
                    ImageView imageView = view.findViewById(R.id.item_icon);
                    imageView.setImageAlpha(0xFF);
                    TextView textView = view.findViewById(R.id.item_name);
                    textView.setTextColor(getResources().getColor(R.color.black));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if(view != null){
                    ImageView imageView = view.findViewById(R.id.item_icon);
                    imageView.setImageAlpha(0x3F);
                    TextView textView = view.findViewById(R.id.item_name);
                    textView.setTextColor(getResources().getColor(R.color.gray_1));
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}