package com.example.registerloginexample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

public class member_check extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        //String userPass = intent.getStringExtra("userPass");
        String teamName = intent.getStringExtra("teamName");

        Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Toast.makeText(member_check.this, response, Toast.LENGTH_LONG).show();
                            String team_name = "";
                            JSONArray jsonArray =new JSONArray(response);
                            ArrayList<String> team = new ArrayList<String>();
                            for( int i= 0; i<jsonArray.length(); i++){
                                team_name = team_name + jsonArray.get(i) + " ";
                                team.add((String) jsonArray.get(i));
                            }
                                //Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(member_check.this, MainActivity.class);
                                intent.putExtra("userID",userID);
                                intent.putExtra("teamName",teamName);
                                intent.putExtra("team_member",team_name);
                                intent.putStringArrayListExtra("team_array",team);
                                startActivity(intent);
                        } catch (JSONException e) {
                            //Toast.makeText(getApplicationContext(), "실패ㅑㅑㅑ", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                };
        MemberCheckRequest memberCheckRequest = new MemberCheckRequest(userID,teamName,responseListener);
        RequestQueue queue = Volley.newRequestQueue(member_check.this);
        queue.add(memberCheckRequest);
        //Toast.makeText(getApplicationContext(), "구성원", Toast.LENGTH_SHORT).show();
    }
}