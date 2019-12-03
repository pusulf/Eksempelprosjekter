class PreparatC extends Legemiddel {
  //PreparatC er klassen for vanlige legemiddler

  public PreparatC(String n, double p, double v) {
    //sender variablene til superklassen
    super(n,p,v);
  }

  public String toString() {
    return "PreparatC: " + navn + ": pris: " + pris + ", mg virkestoff: " + virkestoff + ", Legemiddel ID: " + id;
  }

  @Override
  public String hentType() {
    return "C";
  }
}
