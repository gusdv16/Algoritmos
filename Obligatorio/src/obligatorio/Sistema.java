package obligatorio;

import obligatorio.Retorno.Resultado;
import static obligatorio.metodos.*;

public class Sistema implements ISistema {

    public int cantZonas;
    public ListaZona Lz;
    int[][] matrizDeZonas;
    public ListaMovil Lm;

    @Override
    public Retorno crearSistemaEmergencias(int cantzonas) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (cantzonas <= 0) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La cantidad de ciudades debe ser mayor o igual a 0";
        } else {
            cantZonas = cantzonas;
            Lz = new ListaZona();
            Lm = new ListaMovil();

            matrizDeZonas = new int[cantzonas][cantzonas];

            for (int i = 0; i < matrizDeZonas.length; i++) {
                for (int j = 0; j < matrizDeZonas[i].length; j++) {
                    matrizDeZonas[i][j] = 0;
                }
            }

            ret.resultado = Resultado.OK;
            ret.valorString = "Sistema creado correctamente";
        }

        return ret;
    }

    @Override
    public Retorno destruirSistemaEmergencias() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Resultado.OK;
        ret.valorString = "Sistema destruido correctamente";
        Lz.vaciar();
        Lm.vaciar();
        cantZonas = 0;

        for (int i = 0; i < matrizDeZonas.length; i++) {
            for (int j = 0; j < matrizDeZonas[i].length; j++) {
                matrizDeZonas[i][j] = 0;
            }
        }

        return ret;
    }

    @Override
    public Retorno registrarMovil(String movilID, int zonaID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lz.obtenerElementoPorId(zonaID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona no existe";
        } else if (Lm.obtenerElemento(movilID) != null) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "Móvil ya existe en el sistema de emergencias";
        } else {
            Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaID).getDato()).getLm().agregarFinal(movilID);
            Lm.agregarOrd(movilID);
            ret.resultado = Resultado.OK;
            ret.valorString = "Móvil agregado a zona correctamente";
        }
        return ret;
    }

    @Override
    public Retorno deshabilitarMovil(String movilID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona zona = buscarZonaPorMovil(Lz, movilID);

        if (zona.getLm().obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema";
        } else if (zona.getLm().obtenerElemento(movilID).isEstado() == false) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "Móvil ya esta en estado NO_DISPONIBLE";
        } else if (zona.getLm().obtenerElemento(movilID).isEstado() == false) {
            ret.resultado = Resultado.ERROR_3;
            ret.valorString = "El Móvil esta asignado a un viaje";
        } else {
            zona.getLm().obtenerElemento(movilID).setEstado(false);
            ret.resultado = Resultado.OK;
            ret.valorString = "Móvil Desabilitado";
        }

        return ret;
    }

    @Override
    public Retorno habilitarMovil(String movilID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona zona = buscarZonaPorMovil(Lz, movilID);

        if (zona.getLm().obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema";
        } else if (zona.getLm().obtenerElemento(movilID).isEstado() == true) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "Móvil ya esta en estado DISPONIBLE";
        } else {
            zona.getLm().obtenerElemento(movilID).setEstado(true);
            ret.resultado = Resultado.OK;
            ret.valorString = "Móvil Habilitado";
        }

        return ret;
    }

    @Override
    public Retorno eliminarMovil(String movilID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona zona = buscarZonaPorMovil(Lz, movilID);

        if (zona.getLm().obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema";
        } else {
            borrarMovil(Lz, movilID);
            ret.resultado = Resultado.OK;
            ret.valorString = "Móvil Eliminado";
        }

        return ret;
    }

    @Override
    public Retorno buscarMovil(String movilID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona zona = buscarZonaPorMovil(Lz, movilID);

        if (zona == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema";
        } else {
            NodoListaMovil movil = zona.getLm().obtenerElemento(movilID);
            System.out.println(movil.getDato() + "|Estado: " + movil.isEstado() + "|Zona: " + zona.getDato() + "|#Emergencias: ");

            System.out.println();
            ret.resultado = Retorno.Resultado.OK;
        }

        return ret;
    }

    @Override
    public Retorno informeMovil() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        NodoListaMovil aux = Lm.getInicio();
        while (aux != null) {
            System.out.println("\t" + aux.getDato() + ";" + aux.isEstado());
            aux = aux.getSig();
        }

        System.out.println();
        ret.resultado = Retorno.Resultado.OK;

        return ret;
    }

    @Override
    public Retorno informeMovil(int zonaID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lz.obtenerElementoPorId(zonaID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona no existe";
        } else {
            NodoListaZona aux = Lz.getInicio();
            int moviles = 0;
            int movilesDisponibles = 0;
            String separador = ";";

            while (aux != null) {
                if (aux.idZona == zonaID) {
//                    NodoListaMovil aux1 = aux.getLm().getInicio();
                    ListaMovil aux0 = ordenarMoviles(aux.getLm());
                    NodoListaMovil aux1 = aux0.getInicio();

                    while (aux1 != null) {
                        if (aux1.getSig() == null) {
                            separador = "";
                        }
                        System.out.print(aux1.getDato() + separador);
                        if (aux1.isEstado()) {
                            movilesDisponibles++;
                        }
                        moviles++;
                        aux1 = aux1.getSig();
                    }
                    if (moviles > 0) {
                        System.out.print("|Total Móviles disponibles: " + movilesDisponibles);
                    }
                }
                aux = aux.getSig();
            }
            System.out.println();
            ret.resultado = Retorno.Resultado.OK;
        }

        return ret;
    }

    @Override
    public Retorno cambiarUbicacion(String movilID, int zonaID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ListaMovil listaMovilesOrigen = buscarZonaPorMovil(Lz, movilID).getLm();
        ListaMovil listaMovilesDestino = Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaID).getDato()).getLm();
        if (Lz.obtenerElementoPorId(zonaID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona Origen no existe";
        } else if (Lm.obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "El movil no existe";
        } else {
//            NodoListaZona zonaOrigen = buscarZonaPorMovil(Lz, movilID);
//            borrarMovil(Lz, movilID);

            listaMovilesOrigen.borrarElemento(movilID);
//            listaMovilesDestino.agregarFinal(Lm.obtenerElemento(movilID));
            listaMovilesDestino.agregarFinal(movilID);
            ret.resultado = Resultado.OK;
            ret.valorString = "Se cambio de zona";
        }

        return ret;
    }

    @Override
    public Retorno agregarZona(String zonaNombre) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (cantZonas <= Lz.cantElementos()) {
//            Lz.agregarFinal(zonaNombre);
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "Se paso la cantidad de zonas del sistema";
        } else {
            //se tiene que controlar el id
            if (Lz.obtenerElemento(zonaNombre) == null) {
                Lz.agregarFinal(zonaNombre);
                ret.resultado = Retorno.Resultado.OK;
                ret.valorString = "la zona se agregó correctamente";
            } else {
                ret.resultado = Retorno.Resultado.ERROR_2;
                ret.valorString = "La zona ya existe";
            }
        }
        return ret;
    }

    @Override
    public Retorno listarZonas() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        NodoListaZona aux = Lz.getInicio();

        while (aux != null) {
            System.out.print(aux.getIdZona() + ";" + aux.getDato() + "|\n");

            aux = aux.getSig();
        }
        System.out.println();
        ret.resultado = Retorno.Resultado.OK;

        return ret;
    }

    @Override
    public Retorno agregarRuta(int zonaOrigen, int zonaDestino, int minutosViaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (Lz.obtenerElementoPorId(zonaOrigen) == null) {
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "La zona origen no existe";
        } else if (Lz.obtenerElementoPorId(zonaDestino) == null) {
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "La zona destino no existe";
        } else if (minutosViaje < 1) {
            ret.resultado = Retorno.Resultado.ERROR_3;
            ret.valorString = "Los minutos son menores a 0";
        } else {
            matrizDeZonas[zonaOrigen - 1][zonaDestino - 1] = minutosViaje;
            matrizDeZonas[zonaDestino - 1][zonaOrigen - 1] = minutosViaje;

            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Se agrego la ruta.";
        }

        return ret;
    }

    @Override
    public Retorno modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje) {

//        mostrarmapa(matrizDeZonas);
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (Lz.obtenerElementoPorId(zonaOrigen) == null) {
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "La zona origen no existe";
        } else if (Lz.obtenerElementoPorId(zonaDestino) == null) {
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "La zona destino no existe";
        } else if (minutosViaje < 1) {
            ret.resultado = Retorno.Resultado.ERROR_3;
            ret.valorString = "Los minutos son menores a 0";
        } else {
            matrizDeZonas[zonaOrigen - 1][zonaDestino - 1] = minutosViaje;
            matrizDeZonas[zonaDestino - 1][zonaOrigen - 1] = minutosViaje;

            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Se agrego la ruta.";
        }
        System.out.println();
//        mostrarmapa(matrizDeZonas);
        return ret;
    }

    @Override
    public Retorno movilMasCercano(int zonaID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (Lz.obtenerElementoPorId(zonaID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona no existe";
        } else {
            //CUENTO LA CANTIDAD DE MOVILES HABILITADOS QUE HAY EN LA ZONA
            int cantDisponible = cantidadMovilesDisponibles(Lz, zonaID);

            //SI NO HAY MOVILES HABILITADOS EN LA ZONA BUSCO EN LA ZONA MAS CERCANA
            if (cantDisponible > 0) {
                NodoListaMovil movil = MovilDisponible(Lz, zonaID);
                System.out.println(movil.getDato() + ";0");
                ret.resultado = Retorno.Resultado.OK;
                ret.valorString = "Se encontro movil Disponible.";
            } else {
                int zonaIDM = zonaID - 1;
                int largo = matrizDeZonas.length;
                int duracion = matrizDeZonas[zonaIDM][1];
                int zonaMasCercana = 1;
                for (int i = 1; i < largo; i++) {
                    if (matrizDeZonas[zonaIDM][i] != 0 && matrizDeZonas[zonaIDM][i] < duracion) {
                        duracion = matrizDeZonas[zonaIDM][i];
                        zonaMasCercana = i + 1;
                    }
                }

                int cantDisponibleZonaMasCercana = cantidadMovilesDisponibles(Lz, zonaMasCercana);

                if (cantDisponibleZonaMasCercana > 0) {
                    NodoListaMovil movil = MovilDisponible(Lz, zonaMasCercana);
                    System.out.println(movil.getDato() + ";" + duracion);
                    ret.resultado = Retorno.Resultado.OK;
                    ret.valorString = "Se encontro movil Disponible.";
                } else {
                    ret.resultado = Retorno.Resultado.ERROR_2;
                    ret.valorString = "No se encontro un movil Disponible.";
                }
            }
        }

        return ret;
    }

    @Override
    public Retorno rutaMasRapida(int zonaOrigen, int zonaDestino) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona origen = Lz.obtenerElementoPorId(zonaOrigen);
        NodoListaZona destino = Lz.obtenerElementoPorId(zonaDestino);

        if (origen != null) {
            if (destino != null) {

                int columnas = matrizDeZonas[0].length;
                int duracion = Integer.MAX_VALUE;
                String escala = "";
                String camino = "";
                int escalaNum = 0;
                int zOrigen = zonaOrigen - 1;
                int zDestino = zonaDestino - 1;

                mostrarmapa(matrizDeZonas);
                //VERIFICO SI TIENE RUTA DIRECTA
                if (matrizDeZonas[zOrigen][zDestino] == 0) {
                    //RECORRO TODAS LAS COLUMNAS
                    for (int i = 0; i < columnas; i++) {
                        //VERIFICO RUTAS CONECTADAS AL ORIGEN
                        if (matrizDeZonas[zOrigen][i] > 0) {
                            //VERIFICO QUE ZONA CONECTADA A ORIGEN 
                            //SE CONECTA CON LA DE DESTINO
                            if (matrizDeZonas[i][zDestino] > 0) {
                                //BUSCO LA DURACION MAS CORTA
                                if (matrizDeZonas[zOrigen][i] != 0 && matrizDeZonas[zOrigen][i] < duracion) {
                                    duracion = matrizDeZonas[zOrigen][i];
                                    escalaNum = i;
                                }
                            }
                        }
                    }
                    escala = Lz.BuscarZonaDadaPos(Lz.cantElementos() - escalaNum);
                    camino = "Ir de " + Lz.obtenerElementoPorId(zonaOrigen).getDato() + " a " + Lz.obtenerElementoPorId(zonaDestino).getDato() + "\n";
                    camino += Lz.obtenerElementoPorId(zonaOrigen).getDato() + ";" + 0 + "|" + Lz.obtenerElementoPorId(escalaNum + 1).getDato();
                    camino += ";" + matrizDeZonas[escalaNum][zDestino];
                    camino += "|" + Lz.obtenerElementoPorId(zonaDestino).getDato() + ";" + duracion;
                    camino += "|Demora total: " + (duracion + matrizDeZonas[escalaNum][zDestino]);
                } else {
                    duracion = matrizDeZonas[zOrigen][zDestino];
                    escalaNum = 1;
                }

                System.out.println(camino);
                if (matrizDeZonas[zOrigen][zDestino] != 0 && matrizDeZonas[zOrigen][zDestino] > 0) {
                    camino = "camino directo " + zOrigen + " ; " + zDestino + "duracion " + matrizDeZonas[zOrigen][zDestino];

                }
                //return camino;
                ret.resultado = Resultado.OK;
                ret.valorString = camino;
            } else {
                ret.resultado = Resultado.ERROR_3;

            }
        } else {
            ret.resultado = Resultado.ERROR_2;
        }
        return ret;
    }

    @Override
    public Retorno informeZonas() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        NodoListaZona aux = Lz.getInicio();
        while (aux != null) {
            NodoListaMovil aux2 = aux.getLm().getInicio();
            int movilesDisponibles = 0;
            int movilesNoDisponibles = 0;
            while (aux2 != null) {
                if (aux2.isEstado()) {
                    movilesDisponibles++;
                } else {
                    movilesNoDisponibles++;
                }
                aux2 = aux2.getSig();
            }
            System.out.println(aux.getIdZona() + "|" + aux.getDato() + "|MóvilesDisponibles:" + movilesDisponibles + "|MóvilesNoDisponibles:" + movilesNoDisponibles);
            aux = aux.getSig();
        }

        System.out.println();
        ret.resultado = Retorno.Resultado.OK;

        return ret;
    }

    @Override
    public Retorno zonasEnRadio(int zonaID, int duracionViaje
    ) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarChofer(String movilID, String nombre, String cedula) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (Lm.obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema de emergencias";
        } else {
            Lm.obtenerElemento(movilID).getLch().agregarFinal(cedula, nombre);
            ret.resultado = Resultado.OK;
            ret.valorString = "chofer agregado correctamente";
        }
        return ret;
    }

    @Override
    public Retorno eliminarChofer(String movilID, String cedula) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        NodoListaMovil movil = buscarMovilPorChofer(Lm, cedula);

        if (movil == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "El chofer no existe";
        } else {
            movil.getLch().borrarElemento(cedula);
            ret.valorString = "Se elimino el Chofer " + cedula;
            ret.resultado = Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno informeChoferes(String movilID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lm.obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "no existe el movil en el sistema de emergencias";
        } else {

            NodoListaChofer aux = Lm.getInicio().getLch().getInicio();
            String separador = "|";

            while (aux != null) {
                if (aux.getSiguiente() == null) {
                    separador = "";
                }
                System.out.print(aux.getNombre() + ";" + aux.getCedula() + separador);
                aux = aux.getSiguiente();
            }

            System.out.println();
            ret.resultado = Retorno.Resultado.OK;
        }

        return ret;
    }

    @Override
    public Retorno registrarAbonado(int abonadoID, String abonadoNombre,
            String abonadoDireccion, String abonadoTel,
            int zonaID
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lz.obtenerElementoPorId(zonaID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona no existe";
//        } else if (Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaID).getDato()).getLa().obtenerElemento(abonadoID) != null) {
        } else if (buscarZonaPorAbonado(Lz, abonadoID) != null) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "Abonado ya existe en el sistema de emergencias";
        } else {
            Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaID).getDato()).getLa().agregarFinal(abonadoID, abonadoNombre, abonadoDireccion, abonadoTel);
            ret.resultado = Resultado.OK;
            ret.valorString = "Abonado agregado a zona correctamente";
        }
        return ret;
    }

    @Override
    public Retorno eliminarAbonado(int abonadoID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona zona = buscarZonaPorAbonado(Lz, abonadoID);

        if (zona == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "El abonado no existe";
        } else {
            zona.getLa().borrarElemento(abonadoID);
            ret.resultado = Resultado.OK;
            ret.valorString = "Se elimino el Abonado";
        }
        return ret;
    }

    @Override
    public Retorno informeAbonadosZona(int zonaID
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lz.obtenerElementoPorId(zonaID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona no existe";
        } else {
            NodoListaZona aux = Lz.getInicio();
            NodoListaAbonado aux1 = aux.getLa().getInicio();
            int abonadosDisponibles = 0;
            String separador = "|";

            while (aux != null && aux.idZona == zonaID) {
                System.out.print(aux.getIdZona() + ";" + aux.getDato() + "|");
                while (aux1 != null) {
                    if (aux1.getSig() == null) {
                        separador = "";
                    }
                    System.out.print(aux1.getAbonadoID() + separador);
                    if (aux1.isEstado()) {
                        abonadosDisponibles++;
                    }
                    aux1 = aux1.getSig();
                }
                System.out.print("|Total Abonados disponibles: " + abonadosDisponibles);
                aux = aux.getSig();
            }
            System.out.println();
            ret.resultado = Retorno.Resultado.OK;
        }

        mostrarAbonados(Lz);
        return ret;
    }

    @Override
    public Retorno viaje(int zonaOrigen, int zonaDestino, String movil) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (Lz.obtenerElementoPorId(zonaOrigen) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona Origen no existe";
        } else if (Lz.obtenerElementoPorId(zonaDestino) == null) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "La Zona Destino no existe";
        } else if (Lm.obtenerElemento(movil) == null) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "El movil no existe";
        } else {
            NodoListaZona origen = Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaOrigen).getDato());
            NodoListaZona destino = Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaDestino).getDato());
            NodoListaMovil pmovil = origen.getLm().obtenerElemento(movil);
            destino.getLm().setFin(pmovil);
            destino.getLm().getFin().setSig(pmovil);
            NodoListaMovil aux = origen.getLm().getInicio();

            while (aux.getSig() != pmovil) {
                aux = aux.getSig();
            }

            aux.setSig(pmovil.getSig());
            destino.getLm().getFin().setSig(null);
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

}
