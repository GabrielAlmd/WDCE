package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class Rank extends Activity {

    String player;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    SQLiteDatabase sql;
    DatabaseHelper db;

    Cursor cursor;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);


        Intent playerID = getIntent();
        Bundle extras = playerID.getExtras();
        player = Objects.requireNonNull(extras).getString("player");
        Log.i(TAG, "UserProvider ID: " + player + " => Rank.class");


        listView = (ListView) findViewById(R.id.listranks);
        db = new DatabaseHelper(this);
        listItem = new ArrayList<>();

        viewData();

    }

    private void viewData() {

        Cursor cursor = db.getTopPlayers();

        if(cursor.getCount() == 0){
            Toast.makeText(this, "Não existe dados suficiente!!", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(0));
            }

            adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listItem);
            listView.setAdapter(adapter);
        }
    }

    public void tofinal(View view){

        Intent tofinal = new Intent(this, Final.class);
        tofinal.putExtra("player",player);
        startActivity(tofinal);
    }
}
