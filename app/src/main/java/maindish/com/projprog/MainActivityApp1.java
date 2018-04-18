package maindish.com.projprog;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityApp1 extends AppCompatActivity implements View.OnClickListener{

    EditText editTextEmail, editTextPass;
    Button buttonRegister, buttonSignIn;

    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app1);

        buttonRegister = (Button) findViewById(R.id.register_button);
        buttonSignIn = (Button) findViewById(R.id.signin_button);
        editTextEmail = (EditText) findViewById(R.id.login_email);
        editTextPass = (EditText) findViewById (R.id.login_password);

        buttonRegister.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) { //Si fos null vol dir que està tancant sessió
                    Log.i("SESION", "Sessió iniciada amb email: " + user.getEmail());
                }else{
                    Log.i("SESION", "Sessió tancada");
                }
            }
        };
    }

    private void registrar(String email, String pass){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("SESION", "Usuari creat correctament");
                }else{
                    Log.e("SESION", task.getException().getMessage()+"" );
                }

            }
        });
    }

    private void iniciarSesion(String email, String pass) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("SESION", "Sessió iniciada correctament");
                    //Inciem l'activitat aqui per en cas que ja estigui logged no faci log screen
                   //Intent i = new Intent(MainActivityApp1.this, GaleriaFragment.class);
                   //startActivity(i);
                    /*android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
                    GaleriaFragment galeria = new GaleriaFragment();
                    galeria.setStyle(DialogFragment.STYLE_NO_FRAME,R.style.transparente);
                    galeria.show(manager,"");*/
                    Intent List = new Intent(getApplicationContext(), GaleriaFragment.class);
                    startActivity(List);

                } else {
                    Log.e("SESION", task.getException().getMessage() + "");
                }

            }
        });
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.signin_button:
                String emailIn = editTextEmail.getText().toString();
                String passIn = editTextPass.getText().toString();
                iniciarSesion(emailIn, passIn);

                break;

            case R.id.register_button:
                String emailReg = editTextEmail.getText().toString();
                String passReg = editTextPass.getText().toString();
                registrar(emailReg, passReg);
                break;
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}
