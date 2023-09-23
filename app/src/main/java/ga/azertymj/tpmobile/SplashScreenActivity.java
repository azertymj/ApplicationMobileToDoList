package ga.azertymj.tpmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //redireger vers la page principale "MainActivity" après 3 secondes.


        // handier post delayed
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //demarrer une page
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}