package com.accentelsoft.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFragment extends Fragment {
    private TextView textView;
    public TabFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TabFragment newInstance(String name) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putString("tabName",name);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        textView = view.findViewById(R.id.text_view);
        textView.setText(getArguments().getString("tabName"));
        return view;
    }
}