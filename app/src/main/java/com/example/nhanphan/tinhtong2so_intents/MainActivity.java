package com.example.nhanphan.tinhtong2so_intents;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText a,b;
    Button btn, btnTru , btnNhan , btnChia;
    TextView txtTong;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       try {
           if (requestCode == 101 && resultCode == Activity.RESULT_OK){
            // Bundle: import android.os.Bundle;
               Bundle myResultBundle = data.getExtras();
               Double myResult= myResultBundle.getDouble("ketQua");
                txtTong.setText("Kết quả = " + myResult);
           }
       }
       catch (Exception ex){
           txtTong.setText("Van de: " + requestCode + " " + resultCode);
       }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       a = (EditText) findViewById(R.id.edNhap1);
       b = (EditText) findViewById(R.id.edNhap2);
       btn = (Button) findViewById(R.id.btCong);
        btnTru = (Button) findViewById(R.id.btTru);
        btnNhan = (Button) findViewById(R.id.btNhan);
        btnChia = (Button) findViewById(R.id.btChia);
       txtTong = (TextView) findViewById(R.id.txtTong);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               double soA = Double.parseDouble(a.getText().toString());
               double soB = Double.parseDouble(b.getText().toString());
               Intent intent = new Intent(MainActivity.this, Second.class);
             //  Bundle bundle = new Bundle();
              Bundle bundle = new Bundle();
              bundle.putDouble("soA",soA);
              bundle.putDouble("soB",soB);
               intent.putExtras(bundle);
               startActivityForResult (intent,101);
               //startActivityForResult(Intent intent , int requestcode) thêm hàm thư viện này
           }
       });
       btnTru.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               double soA = Double.parseDouble(a.getText().toString());
               double soB = Double.parseDouble(b.getText().toString());
               Intent intent = new Intent(MainActivity.this, Tru.class);
               //  Bundle bundle = new Bundle();
               Bundle bundle = new Bundle();
               bundle.putDouble("soA",soA);
               bundle.putDouble("soB",soB);

               intent.putExtras(bundle);
               startActivityForResult (intent,101);
               //startActivityForResult(Intent intent , int requestcode) thêm hàm thư viện này
           }
       });
       btnNhan.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               double soA = Double.parseDouble(a.getText().toString());
               double soB = Double.parseDouble(b.getText().toString());
               Intent intent = new Intent(MainActivity.this, Nhan.class);

               //  Bundle bundle = new Bundle();
               Bundle bundle = new Bundle();
               bundle.putDouble("soA",soA);
               bundle.putDouble("soB",soB);

               intent.putExtras(bundle);
               startActivityForResult (intent,101);
               //startActivityForResult(Intent intent , int requestcode) thêm hàm thư viện này
           }
       });
       btnChia.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               double soA = Double.parseDouble(a.getText().toString());
               double soB = Double.parseDouble(b.getText().toString());
               Intent intent = new Intent(MainActivity.this, Chia.class);
                if ( soB ==0)
                {
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Lỗi").setMessage("Số B không được = 0")
                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                    builder.show();
                }else {
                    //  Bundle bundle = new Bundle();
                    Bundle bundle = new Bundle();
                    bundle.putDouble("soA", soA);
                    bundle.putDouble("soB", soB);

                    intent.putExtras(bundle);
                    startActivityForResult(intent, 101);
                    //startActivityForResult(Intent intent , int requestcode) thêm hàm thư viện này
                }
           }
       });
    }
}
