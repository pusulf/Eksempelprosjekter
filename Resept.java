abstract class Resept {

  Legemiddel legemiddel;
  Lege utskrivendeLege;
  Pasient pasient;
  int reit;

  int id;



  private static int antall = 0;

  public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasient = pasient;
    this.reit = reit;

    //Gir en id til objektet og øker antall med 1.
    id = antall ++;
  }



  public int hentId() {
    return id;
  }

  public Legemiddel hentLegemiddel() {
    return legemiddel;
  }

  public Lege hentLege() {
    return utskrivendeLege;
  }

  public Pasient hentpasient() {
    return pasient;
  }

  public int hentReit() {
    return reit;
  }

  public boolean bruk() {
    //Hvis det er 1 eller mer igjen på reit, bruk en og returner true. Ellers returner false.
    if (reit >= 1) {
      reit --;
      return true;
    }
    return false;
  }

  abstract public String farge();

  abstract public double prisAaBetale();




}
