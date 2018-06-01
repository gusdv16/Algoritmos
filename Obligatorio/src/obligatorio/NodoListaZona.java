package obligatorio;

public class NodoListaZona {

    private Object dato;
    private ListaMovil lm;
    private NodoListaZona sig;

    public NodoListaZona(Object dato) {
        this.dato = dato;
        this.lm = new ListaMovil();
        this.sig = null;
    }

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
