package k.javine.myswipelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.BaseSwipeAdapter;

import java.util.List;

import k.javine.myswipelist.model.UserInfo;

/**
 * Created by Administrator on 2016/4/3.
 */
public class MySwipeAdapter extends BaseSwipeAdapter{

    private Context context;
    private List<UserInfo> userInfos;
    private OnSwipeItemListener swipeItemListener;
    private OnDeleteSwipeItemListener deleteListener;

    interface OnSwipeItemListener{
        void onItemOpen(SwipeLayout swipeLayout, int position);
        void onItemClose(SwipeLayout swipeLayout, int position);
    }
    public void setSwipeItemListener(OnSwipeItemListener swipeItemListener) {
        this.swipeItemListener = swipeItemListener;
    }

    interface OnDeleteSwipeItemListener{
        void onDeleteItem(int position);
    }

    public void setDeleteListener(OnDeleteSwipeItemListener listener){
        this.deleteListener = listener;
    }

    public MySwipeAdapter(Context context,List<UserInfo> infos){
        this.context = context;
        userInfos = infos;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(final int position, ViewGroup parent) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.swipe_item,parent,false);
        final SwipeLayout swipeLayout = (SwipeLayout) convertView.findViewById(getSwipeLayoutResourceId(position));
        convertView.findViewById(R.id.id_trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemManger.removeShownLayouts(swipeLayout);
                deleteListener.onDeleteItem(position);
                mItemManger.closeAllItems();
            }
        });
        return convertView;
    }

    @Override
    public void fillValues(int position, View convertView) {
        TextView tv = (TextView) convertView.findViewById(R.id.tv_data);
        tv.setText(userInfos.get(position).getName());
    }

    @Override
    public int getCount() {
        return userInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return userInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userInfos.get(position).getId(); //id must be stable
    }

    public List<UserInfo> getList(){
        return userInfos;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
