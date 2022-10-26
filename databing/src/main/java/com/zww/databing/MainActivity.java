package com.zww.databing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zww.databing.databinding.ActivityMainBinding;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ObservableField<String> username = new ObservableField<>("admin2222");
    private ObservableField<String> password = new ObservableField<>("password");
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        两种不同的装载方式
//        ViewDataBinding binding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.activity_main,null,false);
//        binding.setVariable(BR.username,username);
//        binding.setVariable(BR.password,password);
        ViewDataBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.setVariable(BR.username,username);
        binding.setVariable(BR.password,password);
        binding.setVariable(BR.onRandomClick, (View.OnClickListener) v ->{
                    this.username.set(randUserName());   //  单向绑定实现
                }
        );
        binding.setVariable(BR.onLoginClick, (View.OnClickListener) v -> {
            if(username.get().equals("admin") && password.get().equals("123"))
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                  else
                     Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
        );
        setContentView(binding.getRoot());

    }

    private String randUserName() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 5; i++){
            sb.append((char) (random.nextInt(26) + 'a'));
        }
        return sb.toString();
    }
}
/**
 *    user = findViewById(R.id.user);
 *         psw = findViewById(R.id.password);
 *         btn_login = findViewById(R.id.login);
 *         btn_random = findViewById(R.id.random_user);
 *         btn_random.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View v) {
 *                 user.setText(randUserName());
 *             }
 *         });
 *         btn_login.setOnClickListener(new View.OnClickListener() {
 *             @Override
 *             public void onClick(View v) {
 *                 String userName = user.getText().toString();
 *                 String PassWord = psw.getText().toString();
 *                 if(userName.equals("admin") && PassWord.equals("123"))
 *                     Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
 *                 else{
 *                     Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
 *                 }
 *             }
 *         });
 *
 */