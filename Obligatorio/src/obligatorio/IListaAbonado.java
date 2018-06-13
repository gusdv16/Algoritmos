package obligatorio;

interface IListaAbonado {

    //metodos de la interfaz
    public boolean esVacia();

    public void agregarInicio(int dato, String abonadoNombre, String abonadoDireccion, String abonadoTel);

    public void borrarInicio();

    public void vaciar();

    public void mostrar();

    public void agregarFinal(int dato, String abonadoNombre, String abonadoDireccion, String abonadoTel);

    public void borrarFin();

    public void borrarElemento(int dato);

    public int cantElementos();

    public NodoListaAbonado obtenerElemento(int dato);

    public void mostrarREC(NodoListaChofer l);

}
