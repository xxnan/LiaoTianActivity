package com.android.xxnan.city.liaotianactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView deal_talk_list;
    private MyAdapter myAdapter;
    private EditText edit;
    private Button send;
    private List<TalkBean> list=new ArrayList<TalkBean>();
    private int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView()
    {
        edit=(EditText)findViewById(R.id.edit_send);
        send=(Button)findViewById(R.id.send);
        send.setOnClickListener(this);
        deal_talk_list=(ListView) findViewById(R.id.deal_talk_list);
        myAdapter= new MyAdapter(getApplicationContext(),list);
        deal_talk_list.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View v) {
        num++;
        switch (v.getId())
        {
            case  R.id.send:
                TalkBean talkBean=new TalkBean();
                talkBean.talk_content=edit.getText().toString();
                if(true) {
                    talkBean.user_no = "xxnan";
                    talkBean.isLeft=false;
                }else
                {
                    talkBean.user_no = "jack";
                    talkBean.isLeft=true;
                }
                list.add(talkBean);
                myAdapter.seList(list);
            break;
        }
        deal_talk_list.setSelection(list.size()-1);
        edit.setText("");
    }
    @Override
    protected void onResume() {
        myAdapter.seList(list);
        super.onResume();
    }

}
