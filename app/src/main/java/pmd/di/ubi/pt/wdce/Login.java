package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class Login extends Activity {

    EditText eUser, ePass;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        eUser = findViewById(R.id.user);
        ePass = findViewById(R.id.pass);
        

    }

    public void singIn (View view){
        Intent getMeSing = new Intent(this, Signin.class);
        startActivity(getMeSing);

    }

    public void letsGo (View view){

        String user = eUser.getText().toString();
        String pass = ePass.getText().toString();

        //check user and password
        Boolean chkmatch = db.match(user,pass);
        if(chkmatch == true){

            Intent getMeGoing = new Intent(this, Game.class);
            getMeGoing.putExtra("player",user);
            startActivity(getMeGoing);

            Log.i(TAG, "letsGo: " + user);

            Toast.makeText(getApplicationContext(), "Successfully LogIn", Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(getApplicationContext(), "Wrong user or password", Toast.LENGTH_SHORT).show();

    }
}
