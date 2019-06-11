package com.example.bank_app.businessLogic;



import android.content.Context;

import com.example.bank_app.dataAccess.models.Account;
import com.example.bank_app.dataAccess.models.User;

import static com.example.bank_app.dataAccess.repositories.AccountRepository.getAccount;
import static com.example.bank_app.dataAccess.repositories.AccountRepository.getAccountFromUser;
import static com.example.bank_app.dataAccess.repositories.AccountRepository.modifyAccount;

public class SendMoneyController {
    public static boolean sendMoney(Context context, int accountNumber, float balance, User usuario){

        Account acc2 = getAccount(context, accountNumber);
        Account acc1 = getAccountFromUser(context, usuario);
        if(acc2.getAccountNumber()==0){
            return false;//error()
        }
        if(acc1.getBalance()> balance ) {
            modifyAccount(context, acc2);
            modifyAccount(context, acc1);
            return true;
        }else {
            return false;//error()
        }

    }
}

