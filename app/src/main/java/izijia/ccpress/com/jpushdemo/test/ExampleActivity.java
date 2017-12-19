package izijia.ccpress.com.jpushdemo.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.jpushdemo.bean.ExampleAdapter;
import izijia.ccpress.com.jpushdemo.bean.ExampleBean;

/**
 * Created by Administrator on 2017/12/10.
 */

public class ExampleActivity extends AppCompatActivity {

    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_example);
        mRecyclerview = findViewById(R.id.recy);

        initRecyclerView();
    }

    GridLayoutManager gridLayoutManager;

    private ArrayList<ExampleBean> exampleBeen = new ArrayList<>();


    private void initRecyclerView() {

        exampleBeen.add(new ExampleBean(false, "1", "dsaesd"));
        exampleBeen.add(new ExampleBean(false, "1", "dsaesd"));
        exampleBeen.add(new ExampleBean(false, "1", "dsaesd"));
        exampleBeen.add(new ExampleBean(false, "1", "dsaesd"));
        exampleBeen.add(new ExampleBean(false, "1", "dsaesd"));
        exampleBeen.add(new ExampleBean(false, "1", "dsaesd"));


        gridLayoutManager = new GridLayoutManager(this, 4);
        final ExampleAdapter exampleAdapter = new ExampleAdapter(this, exampleBeen);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
//                int itemViewType = exampleAdapter.getItemViewType(position);
                Log.e("dfsgdfg", position + "位置");
                for (int i = 0; i < exampleBeen.size(); i++) {
                    Log.e("dfsgdfg", position + "位置");
                    if (exampleBeen.get(position).isClick()) {
                        Log.e("dfsgdfg", position + "位置");
                        return gridLayoutManager.getSpanCount();
                    } else {
                        Log.e("dfsgdfgsds", position + "位置");
                        return 2;
                    }
                }
                return 1;
            }
        });
        mRecyclerview.setLayoutManager(gridLayoutManager);


        mRecyclerview.setAdapter(exampleAdapter);

        exampleAdapter.setmClick(new ExampleAdapter.OnClickListener() {
            @Override
            public void setClickListener(View view, int position) {
                ArrayList<ExampleBean> exampleBeen = exampleAdapter.getExampleBeen();

                for (int i = 0; i < exampleBeen.size(); i++) {
                    if (i == position) {
                        exampleBeen.get(i).setClick(true);
                    } else {
                        exampleBeen.get(i).setClick(false);
                    }
                }

                exampleAdapter.setExampleBeen(exampleBeen);
//                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                    @Override
//                    public int getSpanSize(int position) {
//                        int itemViewType = exampleAdapter.getItemViewType(position);
//                        if (itemViewType == 1) {
//                            return 1;
//                        } else {
//                            return 2;
//                        }
//                    }
//                });

            }
        });

    }


}
