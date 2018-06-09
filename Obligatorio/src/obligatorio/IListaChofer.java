package obligatorio;

interface IListaChofer {

    //metodos de la interfaz
    public void encolar(Object cedula, String nombre);

    public void desencolar(Object cedula);

    public boolean esVacia();

    public boolean esllena();

    public Object frente();

    public int elementos();

}
