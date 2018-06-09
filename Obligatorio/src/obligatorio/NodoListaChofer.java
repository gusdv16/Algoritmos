package obligatorio;

public class NodoListaChofer {

    Object cedula;
    String nombre;
    NodoListaChofer siguiente;

    public NodoListaChofer(Object cedula,String nombre) {
        this.cedula = cedula;
        this.siguiente = null;
        this.nombre=nombre;
    }

    public Object getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(Object cedula) {
        this.cedula = cedula;
    }

    public NodoListaChofer getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaChofer siguiente) {
        this.siguiente = siguiente;
    }

}
