package izijia.ccpress.com.jpushdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.StringReader;
import java.security.acl.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import izijia.ccpress.com.jpushdemo.bean.ExampleBean;
import izijia.ccpress.com.jpushdemo.test.Test2Activity;
import izijia.ccpress.com.jpushdemo.test.Test3Activity;
import izijia.ccpress.com.jpushdemo.test.TestActivity;
import izijia.ccpress.com.mylibrary.dialog.BaseBottomDialog;
import izijia.ccpress.com.mylibrary.dialog.BaseCenterMsgDialog;
import izijia.ccpress.com.mylibrary.dialog.listener.BaseListener;
import izijia.ccpress.com.mylibrary.dialog.listener.OnClickListener;
import izijia.ccpress.com.mylibrary.toast.ToastUtil;
import izijia.ccpress.com.mylibrary.utils.OSUtils;
import okhttp3.internal.cache.DiskLruCache;
import pub.devrel.easypermissions.EasyPermissions;

import static android.view.ActionMode.TYPE_PRIMARY;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, EasyPermissions.PermissionCallbacks, ViewTreeObserver.OnScrollChangedListener {

    private CoustomWebview webView;
    private Button redButton, colorButton;
    private RelativeLayout rlRoot;

    private Context mContext;
    private TextView left;
    private TextView center;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        App.setCustomDensity(mContext, getApplication());
        setContentView(R.layout.activity_main);

        rlRoot = (RelativeLayout) findViewById(R.id.rl_root);
        webView = (CoustomWebview) findViewById(R.id.webview);
        redButton = (Button) findViewById(R.id.red);
        colorButton = (Button) findViewById(R.id.color);
        left = (TextView) findViewById(R.id.left);
        center = (TextView) findViewById(R.id.center);


        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        float density = displayMetrics.widthPixels / 360;
        int densityDpi = (int) (density * 160);


        left.setText("设置的" + density + "   " + densityDpi + "  " + displayMetrics.widthPixels);


        redButton.setOnClickListener(this);
        colorButton.setOnClickListener(this);
//        initWebView();
        webView.loadUrl("file:///android_asset/test.html"); //加载assets文件中的H5页面
//        webView.loadUrl("http://dev.m.baobaot.com/common/article_detail?cid=6");

        WebSettings settings = webView.getSettings();

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);


            }
        });


        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ExampleBean.class, new TypeAdapter<ExampleBean>() {
                    @Override
                    public void write(JsonWriter out, ExampleBean value) throws IOException {
                        out.value("aaaa");
                    }

                    @Override
                    public ExampleBean read(JsonReader in) throws IOException {

                        ExampleBean exampleBean = new ExampleBean(true, "aaaaa", "aaa");

                        return exampleBean;
                    }
                })
                .create();


        ToastUtil.toast(mContext, "吐司");


        webView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Log.e("asas", item.getTitle().toString());

                        return true;
                    }
                };

            }
        });


        ExecutorService executorService = Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(4);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(2);

        executorService.isTerminated();

        executorService.isTerminated();


//        TypedValue

//        setMenu();

