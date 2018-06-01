
package obligatorio;

public class NodoListaChofer{
	private Object dato;
	private NodoListaChofer sig;

    public NodoListaChofer(Object dato) {
        this.dato = dato;
        this.sig = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoListaChofer getSig() {
        return sig;
    }

    public void setSig(NodoListaChofer sig) {
        this.sig = sig;
    }

 
}
