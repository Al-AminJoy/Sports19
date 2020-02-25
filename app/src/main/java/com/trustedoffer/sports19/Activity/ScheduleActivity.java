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

public class ScheduleActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView tvLiveTv, tvLiveScore, tvPointTable, tvCricNews, tvSchedule, tvRanking, tvSeries, tvGallery, tvVideo, tvAboutUs, tvRateUs, tvFeedback;
    private ImageView ivNavIcon;
    private String url = APIs.Schedule;
    private WebView wvSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
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
                Intent intent = new Intent(ScheduleActivity.this, LiveTvActivity.class);
                startActivity(intent);
                finish();


            }
        });

        tvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(ScheduleActivity.this, VideoActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(ScheduleActivity.this, LiveScoreActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvPointTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(ScheduleActivity.this, PointTableActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvCricNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(ScheduleActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });
        tvRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(ScheduleActivity.this, RankingActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(ScheduleActivity.this, GalleryActivity.class);
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
            document.getElementsByAttributeValue("span", "font-size:12px;margin-left:10px").remove();
            wvSchedule.getSettings().setJavaScriptEnabled(true);
            wvSchedule.loadDataWithBaseURL(url, document.toString(), "text/html", "utf-8", "");
            wvSchedule.setWebViewClient(new MyWebViewClient());
            wvSchedule.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((keyCode == KeyEvent.KEYCODE_BACK) && (wvSchedule.canGoBack())) {
                        wvSchedule.goBack();
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
            wvSchedule.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            wvSchedule.setVisibility(View.VISIBLE);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }

    private void idFinder() {
        wvSchedule = findViewById(R.id.wvId);
        ivNavIcon = findViewById(R.id.ivNavIcon);
        drawerLayout = findViewById(R.id.ScheduleDrawerId);
        tvLiveTv = findViewById(R.id.tvNavScheduleLiveTvId);
        tvVideo = findViewById(R.id.tvNavScheduleVideoId);
        tvLiveScore = findViewById(R.id.tvNavScheduleLiveScoreId);
        tvPointTable = findViewById(R.id.tvNavSchedulePointTableId);
        tvCricNews = findViewById(R.id.tvNavScheduleCricNewsId);
        tvSchedule = findViewById(R.id.tvNavSchedule_ScheduleId);
        tvRanking = findViewById(R.id.tvNavScheduleRankingId);
        tvGallery = findViewById(R.id.tvNavScheduleGalleryId);
        tvRateUs = findViewById(R.id.tvNavScheduleRateUsId);
        tvFeedback = findViewById(R.id.tvNavScheduleFeedBackId);
    }

    @Override
    public void onBackPressed() {
        if (wvSchedule.canGoBack()) {
            wvSchedule.goBack();
        } else {
            Intent intent = new Intent(ScheduleActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
