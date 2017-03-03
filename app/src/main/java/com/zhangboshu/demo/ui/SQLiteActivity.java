package com.zhangboshu.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zhangboshu.demo.R;
import com.zhangboshu.demo.base.MyApplication;
import com.zhangboshu.demo.bean.Money;
import com.zhangboshu.demo.bean.User;

import org.litepal.crud.DataSupport;

import java.util.List;

public class SQLiteActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn9;
    private Button btn10;
    private Button btn11;
    private User user = MyApplication.user;
    private Button btn12;

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
        btn12 = (Button) findViewById(R.id.button12);

        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button9:
                List<User> rmb = DataSupport.where("userid = ? and name = ?", "321", "RMB").find(User.class);
                if (rmb.isEmpty()) {

                }else{
                    rmb.get(0).setName("OY");
                    rmb.get(0).updateAll("userid = ? and name = ?", "321", "RMB");
                }

                break;
            case R.id.button10:

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

                user.getMoneys().add(money);
                user.getMoneys().add(money2);
                user.save();

                List<User> mj = DataSupport.where("userid = ? and name = ?", "123", "RMB").find(User.class);
                if (mj.isEmpty()){
                    User user = new User();
                    user.setUserId("321");
                    user.setName("RMB");
                    user.save();
                }

                break;
            case R.id.button11:

                List<User> all = DataSupport.findAll(User.class);
                for (User users : all) {
                    Log.i("sssssss", "guanlian" + users.getMoneys().size());

                }

                List<User> users = DataSupport.where("userid = ?", "123").find(User.class);
                for (User user1 : users) {
                    for (Money money1 : user1.getMoneys()) {
                        Log.i("lllll", money1.getName());
                    }
                }
                break;
            case R.id.button12:
                List<User> oy = DataSupport.where("userid = ? and name = ?", "321", "OY").find(User.class);
                if (!oy.isEmpty()){
                    oy.get(0).delete();
                }
                break;
        }
    }
}
