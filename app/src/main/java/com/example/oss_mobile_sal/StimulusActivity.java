package com.example.oss_mobile_sal;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class StimulusActivity extends AppCompatActivity {

    TextView saying;
    Random random = new Random();
    int rannum = random.nextInt(21);
    String[] wise = new String[100];

    LinearLayout back;
    int[] img = {R.drawable.image1 ,R.drawable.image2, R.drawable.image3, R.drawable.image5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stimulus);

        back = (LinearLayout)findViewById(R.id.layout);
        int num = random.nextInt(img.length);
        back.setBackgroundResource(img[num]);

        saying = findViewById(R.id.saying);

        wise[0] = "나를 배부르게 하는 것들이 나를 파괴한다";
        wise[1] = "먹어봤자 내가 아는 그맛이다";
        wise[2] = "살찌는 건 한순간, 빼는 건 피눈물";
        wise[3] = "땀은 지방이 흘리는 눈물이다";
        wise[4] = "간단하다 흔들리면 지방이다";
        wise[5] = "기억하라, 왜 다이어트를 시작했는지";
        wise[6] = "세상에서 가장 큰 거짓말, 다이어트는 내일부터";
        wise[7] = "최고의 적은 배신이 아닌, 바로 게으름이다";
        wise[8] = "오늘 걷지 않으면 내일 뛰어야한다";
        wise[9] = "먹을까 말까 고민이 된다면 먹지 마라";
        wise[10] = "내일의 나를 이기는 것만큼 벅찬 것은 없다";
        wise[11] = "옷을 몸에 맞추지 말고 몸을 옷에 맞춰라";
        wise[12] = "먹는데 1분 빼는데 1시간";
        wise[13] = "지금처럼 먹어서는 답이없다";
        wise[14] = "처먹지를 말던가 살쪘다고 징징거리지 말던가";
        wise[15] = "나약한 육체는 없다, 나약한 정신만 있을뿐";
        wise[16] = "나를 죽이지 못한 고통은 나를 더 성장 시킨다";
        wise[17] = "원하는 몸을 만들기 위해 지금의 몸을 부수자";
        wise[18] = "승리는 가장 끈기있는 자에게 돌아간다";
        wise[19] = "계속 노력해라! 지름길은 없다";
        wise[20] = "내가 꿈꾸던 나 그 모습 그대로 이루고 만다";
        wise[21] = "천천히 그리고 꾸준히";

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                saying.setText(wise[rannum]);
                rannum = random.nextInt(21);
            }
        };

        Timer timer = new Timer();
        timer.schedule(tt, 0, 2000);
    }

}
