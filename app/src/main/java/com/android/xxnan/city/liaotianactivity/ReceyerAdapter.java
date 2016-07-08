package com.android.xxnan.city.liaotianactivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xxnan on 2016/7/7.
 */
public class ReceyerAdapter extends RecyclerView.Adapter {
    private List<TalkBean> mList;
    private Context mContext;
    ReceyerAdapter(List<TalkBean> list, Context context)
    {
        mList=list;
        mContext=context;
    }
    public void setmList(List<TalkBean> list)
    {
        mList=list;
        notifyDataSetChanged();
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        int type=getItemViewType(viewType);
        MyHolder myHolder=null;
        if(viewType==0)
            myHolder=new LeftMyHolder(LayoutInflater.from(mContext).inflate(R.layout.talk_left_item,null));
        else if(viewType==1)
            myHolder=new RightMyHolder(LayoutInflater.from(mContext).inflate(R.layout.talk_right_item,null));
        return myHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof LeftMyHolder)
        {
            ((LeftMyHolder) holder).talk_data_left_tv.setText(mList.get(position).talk_content);
            ((LeftMyHolder) holder).talk_name_tv.setText(mList.get(position).user_no);
        }else if(holder instanceof  RightMyHolder )
        {
            ((RightMyHolder) holder).talk_data_right_tv.setText(mList.get(position).talk_content);
            ((RightMyHolder) holder).talk_myself_tv.setText(mList.get(position).user_no);
        }
    }

    @Override
    public int getItemViewType(int position) {
        int type=0;
        if(mList.get(position).isLeft)
            type=0;
        else
            type=1;
        return type;
    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }
}
    class MyHolder extends RecyclerView.ViewHolder
    {
        public MyHolder(View itemView) {
            super(itemView);
        }
    }
class LeftMyHolder extends MyHolder
{
    TextView talk_name_tv;
    Button talk_data_left_tv;
    public LeftMyHolder(View itemView)
    {
        super(itemView);
        talk_name_tv=(TextView) itemView.findViewById(R.id.talk_name_tv);
        talk_data_left_tv=(Button) itemView.findViewById(R.id.talk_data_left_tv);
    }
}
class RightMyHolder extends MyHolder
{
    TextView talk_myself_tv;
    Button talk_data_right_tv;
    public RightMyHolder(View itemView)
    {
        super(itemView);
        talk_myself_tv=(TextView) itemView.findViewById(R.id.talk_myself_tv);
        talk_data_right_tv=(Button) itemView.findViewById(R.id.talk_data_right_tv);
    }
}
