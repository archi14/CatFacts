package com.example.architamittal.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //RecyclerView view;
    //RecyclerViewAdapeter recyclerViewAdapeter;
    //ListView list;
    //ArrayList arrayList;
    //ArrayList userAdapter;
    //ArrayAdapter<String> arrayAdapter;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    Retrofit retrofit;
    EditText animal,number;
    Button btn;
    LinearLayout visible;
    public static final String BASE_URL ="https://cat-fact.herokuapp.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animal = findViewById(R.id.animal);
        number = findViewById(R.id.number);
        btn = findViewById(R.id.btn);
        visible = findViewById(R.id.visible);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //animal.setVisibility(View.INVISIBLE);
                //number.setVisibility(View.INVISIBLE);
                //btn.setVisibility(View.INVISIBLE);
                ViewGroup.LayoutParams params = visible.getLayoutParams();
                params.height=0;
                visible.setLayoutParams(params);

                retrofit = getRetrofit();
                ApiInterface apiInterface = retrofit.create(ApiInterface.class);
                Call<List<Facts>> call = apiInterface.getAllFacts(animal.getText().toString(),Integer.valueOf(number.getText().toString()));
                call.enqueue(new Callback<List<Facts>>() {
                    @Override
                    public void onResponse(Call<List<Facts>> call, Response<List<Facts>> response) {
                        generatedatalist(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<Facts>> call, Throwable t) {

                    }
                });
            }
        });

        //list = findViewById(R.id.list);
        //arrayList = new ArrayList<>();
        //arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,arrayList);
    }

    private void generatedatalist(List<Facts> body) {
        recyclerView = findViewById(R.id.view);
        customAdapter = new CustomAdapter(body,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapter);

    }

    private Retrofit getRetrofit()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
