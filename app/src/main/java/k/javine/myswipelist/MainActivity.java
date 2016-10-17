package k.javine.myswipelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import k.javine.myswipelist.model.UserInfo;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.animation_list_view)
    AnimationListView listView;

    private MyAdapter mAdapter;
    private MySwipeAdapter swipeAdapter;

    String[] datas = {"Android","ListView","FunnySun","JavineKuang","JayChou","Micheal","QUALCOMM","DalvikVm","Adreno-EGL"};
    List<String> mDatas;
    List<UserInfo> userInfos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDatas = new ArrayList<>();
        userInfos = new ArrayList<>();
        for (int i=0;i<datas.length;i++){
            mDatas.add(datas[i]);
            userInfos.add(new UserInfo(i,datas[i]));
        }
        swipeAdapter = new MySwipeAdapter(this,userInfos);
        listView.setAdapter(swipeAdapter);
        swipeAdapter.setMode(Attributes.Mode.Single);
        swipeAdapter.setDeleteListener(new MySwipeAdapter.OnDeleteSwipeItemListener() {
            @Override
            public void onDeleteItem(final int position) {
                listView.manipulate(new AnimationListView.Manipulator<MySwipeAdapter>() {
                    @Override
                    public void manipulate(MySwipeAdapter adapter) {
                        adapter.getList().remove(position);
                    }
                });
            }
        });
    }
}
