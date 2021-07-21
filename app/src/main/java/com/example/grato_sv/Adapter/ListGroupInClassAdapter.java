package com.example.grato_sv.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grato_sv.Activity.ListMemberInGroup;
import com.example.grato_sv.Model.Group;
import com.example.grato_sv.Model.LoginResponse;
import com.example.grato_sv.R;
import com.example.grato_sv.SessionManagement;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ListGroupInClassAdapter extends RecyclerView.Adapter<ListGroupInClassAdapter.GroupViewHolder> {
    ArrayList<Group> lstGroup;
    Context context;

    LoginResponse loginResponseSession;

    public ListGroupInClassAdapter(ArrayList<Group> lstGroup){
        this.lstGroup = lstGroup;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View groupView = inflater.inflate(R.layout.thong_group_item, parent, false);

        // get session token
        SessionManagement sessionManagement = SessionManagement.getInstance(context);
        String loginResponseJson = sessionManagement.getSession();
        Gson gson = new Gson();
        loginResponseSession = gson.fromJson(loginResponseJson, LoginResponse.class);

        return new GroupViewHolder(groupView);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        Group mgroup = lstGroup.get(position);

        holder.vtNameGroup.setText(mgroup.getGname());
        holder.vtWholesale.setText(mgroup.getNoStudent()+"");
        holder.vtMaxStudent.setText(mgroup.getMaxStudent()+"");

        holder.btnMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListMemberInGroup.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstGroup == null ? 0 : lstGroup.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder{

        public TextView vtNameGroup, vtMaxStudent, vtWholesale;
        Button btnMember;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            vtNameGroup = (TextView) itemView.findViewById(R.id.name_group);
            vtMaxStudent = (TextView) itemView.findViewById(R.id.maxStudent);
            vtWholesale = (TextView) itemView.findViewById(R.id.wholesale);
            btnMember = itemView.findViewById(R.id.button_view_member);
        }
    }
}

