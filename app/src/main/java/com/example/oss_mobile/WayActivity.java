package com.example.oss_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class WayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_way);

        getSupportActionBar().setIcon(R.drawable.icon2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        List<ExerciseData> exerciseList = new ArrayList<>();
        //1.푸쉬업
        exerciseList.add(new ExerciseData(R.drawable.pushup, "푸쉬업", "대흉근(가슴)","1. 복부부터 다리까지 일자로 고정되도록 복부에 힘을 준다.\n" +
                "2. 호흡을 마시면서 가슴을 바닥과 내려간다.\n3. 호흡을 뱉으면서 겨드랑이쪽에 힘을 주고 올라온다.","10-15회(5세트)", "내로우 푸쉬업, 와이드 푸쉬업"));
        //2.벤치프레스
        exerciseList.add(new ExerciseData(R.drawable.bench_press, "벤치 프레스", "대흉근(가슴)", "1.자신에게 맞는 바벨 무게를 선택한다.\n" +
                "2. 바벨을 어깨보다 약간 넓게 잡고, 견갑골을 벤치에 고정시킨다.\n3. 팔을 직선으로 곧게 뻗어 바벨을 밀어준다는 느낌으로 올린다.\n" +
                "4. 그대로 팔을 뒤로 굽혀 가슴에 닿기 직전까지 깊게 바벨을 끌어당긴다.","10-12회(3세트)", "인클라인 벤치프레스, 디클라인 벤치프레스"));
        //3.풀업
        exerciseList.add(new ExerciseData(R.drawable.pullup, "풀업(턱걸이)", "광배근(등), 이두근/삼두근(팔)", "1. 어깨너비보다 약간 넓게 바를 잡고, 복부에 힘을 줘서 무릎을 살짝 굽혀준다.\n" +
                "2. 가슴을 바에 붙이는 느낌으로 위로 몸을 들어올린다.\n3. 최고점까지 올라가 숨을 뱉고, 등 근육의 자극을 준다.\n4. 숨을 들이마시면서 몸을 내리고, 팔을 다 펼때까지 등 근육의 힘을 유지한다.",
                "10-15회", "친업, 패러럴 그립 풀업"));
        //4.크런치
        exerciseList.add(new ExerciseData(R.drawable.crunch, "크런치", "복부", "1. 바닥에 등을 대고 눕고 무릎을 굽혀서 발바닥을 바닥에 댄다.\n2. 두 손은 가슴에 올리거나 머리 뒤에 댄다.\n" +
                "3. 등의 아랫부분을 바닥에서 떼지 말고 견갑골을 바닥에서 들어올린다는 느낌으로 복부를 강하게 쥐어짠다.\n4. 상체를 일으키기 전 숨을 들이마시고, 일으키면서 숨을 내쉬고 최고점에서 완전히 숨을 다 뱉는다.\n" +
                "5. 시작 자세로 내려오면서 숨을 들이 마신다.","10-20회(3-5세트)", "V 크런치, 바이시클 크런치"));
        //5.플랭크
        exerciseList.add(new ExerciseData(R.drawable.plank, "플랭크", "복부, 허리, 엉덩이, 허벅지 뒤", "1. 엎드려 팔꿈치 간격은 어깨너비 정도로 벌린다.\n" +
                "2. 시선은 아래를 바라보고, 몸을 지면과 수평하게 유지한다.\n3. 견갑골 모양이 약간 둥글어질때까지 어깨로 지면을 밀어준다.\n4. 복부와 엉덩이에 힘을 주고 버틴다.",
                "30-60초(5세트)", "플랭크 업다운, 플랭크 잭"));
        //6.런지
        exerciseList.add(new ExerciseData(R.drawable.lunge, "런지", "대퇴사두근(허벅지), 대둔근(엉덩이)", "1. 앞발에 무게중심을 두고 발을 뒤로 빼며 앉는다.\n" +
                "2. 앞다리 엉덩이가 뒤로 빠지듯 앉으며 뒷다리는 무릎이 바닥과 가깝도록 앉는다.\n3. 앉은 상태에서 버티며 유지한다.","12-15회(3-4세트)", "리버스 런지, 프론트 런지, 사이드 런지"));
        //7.스쿼트
        exerciseList.add(new ExerciseData(R.drawable.squat, "스쿼트", "대퇴사두근(허벅지), 대둔근(엉덩이)", "1. 다리를 어깨넓이만큼 벌리고 양팔을 앞으로 모아준다.\n" +
                "2. 허리는 피고, 엉덩이는 살짝 내밀고 발끝보다 무릎이 나가지 않을만큼 무릎을 굽혀준다.\n3. 호흡은 앉으면서 들이쉬고 일어서면서 내뱉는다.",
                "10-15회(3세트)", "점프 스쿼트, 스모 스쿼트"));
        //8.레그프레스
        exerciseList.add(new ExerciseData(R.drawable.leg_press, "레그 프레스", "대퇴사두근(허벅지)", "1. 자신이 원하는 중량을 선택하고, 등을 등받이에 기대고 앉아 발판에 발을 올린다.\n" +
                "2. 양 발의 너비는 자신의 어깨너비 기준으로 벌려서 앉고, 양쪽 발과 무릎 간격을 동일하게 유지한다.\n3. 호흡을 내쉬면서 무릎이 다 펴지기 전까지 천천히 밀어준다.\n" +
                "4. 호흡을 들이마시면서 무릎을 90도에 가깝게 구부린다.","10-15회(3세트)", "자극시키고 싶은 부위에 따라 발의 위치를 바꾼다"));
        //9.데드리프트
        exerciseList.add(new ExerciseData(R.drawable.deadlift, "데드 리프트", "둔근, 대둔근(엉덩이), 햄스트링(허벅지 뒤쪽), 기립근, 대퇴사두(허벅지 앞쪽)",
                "1. 바벨의 정중앙에 서고, 정강이에서 약 2cm 떨어진 곳에 바벨을 놓는다.\n 2. 그립은 어깨너비 정도로 잡는다.\n" +
                        "3. 시선은 아래 사선방향으로 보고 척추가 일직선이 되도록 자세를 잡고 복부에 힘을 유지한다.\n4.리프트 단계: 바벨을 하체의 힘으로 무릎위치까지 들어올린다.\n" +
                        "5.바벨이 무릎을 넘어가면 등의 힘으로 들어올린다.", "5회-10회(1세트)", "루마니안 데드 리프트, 스모 데드 리프트"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(exerciseList);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize((true));



        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration); //구분선 넣기
        //recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(10)); //여백 주기
    }
}