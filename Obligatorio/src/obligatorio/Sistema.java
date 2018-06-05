package obligatorio;

import obligatorio.Retorno.Resultado;
import static obligatorio.metodos.*;

public class Sistema implements ISistema {

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
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno cambiarUbicacion(String movilID, int zonaID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno agregarZona(String zonaNombre) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        // if (Lz.getCantelementos()< Lz.getTope() || Lz.getTope() == 0) {
        if (Lz.obtenerElemento(zonaNombre) == null) {
            Lz.agregarFinal(zonaNombre);
            //   }
        } else {
            ret.resultado = Retorno.Resultado.ERROR_1;
            ret.valorString = "La zona ya existe";
        }
        ret.resultado = Retorno.Resultado.OK;
        ret.valorString = "la zona se agregó correctamente";
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
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno movilMasCercano(int zonaID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno rutaMasRapida(int zonaOrigen, int zonaDestino) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno informeZonas() {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno zonasEnRadio(int zonaID, int duracionViaje) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarChofer(String movilID, String nombre, String cedula) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno eliminarChofer(String movilID, String cedula) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno informeChoferes(String movilID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno registrarAbonadol(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel, int zonaID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno eliminarAbonado(int abonadoID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno informeAbonadosZona(int zonaID) {
        return new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

}
