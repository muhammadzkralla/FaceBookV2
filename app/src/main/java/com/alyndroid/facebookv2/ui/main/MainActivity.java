package com.alyndroid.facebookv2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.alyndroid.facebookv2.R;
import com.alyndroid.facebookv2.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;
    PostsAdapter adapter;
    Context context;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        recyclerView = findViewById(R.id.recycler);

        postViewModel.getPosts();

        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter  = new PostsAdapter(postModels);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(adapter);

            }
        });

    }
}
