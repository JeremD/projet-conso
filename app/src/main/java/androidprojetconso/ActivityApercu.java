package androidprojetconso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ActivityApercu extends AppCompatActivity {
    TextView tvFluxJson, tvJSON;
    TextView tvDate1, tvDate2, tvDate3;
    TextView tvCourant1,tvCourant2,tvCourant3;
    TextView tvTension1,tvTension2,tvTension3;
    TextView tvP_active1,tvP_active2,tvP_active3;
    TextView tvP_apparente1,tvP_apparente2,tvP_apparente3;
    TextView tvP_reactive1,tvP_reactive2,tvP_reactive3;
    TextView tvF_puissance1,tvF_puissance2,tvF_puissance3;
    TextView tvE_totale1,tvE_totale2,tvE_totale3;
    Button btR;

    public static String Ip;
    Intent intentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_apercu);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        //Déclaration des widgets
        this.tvFluxJson = (TextView) findViewById(R.id.tvFluxJson);
        tvFluxJson.setText("Nom abonné :");
        tvFluxJson.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        //Date
        this.tvDate1 = (TextView) findViewById(R.id.tvDate1);
        this.tvDate2 = (TextView) findViewById(R.id.tvDate2);
        this.tvDate3 = (TextView) findViewById(R.id.tvDate3);

        //Tension
        this.tvTension1 = (TextView) findViewById(R.id.tvTension1);
        this.tvTension2 = (TextView) findViewById(R.id.tvTension2);
        this.tvTension3 = (TextView) findViewById(R.id.tvTension3);

        //Courant
        this.tvCourant1 = (TextView) findViewById(R.id.tvCourant1);
        this.tvCourant2 = (TextView) findViewById(R.id.tvCourant2);
        this.tvCourant3 = (TextView) findViewById(R.id.tvCourant3);

        //Puissance active
        this.tvP_active1 = (TextView) findViewById(R.id.tvP_active1);
        this.tvP_active2 = (TextView) findViewById(R.id.tvP_active2);
        this.tvP_active3 = (TextView) findViewById(R.id.tvP_active3);

        //Puissance apparente
        this.tvP_apparente1 = (TextView) findViewById(R.id.tvP_apparente1);
        this.tvP_apparente2 = (TextView) findViewById(R.id.tvP_apparente2);
        this.tvP_apparente3 = (TextView) findViewById(R.id.tvP_apparente3);

        //Puissance reactive
        this.tvP_reactive1 = (TextView) findViewById(R.id.tvP_reactive1);
        this.tvP_reactive2 = (TextView) findViewById(R.id.tvP_reactive2);
        this.tvP_reactive3 = (TextView) findViewById(R.id.tvP_reactive3);

        //Facteur de puissance
        this.tvF_puissance1 = (TextView) findViewById(R.id.tvF_puissance1);
        this.tvF_puissance2 = (TextView) findViewById(R.id.tvF_puissance2);
        this.tvF_puissance3 = (TextView) findViewById(R.id.tvF_puissance3);

        //Energie totale
        this.tvE_totale1 = (TextView) findViewById(R.id.tvE_totale1);
        this.tvE_totale2 = (TextView) findViewById(R.id.tvE_totale2);
        this.tvE_totale3 = (TextView) findViewById(R.id.tvE_totale3);

        // Récupération Ip Serveur
        Intent intentIP = getIntent();
        Bundle extra = intentIP.getExtras();
        //Récupération Ip abonné
        Intent intentID = getIntent();
        Bundle extra2 = intentID.getExtras();

        //Si connexion établie
        if (extra != null) {
            //IP du serveur et id abonné insérés dans l'URL
            String getIP = (String) extra.get("IP");
            String getID = (String) extra2.get("ID");
            Ip = "http://" + getIP + "/~prj-conso/WSProjet/WSTempsReel.php?id_abonne=" + getID;
            
        }//Fin Si
        

        //Récupération flux json
        this.tvJSON = (TextView) findViewById(R.id.tvJSON);
        IntentFilter intentFilter = new IntentFilter("donnees");

        //Démarrage du service cyclique et du broadcast
        registerReceiver(serviceReceiver, intentFilter);
        intentService = new Intent(this, ServiceCyclique.class);
        startService(intentService);


        //Bouton Retour
        this.btR = (Button) findViewById(R.id.btR);
        Typeface Font2 = Typeface.createFromAsset(getAssets(), "fonts/Android.ttf");
        btR.setTypeface(Font2);

        //Méthode Bouton Retour
        btR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View actuelView) {
                ActivityApercu.this.finish(); //Fin de l'activité
            }
        });

    }


    //Mise à jour des contrôles de la vue
    private BroadcastReceiver serviceReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            tvJSON.setText(intent.getStringExtra("Nom"));

            tvDate1.setText(intent.getStringExtra("D1"));
            tvDate2.setText(intent.getStringExtra("D2"));
            tvDate3.setText(intent.getStringExtra("D3"));

            tvTension1.setText(intent.getStringExtra("T1"));
            tvTension2.setText(intent.getStringExtra("T2"));
            tvTension3.setText(intent.getStringExtra("T3"));;

            tvCourant1.setText(intent.getStringExtra("C1"));
            tvCourant2.setText(intent.getStringExtra("C2"));
            tvCourant3.setText(intent.getStringExtra("C3"));

            tvP_active1.setText(intent.getStringExtra("PAC1"));
            tvP_active2.setText(intent.getStringExtra("PAC2"));
            tvP_active3.setText(intent.getStringExtra("PAC3"));

            tvP_apparente1.setText(intent.getStringExtra("PAP1"));
            tvP_apparente2.setText(intent.getStringExtra("PAP2"));
            tvP_apparente3.setText(intent.getStringExtra("PAP3"));

            tvP_reactive1.setText(intent.getStringExtra("PR1"));
            tvP_reactive2.setText(intent.getStringExtra("PR2"));
            tvP_reactive3.setText(intent.getStringExtra("PR3"));

            tvF_puissance1.setText(intent.getStringExtra("FP1"));
            tvF_puissance2.setText(intent.getStringExtra("FP2"));
            tvF_puissance3.setText(intent.getStringExtra("FP3"));

            tvE_totale1.setText(intent.getStringExtra("ET1"));
            tvE_totale2.setText(intent.getStringExtra("ET2"));
            tvE_totale3.setText(intent.getStringExtra("ET3"));
        }
    }; //


    //Arret de l'activité
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intentService); // Service interrompu
        this.unregisterReceiver(serviceReceiver); //Broadcast interrompu
    }

}