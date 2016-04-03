package k.javine.myswipelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/4/2.
 */
public class MyAdapter extends BaseAdapter {
    private List<String> mDatas;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(Context context,List<String> data){
        this.context = context;
        mDatas = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mDatas.get(position).hashCode(); //每一个Item的Id必须是唯一的，且不会改变的。
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_list_view,parent,false);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.item_tv);
        tv.setText(mDatas.get(position));
        return convertView;
    }
}
