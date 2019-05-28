package com.example.bank_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BusinessLogic extends AppCompatActivity {

    private EditText et_usuario, et_contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);

        et_usuario = (EditText)findViewById(R.id.txt_usuario);
        et_contraseña = (EditText)findViewById(R.id.txt_contraseña);

    }

    public void button(View view){
        DataAccess dbAccess = new DataAccess(this,"cuentas",null,1);
        SQLiteDatabase db = dbAccess.getReadableDatabase();

        String usuario = et_usuario.getText().toString();
        String contraseña = et_contraseña.getText().toString();

        if(!usuario.isEmpty() || !contraseña.isEmpty()){
            Cursor tupla = db.rawQuery("select contraseña from cuenta where usuario =" + contraseña,null);
            //Terminar la validación del usuario
        }else{
            Toast.makeText(this,"Debes llenar los campos", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}
