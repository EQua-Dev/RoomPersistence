package com.androidstrike.roompersistence;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnAddUser;
    private Button btnReadUser;
    private Button btnDeleteUser;
    private Button btnUpdateUser;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnAddUser = view.findViewById(R.id.btn_add_user);
        btnAddUser.setOnClickListener(this);

        btnReadUser = view.findViewById(R.id.btn_view_users);
        btnReadUser.setOnClickListener(this);

        btnDeleteUser = view.findViewById(R.id.btn_delete_user);
        btnDeleteUser.setOnClickListener(this);
        btnUpdateUser = view.findViewById(R.id.btn_update_user);
        btnUpdateUser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_add_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.btn_view_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.btn_delete_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.btn_update_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateUserFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }
}
