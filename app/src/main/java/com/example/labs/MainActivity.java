package com.example.labs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etId,etName,etEmail;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = (EditText) findViewById(R.id.idTextView);
        etName = (EditText) findViewById(R.id.nameTextView);
        etEmail = (EditText) findViewById(R.id.emailTextView);

        dbHelper = new DBHelper(this);

    }
    @Override
    public void onClick(View v)
    {
        String ID = etId.getText().toString();
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues(); // класс для добавления новых строк в таблицу

        switch (v.getId())
        {
            case R.id.addButton:
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_MAIL, email);
                database.insert(DBHelper.TABLE_PERSONS, null, contentValues);
                break;

            case R.id.readButton:
                Cursor cursor = database.query(DBHelper.TABLE_PERSONS, null, null, null,
                        null, null, null); // все поля без сортировки и группировки

                if (cursor.moveToFirst())
                {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
                    do {
                        Log.d("mLog", "ID =" + cursor.getInt(idIndex) +
                                ", name = " + cursor.getString(nameIndex) +
                                ", email = " + cursor.getString(emailIndex));

                    } while (cursor.moveToNext());
                } else
                    Log.d("mLog", "0 rows");

                cursor.close(); // освобождение памяти
                break;

            case R.id.clearButton:
                database.delete(DBHelper.TABLE_PERSONS, null, null);
                break;

            case R.id.deleteButton:
                if (ID.equalsIgnoreCase(""))
                {
                    break;
                }
                int delCount = database.delete(DBHelper.TABLE_PERSONS, DBHelper.KEY_ID + "= " + ID, null);
                Log.d("mLog", "Удалено строк = " + delCount);

            case R.id.updateButton:
                if (ID.equalsIgnoreCase(""))
                {
                    break;
                }
                contentValues.put(DBHelper.KEY_MAIL, email);
                contentValues.put(DBHelper.KEY_NAME, name);
                int updCount = database.update(DBHelper.TABLE_PERSONS, contentValues, DBHelper.KEY_ID + "= ?", new String[] {ID});
                Log.d("mLog", "Обновлено строк = " + updCount);
        }
        dbHelper.close(); // закрываем соединение с БД
    }
}