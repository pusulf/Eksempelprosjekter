import java.util.*;
import java.io.*;





public class Legesystem{
  // Opprett lister som lagrer objektene i legesystemet

  //Oppretter itererbare lister, de heter Lenkeliste.java
  //Gjor de aktuelle listene globale
  //Og static, vet ikke hvorfor
  public static Lenkeliste<Pasient> pasientListe = new Lenkeliste<Pasient>();
  public static SortertLenkeliste<Lege> legeListe = new SortertLenkeliste<Lege>();
  public static Lenkeliste<Resept> reseptListe = new Lenkeliste<Resept>();
  public static Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();

  private static int valg;
  private static int inputInt;
  private static double inputDouble;

  private static Scanner inputScanner;





  public static void main(String[] args){
    lesFraFil(new File("legeSystemInndata.txt"));

    boolean forsettLokke = true;

    while(forsettLokke) {
      startTekst();
      valg = lesIntFraBruker();

      switch(valg) {

        case 1: skrivUtSystem(); break;

        case 2: leggTilElement(); break;

        case 3: brukResept(); break;

        case 4: printStatestikk(); break;

        case 5: skrivTilFil(); break;

        case 6: return;

        default:
          System.out.println("\nDU HAR VALGT ET UGYLDIG ALTERNATIV\n");
      }


    }

  }

  public static String lesFraBruker(){
    inputScanner = new Scanner(System.in);
    String brukerTekst = inputScanner.nextLine();

    return brukerTekst;
  }

  public static int lesIntFraBruker(){
    inputScanner = new Scanner(System.in);
    try {inputInt = Integer.parseInt(lesFraBruker());
    } catch(NumberFormatException nfe){
      System.out.println("DU HAR VALGT ET UGYLDIG ALTERNATIV, SKRIV ET HELTALL");
      inputInt = lesIntFraBruker();
    }

    return inputInt;
  }

  public static double lesDoubleFraBruker(){
    inputScanner = new Scanner(System.in);
    try {inputDouble = Double.parseDouble(lesFraBruker());
    } catch(NumberFormatException nfe){
      System.out.println("DU HAR VALGT ET UGYLDIG ALTERNATIV, SKRIV ET FLYTTALL");
      inputDouble
       = lesDoubleFraBruker();
    }

    return inputDouble;
  }

  public static void ventPaaBruker(){
    System.out.println("\nTrykk enter for aa fortsette");
    inputScanner = new Scanner(System.in);
    String temp = inputScanner.nextLine();
  }

  public static void startTekst() {

    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nLegesystem:\n\nVelg et alternativ mellom 1 og 7\n1: Skriv ut hele legesystemet\n2: Legg til et nytt elemement\n3: Bruk en resept\n4: print printStatestikk\n5: Skriv til fil\n6: Avslutt programmet\n\nSkriv inn et tall og trykk enter\n");

  }

  public static void skrivUtSystem(){
    System.out.println(" ");

    System.out.println("----------Pasienter----------");
    for(Pasient p:pasientListe){
      System.out.println(p);
    }

    System.out.println(" ");
    System.out.println("----------Leger----------");
    for(Lege l:legeListe){
      System.out.println(l);
    }

    System.out.println("");
    System.out.println("----------Legemiddler----------");
    for(Legemiddel lm:legemiddelListe){
      System.out.println(lm);
    }

    System.out.println("");
    System.out.println("----------Resepter----------");
    for(Resept r:reseptListe){
      System.out.println(r);
    }

    ventPaaBruker();
  }

  public static void leggTilElement(){

    leggTilTekst();
    valg = lesIntFraBruker();

    switch(valg) {

    case 1: leggTilPasient(); break;

    case 2: leggTilLege(); break;

    case 3: leggTilLegemiddel(); break;

    case 4: leggTilResept(); break;

    case 6: return;

    default:
      System.out.println("\nDU HAR VALGT ET UGYLDIG ALTERNATIV\n");

    }
  }

    public static void leggTilTekst(){
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nDu vil legge til element\n1: Pasient\n2: Lege\n3: Legemiddel\n4: Resept\n5:Gaa tilbake til hovedmeny");
    }

    public static void leggTilPasient(){
      System.out.println("\nDu prover aa legge til en ny pasient\nSkriv inn navnet paa den nye pasienten, og trykk enter: \n");
      String pasientNavn = lesFraBruker();
      System.out.println("\nSkriv inn foedselsnummer til pasienten: \n");
      String foedselsnummer = lesFraBruker();

      Pasient nyPasient = new Pasient(pasientNavn,foedselsnummer);

      pasientListe.leggTil(nyPasient);
    }

