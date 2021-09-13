package com.example.androidwebbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener

{

    private Button searchButtonHome;
    private EditText InputURL;
    private Button facebook_btn;
    private Button youtube_btn;
    private Button instagram_btn;
    private Button google_btn;
    private Button snapchat_btn;
    private Button yahoo_btn;
    private ProgressDialog Loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Loadingbar = new ProgressDialog(this);

        searchButtonHome = findViewById(R.id.search_button_home);
        InputURL = findViewById(R.id.search_url_home);
        facebook_btn = findViewById(R.id.facebook);
        youtube_btn = findViewById(R.id.youtube);
        instagram_btn = findViewById(R.id.instagram);
        google_btn = findViewById(R.id.google);
        snapchat_btn = findViewById(R.id.snapChat);
        yahoo_btn = findViewById(R.id.yahoo);

        Loadingbar.setTitle("Cat Browser.....");
        Loadingbar.setMessage("Welcome to the world fastest browser.");
        Loadingbar.show();


        searchButtonHome.setOnClickListener(this);
        facebook_btn.setOnClickListener(this);
        youtube_btn.setOnClickListener(this);
        instagram_btn.setOnClickListener(this);
        google_btn.setOnClickListener(this);
        snapchat_btn.setOnClickListener(this);
        yahoo_btn.setOnClickListener(this);


    }



    @Override
    public void onClick(View view) {

        if (view == searchButtonHome){

           openWebsite();

        }
        if (view == facebook_btn){

            Intent open_facebook = new Intent(HomeActivity.this,UrlSearch.class);
            open_facebook.putExtra("url_address", "https://www.facebook.com");
            startActivity(open_facebook);
        }

        if (view == youtube_btn){

            Intent open_youtube = new Intent(HomeActivity.this,UrlSearch.class);
            open_youtube.putExtra("url_address", "https://www.youtube.com");
            startActivity(open_youtube);
        }

        if (view == instagram_btn){

            Intent open_instagram = new Intent(HomeActivity.this,UrlSearch.class);
            open_instagram.putExtra("url_address", "https://www.instagram.com");
            startActivity(open_instagram);
        }

        if (view == google_btn){

            Intent open_google = new Intent(HomeActivity.this,UrlSearch.class);
            open_google.putExtra("url_address", "https://www.google.com");
            startActivity(open_google);
        }

        if (view == snapchat_btn){

            Intent open_snapchat = new Intent(HomeActivity.this,UrlSearch.class);
            open_snapchat.putExtra("url_address", "https://www.snapchat.com");
            startActivity(open_snapchat);
        }

        if (view == yahoo_btn){

            Intent open_yahoo = new Intent(HomeActivity.this,UrlSearch.class);
            open_yahoo.putExtra("url_address", "https://www.yahoo.com");
            startActivity(open_yahoo);
        }

    }

    private void openWebsite()

    {
          Loadingbar.setTitle("Loading.....");
          Loadingbar.setMessage("Please wait while we are opening your requested web address ");
          Loadingbar.show();


        String Url_Address = InputURL.getText().toString();
        if (TextUtils.isEmpty(Url_Address)){

            Toast empty = Toast.makeText(HomeActivity.this,"Please enter Url or Web Address",Toast.LENGTH_LONG);
            empty.show();
        }
        else {
            String url_without_https = Url_Address.replaceAll("https://www.","");
            String https = "https://";
            String www = "www.";

            Intent search = new Intent(HomeActivity.this, UrlSearch.class);
            search.putExtra("url_address" , https + www + url_without_https );
            startActivity(search);

            InputURL.setText("");
            InputURL.requestFocus();
        }
    }
}