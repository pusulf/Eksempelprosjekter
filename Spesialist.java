class Spesialist extends Lege implements GodkjenningsFritak {

  int kontrollID;

  public Spesialist(String navn, int kontrollID) {
    super(navn);

    this.kontrollID = kontrollID;
  }

@Override
public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) {
  BlaaResept b1 = new BlaaResept(legemiddel, this, pasient, reit);
  return b1;
}

@Override
public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) {
  HvitResept h1 = new HvitResept(legemiddel, this, pasient, reit);
  return h1;
}

@Override
public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) {
  MilitaerResept m1 = new MilitaerResept(legemiddel, this, pasient, reit);
  return m1;
}

@Override
public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) {
  PResept p1 = new PResept(legemiddel, this, pasient);
  return p1;
}

  //hent kontrollID er fra GodkjenningsFritak interfacen
  @Override
  public int hentKontrollID() {
    return kontrollID;
  }

  @Override
  public String toString() {
    return "Spesialist: " + navn +", kontrollID: " + kontrollID;
  }
}
