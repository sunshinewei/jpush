#### 网络请求基本使用

##### 页面加载(设置加载方式：false:进入页面加载，true:事件请求)
<pre><code>
 new BaseGoSpace<HomeTabBean>()
                .setUrl(url)
                .setDataType(HomeTabBean.class)
                .setBaseView(mHomeView)
                .setIsLoad(false)
                .setOnSuccessListener(new OnSuccessListener<HomeTabBean>() {
                    @Override
                    public void setSuccessInfo(HomeTabBean datas) {
                        mHomeView.setSuccessView(datas);
                    }
                })
                .goGetSpace();
</code></pre>
