package com.example.androidwebbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UrlSearch extends AppCompatActivity implements View.OnClickListener {

    private Button SearchUrlButton;
    private EditText UrlInput;
    private Button HomeButton;
    private WebView SearchWebAddress;
    String url;
    private ProgressDialog Loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_search);

        Loadingbar = new ProgressDialog(this);

        SearchUrlButton = findViewById(R.id.search_url_button);
        UrlInput = findViewById(R.id.input_search_Url);
        HomeButton = findViewById(R.id.home_button);
        SearchWebAddress = findViewById(R.id.SearchWebsite);

        url = getIntent().getExtras().get("url_address").toString();
        UrlInput.setText(url);

        WebSettings webSettings = SearchWebAddress.getSettings();
        webSettings.setJavaScriptEnabled(true);
        SearchWebAddress.loadUrl(url);
        SearchWebAddress.setWebViewClient(new WebViewClient());

        Loadingbar.setTitle("Loading.....");
        Loadingbar.setMessage("Please wait while we are opening your requested web address. ");
        Loadingbar.show();


      SearchUrlButton.setOnClickListener(this);
      HomeButton.setOnClickListener(this);




    }

    @Override
    public void onBackPressed() {

        if (SearchWebAddress.canGoBack()){

            SearchWebAddress.goBack();
        }

        else {

            super.onBackPressed();
        }

    }

    @Override
    public void onClick(View v) {

        if (v == HomeButton){

            finish();
            Intent homepage = new Intent(UrlSearch.this,HomeActivity.class);
            startActivity(homepage);
        }
        if (v == SearchUrlButton){

            SearchWebAddress();
        }


    }

    private void SearchWebAddress()
    {
        Loadingbar.setTitle("Loading.....");
        Loadingbar.setMessage("Please wait while we are opening your requested web address ");
        Loadingbar.show();

        String Url_Address = UrlInput.getText().toString();

        if (TextUtils.isEmpty(Url_Address)){

            Toast empty = Toast.makeText(UrlSearch.this,"Please enter Url or Web Address",Toast.LENGTH_LONG);
            empty.show();
        }

        else {
            String url_without_https = Url_Address.replaceAll("https://www.","");
            String https = "https://";
            String www = "www.";

            Intent search = new Intent(UrlSearch.this, UrlSearch.class);
            search.putExtra("url_address" , https + www + url_without_https );
            startActivity(search);

            UrlInput.setText("");
            UrlInput.requestFocus();
        }

    }
}