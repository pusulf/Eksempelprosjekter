class PResept extends HvitResept {

  public PResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient) {
    //Reit på P-resept er alltid 3.
    super(legemiddel, utskrivendeLege, pasient, 3);
  }

  @Override
  public double prisAaBetale(){
    if ((legemiddel.hentPris() - 108) < 0) {
      return 0;
      }
    double pris = legemiddel.hentPris() -108;
    return pris;
  }

  @Override
  public String toString() {
    return "PResept: Legemiddel: " + legemiddel + "utskrivendeLege: " + utskrivendeLege + ", pasient: " + pasient + ", resterende reit: " + reit + ", pris aa betale: " + pris;
  }
}
