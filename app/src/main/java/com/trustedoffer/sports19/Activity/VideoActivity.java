package com.trustedoffer.sports19.Activity;

import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.trustedoffer.sports19.R;
import com.trustedoffer.sports19.Adapter.ViewPagerAdapter;

public class VideoActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView tvLiveTv, tvLiveScore, tvPointTable, tvCricNews, tvSchedule, tvRanking, tvSeries, tvGallery, tvVideo, tvAboutUs, tvRateUs, tvFeedback;
    private ImageView ivNavIcon;

    private TabLayout tlVideo;
    private TabItem tiHighlights, tiUnofficialVideo;
    private ViewPager vpVideo;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        idFinder();
        loadFragment();
        NavDrawerOperations();

    }

    private void NavDrawerOperations() {
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
                Intent intent = new Intent(VideoActivity.this, LiveTvActivity.class);
                startActivity(intent);
                finish();


            }
        });
        tvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);


            }
        });
        tvLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(VideoActivity.this, LiveScoreActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvPointTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(VideoActivity.this, PointTableActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvCricNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(VideoActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(VideoActivity.this, ScheduleActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(VideoActivity.this, RankingActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(VideoActivity.this, GalleryActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }

    private void loadFragment() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tlVideo.getTabCount());
        vpVideo.setAdapter(viewPagerAdapter);
        vpVideo.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlVideo));
    }

    private void idFinder() {
        drawerLayout = findViewById(R.id.VideoDrawerId);
        ivNavIcon = findViewById(R.id.ivNavIcon);
        tvLiveTv = findViewById(R.id.tvNavVideoLiveTvId);
        tvVideo = findViewById(R.id.tvNavVideoVideoId);
        tvLiveScore = findViewById(R.id.tvNavVideoLiveScoreId);
        tvPointTable = findViewById(R.id.tvNavVideoPointTableId);
        tvCricNews = findViewById(R.id.tvNavVideoCricNewsId);
        tvSchedule = findViewById(R.id.tvNavVideoScheduleId);
        tvRanking = findViewById(R.id.tvNavVideoRankingId);
        tvGallery = findViewById(R.id.tvNavVideoGalleryId);
        tvRateUs = findViewById(R.id.tvNavVideoRateUsId);
        tvFeedback = findViewById(R.id.tvNavVideoFeedBackId);
        tlVideo = findViewById(R.id.tlVideoId);
        tiHighlights = findViewById(R.id.tbiVideoHighlightsId);
        tiUnofficialVideo = findViewById(R.id.tbiVideoUnofficialVideoId);
        vpVideo = findViewById(R.id.vpVideoId);

    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(VideoActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }


}
