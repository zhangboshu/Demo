package com.zhangboshu.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zhangboshu.demo.R;
import com.zhangboshu.demo.bean.Money;
import com.zhangboshu.demo.bean.User;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class SQLiteActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn9;
    private Button btn10;
    private Button btn11;
    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        initViews();
    }

    private void initViews() {
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        btn11 = (Button) findViewById(R.id.button11);

        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button9:
                Connector.getDatabase();
                break;
            case R.id.button10:
                if (user.isSaved()){
                    user.setName("new");
                    user.setUserId("1234");
                    user.update(1);
                }else{
                    user.setUserId("2587");
                    user.setName("MJ");
                    user.save();

                    Money money = new Money();
                    money.setName("MJ");
                    money.setNum(120.0f);
                    money.setUser(user);
                    money.save();

                    Money money2 = new Money();
                    money2.setName("RMB");
                    money2.setNum(180.0f);
                    money2.setUser(user);
                    money2.save();
                }
                break;
            case R.id.button11:

                List<User> all = DataSupport.findAll(User.class);
                for (User users : all) {
                    Log.i("sssssss", users.getUserId());
                    Log.i("sssssss", users.getName());
                }

                break;
        }
    }
}
