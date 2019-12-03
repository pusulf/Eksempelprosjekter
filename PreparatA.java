class PreparatA extends Legemiddel {
  //PreparatA er klassen for narkotiske legemiddler

  //Styrke her omhandler hvor narkotisk stoffet er
  int styrke;

  public PreparatA(String n, double p, double v, int s) {
    //sender variablene til superklassen
    super(n,p,v);
    styrke = s;
  }


  public int hentNarkotiskStyrke() {
    return styrke;
  }

  public String toString() {
    return "PreparatA: " + navn + ": pris: " + pris + ", mg virkestoff: " + virkestoff + ", narkotisk styrke: " + styrke + ", Legemiddel ID: " + id;
  }

  @Override
  public String hentType() {
    return "A";
  }
}
