package com.example.bank_app.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.dataAccess.database.Database;
import com.example.bank_app.dataAccess.models.User;

public class UserRepository {

    public static void createUser(Context context, User newUser) {
        //Se llama a la db
        Database dbAccess = new Database(context, "users", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Se crea el registro que se va a ingresar
        ContentValues registro = new ContentValues();
        registro.put("id_user", newUser.getId());
        registro.put("name", newUser.getName());
        registro.put("password", newUser.getPassword());

        //Se inserta en la base de datos
        db.insert("user", null, registro);//En la tabla USER!
        db.close();
    }

    public static User getUser(Context context, int id_user, int password){
        User user = new User();// Usuario a retornar

        //Se llama a la base de datos
        Database dbAccess = new Database(context, "users", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Atributos para hacer la consulta
        String[] columns = new String[]{"id_user","password"}; //Columnas de la tabla
        String where = "id_user = ? AND password = ?";//cláusula
        String[] whereValues = new String[]{Integer.toString(id_user), Integer.toString(password)};// valores de la condición

        //Consulta per sé
        Cursor register = db.query("user", columns, where, whereValues, null, null, null);

        //Si existe, retorne el usuario, y si no, retorna el usuario default
        if (register.moveToFirst()){
            user.setId(register.getInt(0));
            user.setName(register.getString(1));
            user.setPassword(register.getInt(2));
        }

        db.close();
        return user;
    }

    public static int deleteUser(Context context, int id_user){
        //Se llama a la base de datos
        Database dbAccess = new Database(context, "users", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Atributos para la eliminación
        String where = "id_user = ?";//cláusula
        String[] whereValues = new String[]{Integer.toString(id_user)};// valores de la condición

        //Eliminación del registro, la función devuelve la cantidad de registros eliminados
        int deletedCant = db.delete("user", where, whereValues);

        db.close();
        return deletedCant;
    }

    public static int modifyUser(Context context, User user){
        //Se llama a la base de datos
        Database dbAccess = new Database(context, "users", null, 1);
        SQLiteDatabase db = dbAccess.getWritableDatabase();

        //Nuevos valores del registro
        ContentValues registro = new ContentValues();
        registro.put("id_user", user.getId());
        registro.put("name", user.getName());
        registro.put("password", user.getPassword());

        //Atributos para la Actualización
        String where = "id_user = ?";//cláusula
        String[] whereValues = new String[]{Integer.toString(user.getId())};// valores de la condición

        //Actualización del registro, la función devuelve la cantidad de registros actualizados
        int modifiedCant = db.update("user", registro, where, whereValues);

        db.close();
        return modifiedCant;
    }

}
