package com.example.android.lab09_include_merge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity1 extends QuestionActivity {

    public static final String Q1_ANSWER_KEY = "Q1";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        m_tv_no.setText("1");
        m_btn_back.setVisibility(Button.GONE);
    }


    @Override
    public void back(View view) {

    }

    // 按下 NEXT
    public void next(View view) {

        // 建立新 Intent: new Intent( 來源 , 目的)
        Intent intent = new Intent(this, Activity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra(Q1_ANSWER_KEY, m_answer);
        startActivity(intent);
    }

}
