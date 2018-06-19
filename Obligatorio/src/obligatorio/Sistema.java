package obligatorio;

import obligatorio.Retorno.Resultado;
import static obligatorio.metodos.*;

public class Sistema implements ISistema {

    public int cantZonas;
    public ListaZona Lz;
    int[][] matrizDeZonas;
    public ListaMovil Lm;

    //pre:
    //post: damos de alta el sistema
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

//pre:
    //post:damos de baja el sistema, limpiamos las listas y enviamos el mensaje de que fue correcta su destruccion
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

//pre:
    //post: agregamos un movil a las listas LM y LZ
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

//pre:
    //post: Ponemos en Estado = false al movil
    @Override
    public Retorno deshabilitarMovil(String movilID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona zona = buscarZonaPorMovil(Lz, movilID);

        if (Lm.obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema";
        } else if (zona.getLm().obtenerElemento(movilID).isEstado() == false) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "Móvil ya esta en estado NO_DISPONIBLE";
        } else if (zona.getLm().obtenerElemento(movilID).getViaje() > 0) {
            ret.resultado = Resultado.ERROR_3;
            ret.valorString = "El Móvil esta asignado a un viaje";
        } else {
            zona.getLm().obtenerElemento(movilID).setEstado(false);
            ret.resultado = Resultado.OK;
            ret.valorString = "Móvil Desabilitado";
        }

        return ret;
    }

//pre:
    //post: ponemos en estado=true a los moviles si no estan disponibles
    @Override
    public Retorno habilitarMovil(String movilID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona zona = buscarZonaPorMovil(Lz, movilID);

        if (Lm.obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema";
        } else if (zona.getLm().obtenerElemento(movilID).isEstado() == true) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "Móvil ya esta en estado DISPONIBLE";
        } else if (zona.getLm().obtenerElemento(movilID).getViaje() > 0) {
            //NUNCA LLEGA A ESTE ERROR PORQUE NO PUEDE ESTAR DE VIAJE SI ESTA DESHABILITADO
            ret.resultado = Resultado.ERROR_3;
            ret.valorString = "El Móvil esta asignado a un viaje";
        } else {
            zona.getLm().obtenerElemento(movilID).setEstado(true);
            ret.resultado = Resultado.OK;
            ret.valorString = "Móvil Habilitado";
        }

        return ret;
    }

    //pre:
    //post: quitamos de la lista el movil
    @Override
    public Retorno eliminarMovil(String movilID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        //NodoListaZona zona = buscarZonaPorMovil(Lz, movilID);

        if (Lm.obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema";
        } else {
            borrarMovil(Lz, movilID);
            Lm.borrarElemento(movilID);
            ret.resultado = Resultado.OK;
            ret.valorString = "Móvil Eliminado";
        }

        return ret;
    }

    //pre:
    //post: te devuelve en pantalla los datos del movil que le pasas como parametro
    @Override
    public Retorno buscarMovil(String movilID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona zona = buscarZonaPorMovil(Lz, movilID);

        if (zona == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema";
        } else {
            NodoListaMovil movil = zona.getLm().obtenerElemento(movilID);
            System.out.println(movil.getDato() + "|Estado: " + movil.isEstado() + "|Zona: " + zona.getDato() + "|#Emergencias: " + movil.getEmergencias());

            System.out.println();
            ret.resultado = Retorno.Resultado.OK;
        }

        return ret;
    }

//pre:
    //post:se devuelve en pantalla los datos todos los moviles existentes 
    @Override
    public Retorno informeMovil() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona aux = Lz.getInicio();
        int cont = 0;

        while (aux != null) {
            NodoListaMovil aux1 = aux.getLm().getInicio();
            while (aux1 != null) {
                String separador = "";
                cont++;
                if (cont > 1) {
                    separador = ";";
                }
                String estado = "DISPONIBLE";
                if (!aux1.isEstado()) {
                    estado = "NO DISPONIBLE";
                }
                System.out.print(separador + aux1.getDato() + ";" + estado);
                aux1 = aux1.getSig();
            }
            if (cont > 0) {
                System.out.print(";" + aux.getDato());
                System.out.print("|");
            }
            cont = 0;
            aux = aux.getSig();
        }

        System.out.println();
        ret.resultado = Retorno.Resultado.OK;

        return ret;
    }

//pre:
    //post: devuelve en pantalla los moviles que se encuentran disponibles en la zona que se le pasa por parametro y cantidad de disponibles que tiene
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
            listaMovilesOrigen.borrarElemento(movilID);
            listaMovilesDestino.agregarFinal(movilID);
            Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaID).getDato()).getLm().obtenerElemento(movilID).setViaje(0);
            
            ret.resultado = Resultado.OK;
            ret.valorString = "Se cambio de zona";
        }

        return ret;
    }

//pre:
    //post:se crea una zona en el sistema
    @Override
    public Retorno agregarZona(String zonaNombre) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (cantZonas <= Lz.cantElementos()) {
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

//pre:
    //post: se muestra en pantalla las zonas que existen. estan ordenadas por id ascendentemente 
    @Override
    public Retorno listarZonas() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona aux = Lz.getInicio();
        int cont = 0;
        String separador = "";

        while (aux != null) {
            if (cont > 0) {
                separador = "|";
            }
            System.out.print(separador + aux.getIdZona() + ";" + aux.getDato() + "\n");

            aux = aux.getSig();
            cont++;
        }
        System.out.println();
        ret.resultado = Retorno.Resultado.OK;

        return ret;
    }

