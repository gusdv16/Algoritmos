package obligatorio;

interface IListaAbonado {

    //metodos de la interfaz
    public boolean esVacia();

    public void agregarInicio(Object dato, int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel);

    public void borrarInicio();

    public void agregarFinal(Object dato, int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel);

    public void borrarFin();

    public void vaciar();

    public void mostrar();

    public void agregarOrd(Object dato, int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel);

    public NodoListaAbonado obtenerElemento(Object dato);
}
