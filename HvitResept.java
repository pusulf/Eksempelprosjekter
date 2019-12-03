class HvitResept extends Resept {

  double pris;

  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  @Override
  public String farge() {
    return "Hvit";
  }

  @Override
  public double prisAaBetale() {
  double pris = legemiddel.hentPris();
  return pris;
  }

  public String toString() {
    return "HvitResept: Legemiddel: " + legemiddel + "utskrivendeLege: " + utskrivendeLege + ", pasient: " + pasient + ", resterende reit: " + reit + ", pris aa betale: " + pris;
  }


}
