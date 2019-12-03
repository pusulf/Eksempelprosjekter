import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;



class IntegrasjonsTest {

  String type;

  public static ArrayList<Legemiddel> legemidler = new ArrayList<Legemiddel>();
  public static ArrayList<Lege> leger = new ArrayList<Lege>();
  public static ArrayList<Resept> resepter = new ArrayList<Resept>();



  public static void main(String[] args) {

    //Leser inn filen
    File fil = new File("inndata.txt");
    Scanner scanner = null;

    //Oppretter en scanner for filen
    try {
    scanner = new Scanner(fil);
    } catch (FileNotFoundException e) {
      System.out.println("Finner ikke filen");
      System.exit(1);
    }

    //Leser forste linje, sa starter lokken
    String line = scanner.nextLine();

    //En while løkke som kjører så lenge fil har linjer
    while(scanner.hasNextLine()) {

      //Vi sjekker om den forste linjen inneholder # Legemidler
      System.out.println(line + "--");


      if(line.startsWith("# Legemidler")) {

        //Hopper til neste linje, forste legemiddel
        line = scanner.nextLine();


        //Saa lenge linjen ikke inneholder #, er det et Legemiddel
        while(!(line.contains("#"))) {
          lesLegemiddel(line);
          line = scanner.nextLine();

          }
      } else if(line.startsWith("# Leger")) {

        //Hopper til neste linje, som er forste lege
        line = scanner.nextLine();


          while(!(line.contains("#"))) {
            lesLege(line);
            line = scanner.nextLine();
            }

        } else if(line.startsWith("# Resepter")) {

            //Hopper til neste linje, og begynner paa forste resept
            line = scanner.nextLine();


            while(!(line.contains("#"))) {
              lesResept(line);
              //Ser om neste linje er den siste
              if(!(scanner.hasNextLine())) {
                break;
              }
              line = scanner.nextLine();

            }
          } else {System.out.println("Noe er galt, en tom linje blir lest");}
      }

      for(Legemiddel l:legemidler) {System.out.println(l);}
      for(Lege s:leger) {System.out.println(s);}
      for(Resept r:resepter) {System.out.println(r);}

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


    legemidler.add(nyttLegemiddel);


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

    leger.add(l);

    }

  public static void lesResept(String setning) {
    String[] variabler = setning.split(", ");

    String type = variabler[0];
    int legemiddelNummer = Integer.parseInt(variabler[1]);
    String legeNavn = variabler[2];
    int personID = Integer.parseInt(variabler[3]);

    int reit = 0;

    Resept nyResept = null;

    if (!type.equals("prevensjon")) {
      reit = Integer.parseInt(variabler[4]);
      }



    //Henter tak i lege objektet
    Lege utskrivendeLege = null;
    for(Lege l:leger) {
      if(l.hentNavn().equals(legeNavn)) {
        utskrivendeLege = l;
        }
      }

    //Henter riktig legemiddel objekt
    Legemiddel legemiddel = null;

    for(Legemiddel lm:legemidler) {
      //System.out.println("En test");
      if(lm.hentId() == legemiddelNummer) {
        legemiddel = lm;
        //System.out.println(legemiddel);
        //System.out.println("Det aktuelle Legemiddelet er: " + legemiddel);
      }
    }

    //Trouble med reit might not have been initialisted
    if(type.equals("prevensjon")){
      nyResept = new PResept(legemiddel, utskrivendeLege, personID);
    } else if (type.equals("hvit")) {nyResept = new HvitResept(legemiddel, utskrivendeLege, personID, reit);
      } else if (type.equals("blaa")) {nyResept = new BlaaResept(legemiddel, utskrivendeLege, personID, reit);
        } else {nyResept = new MilitaerResept(legemiddel, utskrivendeLege, personID, reit);
          }

      //Legger til den nye resepten i lista
      resepter.add(nyResept);
    }
  }
