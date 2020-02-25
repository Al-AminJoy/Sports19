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

public class GalleryActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView tvLiveTv, tvLiveScore, tvPointTable, tvCricNews, tvSchedule, tvRanking, tvSeries, tvGallery, tvVideo, tvAboutUs, tvRateUs, tvFeedback;
    private ImageView ivNavIcon;
    private String url = APIs.CricGallery;
    private WebView wvGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        IdFinder();
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
                Intent intent = new Intent(GalleryActivity.this, LiveTvActivity.class);
                startActivity(intent);
                finish();


            }
        });

        tvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(GalleryActivity.this, VideoActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(GalleryActivity.this, LiveScoreActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvPointTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(GalleryActivity.this, PointTableActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvCricNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(GalleryActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(GalleryActivity.this, ScheduleActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(GalleryActivity.this, RankingActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
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
            wvGallery.getSettings().setJavaScriptEnabled(true);
            wvGallery.loadDataWithBaseURL(url, document.toString(), "text/html", "utf-8", "");
            wvGallery.setWebViewClient(new MyWebViewClient());
            wvGallery.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((keyCode == KeyEvent.KEYCODE_BACK) && (wvGallery.canGoBack())) {
                        wvGallery.goBack();
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
            wvGallery.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            wvGallery.setVisibility(View.VISIBLE);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }

    private void IdFinder() {
        wvGallery = findViewById(R.id.wvId);
        ivNavIcon = findViewById(R.id.ivNavIcon);
        drawerLayout = findViewById(R.id.GalleryDrawerId);
        tvLiveTv = findViewById(R.id.tvNavGalleryLiveTvId);
        tvVideo = findViewById(R.id.tvNavGalleryVideoId);
        tvLiveScore = findViewById(R.id.tvNavGalleryLiveScoreId);
        tvPointTable = findViewById(R.id.tvNavGalleryPointTableId);
        tvCricNews = findViewById(R.id.tvNavGalleryCricNewsId);
        tvSchedule = findViewById(R.id.tvNavGalleryScheduleId);
        tvRanking = findViewById(R.id.tvNavGalleryRankingId);
        tvGallery = findViewById(R.id.tvNavGallery_GalleryId);
        tvRateUs = findViewById(R.id.tvNavGalleryRateUsId);
        tvFeedback = findViewById(R.id.tvNavGalleryFeedBackId);
    }

    @Override
    public void onBackPressed() {
        if (wvGallery.canGoBack()) {
            wvGallery.goBack();
        } else {
            Intent intent = new Intent(GalleryActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
