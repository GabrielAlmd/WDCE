package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

import static android.content.ContentValues.TAG;

public class LastRound extends Activity {


    TextView semi;
    EditText attempt;


    String right = ""; //variavel para a palavra
    String eTextAttempt ="";
    String player = ""; //variavel para o user
    String putonTv = "";

    int nTrys = 5;

    //variavel de tentativas começa as 5
    //variavel 0/1 para detetar (começa a 1)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_round);

        semi = findViewById(R.id.semi);
        attempt = findViewById(R.id.attempt);


        Intent playerandword = getIntent();
        Bundle extras = playerandword.getExtras();
        player = Objects.requireNonNull(extras).getString("player");
        right = Objects.requireNonNull(extras).getString("right");
        putonTv = Objects.requireNonNull(extras).getString("display");
        Log.i(TAG, "User ID: " + player + " => LastRound.class");


        Log.i(TAG, "Right word: " + right);
        Log.i(TAG, "Right display: " + putonTv);

        //recever a palavra e por no textview
        semi.setText(putonTv);


    }

    //funçao para tentativas
        // se errado
            //soma n tentativas
            // mantem a variavel a 1
            //da clear do edit tex
            //toast tenta de novo
        // se certo
            //calcula score
            //volta a função fristround
            //passa o score e o user


    //função para desistir
        //passa a fristround
        // passa o score e user
        //

}
