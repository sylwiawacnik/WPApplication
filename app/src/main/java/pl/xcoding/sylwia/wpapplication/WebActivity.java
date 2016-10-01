package pl.xcoding.sylwia.wpapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.drawee.backends.pipeline.Fresco;



public class WebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
          setContentView(R.layout.web_layout);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        Bundle bundleMore = getIntent().getExtras();
        String string = bundleMore.getString("data");
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(string);


    }
}
