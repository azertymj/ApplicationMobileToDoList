package ga.azertymj.tpmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class setting4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting4);
    }
    @Override
    public void onBackPressed() {
        // Redirection vers une autre activité
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
        finish(); // Facultatif, pour fermer l'activité actuelle
    }

}