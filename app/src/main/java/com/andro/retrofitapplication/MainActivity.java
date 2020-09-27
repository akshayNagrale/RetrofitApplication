package com.andro.retrofitapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<hero> heroArrayList;
    String BASE_URL = "https://simplifiedcoding.net/demos/";
    RecyclerView mRecyclerView;
    private HeroAdapter heroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        heroArrayList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        heroAdapter = new HeroAdapter(heroArrayList, this);
        mRecyclerView.setAdapter(heroAdapter);
        loadData();
    }

    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<hero>> call = apiInterface.getHeroes();
        call.enqueue(new Callback<List<hero>>() {
            @Override
            public void onResponse(Call<List<hero>> call, Response<List<hero>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "response fail", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_LONG).show();
                heroArrayList.addAll(response.body());
                heroAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<hero>> call, Throwable t) {

            }
        });
    }
}