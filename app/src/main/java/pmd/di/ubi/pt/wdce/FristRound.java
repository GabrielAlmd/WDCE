package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.Object.*;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class FristRound extends Activity {

    TextView semi;

    String right = "";
    String line="";

    int certo = 0; //0 - acertou / 1 - Errou

    //valor do score feito
    String player = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist_round);

        semi = findViewById(R.id.semi);

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
            // manter o que estava
        }

    }

    //Função do botão a verificar se está certo


        //variavel para contar as vezes de erro

        //Se certo
            //Mete a variavel de certo a 0
            //calcula o score

        //Se errado

            //adicionar +1 nas variaveis de erro
            //se a varialvel erro < 5
                //dar clean no editext
                //e tenta de novo toast
            //se a variavel erro > 5

                //fazer intent para a class lastround
                //toast está dificil
                //passar o score e o user
                //passar a palavra
}
