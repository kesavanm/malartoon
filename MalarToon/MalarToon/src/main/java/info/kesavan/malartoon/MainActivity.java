package info.kesavan.malartoon;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        String uri = "http://www.kesavan.info/";
*/
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        mWebView.loadUrl(uri);

        /**************************  TOON ACTION **********************/
        // Exit Code
        Button btn_toon = (Button) findViewById(R.id.button_open_toon);
        btn_toon.setOnClickListener(new View.OnClickListener() {

        String uri = "http://www.kesavan.info/services/toon.php";

         @Override
         public void onClick(View v) {
             mWebView.setWebViewClient(new WebViewClient());
             mWebView.loadUrl(uri);
                // TODO Auto-generated method stub
            }
        });


        /**************************  RAND ACTION **********************/
        // Exit Code
        Button btn_rand = (Button) findViewById(R.id.button_rand);
        btn_rand.setOnClickListener(new View.OnClickListener() {

            String uri = "http://www.kesavan.info/services/toon.php?rand";

            @Override
            public void onClick(View v) {
                mWebView.setWebViewClient(new WebViewClient());
                mWebView.loadUrl(uri);
                // TODO Auto-generated method stub
            }
        });

        /**************************  THANKS ACTION **********************/
        // Exit Code
        Button btn_thanks = (Button) findViewById(R.id.button_thanks);
        btn_thanks.setOnClickListener(new View.OnClickListener() {

            String uri = "http://www.kesavan.info/";

            @Override
            public void onClick(View v) {
                mWebView.loadUrl(uri);
                // TODO Auto-generated method stub
            }
        });



        /**************************  EXIT ACTION **********************/
        // Exit Code
        Button btn_exit = (Button) findViewById(R.id.button_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });

    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}