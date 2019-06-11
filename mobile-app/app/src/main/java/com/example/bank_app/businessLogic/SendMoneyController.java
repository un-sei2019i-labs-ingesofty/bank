package com.example.bank_app.businessLogic;



import android.content.Context;

import com.example.bank_app.dataAccess.models.Account;
import com.example.bank_app.dataAccess.models.User;

import static com.example.bank_app.dataAccess.repositories.AccountRepository.getAccount;
import static com.example.bank_app.dataAccess.repositories.AccountRepository.modifyAccount;

public class SendMoneyController {
    public static void sendMoney(Context context, int accountNumber, float balance, User usuario){

        Account acc2 = getAccount(context, accountNumber);
        Account acc1 = getAccountFromUser(context, usuario);







    }
}

