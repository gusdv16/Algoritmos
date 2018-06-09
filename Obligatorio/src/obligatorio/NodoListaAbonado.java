package obligatorio;

public class NodoListaAbonado {

    private Object abonadoID;
    private NodoListaAbonado sig;
    private String abonadoNombre;
    private String abonadoDireccion;
    private String abonadoTel;
    private boolean Estado;

    public NodoListaAbonado(Object dato, String abonadoNombre, String abonadoDireccion, String abonadoTel) {
        this.abonadoID = dato;
        this.sig = null;
        this.abonadoNombre = abonadoNombre;
        this.abonadoDireccion = abonadoDireccion;
        this.abonadoTel = abonadoTel;
        this.Estado = true;
    }

    public Object getAbonadoID() {
        return abonadoID;
    }

    public void setAbonadoID(Object abonadoID) {
        this.abonadoID = abonadoID;
    }

    public NodoListaAbonado getSig() {
        return sig;
    }

    public void setSig(NodoListaAbonado sig) {
        this.sig = sig;
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