    public static void leggTilLege(){
      System.out.println("\nDu prover aa legge til en ny Lege eller Spesialist\nSkriv inn navnet paa den nye Legen eller Spesiealist, og trykk enter: \n");
      String legeNavn = lesFraBruker();
      System.out.println("\nHvis Legen er Spesialist, legg inn kontrollID. Er det en vanlig Lege, legg inn 0 og trykk enter: \n");
      int kontrollID = lesIntFraBruker();

      Lege nyLege = null;

      if(kontrollID == 0){
        nyLege = new Lege(legeNavn);
        legeListe.leggTil(nyLege);

      } else{
        nyLege = new Spesialist(legeNavn,kontrollID);
      }

      System.out.println("\nDu har lagt til: " + nyLege);
      ventPaaBruker();
    }

    public static void leggTilLegemiddel(){
      System.out.println("\nDu vil opprette et legemiddel.");
      System.out.println("Skriv inn navnet paa legemiddelet: ");
      String legemiddelNavn = lesFraBruker();

      String legemiddelType = "";
      boolean riktigType = false;
      while(!riktigType){
        System.out.println("Skriv typen legemiddel: a,b, eller c");
        legemiddelType = lesFraBruker();
        if(legemiddelType.equals("a")){riktigType = true;}
        if(legemiddelType.equals("b")){riktigType = true;}
        if(legemiddelType.equals("c")){riktigType = true;}
      }

      System.out.println("Skriv inn prisen: ");
      double legemiddelPris = lesDoubleFraBruker();

      System.out.println("Skriv mengden virkestoff: ");
      double legemiddelVirkestoff = lesDoubleFraBruker();

      Legemiddel nyttLegemiddel = null;

      if(legemiddelType.equals("c")){
        nyttLegemiddel = new PreparatC(legemiddelNavn,legemiddelPris,legemiddelVirkestoff);
      }

      if(legemiddelType.equals("a")){
        System.out.println("Skriv inn narkotisk styrke: ");
        int legemiddelNarkotiskStyrke = lesIntFraBruker();
        nyttLegemiddel = new PreparatA(legemiddelNavn,legemiddelPris,legemiddelVirkestoff,legemiddelNarkotiskStyrke);
      }

      if(legemiddelType.equals("b")){
        System.out.println("Skriv inn vanedannende styrke: ");
        int legemiddelVanedannendeStyrke = lesIntFraBruker();
        nyttLegemiddel = new PreparatB(legemiddelNavn,legemiddelPris,legemiddelVirkestoff,legemiddelVanedannendeStyrke);
      }

      legemiddelListe.leggTil(nyttLegemiddel);

      System.out.println("Du har lagt til legemiddelet: " + nyttLegemiddel);

      ventPaaBruker();
    }

