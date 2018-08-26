package androidprojetconso;

public class DonneesJson {
    private String FluxJson;
    private String Date;
    private String Tension;
    private String Courant;
    private String PuissanceActive;
    private String PuissanceApparente;
    private String PuissanceReactive;
    private String FacteurPuissance;
    private String EnergieTotale;
    private String Nom;


//FluxJson
    public void SetFluxJson(String Flux) {
        FluxJson = Flux;
    }

    public String GetFluxJson() {
        return FluxJson;
    }
//


//Date
    public void SetDate(String date) {
        Date = date;
    }

    public String GetDate() {
        return Date;
    }
//





//Tension
    public void SetTension(String tension) {
        Tension = tension;
    }

    public String GetTension() {
        return Tension;
    }
//



//Courant
    public void SetCourant(String courant) {
        Courant = courant;
    }

    public String GetCourant() {
        return Courant;
    }
//




//Puissance active
    public void SetP_active(String p_active) {
        PuissanceActive = p_active;
    }

    public String GetP_active() {
        return PuissanceActive;
    }
//




//Puissance apparente
    public void SetP_apparente(String p_apparente) {
        PuissanceApparente = p_apparente;
    }

    public String GetP_apparente() {
        return PuissanceApparente;
    }
//



//Puissance réactive
    public void SetP_reactive(String p_reactive) {
        PuissanceReactive = p_reactive;
    }

    public String GetP_reactive() {
        return PuissanceReactive;
    }
//



//Facteur de puissance
    public void SetFacteurPuissance(String f_puissance) {
        FacteurPuissance = f_puissance;
    }

    public String GetFacteurPuissance() {
        return FacteurPuissance;
    }
//




//Energie totale
    public void SetEnergieTotale(String e_totale) {
        EnergieTotale = e_totale;
    }

    public String GetEnergieTotale() {
        return EnergieTotale;
    }
//




//Nom abonné
    public void SetNom (String nom) {
        Nom = nom;
    }

    public String GetNom() {
        return Nom;
    }
//

}




