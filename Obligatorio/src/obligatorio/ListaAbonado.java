package obligatorio;

import obligatorio.IListaAbonado;

public class ListaAbonado implements IListaAbonado {

    private NodoListaAbonado inicio;
    private NodoListaAbonado fin;
    private int cantelementos;

    //Constructor
    public ListaAbonado() {
        this.inicio = null;
        this.fin = null;
        this.cantelementos = 0;
    }

    //Inicio
    public void setInicio(NodoListaAbonado i) {
        inicio = i;
    }

    public NodoListaAbonado getInicio() {
        return inicio;
    }

    //Fin
    public void setFin(NodoListaAbonado f) {
        fin = f;
    }

    public NodoListaAbonado getFin() {
        return fin;
    }

    public int getCantelementos() {
        return cantelementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }

    /**
     * ************Métodos Básicos******************
     */
    /**
     * ********************************************
     */
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    public boolean esVacia() {
        return (this.inicio == null);
    }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public void agregarInicio(Object dato, String abonadoNombre, String abonadoDireccion, String abonadoTel) {
        NodoListaAbonado nuevo = new NodoListaAbonado(dato, abonadoNombre, abonadoDireccion, abonadoTel);
        nuevo.setSig(inicio);
        this.inicio = nuevo;
        if (this.fin == null)//estoy insertando el primer nodo
        {
            this.fin = nuevo;
        }

        this.cantelementos = this.cantelementos + 1;
    }

    //PRE:
    //POS: Borra el primer nodo
    public void desencolar() {
        if (!this.esVacia()) {
            this.inicio = this.inicio.getSig();
            this.cantelementos = this.cantelementos - 1;
        }
    }
    //PRE:
    //POS: elimina todos los nodos de una lista dada

    public void vaciar() {
        this.inicio = null;
        this.fin = null;
        this.cantelementos = 0;
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrar() {
        if (this.esVacia()) {
            System.out.println("\tLista es vacía");
        } else {
            NodoListaAbonado aux = this.inicio;
            while (aux != null) {
                System.out.println("\t" + aux.getAbonadoID());
                aux = aux.getSig();
            }
        }
    }

    /*Variantes agregadas a los metodos basicos.*/
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public void encolar(Object dato, String abonadoNombre, String abonadoDireccion, String abonadoTel) {
        //NodoLista nuevo= new NodoLista(n);
        if (this.esVacia()) {
            this.agregarInicio(dato, abonadoNombre, abonadoDireccion, abonadoTel); // el agregar inicio suma 1 a cantelementos
        } else {
            NodoListaAbonado nuevo = new NodoListaAbonado(dato, abonadoNombre, abonadoDireccion, abonadoTel);
            fin.setSig(nuevo);
            fin = nuevo;
            this.cantelementos = this.cantelementos + 1;
        }
    }

    public Object frente() {
        return fin.getAbonadoID();
    }

    //PRE:
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(Object dato) {
        NodoListaAbonado anterior = this.getInicio(), aux = this.getInicio();

        while (aux != null && aux.getAbonadoID() != dato) {
            anterior = aux;
            aux = aux.getSig();
        }
        if (aux != null) {
            anterior.setSig(aux.getSig());
        }
    }

    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos() {
        return this.cantelementos;
    }

    //PRE: //POS:
    //PRE: //POS:
    public NodoListaAbonado obtenerElemento(Object dato) {
        NodoListaAbonado aux = this.inicio;
        while (aux != null && aux.getAbonadoID() != dato) {
            aux = aux.getSig();
        }
        //encontro dato o lleguo al final
        return aux;
    }

}
