package com.example.grato_sv.Repository;

import android.util.Log;

import com.example.grato_sv.Api.ApiRequest;
import com.example.grato_sv.Api.RetrofitInit;
import com.example.grato_sv.Model.Group;

import java.util.List;

import io.reactivex.rxjava3.core.Maybe;

public class GroupRepository {
    private static GroupRepository mInstance = null;
    private ApiRequest mApiRequest = null;

    // khởi tạo ApiRequest
    private GroupRepository(){
        mApiRequest = RetrofitInit.getInstance();
    }
    // khởi tạo mInstance
    public static GroupRepository getInstance(){
        if(mInstance == null){
            mInstance = new GroupRepository();
        }
        return mInstance;
    }

    public Maybe<List<Group>> getListGroup(String token, String sub_id, Integer semester_id, String class_id){
        Log.d("get list group:",sub_id+" "+semester_id+" "+class_id);
        return mApiRequest.getListGroup(token,sub_id,semester_id,class_id);
    }

}
