package com.example.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String TAG = "StartActivity";

    private Integer count = 5;

    // Вызывается при создании Активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализация Активности
        Log.d(TAG, "onCreate");
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
    }

    // Вызывается, когда Активность стала видимой
    @Override
    protected void onStart() {
        super.onStart();
        // Проделать необходимые действия для
        // Активности, видимой на экране
        Log.d(TAG, "onStart");
        resetUI();
        Toast.makeText(this, "onStart()", Toast.LENGTH_LONG).show();
    }

    // Должен вызываться в начале видимого состояния.
    // На самом деле Android вызывает данный обработчик только
    // для Активностей, восстановленных из неактивного состояния
    @Override
    protected void onResume() {
        super.onResume();
        // Восстановить приостановленные обновления UI,
        // потоки и процессы, замороженные, когда
        // Активность была в неактивном состоянии
        Log.d(TAG, "onResume");
        Toast.makeText(this, "onResume()", Toast.LENGTH_LONG).show();
    }

    // Вызывается перед выходом из активного состояния
    @Override
    protected void onPause() {
        // «Заморозить» обновления UI, потоки или
        // «трудоемкие» процессы, не нужные, когда Активность
        // не на переднем плане
        super.onPause();
        Log.d(TAG, "onPause");
        Toast.makeText(this, "onPause()", Toast.LENGTH_LONG).show();
    }

    // Вызывается перед выходом из видимого состояния
    @Override
    protected void onStop() {
        // «Заморозить» обновления UI, потоки или
        // «трудоемкие» процессы, ненужные, когда Активность
        // не на переднем плане.
        // Сохранить все данные и изменения в UI, так как
        // процесс может быть в любой момент убит системой
        super.onStop();
        Log.d(TAG, "onStop");
        Toast.makeText(this, "onStop()", Toast.LENGTH_LONG).show();
    }

    // Вызывается перед тем, как Активность снова становится видимой
    @Override
    protected void onRestart() {
        super.onRestart();
        // Восстановить состояние UI с учетом того,
        // что данная Активность уже была видимой.
        Log.d(TAG, "onRestart");
        Toast.makeText(this, "onRestart()", Toast.LENGTH_LONG).show();
    }

    // Вызывается перед уничтожением активности
    @Override
    protected void onDestroy() {
        // Освободить все ресурсы, включая работающие потоки,
        // соединения с БД и т. д.
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_LONG).show();
    }

    // Вызывается перед выходом из активного состояния,
    // позволяя сохранить состояние в объекте savedInstanceState
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Объект savedInstanceState будет в последующем
        // передан методам onCreate и onRestoreInstanceState
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
        Log.d(TAG, "onSaveInstanceState");
        Toast.makeText(this, "onSaveInstanceState()", Toast.LENGTH_LONG).show();
    }

    // Вызывается после завершения метода onCreate
    // Используется для восстановления состояния UI
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Восстановление состояние UI из объекта savedInstanceState.
        // Данный объект также был передан методу onCreate.
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("count")) {
            count = savedInstanceState.getInt("count");
        }
        Log.d(TAG, "onRestoreInstanceState");
        Toast.makeText(this, "onRestoreInstanceState()", Toast.LENGTH_LONG).show();
    }

    private void resetUI() {
        ((TextView) findViewById(R.id.txt_counter)).setText(count.toString());
        Log.d(TAG, "resetUI");
    }


}
