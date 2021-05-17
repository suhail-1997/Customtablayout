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
        MainModel mainModel = mainModelList.get(position);
        TextView tv = (TextView) v.findViewById(R.id.item_name);
        TextView textView = v.findViewById(R.id.item_count);
        if(mainModel.getCount() != 0){
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(mainModel.getCount()));
        }
        else{
            textView.setVisibility(View.GONE);
        }

        tv.setText(mainModel.getLabel());
        ImageView img = (ImageView) v.findViewById(R.id.item_icon);

        if(mainModel.getTab_name().equalsIgnoreCase("fruits")){
            img.setImageResource(R.drawable.fruits);
        }
        else if(mainModel.getTab_name().equalsIgnoreCase("vegetables"))
        {
            img.setImageResource(R.drawable.harvest);
        }
        else if(mainModel.getTab_name().equalsIgnoreCase("soft drink"))
        {
            img.setImageResource(R.drawable.drink);
        }
        else if(mainModel.getTab_name().equalsIgnoreCase("milkshake"))
        {
            img.setImageResource(R.drawable.milkshake);
        }
        else if(mainModel.getTab_name().equalsIgnoreCase("fast food"))
        {
            img.setImageResource(R.drawable.fastfood);
        }
        else if(mainModel.getTab_name().equalsIgnoreCase("pizza"))
        {
            img.setImageResource(R.drawable.pizza);
        }
        else{
            img.setImageResource(R.drawable.breakfast);
        }

        if(position != 0){
            img.setImageAlpha(0x3F);
            tv.setTextColor(context.getResources().getColor(R.color.gray_1));
            textView.setBackgroundResource(R.drawable.circular_badge_grey);
        }
        return v;
    }
}