    public static void leggTilResept(){
      System.out.println("Du prover aa opprette en resept");

      Legemiddel utskrevetLegemiddel = null;
      System.out.println("\nAktuelle Legemiddeler");
      int i = 0;
      for(Legemiddel lm:legemiddelListe){
        System.out.println(i + ": " + lm);
        i++;
      }
      System.out.println("\nSkriv inn nr til Legemiddelet du vil benytte: ");
      int id = lesIntFraBruker();
      while((id > legemiddelListe.stoerrelse()-1) || id < 0){
        System.out.println("Ugyldig nr, skriv inn paa nytt!:");
        id = lesIntFraBruker();
      }
      utskrevetLegemiddel = legemiddelListe.hent(id);



      System.out.println("Skriv navnet paa Legen som skriver ut resepten");
      Lege utskrivendeLege = null;

      System.out.println("\nAktuelle Leger");
      i = 0;
      for(Lege l:legeListe){
        System.out.println(i + ": " + l);
        i++;
      }
      System.out.println("\nSkriv inn nr til Legen du vil benytte: ");
      int index = lesIntFraBruker();
      while((index > legeListe.stoerrelse()-1) || index < 0){
        System.out.println("Ugyldig nr, skriv inn paa nytt!:");
        index = lesIntFraBruker();
      }
      utskrivendeLege = legeListe.hent(id);


      Pasient pasienten = null;
      System.out.println("\nAktuelle pasientr");
      i = 0;
      for(Pasient l:pasientListe){
        System.out.println(i + ": " + l);
        i++;
      }
      System.out.println("\nSkriv inn nr til pasientn du vil benytte: ");
      index = lesIntFraBruker();
      while((index > pasientListe.stoerrelse()-1) || index < 0){
        System.out.println("Ugyldig nr, skriv inn paa nytt!:");
        index = lesIntFraBruker();
      }
      pasienten = pasientListe.hent(id);


      Resept nyResept = null;
      int antallReit;

      System.out.println("\nDet finnes fire typer resept, skriv inn nr paa typen du vil benytte:\n0: BlaaResept\n1: HvitResept\n2: MilitaerResept\n3: PResept");
      int reseptType = lesIntFraBruker();
      while(reseptType > 3 || reseptType < 0){
        System.out.println("Ugyldig valg, skriv inn paa nytt");
        reseptType = lesIntFraBruker();
      }

      //Henter type resept og printer passende ord
      if(reseptType == 3){//Presept
        nyResept = new PResept(utskrevetLegemiddel,utskrivendeLege,pasienten);
        reseptListe.leggTil(nyResept);
        System.out.println("Du har lagt til Resepten: " + nyResept);
        ventPaaBruker();
        return;
      } else {
        System.out.println("Skriv inn antall reit til Resepten");
        antallReit = lesIntFraBruker();

        if(reseptType == 0){//BlaaResept
          nyResept = new BlaaResept(utskrevetLegemiddel,utskrivendeLege,pasienten,antallReit);
          reseptListe.leggTil(nyResept);
          System.out.println("Du har lagt til Resepten: " + nyResept);
          ventPaaBruker();
          return;
        }

        if(reseptType == 1){//Hvit Resept
          nyResept = new HvitResept(utskrevetLegemiddel,utskrivendeLege,pasienten,antallReit);
          reseptListe.leggTil(nyResept);
          System.out.println("Du har lagt til Resepten: " + nyResept);
          ventPaaBruker();
          return;
        }

        if(reseptType == 2){//MilitaerResept
          nyResept = new MilitaerResept(utskrevetLegemiddel,utskrivendeLege,pasienten,antallReit);
          reseptListe.leggTil(nyResept);
          System.out.println("Du har lagt til Resepten: " + nyResept);
          ventPaaBruker();
          return;
        }
        System.out.println("Du har skrevet inn en ugyldig type: " + reseptType);
        ventPaaBruker();
        return;
      }
    }

    /*

    public static T velgFraListe(Lenkeliste<T> liste){
      int i = 0;
      System.out.println("Skriv inn tallet som korresponderer med ditt valg, og trykk enter");
      for(T element:liste){
        System.out.println(i+": " + element);
        i++;
      }

      int valgtElement = lesIntFraBruker();
      if(valgtElement > 0 && valgtElement < liste.stoerrelse()){
      return liste.hent(valgtElement);
      } else {System.out.println("Du har valgt et ugyldig element: " + valgtElement);
        velgFraListe(liste);
          }
    }

  */

  public static void brukResept(){
    System.out.println("Hvilken pasient vil du se reseptene for?");
    int i = 0;
    for(Pasient l:pasientListe){
      System.out.println(i + ": " + l);
      i++;
    }
    System.out.println("\nSkriv inn nr til pasientn du vil bruke en resept paa: ");
    int index = lesIntFraBruker();
    while((index > pasientListe.stoerrelse()-1) || index < 0){
      System.out.println("Ugyldig nr, skriv inn paa nytt!:");
      index = lesIntFraBruker();
    }
    Pasient bruker = pasientListe.hent(index);
    System.out.println(bruker);

    System.out.println("\nHvilken resept vil du benytte?");
    i = 0;
    Stabel<Resept> reseptStabel= bruker.hentReseptListe();
    System.out.println("hei, her er storrelsen paa stabelen");
    System.out.println(reseptStabel.stoerrelse());
    System.out.println(bruker.hentReseptListe());
    for(Resept r:reseptStabel){//Hvorfor itererer du ikke?
      System.out.println(i + ": " + r);
      i++;
    }
    System.out.println("\nSkriv inn nr til resepten du vil benytte");
    index = lesIntFraBruker();
    while((index > reseptStabel.stoerrelse()-1) || index < 0){
      System.out.println("Ugyldig nr, skriv inn paa nytt!:");
      index = lesIntFraBruker();
    }
    if(reseptStabel.hent(index).bruk()){
      System.out.println("Brukte en reit paa " + reseptStabel.hent(index));
      ventPaaBruker();
      return;
    } else{
      System.out.println("Allerede tom");
      ventPaaBruker();
      return;
    }
  }

