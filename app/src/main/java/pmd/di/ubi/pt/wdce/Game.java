package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Game extends Activity {

    //Guardar o user do intento anterior e passar para a proxima atividade

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    //função para o butão começar
}
