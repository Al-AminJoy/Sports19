package com.trustedoffer.sports19.Activity;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trustedoffer.sports19.R;

public class LiveTvActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView tvLiveTv, tvLiveScore, tvPointTable, tvCricNews, tvSchedule, tvRanking, tvSeries, tvGallery, tvVideo, tvAboutUs, tvRateUs, tvFeedback;
    private ImageView ivNavIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_tv);
        idFinder();
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

            }
        });
        tvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveTvActivity.this, VideoActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveTvActivity.this, LiveScoreActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvPointTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveTvActivity.this, PointTableActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvCricNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveTvActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveTvActivity.this, ScheduleActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveTvActivity.this, RankingActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(LiveTvActivity.this, GalleryActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void idFinder() {
        drawerLayout = findViewById(R.id.LiveTvDrawerId);
        ivNavIcon = findViewById(R.id.ivNavIcon);
        tvLiveTv = findViewById(R.id.tvNavLiveTv_LiveTvId);
        tvVideo = findViewById(R.id.tvNavLiveTvVideoId);
        tvLiveScore = findViewById(R.id.tvNavLiveTvLiveScoreId);
        tvPointTable = findViewById(R.id.tvNavLiveTvPointTableId);
        tvCricNews = findViewById(R.id.tvNavLiveTvCricNewsId);
        tvSchedule = findViewById(R.id.tvNavLiveTvScheduleId);
        tvRanking = findViewById(R.id.tvNavLiveTvRankingId);
        tvGallery = findViewById(R.id.tvNavLiveTvGalleryId);
        tvRateUs = findViewById(R.id.tvNavLiveTvRateUsId);
        tvFeedback = findViewById(R.id.tvNavLiveTvFeedBackId);

    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(LiveTvActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
