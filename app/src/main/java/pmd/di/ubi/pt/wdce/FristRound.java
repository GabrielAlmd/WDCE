package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class FristRound extends Activity {

    TextView semi;
    EditText attempt;

    String right = "";
    String line="";
    String eTextAttempt ="";



    int certo = 0; //0 - acertou / 1 - Errou
    int scoreround;//valor do score feito
    int nTrys = 1;
    String player = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist_round);

        semi = findViewById(R.id.semi);
        attempt = findViewById(R.id.attempt);

        //Recebe o user id
        Intent playerID = getIntent();
        Bundle extras = playerID.getExtras();
        player = Objects.requireNonNull(extras).getString("player");
        Log.i(TAG, "User ID: " + player + " => FristRound.class");

        if(certo == 0){
            //le  o ficheiro mete num vetor e seleciona uma palavra rand

            ArrayList<String> listS = new ArrayList<>();
            InputStream inputStream = getResources().openRawResource(R.raw.dictionary);

            BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream));

            try {
                while ((line = bReader.readLine()) != null)
                    listS.add(line);
            }catch (IOException e){
                e.printStackTrace();
            }

            int index = (int) (Math.random() * listS.size());
            right = listS.get(index);
            listS.clear();
            Log.i(TAG, "Right word " + right);

            int max = (int) (Math.random() * right.length());

            String cut = right.substring(0,max);


            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < (right.length()-max); i++) {
                builder.append("*");
            }
            String sfinal = cut+builder.toString();
            semi.setText(sfinal);
            builder.setLength(0);

        }


        if(certo == 1){

        }

    }

    //Função do botão a verificar se está certo
    public void chkifright (View view){

        eTextAttempt = attempt.getText().toString();
        Log.i(TAG, "chkifright: try is " + eTextAttempt);


        if (eTextAttempt.equals(right)) {//Se certo
            certo = 0;//Mete a variavel de certo a 0
            scoreround = (1000 / nTrys); //calcula o score

            Log.i(TAG, "chkifright: score is " + scoreround);
            eTextAttempt = "";

            //muda a palavra e segue jogo
            Intent intent = getIntent();
            finish();
            startActivity(intent);

        }
        else { //Se errado
            nTrys +=1;// adicionar +1 nas variaveis de erro

            //se a varialvel erro < 5
        //dar clean no editext
        //e tenta de novo toast
        //se a variavel erro > 5

        //fazer intent para a class lastround
        //toast está dificil
        //passar o score e o user
        //passar a palavra
        }
    }

    public void imgone (View view){

        Intent letmego = new Intent(this, Final.class);
        letmego.putExtra("player",player);
        startActivity(letmego);
    }


}
