
package org.techtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

import org.techtown.myapplication.MainActivity2;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;  //  날짜를 선택하는 달력
    TextView viewDatePick;  //  선택한 날짜를 보여주는 textView
    String data; // intent로 넘겨줄 값
    TextView weightview;
    // String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("살뺄라그램");

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
            return "몸무게:"+data[0]+"Kg  " +"/"+ "  소모 칼로리:"+data[1]+ "Kcal  "+  "/" + "         소모 칼로리:"+data[2]+ "Kcal";
        }
        catch (Exception e) {
            return "";
        }
    }
}
