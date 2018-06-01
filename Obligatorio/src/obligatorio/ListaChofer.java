package obligatorio;

import obligatorio.IListaChofer;

public class ListaChofer implements IListaChofer {

    private NodoListaChofer inicio;
    private NodoListaChofer fin;
    private int cantelementos;

    //Constructor
    public ListaChofer() {
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
    public void agregarInicio(Object dato) {
        NodoListaChofer nuevo = new NodoListaChofer(dato);
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
    public void borrarInicio() {
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
            System.out.println("Lista es vacía");
        } else {
            NodoListaChofer aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getDato());
                aux = aux.getSig();
            }
        }
    }

    /*Variantes agregadas a los metodos basicos.*/
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public void agregarFinal(Object dato) {
        //NodoLista nuevo= new NodoLista(n);
        if (this.esVacia()) {
            this.agregarInicio(dato); // el agregar inicio suma 1 a cantelementos
        } else {
            NodoListaChofer nuevo = new NodoListaChofer(dato);
            fin.setSig(nuevo);
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
                while (aux.getSig().getSig() != null) {
                    aux = aux.getSig();
                }
                this.fin = aux;
                this.fin.setSig(null);
                this.cantelementos = this.cantelementos - 1;
            }
        }
    }

    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public void agregarOrd(Object dato) {
        //lista vacìa o primer elemento es mayor o igual => agrego al ppio
        if (this.esVacia() || (this.inicio.getDato().toString().compareTo(dato.toString()) > 0)) {
            this.agregarInicio(dato);
            return;
        }
        if (this.fin.getDato().toString().compareTo(dato.toString()) < 0) {   //ùltimo elemento es menor o igual => agrego al final
            this.agregarFinal(dato);
            return;
        }
        NodoListaChofer aux = this.inicio;

        while (aux.getSig().getDato() != null && dato.toString().compareTo(aux.getSig().getDato().toString()) > 0) {
            aux = aux.getSig();
        }
        NodoListaChofer nuevo = new NodoListaChofer(dato);
        nuevo.setSig(aux.getSig());
        aux.setSig(nuevo);
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(Object dato) {   
        NodoListaChofer anterior = this.getInicio(),aux = this.getInicio();
        
        while (aux != null && aux.getDato() != dato) {
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
    public NodoListaChofer obtenerElemento(Object dato) {
        NodoListaChofer aux = this.inicio;
        while (aux != null && aux.getDato() != dato) {
            aux = aux.getSig();
        }
        //encontrÃ© dato o lleguÃ© al final
        return aux;
    }

    /**
     * *** para resolver en forma recursiva Métodos RECURSIVOS  ****
     */
    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoListaChofer l) {
        if (l != null) {
            System.out.println(l.getDato());
            mostrarREC(l.getSig());

        }
    }

}
