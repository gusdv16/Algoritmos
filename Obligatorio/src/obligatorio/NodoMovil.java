package obligatorio;

public class NodoMovil {

    private Object dato;
    private NodoMovil sig;
    private ListaChofer lch;

    public NodoMovil(Object dato) {
        this.dato = dato;
        this.sig = null;
        this.lch = new ListaChofer();
    }

    public ListaChofer getLch() {
        return lch;
    }

    public void setCh(ListaChofer lch) {
        this.lch = lch;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoMovil getSig() {
        return sig;
    }

    public void setSig(NodoMovil sig) {
        this.sig = sig;
    }

}
