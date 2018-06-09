package obligatorio;

public class NodoListaAbonado {

    private Object dato;
    private NodoListaAbonado sig;
    private int abonadoID;
    private String abonadoNombre;
    private String abonadoDireccion;
    private String abonadoTel;
    private boolean Estado;

    public NodoListaAbonado(Object dato, int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel) {
        this.dato = dato;
        this.sig = null;
        this.abonadoID = abonadoID;
        this.abonadoNombre = abonadoNombre;
        this.abonadoDireccion = abonadoDireccion;
        this.abonadoTel = abonadoTel;
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

    public int getAbonadoID() {
        return abonadoID;
    }

    public void setAbonadoID(int abonadoID) {
        this.abonadoID = abonadoID;
    }

    public String getAbonadoNombre() {
        return abonadoNombre;
    }

    public void setAbonadoNombre(String abonadoNombre) {
        this.abonadoNombre = abonadoNombre;
    }

    public String getAbonadoDireccion() {
        return abonadoDireccion;
    }

    public void setAbonadoDireccion(String abonadoDireccion) {
        this.abonadoDireccion = abonadoDireccion;
    }

    public String getAbonadoTel() {
        return abonadoTel;
    }

    public void setAbonadoTel(String abonadoTel) {
        this.abonadoTel = abonadoTel;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
}
