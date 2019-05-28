package com.example.bank_app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BusinessLogic extends AppCompatActivity {

    private EditText et_usuario, et_contraseña;
    private boolean init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);

        et_usuario = (EditText)findViewById(R.id.txt_usuario);
        et_contraseña = (EditText)findViewById(R.id.txt_contraseña);

        init = false;
    }

    public void button(View view){
        DataAccess dbAccess = new DataAccess(this,"cuentas",null,1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        if(init==false){
            ContentValues registro = new ContentValues();
            registro.put("usuario","default");
            registro.put("contraseña","123");

            db.insert("cuenta",null,registro);
            init = true;
        }
        String usuario = et_usuario.getText().toString();
        String contraseña = et_contraseña.getText().toString();

        if(!usuario.isEmpty() || !contraseña.isEmpty()){
            Cursor tupla = db.rawQuery("select usuario from cuenta where contraseña =" + contraseña,null);
            //Terminar la validación del usuario
            if(tupla.moveToFirst()){
                Toast.makeText(this,"Felicidades!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,"Usuario o contraseña no registrados", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Debes llenar los campos", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}