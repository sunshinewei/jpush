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

#### BaseLoadActivity的使用

##### 在成功页面添加网络请求状态（1:成功 2:失败 3：加载中）
<pre><code>
statusViewChange(1);
</code></pre>