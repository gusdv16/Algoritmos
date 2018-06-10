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
        if (cantzonas < 0) {
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
        return ret;
    }

    @Override
    public Retorno registrarMovil(String movilID, int zonaID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lz.obtenerElementoPorId(zonaID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona no existe";
        } else if (Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaID).getDato()).getLm().obtenerElemento(movilID) != null) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "Móvil ya existe en el sistema de emergencias";
        } else {
            Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaID).getDato()).getLm().agregarOrd(movilID);
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
            NodoListaMovil aux1 = aux.getLm().getInicio();
            int movilesDisponibles = 0;
            String separador = ";";

            while (aux != null && aux.idZona == zonaID) {
                while (aux1 != null) {
                    if (aux1.getSig() == null) {
                        separador = "";
                    }
                    System.out.print(aux1.getDato() + separador);
                    if (aux1.isEstado()) {
                        movilesDisponibles++;
                    }
                    aux1 = aux1.getSig();
                }
                System.out.print("|Total Móviles disponibles: " + movilesDisponibles);
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
        String zona = Lz.obtenerElementoPorId(zonaID).getDato().toString();
        cambiarUbicacionZona(Lz, zona, movilID);

        return ret;
    }

    @Override
    public Retorno agregarZona(String zonaNombre) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (cantZonas <= Lz.cantElementos()) {
            Lz.agregarFinal(zonaNombre);
            ret.resultado = Retorno.Resultado.ERROR_2;
            ret.valorString = "Se paso la cantidad de zonas del sistema";
        } else {
            //se tiene que controlar el id
            if (Lz.obtenerElemento(zonaNombre) == null) {
                Lz.agregarFinal(zonaNombre);
                ret.resultado = Retorno.Resultado.OK;
                ret.valorString = "la zona se agregó correctamente";
            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
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
            aux.getLm().mostrar();
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
    public Retorno modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje
    ) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno movilMasCercano(int zonaID) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        int largo = matrizDeZonas.length;
        int minimo = matrizDeZonas[zonaID][0];
        for (int i = 0; i < largo; i++) {
            if (matrizDeZonas[zonaID][i] != 0 && matrizDeZonas[zonaID][i] < minimo) {
                minimo = matrizDeZonas[zonaID][i];
            }
        }

        ret.resultado = Retorno.Resultado.OK;
        ret.valorString = "Se agrego la ruta.";

        return ret;
    }
// pre: ninguna distancia puede ser 0

    @Override
    public Retorno rutaMasRapida(int zonaOrigen, int zonaDestino) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona orgigen = Lz.obtenerElementoPorId(zonaOrigen);
        NodoListaZona destino = Lz.obtenerElementoPorId(zonaDestino);
        
        if (orgigen != null) {
            if (destino != null) {

                int columnas = matrizDeZonas[0].length;
                int duracion = Integer.MAX_VALUE;
                String escala = "";
                String camino = "";
                int escalaNum = 0;
                
                for (int i = 0; i < columnas; i++) {
                    if (matrizDeZonas[zonaOrigen][i] != 0 && matrizDeZonas[zonaDestino][i] != 0 && matrizDeZonas[zonaOrigen][i] + matrizDeZonas[zonaDestino][i] < duracion) {
                        duracion = matrizDeZonas[zonaOrigen][i] + matrizDeZonas[zonaDestino][i];
                        escalaNum = i-1;
                    }

                }
                escala = Lz.BuscarZonaDadaPos(Lz.cantElementos() - escalaNum);
                camino = "ir de " + zonaOrigen + " ; " + zonaDestino + " escala en " + escala + " duracion " + duracion;

                System.out.println(camino);
                if (matrizDeZonas[zonaOrigen][zonaDestino] != 0 && matrizDeZonas[zonaOrigen][zonaDestino] > 0) {
                    camino = "camino directo " + zonaOrigen + " ; " + zonaDestino + "duracion " + matrizDeZonas[zonaOrigen][zonaDestino];

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
        NodoListaMovil aux2 = aux.getLm().getInicio();
        while (aux != null) {
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
    public Retorno registrarChofer(String movilID, String nombre,
            String cedula
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (Lm.obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema de emergencias";
        } else {
            Lm.obtenerElemento(movilID).getLch().encolar(cedula, nombre);
            ret.resultado = Resultado.OK;
            ret.valorString = "chofer agregado correctamente";
        }
        return ret;
    }

    @Override
    public Retorno eliminarChofer(String movilID, String cedula
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        if (Lm.obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "Móvil no existe en el sistema";
        } else {
            Lm.obtenerElemento(movilID).getLch().desencolar(cedula);
            ret.resultado = Resultado.OK;
            ret.valorString = "Chofer eliminado";
        }

        return ret;
    }

    @Override
    public Retorno informeChoferes(String movilID
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lm.obtenerElemento(movilID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "no existe el movil en el sistema de emergencias";
        } else {

            NodoListaChofer aux = Lm.getInicio().getLch().getPrimero();
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
    public Retorno registrarAbonadol(int abonadoID, String abonadoNombre,
            String abonadoDireccion, String abonadoTel,
            int zonaID
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        if (Lz.obtenerElementoPorId(zonaID) == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La Zona no existe";
        } else if (Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaID).getDato()).getLa().obtenerElemento(abonadoID) != null) {
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "Abonado ya existe en el sistema de emergencias";
        } else {
            Lz.obtenerElemento(Lz.obtenerElementoPorId(zonaID).getDato()).getLa().encolar(abonadoID, abonadoNombre, abonadoDireccion, abonadoTel);
            ret.resultado = Resultado.OK;
            ret.valorString = "Abonado agregado a zona correctamente";
        }
        return ret;
    }

    @Override
    public Retorno eliminarAbonado(int abonadoID
    ) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        NodoListaZona zona = buscarZonaPorAbonado(Lz, abonadoID);

        if (zona == null) {
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "El abonado no existe";
        } else {
            NodoListaAbonado aux = zona.getLa().getInicio();
            while (aux.getSig().getSig() != null && aux.getAbonadoID() != abonadoID) {
                aux = aux.getSig();
            }
            if (aux.getSig() != null) {
                aux.setSig(aux.getSig().getSig());
                ret.resultado = Resultado.OK;
                ret.valorString = "Se elimino el Abonado";
            }
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

}
