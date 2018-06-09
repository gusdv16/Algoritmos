package obligatorio;

import obligatorio.IListaChofer;

public class ListaChofer implements IListaChofer {

    int maximo;
    int cantelementos;
    NodoListaChofer primero;
    NodoListaChofer ultimo;

    // maximo es la cantidad de elementos que soportara la cola
    public ListaChofer(int maximo) {
        this.maximo = maximo;
        this.cantelementos = 0;
        this.primero = null;
        this.ultimo = null;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getCantelementos() {
        return cantelementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }

    public NodoListaChofer getPrimero() {
        return primero;
    }

    public void setPrimero(NodoListaChofer primero) {
        this.primero = primero;
    }

    public NodoListaChofer getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoListaChofer ultimo) {
        this.ultimo = ultimo;
    }

// implementacion de los metodos de ICola
    @Override
    public void encolar(Object cedula, String nombre) {
        NodoListaChofer nuevo = new NodoListaChofer(cedula, nombre);

        if (this.cantelementos < this.maximo) {
            if (!this.esVacia()) {
                this.ultimo.siguiente = nuevo;
                this.ultimo = nuevo;
            } else {
                this.ultimo = nuevo;
                this.primero = nuevo;
            }
            this.cantelementos = this.cantelementos + 1;
        }
    }

    @Override
    public void desencolar(Object cedula) {
        if (!this.esVacia()) {
            this.primero = this.primero.siguiente;
            this.cantelementos = this.cantelementos - 1;
        }
    }

    @Override
    public boolean esVacia() {
        return (this.primero == null);
    }

    @Override
    public boolean esllena() {
        return (this.cantelementos == this.maximo);

    }

    @Override
    public Object frente() {
        if (!this.esVacia()) {
            return primero.cedula;
        } else {
            return ("Esta vacia:");
        }

    }

    @Override
    public int elementos() {
        return this.cantelementos;
    }

}
