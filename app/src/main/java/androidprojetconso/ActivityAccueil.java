package androidprojetconso;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityAccueil extends AppCompatActivity {
    TextView tv1, tv2;
    EditText etIp;
    Button btIp;
    Spinner spinnerAccueil;

public static String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_accueil);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Déclaration des widgets
        this.tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText("IP Serveur :");

        this.tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setText("id abonné :");

        this.etIp = (EditText) findViewById(R.id.etIp);
        ip = String.valueOf(etIp.getText());
        //etIp.setText("194.199.35.123");

        this.btIp = (Button)findViewById(R.id.btIp);
        Typeface Font1 = Typeface.createFromAsset(getAssets(), "fonts/Android.ttf");
        btIp.setTypeface(Font1);

        //Choix id
        spinnerAccueil = (Spinner) findViewById(R.id.spinnerAccueil);
        String[] liste = new String[]{"1", "2", "3", "4", "5", "6"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, liste);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerAccueil.setAdapter(adapter);

        // Méthode menu déroulant
        spinnerAccueil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {}
            public void onNothingSelected(AdapterView<?> parent) {}
        });//

    }

         //Action sur bouton "Connexion"
        public void onClickSurBouton(View v) {
        Intent intentActivity = new Intent(this, ActivityApercu.class);
        intentActivity.putExtra("IP", etIp.getText().toString());
        intentActivity.putExtra("ID", spinnerAccueil.getSelectedItem().toString());
        startActivity(intentActivity);
        }
}

