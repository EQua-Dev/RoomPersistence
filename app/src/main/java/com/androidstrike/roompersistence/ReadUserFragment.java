package com.androidstrike.roompersistence;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {

    private TextView TxtInfo;


    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_user, container, false);
        TxtInfo = view.findViewById(R.id.txt_display_info);

//        we will use the MyAppDatabase object created in the MainActivity to get the users saved in the database
        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();

//        we create and initialize an empty variable to populate the users list later
        String info = "";

//        we create a for loop for each of the database
        for (User usr : users){
            int id = usr.getId();
            String name = usr.getName();
            String email = usr.getEmail();
//            we then display it in the info string created
            info = info + "\n\n"+"Id :"+id+"\n Name :"+name+"\n"+"Email :"+email;
        }

//        we display the info on the screen
        TxtInfo.setText(info);
        return view;
    }

}
