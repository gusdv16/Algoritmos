package obligatorio;

interface IListaAbonado {

    //metodos de la interfaz
    public boolean esVacia();

    public void agregarInicio(Object dato, String abonadoNombre, String abonadoDireccion, String abonadoTel);

    public void desencolar();

    public void encolar(Object dato, String abonadoNombre, String abonadoDireccion, String abonadoTel);

    public void vaciar();

    public void mostrar();

    public Object frente();

    public NodoListaAbonado obtenerElemento(Object dato);
}
