package com.example.android.lab09_include_merge;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by android on 2017/8/23.
 */

abstract public class QuestionActivity extends AppCompatActivity{

    protected TextView m_tv_no;
    protected TextView m_tv_question;
    protected RadioButton m_radio_a;
    protected RadioButton m_radio_b;
    protected RadioButton m_radio_c;

    protected CharSequence m_answer;

    protected Button m_btn_back;
    protected Button m_btn_next;

    protected static int sQuestionIndex;
    private Adapter adapter;
    public void setAdapter(Adapter adapter){
        this.adapter = adapter;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();
        setAdapter(new QuestionFromResource(this));
    }

    private void init() {

        m_tv_no = (TextView) findViewById(R.id.tv_no);
        m_tv_question = (TextView) findViewById(R.id.tv_question);
        m_radio_a = (RadioButton) findViewById(R.id.radio_a);
        m_radio_b = (RadioButton) findViewById(R.id.radio_b);
        m_radio_c = (RadioButton) findViewById(R.id.radio_c);

        m_btn_back = (Button)findViewById(R.id.btn_back);
        m_btn_next = (Button)findViewById(R.id.btn_next);

        m_tv_no.setText(String.valueOf(sQuestionIndex + 1));
        m_tv_question.setText(adapter.getQuestion(sQuestionIndex));
        m_radio_a.setText(adapter.getOptionA(sQuestionIndex));
        m_radio_b.setText(adapter.getOptionB(sQuestionIndex));
        m_radio_c.setText(adapter.getOptionC(sQuestionIndex));

    }

    public Spanned toHtmlString(int resId){
        return toHtmlString(getString(resId));
    }
    public Spanned toHtmlString(String s){
        Spanned result;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            result = Html.fromHtml(s,Html.FROM_HTML_MODE_LEGACY);
        }else {
            result = Html.fromHtml(s);
        }
        return result;
    }

    // 按下 BACK
    abstract public void back(View view);
    // 按下 NEXT
    abstract public void next(View view);

    public void click(View view) {
        m_answer = view.getTag().toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
    }

    @Override
    public void onBackPressed() {
        return;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

}
