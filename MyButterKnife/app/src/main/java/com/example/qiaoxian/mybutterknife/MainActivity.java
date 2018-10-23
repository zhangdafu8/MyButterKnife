package com.example.qiaoxian.mybutterknife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView1)
    TextView textView;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindString(R.string.ButterButter)
    String string1;
    @BindView(R.id.listView)
    ListView listView1;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView1;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList.add("I am butter");
        mList.add("I am knife");
        mList.add("I am butterKnife");
        mList.add("I am an Apple");

        ButterKnife.bind(this);
        textView.setText(string1);
        button1.setText("ButterButton1");
        button2.setText("ButterButton2");
        listView1.setAdapter(new MyAdapter(this, mList));
        recyclerView1.setAdapter(new MyRecycleViewAdapter(this, mList));
        recyclerView1.setLayoutManager(new GridLayoutManager(this, 2));


    }

    @OnItemClick(R.id.listView)
    public void itemClicked(int position) {
        Toast.makeText(this, "position" + position, Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.button1, R.id.button2})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Toast.makeText(MainActivity.this, "I am Button1!", Toast.LENGTH_SHORT).show();
            case R.id.button2:
                Toast.makeText(MainActivity.this, "I am Button2!", Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.textView1)
    public void onViewClicked() {
    }
}
