### Dialog

#### BaseCenterMsgDialog的使用
<pre><code>
BaseCenterMsgDialog.newInstance()
                        .setTitle("这是标题")
                        .setContent("输入内容")
                        .setBaseListener(new BaseListener() {
                            @Override
                            public void setOnClickListner(View view) {
                                Toast.makeText(MainActivity.this, "点击了确定", Toast.LENGTH_LONG).show();
                            }
                        })
                        .show(MainActivity.this)
                        .setCancelable(false);//点击空白区域，控制Dialog ,true:消失，false:不消失
</code></pre>

#### BaseBottomDialog的使用
<pre><code>
 BaseBottomDialog.newInstance()
                       .setmArrays(mArray)
                       .setOnClickListener(new OnClickListener() {
                           @Override
                           public void setOnClickListner(View view, int position) {
                                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_LONG).show();
                           }
                       })
                       .show(getFragmentManager(), "sss");
</code></pre>

#### ViewBottomPopupWindow的使用(在某个View下显示)
<pre><code>
 new ViewBottomPopupWindow(Test2Activity.this)
                        .setmArrays(mArray)
                        .setOnClickListener(new OnClickListener() {
                            @Override
                            public void setOnClickListner(View view, int position) {
                                toastLong("sdfsdgfsdfg");
                            }
                        })
                        .show(tvLoad);
</code></pre>



#### 使用DialogFactory进行调用
