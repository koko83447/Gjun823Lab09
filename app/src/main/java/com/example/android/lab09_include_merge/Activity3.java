package com.example.android.lab09_include_merge;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

public class Activity3 extends QuestionActivity {
    public static final String Q3_ANSWER_KEY = "Q3";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        m_tv_no.setText("3");
        m_btn_next.setText("MAIN");
    }

    // 按下 BACK
    public void back(View view) {
        // 建立新 Intent: new Intent( 來源 , 目的)
        Intent intent = new Intent(this, Activity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void next(View view) {
        //Intent intent = new Intent(this, MainActivity.class);

        Intent q2Intent = getIntent(); // 取得 Activity1 傳來的 Intent
        CharSequence q1Answer = q2Intent.getStringExtra(Activity1.Q1_ANSWER_KEY);
        CharSequence q2Answer = q2Intent.getStringExtra(Activity2.Q2_ANSWER_KEY);
        CharSequence q3Answer = m_answer;
        //String answers = q1Answer + "\n" + q2Answer + "\n" + q3Answer;
        //m_tv_no.setText(answers); // 暫時將答案顯示在 TextView
        StringBuilder message = new StringBuilder(100); // 初始容量 100 字
        message.append("您的作答如下\n")
                .append(q1Answer)
                .append("\n")
                .append(q2Answer)
                .append("\n")
                .append(q3Answer)
                .append("\n確定要結束?");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("Yes", new PositiveButton小幫手())
                .setNegativeButton("No", new NegativeButton小幫手())
                .show();
    }

    // 處理按下對話框的 Yes 按鈕
    private class PositiveButton小幫手 implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // 切換到主畫面
            Intent intent = new Intent(Activity3.this, MainActivity.class);
            // 清空所有堆疊裡的 Activity
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }
    }

    // 處理按下對話框的 No 按鈕
    private class NegativeButton小幫手 implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            // 沒有想要做什麼 就空著吧
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
    }


}