  public static void printStatestikk(){
    System.out.println("Hvilken statestikk vil du se?\n1: Vanedannede\n2: Narkotiske\n3: Leger som har utskrevet narkotiske\n4: Pasienter med narkotiske resepter");
    valg = lesIntFraBruker();

    switch(valg) {

      case 1: visVanedannede(); break;

      case 2: visNarkotiske(); break;

      case 3: narkoLeger(); break;

      case 4: narkoPasienter(); break;

      case 6: return;

      default:
        System.out.println("\nDU HAR VALGT ET UGYLDIG ALTERNATIV\n");
    }

  }

    public static void visVanedannede(){
    int ant = 0;
      for(Resept r:reseptListe){
        if(r.hentLegemiddel() instanceof PreparatA){
          ant ++;
        }
      }
      System.out.println("Antall vandeannde: " + ant);
    }



    public static void visNarkotiske(){}

    public static void narkoLeger(){}

    public static void narkoPasienter(){}





  public static void skrivTilFil() {}

  private static void lesFraFil(File fil){
      Scanner scanner = null;
      try{
      scanner = new Scanner(fil);
    }catch(FileNotFoundException e){
      System.out.println("Fant ikke filen, starter opp som et tomt Legesystem");
      return;
      }

      String innlest = scanner.nextLine();
      //System.out.println(innlest);


      while(scanner.hasNextLine()){

        String[] info = innlest.split(" ");

        // Legger til alle pasientene i filen
        if(info[1].compareTo("Pasienter") == 0){
          while(scanner.hasNextLine()) {
            innlest = scanner.nextLine();

            //Om vi er ferdig med å legge til pasienter, bryt whileløkken,
            //slik at vi fortsetter til koden for å legge til legemiddler
            if(innlest.charAt(0) == '#'){
              for(Pasient pas:pasientListe) {
                //System.out.println("Pasienter: " + pas);
              }
              break;
            }
            //
            //MERK:  Her må du legge til pasienten i en lenkeliste
            //
            //System.out.println("Innlest: " + innlest);
            lesPasient(innlest); // Bruker les metode
          }

        }

        //Legger inn Legemidlene
        else if(info[1].compareTo("Legemidler") == 0){
          while(scanner.hasNextLine()){
            innlest = scanner.nextLine();
            //Om vi er ferdig med å legge til legemidler, bryt whileløkken,
            //slik at vi fortsetter til koden for å legge til leger
            if(innlest.charAt(0) == '#'){
              for(Legemiddel legm:legemiddelListe) {
                //System.out.println("Legemiddler: " + legm);
              }
              break;
            }
            lesLegemiddel(innlest);

            /*
            String[] legemiddel = innlest.split(", ");
            if(legemiddel[1].compareTo("a") == 0){
            //
            //MERK:  Her må du legge til et PreparatA i en lenkeliste
            //
          }
          else if(legemiddel[1].compareTo("b") == 0){
          //
          //MERK:  Her må du legge til et PreparatB i en lenkeliste
          //
        }else if (legemiddel[1].compareTo("c") == 0){
        //
        //MERK:  Her må du legge til et PreparatC i en lenkeliste
        //
        */

      }
    }
    //Legger inn leger
      else if(info[1].compareTo("Leger") == 0){
        while(scanner.hasNextLine()){
        innlest = scanner.nextLine();
        //Om vi er ferdig med å legge til leger, bryt whileløkken,
        //slik at vi fortsetter til koden for å legge til resepter
        if(innlest.charAt(0) == '#'){
          for(Lege leg:legeListe) {
            //System.out.println("Leger: " + leg);
          }
          break;
        }
        lesLege(innlest);


        /*
        info = innlest.split(", ");
        int kontrollid = Integer.parseInt(info[1]);
        if(kontrollid == 0){
        //
        //MERK:  Her må du legge til et lege objekt i en sortert lenkeliste
        //
      }else{
      //
      //MERK:  Her må du legge til et spesialist objekt i en sortert lenkeliste
      //
    } */
  }

    }
    //Legger inn Resepter
    else if(info[1].compareTo("Resepter") == 0){
    while(scanner.hasNextLine()){
      innlest = scanner.nextLine();
      lesResept(innlest);


      //
      // Her må du finne legen, legemiddelet, og pasienten som ligger
      // i lenkelistene utifra informasjonen.
      //
      // Dette burde skilles ut i hjelpemetoder leter gjennom listene
      // og returnerer riktig objekt, ut ifra informasjonen som ble lest inn
      //
      // Opprett et reseptobjekt med skrivResept funksjonen i legen,
      // og legg det til i en lenkeliste
      //
      // Dersom legeobjektene dine oppretter PResepter, kan du ignorere reit
      //
      //
    }
  }
    }
  }

public static void lesPasient(String setning) {
  //System.out.println("Inni lesPasient: " + setning);
  String[] innlest = setning.split(", ");
  String navn = innlest[0];
  String pasientID = innlest[1];

  Pasient pasient = new Pasient(navn, pasientID);

  pasientListe.leggTil(pasient);
  //System.out.println("Pasienten: " + pasient + " er lagt til i pasientListe");
}

public static void lesLegemiddel(String setning) {
  String[] variabler = setning.split(", ");

  String navn = variabler[0];
  String type = variabler[1];
  double pris = Double.parseDouble(variabler[2]);
  double virkestoff = Double.parseDouble(variabler[3]);

  int styrke;
  Legemiddel nyttLegemiddel=null;

  //Hvis det ikke er et legemiddel av type c, kjører den med styrke
  //If(type != "c") er en tallmetode, vi maa i stedet bruke type.equals("c")
  if (!type.equals("c")) {

    styrke = Integer.parseInt(variabler[4]);

    if (type.equals("a")) {
      nyttLegemiddel = new PreparatA(navn, pris, virkestoff, styrke);
    }

    if (type.equals("b")) {
      nyttLegemiddel = new PreparatB(navn, pris, virkestoff, styrke);
    }
  }

  //Om det er typen c opprettes det utenfor if-testene
  if (type.equals("c")) {
    nyttLegemiddel = new PreparatC(navn, pris, virkestoff);
  }


  legemiddelListe.leggTil(nyttLegemiddel);
  //System.out.println("Legemiddelet " + nyttLegemiddel + " er lagt til i legemiddelListe");


}

public static void lesLege(String setning) {
  String[] variabler = setning.split(", ");



  String navn = variabler[0];
  int kontrollID = Integer.parseInt(variabler[1]);

  Lege l = null;

  if(kontrollID == 0) {
    l = new Lege(navn);
  } else {l = new Spesialist(navn, kontrollID);
  }

  legeListe.leggTil(l);
  //System.out.println("Legen " + l + "er lagt til i Legelister");

}

public static void lesResept(String setning) {
  //System.out.println("Inni lesResept");
  String[] variabler = setning.split(", ");

  int legemiddelNummer = Integer.parseInt(variabler[0]);
  String legeNavn = variabler[1];
  int personID = Integer.parseInt(variabler[2]);

  int reit = 0;

  Resept nyResept = null;


  //Henter tak i lege objektet
  Lege utskrivendeLege = null;
  for(Lege l:legeListe) {
    if(l.hentNavn().equals(legeNavn)) {
      utskrivendeLege = l;
    }
  }
  //System.out.println("Utskrivende lege: " + utskrivendeLege);

  //Henter riktig legemiddel objekt
  Legemiddel legemiddel = null;

  for(Legemiddel lm:legemiddelListe) {
    //System.out.println("LegemiddelListe: " + lm);
    //System.out.println("En test");
    //System.out.println("LegemiddelNr: " + legemiddelNummer);
    if(lm.hentId() == legemiddelNummer) {
      legemiddel = lm;
      //System.out.println(legemiddel);
      //System.out.println("Det aktuelle Legemiddelet er: " + legemiddel);
    }
  }
  //System.out.println("Utskrevet legemiddel: " + legemiddel);

  //Henter riktig type
  String type = legemiddel.hentType();

  //Henter ut antall reit
  if (!type.equals("prevensjon")) {
    reit = Integer.parseInt(variabler[3]);
  }

  //Henter tak i lege objektet
  Pasient pasient = null;
  for(Pasient p:pasientListe) {
    if(p.hentPasientID() == personID) {
      pasient = p;
    }
  }

  //Trouble med reit might not have been initialisted
  if(type.equals("prevensjon")){
    nyResept = new PResept(legemiddel, utskrivendeLege, pasient);
  } else if (type.equals("hvit")) {nyResept = new HvitResept(legemiddel, utskrivendeLege, pasient, reit);
  } else if (type.equals("blaa")) {nyResept = new BlaaResept(legemiddel, utskrivendeLege, pasient, reit);
  } else {nyResept = new MilitaerResept(legemiddel, utskrivendeLege, pasient, reit);
  }

  //Legger til den nye resepten i lista
  reseptListe.leggTil(nyResept);
  pasient.leggTilResept(nyResept);
}

public Legemiddel finnLegemiddel(String lmNavn){
  for(Legemiddel lm:legemiddelListe){
    if(lmNavn.equals(lm.hentNavn())){
      return lm;
    }
  }
  return null; //Navnet er ikke i lista
}

}
