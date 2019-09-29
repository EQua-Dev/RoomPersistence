package com.androidstrike.roompersistence;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {
    private EditText UserId, UserName, UserEmail;
    private Button BtnSave;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        UserId = view.findViewById(R.id.edit_text_user_id);
        UserName = view.findViewById(R.id.edit_text_name);
        UserEmail = view.findViewById(R.id.edit_text_email);
        BtnSave = view.findViewById(R.id.button_save);

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                on click, we fetch the information in each field to string, ready to be saved into the database
                int userid = Integer.parseInt(UserId.getText().toString());
                String username = UserName.getText().toString();
                String useremail = UserEmail.getText().toString();
//                todo open main activity to initialize the databbase

//                now we perform the insertion
                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);

//                here, using the MyAppDatabase object created in the MainActivity, we add the User detail to the database
                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User added successfully!!", Toast.LENGTH_SHORT).show();

                UserId.setText("");
                UserName.setText("");
                UserEmail.setText("");
            }
        });

        return view;
    }

}
