package com.trustedoffer.sports19.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.StrictMode;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.trustedoffer.sports19.Helper.APIs;
import com.trustedoffer.sports19.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PointTableActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView tvLiveTv, tvLiveScore, tvPointTable, tvCricNews, tvSchedule, tvRanking, tvSeries, tvGallery, tvVideo, tvAboutUs, tvRateUs, tvFeedback;
    private ImageView ivNavIcon;
    private WebView wvPointTable;
    private String url = APIs.PointTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_table);
        idFinder();
        loadURL();
        NavDrawerOperation();
    }

    private void NavDrawerOperation() {
        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        ivNavIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);


            }
        });
        tvLiveTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(PointTableActivity.this, LiveTvActivity.class);
                startActivity(intent);
                finish();


            }
        });

        tvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(PointTableActivity.this, VideoActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(PointTableActivity.this, LiveScoreActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvPointTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);


            }
        });
        tvCricNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(PointTableActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(PointTableActivity.this, ScheduleActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(PointTableActivity.this, RankingActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(PointTableActivity.this, GalleryActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void loadURL() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            Document document = Jsoup.connect(url).get();
            document.getElementsByClass("cbz-leaderboard-banner").remove();
            document.getElementsByClass("row cbz-div-header").remove();
            document.getElementsByClass("table-responsive").remove();
            document.getElementsByClass("footer-list-menu").remove();
            document.getElementsByClass("ui-footer").remove();
            document.getElementById("bottom-banner").remove();
            WebSettings webSettings = wvPointTable.getSettings();
            webSettings.setJavaScriptEnabled(true);
            wvPointTable.loadDataWithBaseURL(url, document.toString(), "text/html", "utf-8", "");
            wvPointTable.setWebViewClient(new MyWebViewClient());
            wvPointTable.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (wvPointTable.canGoBack() && (keyCode == KeyEvent.KEYCODE_BACK)) {
                        wvPointTable.goBack();
                        return true;
                    }
                    return false;

                }
            });

        } catch (Exception e) {

        }
    }

    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            wvPointTable.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            wvPointTable.setVisibility(View.VISIBLE);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }

    private void idFinder() {
        wvPointTable = findViewById(R.id.wvId);
        ivNavIcon = findViewById(R.id.ivNavIcon);
        drawerLayout = findViewById(R.id.PointTableDrawerId);
        tvLiveTv = findViewById(R.id.tvNavPointTableLiveTvId);
        tvVideo = findViewById(R.id.tvNavPointTableVideoId);
        tvLiveScore = findViewById(R.id.tvNavPointTableLiveScoreId);
        tvPointTable = findViewById(R.id.tvNavPointTable_PointTableId);
        tvCricNews = findViewById(R.id.tvNavPointTableCricNewsId);
        tvSchedule = findViewById(R.id.tvNavPointTableScheduleId);
        tvRanking = findViewById(R.id.tvNavPointTableRankingId);
        tvGallery = findViewById(R.id.tvNavPointTableGalleryId);
        tvRateUs = findViewById(R.id.tvNavPointTableRateUsId);
        tvFeedback = findViewById(R.id.tvNavPointTableFeedBackId);
    }

    @Override
    public void onBackPressed() {
        if (wvPointTable.canGoBack()) {
            wvPointTable.goBack();
        } else {
            Intent intent = new Intent(PointTableActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
