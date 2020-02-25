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

public class LiveScoreActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView tvLiveTv, tvLiveScore, tvPointTable, tvCricNews, tvSchedule, tvRanking, tvSeries, tvGallery, tvVideo, tvAboutUs, tvRateUs, tvFeedback;
    private ImageView ivNavIcon;
    private String url = APIs.LiveScore;
    private WebView wvLiveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_score);
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
                Intent intent = new Intent(LiveScoreActivity.this, LiveTvActivity.class);
                startActivity(intent);
                finish();


            }
        });

        tvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveScoreActivity.this, VideoActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });
        tvPointTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveScoreActivity.this, PointTableActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvCricNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveScoreActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveScoreActivity.this, ScheduleActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveScoreActivity.this, RankingActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveScoreActivity.this, GalleryActivity.class);
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
            wvLiveScore.getSettings().setJavaScriptEnabled(true);
            wvLiveScore.loadDataWithBaseURL(url, document.toString(), "text/html", "utf-8", "");
            wvLiveScore.setWebViewClient(new MyWebViewClient());
            wvLiveScore.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((keyCode == KeyEvent.KEYCODE_BACK) && (wvLiveScore.canGoBack())) {
                        wvLiveScore.goBack();
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
            wvLiveScore.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            wvLiveScore.setVisibility(View.VISIBLE);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }

    private void idFinder() {
        wvLiveScore = findViewById(R.id.wvId);
        ivNavIcon = findViewById(R.id.ivNavIcon);
        drawerLayout = findViewById(R.id.LiveScoreDrawerId);
        tvLiveTv = findViewById(R.id.tvNavLiveScoreLiveTvId);
        tvVideo = findViewById(R.id.tvNavLiveScoreVideoId);
        tvLiveScore = findViewById(R.id.tvNavLiveScore_LiveScoreId);
        tvPointTable = findViewById(R.id.tvNavLiveScorePointTableId);
        tvCricNews = findViewById(R.id.tvNavLiveScoreCricNewsId);
        tvSchedule = findViewById(R.id.tvNavLiveScoreScheduleId);
        tvRanking = findViewById(R.id.tvNavLiveScoreRankingId);
        tvGallery = findViewById(R.id.tvNavLiveScoreGalleryId);
        tvRateUs = findViewById(R.id.tvNavLiveScoreRateUsId);
        tvFeedback = findViewById(R.id.tvNavLiveScoreFeedBackId);
    }

    @Override
    public void onBackPressed() {
        if (wvLiveScore.canGoBack()) {
            wvLiveScore.goBack();
        } else {
            Intent intent = new Intent(LiveScoreActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
