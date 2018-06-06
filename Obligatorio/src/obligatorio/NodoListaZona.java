package obligatorio;

public class NodoListaZona {

    private Object dato;
    private ListaMovil lm;
    private ListaAbonado la;
    private NodoListaZona sig;
    private static int id = 1;
    int idZona;

    public NodoListaZona(Object dato) {
        this.dato = dato;
        this.lm = new ListaMovil();
        this.la = new ListaAbonado();
        this.sig = null;
        idZona = this.id++;
    }

    public ListaAbonado getLa() {
        return la;
    }

    public void setLa(ListaAbonado la) {
        this.la = la;
    }

    public int getIdZona() {
        return idZona;
    }

//    public void setIdZona(int idZona) {
//        this.idZona = idZona;
//    }
    public ListaMovil getLm() {
        return lm;
    }

    public void setLm(ListaMovil lm) {
        this.lm = lm;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoListaZona getSig() {
        return sig;
    }

    public void setSig(NodoListaZona sig) {
        this.sig = sig;
    }
}
