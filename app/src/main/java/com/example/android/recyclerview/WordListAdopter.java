package com.example.android.recyclerview;
import android.content.Context;
 import android.support.v7.widget.RecyclerView;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.TextView;
 import java.util.LinkedList;



public class WordListAdopter extends RecyclerView.Adapter<WordListAdopter.WordViewHolder>{
    private final LinkedList<String> mWordList;
     private final LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public final TextView wordItemView;
        final WordListAdopter mAdapter;

        public WordViewHolder(View itemView, WordListAdopter adopter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            this.mAdapter = adopter;
            itemView.setOnClickListener(this);
        }


        public void onClick(View v) {
            // All we do here is prepend "Clicked! " to the text in the view, to verify that
            // the correct item was clicked. The underlying data does not change.
            wordItemView.setText("Clicked! " + wordItemView.getText());
        }
    }
    public WordListAdopter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                 // Inflate an item view.
                View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
                 return new WordViewHolder(mItemView, this);
             }
    @Override
     public void onBindViewHolder(WordViewHolder holder, int position) {
                 // Retrieve the data for that position.
                 String mCurrent = mWordList.get(position);
                 // Add the data to the view holder.
                 holder.wordItemView.setText(mCurrent);
            }
    @Override
     public int getItemCount() {
                 return mWordList.size();
             }

 }















