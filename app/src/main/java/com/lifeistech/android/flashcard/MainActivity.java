package com.lifeistech.android.flashcard;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    //変数を宣言する
    ListView listView;
    CustomAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ここにリストを作っていきます！

        List<Word> objects = new ArrayList<Word>();
        //リストの生成をする

        objects.add(new Word("apple", "りんご"));
        objects.add(new Word("Doppler effect", "phenomenon responsible for the apparent change in pitch"));
        objects.add(new Word("wave", "disturbance that transfers energy through a medium"));
        objects.add(new Word("physics","the study of the relationships between matter and energy"));
        //objects.add(new Word("英語帳のスペル", "英単語の意味"));

        //変数に実態を代入していきます！
        mAdapter =new CustomAdapter(getApplicationContext(), 0, objects);
        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //タップされた時の処理をここに書いていきます。
                Word word = (Word) mAdapter.getItem(position);
                Toast.makeText(getApplicationContext(), word.definition, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
