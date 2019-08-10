package com.example.onedream.flightapp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.bean.PriceChildInfo;
import com.example.onedream.flightapp.bean.PriceGroupInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogPriceDetailAdapter extends BaseExpandableListAdapter {
    List<PriceGroupInfo> list;
    Context context;

    public DialogPriceDetailAdapter(List<PriceGroupInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (list != null && list.get(groupPosition).getItemlist() != null) {
            return list.get(groupPosition).getItemlist().size();
        }
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_price_group, parent, false);
            holder = new GroupViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        PriceGroupInfo bean = list.get(groupPosition);
        holder.tvName.setText(setNullText(bean.getTitle()));
        holder.tvCount.setText("￥" + bean.getTotalPrice());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_price_child, parent, false);
            holder = new ChildViewHolder(convertView);
            convertView.setTag(holder);
        }else {
           holder = (ChildViewHolder) convertView.getTag();
        }
        PriceChildInfo bean = list.get(groupPosition).getItemlist().get(childPosition);
        holder.tvName.setText(setNullText(bean.getName()));
        holder.tvCount.setText("￥" + bean.getItemPrice());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public String setNullText(String content) {
        if (TextUtils.isEmpty(content)) {
            return "";
        } else {
            return content;
        }
    }

    static class GroupViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_count)
        TextView tvCount;

        GroupViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ChildViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_count)
        TextView tvCount;

        ChildViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
