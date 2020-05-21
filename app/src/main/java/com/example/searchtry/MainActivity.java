package com.example.searchtry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.searchtry.ApiInterface.getUsers;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Users> users;
    private  Adapter adapter;
    private  ApiInterface apiInterface;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressbar);
        recyclerView=findViewById(R.id.recycler);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        fetchUsers("");
    }
    public void  fetchUsers(String key)
    {
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Users>> call= getUsers(key);

        call.enqueue(new Callback<List<Users>>()
                      {
                          @Override
                          public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                     progressBar.setVisibility(View.GONE);
                     users=response.body();
                     adapter=new Adapter(users,MainActivity.this);
                     recyclerView.setAdapter(adapter);
                     adapter.notifyDataSetChanged();


                          }

                          @Override
                          public void onFailure(Call<List<Users>> call, Throwable t) {
                          progressBar.setVisibility(View.GONE);
                          Toast.makeText(MainActivity.this,"Error"+ t.toString(),Toast.LENGTH_SHORT).show();
                          }
                      }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        SearchManager searchManager=(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView=(SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName())
        );
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                fetchUsers(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fetchUsers(newText);
                return false;
            }
        });
        return true;
    }
}
