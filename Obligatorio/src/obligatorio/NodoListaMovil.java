package obligatorio;

public class NodoListaMovil {

    private Object dato;
    private NodoListaMovil sig;
    private boolean Estado;

    public NodoListaMovil(Object dato) {
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

    public NodoListaMovil getSig() {
        return sig;
    }

    public void setSig(NodoListaMovil sig) {
        this.sig = sig;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

}
