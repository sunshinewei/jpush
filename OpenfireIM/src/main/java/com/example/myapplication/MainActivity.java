package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.Utils.PicUtils;
import com.example.myapplication.bean.EnumMethod;
import com.example.myapplication.bean.HomeBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import izijia.ccpress.com.mylibrary.base.BaseCommonActivity;
import izijia.ccpress.com.mylibrary.base.loadingdialog.view.LoadingDialog;

public class MainActivity extends BaseCommonActivity {
    private RecyclerView recy;

    @Override
    public int setRootView() {
        return R.layout.activity_main;
    }

    private ArrayList<HomeBean> mainBean;

    @Override
    public void initView() {
        recy = (RecyclerView) findViewById(R.id.recy);
        tvTitle.setText("首页");
        tvBack.setVisibility(View.GONE);
    }


    @Override
    public void initData() {

        Gson gson = new Gson();

        Type type = new TypeToken<List<HomeBean>>() {

        }.getType();

        mainBean = gson.fromJson(source, type);

        recy.setLayoutManager(new GridLayoutManager(mContext, 2));

        recy.addItemDecoration(new DividerItemDecoration(mContext, LinearLayout.VERTICAL));
        recy.addItemDecoration(new DividerItemDecoration(mContext, LinearLayout.HORIZONTAL));
        recy.setAdapter(new ShowAdapter(mainBean));

    }


    class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.SViewHolder> {
        private ArrayList<HomeBean> homeBeans;

        ShowAdapter(ArrayList<HomeBean> homeBeans) {
            this.homeBeans = homeBeans;
        }

