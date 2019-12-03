abstract class Legemiddel {

  String navn;
  double pris;
  //Antall mg med virkestoff i Legemiddelet
  double virkestoff;
  int id;

  //Alle legemidler bruker samme id-system
  protected static int antall = 0;

  public Legemiddel(String n, double p, double v) {
    navn = n;
    pris = p;
    virkestoff = v;

    //Den forste som blir lagd får id 0. DERETTER øker id antall med 1.
    id = antall ++;
  }

  public int hentId() {
    //INneholder ikke noe, da id er separat for hver subclasse
    //Hvis man får -1, betyr det at ID ikke er blitt assigned
    return id;
  }

  public String hentNavn() {
    return navn;
  }

  public double hentPris() {
    return pris;
  }

  public double hentVirkestoff() {
    return virkestoff;
  }

  public void settNyPris(double nyPris) {
    pris = nyPris;
  }

  abstract public String hentType();
}
