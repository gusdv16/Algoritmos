package obligatorio;

public class metodos {

    //Pos:AGREGA UN MOVIL EN UNA ZONA
    //Pre:Asumimos que existe la zona
    public static void agregarMovilAZona(ListaZona lz, String Zona, String movil) {
        NodoListaZona unazona = lz.obtenerElemento(Zona);
        unazona.getLm().agregarOrd(movil);
    }

    //pre:se asume que existen todos los datos
    public static void viaje(ListaZona lz, String zonaOrigen, String zonaDestino, String movil) {
        agregarMovilAZona(lz, zonaDestino, movil);
        lz.obtenerElemento(zonaOrigen).getLm().borrarElemento(movil);
    }

//    //se asume que existen todos los datos
//    public static void cambiarUbicacionZona(ListaZona lz, String zonaDestino, String movil) {
//        NodoListaZona origen = lz.obtenerElemento(buscarZonaPorMovil(lz, movil));
//        NodoListaMovil pmovil = origen.getLm().obtenerElemento(movil);
//        lz.obtenerElemento(zonaDestino).getLm().getFin().setSig(pmovil);
//        lz.obtenerElemento(zonaDestino).getLm().setFin(pmovil);
//
//        NodoListaMovil aux = origen.getLm().getInicio();
//        while (aux.getSig() != pmovil) {
//            aux = aux.getSig();
//            aux.setSig(pmovil.getSig());
//            lz.obtenerElemento(zonaDestino).getLm().getFin().setSig(null);
//        }
//    }
    //pre:se asume que existen todos los datos
    //pos:se cambia el movil de zona
    public static void cambiarUbicacionZona(ListaZona lz, String zonaDestino, String movil) {

        agregarMovilAZona(lz, zonaDestino, movil);
        borrarMovil(lz, movil);
    }

    //pre:se asume que existen todos los datos
    // pos:se borra el movil que le pasamos de la lista de la zona que le pasamos
    public static void borrarMovil(ListaZona lz, String movil) {
        NodoListaZona origen = lz.obtenerElemento(buscarZonaPorMovil(lz, movil).getDato());
        NodoListaMovil pmovil = origen.getLm().obtenerElemento(movil);

        ListaMovil aux = origen.getLm();
        if (aux.getInicio() == pmovil) {
            aux.borrarInicio();
        } else if (aux.getFin() == pmovil) {
            aux.borrarFin();
        } else {
            aux.borrarElemento(movil);
        }
    }

    //pre:se asume que existen todos los datos
    //pos:borra el elemento abonado que le pasas por parametro
    public static void borrarAbonado(ListaZona lz, int abonadoId) {
        NodoListaZona origen = lz.obtenerElemento(buscarZonaPorAbonado(lz, abonadoId).getDato());
        NodoListaAbonado pabonado = origen.getLa().obtenerElemento(abonadoId);

        ListaAbonado aux = origen.getLa();
        if (aux.getFin() == pabonado) {
            aux.borrarElemento(abonadoId);
        } else {
            aux.borrarElemento(abonadoId);
        }
    }

    //pre:se asume que existen todos los datos
    //pos: devuelve la zona donde se encuentra el movil que le pasas por parametro
    public static NodoListaZona buscarZonaPorMovil(ListaZona lz, String movil) {
        NodoListaZona aux = lz.getInicio();

        while (aux != null) {
            if (aux.getLm().obtenerElemento(movil) != null) {
                return aux;
            }
            aux = aux.getSig();
        }
        return null;
    }

    //pre:se asume que existen todos los datos
    //pos: lo mismo que el anterior pero trae el movil que tiene el chofer
    public static NodoListaMovil buscarMovilPorChofer(ListaMovil lm, String chofer) {
        NodoListaMovil aux = lm.getInicio();

        while (aux != null) {
            if (aux.getLch().obtenerElemento(chofer) != null) {
                return aux;
            }
            aux = aux.getSig();
        }
        return null;
    }

    //pre:se asume que existen todos los datos
    //pos: lo mismo que los dos anteriores pero esta es la zona donde esta el abonado lo que te devuelve
    public static NodoListaZona buscarZonaPorAbonado(ListaZona lz, int abonadoID) {
        NodoListaZona aux = lz.getInicio();

        while (aux != null) {
            if (aux.getLa().obtenerElemento(abonadoID) != null) {
                return aux;
            }
            aux = aux.getSig();
        }
        return null;
    }
//pre: la zona que se le pasa existe
    //pos: muestra todas las zonas existentes
    public static void mostrarZonasCompleto(ListaZona lz) {
        NodoListaZona aux = lz.getInicio();

        while (aux != null) {
            System.out.println("\n" + aux.getDato());
            aux.getLm().mostrar();

//            NodoListaMovil aux2 = aux.getLm().getInicio();
//            if (aux2.getLch() != null) {
//                while (aux2 != null) {
//                    System.out.println("\n" + aux2.getDato());
//                    aux2.getLch().mostrar();
//                    aux2 = aux2.getSig();
//                }
//            }
            aux = aux.getSig();
        }
    }

    //PRE: La zona debe existir
    //post:retorna la cantidad de moviles que estan disponible para la zona que le pasas por parametro
    public static int cantidadMovilesDisponibles(ListaZona Lz, int zonaID) {
        NodoListaZona aux = Lz.getInicio();
        int movilesDisponibles = 0;

        while (aux != null) {
            if (aux.idZona == zonaID) {
                NodoListaMovil aux1 = aux.getLm().getInicio();
                while (aux1 != null) {
                    if (aux1.isEstado()) {
                        movilesDisponibles++;
                    }
                    aux1 = aux1.getSig();
                }
            }
            aux = aux.getSig();
        }
        return movilesDisponibles;
    }

    //PRE: La zona debe existir
    //pos: devuelve un movil disponible para la zona que esta como parametro 
    public static NodoListaMovil MovilDisponible(ListaZona Lz, int zonaID) {
        NodoListaZona aux = Lz.getInicio();

        while (aux != null) {
            if (aux.idZona == zonaID) {
                NodoListaMovil aux1 = aux.getLm().getInicio();
                while (aux1 != null && !aux1.isEstado()) {
                    aux1 = aux1.getSig();
                }
                return aux1;
            }
            aux = aux.getSig();
        }
        return null;
    }
//pre: la matriz existe o sea el mapa existe
    //pos: te imprime en pantalla la matriz
    public static void mostrarmapa(int[][] mapa) {
        int filas = mapa.length;
        int columnas = mapa[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(mapa[i][j] + " - ");
            }
            System.out.println();
        }

    }
//pre:la lista zona es existente
    //pos: muestra en pantalla los abonados en esa zona
    
    public static void mostrarAbonados(ListaZona lz) {
        NodoListaZona aux = lz.getInicio();

        while (aux != null) {
            System.out.println("\n" + aux.getDato());
//            aux.getLm().mostrar();

            NodoListaAbonado aux2 = aux.getLa().getInicio();
//            if (aux2.getLch() != null) {
            while (aux2 != null) {
                System.out.println("\n" + aux2.getAbonadoID());
//                    aux2.getLch().mostrar();
                aux2 = aux2.getSig();
            }
//            }
            aux = aux.getSig();
        }
    }
}
