package com.zww.music_mvvm.ui.home;

import static com.zww.music_mvvm.data.Config.Constant.BANNER_URI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hjq.toast.ToastUtils;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.zww.music_mvvm.Base.BaseActivity;
import com.zww.music_mvvm.R;
import com.zww.music_mvvm.data.Config;
import com.zww.music_mvvm.databinding.ActivityWebBinding;
import com.zww.music_mvvm.utils.ClickUtil;

@Route(path = Config.ROUTE_WEB)
public class WebActivity extends BaseActivity {

    private ActivityWebBinding binding;

    WebView webView;
    TextView title;

    @Autowired(name = "url") String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(binding.getRoot());
        // 使用ARouter 对本页面的属性通过传入的参数进行注入。
        ARouter.getInstance().inject(this);

        initView();
    }

    private void initView() {
        binding.web.setSettings(this);
//        String url = getIntent().getStringExtra(BANNER_URI);
        binding.web.getTitle(title->{
            binding.title.tvTitle.setText(title);
            binding.title.tvTitle.setVisibility(View.VISIBLE);
            return null;
        });
        binding.web.setUrl(url);
        binding.title.ivBack.setOnClickListener(view->{
            if (ClickUtil.enableClick()){
                finish();
            }
        });
    }

    /**
    @SuppressLint("SetJavaScriptEnabled")
    private void initData() {
//
        Log.e("网址",url);
        webView.loadUrl(url);
        webView.getSettings().setGeolocationEnabled(false);//定位
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(client);
        webView.setWebChromeClient(webChromeClient);
        saveData(webView);

        if (webView.getX5WebViewExtension() != null){
            webView.getX5WebViewExtension().setVerticalScrollBarEnabled(false);  //滑动
            Log.e("QbSdk内部",webView.getX5WebViewExtension().toString());
            Log.e("QbSdk内核版本", QbSdk.getTbsVersion(this)+"");
            webView.getSettingsExtension().setDisplayCutoutEnable(true); //适配刘海屏
        }else {
            ToastUtils.show("X5内核未启动");
            String x5CrashInfo = WebView.getCrashExtraMessage(this);
            Log.e("QbSdk", x5CrashInfo+"");
        }
        webView.setWebViewClient(client);
        webView.setWebChromeClient(webChromeClient);
        Log.e("当前UserAgentString",webView.getSettings().getUserAgentString());

    }

    private void saveData(WebView webView) {
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        String appCach = getApplicationContext().getCacheDir().getAbsolutePath();
        Log.d("WebViewCache:",appCach);
        webView.getSettings().setAppCachePath(appCach);  //设定缓存地址
    }

    WebViewClient client = new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String s) {
            //拦截url调整系统浏览器
            webView.loadUrl(s);
            return false;
        }
    };
//
    WebChromeClient webChromeClient = new WebChromeClient (){

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
//            if (i ==100){
//                pg.setVisibility(View.GONE);
//            }
        }

        @Override
        public void onReceivedTitle(WebView webView, String s) {
            super.onReceivedTitle(webView, s);
            Log.e("标题",s);
//            设定标题
//            setTitleText(s);
            title.setText(s);
        }
    };
*/
    @Override
    protected View getDataBind() {
        binding = ActivityWebBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.web.setResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        binding.web.setPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.web.setDestroy();
    }
}