//pre:
    //post:se agrega una Ruta de viaje 
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

//pre:
    //post: cambia los valores de la ruta del viaje
    @Override
    public Retorno modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje) {
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
        return ret;
    }

    //pre:
    //post:muestra en pantalla el movil mas cercano a zona que le pasas por parametro y el tiempo de demora 
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

//pre:
    //post:se le pasa dos zonas por parametro y te devuleve en pantalla la ruta mas rapida o sea la de menor duracion
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

//pre:
    //post:muestra en pantalla todas las zonas detalladamente
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

            String separador = "";
            String rutas = "";
            int cont = 0;
            for (int j = 0; j < matrizDeZonas[aux.getIdZona() - 1].length; j++) {
                if (matrizDeZonas[aux.getIdZona() - 1][j] > 0) {
                    if (cont > 0) {
                        separador = "|";
                    }
                    cont++;
                    rutas += separador + (j + 1) + ";" + matrizDeZonas[aux.getIdZona() - 1][j];
                }
            }

            System.out.println(aux.getIdZona() + "|" + rutas + "|MóvilesDisponibles:" + movilesDisponibles + "|MóvilesNoDisponibles:" + movilesNoDisponibles);
            aux = aux.getSig();
        }

        System.out.println();
        ret.resultado = Retorno.Resultado.OK;

        return ret;
    }

    //pre:
    //pos: devuelve en pantalla un listado con las zonas y su duracion de viaje en el rango que le pasas de duracion de viaje como parametro
    @Override
    public Retorno zonasEnRadio(int zonaID, int duracionViaje) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lz.obtenerElementoPorId(zonaID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona no existe";
        } else {
            if (duracionViaje <= 0) {
                ret.resultado = Resultado.ERROR_2;
                ret.valorString = "La duracion del viaje es menor o igual a 0";
            } else {
                String aux = "";
                int cont = 0;
                for (int j = 0; j < matrizDeZonas[zonaID - 1].length; j++) {
                    if (matrizDeZonas[zonaID - 1][j] > 0 && matrizDeZonas[zonaID - 1][j] <= duracionViaje) {
                        cont++;
                        if (cont > 1) {
                            aux = "|";
                        }
                        System.out.print(aux + (j + 1) + ";" + matrizDeZonas[zonaID - 1][j]);
                    }
                }
                ret.resultado = Resultado.OK;
            }
        }
        return ret;
    }

    //pre:
    //post: se da de alta un chofer en el sistema al cual se le asigna un movil
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

//pre:
    //post:se elimina el chofer cuya cedula es la que le pasas del movil que se le pasa como parametro
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

//pre: los moviles tienen choferes asignados si o si
    //post:devuelve en pantalla los datos del chofer para el movil que le pasamos como parametro. si hay moviles sin chofer muestra " "
//    no es la idea de la realidad por eso la pre
    @Override
    public Retorno informeChoferes(String movilID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lm.obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "No existe el movil en el sistema de emergencias";
        } else {
            NodoListaChofer aux = Lm.obtenerElemento(movilID).getLch().getInicio();
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

//pre:
    //post:se da de alta el abonado para una determinada zona que le pasas por parametro
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

//pre:
    //post: se elimina el abonado que se indico por parametro
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

    //pre:no existe un abonado en mas de una zona
    //post:muestra en pantalla todos los abonados existentes en la zona que se le pasa por parametro. si hay una zona que no hay abonados muuestra ""
    @Override
    public Retorno informeAbonadosZona(int zonaID
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lz.obtenerElementoPorId(zonaID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona no existe";
        } else {
            NodoListaZona aux = Lz.getInicio();
            int abonadosDisponibles = 0;
            String separador = "|";

            while (aux != null) {
                if (aux.idZona == zonaID) {
                    NodoListaAbonado aux1 = aux.getLa().getInicio();
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
                }
                aux = aux.getSig();
            }
            System.out.println();
            ret.resultado = Retorno.Resultado.OK;
        }

        //mostrarAbonados(Lz);
        return ret;
    }

    @Override
    public Retorno viaje(int zonaDestino) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (Lz.obtenerElementoPorId(zonaDestino) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona Destino no existe";
        } else {
            NodoListaZona destino = Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaDestino).getDato());
            NodoListaMovil aux = destino.getLm().getInicio();

            while (aux.getSig() != null && !aux.isEstado() || aux.getViaje() > 0) {
                aux = aux.getSig();
            }

            if (aux.getSig() != null) {
                aux.setViaje(zonaDestino);
                aux.setEmergencias(aux.getEmergencias() + 1);
            }

            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Se agrego el movil a un viaje";
        }
        return ret;
    }

    @Override
    public Retorno mostrarmapa() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        ret.resultado = Retorno.Resultado.OK;
        int filas = matrizDeZonas.length;
        int columnas = matrizDeZonas[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matrizDeZonas[i][j] + " - ");
            }
            System.out.println();
        }
        return ret;
    }
}
