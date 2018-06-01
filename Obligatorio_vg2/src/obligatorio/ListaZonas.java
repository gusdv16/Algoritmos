//package obligatorio;
//
//public class ListaZonas implements IlistaZonas {
//
//    private int cantElementos;
//    private int tope;
//    private NodoCiudad inicio;
//    private NodoCiudad fin;
//
//    public NodoCiudad getFin() {
//        return fin;
//    }
//
//    public void setFin(NodoCiudad fin) {
//        this.fin = fin;
//    }
//
//    public ListaCiudades(int cantMaxCiudades) {
//        this.cantElementos = cantMaxCiudades;
//        this.tope = 0;
//        this.inicio = null;
//    }
//
//    //Constructor cuando la cantidad de ciudades es limitada
//    //Constructor cuando no es limitada
//    public ListaZonas() {
//        //Ver si sirve cantCiudades
//        this.tope = 0;
//        this.inicio = null;
//    }
//
//    public int getCantElementos() {
//        return cantElementos;
//    }
//
//    public void setCantElementos(int cantElementos) {
//        this.cantElementos = cantElementos;
//    }
//
//    public int getTope() {
//        return tope;
//    }
//
//    public void setTope(int tope) {
//        this.tope = tope;
//    }
//
//    public NodoZona getInicio() {
//        return inicio;
//    }
//
//    public void setInicio(NodoZona inicio) {
//        this.inicio = inicio;
//    }
//
//    public int obtenerPosicionElemento(String Zona) {
//
//        NodoZona aux = this.inicio;
//        int contador = 1;
//        while (aux != null && aux.getDato() != Zona) {
//
//            aux = aux.getSiguiente();
//            ++contador;
//        }
//        if (aux == null) {
//            contador = -1;
//        }
//
//        return contador;
//
//    }
//
//    public String BuscarCiudadDadaPos(int pos) {
//        int contador = 1;
//        NodoZona aux = this.inicio;
//
//        if (pos == 0) {
//            return aux.getNombreZona();
//        } else if (pos > this.cantElementos) {
//            return "No se encuentra la ciudad";
//        } else {
//
//            while (aux != null && contador != pos) {
//                aux = aux.getSiguiente();
//                contador++;
//            }
//        }
//
//        return aux.getNombreZona();
//
//    }
//
//    @Override
//    public Retorno.Resultado agregarInicio(String dato) {
//        NodoZona nuevo = new NodoZona(dato);
//        nuevo.setSiguiente(inicio);
//        this.inicio = nuevo;
//        if (this.fin == null)//estoy insertando el primer nodo
//        {
//            this.fin = nuevo;
//        }
//
//        this.cantElementos = this.cantElementos + 1;
//
//        return Retorno.Resultado.OK;
//    }
//
//    //PRE:
//    //POS: Borra el primer nodo
//    @Override
//    public void borrarInicio() {
//        if (!this.esVacia()) {
//            this.inicio = this.inicio.getSiguiente();
//            this.cantElementos = this.cantElementos - 1;
//        }
//    }
//    //PRE:
//    //POS: elimina todos los nodos de una lista dada
//
//    @Override
//    public void vaciar() {
//        this.inicio = null;
//        this.fin = null;
//        this.cantElementos = 0;
//    }
//
//    //PRE:
//    //POS: Recorre y muestra los datos de lista
//    @Override
//    public void mostrar() {
//        if (this.esVacia()) {
//            System.out.println("Lista es vacía");
//        } else {
//            NodoZona aux = this.inicio;
//            while (aux != null) {
//                System.out.println(aux.getDato());
//                aux = aux.getSiguiente();
//            }
//        }
//    }
//
//    //PRE:
//    //POS: Agrega un nuevo Nodo al final de la lista
//    @Override
//    public void agregarFinal(String dato) {
//        if (this.esVacia()) {
//            this.agregarInicio(dato);
//        } else {
//            NodoZona nuevo = new NodoZona(dato);
//            fin.setSiguiente(nuevo);
//            fin = nuevo;
//            this.cantElementos = this.cantElementos++;
//        }
//
//    }
//
//    //PRE:
//    //POS: Borra el último nodo
//    @Override
//    public void borrarFin() {
//        if (!this.esVacia()) {
//            if (this.inicio == this.fin) {
//                this.borrarInicio();  // actualiza canelementos
//            } else {
//                NodoZona aux = this.inicio;
//                while (aux.getSiguiente().getSiguiente() != null) {
//                    aux = aux.getSiguiente();
//                }
//                this.fin = aux;
//                this.fin.setSiguiente(null);
//                this.cantElementos = this.cantElementos--;
//            }
//        }
//    }
//
//    //PRE: 
//    //POS: Retorna la cantidad de nodos que tiene la lista
//    @Override
//    public int cantElementos() {
//        return this.cantElementos;
//    }
//
//    //PRE: //POS:
//    //PRE: //POS:
//    @Override
//    public NodoZona obtenerElemento(String dato) {
//        NodoZona aux = this.inicio;
//
//        while (aux != null && aux.getDato() != dato) {
//            aux = aux.getSiguiente();
//        }
//        return aux;
//    }
//
//    @Override
//    public boolean esVacia() {
//        return this.inicio == null;
//    }
//}
