package cn.edu.swufe.worldnum;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Runnable{
    EditText numtext;
    private String num = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numtext=findViewById(R.id.num);
        SharedPreferences sharedPreferences = getSharedPreferences("search_num", Activity.MODE_PRIVATE);
        PreferenceManager.getDefaultSharedPreferences(this);
        num = sharedPreferences.getString ("num", "");

    }

    private void openConfig() {
        Intent config1 = new Intent(this, ConfigActivity.class);
//        config.putExtra("dollar_rate_key", dollarRate);
//        config.putExtra("euro_rate_key", euroRate);
//        config.putExtra("won_rate_key", wonRate);
        //startActivity(config);
        startActivityForResult(config1, 1);
    }
    public void onClick(View btn) {
        String str = numtext.getText().toString();
        if (str.length() > 0) {
            if (btn.getId() == R.id.search_chose_btn1) {
                Intent config1 = new Intent(this, ConfigActivity.class);
                //config.putExtra("dollar_rate_key", dollarRate)；
                //startActivity(config);
                startActivityForResult(config1, 1);
            } else {
                Intent config2 = new Intent(this, ConfigActivity2.class);
//                config.putExtra("dollar_rate_key", dollarRate);
//                config.putExtra("euro_rate_key", euroRate);
//                config.putExtra("won_rate_key", wonRate);
                //startActivity(config);
                startActivityForResult(config2, 1);
            }
            {
                Intent config = new Intent(this, ConfigActivity.class);
                //config.putExtra("dollar_rate_key", dollarRate);
                //config.putExtra("euro_rate_key", euroRate);
                //config.putExtra("won_rate_key", wonRate);
                //startActivity(config);
                startActivityForResult(config, 1);
            }

        } else {
            Toast.makeText(MainActivity.this, "请输入金额", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void run() {

    }
}
