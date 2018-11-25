package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    int scoreround = 0;

    //variavel de tentativas começa as 5
    //variavel 0/1 para detetar (começa a 1)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_round);

        semi = findViewById(R.id.semi);
        attempt = findViewById(R.id.attempt);


        Intent playerandword = getIntent();
        player = playerandword.getExtras().getString("player");
        right = playerandword.getExtras().getString("word");
        putonTv = playerandword.getExtras().getString("display");
        Log.i(TAG, "UserProvider ID: " + player + " => LastRound.class");


        Log.i(TAG, "Right word: " + right);
        Log.i(TAG, "Right display: " + putonTv);

        //recever a palavra e por no textview
        semi.setText(putonTv);


    }

    public void chkword (View view){ //funçao para tentativas

        eTextAttempt = attempt.getText().toString();
        Log.i(TAG, "chkword: try is " + eTextAttempt);

        if(right.equals(eTextAttempt)){// se certo
            scoreround = 1000/nTrys; //calcula score

            String toastText = "Fez " + scoreround +" pontos!!";

            //Falta guardar adicionar ao score

            Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT).show();

            //volta a função fristround
            Intent igotit = new Intent(this, FristRound.class);
            igotit.putExtra("player",player);
            startActivity(igotit);
        }
        else{ // se errado

            nTrys += 1;
            Log.i(TAG, "chkword: number of trys " + nTrys);//soma n tentativas
            attempt.getText().clear(); //da clear do edit tex
            Toast.makeText(getApplicationContext(), "TENTA DE NOVO!!", Toast.LENGTH_SHORT).show(); //toast tenta de novo
        }

    }


    public void changeWord (View view){ //função para desistir

        //passa a fristround
        Toast.makeText(getApplicationContext(), "Deste-te por vencido!!", Toast.LENGTH_SHORT).show();
        Intent nextword = new Intent(this, FristRound.class);
        nextword.putExtra("player",player);
        startActivity(nextword);

    }

}
