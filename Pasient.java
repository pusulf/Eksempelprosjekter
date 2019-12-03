class Pasient{

  String navn;
  String foedselsnummer;
  Stabel<Resept> stabelResepter;
  int id;

  //antall pasienter
  private static int antall = 0;

  public Pasient(String navn, String foedselsnummer) {
    this.navn = navn;
    this.foedselsnummer = foedselsnummer;

  stabelResepter = new Stabel<Resept>();

    //Gir pasienten en unik id
    id = antall ++;
  }

  public Stabel<Resept> hentReseptListe() {
    return  stabelResepter;
  }

  public void leggTilResept(Resept resept) {
    stabelResepter.leggPaa(resept);
  }

  public int hentPasientID() {
    return id;
  }

  public String hentNavn(){
    return navn;
  }

  @Override
  public String toString(){
    return "Pasient: " + navn + ", foedselsnummer: " + foedselsnummer;
  }

  public int antallNarko(){
    int ant = 0;
    for(Resept r:stabelResepter){
      if(r.hentLegemiddel() instanceof PreparatA){
        ant ++;
      }
    }
    return ant;
  }
}
