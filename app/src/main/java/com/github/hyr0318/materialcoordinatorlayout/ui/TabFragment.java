package com.github.hyr0318.materialcoordinatorlayout.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.github.hyr0318.materialcoordinatorlayout.R;
import com.github.hyr0318.materialcoordinatorlayout.listener.OnPagerSelectedLisener;
import com.github.hyr0318.materialcoordinatorlayout.widgets.bean;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/8/24 14:38
 * 邮箱：2045446584@qq.com
 */
public class TabFragment extends Fragment implements OnPagerSelectedLisener {

    private String keywords;


    private List<bean> getData() {

        List<bean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            bean bean = new bean();

            bean.setName(keywords + i);
            list.add(bean);
        }

        return list;
    }


    public static TabFragment getInstance(String mTitle) {
        TabFragment tabFragment = null;


        if (tabFragment == null) {
            tabFragment = new TabFragment();
        }
        tabFragment.keywords = mTitle;
        return tabFragment;
    }


    @Nullable @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, null);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);

        init(recyclerView);

        return view;
    }


    private void init(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyAapter());

    }


    @Override public void OnPagerSelected(int position, String keywords) {
        this.keywords = keywords;
    }


    private class MyAapter extends RecyclerView.Adapter<MyAapter.ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,
                viewGroup, false);
            return new ViewHolder(view);
        }


        @Override public void onBindViewHolder(ViewHolder holder, int position) {

            bean bean = getData().get(position);

            holder.textView.setText(bean.getName());

        }


        @Override public int getItemCount() {
            return getData().size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView textView;


            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.tv);

            }
        }
    }
}
