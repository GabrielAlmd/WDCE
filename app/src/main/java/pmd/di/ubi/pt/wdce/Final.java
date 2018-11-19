package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import static android.content.ContentValues.TAG;

public class Final extends Activity {

    TextView userid;
    TextView totalScore;

    DatabaseHelper db;

    int userSocer;//variavel score
    String player;//variavel user


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        Intent playerID = getIntent();
        Bundle extras = playerID.getExtras();
        player = Objects.requireNonNull(extras).getString("player");
        Log.i(TAG, "User ID: " + player + " => Final.class");

        userid = findViewById(R.id.userid);
        userid.setText(player);


        totalScore = findViewById(R.id.totalScore);
        userSocer = db.getscoreuser(player);
        //totalScore.setText();


        //pega no score do user e adiciona pontos

        //mostra o score feito na textview
        //mostra o total de pontos acumolado

    }

    public void lestgoagain (View view){//Função vamos de novo
        Intent again = new Intent(this, Game.class);
        again.putExtra("player",player);
        startActivity(again);
    }


    public void closeall (View view){//Funçao fechar por completo
        finishAffinity();
        finish();
    }

}
