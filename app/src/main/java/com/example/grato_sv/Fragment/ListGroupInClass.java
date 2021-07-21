package com.example.grato_sv.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.grato_sv.Adapter.ListGroupInClassAdapter;
import com.example.grato_sv.Model.Group;
import com.example.grato_sv.Model.LoginResponse;
import com.example.grato_sv.R;
import com.example.grato_sv.SessionManagement;
import com.example.grato_sv.ViewModel.GratoViewModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class ListGroupInClass extends Fragment {

    RecyclerView listGroupRecycleView;
    View view;

    GratoViewModel mGratoViewModel;
    LoginResponse loginResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_group_in_class, container, false);

        // get token
        SessionManagement sessionManagement = SessionManagement.getInstance(getContext());

        String loginResponseJson = sessionManagement.getSession();
        Gson gson = new Gson();
        loginResponse = gson.fromJson(loginResponseJson, LoginResponse.class);

        addControls();
        // Inflate the layout for this fragment
        getData();
        return view;
    }

    private void getData() {
        ArrayList<Group> lstGroup = new ArrayList<>();
//        lstGroup.add(new Group("Alias",3,3));
//        lstGroup.add(new Group("Pepsi",4,1));
//        lstGroup.add(new Group("CoCa",3,2));
//        lstGroup.add(new Group("Sting",3,2));

//        mGratoViewModel = new ViewModelProvider(this).get(GratoViewModel.class);
//        mGratoViewModel.getResponseListGroup().observe(getViewLifecycleOwner(), new Observer<List<Group>>() {
//            @Override
//            public void onChanged(List<Group> groups) {
//                Log.d("list group",groups.toString());
//                ListGroupInClassAdapter listGroupClassAdapter = new ListGroupInClassAdapter((ArrayList<Group>) groups);
//                listGroupRecycleView.setHasFixedSize(true);
//                listGroupRecycleView.setAdapter(listGroupClassAdapter);
//            }
//        });
//
//        mGratoViewModel.fetchListGroup(loginResponse.getToken(),"CO3005",202,"L01");


    }

    private void addControls() {
        listGroupRecycleView = view.findViewById(R.id.list_group);
    }
}