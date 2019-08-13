package com.example.onedream.flightapp.activity;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.onedream.flightapp.R;
import com.example.onedream.flightapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class WebActivity extends BaseActivity {
    String TAG = WebActivity.class.getSimpleName() + "";
    String url = "";
    @BindView(R.id.tv_tiltle)
    TextView tvTiltle;
    @BindView(R.id.web)
    WebView webview;


    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
            if (webview != null) {
                webview.destroy();
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webview != null) {
            webview.destroy();
        }
    }


    @Override
    public int getLayout() {
        return R.layout.activity_web;
    }

    @Override
    public void initView() {
        url = getIntent().getStringExtra("url");
        String name = getIntent().getStringExtra("name");
        if (!TextUtils.isEmpty(name)) {
            tvTiltle.setText(name);
        }
        WebSettings webSettings = webview.getSettings();
        //支持缩放，默认为true。
        webSettings.setSupportZoom(false);
        //调整图片至适合webview的大小
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setTextZoom(100);
        //设置默认编码
        webSettings.setDefaultTextEncodingName("utf-8");
        //设置自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        //多窗口
        webSettings.supportMultipleWindows();
        //获取触摸焦点
        webview.requestFocusFromTouch();
        //允许访问文件
        webSettings.setAllowFileAccess(true);
        //开启javascript
        webSettings.setJavaScriptEnabled(true);
        //支持通过JS打开新窗口
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //提高渲染的优先级
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        //支持内容重新布局
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //关闭webview中缓存
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webview.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                try {
                    String baseUrl = request.getUrl().toString();
                    if (baseUrl.startsWith("http:") || baseUrl.startsWith("https:")) {
                        view.loadUrl(baseUrl);
                        return false;
                    } else {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Log.i(TAG, "onReceivedError:"/*+error.getDescription()*/);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                Log.i(TAG, "onReceivedHttpError:");
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                Log.i(TAG, "onReceivedSslError:");
            }
        });

        webview.loadUrl(url);
    }


    @OnClick(R.id.tv_back)
    public void onViewClicked() {
        finish();
    }
}
