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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.trustedoffer.sports19.Helper.APIs;
import com.trustedoffer.sports19.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class NewsActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView tvLiveTv, tvLiveScore, tvPointTable, tvCricNews, tvSchedule, tvRanking, tvSeries, tvGallery, tvVideo, tvAboutUs, tvRateUs, tvFeedback;
    private ImageView ivNavIcon;
    private String url = APIs.CricNews;
    private WebView wvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
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
                Intent intent = new Intent(NewsActivity.this, LiveTvActivity.class);
                startActivity(intent);
                finish();


            }
        });

        tvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(NewsActivity.this, VideoActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(NewsActivity.this, LiveScoreActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvPointTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(NewsActivity.this, PointTableActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvCricNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });
        tvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(NewsActivity.this, ScheduleActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(NewsActivity.this, RankingActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(NewsActivity.this, GalleryActivity.class);
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
            //document.getElementsByAttributeValue("span","font-size:12px;margin-left:10px").remove();
            wvNews.getSettings().setJavaScriptEnabled(true);
            wvNews.loadDataWithBaseURL(url, document.toString(), "text/html", "utf-8", "");
            wvNews.setWebViewClient(new MyWebViewClient());
            wvNews.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((keyCode == KeyEvent.KEYCODE_BACK) && (wvNews.canGoBack())) {
                        wvNews.goBack();
                        return true;
                    }
                    return false;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
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
            wvNews.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            wvNews.setVisibility(View.VISIBLE);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }

    private void idFinder() {
        wvNews = findViewById(R.id.wvId);
        ivNavIcon = findViewById(R.id.ivNavIcon);
        drawerLayout = findViewById(R.id.NewsDrawerId);
        tvLiveTv = findViewById(R.id.tvNavNewsLiveTvId);
        tvVideo = findViewById(R.id.tvNavNewsVideoId);
        tvLiveScore = findViewById(R.id.tvNavNewsLiveScoreId);
        tvPointTable = findViewById(R.id.tvNavNewsPointTableId);
        tvCricNews = findViewById(R.id.tvNavNewsCricNewsId);
        tvSchedule = findViewById(R.id.tvNavNewsScheduleId);
        tvRanking = findViewById(R.id.tvNavNewsRankingId);
        tvGallery = findViewById(R.id.tvNavNewsGalleryId);
        tvRateUs = findViewById(R.id.tvNavNewsRateUsId);
        tvFeedback = findViewById(R.id.tvNavNewsFeedBackId);
    }

    @Override
    public void onBackPressed() {
        if (wvNews.canGoBack()) {
            wvNews.goBack();
        } else {
            Intent intent = new Intent(NewsActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
