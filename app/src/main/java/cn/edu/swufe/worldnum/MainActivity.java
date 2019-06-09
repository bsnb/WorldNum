package cn.edu.swufe.worldnum;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {//implements Runnable {
    EditText numtext;
    private String name = "";
    private String num = "";
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numtext = findViewById(R.id.num);
        SharedPreferences sharedPreferences = getSharedPreferences("search_num", Activity.MODE_PRIVATE);
        PreferenceManager.getDefaultSharedPreferences(this);
        name = sharedPreferences.getString("name", "");
        num = sharedPreferences.getString("num", "");
    }

    private void openConfig() {
        String num = numtext.getText().toString();
        Intent config1 = new Intent(this, ConfigActivity.class);
        config1.putExtra("num", num);
        startActivityForResult(config1, 1);
    }

    public void onClick(View btn) {
        String num = numtext.getText().toString();
        if (num.length() > 0) {
            if (btn.getId() == R.id.search_chose_btn1) {
                openConfig();
            } else {
                openConfig();
            }
        } else {
            Toast.makeText(MainActivity.this, "请输入查询的国家或地区区号", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.num, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.inl_num) {
            Intent config = new Intent(this, InlNumActivity.class);
            startActivity(config);
        } else if (item.getItemId() == R.id.for_num) {
            Intent list = new Intent(this, ForNumActivity.class);
            startActivity(list);
        }
        return super.onOptionsItemSelected(item);
    }
}

