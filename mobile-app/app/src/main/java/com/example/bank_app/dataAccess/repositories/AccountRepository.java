package com.example.bank_app.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.dataAccess.database.Database;
import com.example.bank_app.dataAccess.models.Account;
import com.example.bank_app.dataAccess.models.User;
public class AccountRepository {

    public static void createAccount(Context context, Account newAccount) {
        //Se llama a la db
        Database dbAccess = new Database(context, "accounts", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Se crea el registro que se va a ingresar
        ContentValues registro = new ContentValues();
        registro.put("number", newAccount.getAccountNumber());
        registro.put("balance", newAccount.getBalance());

        //Se inserta en la base de datos
        db.insert("account", null, registro);//En la tabla ACCOUNT!
        db.close();
    }

    public static Account getAccount(Context context, int accountNumber ){
        Account Account = new Account();// Usuario a retornar

        //Se llama a la base de datos
        Database dbAccess = new Database(context, "Accounts", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Atributos para hacer la consulta
        String[] columns = new String[]{"number","balance"}; //Columnas de la tabla
        String where = "accountNumber = ? ";//cláusula
        String[] whereValues = new String[]{Integer.toString(accountNumber)};// valores de la condición

        //Consulta per sé
        Cursor register = db.query("Account", columns, where, whereValues, null, null, null);

        //Si existe, retorne el usuario, y si no, retorna el usuario default
        if (register.moveToFirst()){
            Account.setAccountNumber(register.getInt(0));
            Account.setBalance(register.getFloat(1));

        }

        db.close();
        return Account;
    }

    public static int deleteAccount(Context context, int accountNumber){
        //Se llama a la base de datos
        Database dbAccess = new Database(context, "Accounts", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Atributos para la eliminación
        String where = "accountNumber = ?";//cláusula
        String[] whereValues = new String[]{Integer.toString(accountNumber)};// valores de la condición

        //Eliminación del registro, la función devuelve la cantidad de registros eliminados
        int deletedCant = db.delete("Account", where, whereValues);

        db.close();
        return deletedCant;
    }

    public static int modifyAccount(Context context, Account Account){
        //Se llama a la base de datos
        Database dbAccess = new Database(context, "Accounts", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Nuevos valores del registro
        ContentValues registro = new ContentValues();
        registro.put("number", Account.getAccountNumber());
        registro.put("balance", Account.getBalance());

        //Atributos para la Actualización
        String where = "number = ?";//cláusula
        String[] whereValues = new String[]{Integer.toString(Account.getAccountNumber())};// valores de la condición

        //Actualización del registro, la función devuelve la cantidad de registros actualizados
        int modifiedCant = db.update("Account", registro, where, whereValues);

        db.close();
        return modifiedCant;

    }


    public static Account getAccountFromUser(Context context, User user){
        Account Account = new Account();// Usuario a retornar

        //Se llama a la base de datos
        Database dbAccess = new Database(context, "Accounts", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Atributos para hacer la consulta
        String[] columns = new String[]{"number","balance"}; //Columnas de la tabla
        String where = "id_user = ? ";//cláusula
        String[] whereValues = new String[]{Integer.toString(user.getId())};// valores de la condición

        //Consulta per sé
        Cursor register = db.query("Account JOIN User", columns, where, whereValues, null, null, null);

        //Si existe, retorne el usuario, y si no, retorna el usuario default
        if (register.moveToFirst()){
            Account.setAccountNumber(register.getInt(0));
            Account.setBalance(register.getFloat(1));

        }

        db.close();
        return Account;
    }
}
