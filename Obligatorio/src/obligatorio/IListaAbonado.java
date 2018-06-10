package obligatorio;

interface IListaAbonado {

    //metodos de la interfaz
    public boolean esVacia();

    public void agregarInicio(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel);

    public void desencolar();

    public void encolar(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel);

    public void vaciar();

    public void mostrar();

    public Object frente();

    public NodoListaAbonado obtenerElemento(int abonadoID);
}
