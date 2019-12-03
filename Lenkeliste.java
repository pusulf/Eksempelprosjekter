import java.util.Iterator;

class Lenkeliste<T> implements Liste<T> {

  protected Node start;
  protected Node slutt;
  protected int storrelse = 0;



  public Lenkeliste(){
    start = new Node(null);
    slutt = new Node(null);

    start.neste = slutt;
    slutt.forrige = start;

  }


  //Bruker en privat klasse kalt node fordi kun Lenkeliste skal bruke Node
  class Node{
    Node neste;
    Node forrige;
    T data;

    Node(T data) {
      this.data = data;
    }


    public void settMellom(Node foer, Node etter) {
      foer.neste = this;
      etter.forrige = this;
      this.forrige = foer;
      this.neste = etter;
    }

    public void fjernMellom(Node foer, Node etter) {
      foer.neste = etter;
      etter.forrige = foer;
    }
  }

  public Iterator<T> iterator(){ // Kaller paa et object som implimenterer Iterator<T> interfacet
    return new LenkelisteIterator();
  }



  class LenkelisteIterator implements Iterator<T>{ // LenkelisteIterator er en klasse som itererer gjennom lenkelister
    Node node = start.neste;


    public boolean hasNext(){
      //Denne returner true hvis neste node ikke er slutt
      return (node != slutt);
    }

    public T next(){
      //Mellomlagrer dataen
      T nodeData = node.data;
      //Henter neste node
      node = node.neste;
      //returnerer dataen til noden vi tuller med
      return nodeData;
    }
  }


  //Mest for ovingens skyld
  public int stoerrelse() {
    return storrelse;
  }

  public void leggTil(T x) {
    Node nyNode = new Node(x);
    nyNode.settMellom(slutt.forrige,slutt);

    storrelse ++;
  }

  /*

  public void leggTil(T x) {
    //Hvis det ikke er noen noder
    if (storrelse == 0) {
      Node nyNode = new Node(x);
      start = nyNode;
      slutt = nyNode;

      //Hvis det er noen noder fra for
    } else {
      //Ny node opprettes, gammel slutt er ny nodes forrige og slutt peker naa paa ny Node
      Node nyNode = new Node(x);
      nyNode.forrige = slutt;
      slutt = nyNode;
      }

      storrelse ++;
    }

  */

  //MANGLER THROW ULOVELIG INDEX
  public void leggTil(int pos, T x) {

    if(pos < 0) {throw new UgyldigListeIndeks(pos);
    }

    //Hvis det ikke er noen noder
    if (storrelse == 0) {
      if(pos != 0) {throw new UgyldigListeIndeks(pos);
      }
      Node nyNode = new Node(x);
      //Sett mellom
      start.neste = nyNode;
      slutt.forrige = nyNode;
      nyNode.forrige = start;
      nyNode.neste = slutt;

      //Hvis det er noen noder fra for
    } else {

      if(pos > storrelse) {throw new UgyldigListeIndeks(pos);
      }

      //henter stedet i listen vi vil legge inn et objekt
      //n blir noden paa den plassen vi vil putte den nye noden inn på
      //start.neste er den forste ordentlige noden i lenka
      Node n = start.neste;
      int index = 0;
      while(index != pos) {index ++; n = n.neste;
      }


      //Naar denne lokken er ferdig er n Noden på indexen vi onsker aa sette inn et nytt element paa
      Node nyNode = new Node(x);
      nyNode.settMellom(n.forrige,n);
      }

    storrelse ++;
  }


  //Denne metroden overskiver dataen i en node
  //Ikke laget for tom liste
  //Ikke laget for ulovelig index
  public void sett(int pos, T x) {
    //Sjekker om indexen er riktig
    if(pos < 0 || pos >= storrelse) {throw new UgyldigListeIndeks(pos);
    }

    if(storrelse == 0) {throw new UgyldigListeIndeks(-1);
    }

    // Finner riktig node
    Node n = start.neste;
    int index = 0;
    while(index != pos) {index ++; n = n.neste;
    }

    //overskiver daaen
    n.data = x;
  }


  public T hent(int pos) {
    //sjekker om posisjonen er gyldig
    if(pos < 0 || pos >= storrelse) {throw new UgyldigListeIndeks(pos);
    }

    Node n = start.neste;
    int index = 0;
    while(index != pos) {index ++; n = n.neste;
    }

    return n.data;
  }

  //IKKE LAGET FOR TOM LISTE
  //Ikke laget for ulovelig index
  public T fjern(int pos) {
    if(pos < 0 || pos >= storrelse) {throw new UgyldigListeIndeks(pos);
    }

    if(storrelse == 0) {throw new UgyldigListeIndeks(-1);
    }


    //Finner riktig node
    Node n = start.neste;
    int index = 0;
    while(index != pos) {index ++; n = n.neste;
    }

    n.fjernMellom(n.forrige,n.neste);

    storrelse --;

    return n.data;
  }

  //Mangler tom liste evet
  //Ikke laget for ulobvelig index
  public T fjern() {
    if(storrelse == 0) {throw new UgyldigListeIndeks(-1);
    }

    //Kunne brukt fjern mellom

    Node skalBort = start.neste;

    skalBort.neste.forrige = start;
    start.neste = skalBort.neste;

    storrelse --;
    return skalBort.data;
  }



  /*

  public T velgFraListe(){
    int i = 0;
    System.out.println("Skriv inn tallet som korresponderer med ditt valg, og trykk enter");
    for(T element:this){
      System.out.println(i+": " + element);
      i++;
    }

    int valgtElement = lesIntFraBruker();
    if(valgtElement > 0 && valgtElement < this.stoerrelse()){
    return this.hent(valgtElement);
    } else {System.out.println("Du har valgt et ugyldig element: " + valgtElement);
      velgFraListe();
        }
  }
  */
}
