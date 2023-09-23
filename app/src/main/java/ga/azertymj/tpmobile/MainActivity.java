package ga.azertymj.tpmobile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ImageView setting;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisation des préférences partagées
        preferences = getSharedPreferences("MyTasks", Context.MODE_PRIVATE);

        this.setting = (ImageView) findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), Setting.class);
                startActivity(otherActivity);
            }
        });

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();

        // Charger les tâches enregistrées lors du démarrage de l'application
        loadTasks();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Sauvegarder les tâches lorsque l'application est mise en pause
        saveTasks();
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Task Removed", Toast.LENGTH_LONG).show();

                items.remove(i);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View view) {
        EditText input = findViewById(R.id.editText2);
        String itemText = input.getText().toString();

        if (!itemText.equals("")) {
            itemsAdapter.add(itemText);
            input.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Please enter text...", Toast.LENGTH_LONG).show();
        }
    }

    // Méthode pour sauvegarder les tâches
    private void saveTasks() {
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> taskSet = new HashSet<>(items);
        editor.putStringSet("tasks", taskSet);
        editor.apply();
    }

    // Méthode pour charger les tâches
    private void loadTasks() {
        Set<String> taskSet = preferences.getStringSet("tasks", new HashSet<>());
        items.addAll(taskSet);
        itemsAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // L'utilisateur a appuyé sur le bouton de retour, affichez la boîte de dialogue de confirmation
            showExitConfirmationDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // Fonction pour afficher la boîte de dialogue de confirmation de sortie
    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Quitter l'application");
        builder.setMessage("Êtes-vous sûr de vouloir quitter l'application ?");
        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Action à effectuer lorsque l'utilisateur confirme la sortie
                finish();
            }
        });
        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Action à effectuer lorsque l'utilisateur annule la sortie
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
