package net.thehvac.thehvacteam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class HomeActivity extends AppCompatActivity {
    private static Button button_sbm;
    private static EditText url_text;
    private static WebView browser;
    private static TextView standbytext;

    //private static Button button_sbm2;
    //private static textView url_text2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openURL();

        browser = (WebView) findViewById(R.id.activity_main_webView);

        //enable javascript
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.loadUrl("http://app.convectek.com/technician/");
        //this keeps clicks opening in the webview and not the default browser.
        browser.setWebViewClient(new WebViewClient());
    }


    public void openURL() {
        button_sbm =(Button)findViewById(R.id.button);
        url_text =(EditText)findViewById(R.id.editText);
        browser = (WebView)findViewById(R.id.activity_main_webView);


        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = url_text.getText().toString();
                            browser.getSettings().setLoadsImagesAutomatically(true);
                            browser.getSettings().setJavaScriptEnabled(true);
                            browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                            browser.loadUrl(url);

                        browser.postDelayed(new Runnable() {
                            public void run() {
                                browser.setVisibility(View.INVISIBLE);
                                standbytext.setVisibility(View.VISIBLE);
                            }
                        }, 5000);
                    }
                }
        );
    }

    @Override
    public void onBackPressed() {
        if (browser.canGoBack())
        {
            browser.goBack();

            browser.postDelayed(new Runnable() {
                public void run() {
                    browser.setVisibility(View.VISIBLE);
                }
            }, 3000);


        } else {
            //super.onBackPressed();
            //super.onBackPressed() is DISABLED
            //app wont close with back button.
        }
    }




}




