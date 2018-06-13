package obligatorio;

interface IListaChofer {

    //metodos de la interfaz
    public boolean esVacia();

    public void agregarInicio(Object dato, String nombre);

    public void borrarInicio();

    public void agregarFinal(Object dato, String nombre);

    public void borrarFin();

    public void vaciar();

    public void mostrar();

    public NodoListaChofer obtenerElemento(Object dato);

}
