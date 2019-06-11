package com.example.bank_app.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.dataAccess.database.Database;
import com.example.bank_app.dataAccess.models.Account;
import com.example.bank_app.dataAccess.models.Admin;
import com.example.bank_app.dataAccess.models.User;

public class AdminRepository {

    public static void createAdmin(Context context, Admin newAdmin) {
        //Se llama a la db
        Database dbAccess = new Database(context, "admins", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Se crea el registro que se va a ingresar
        ContentValues registro = new ContentValues();
        registro.put("id_admin", newAdmin.getId());
        registro.put("password", newAdmin.getPassword());

        //Se inserta en la base de datos
        db.insert("admin", null, registro);//En la tabla ADMIN!
        db.close();
    }

    public static Admin getAdmin(Context context, int id_admin, int password){
        Admin admin = new Admin();// Administrador a retornar

        //Se llama a la base de datos
        Database dbAccess = new Database(context, "admins", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Atributos para hacer la consulta
        String[] columns = new String[]{"id_admin","password"}; //Columnas de la tabla
        String where = "id_admin = ? AND password = ?";//cláusula
        String[] whereValues = new String[]{Integer.toString(id_admin), Integer.toString(password)};// valores de la condición

        //Consulta per sé
        Cursor register = db.query("admin", columns, where, whereValues, null, null, null);

        if (register.moveToFirst()){
            admin.setId(register.getInt(0));
            admin.setPassword(register.getString(1));
        }

        db.close();
        return admin;
    }


    public static int modifyAdmin(Context context, Admin admin){
        //Se llama a la base de datos
        Database dbAccess = new Database(context, "admins", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Nuevos valores del registro
        ContentValues registro = new ContentValues();
        registro.put("id_admin", admin.getId());
        registro.put("password", admin.getPassword());

        //Atributos para la Actualización
        String where = "id_admin = ?";//cláusula
        String[] whereValues = new String[]{Integer.toString(admin.getId())};// valores de la condición

        //Actualización del registro, la función devuelve la cantidad de registros actualizados
        int modifiedCant = db.update("admin", registro, where, whereValues);

        db.close();
        return modifiedCant;
    }


}
