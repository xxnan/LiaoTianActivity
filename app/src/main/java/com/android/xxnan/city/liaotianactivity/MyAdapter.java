package com.android.xxnan.city.liaotianactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xxnan on 2016/6/30.
 */
public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private  List<TalkBean> mlist;
    private LayoutInflater inflater;
    public MyAdapter(Context applicationContext, List<TalkBean> list) {
        mContext=applicationContext;
        mlist=list;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if(mlist.get(position).isLeft)
            return 0;
        else
        return 1;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    public void seList( List<TalkBean> list)
    {
        mlist=list;
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TalkleftHolder talkleftHolder=null;
        TalkrightHolder talkrightHolder=null;
        TalkBean bean=mlist.get(position);
        int type=getItemViewType(position);
        if(convertView==null)
        {
            switch (type){
                case 0:
                    convertView =inflater.inflate(R.layout.talk_left_item,null);
                    talkleftHolder=new TalkleftHolder();
                    talkleftHolder.leftcontent=(Button)convertView.findViewById(R.id.talk_data_left_tv);
                    talkleftHolder.lefttalkname=(TextView) convertView.findViewById(R.id.talk_name_tv);
                    talkleftHolder.leftcontent.setText(bean.talk_content);
                    talkleftHolder.lefttalkname.setText(bean.user_name);
                    convertView.setTag(talkleftHolder);
                    break;
                case  1:
                    convertView =inflater.inflate(R.layout.talk_right_item,null);
                    talkrightHolder=new TalkrightHolder();
                    talkrightHolder.rightcontent=(Button)convertView.findViewById(R.id.talk_data_right_tv);
                    talkrightHolder.righttalkname=(TextView) convertView.findViewById(R.id.talk_myself_tv);
                    talkrightHolder.rightcontent.setText(bean.talk_content);
                    talkrightHolder.righttalkname.setText(bean.user_name);
                    convertView.setTag(talkrightHolder);
                    break;
                default:
                    break;
            }

        }else
        {
            switch (type){
                case 0:
                    talkleftHolder=(TalkleftHolder) convertView.getTag();
                    talkleftHolder.leftcontent.setText(bean.talk_content);
                    talkleftHolder.lefttalkname.setText(bean.user_no);
                    break;
                case  1:
                    talkrightHolder=(TalkrightHolder)convertView.getTag();
                    talkrightHolder.rightcontent.setText(bean.talk_content);
                    talkrightHolder.righttalkname.setText(bean.user_no);
                    break;
                default:
                    break;
            }
        }
        return convertView;
    }
    static class TalkleftHolder{
        private Button leftcontent;
        private TextView lefttalkname;
    }
   static class TalkrightHolder{
        private Button  rightcontent;
        private TextView righttalkname;
    }
}
