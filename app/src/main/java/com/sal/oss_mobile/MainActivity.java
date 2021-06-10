package com.sal.oss_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.FileInputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private long backKeyPressedTime = 0;
    private Toast toast;

    Button btnWeightChart, btnDietChart;
    Button btnStimulus, btnWay;

    DatePicker datePicker;  //  날짜를 선택하는 달력
    TextView viewDatePick;  //  선택한 날짜를 보여주는 textView
    String data; // intent로 넘겨줄 값
    TextView weightview;
    // String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.icon2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        datePicker = findViewById(R.id.datePicker);
        viewDatePick = findViewById(R.id.viewDatePick);
        weightview = findViewById(R.id.weightview);
        // weightview.setText("");

        //여기부터


        //여기까지


        // 오늘 날짜 받음
        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);
        int cMonth = c.get(Calendar.MONTH) + 1;
        int cDay = c.get(Calendar.DAY_OF_MONTH);

        data = cYear + "/" + cMonth + "/" + cDay;
        Log.d("data", "data1 = " + data);

        viewDatePick.setText(cYear + "/" + cMonth + "/" + cDay + "기록"); // textView에 오늘 날짜를 띄워준다.


        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                weightview.setText("");
                monthOfYear = monthOfYear + 1;
                data = year + "/" + monthOfYear + "/" + dayOfMonth;
                Log.d("data", "data1 = " + data);
                viewDatePick.setText(year + "/" + monthOfYear + "/" + dayOfMonth + "기록"); // textView에 오늘 날짜를 띄워준다.
                String fileName = Integer.toString(year) + Integer.toString(monthOfYear) + Integer.toString(dayOfMonth) + ".txt";
                String result = checkedDay(fileName);
                weightview.setText(result);
            }
        });

        Button button = findViewById(R.id.writeButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                Log.d("data", "send data = " + data);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });

        btnWeightChart = findViewById(R.id.btnBarChart);
        btnWeightChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, BarChartActivity.class);
                startActivity(I);
            }
        });

        btnStimulus = findViewById(R.id.btnStimulus);
        btnStimulus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, StimulusActivity.class);
                startActivity(I);
            }
        });

        btnWay = findViewById(R.id.btnWay);
        btnWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, WayActivity.class);
                startActivity(I);
            }
        });
    }

    private String checkedDay(String fileName) {
        // 읽어봐서 읽어지면 가져오고
        // 없으면 catch로 처리
        FileInputStream fis = null;
        try {
            fis = openFileInput(fileName);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            String str = new String(fileData, "EUC-KR");
            String[] data = str.split("/");
            return "몸무게:" + data[0] + "Kg  " + "/" + "  소모 칼로리:" + data[1] + "Kcal  " + "/" + "\n섭취 칼로리:" + data[2] + "Kcal";
        } catch (Exception e) {
            return "";
        }
    }

    public void onBackPressed(){
        if(System.currentTimeMillis()>backKeyPressedTime+2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
            toast.show();
            return;
        }
        else{
            ActivityCompat.finishAffinity(this);
        }
    }
}