package com.example.android.lab09_include_merge;

/**
 * Created by android on 2017/8/23.
 */

public interface Adapter {
    CharSequence getQuestion(int index);
    CharSequence getOptionA(int index);
    CharSequence getOptionB(int index);
    CharSequence getOptionC(int index);
}
