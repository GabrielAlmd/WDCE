package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.os.Bundle;

public class FristRound extends Activity {

    //Criar variável que verifica se ele acertou ou não 0 - acertou / 1 - Errou
    //Variavel que guarda o que escreve na texview
    //valor do score feito
    //receber o user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist_round);

        //se 0
        // Defenir a texview

        //Se 1
        // manter o que estava
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
