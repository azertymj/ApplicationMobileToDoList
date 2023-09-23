package ga.azertymj.tpmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    private TextView setting_lang;
    private TextView setting_aid;
    private TextView setting_them;
    private TextView setting_aprop;
    private TextView setting_confid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        this.setting_lang = (TextView) findViewById(R.id.setting_lang);
        setting_lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), setting1.class);
                startActivity(otherActivity);
                finish();
            }
        });this.setting_aid = (TextView) findViewById(R.id.setting_aid);
        setting_aid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), setting2.class);
                startActivity(otherActivity);
                finish();
            }
        });this.setting_them = (TextView) findViewById(R.id.setting_them);
        setting_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), setting3.class);
                startActivity(otherActivity);
                finish();
            }
        });this.setting_aprop = (TextView) findViewById(R.id.setting_aprop);
        setting_aprop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), setting4.class);
                startActivity(otherActivity);
                finish();
            }
        });this.setting_confid = (TextView) findViewById(R.id.setting_confid);
        setting_confid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), setting5.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}