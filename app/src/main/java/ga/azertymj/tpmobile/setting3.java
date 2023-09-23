/*package ga.azertymj.tpmobile;

import android.os.Bundle;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import ga.azertymj.tpmobile.R;


public class setting3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting3);

        RadioGroup radioGroup = findViewById(R.id.RadioGroup); // Remplacez R.id.radioGroup par l'ID réel de votre RadioGroup

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioLight: // Remplacez R.id.radioTheme1 par l'ID réel de votre bouton radio
                        setTheme(R.style.color_light); // Changez le thème en utilisant le style approprié
                        recreate(); // Recréez l'activité pour appliquer le nouveau thème
                        break;

                    case R.id.radioDark: // Remplacez R.id.radioTheme2 par l'ID réel de votre autre bouton radio
                        setTheme(R.style.color_night);
                        recreate();
                        break;

                    // Ajoutez des cas pour d'autres options de thème si nécessaire

                    default:
                        break;
                }
            }        });
    }

    @Override
    public void onBackPressed() {
        // Redirection vers une autre activité
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
        finish(); // Facultatif, pour fermer l'activité actuelle
    }
}
*/
package ga.azertymj.tpmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class setting3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting3);
    }
    @Override
    public void onBackPressed() {
        // Redirection vers une autre activité
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
        finish(); // Facultatif, pour fermer l'activité actuelle
    }

}