        @Override
        public SViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.adapter_gride_home, parent, false);
            return new SViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(final SViewHolder holder, int position) {
            final HomeBean homeBean = homeBeans.get(position);
            holder.tvPrice.setText("协议价 ¥" + homeBean.getMinPrice() + "");
            holder.tvTitle.setText(homeBean.getName());
            holder.imgAdaShow.setImageDrawable(PicUtils.initPic(mContext, homeBean.getId()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ProInfoActivity.class);
                    intent.putExtra(Constant.INTENT_INFO, homeBean);
                    startActivity(intent);
                }
            });

            ArrayList arrayList = new ArrayList();
            arrayList.add(nums1);
            arrayList.add(nums2);
        }

        int[] nums1;
        int[] nums2;


        @Override
        public int getItemCount() {
            return homeBeans.size();
        }


        class SViewHolder extends RecyclerView.ViewHolder {

            private ImageView imgAdaShow;
            private TextView tvTitle;
            private TextView tvPrice;

            public SViewHolder(View itemView) {
                super(itemView);
                imgAdaShow = (ImageView) itemView.findViewById(R.id.img_ada_show);
                tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
                tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            }
        }
    }

    String source = "[\n" +
            "  {\n" +
            "    barCode: \"\",\n" +
            "    categoryId: 35,\n" +
            "    characteristic: \"茅台醇为茅台集团技开公司开发，零售价应按市场零售价执行。\",\n" +
            "    commission: 9,\n" +
            "    commissionType: 1,\n" +
            "    dateAdd: \"2017-05-03 09:09:36\",\n" +
            "    dateStart: \"2017-10-20 08:34:37\",\n" +
            "    dateUpdate: \"2018-10-10 17:03:55\",\n" +
            "    gotScore: 0,\n" +
            "    gotScoreType: 0,\n" +
            "    id: 36,\n" +
            "    kanjia: false,\n" +
            "    kanjiaPrice: 0,\n" +
            "    logisticsId: 12,\n" +
            "    originalPrice: 599,\n" +
            "    minScore: 0,\n" +
            "    name: \"茅台醇1992 规格（53°）（500ml/瓶）\",\n" +
            "    numberFav: 0,\n" +
            "    numberGoodReputation: 6,\n" +
            "    numberOrders: 107,\n" +
            "    numberSells: 0,\n" +
            "    minPrice: 369,\n" +
            "    paixu: 0,\n" +
            "    pic: \"R.mipmap.mt92\",\n" +
            "    pingtuan: false,\n" +
            "    pingtuanPrice: 0,\n" +
            "    propertyIds: \",11,\",\n" +
            "    recommendStatus: 0,\n" +
            "    recommendStatusStr: \"普通\",\n" +
            "    shopId: 0,\n" +
            "    status: 0,\n" +
            "    statusStr: \"上架\",\n" +
            "    stores: 9999,\n" +
            "    userId: 51,\n" +
            "    views: 14958,\n" +
            "    weight: 0,\n" +
            "    scanShow: false,\n" +
            "    scanPrice: 0\n" +
            "  },\n" +
            "  {\n" +
            "    categoryId: 36,\n" +
            "    characteristic: \"茅台醇为茅台集团技开公司开发，零售价应按市场零售价执行。\",\n" +
            "    commission: 0,\n" +
            "    commissionType: 0,\n" +
            "    dateAdd: \"2017-04-26 23:07:15\",\n" +
            "    dateUpdate: \"2018-10-10 17:18:59\",\n" +
            "    gotScore: 0,\n" +
            "    gotScoreType: 0,\n" +
            "    id: 35,\n" +
            "    kanjia: false,\n" +
            "    kanjiaPrice: 0,\n" +
            "    logisticsId: 0,\n" +
            "    minPrice: 209,\n" +
            "    minScore: 0,\n" +
            "    name: \"茅台醇1998规格（53°）（500ml/瓶）\",\n" +
            "    numberFav: 0,\n" +
            "    numberGoodReputation: 1,\n" +
            "    numberOrders: 95,\n" +
            "    numberSells: 0,\n" +
            "    originalPrice: 369,\n" +
            "    paixu: 0,\n" +
            "    pic: \"/pages/index/img/mt98\",\n" +
            "    pingtuan: false,\n" +
            "    pingtuanPrice: 0,\n" +
            "    recommendStatus: 0,\n" +
            "    recommendStatusStr: \"普通\",\n" +
            "    shopId: 0,\n" +
            "    status: 0,\n" +
            "    statusStr: \"上架\",\n" +
            "    stores: 1000074,\n" +
            "    userId: 51,\n" +
            "    views: 21364,\n" +
            "    weight: 0,\n" +
            "    scanShow: false,\n" +
            "    scanPrice: 0\n" +
            "  },\n" +
            "  {\n" +
            "    categoryId: 35,\n" +
            "    characteristic: \"茅台醇为茅台集团技开公司开发，零售价应按市场零售价执行。\",\n" +
            "    commission: 0,\n" +
            "    commissionType: 0,\n" +
            "    dateAdd: \"2017-04-26 22:39:51\",\n" +
            "    dateUpdate: \"2018-10-10 11:13:28\",\n" +
            "    gotScore: 0,\n" +
            "    gotScoreType: 0,\n" +
            "    id: 34,\n" +
            "    kanjia: false,\n" +
            "    kanjiaPrice: 0,\n" +
            "    logisticsId: 0,\n" +
            "    minPrice: 109,\n" +
            "    minScore: 0,\n" +
            "    name: \"茅台醇2008规格（53°）（500ml/瓶）\",\n" +
            "    numberFav: 0,\n" +
            "    numberGoodReputation: 0,\n" +
            "    numberOrders: 91,\n" +
            "    numberSells: 0,\n" +
            "    originalPrice: 199,\n" +
            "    paixu: 0,\n" +
            "    pic: \"R.mipmap.mt08\",\n" +
            "    pingtuan: false,\n" +
            "    pingtuanPrice: 0,\n" +
            "    recommendStatus: 0,\n" +
            "    recommendStatusStr: \"普通\",\n" +
            "    shopId: 0,\n" +
            "    status: 0,\n" +
            "    statusStr: \"上架\",\n" +
            "    stores: 1000068,\n" +
            "    userId: 51,\n" +
            "    views: 8723,\n" +
            "    weight: 0,\n" +
            "    scanShow: false,\n" +
            "    scanPrice: 0\n" +
            "  },\n" +
            "  {\n" +
            "    categoryId: 37,\n" +
            "    characteristic: \"白金金质酒为茅台集团白金酒公司开发，市场零售价在最低零售价到扫码价之间。\",\n" +
            "    commission: 0,\n" +
            "    commissionType: 0,\n" +
            "    dateAdd: \"2017-04-26 22:29:45\",\n" +
            "    dateUpdate: \"2018-10-10 17:10:30\",\n" +
            "    gotScore: 0,\n" +
            "    gotScoreType: 0,\n" +
            "    id: 33,\n" +
            "    kanjia: false,\n" +
            "    kanjiaPrice: 0,\n" +
            "    logisticsId: 10,\n" +
            "    minPrice: 288,\n" +
            "    minScore: 0,\n" +
            "    name: \"白金金质酒V30（蓝）规格（53°）（500ml/瓶）\",\n" +
            "    numberFav: 0,\n" +
            "    numberGoodReputation: 0,\n" +
            "    numberOrders: 39,\n" +
            "    numberSells: 0,\n" +
            "    originalPrice: 498,\n" +
            "    paixu: 0,\n" +
            "    pic: \"R.mipmap.bjjzl\",\n" +
            "    pingtuan: false,\n" +
            "    pingtuanPrice: 0,\n" +
            "    recommendStatus: 0,\n" +
            "    recommendStatusStr: \"普通\",\n" +
            "    shopId: 0,\n" +
            "    status: 0,\n" +
            "    statusStr: \"上架\",\n" +
            "    stores: 77,\n" +
            "    userId: 51,\n" +
            "    views: 8989,\n" +
            "    weight: 0,\n" +
            "    scanShow: true,\n" +
            "    scanPrice: 1288\n" +
            "  },\n" +
            "  {\n" +
            "    categoryId: 42,\n" +
            "    characteristic: \"白金金质酒为茅台集团白金酒公司开发，市场零售价在最低零售价到扫码价之间。\",\n" +
            "    commission: 0,\n" +
            "    commissionType: 0,\n" +
            "    dateAdd: \"2017-04-26 21:52:16\",\n" +
            "    dateUpdate: \"2018-10-06 21:25:42\",\n" +
            "    gotScore: 0,\n" +
            "    gotScoreType: 0,\n" +
            "    id: 32,\n" +
            "    kanjia: false,\n" +
            "    kanjiaPrice: 0,\n" +
            "    logisticsId: 10,\n" +
            "    minPrice: 258,\n" +
            "    minScore: 0,\n" +
            "    name: \"白金金质酒V30（黑）规格（53°）（500ml/瓶）\",\n" +
            "    numberFav: 0,\n" +
            "    numberGoodReputation: 0,\n" +
            "    numberOrders: 17,\n" +
            "    numberSells: 0,\n" +
            "    originalPrice: 398,\n" +
            "    paixu: 0,\n" +
            "    pic: \"R.mipmap.bjjzh\",\n" +
            "    pingtuan: false,\n" +
            "    pingtuanPrice: 0,\n" +
            "    recommendStatus: 0,\n" +
            "    recommendStatusStr: \"普通\",\n" +
            "    shopId: 0,\n" +
            "    status: 0,\n" +
            "    statusStr: \"上架\",\n" +
            "    stores: 88,\n" +
            "    userId: 51,\n" +
            "    views: 3821,\n" +
            "    weight: 0,\n" +
            "    scanShow: true,\n" +
            "    scanPrice: 1188\n" +
            "  },\n" +
            "  {\n" +
            "    categoryId: 36,\n" +
            "    characteristic: \"白金金质酒为茅台集团白金酒公司开发，市场零售价在最低零售价到扫码价之间。\",\n" +
            "    commission: 0,\n" +
            "    commissionType: 0,\n" +
            "    dateAdd: \"2017-04-25 23:54:54\",\n" +
            "    dateUpdate: \"2018-10-10 17:15:06\",\n" +
            "    gotScore: 0,\n" +
            "    gotScoreType: 0,\n" +
            "    id: 31,\n" +
            "    kanjia: false,\n" +
            "    kanjiaPrice: 0,\n" +
            "    logisticsId: 0,\n" +
            "    minPrice: 258,\n" +
            "    minScore: 0,\n" +
            "    name: \"白金金质酒V30（金）规格（53°）（500ml/瓶）\",\n" +
            "    numberFav: 0,\n" +
            "    numberGoodReputation: 0,\n" +
            "    numberOrders: 64,\n" +
            "    numberSells: 0,\n" +
            "    originalPrice: 398,\n" +
            "    paixu: 0,\n" +
            "    pic: \"R.mipmap.bjjzj\",\n" +
            "    pingtuan: false,\n" +
            "    pingtuanPrice: 0,\n" +
            "    recommendStatus: 0,\n" +
            "    recommendStatusStr: \"普通\",\n" +
            "    shopId: 0,\n" +
            "    status: 0,\n" +
            "    statusStr: \"上架\",\n" +
            "    stores: 19079,\n" +
            "    userId: 51,\n" +
            "    views: 12844,\n" +
            "    weight: 0,\n" +
            "    scanShow: true,\n" +
            "    scanPrice: 1188\n" +
            "  },\n" +
            "  {\n" +
            "    categoryId: 35,\n" +
            "    characteristic: \"白金金质酒为茅台集团白金酒公司开发，市场零售价在最低零售价到扫码价之间。\",\n" +
            "    commission: 0,\n" +
            "    commissionType: 0,\n" +
            "    dateAdd: \"2017-04-25 23:37:32\",\n" +
            "    dateUpdate: \"2018-10-10 17:04:45\",\n" +
            "    gotScore: 0,\n" +
            "    gotScoreType: 0,\n" +
            "    id: 30,\n" +
            "    kanjia: false,\n" +
            "    kanjiaPrice: 0,\n" +
            "    logisticsId: 10,\n" +
            "    minPrice: 228,\n" +
            "    minScore: 0,\n" +
            "    name: \"白金金质酱香规格（53°）（500ml/瓶）\",\n" +
            "    numberFav: 0,\n" +
            "    numberGoodReputation: 0,\n" +
            "    numberOrders: 10,\n" +
            "    numberSells: 0,\n" +
            "    originalPrice: 298,\n" +
            "    paixu: 0,\n" +
            "    pic: \"R.mipmap.bjjx\",\n" +
            "    pingtuan: false,\n" +
            "    pingtuanPrice: 0,\n" +
            "    propertyIds: \",10,\",\n" +
            "    recommendStatus: 0,\n" +
            "    recommendStatusStr: \"普通\",\n" +
            "    shopId: 0,\n" +
            "    status: 0,\n" +
            "    statusStr: \"上架\",\n" +
            "    stores: 338,\n" +
            "    userId: 51,\n" +
            "    views: 3272,\n" +
            "    weight: 0,\n" +
            "    scanShow: true,\n" +
            "    scanPrice: 888\n" +
            "  },\n" +
            "  {\n" +
            "    categoryId: 35,\n" +
            "    characteristic: \"白金金质酒为茅台集团白金酒公司开发，市场零售价在最低零售价到扫码价之间。\",\n" +
            "    commission: 0,\n" +
            "    commissionType: 0,\n" +
            "    dateAdd: \"2017-04-25 23:18:58\",\n" +
            "    dateUpdate: \"2018-10-09 14:14:22\",\n" +
            "    gotScore: 0,\n" +
            "    gotScoreType: 0,\n" +
            "    id: 29,\n" +
            "    kanjia: false,\n" +
            "    kanjiaPrice: 0,\n" +
            "    logisticsId: 10,\n" +
            "    minPrice: 350,\n" +
            "    minScore: 0,\n" +
            "    name: \"国典酱香(习酒内部定制酒)\",\n" +
            "    numberFav: 0,\n" +
            "    numberGoodReputation: 0,\n" +
            "    numberOrders: 6,\n" +
            "    numberSells: 0,\n" +
            "    originalPrice: 598,\n" +
            "    paixu: 0,\n" +
            "    pic: \"R.mipmap.xj\",\n" +
            "    pingtuan: false,\n" +
            "    pingtuanPrice: 0,\n" +
            "    recommendStatus: 0,\n" +
            "    recommendStatusStr: \"普通\",\n" +
            "    shopId: 0,\n" +
            "    status: 0,\n" +
            "    statusStr: \"上架\",\n" +
            "    stores: 98,\n" +
            "    userId: 51,\n" +
            "    views: 2868,\n" +
            "    weight: 0,\n" +
            "    scanShow: false,\n" +
            "    scanPrice: 0\n" +
            "  }\n" +
            "]";

}
