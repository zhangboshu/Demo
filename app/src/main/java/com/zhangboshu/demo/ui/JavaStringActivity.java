package com.zhangboshu.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhangboshu.demo.R;

import java.util.ArrayList;
import java.util.List;

public class JavaStringActivity extends AppCompatActivity {

    private List<String> strList;
    private List<String> ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_string);

        initViews();
        initListStr();
    }

    private void initListStr() {
        String str = "b1,c1";
        String result = "";
        ok = new ArrayList<>();
        for (int i = 0; i < strList.size(); i++) {
            String back = strList.get(i);
            if (str.split(",").length == back.split(",").length - 1) {
                if (back.contains(str)) {
                    for (int j = 0; j < back.split(",").length; j++) {
                        if (str.contains(back.split(",")[j])) {
                            result += back.split(",")[j] + ",";
                        } else {
                            result += back.split(",")[j] + ",";
                        }
                    }
                }
            }
            if (!result.isEmpty()){
                ok.add(result.substring(0, result.length() - 1));
                result = "";
            }
        }
        for (int i = 0; i < ok.size(); i++) {
            Log.i("aaaaa", ok.get(i));
        }
    }

    private void initViews() {

        String str1 = "a1,b1,c1";
        String str2 = "a1,b1,c2";
        String str3 = "a1,b2,c1";
        String str4 = "a1,b2,c2";
        String str5 = "a2,b1,c1";
        String str6 = "a2,b1,c2";
        String str7 = "a2,b2,c1";
        String str8 = "a2,b2,c2";

        strList = new ArrayList<>();

        strList.add(str1);
        strList.add(str2);
        strList.add(str3);
        strList.add(str4);
        strList.add(str5);
        strList.add(str6);
        strList.add(str7);
        strList.add(str8);
    }

}
