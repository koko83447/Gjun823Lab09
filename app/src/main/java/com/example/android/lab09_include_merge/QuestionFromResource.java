package com.example.android.lab09_include_merge;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;

/**
 * Created by android on 2017/8/23.
 */

public class QuestionFromResource implements Adapter{

    private Activity activity;

    public QuestionFromResource(Activity activity){
        this.activity = activity;
    }

    public Spanned toHtmlString(int resId){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return Html.fromHtml(activity.getString(resId),Html.FROM_HTML_MODE_LEGACY);
        }else {
            return Html.fromHtml(activity.getString(resId));
        }
    }

    @Override
    public CharSequence getQuestion(int index){
        switch (index){
            case 0:
                return toHtmlString(R.string.question_1);
            case 1:
                return toHtmlString(R.string.question_2);
            case 2:
                return toHtmlString(R.string.question_3);
        }
        return null;
    }

    @Override
    public CharSequence getOptionA(int index) {
        switch (index) {
            case 0:
                return toHtmlString(R.string.question_1_radio_a);
            case 1:
                return toHtmlString(R.string.question_2_radio_a);
            case 2:
                return toHtmlString(R.string.question_3_radio_a);
        }
        return null;
    }

    @Override
    public CharSequence getOptionB(int index) {
        switch (index) {
            case 0:
                return toHtmlString(R.string.question_1_radio_b);
            case 1:
                return toHtmlString(R.string.question_2_radio_b);
            case 2:
                return toHtmlString(R.string.question_3_radio_b);
        }
        return null;
    }

    @Override
    public CharSequence getOptionC(int index) {
        switch (index) {
            case 0:
                return toHtmlString(R.string.question_1_radio_c);
            case 1:
                return toHtmlString(R.string.question_2_radio_c);
            case 2:
                return toHtmlString(R.string.question_3_radio_c);
        }
        return null;
    }
}
