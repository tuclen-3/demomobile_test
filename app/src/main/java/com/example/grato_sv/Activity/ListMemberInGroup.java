package com.example.grato_sv.Activity;

import android.os.Bundle;

import com.example.grato_sv.Adapter.MemberInGroupAdapter;
import com.example.grato_sv.Model.Member;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grato_sv.R;

import java.util.ArrayList;

public class ListMemberInGroup extends AppCompatActivity {

    RecyclerView memberInGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thong_list_member_in_group);
        addControls();
        getData();
    }

    private void getData(){
        ArrayList<Member> lstMember = new ArrayList<>();
        lstMember.add(new Member("Do My Linh","1812222"));
        lstMember.add(new Member("H'Hen Nie","1813333"));
        lstMember.add(new Member("Cao Xuan Tai","1814444"));
        lstMember.add(new Member("Nguyen Xuan Tien","1815555"));

        MemberInGroupAdapter  memberInGroupAdapter = new MemberInGroupAdapter(lstMember);
        memberInGroup.setHasFixedSize(true);
        memberInGroup.setAdapter(memberInGroupAdapter);
    }

    private void addControls(){
        memberInGroup = findViewById(R.id.list_member_in_group);
    }
}