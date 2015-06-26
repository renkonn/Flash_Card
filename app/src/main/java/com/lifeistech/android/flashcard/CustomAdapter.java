package com.lifeistech.android.flashcard;

/**
 * Created by Ren on 2015/06/05.
 */


import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.content.Context;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {



    public CustomAdapter(Context context, int textViewResourceId, List<Word> objects) {
        super (context, textViewResourceId, objects);

        mWords = objects;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //ここにメソッドを書いていきます！
    List<Word> mWords;
    private LayoutInflater layoutInflater;
    @Override
    public int getCount(){
        return mWords.size();
    }

    @Override
    public Object getItem(int position)  {
        return mWords.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)  {

        //getViewの処理内容を書いていきます！
        Word item = (Word) getItem(position);

        if (null == convertView) {
            convertView = layoutInflater.inflate(R.layout.rowdata, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(item.spell);

        return convertView;
    }
}
