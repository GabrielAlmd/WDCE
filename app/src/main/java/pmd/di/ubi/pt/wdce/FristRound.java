package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    String rightforpass ="";
    String line="";
    String eTextAttempt ="";
    String player = "";
    String sfinal = "";

    int scoreTotal;
    int certo = 0; //0 - acertou / 1 - Errou
    int scoreround; //valor do score feito
    int nTrys = 1;

    DatabaseHelper db;


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
        scoreTotal = Objects.requireNonNull(extras).getInt("scoregame");
        Log.i(TAG, "UserProvider ID: " + player + " => FristRound.class");

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
            rightforpass = right;
            listS.clear();

            //Aletrar a quantidade de letras a tirar
            Log.i(TAG, "Right word " + rightforpass);

            //int max = (int) (Math.random() * right.length()); //curtava de forma aleatória
            int max = right.length() - 3; // corta x letras da mesma

            String cut = right.substring(0,max);


            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < (right.length()-max); i++) {
                builder.append(" _ ");
            }
            sfinal = cut+builder.toString();

            semi.setText(sfinal);
            Log.i(TAG, "chkifright: o que mostra "+sfinal);
            builder.setLength(0);

        }

    }

    //Função do botão a verificar se está certo
    public void chkifright (View view){

        eTextAttempt = attempt.getText().toString();
        Log.i(TAG, "chkifright: try is " + eTextAttempt);


        if (eTextAttempt.equals(right)) {//Se certo
            certo = 0;//Mete a variavel de certo a 0
            scoreround = (1000 / nTrys); //calcula o score
            db = new DatabaseHelper(this);

            Log.i(TAG, "chkifright: score is " + scoreround);
            eTextAttempt = "";

            String toastText = "Fez " + scoreround +" pontos !!";
            scoreTotal +=  scoreround;
            Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT).show();


            //muda a palavra e segue jogo
            Intent intent = getIntent();
            intent.putExtra("scoregame",scoreTotal);
            finish();
            startActivity(intent);

        }
        else { //Se errado
            certo = 1;
            nTrys +=1;// adicionar +1 nas variaveis de erro

            Log.i(TAG, "chkifright: number of trys " + nTrys);

            if(nTrys <= 5) {//se a varialvel erro < 5
                attempt.getText().clear();//dar clean no editext
                Toast.makeText(getApplicationContext(), "TENTA DE NOVO!!", Toast.LENGTH_SHORT).show();
            }
            else{//se a variavel erro > 5

                //fazer intent para a class lastround
                Intent idonknow = new Intent(this, LastRound.class);
                Bundle bundle = new Bundle();
                bundle.putString("player",player);
                bundle.putString("word",right);
                bundle.putString("display",sfinal);
                bundle.putInt("scoregame",scoreTotal);
                idonknow.putExtras(bundle);
                startActivity(idonknow);
                Toast.makeText(getApplicationContext(), "Está difícil!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void imgone (View view){

        Intent letmego = new Intent(this, Final.class);
        Bundle bundle = new Bundle();
        bundle.putString("player",player);
        bundle.putInt("scoregame",scoreTotal);
        letmego.putExtras(bundle);
        startActivity(letmego);
    }


}
