package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import static android.content.ContentValues.TAG;

public class Final extends Activity {

    TextView userid;
    TextView Total;
    TextView userlevel;

    DatabaseHelper db;

    String player;  //variavel user
    int scoreTotal; //variavel score


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        Intent playerID = getIntent();
        Bundle extras = playerID.getExtras();
        player = Objects.requireNonNull(extras).getString("player");
        scoreTotal = Objects.requireNonNull(extras).getInt("scoregame");
        Log.i(TAG, "UserProvider ID: " + player + " => Final.class");

        userid = (TextView) findViewById(R.id.userid);
        Total = (TextView) findViewById(R.id.totalScore);
        userlevel = (TextView) findViewById(R.id.userlevel);


        userid.setText(player);
        Total.setText("Pontos : "+ scoreTotal);
        //definir nivel

    }


    public void lestgoagain (View view){//Função vamos de novo
        Intent again = new Intent(this, FristRound.class);
        Bundle bundle = new Bundle();
        bundle.putString("player",player);
        bundle.putInt("scoregame",scoreTotal);
        again.putExtras(bundle);
        startActivity(again);
    }


    public void closeall (View view){//Funçao fechar por completo

        Toast.makeText(getApplicationContext(), "ADEUS !!", Toast.LENGTH_SHORT).show();
        finishAffinity();
        finish();
    }

    public void showrank (View view){

        Intent torank = new Intent(this, Rank.class);
        torank.putExtra("player", player);
        startActivity(torank);
    }
    /*
    private void UserLevel(String player) {

        Cursor cursor = db.getLevelUser(player);

        if(cursor.getCount() == 0){
            Toast.makeText(this, "Não consegui ir buscar dados!!", Toast.LENGTH_SHORT).show();
        }else{
            String text = "Nível atual : " + Integer.parseInt(cursor.getString(0));
            userlevel.setText(text);
        }
    }

    private void UserScore(String player) {
        Cursor cursor = db.getScoreUser(player);

        if(cursor.getCount() == 0){
            Toast.makeText(this, "Não consegui ir buscar dados!!", Toast.LENGTH_SHORT).show();
        }else{
            String text = "Potos coletados : " + Integer.parseInt(cursor.getString(0));
            userlevel.setText(text);
        }

    }*/

}
