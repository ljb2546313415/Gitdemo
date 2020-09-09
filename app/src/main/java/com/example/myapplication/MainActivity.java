package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MyCount mc;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.show);
        mc = new MyCount(10000, 1000);
        mc.start();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture,long countDownInterval){
            super(millisInFuture,countDownInterval);

        }

        @Override
        public void onTick(long millisUntilFinshed){
            tv.setText("请等待10秒("+ millisUntilFinshed/1000+")...");
            Toast.makeText(MainActivity.this,millisUntilFinshed/1000+"",
                    Toast.LENGTH_LONG).show();
        }
        @Override
        public void onFinish(){
            tv.setText("finish");
        }
    }

}