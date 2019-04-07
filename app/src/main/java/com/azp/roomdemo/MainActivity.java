package com.azp.roomdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.azp.roomdemo.database.AppDatabase;
import com.azp.roomdemo.utils.DatabaseInitializer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_insert = findViewById(R.id.btn_add);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(MainActivity.this));
            }
        });
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
