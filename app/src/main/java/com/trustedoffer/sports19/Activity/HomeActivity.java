package com.trustedoffer.sports19.Activity;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.trustedoffer.sports19.R;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView tvLiveTv, tvLiveScore, tvPointTable, tvCricNews, tvSchedule, tvRanking, tvSeries, tvGallery, tvVideo, tvAboutUs, tvRateUs, tvFeedback;
    private ImageView ivNavIcon;
    private CardView cvLiveScore;
    private Button btLiveTv,btRanking,btNews,btSchedule,btSeries,btPointTable,btGallery,btVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        idFinder();
        intentOperations();
        navDrawerOperation();
    }

    private void navDrawerOperation() {
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
                Intent intent = new Intent(HomeActivity.this, LiveTvActivity.class);
                startActivity(intent);
                finish();


            }
        });

        tvVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(HomeActivity.this, VideoActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(HomeActivity.this, LiveScoreActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvPointTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(HomeActivity.this, PointTableActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvCricNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(HomeActivity.this, ScheduleActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(HomeActivity.this, RankingActivity.class);
                startActivity(intent);
                finish();

            }
        });
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(HomeActivity.this, GalleryActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void intentOperations() {
        btLiveTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LiveTvActivity.class);
                startActivity(intent);
                finish();
            }
        });
        cvLiveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LiveScoreActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, VideoActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btPointTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, PointTableActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RankingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ScheduleActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, GalleryActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void idFinder() {

        ivNavIcon = findViewById(R.id.ivNavIcon);
        drawerLayout = findViewById(R.id.HomeDrawerId);
        tvLiveTv = findViewById(R.id.tvNavHomeLiveTvId);
        tvVideo = findViewById(R.id.tvNavHomeVideoId);
        tvLiveScore = findViewById(R.id.tvNavHomeLiveScoreId);
        tvPointTable = findViewById(R.id.tvNavHomePointTableId);
        tvCricNews = findViewById(R.id.tvNavHomeCricNewsId);
        tvSchedule = findViewById(R.id.tvNavHomeScheduleId);
        tvRanking = findViewById(R.id.tvNavHomeRankingId);
        tvGallery = findViewById(R.id.tvNavHomeGalleryId);
        tvRateUs = findViewById(R.id.tvNavHomeRateUsId);
        tvFeedback = findViewById(R.id.tvNavHomeFeedBackId);
        btLiveTv = findViewById(R.id.btHomeLiveTvId);
        cvLiveScore = findViewById(R.id.cvHomeLiveScoreId);
        btRanking = findViewById(R.id.btHomeRankingId);
        btNews = findViewById(R.id.btHomeNewsId);
        btSchedule = findViewById(R.id.btHomeScheduleId);
        btPointTable = findViewById(R.id.btHomePointTableId);
        btGallery = findViewById(R.id.btHomeGalleryId);
        btVideo = findViewById(R.id.btHomeVideoId);

    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }

}
