package obligatorio;

import obligatorio.ListaChofer;

public class NodoListaMovil {

    private Object dato;
    private NodoListaMovil sig;
    private boolean Estado;
    private int Viaje;
    private int Emergencias;

    private ListaChofer lch;

    public NodoListaMovil(Object dato) {
        this.dato = dato;
        this.sig = null;
        this.Estado = true;
        this.Viaje = 0;
        this.Emergencias = 0;
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

    public NodoListaMovil getSig() {
        return sig;
    }

    public void setSig(NodoListaMovil sig) {
        this.sig = sig;
    }

    public int getViaje() {
        return Viaje;
    }

    public void setViaje(int Viaje) {
        this.Viaje = Viaje;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public int getEmergencias() {
        return Emergencias;
    }

    public void setEmergencias(int Emergencias) {
        this.Emergencias = Emergencias;
    }
    

}
