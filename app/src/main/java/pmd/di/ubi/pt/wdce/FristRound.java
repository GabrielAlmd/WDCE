package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.FileNotFoundException;

import static android.content.ContentValues.TAG;

public class FristRound extends Activity {

    TextView semi;

    RandomWord r;

    int certo = 0; //0 - acertou / 1 - Errou
    String fWord;// full word

    //valor do score feito
    String player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist_round);

        semi = findViewById(R.id.semi);

        //Recebe o user id
        Intent playerID = getIntent();
        Bundle extras = playerID.getExtras();
        player = extras.getString("player");
        Log.i(TAG, "User ID: " + player + " => FristRound.class");

        if(certo == 0){
            // Defenir a texview
            /*
            try {
                fWord = r.selectRadomWordFromFile();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            semi.setText(fWord);*/
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
