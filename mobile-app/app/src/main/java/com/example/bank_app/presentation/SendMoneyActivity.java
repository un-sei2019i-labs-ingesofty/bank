package com.example.bank_app.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_app.R;
import com.example.bank_app.businessLogic.SendMoneyController;
import com.example.bank_app.dataAccess.models.User;

public class SendMoneyActivity extends AppCompatActivity {

    private EditText et_destino, et_monto;
    User usuario1;

    public SendMoneyActivity(User usuario){
        usuario1 = usuario;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendmoneylayout);

        et_destino = (EditText)findViewById(R.id.txt_destino);
        et_monto = (EditText)findViewById(R.id.txt_monto);
    }

    public void sendButton(View view){
        String destino = et_destino.getText().toString();
        String monto = et_monto.getText().toString();
        if(!destino.isEmpty() || !monto.isEmpty()){
            SendMoneyController.sendMoney(Integer.parseInt(destino), Float.parseFloat(monto), usuario1);
        }else {
            Toast.makeText(this, "Debes llenar los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
