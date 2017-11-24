package izijia.ccpress.com.jpushdemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;

import cn.jpush.android.api.JPushInterface;
import izijia.ccpress.com.jpushdemo.test.Test2Activity;
import izijia.ccpress.com.jpushdemo.test.TestActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;
    private Button redButton, colorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webview);
        redButton = (Button) findViewById(R.id.red);
        colorButton = (Button) findViewById(R.id.color);
        redButton.setOnClickListener(this);
        colorButton.setOnClickListener(this);
        initWebView();
        webView.loadUrl("file:///android_asset/test.html"); //加载assets文件中的H5页面

    }


    /**
     * 初始化WebView
     */
    @SuppressLint("JavascriptInterface")  //添加该字段
    private void initWebView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);  //设置运行使用JS
        ButtonClick click = new ButtonClick();
        //这里添加JS的交互事件，这样H5就可以调用原生的代码
        webView.addJavascriptInterface(click, click.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.red:  //调用JS中的无参数方法
                webView.loadUrl("javascript:setRed()");
                break;
            case R.id.color://调用JS中的有参数方法
//                webView.loadUrl("javascript:setColor('#00f','代码的触发事件')");
                startActivity(new Intent(this, Test2Activity.class));
                break;
        }
    }

    /**
     * H5页面按钮点击触发事件
     */
    class ButtonClick {

        //这是 button.click0() 的触发事件
        //H5调用方法：javascript:button.click0()
        @JavascriptInterface
        public void click0() {
            show("title", "");
        }

        //这是 button.click0() 的触发事件，可以传递待参数
        //H5调用方法：javascript:button.click0('参数1','参数2')
        @JavascriptInterface
        public void click0(String data1, String data2) {
            show(data1, data2);
        }


        @Override
        @JavascriptInterface  //必须添加，这样才可以标志这个类的名称是 button
        public String toString() {
            return "button";
        }

        private void show(String title, String data) {
//            new AlertDialog.Builder(getWindow().getContext())
//                    .setTitle(title)
//                    .setMessage(data)
//                    .setPositiveButton("确定",null)
//                    .create().show();
            if ("title".equals(title)) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        }
    }
}
