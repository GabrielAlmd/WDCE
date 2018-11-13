package pmd.di.ubi.pt.wdce;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends Activity {

    DatabaseHelper db;
    EditText eEmail, eUser, ePass, eCPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        db = new DatabaseHelper(this);

        eEmail = (EditText) findViewById(R.id.email);
        eUser = (EditText) findViewById(R.id.username);
        ePass = (EditText) findViewById(R.id.pass);
        eCPass = (EditText) findViewById(R.id.cpass);
    }

    public void addRegist (View view){

        //Buscar input
        String s1 = eEmail.getText().toString();
        String s2 = eUser.getText().toString();
        String s3 = ePass.getText().toString();
        String s4 = eCPass.getText().toString();


        //check equals
        if(s1.equals("")||s2.equals("")|| s3.equals("") || s4.equals(""))
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
        else {
            if(s3.equals(s4)){
                Boolean chkuser = db.chkuser(s2);
                Boolean chkmail = db.chkemail(s1);
                if(chkmail == true && chkuser == true){
                    Boolean insert = db.insert(s1,s2,s3);
                    if (insert == true){
                        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                        super.finish();
                    }
                }
                else {
                    if(chkmail == false)
                        Toast.makeText(getApplicationContext(), "Email Already exists", Toast.LENGTH_SHORT).show();
                    if(chkuser == false)
                        Toast.makeText(getApplicationContext(), "User Already exists", Toast.LENGTH_SHORT).show();
                }

            }
            else
                Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
        }
    }



    public void takeMeBack (View view){
        super.finish();
        Toast.makeText(getApplicationContext(), "YOU FORGOT YOURSELF TO REGISTER !!", Toast.LENGTH_SHORT).show();
    }
}
