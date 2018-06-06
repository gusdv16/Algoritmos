package obligatorio;

public class NodoListaAbonado {

    private Object dato;
    private NodoListaAbonado sig;
    private boolean Estado;

    public NodoListaAbonado(Object dato) {
        this.dato = dato;
        this.sig = null;
        this.Estado = true;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoListaAbonado getSig() {
        return sig;
    }

    public void setSig(NodoListaAbonado sig) {
        this.sig = sig;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

}
