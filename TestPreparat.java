class TestPreparat {

  public static void main(String[] args) {
    PreparatA lim = new PreparatA("Lim",20.50,5.0,7);
    PreparatA stov = new PreparatA("Stov",20.50,5.0,7);

    PreparatB sjokolade = new PreparatB("Sjokolade", 1, 2, 3);

    PreparatC ibux = new PreparatC("Ibux", 9, 8);

    System.out.println("Testing PreparatA, skal gi lim, 0, 20.50, 5.0, 7, 50, 1");
    System.out.println(lim.toString());
    System.out.println(lim.hentNavn());
    System.out.println(lim.hentId());
    System.out.println(lim.hentPris());
    System.out.println(lim.hentVirkestoff());
    System.out.println(lim.hentNarkotiskStyrke());
    lim.settNyPris(50.00);
    System.out.println(lim.hentPris());
    System.out.println(stov.hentId());



    //Tester PreparatB
    System.out.println("Testing PreparatB, skal gi sjokolade,2, 1, 2, 3, 50");
    System.out.println(sjokolade.toString());
    System.out.println(sjokolade.hentNavn());
    System.out.println(sjokolade.hentId());
    System.out.println(sjokolade.hentPris());
    System.out.println(sjokolade.hentVirkestoff());
    System.out.println(sjokolade.hentVanedannendeStyrke());
    sjokolade.settNyPris(50.00);
    System.out.println(sjokolade.hentPris());

    //Tester PreparatC
    System.out.println("Testing PreparatC, skal gi ibux,3,9,8,50");
    System.out.println(ibux.toString());
    System.out.println(ibux.hentNavn());
    System.out.println(ibux.hentId());
    System.out.println(ibux.hentPris());
    System.out.println(ibux.hentVirkestoff());
    ibux.settNyPris(50.00);
    System.out.println(ibux.hentPris());


    test("tester navn", "Sivert", "Sivert");
    test("alder", 21, 21);
  }

  static boolean test(String beskrivelse, String inn, String forventet){
    System.out.print(beskrivelse + ": ");

    if(inn.equals(forventet)){
      System.out.print("True");
      return true;
    }else{
      System.out.print("False");
      return false;
    }
  }

  static boolean test(String beskrivelse, int inn, int forventet){
    System.out.print(beskrivelse + ": ");

    if(inn == forventet){
      System.out.print("True");
      return true;
    }else{
      System.out.print("False");
      return false;
    }
  }
}
