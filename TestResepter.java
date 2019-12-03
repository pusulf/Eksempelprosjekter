class TestResepter {
  public static void main(String[] args) {

    //Oppretter PreparatA lim
    //System.out.println("Testing PreparatA, skal gi lim, 0, 20.50, 5.0, 7, 50, 1");
    PreparatA lim = new PreparatA("Lim",20.50,5.0,7);

    Lege lars = new Lege();

    //PasientID er 1, reit er 1
    BlaaResept nyBlaa = new BlaaResept(lim, lars, 1, 1);
    System.out.println("skal gi lim, lars(lege et eller annet), 1, 1, Blaa og 5.125");
    System.out.println(nyBlaa.toString());
    System.out.println(nyBlaa.hentId());
    System.out.println(nyBlaa.hentLegemiddel());
    System.out.println(nyBlaa.hentLege());
    System.out.println(nyBlaa.hentPasientID());
    System.out.println(nyBlaa.hentReit());
    System.out.println(nyBlaa.farge());
    System.out.println(nyBlaa.prisAaBetale());

    HvitResept nyHvit = new HvitResept(lim, lars, 2, 2);
    System.out.println("skal gi lim, lars(lege et eller annet), 2, 2, Hvit og 20.5");
    System.out.println(nyHvit.toString());
    System.out.println(nyHvit.hentId());
    System.out.println(nyHvit.hentLegemiddel());
    System.out.println(nyHvit.hentLege());
    System.out.println(nyHvit.hentPasientID());
    System.out.println(nyHvit.hentReit());
    System.out.println(nyHvit.farge());
    System.out.println(nyHvit.prisAaBetale());

    PResept nyP = new PResept(lim, lars, 3);
    System.out.println("skal gi lim, lars(lege et eller annet), 3, 3, Hvit og 0");
    System.out.println(nyP.toString());
    System.out.println(nyP.hentId());
    System.out.println(nyP.hentLegemiddel());
    System.out.println(nyP.hentLege());
    System.out.println(nyP.hentPasientID());
    System.out.println(nyP.hentReit());
    System.out.println(nyP.farge());
    System.out.println(nyP.prisAaBetale());

    MilitaerResept nyMilitaer = new MilitaerResept(lim, lars, 2, 2);
    System.out.println("skal gi lim, lars(lege et eller annet), 2, 2, Hvit og 0");
    System.out.println(nyMilitaer.toString());
    System.out.println(nyMilitaer.hentId());
    System.out.println(nyMilitaer.hentLegemiddel());
    System.out.println(nyMilitaer.hentLege());
    System.out.println(nyMilitaer.hentPasientID());
    System.out.println(nyMilitaer.hentReit());
    System.out.println(nyMilitaer.farge());
    System.out.println(nyMilitaer.prisAaBetale());


  }
}
