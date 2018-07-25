package com.example.android.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;
 import android.view.View;
 import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private WordListAdopter mAdapter;
    private final LinkedList<String> mWordList = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);

        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new WordListAdopter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
          public void onClick(View view) {
                        int wordListSize = mWordList.size();
                                         // Add a new word to the wordList.
                        mWordList.addLast("+ Word " + wordListSize);
                                         // Notify the adapter, that the data has changed.
                        mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                                         // Scroll to the bottom.
                        mRecyclerView.smoothScrollToPosition(wordListSize);
                                     }
        });
    }
 }






