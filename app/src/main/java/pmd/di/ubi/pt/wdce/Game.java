package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class Game extends Activity {

    //Guardar o user do intento anterior e passar para a proxima atividade
    String player;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Recebe o user id
        Intent playerID = getIntent();
        Bundle extras = playerID.getExtras();
        player = extras.getString("player");
        Log.i(TAG, "User ID: " + player + " => Game.class");

        //boolean insert = db.insertword();
       // if (insert == true)
        //    Toast.makeText(getApplicationContext(), "Dic. Successfully!!", Toast.LENGTH_SHORT).show();
       // else Toast.makeText(getApplicationContext(), "Dic. Fail!!", Toast.LENGTH_SHORT).show();

    }

    //função para o butão começar
    public void rungame (View view){


        Intent letmeplay = new Intent(this, FristRound.class);
        letmeplay.putExtra("player",player);
        startActivity(letmeplay);
    }

}
