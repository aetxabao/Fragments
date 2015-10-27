package com.pmdm.fragments;

import android.app.Fragment;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetalleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    /**
     * Mostrar imagen
     */
    public void mostrarDetalle(int num) {
        String strUrl;
        String[] webs = getView().getResources().getStringArray(R.array.webs);
        strUrl = webs[num];
        Log.d("LOG","url: " + strUrl);
        WebView webView = (WebView) getView().findViewById(R.id.WebViewZona);
        WebSettings webViewSettings = webView.getSettings();
        webViewSettings.setJavaScriptEnabled(true);
        webViewSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webViewSettings.setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setAllowFileAccess(true);
        webView.setSoundEffectsEnabled(true);
        webView.setWebViewClient(new SSLTolerentWebViewClient());
        webView.loadUrl(strUrl);
    }

    // SSL Error Tolerant Web View Client
    // http://stackoverflow.com/questions/7416096/android-webview-not-loading-https-url
    private class SSLTolerentWebViewClient extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }
    }
}
