package izijia.ccpress.com.jpushdemo.bean;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import izijia.ccpress.com.jpushdemo.R;
import izijia.ccpress.com.mylibrary.dialog.listener.OnClickListener;

/**
 * Created by Administrator on 2017/12/10.
 */

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.BaseViewHolder> {

    private Context mContext;

    ArrayList<ExampleBean> exampleBeen;

    public int VIEW_TYPE_ONE = 1;
    public int VIEW_TYPE_TWO = 2;

    public ArrayList<ExampleBean> getExampleBeen() {
        return exampleBeen;
    }

    public void setExampleBeen(ArrayList<ExampleBean> exampleBeen) {
        this.exampleBeen = exampleBeen;
        notifyDataSetChanged();
    }

    public ExampleAdapter(Context mContext, ArrayList<ExampleBean> exampleBeen) {

        this.mContext = mContext;
        this.exampleBeen = exampleBeen;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = null;
        switch (viewType) {
            case 1:
                inflate = LayoutInflater.from(mContext).inflate(R.layout.adapter_item_one, null);
                break;
            case 2:
                inflate = LayoutInflater.from(mContext).inflate(R.layout.adapter_item_two, null);
                break;
        }
        return new BaseViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        ExampleBean exampleBean = exampleBeen.get(position);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClick.setClickListener(view, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exampleBeen.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (exampleBeen.get(position).isClick()) {
            return VIEW_TYPE_ONE;
        } else {
            return VIEW_TYPE_TWO;
        }
    }

    private OnClickListener mClick;

    public void setmClick(OnClickListener mClick) {
        this.mClick = mClick;
    }



    public interface OnClickListener {

        void setClickListener(View view, int position);
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public BaseViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);

        }


    }
}
