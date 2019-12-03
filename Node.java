class Node {

  Node neste = null;
  Node forrige = null;
  T data = null;


  public Node(T data) {

    this.data = data;

  }

  public T hentdata(){
    return data;
  }

  public Node hentNeste(){
    return neste;
  }

  public Node hentForrige(){
    return forrige;
  }
}
