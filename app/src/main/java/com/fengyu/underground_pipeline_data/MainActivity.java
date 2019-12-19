package com.fengyu.underground_pipeline_data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.main_activity_title);
        toolbar.setLogo(R.drawable.logo);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(onMenuItemClick);

         ListView listView1= findViewById(R.id.list_item);
        List<Map<String, Object>> listItems=new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Map<String, Object> listItem=new HashMap<>();
            listItem.put("header", "1");
            listItem.put("second", "2");
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.testview_item,new String[]{"header","second"},new int[]{R.id.tvF,R.id.tvS});
        listView1.setAdapter(simpleAdapter);

    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.search_menu_item:
                    msg += "Click search_menu_item";
                    break;
                case R.id.setting_menu_item:
                    msg += "Click setting_menu_item";
                    break;
            }
            if(!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }
}
