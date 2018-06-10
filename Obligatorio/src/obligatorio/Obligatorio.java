package obligatorio;

import static obligatorio.metodos.*;

public class Obligatorio {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Prueba p = new Prueba();

//        prueba1(s, p);
//        prueba2(s, p);
//        prueba3(s, p);
//        prueba4(s, p);
        prueba5(s, p);
//        prueba6(s, p);
//        ListaZona lz = new ListaZona();
//
//        lz.agregarInicio("Zona 1");
//        lz.getInicio().getLm().agregarOrd("  Movil 3");
//        lz.getInicio().getLm().agregarOrd("  Mavil 1");
//        lz.getInicio().getLm().agregarOrd("  Movil 1");
////        lz.getInicio().getLm().getInicio().getLch().agregarOrd("    Chofer 1");
////        lz.getInicio().getLm().getInicio().getLch().agregarOrd("    Chofer 2");
////        lz.getInicio().getLm().getInicio().getLch().agregarOrd("    Cahofer 2");
//        lz.getInicio().getLm().agregarOrd("  Movil 4");
//        lz.getInicio().getLm().agregarOrd("  Movil 2");
//        lz.agregarInicio("Zona 2");
//        lz.getInicio().getLm().agregarOrd("  Movil 20");
//        lz.getInicio().getLm().agregarOrd("  Movil 21");
//        lz.agregarInicio("Zona 3");
//        lz.getInicio().getLm().agregarOrd("  Movil 31");
//        lz.getInicio().getLm().agregarOrd("  Movil 32");
//
//        agregarMovilAZona(lz, "Zona 2", "  Movil 99");
//        mostrarZonasCompleto(lz);
//        System.out.println("\n-----------------");
//        System.out.println("Muevo Zona");
//        System.out.println("-----------------");
//        viaje(lz, "Zona 1", "Zona 2", "  Movil 1");
//        cambiarUbicacion(lz, "Zona 2", "  Movil 1");
//        mostrarZonasCompleto(lz);

//        System.out.println(buscarZonaPorMovil(lz, "  Movil 99").getDato());//z2
//        System.out.println(buscarZonaPorMovil(lz, "  Movil 32").getDato());//z3
//        System.out.println(buscarZonaPorMovil(lz, "  Movil 4").getDato());//z1
    }

    static void prueba1(Sistema s, Prueba p) {

        p.ver(s.crearSistemaEmergencias(3).resultado, Retorno.Resultado.OK, "Se crea el sistema para 3 zonas");
        p.ver(s.agregarZona("Montevideo").resultado, Retorno.Resultado.OK, "Se agrego Montevideo");
        p.ver(s.agregarZona("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Se intento agregar Montevideo que ya existe");
        p.ver(s.agregarZona("Punta del Este").resultado, Retorno.Resultado.OK, "Se agrego Punta del Este");
        p.ver(s.agregarZona("La Paloma").resultado, Retorno.Resultado.OK, "Se agrego La Paloma");
        p.ver(s.agregarZona("Maldonado").resultado, Retorno.Resultado.ERROR_2, "Se intento agregar Maldonado pero el sistema esta completo");
        p.ver(s.destruirSistemaEmergencias().resultado, Retorno.Resultado.OK, "Se destruye sistema");
        p.imprimirResultadosPrueba();
    }

    static void prueba2(Sistema s, Prueba p) {
        p.imprimirComentario("CREAMOS SISTMA PARA 5 CIUDADES");
        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.imprimirComentario("INGRESAMOS ZONAS");
        p.ver(s.agregarZona("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.agregarZona("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.agregarZona("Lima").resultado, Retorno.Resultado.OK, "Se ingresa Lima");
        p.ver(s.agregarZona("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo");
        p.imprimirComentario("INGRESAMOS CIUDAD REPETIDA");
        p.ver(s.agregarZona("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.ver(s.agregarZona("New York").resultado, Retorno.Resultado.OK, "Se ingresa New York");

        p.imprimirComentario("INTENTAMOS SOBREPASAR EL LIMITE DE CIUDADES");
        p.ver(s.agregarZona("Buenos Aires").resultado, Retorno.Resultado.ERROR_2, "Se sobrepasa el límite de ciudades gestionados por el sistema");

        p.imprimirResultadosPrueba();
    }

    static void prueba3(Sistema s, Prueba p) {
        p.imprimirComentario("CREAMOS SISTMA PARA 5 CIUDADES");
        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.listarZonas().resultado, Retorno.Resultado.OK, "Lista de Zonas vacia");
        p.imprimirComentario("INGRESAMOS ZONAS");
        p.ver(s.agregarZona("Pocitos").resultado, Retorno.Resultado.OK, "Se ingresa Pocitos");
        p.ver(s.agregarZona("Punta Carretas").resultado, Retorno.Resultado.OK, "Se ingresa Punta Carretas");
        p.ver(s.agregarZona("Parque Rodo").resultado, Retorno.Resultado.OK, "Se ingresa Parque Rodo");
        p.ver(s.agregarZona("Buceo").resultado, Retorno.Resultado.OK, "Se ingresa Buceo");
        p.ver(s.agregarZona("Malvin").resultado, Retorno.Resultado.OK, "Se ingresa Malvin");

        p.ver(s.registrarMovil("PCS124", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS124 a Pocitos");
        p.ver(s.registrarMovil("PCS1231", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS1231 a Pocitos ");
        p.ver(s.registrarMovil("PCS123", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS123 a Pocitos ");
        p.ver(s.registrarMovil("PCS123", 1).resultado, Retorno.Resultado.ERROR_2, "Agrego movil PCS123 que ya existe en Pocitos ");
        p.ver(s.registrarMovil("PCS123", 20).resultado, Retorno.Resultado.ERROR_1, "Agrego movil PCS123 a zona que no existe ");
        p.ver(s.listarZonas().resultado, Retorno.Resultado.OK, "Lista de Zonas");
        p.ver(s.deshabilitarMovil("PCS123").resultado, Retorno.Resultado.OK, "Se deshabilita PCS123");
        p.ver(s.deshabilitarMovil("PCS123").resultado, Retorno.Resultado.ERROR_2, "Se deshabilita PCS123 que ya estaba deshabilitado");
        p.ver(s.listarZonas().resultado, Retorno.Resultado.OK, "Lista de Zonas");
        p.ver(s.habilitarMovil("PCS123").resultado, Retorno.Resultado.OK, "se habilita movil PCS123");
        p.ver(s.listarZonas().resultado, Retorno.Resultado.OK, "Lista de Zonas");
        p.ver(s.eliminarMovil("PCS1231").resultado, Retorno.Resultado.OK, "Se elimina mobil PCS1231");
        p.ver(s.listarZonas().resultado, Retorno.Resultado.OK, "Lista de Zonas");
        p.ver(s.deshabilitarMovil("PCS123").resultado, Retorno.Resultado.OK, "Se deshabilita PCS123");
        p.ver(s.buscarMovil("PCS123").resultado, Retorno.Resultado.OK, "Muestro datos del movil PCS123");
        p.ver(s.buscarMovil("PCS1237").resultado, Retorno.Resultado.ERROR_1, "No obtengo ningun dato");
        p.ver(s.informeMovil().resultado, Retorno.Resultado.OK, "Lista de Móviles");
        p.imprimirResultadosPrueba();
    }

    static void prueba4(Sistema s, Prueba p) {
        p.imprimirComentario("CREAMOS SISTMA PARA 5 ZONAS");
        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");

        p.imprimirComentario("INGRESAMOS ZONAS");

        p.ver(s.agregarZona("Pocitos").resultado, Retorno.Resultado.OK, "Se ingresa Pocitos");
        p.ver(s.agregarZona("Punta Carretas").resultado, Retorno.Resultado.OK, "Se ingresa Punta Carretas");
        p.ver(s.agregarZona("Parque Rodo").resultado, Retorno.Resultado.OK, "Se ingresa Parque Rodo");
        p.ver(s.agregarZona("Buceo").resultado, Retorno.Resultado.OK, "Se ingresa Buceo");
        p.ver(s.agregarZona("Malvin").resultado, Retorno.Resultado.OK, "Se ingresa Malvin");

        p.ver(s.registrarMovil("PCS123", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS123 a Pocitos ");
        p.ver(s.registrarMovil("PCS123", 1).resultado, Retorno.Resultado.ERROR_2, "Agrego movil PCS123 que ya existe en Pocitos ");
        p.ver(s.registrarMovil("PCS123", 20).resultado, Retorno.Resultado.ERROR_1, "Agrego movil PCS123 a zona que no existe ");
        p.ver(s.registrarMovil("PCS124", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS124 a Pocitos ");
        p.ver(s.registrarMovil("PCS1245", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS1245 a Pocitos ");
        p.ver(s.deshabilitarMovil("PCS1245").resultado, Retorno.Resultado.OK, "Se deshabilita PCS1245");

        p.ver(s.informeMovil().resultado, Retorno.Resultado.OK, "Listado de moviles");

        p.ver(s.deshabilitarMovil("PCS123").resultado, Retorno.Resultado.OK, "Se deshabilita PCS123");
        p.ver(s.deshabilitarMovil("PCS123").resultado, Retorno.Resultado.ERROR_2, "Se deshabilita PCS123 que ya estaba deshabilitado");
        p.ver(s.habilitarMovil("PCS123").resultado, Retorno.Resultado.OK, "se habilita movil PCS123");
        p.ver(s.eliminarMovil("PCS123").resultado, Retorno.Resultado.OK, "Se elimina mobil PCS123");

        p.ver(s.informeMovil().resultado, Retorno.Resultado.OK, "Listado de moviles - se elimino PCS123 ");

        p.ver(s.buscarMovil("PCS124").resultado, Retorno.Resultado.OK, "Se busca el movil PCS124 que existe");
        p.ver(s.buscarMovil("PCS123").resultado, Retorno.Resultado.ERROR_1, "Se busca el movil PCS123 que NO existe");
        p.ver(s.buscarMovil("PCS999").resultado, Retorno.Resultado.ERROR_1, "Se busca el movil PCS99 que NO existe");

        p.ver(s.registrarMovil("PCS444", 4).resultado, Retorno.Resultado.OK, "Agrego movil BCO444 a Buceo ");
        p.ver(s.registrarMovil("PCS445", 4).resultado, Retorno.Resultado.OK, "Agrego movil BCO123  en Buceo ");

        p.ver(s.informeMovil(1).resultado, Retorno.Resultado.OK, "Moviles de Pocitos");
        p.ver(s.informeMovil(4).resultado, Retorno.Resultado.OK, "Moviles de Buceo");
        p.ver(s.informeMovil(40).resultado, Retorno.Resultado.ERROR_1, "No existe Zona");
        p.ver(s.informeZonas().resultado, Retorno.Resultado.OK, "Muestra el listado de Zonas");

        p.imprimirResultadosPrueba();
    }

    static void prueba5(Sistema s, Prueba p) {
        p.imprimirComentario("CREAMOS SISTMA PARA 5 ZONAS");
        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");

        p.imprimirComentario("INGRESAMOS ZONAS");

        p.ver(s.agregarZona("Pocitos").resultado, Retorno.Resultado.OK, "Se ingresa Pocitos");
        p.ver(s.agregarZona("Punta Carretas").resultado, Retorno.Resultado.OK, "Se ingresa Punta Carretas");
        p.ver(s.agregarZona("Parque Rodo").resultado, Retorno.Resultado.OK, "Se ingresa Parque Rodo");
        p.ver(s.agregarZona("Buceo").resultado, Retorno.Resultado.OK, "Se ingresa Buceo");
        p.ver(s.agregarZona("Malvin").resultado, Retorno.Resultado.OK, "Se ingresa Malvin");

        p.ver(s.registrarMovil("PCS123", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS123 a Pocitos ");
        p.ver(s.registrarMovil("PCS124", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS124 a Pocitos ");
        p.ver(s.registrarMovil("PCS123", 1).resultado, Retorno.Resultado.ERROR_2, "Agrego movil PCS123 que ya existe en Pocitos ");
        p.ver(s.registrarMovil("PCS123", 20).resultado, Retorno.Resultado.ERROR_1, "Agrego movil PCS123 a zona que no existe ");

        p.ver(s.informeMovil().resultado, Retorno.Resultado.OK, "Listado de moviles");

        p.ver(s.deshabilitarMovil("PCS123").resultado, Retorno.Resultado.OK, "Se deshabilita PCS123");
        p.ver(s.deshabilitarMovil("PCS123").resultado, Retorno.Resultado.ERROR_2, "Se deshabilita PCS123 que ya estaba deshabilitado");
        p.ver(s.habilitarMovil("PCS123").resultado, Retorno.Resultado.OK, "se habilita movil PCS123");
        p.ver(s.eliminarMovil("PCS123").resultado, Retorno.Resultado.OK, "Se elimina mobil PCS123");

        p.ver(s.informeMovil().resultado, Retorno.Resultado.OK, "Listado de moviles - se elimino PCS123 ");

        p.ver(s.buscarMovil("PCS123").resultado, Retorno.Resultado.ERROR_1, "Se busca el movil PCS123 que no existe");
        p.ver(s.buscarMovil("PCS124").resultado, Retorno.Resultado.OK, "Se busca el movil PCS124 que existe");
        p.ver(s.buscarMovil("PCS999").resultado, Retorno.Resultado.ERROR_1, "Se busca el movil PCS99 que NO existe");

        p.ver(s.registrarMovil("PCS444", 4).resultado, Retorno.Resultado.OK, "Agrego movil BCO444 a Buceo ");
        p.ver(s.registrarMovil("PCS445", 4).resultado, Retorno.Resultado.OK, "Agrego movil BCO123  en Buceo ");

        p.ver(s.informeMovil(1).resultado, Retorno.Resultado.OK, "Moviles de Pocitos");
        p.ver(s.informeMovil(4).resultado, Retorno.Resultado.OK, "Moviles de Buceo");
        p.ver(s.informeMovil().resultado, Retorno.Resultado.OK, "Listado de moviles ");

        p.imprimirComentario("Agrego abonados");

        p.ver(s.registrarAbonadol(1, "Juan", " Mercedes 1455", "0991234", 1).resultado, Retorno.Resultado.OK, "Se agrega Juan");
        p.ver(s.registrarAbonadol(2, "Pedro", " Mercedes 1455", "0991234", 1).resultado, Retorno.Resultado.OK, "Se agrega Pedro");
        p.ver(s.registrarAbonadol(3, "Ana", " Mercedes 1455", "0991234", 1).resultado, Retorno.Resultado.OK, "Se agrega Ana");
        p.ver(s.registrarAbonadol(4, "Maria", " Mercedes 1455", "0991234", 1).resultado, Retorno.Resultado.OK, "Se agrega Maria");
        p.ver(s.registrarAbonadol(1, "Pablo", " Libertador 1455", "0991114", 10).resultado, Retorno.Resultado.ERROR_1, "No se encuentra zona 10");
        p.ver(s.registrarAbonadol(1, "Juan", " Mercedes 1455", "0991234", 1).resultado, Retorno.Resultado.ERROR_2, "Se agrega Juan que ya existe");

        p.ver(s.informeAbonadosZona(1).resultado, Retorno.Resultado.OK, "abonados de zona 1");

        p.ver(s.eliminarAbonado(5).resultado, Retorno.Resultado.ERROR_1, "El abonado 5 no existe en el sistema");
        p.ver(s.eliminarAbonado(2).resultado, Retorno.Resultado.OK, "Se elimina a Juan");

        p.ver(s.informeAbonadosZona(1).resultado, Retorno.Resultado.OK, "abonados de zona 1 - 2");
//        p.imprimirResultadosPrueba();
        //p.ver(s.cambiarUbicacion("PCS1245", 2).resultado, Retorno.Resultado.OK, "Cambia");
    }

    static void prueba6(Sistema s, Prueba p) {
        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");

        p.ver(s.agregarZona("Pocitos").resultado, Retorno.Resultado.OK, "Se ingresa Pocitos");

        p.ver(s.registrarMovil("PCS444", 1).resultado, Retorno.Resultado.OK, "Agrego movil BCO444 a Buceo ");
        p.ver(s.registrarChofer("PCS444", "Maria", "1455").resultado, Retorno.Resultado.OK, "Se agrega Maria");
        p.ver(s.registrarChofer("PCS444", "Maria2", "1185").resultado, Retorno.Resultado.OK, "Se agrega Maria");
        p.ver(s.informeChoferes("PCS444").resultado, Retorno.Resultado.OK, "Informe de choferes para el movil PCS444");
        p.ver(s.eliminarChofer("PCS444", "1185").resultado, Retorno.Resultado.OK, "Se elimina el puto chofer");
        p.ver(s.informeChoferes("PCS444").resultado, Retorno.Resultado.OK, "Informe de choferes para el movil PCS444");

        p.imprimirResultadosPrueba();
    }
}
