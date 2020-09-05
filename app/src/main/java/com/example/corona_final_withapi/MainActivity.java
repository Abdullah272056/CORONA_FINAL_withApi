package com.example.corona_final_withapi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterFace apiInterface;
    List<ObjectDataClass> allInformationList;
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = MyRetrofit.getRetrofit().create(ApiInterFace.class);
        recyclerView = findViewById(R.id.recyclerView);
        //api call to get the data
        getAllInformationData();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater=getMenuInflater ();
//        menuInflater.inflate(R.menu.menu_layout,menu);
//
//        MenuItem menuItem=menu.findItem(R.id.searchViewID);
//        SearchView searchView= (SearchView) menuItem.getActionView();
//        searchView.setOnQueryTextListener (new SearchView.OnQueryTextListener () {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//               // adapter.getFilter().filter(s);
//                return false;
//            }
//        });
//
//
//        return true;
//    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Please confirm");
        builder.setMessage("Do you want to exit this app?");
        builder.setCancelable(true);
        builder.setPositiveButton ("Yes", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText (MainActivity.this, "thank you", Toast.LENGTH_SHORT).show ();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    private void getAllInformationData(){
        apiInterface.GetData().enqueue(new Callback<List<ObjectDataClass>>() {
            @Override
            public void onResponse(Call<List<ObjectDataClass>> call, Response<List<ObjectDataClass>> response) {
                if (response.isSuccessful()){
                    allInformationList=new ArrayList<>();
                    allInformationList.addAll(response.body());

                    if (allInformationList.size() > 0) {

                        adapter = new CustomAdapter(MainActivity.this,allInformationList);
                        recyclerView.setLayoutManager(new LinearLayoutManager (MainActivity.this));
                        recyclerView.setAdapter(adapter);

                        // Toast.makeText(MainActivity.this, "sss", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(MainActivity.this, String.valueOf(allInformationList.size()), Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(MainActivity.this, String.valueOf(allInformationList.size()), Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onFailure(Call<List<ObjectDataClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}