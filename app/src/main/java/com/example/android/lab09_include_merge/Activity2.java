package com.example.android.lab09_include_merge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Activity2 extends QuestionActivity {

    public static final String Q2_ANSWER_KEY = "Q2";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        m_tv_no.setText("2");
    }


    // 按下 BACK
    public void back(View view) {
        // 建立新 Intent: new Intent( 來源 , 目的)
        Intent intent = new Intent(this, Activity1.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }

    // 按下 NEXT
    public void next(View view) {

        Intent q1Intent = getIntent(); // 取得 Activity1 或 Activity3 傳來的 Intent
        CharSequence q1Answer = q1Intent.getStringExtra(Activity1.Q1_ANSWER_KEY);
        CharSequence q2Answer = m_answer;

        // 建立新 Intent: new Intent( 來源 , 目的)
        Intent intent = new Intent(this, Activity3.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra(Activity1.Q1_ANSWER_KEY, q1Answer);
        intent.putExtra(Activity2.Q2_ANSWER_KEY, q2Answer);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
    }
}
