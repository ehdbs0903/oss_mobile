package org.techtown.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.material.textfield.TextInputEditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity2 extends AppCompatActivity {
    EditText edtWeight;
    EditText edtKcal;
    EditText edtKcal2;
    EditText edtMemo;// 쓰기,
    Button btnSave;   //  저장, 수정버튼
    TextView Weight;
    Button calendar;
    String fileName;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("살뺄라그램");

        edtWeight = findViewById(R.id.edtWeight);
        edtKcal = findViewById(R.id.edtKcal);
        edtKcal2 = findViewById(R.id.edtKcal2);
        edtMemo = findViewById(R.id.edtMemo);
        btnSave = findViewById(R.id.btnSave);
        Weight = findViewById(R.id.Weight);
        calendar = findViewById(R.id.calendar);


        Intent intent = getIntent();
        processIntent(intent);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { saveDiary(fileName); }

        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 다시 뒤의 화면으로 돌아감
            }
        });
    }

    private void processIntent(Intent intent){
        if(intent != null){
            data = intent.getStringExtra("data");
            Log.d("data", "data= "+data);
            if(intent != null){
                checkedDay(data);
            }
        }
    }

    //파일 읽기
    private void checkedDay(String day) {
        String[] dateArr = day.split("/");
        int year = Integer.parseInt(dateArr[0]);
        int monthOfYear = Integer.parseInt(dateArr[1]);
        int dayOfMonth = Integer.parseInt(dateArr[2]);

        fileName = year + "" + monthOfYear + "" + dayOfMonth + ".txt";

        // 읽어봐서 읽어지면
        // 없으면 catch로 처리
        FileInputStream fis = null;
        try {
            fis = openFileInput(fileName);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            String str = new String(fileData, "EUC-KR");
            Toast.makeText(getApplicationContext(), "이미 등록됨", Toast.LENGTH_SHORT).show();
            String[] data = str.split("/");
            edtWeight.setText(data[0]);
            edtKcal.setText(data[1]);
            edtKcal2.setText(data[2]);
            edtMemo.setText(data[3]);
            btnSave.setText("수정하기"); // 일기 써둔게 있다면 수정하기로 버튼이 바뀐다.
        }
        catch (Exception e) {
            // 없어서 오류가 나면 내용이 없는 것.
            Toast.makeText(getApplicationContext(), "입력되지 않은 날", Toast.LENGTH_SHORT).show();
            edtWeight.setText("");
            btnSave.setText("등 록");
            e.printStackTrace();
        }

    }

    // 저장
    private void saveDiary(String readDay) {

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(readDay, Context.MODE_PRIVATE);
            String content = edtWeight.getText().toString();

            String kcal = edtKcal.getText().toString();

            String kcal2= edtKcal2.getText().toString();

            String memo = edtMemo.getText().toString();

            content = content + '/' + kcal + '/' + kcal2 + '/' + memo;
            fos.write(content.getBytes());
            fos.close();

            Toast.makeText(getApplicationContext(), "등록됨", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "오류오류", Toast.LENGTH_SHORT).show();
        }
    }

}





