package com.example.bank_app.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_app.R;
import com.example.bank_app.dataAccess.models.User;
import com.example.bank_app.dataAccess.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {

    private EditText et_usuario, et_contraseña;
    private boolean init;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);

        et_usuario = (EditText)findViewById(R.id.txt_usuario);
        et_contraseña = (EditText)findViewById(R.id.txt_contraseña);

        init = false;
    }

    public void button(View view){
        if(!init){
            UserRepository.createUser(this, new User(100000,"default",1234));
            init = true;
        }
        String usuario = et_usuario.getText().toString();
        String contraseña = et_contraseña.getText().toString();
        if(!usuario.isEmpty() || !contraseña.isEmpty()){
            if(UserRepository.getUser(this, Integer.parseInt(usuario), Integer.parseInt(contraseña)).getId() != 0){
                Toast.makeText(this,"Felicidades!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,"Usuario o contraseña no registrados", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "Debes llenar los campos", Toast.LENGTH_SHORT).show();
        }
    }
}