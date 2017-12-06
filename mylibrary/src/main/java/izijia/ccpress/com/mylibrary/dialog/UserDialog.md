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