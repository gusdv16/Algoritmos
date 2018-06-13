package obligatorio;

import obligatorio.IListaChofer;

public class ListaChofer implements IListaChofer {

    private NodoListaChofer inicio;
    private NodoListaChofer fin;
    private int cantelementos;

    //Constructor
    public void ListaChofer() {
        this.inicio = null;
        this.fin = null;
        this.cantelementos = 0;
    }

    //Inicio
    public void setInicio(NodoListaChofer i) {
        inicio = i;
    }

    public NodoListaChofer getInicio() {
        return inicio;
    }

    //Fin
    public void setFin(NodoListaChofer f) {
        fin = f;
    }

    public NodoListaChofer getFin() {
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
    public void agregarInicio(Object dato, String nombre) {
        NodoListaChofer nuevo = new NodoListaChofer(dato,nombre);
        nuevo.setSiguiente(inicio);
        this.inicio = nuevo;
        if (this.fin == null)//estoy insertando el primer nodo
        {
            this.fin = nuevo;
        }

        this.cantelementos = this.cantelementos + 1;
    }

    //PRE:
    //POS: Borra el primer nodo
    public void borrarInicio() {
        if (!this.esVacia()) {
            this.inicio = this.inicio.getSiguiente();
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
            System.out.println("Lista es vacía");
        } else {
            NodoListaChofer aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getCedula()+aux.getNombre());
                aux = aux.getSiguiente();
            }
        }
    }

  
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public void agregarFinal(Object dato, String nombre) {
        //NodoLista nuevo= new NodoLista(n);
        if (this.esVacia()) {
            this.agregarInicio(dato,nombre); // el agregar inicio suma 1 a cantelementos
        } else {
            NodoListaChofer nuevo = new NodoListaChofer(dato,nombre);
            fin.setSiguiente(nuevo);
            fin = nuevo;
            this.cantelementos = this.cantelementos + 1;
        }

    }

    //PRE:
    //POS: Borra el último nodo
    public void borrarFin() {
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();  // actualiza canelementos
            } else {
                NodoListaChofer aux = this.inicio;
                while (aux.getSiguiente().getSiguiente()!= null) {
                    aux = aux.getSiguiente();
                }
                this.fin = aux;
                this.fin.setSiguiente(null);
                this.cantelementos = this.cantelementos - 1;
            }
        }
    }

   //PRE:
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(Object dato) {
        NodoListaChofer anterior = this.getInicio(), aux = this.getInicio();

        while (aux != null && aux.getCedula()!= dato) {
            anterior = aux;
            aux = aux.getSiguiente();
        }
        if (aux != null) {
            anterior.setSiguiente(aux.getSiguiente());
        }
    }

    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos() {
        return this.cantelementos;
    }

    //PRE: //POS:
    //PRE: //POS:
    public NodoListaChofer obtenerElemento(Object dato) {
        NodoListaChofer aux = this.inicio;
        while (aux != null && aux.getCedula()!= dato) {
            aux = aux.getSiguiente();
        }
        //encontrÃ© dato o lleguÃ© al final
        return aux;
    }

    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoListaChofer l) {
        if (l != null) {
            System.out.println(l.getCedula());
            mostrarREC(l.getSiguiente());

        }
    }


}
