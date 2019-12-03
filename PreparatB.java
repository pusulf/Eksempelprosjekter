class PreparatB extends Legemiddel {
  //PreparatB er klassen for vannedannende legemiddler

  //Styrke her omhandler hvor vanedannende legemiddelet er
  int styrke;

  public PreparatB(String n, double p, double v, int s) {
    //sender variablene til superklassen
    super(n,p,v);
    styrke = s;

  }

  public int hentVanedannendeStyrke() {
    return styrke;
  }

  public String toString() {
    return "PreparatB: " + navn + ": pris: " + pris + ", mg virkestoff: " + virkestoff + ", vanedannende-styrke: " + styrke + ", Legemiddel ID: " + id;
  }

  @Override
  public String hentType() {
    return "B";
  }
}
