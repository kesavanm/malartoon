/*
    Update 2
    2014-03-22
 */

package info.kesavan.malartoon;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    String answer;

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                answer="You are connected to a WiFi Network";
            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                answer="You are connected to a Mobile Network\n" +
                        "You may charged! ";
        }
        else
            answer = "No internet Connectivity.Please use Internet connection to use this app!";
        Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();

        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

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
            String uri = "http://www.kesavan.info/services/toon.php?choose=y";
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl(uri);
            return true;
        }

        if(id == R.id.action_thanks){
            String uri = "http://www.kesavan.info/feedback.php";
                mWebView.loadUrl(uri);
                // TODO Auto-generated method stub
        }

        if(id == R.id.action_exit){
            finish();
            System.exit(0);
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


