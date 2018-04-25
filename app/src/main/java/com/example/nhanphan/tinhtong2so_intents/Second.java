package com.example.nhanphan.tinhtong2so_intents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Second extends AppCompatActivity {

    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = (EditText) findViewById(R.id.edDuLieu);
        btn = (Button) findViewById(R.id.btBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent myCallerIntent = getIntent();
        Bundle mybundle =  myCallerIntent.getExtras();
        double soA = mybundle.getDouble("soA");
        double soB = mybundle.getDouble("soB");
        double kq = soA+soB;
        editText.setText("Dữ liệu nhận:\n" +
                "Số thứ 1: "+ soA  + "\nSố thứ 2: "+
                soB + "\n\nKết quả: "  + kq);
        mybundle.putDouble("ketQua",kq);
        myCallerIntent.putExtras(mybundle);
        setResult(Activity.RESULT_OK, myCallerIntent);
    }
}
