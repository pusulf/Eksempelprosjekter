class BlaaResept extends Resept {

  double pris;

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
    super(legemiddel, utskrivendeLege, pasient, reit);
  }

  @Override
  public String farge() {
    return "Blaa";
  }

  @Override
  public double prisAaBetale() {
  double pris = legemiddel.hentPris() * 0.25;
  return pris;
  }

  public String toString() {
    return "BlaaResept: Legemiddel: " + legemiddel + ", utskrivendeLege: " + utskrivendeLege + ", pasient: " + pasient + ", resterende reit: " + reit + ", pris aa betale: " + pris;
  }
}
