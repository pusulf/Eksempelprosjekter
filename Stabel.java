class Stabel<T> extends Lenkeliste<T> {

  public void leggPaa(T x) {
    Node nyNode = new Node(x);
    nyNode.settMellom(slutt.forrige,slutt);

    storrelse ++;
  }

  public T taAv() {
    //Fjern posisjon (storrelse -1) kunne også funka

    if(storrelse == 0) {throw new UgyldigListeIndeks(-1);
    }

    T x = slutt.forrige.data;
    slutt.forrige.fjernMellom(slutt.forrige.forrige,slutt);

    storrelse --;
    return x;
  }
}
