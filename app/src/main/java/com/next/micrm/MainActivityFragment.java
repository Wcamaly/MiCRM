package com.next.micrm;


import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
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
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText("Este el el contenido de la sección "+Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
        return rootView;
    }

    public static MainActivityFragment newInstace(int i) {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle arg = new Bundle();
        arg.putInt(ARG_SECTION_NUMBER,i);
        fragment.setArguments(arg);
        return fragment;
    }
}