//        webView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
////                startActionMode(callback);
//                return true;
//            }
//        });
//
//        callback= new ActionMode.Callback() {
//            @Override
//            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//
//
//
////                mode.getMenuInflater().inflate(R.menu.wv_menu,menu);
//
//
//                return true;
//            }
//
//            @Override
//            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//                return false;
//            }
//
//            @Override
//            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//
//                Log.e("点击","点击");
//
//                return false;
//            }
//
//            @Override
//            public void onDestroyActionMode(ActionMode mode) {
//
//            }
//        };
    }


    ActionMode.Callback callback;

    @Override
    public void onActionModeStarted(ActionMode mode) {
        Menu menu = mode.getMenu();

        for (int i = (menu.size() - 1); i >= 0; i--) {
//            if (!menu.getItem(i).getTitle().toString().equals("全选")) {
            menu.removeItem(menu.getItem(i).getItemId());
//            }
        }
//        menu.add("item1");
//        menu.add("item2");
//        menu.add("item3");
//        menu.add("item4");
//        Log.e("onActionModeStarted","sssss");
        super.onActionModeStarted(mode);
    }


    @Override
    public void onScrollChanged() {

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("生命周期", "MainActivity+onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("生命周期", "MainActivity+onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("生命周期", "MainActivity+onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("生命周期", "MainActivity+onPause");
    }

    /**
     * 初始化WebView
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("JavascriptInterface")  //添加该字段
    private void initWebView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);  //设置运行使用JS

        CookieManager.getInstance()
                .setCookie("aa", "aaaa");


        ButtonClick click = new ButtonClick();
        JsPurchase jsPurchase = new JsPurchase();
        //这里添加JS的交互事件，这样H5就可以调用原生的代码
        webView.addJavascriptInterface(jsPurchase, "BBT_APP");

        webView.evaluateJavascript("aaa", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.red:  //调用JS中的无参数方法
//                webView.loadUrl("javascript:setRed()");
//                startActivity(new Intent(this, Test2Activity.class));
                View inflate = LayoutInflater.from(this).inflate(izijia.ccpress.com.mylibrary.R.layout.toast_view, null);
//                Snackbar.make(webView, "sdfsdf", Snackbar.LENGTH_LONG)
//                        .setAction("确定", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                ToastUtil.toast(MainActivity.this, "发个好地方个好地方");
//                            }
//                        })
//                        .show();


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

//                startActivity(new Intent(this, TeastActivity.class));

                break;
            case R.id.color://调用JS中的有参数方法
//                webView.loadUrl("javascript:setColor('#00f','代码的触发事件')");
//                startActivity(new Intent(this, TestActivity.class));
////                startActivity(new Intent(this, HomeActivity.class));
//                ToastUtil.toast(MainActivity.this, "和国家科技和客户就1");
//                break;

                if (EasyPermissions.hasPermissions(this, "android.permission.READ_EXTERNAL_STORAGE")) {


                } else {
                    EasyPermissions.requestPermissions(this, "是否授权存储!", 100, "android.permission.READ_EXTERNAL_STORAGE");
                }
            default:
        }
    }


    private static void grantUriPermission(Context context, Uri fileUri, Intent intent) {
        List<ResolveInfo> resInfoList = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        for (ResolveInfo resolveInfo : resInfoList) {
            String packageName = resolveInfo.activityInfo.packageName;
            context.grantUriPermission(packageName, fileUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        // Some permissions have been granted
        // ...
        ToastUtil.toast(this, "授权成功" + requestCode);
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
        // Some permissions have been denied
        // ...
        ToastUtil.toast(this, "授权失败" + requestCode);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void explode(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        intent.putExtra("flag", "explode");
        startActivity(intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void slide(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        intent.putExtra("flag", "slide");
        startActivity(intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void fade(View view) {
        Intent intent = new Intent(this, TestActivity.class);
        intent.putExtra("flag", "fade");
        startActivity(intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
    }


    public class JsPurchase {
        //Map<String,String> map=new HashMap<>();

        @JavascriptInterface
        public void goPurchase(String jsPurchaseList) {

//            Intent intent=new Intent(WebActivity.this, PurchaseActivity.class);
//            startActivity(intent);

            Log.e("aaa", jsPurchaseList);
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
                startActivity(new Intent(MainActivity.this, Test3Activity.class));
//                startActivity(new Intent(MainActivity.this, TestActivity.class));
//                String[] mString = {"1233", "1233", "1233", "1233", "1233"};
//
//                ArrayList<String> mArray = new ArrayList<>();
//                mArray.add("sdfdfdf");
//                mArray.add("sdfdfdf");
//                mArray.add("sdfdfdf");
//                mArray.add("sdfdfdf");
//                mArray.add("sdfdfdf");
//                new BaseBottomDialog()
//                        .setmArrays(mArray)
//                        .setOnClickListener(new OnClickListener() {
//                            @Override
//                            public void setOnClickListner(View view, int position) {
////                                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_LONG).show();
//                                ToastUtil.toast(MainActivity.this, "和国家科技和客户就1");
//                            }
//                        })
//                        .show(getSupportFragmentManager(), "sss");


            } else {

//                BaseCenterMsgDialog.newInstance()
//                        .setTitle("这是标题")
//                        .setContent("OSUtils" + OSUtils.getDefaultDisplay(MainActivity.this)
//                                .getHeight() + "  :  " + OSUtils.getDefaultDisplay(MainActivity.this)
//                                .getWidth() + "  :  " + OSUtils.getDeviceName() + "  :   " + OSUtils.getDeviceProduct())
//                        .setBaseListener(new BaseListener() {
//                            @Override
//                            public void setOnClickListner(View view) {
//                                Toast.makeText(MainActivity.this, "点击了确定", Toast.LENGTH_LONG).show();
//                            }
//                        })
//                        .show(MainActivity.this)
//                        .setCancelable(false);

//                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_right);
            }
        }
    }


}

class ContainerHelpers {

    // This is Arrays.binarySearch(), but doesn't do any argument validation.
    static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }

    static int binarySearch(long[] array, int size, long value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final long midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }
}
