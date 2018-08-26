package androidprojetconso;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

public class ServiceCyclique extends Service {

    Timer timer;
    TimerTask task;

    @Override
    public void onCreate()
    {
        timer = new Timer();
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        task = new TimerTask() {

            public void run() {

                //Récupération adresse IP serveur
                String urlServeur = ActivityApercu.Ip;

//Compteur n°1
                urlServeur = urlServeur + "&id_compteur=1";

                //Récupération flux json compteur 1
                DonneesJson data = new DonneesJson();
                AgentWs agent = new AgentWs(urlServeur,data);
                agent.ReceptionFluxJson();
                String flux = data.GetFluxJson();
                String nom = data.GetNom();
                String date = data.GetDate();
                String tension = data.GetTension();
                String courant = data.GetCourant();
                String p_active = data.GetP_active();
                String p_apparente = data.GetP_apparente();
                String p_reactive = data.GetP_reactive();
                String f_puissance = data.GetFacteurPuissance();
                String e_totale = data.GetEnergieTotale();

                //Stockage des valeurs compteur 1
                Intent intentService = new Intent("donnees");
                intentService.putExtra("Flux1", flux);
                intentService.putExtra("D1", date);
                intentService.putExtra("Nom", nom);
                intentService.putExtra("T1", tension);
                intentService.putExtra("C1", courant);
                intentService.putExtra("PAC1", p_active);
                intentService.putExtra("PAP1", p_apparente);
                intentService.putExtra("PR1", p_reactive);
                intentService.putExtra("FP1", f_puissance);
                intentService.putExtra("ET1", e_totale);

//Compteur n°2
                urlServeur = urlServeur + "&id_compteur=2";

                //Récupération flux json compteur 2
                agent = new AgentWs(urlServeur,data);
                agent.ReceptionFluxJson();
                flux = data.GetFluxJson();
                date = data.GetDate();
                tension = data.GetTension();
                courant = data.GetCourant();
                p_active = data.GetP_active();
                p_apparente = data.GetP_apparente();
                p_reactive = data.GetP_reactive();
                f_puissance = data.GetFacteurPuissance();
                e_totale = data.GetEnergieTotale();

                //Stockage des valeurs compteur 2
                intentService.putExtra("FluX2", flux);
                intentService.putExtra("D2", date);
                intentService.putExtra("T2", tension);
                intentService.putExtra("C2", courant);
                intentService.putExtra("PAC2", p_active);
                intentService.putExtra("PAP2", p_apparente);
                intentService.putExtra("PR2", p_reactive);
                intentService.putExtra("FP2", f_puissance);
                intentService.putExtra("ET2", e_totale);

//Compteur n°3
                urlServeur = urlServeur + "&id_compteur=3";

                //Récupération flux json compteur 3
                agent = new AgentWs(urlServeur,data);
                agent.ReceptionFluxJson();
                flux = data.GetFluxJson();
                date = data.GetDate();
                tension = data.GetTension();
                courant = data.GetCourant();
                p_active = data.GetP_active();
                p_apparente = data.GetP_apparente();
                p_reactive = data.GetP_reactive();
                f_puissance = data.GetFacteurPuissance();
                e_totale = data.GetEnergieTotale();

                //Stockage des valeurs compteur 3
                intentService.putExtra("FluX3", flux);
                intentService.putExtra("D3", date);
                intentService.putExtra("T3", tension);
                intentService.putExtra("C3", courant);
                intentService.putExtra("PAC3", p_active);
                intentService.putExtra("PAP3", p_apparente);
                intentService.putExtra("PR3", p_reactive);
                intentService.putExtra("FP3", f_puissance);
                intentService.putExtra("ET3", e_totale);

//Compteur n°4
                urlServeur = urlServeur + "&id_compteur=4";

                //Récupération flux json compteur 4
                agent = new AgentWs(urlServeur,data);
                agent.ReceptionFluxJson();
                flux = data.GetFluxJson();
                date = data.GetDate();
                tension = data.GetTension();
                courant = data.GetCourant();
                p_active = data.GetP_active();
                p_apparente = data.GetP_apparente();
                p_reactive = data.GetP_reactive();
                f_puissance = data.GetFacteurPuissance();
                e_totale = data.GetEnergieTotale();

                //Stockage des valeurs compteur 4
                intentService.putExtra("FluX4", flux);
                intentService.putExtra("D4", date);
                intentService.putExtra("T4", tension);
                intentService.putExtra("C4", courant);
                intentService.putExtra("PAC4", p_active);
                intentService.putExtra("PAP4", p_apparente);
                intentService.putExtra("PR4", p_reactive);
                intentService.putExtra("FP4", f_puissance);
                intentService.putExtra("ET4", e_totale);

                //Envoi de la diffusion
                ServiceCyclique.this.sendBroadcast(intentService);

            }

        };

        //Configuration de la période de scrutation
        timer.schedule(task, 0, 10000); //10 s
        return START_STICKY;

    }


    @Override
    public void onDestroy()
    {
        timer.cancel();
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}


