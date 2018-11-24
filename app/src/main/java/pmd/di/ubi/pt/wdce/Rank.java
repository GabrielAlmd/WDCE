package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Objects;

import static android.content.ContentValues.TAG;

public class Rank extends Activity {

    String player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);


        Intent playerID = getIntent();
        Bundle extras = playerID.getExtras();
        player = Objects.requireNonNull(extras).getString("player");
        Log.i(TAG, "User ID: " + player + " => Rank.class");


        //mostrar tabela de ranks
        
    }

    public void tofinal(View view){

        Intent tofinal = new Intent(this, Final.class);
        tofinal.putExtra("player",player);
        startActivity(tofinal);
    }
}
