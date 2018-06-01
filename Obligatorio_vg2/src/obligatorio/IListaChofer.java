
package obligatorio;

interface IListaChofer {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(Object dato);
    public void borrarInicio();
    public void agregarFinal(Object dato);
    public void borrarFin();
    public void vaciar();
    public void mostrar();
    public void agregarOrd(Object dato);
    public NodoListaChofer obtenerElemento(Object dato);
    
}
