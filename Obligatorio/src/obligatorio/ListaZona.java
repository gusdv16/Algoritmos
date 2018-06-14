package obligatorio;

import obligatorio.IListaZona;

public class ListaZona implements IListaZona {

    private NodoListaZona inicio;
    private NodoListaZona fin;
    private int cantelementos;
//    private int idZona; 

    //Constructor
    public void Lista() {
        this.inicio = null;
        this.fin = null;
        this.cantelementos = 0;
//        this.idZona=0;
    }

    //Inicio
    public void setInicio(NodoListaZona i) {
        inicio = i;
    }

    public NodoListaZona getInicio() {
        return inicio;
    }

    //Fin
    public void setFin(NodoListaZona f) {
        fin = f;
    }

    public NodoListaZona getFin() {
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
        NodoListaZona nuevo = new NodoListaZona(dato);
        nuevo.setSig(inicio);
        this.inicio = nuevo;
        if (this.fin == null)//estoy insertando el primer nodo
        {
            this.fin = nuevo;
        }

        this.cantelementos++;
//        this.idZona ++;
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
            NodoListaZona aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getDato());
                aux = aux.getSig();
            }
        }
    }
   

//pre: //pos: devuelve la posicion de la zona segun el nombre que se le pasa por parametro
    public int obtenerPosicionElemento(String Zona) {

        NodoListaZona aux = this.inicio;
        int contador = 1;
        while (aux != null && aux.getDato() != Zona) {

            aux = aux.getSig();
            ++contador;
        }
        if (aux == null) {
            contador = -1;
        }

        return contador;

    }

//pre: //pos: devuevle el nombre de la zona segun la posicion que se le pasa por parametro
    public String BuscarZonaDadaPos(int pos) {
        int contador = 1;
        NodoListaZona aux = this.inicio;

        if (pos == 0) {
            return aux.getDato().toString();
        } else if (pos > this.cantelementos) {
            return "No se encuentra la ciudad";
        } else {

            while (aux != null && contador != pos) {
                aux = aux.getSig();
                contador++;
            }
        }

        return aux.getDato().toString();

    }

    /*Variantes agregadas a los metodos basicos.*/
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public void agregarFinal(Object dato) {
        //NodoLista nuevo= new NodoLista(n);
        if (this.esVacia()) {
            this.agregarInicio(dato); // el agregar inicio suma 1 a cantelementos
        } else {
            NodoListaZona nuevo = new NodoListaZona(dato);
            fin.setSig(nuevo);
            fin = nuevo;
            this.cantelementos = this.cantelementos + 1;
//            this.idZona ++;
        }

    }

    //PRE:
    //POS: Borra el último nodo
    public void borrarFin() {
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();  // actualiza canelementos
            } else {
                NodoListaZona aux = this.inicio;
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
//        //lista vacìa o primer elemento es mayor o igual => agrego al ppio
//        Object datonodo = this.inicio.getDato();
//        if (this.esVacia() || (this.inicio.getDato() > dato ){
//            this.agregarInicio(n);
//            return;
//        }
//        if (this.fin.getDato()<=n){   //ùltimo elemento es menor o igual => agrego al final
//            this.agregarFinal(n);
//            return;
//        }
//        NodoLista aux=this.inicio;
//        while (aux.getSig()!=null && aux.getSig().getDato() < n)
//           ;
//        NodoLista nuevo=new NodoLista(n);
//        nuevo.setSig(aux.getSig());
//        aux.setSig(nuevo);
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(Object dato) {
        NodoListaZona anterior = this.getInicio(), aux = this.getInicio();

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
    public NodoListaZona obtenerElemento(Object dato) {
        NodoListaZona aux = this.inicio;
        while (aux != null && aux.getDato() != dato) {
            aux = aux.getSig();
        }
        //encontrÃ© dato o lleguÃ© al final
        return aux;
    }

    //PRE: //POS:
    //PRE: //POS:
    public NodoListaZona obtenerElementoPorId(int idZona) {
        NodoListaZona aux = this.inicio;
        while (aux != null && aux.getIdZona() != idZona) {
            aux = aux.getSig();
        }
        
        return aux;
    }

}
