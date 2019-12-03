class Lege implements Comparable<Lege> {

  String navn;

  Lenkeliste<Resept> utskrevedeResepter;


  public Lege(String navn) {
    this.navn = navn;

    utskrevedeResepter = new Lenkeliste<Resept>();
  }

  @Override
  public int compareTo(Lege lege) {
    return this.navn.compareTo(lege.hentNavn()); //Skjoenner ikke hvorfor dette funker

    /*
    if(this.navn < lege.hentNavn()) { //Hvis
      return -1;
    }

    if(this.navn > lege.hentNavn()) {
      return 1;
    }
    return 0;
    */
  }


  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    if (legemiddel instanceof PreparatA) throw new UlovligUtskrift(this, legemiddel);
    BlaaResept b1 = new BlaaResept(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(b1);
    pasient.leggTilResept(b1);  
    return b1;
  }

  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    if (legemiddel instanceof PreparatA) throw new UlovligUtskrift(this, legemiddel);
    HvitResept h1 = new HvitResept(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(h1);
    pasient.leggTilResept(h1);
    return h1;
  }

  public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    if (legemiddel instanceof PreparatA) throw new UlovligUtskrift(this, legemiddel);
    MilitaerResept m1 = new MilitaerResept(legemiddel, this, pasient, reit);
    utskrevedeResepter.leggTil(m1);
    pasient.leggTilResept(m1);
    return m1;
  }

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
    if (legemiddel instanceof PreparatA) throw new UlovligUtskrift(this, legemiddel);
    PResept p1 = new PResept(legemiddel, this, pasient);
    utskrevedeResepter.leggTil(p1);
    pasient.leggTilResept(p1);
    return p1;
  }

  public String hentNavn() {
    return navn;
  }

  public String toString() {
    return "Lege: " + navn;
  }
}
