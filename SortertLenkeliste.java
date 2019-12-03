class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {
  //Node temp = start.neste;

  @Override
  public void leggTil(T x) {
    Node nyNode = new Node(x);

    if(storrelse == 0) {
      nyNode.settMellom(start,slutt);

      //Hvis det er mer enn 0 noder i listen
    } else {
        Node n = start.neste;

        //Om den er mindre enn n
        //Saa lenge nyNode sammenlignet med n er 1 eller 0, skal vi gaa til neste
        while(nyNode.data.compareTo(n.data) >= 0) {
          //Vi kunne lagd en start og slutt subklasse av node, som alltid er stoerst/minst
          if(n.neste == slutt) {
            nyNode.settMellom(n,slutt);
            storrelse ++;
            return;
          }
          n = n.neste;
        }
        nyNode.settMellom(n.forrige,n);
          /*

          REKURSJON
          temp = temp.neste;

          //Gjor rekursjon, fordi det er KULT!!!
          leggTil(x);

          */
      }
      storrelse ++;
  }

  @Override
  public T fjern() {
    if(storrelse == 0) {throw new UgyldigListeIndeks(-1);
    } else {
      Node x = slutt.forrige;
      slutt.forrige = x.forrige;
      x.forrige.neste = slutt;
      storrelse --;
      return x.data;
    }
  }

  @Override
  public void sett(int pos, T x) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void leggTil(int pos, T x) {
    throw new UnsupportedOperationException();
  }
}
