package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Showmember extends AppCompatActivity {
    private ImageButton Main_setting;
    private RecyclerAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_check);
        init();
        getData();
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String teamName = intent.getStringExtra("teamName");
        String team_member = intent.getStringExtra("team_member");
        Main_setting = findViewById(R.id.Main_setting);

        Main_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Showmember.this, SettingActivity.class);
                intent.putExtra("userID",userID);
                intent.putExtra("teamName",teamName);
                startActivity(intent);
            }
        });

    }
    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }
    private void getData() {
        Intent intent = getIntent();
        ArrayList<String> team = intent.getStringArrayListExtra("team_array");
        for (int i = 0; i < team.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Data data = new Data();
            data.setContent(team.get(i));
            adapter.addItem(data);
            // 각 값이 들어간 data를 adapter에 추가합니다.

        }
        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }



}
