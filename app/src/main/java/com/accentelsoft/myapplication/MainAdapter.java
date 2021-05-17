package com.accentelsoft.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;
import java.util.Map;

/**
 * Designed and Developed by Mohammad suhail ahmed on 17/05/2021
 */
public class MainAdapter extends FragmentPagerAdapter {
    private Context context;
    private int noOfTabs;
    private List<MainModel> mainModelList;

    private String drugName;
    public MainAdapter(@NonNull FragmentManager fm, Context context, int noOfTabs, List<MainModel> mainModelList) {
        super(fm);
        this.context = context;
        this.noOfTabs = noOfTabs;
        this.mainModelList = mainModelList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        MainModel mainModel = mainModelList.get(position);
        return  TabFragment.newInstance(mainModel.getTab_name());
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }

    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        MainModel drugDetail = mainModelList.get(position);
        TextView tv = (TextView) v.findViewById(R.id.item_name);
        tv.setText(drugDetail.getLabel());
        ImageView img = (ImageView) v.findViewById(R.id.item_icon);

        if(drugDetail.getTab_name().equalsIgnoreCase("fruits")){
            img.setImageResource(R.drawable.fruits);
        }
        else if(drugDetail.getTab_name().equalsIgnoreCase("vegetables"))
        {
            img.setImageResource(R.drawable.harvest);
        }
        else if(drugDetail.getTab_name().equalsIgnoreCase("soft drink"))
        {
            img.setImageResource(R.drawable.drink);
        }
        else if(drugDetail.getTab_name().equalsIgnoreCase("milkshake"))
        {
            img.setImageResource(R.drawable.milkshake);
        }
        else if(drugDetail.getTab_name().equalsIgnoreCase("fast food"))
        {
            img.setImageResource(R.drawable.fastfood);
        }
        else if(drugDetail.getTab_name().equalsIgnoreCase("pizza"))
        {
            img.setImageResource(R.drawable.pizza);
        }
        else{
            img.setImageResource(R.drawable.breakfast);
        }

        if(position != 0){
            img.setImageAlpha(0x3F);
            tv.setTextColor(context.getResources().getColor(R.color.gray_1));
        }
        return v;
    }
}
