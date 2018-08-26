package androidprojetconso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class AgentWs {

    public  String ws;
    public DonneesJson data;
    HttpURLConnection httpConnection;


    URL url;


    AgentWs(String Ws, DonneesJson Data) {

        ws = Ws;
        data = Data;

        try {
            url = new URL(ws);

            }

        catch (MalformedURLException ex) {
            System.out.println("Erreur MalformedURLException : "+ex);
        }

    }

    //Connexion serveur Http
    public String ReceptionFluxJson() {

        int responseCode;
        try {
            URLConnection connection = url.openConnection();
            httpConnection = (HttpURLConnection) connection;
            responseCode = httpConnection.getResponseCode();

            //Si connexion établie
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream in = httpConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

                String fluxJson = bufferedReader.readLine();
                bufferedReader.close();


                //Si compteur existant
                if (!fluxJson.equals("false")) {

                    //Parse flux Json
                    data.SetFluxJson(fluxJson);

                    //Récupération nom
                    JSONObject jsonNom = new JSONObject(fluxJson);
                    String nom = jsonNom.getString("Nom");
                    data.SetNom(nom);

                    //Récupération date
                    JSONObject jsonDate = new JSONObject(fluxJson);
                    String date = jsonDate.getString("D");
                    data.SetDate(date);

                    //Récupération tension
                    JSONObject jsonTension = new JSONObject(fluxJson);
                    String tension = jsonTension.getString("T");
                    data.SetTension(tension + " V");

                    //Récupération courant
                    JSONObject jsonCourant = new JSONObject(fluxJson);
                    String courant = jsonCourant.getString("C");
                    data.SetCourant(courant + " A");

                    //Récupération puissance active
                    JSONObject jsonP_active = new JSONObject(fluxJson);
                    String p_active = jsonP_active.getString("PAC");
                    data.SetP_active(p_active + " W");

                    //Récupération puissance apparente
                    JSONObject jsonP_apparente = new JSONObject(fluxJson);
                    String p_apparente = jsonP_apparente.getString("PAP");
                    data.SetP_apparente(p_apparente + " V.A");

                    //Récupération puissance réactive
                    JSONObject jsonP_reactive = new JSONObject(fluxJson);
                    String p_reactive = jsonP_reactive.getString("PR");
                    data.SetP_reactive(p_reactive + " VAR");

                    //Récupération facteur de puissance
                    JSONObject jsonF_puissance = new JSONObject(fluxJson);
                    String f_puissance = jsonF_puissance.getString("FP");
                    data.SetFacteurPuissance(f_puissance);

                    //Récupération énergie totale
                    JSONObject jsonE_totale = new JSONObject(fluxJson);
                    String e_totale = jsonE_totale.getString("ET");
                    data.SetEnergieTotale(e_totale + " kW.h");
                    }
                //Fin Si


                else {
                    data.SetFluxJson(fluxJson);
                    data.SetDate("");
                    data.SetTension("");
                    data.SetCourant("");
                    data.SetP_active("");
                    data.SetP_apparente("");
                    data.SetP_reactive("");
                    data.SetFacteurPuissance("");
                    data.SetEnergieTotale("");
                    }
                //Fin Else
            }
            //fin Si


            else
            {
                data.SetNom("??????");
                data.SetFluxJson("ERROR_FLUX");
                data.SetDate("ERROR_FLUX");
                data.SetTension("ERROR_FLUX");
                data.SetCourant("ERROR_FLUX");
                data.SetP_active("ERROR_FLUX");
                data.SetP_apparente("ERROR_FLUX");
                data.SetP_reactive("ERROR_FLUX");
                data.SetEnergieTotale("ERROR_FLUX");
                data.SetFacteurPuissance("ERROR_FLUX");
            }
                //Fin Else

        }

        catch (IOException ex) {
            System.out.println("Erreur IOException : "+ex);
  
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return String.valueOf(data);

    }
}
