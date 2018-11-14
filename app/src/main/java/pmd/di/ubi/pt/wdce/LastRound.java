package pmd.di.ubi.pt.wdce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LastRound extends AppCompatActivity {

    //variavel para a palavra
    //variavel para o user
    //variavel para o score
    //variavel de tentativas começa as 5
    //variavel 0/1 para detetar (começa a 1)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_round);

        //recever a palavra e por no textview

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
