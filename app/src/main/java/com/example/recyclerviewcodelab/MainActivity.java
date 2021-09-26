package com.example.recyclerviewcodelab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0 ; i < 20 ; i++) {
            mWordList.addLast("Word" + i);
        }
        // GEt a handle to the recyclerview
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed
        mAdapter = new WordListAdapter(this, mWordList);
        // Connect the adapter with the RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        // Give the REcyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    public void onClick(View view) {
        int wordListSize = mWordList.size();

        mWordList.addLast(" + Word " + wordListSize);

        mRecyclerView.getAdapter().notifyItemInserted(wordListSize);

        mRecyclerView.smoothScrollToPosition(wordListSize);


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}