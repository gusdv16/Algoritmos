package obligatorio;

public class metodos {
    //se asume que existen todos los datos
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

    //se asume que existen todos los datos
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

    //se asume que existen todos los datos
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

    //se asume que existen todos los datos
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

    //PRE: La zona debe existir
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
