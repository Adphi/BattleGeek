package fr.wcs.battlegeek;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        ImageButton settings = (ImageButton) findViewById(R.id.button_settings);
        ImageButton trophy = (ImageButton) findViewById(R.id.button_trophy);
        Button easyPlay = (Button) findViewById(R.id.button_easy);
        Button mediumPlay = (Button) findViewById(R.id.button_medium);
        Button hardPlay = (Button) findViewById(R.id.button_hard);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, SettingsActivity.class);
                startActivity(intent);
            }

        });

        trophy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, RankingActivity.class);
                startActivity(intent);
            }

        });

        easyPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, CreateMapActivity.class);
                startActivity(intent);
            }

        });

        mediumPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, CreateMapActivity.class);
                startActivity(intent);
            }

        });

        hardPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, CreateMapActivity.class);
                startActivity(intent);
            }

        });

    }
}