package com.next.micrm;


import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_SECTION_NAME ="section_name";
    private static final String ARG_SECTION_IMAGE ="section_image";
    public MainActivityFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity) context).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.img_section);
        TextView textImage = (TextView) rootView.findViewById(R.id.section_img);
        imageView.setImageResource(getArguments().getInt(ARG_SECTION_IMAGE));
        textImage.setText(getArguments().getString(ARG_SECTION_NAME));
        return rootView;
    }
    public static MainActivityFragment newInstace(int i) {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle arg = new Bundle();
        arg.putInt(ARG_SECTION_NUMBER,i);
        fragment.setArguments(arg);
        return fragment;
    }
    public static MainActivityFragment newInstace(int i, String name, int image) {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle arg = new Bundle();
        arg.putInt(ARG_SECTION_NUMBER,i);
        arg.putInt(ARG_SECTION_IMAGE, image);
        arg.putString(ARG_SECTION_NAME, name);
        fragment.setArguments(arg);
        return fragment;
    }
}
