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
//        prueba5(s, p);
//        prueba6(s, p);
        prueba7(s, p);
//        prueba8(s, p);
//        prueba9(s, p);
//        pruebax(s, p);
//        prueba10(s, p);
    }

    static void prueba1(Sistema s, Prueba p) {

        p.ver(s.crearSistemaEmergencias(3).resultado, Retorno.Resultado.OK, "Se crea el sistema para 3 zonas");
        p.ver(s.agregarZona("Montevideo").resultado, Retorno.Resultado.OK, "Se agrego Montevideo");
        p.ver(s.agregarZona("Montevideo").resultado, Retorno.Resultado.ERROR_2, "Se intento agregar Montevideo que ya existe");
        p.ver(s.agregarZona("Punta del Este").resultado, Retorno.Resultado.OK, "Se agrego Punta del Este");
        p.ver(s.agregarZona("La Paloma").resultado, Retorno.Resultado.OK, "Se agrego La Paloma");
        p.ver(s.agregarZona("Maldonado").resultado, Retorno.Resultado.ERROR_1, "Se intento agregar Maldonado pero el sistema esta completo");

        p.ver(s.listarZonas().resultado, Retorno.Resultado.OK, "listo las zonas");
        p.ver(s.informeZonas().resultado, Retorno.Resultado.OK, "mostramos zonas");
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
        p.ver(s.agregarZona("Montevideo").resultado, Retorno.Resultado.ERROR_2, "Montevideo ya existe");
        p.ver(s.agregarZona("New York").resultado, Retorno.Resultado.OK, "Se ingresa New York");

        p.imprimirComentario("INTENTAMOS SOBREPASAR EL LIMITE DE CIUDADES");
        p.ver(s.agregarZona("Buenos Aires").resultado, Retorno.Resultado.ERROR_1, "Se sobrepasa el límite de ciudades gestionados por el sistema");

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
        p.ver(s.eliminarMovil("PCS123").resultado, Retorno.Resultado.OK, "Se elimina movil PCS123");

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

        p.ver(s.registrarAbonado(1, "Juan", " Mercedes 1455", "0991234", 1).resultado, Retorno.Resultado.OK, "Se agrega Juan");
        p.ver(s.registrarAbonado(2, "Pedro", " Mercedes 1455", "0991234", 1).resultado, Retorno.Resultado.OK, "Se agrega Pedro");
        p.ver(s.registrarAbonado(3, "Ana", " Mercedes 1455", "0991234", 1).resultado, Retorno.Resultado.OK, "Se agrega Ana");
        p.ver(s.registrarAbonado(4, "Maria", " Mercedes 1455", "0991234", 1).resultado, Retorno.Resultado.OK, "Se agrega Maria");
        p.ver(s.registrarAbonado(1, "Pablo", " Libertador 1455", "0991114", 10).resultado, Retorno.Resultado.ERROR_1, "No se encuentra zona 10");
        p.ver(s.registrarAbonado(1, "Juan", " Mercedes 1455", "0991234", 1).resultado, Retorno.Resultado.ERROR_2, "Se agrega Juan que ya existe");

        p.ver(s.informeAbonadosZona(1).resultado, Retorno.Resultado.OK, "abonados de zona 1");

        p.ver(s.eliminarAbonado(5).resultado, Retorno.Resultado.ERROR_1, "El abonado 5 no existe en el sistema");
        p.ver(s.eliminarAbonado(1).resultado, Retorno.Resultado.OK, "Se elimina a Juan");

        p.ver(s.informeAbonadosZona(1).resultado, Retorno.Resultado.OK, "abonados de zona 1 - 2");
        p.imprimirResultadosPrueba();
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

    static void prueba7(Sistema s, Prueba p) {
        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");

        p.ver(s.agregarZona("Pocitos").resultado, Retorno.Resultado.OK, "Se ingresa Pocitos");
        p.ver(s.agregarZona("Punta Carretas").resultado, Retorno.Resultado.OK, "Se ingresa Punta Carretas");
        p.ver(s.agregarZona("Parque Rodo").resultado, Retorno.Resultado.OK, "Se ingresa Parque Rodo");
        p.ver(s.agregarZona("Buceo").resultado, Retorno.Resultado.OK, "Se ingresa Buceo");
        p.ver(s.agregarZona("Malvin").resultado, Retorno.Resultado.OK, "Se ingresa Malvin");

        p.ver(s.registrarMovil("PCS123", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS123 a Pocitos");
        p.ver(s.deshabilitarMovil("PCS123").resultado, Retorno.Resultado.OK, "Se deshabilita PCS123");
        p.ver(s.registrarMovil("PCS124", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS124 a Pocitos");
        p.ver(s.deshabilitarMovil("PCS124").resultado, Retorno.Resultado.OK, "Se deshabilita PCS123");
        p.ver(s.registrarMovil("PCS125", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS125 a Pocitos");
        p.ver(s.deshabilitarMovil("PCS125").resultado, Retorno.Resultado.OK, "Se deshabilita PCS123");
        p.ver(s.registrarMovil("PCS520", 5).resultado, Retorno.Resultado.OK, "Agrego movil PCS520 a Malvin");
        p.ver(s.deshabilitarMovil("PCS520").resultado, Retorno.Resultado.OK, "Se deshabilita PCS123");
        p.ver(s.registrarMovil("PCS521", 5).resultado, Retorno.Resultado.OK, "Agrego movil PCS521 a Malvin");

        p.ver(s.agregarRuta(1, 2, 10).resultado, Retorno.Resultado.OK, "Se crea la ruta Pocitos a Punta Carretas");
        p.ver(s.agregarRuta(1, 3, 15).resultado, Retorno.Resultado.OK, "Se crea la ruta Pocitos a Parque Rodo");
        p.ver(s.agregarRuta(2, 4, 8).resultado, Retorno.Resultado.OK, "Se crea la ruta Punta Carretas a Buceo");
        p.ver(s.agregarRuta(3, 4, 7).resultado, Retorno.Resultado.OK, "Se crea la ruta Parque Rodo a Buceo");
        p.ver(s.agregarRuta(1, 5, 4).resultado, Retorno.Resultado.OK, "Se crea la ruta Pocitos a Malvin");

        p.ver(s.agregarRuta(6, 4, 100).resultado, Retorno.Resultado.ERROR_1, "La zona Origen no existe");
        p.ver(s.agregarRuta(1, 6, 100).resultado, Retorno.Resultado.ERROR_2, "La zona Destino no existe");
        p.ver(s.agregarRuta(1, 2, 0).resultado, Retorno.Resultado.ERROR_3, "Los minutos son menos de 1");

//        p.ver(s.modificarDemora(1, 2, 18).resultado, Retorno.Resultado.OK, "Se crea la ruta Pocitos a Punta Carretas");

        p.ver(s.movilMasCercano(1).resultado, Retorno.Resultado.OK, "Movil mas cercano");
        p.ver(s.zonasEnRadio(1, 11).resultado, Retorno.Resultado.OK, "yo que se");
        p.imprimirResultadosPrueba();
    }

    static void prueba8(Sistema s, Prueba p) {
        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");

        p.ver(s.agregarZona("Pocitos").resultado, Retorno.Resultado.OK, "Se ingresa Pocitos");

        p.ver(s.registrarMovil("PCS444", 1).resultado, Retorno.Resultado.OK, "Agrego movil BCO444 a Buceo ");
        p.ver(s.registrarChofer("PCS444", "Maria", "1455").resultado, Retorno.Resultado.OK, "Se agrega Maria");
        p.ver(s.registrarChofer("PCS444", "Maria2", "1185").resultado, Retorno.Resultado.OK, "Se agrega Maria2");
        p.ver(s.registrarChofer("PCS444", "Maria3", "007").resultado, Retorno.Resultado.OK, "Se agrega Maria2");
        p.ver(s.informeChoferes("PCS444").resultado, Retorno.Resultado.OK, "Informe de choferes para el movil PCS444");
        p.ver(s.eliminarChofer("PCS444", "1185").resultado, Retorno.Resultado.OK, "Se elimina el puto chofer");
        p.ver(s.informeChoferes("PCS444").resultado, Retorno.Resultado.OK, "Informe de choferes para el movil PCS444");

        p.imprimirResultadosPrueba();

    }

    static void prueba9(Sistema s, Prueba p) {
        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");

        p.ver(s.agregarZona("Pocitos").resultado, Retorno.Resultado.OK, "Se ingresa Pocitos");
        p.ver(s.agregarZona("Punta Carretas").resultado, Retorno.Resultado.OK, "Se ingresa Punta Carretas");
        p.ver(s.agregarZona("Parque Rodo").resultado, Retorno.Resultado.OK, "Se ingresa Parque Rodo");
        p.ver(s.agregarZona("Buceo").resultado, Retorno.Resultado.OK, "Se ingresa Buceo");
        p.ver(s.agregarZona("Malvin").resultado, Retorno.Resultado.OK, "Se ingresa Malvin");

        p.ver(s.registrarMovil("PCS123", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS123 a Pocitos");

        p.ver(s.registrarMovil("PCS124", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS124 a Pocitos");

        p.ver(s.registrarMovil("PCS125", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS125 a Pocitos");

        p.ver(s.registrarMovil("PCS520", 5).resultado, Retorno.Resultado.OK, "Agrego movil PCS520 a Malvin");

        p.ver(s.registrarMovil("PCS521", 5).resultado, Retorno.Resultado.OK, "Agrego movil PCS521 a Malvin");
        p.ver(s.registrarMovil("PCSPrueba", 4).resultado, Retorno.Resultado.OK, "Agrego movil PCS520 a buceo");

//        p.ver(s.cambiarUbicacion("PCS521", 2).resultado, Retorno.Resultado.OK, "CAMBIO LA UBICACION DEL AUTO A PUNTA CARRETAS");
        p.ver(s.informeMovil().resultado, Retorno.Resultado.OK, "muestro el informe movil");
        p.ver(s.informeZonas().resultado, Retorno.Resultado.OK, "muestro el informe zonas");
        p.imprimirResultadosPrueba();
    }

    static void pruebax(Sistema s, Prueba p) {
        p.imprimirComentario("CREAMOS SISTEMA PARA 0 CIUDADES");
        p.ver(s.crearSistemaEmergencias(0).resultado, Retorno.Resultado.ERROR_1, "Se crea el sistema de reservas para cero zonas");

        p.imprimirComentario("CREAMOS SISTEMA PARA 7 CIUDADES");
        p.ver(s.crearSistemaEmergencias(7).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");

        p.imprimirComentario("INGRESAMOS ZONAS");
        p.ver(s.agregarZona("Pocitos").resultado, Retorno.Resultado.OK, "Se ingresa Pocitos");
        p.ver(s.agregarZona("Punta Carretas").resultado, Retorno.Resultado.OK, "Se ingresa Punta Carretas");

        p.ver(s.agregarZona("Punta Carretas").resultado, Retorno.Resultado.ERROR_2, "Se ingresa Punta Carretas que ya existe");

        p.ver(s.agregarZona("Parque Rodo").resultado, Retorno.Resultado.OK, "Se ingresa Parque Rodo");
        p.ver(s.agregarZona("Buceo").resultado, Retorno.Resultado.OK, "Se ingresa Buceo");
        p.ver(s.agregarZona("Malvin").resultado, Retorno.Resultado.OK, "Se ingresa Malvin");
        p.ver(s.agregarZona("Colon").resultado, Retorno.Resultado.OK, "Se ingresa Colon");
        p.ver(s.agregarZona("Centro").resultado, Retorno.Resultado.OK, "Se ingresa Centro");
        p.ver(s.agregarZona("Ciudad Vieja").resultado, Retorno.Resultado.ERROR_1, "Se ingresa Ciudad vieja que sobrepasa el limite de 7 ciudades");
        //
        p.ver(s.listarZonas().resultado.OK, Retorno.Resultado.OK, " se listan las zonas registradas");
        //

        p.imprimirComentario("AGREGAMOS RUTAS CORRECTAS AL MAPA");
        p.ver(s.agregarRuta(1, 4, 2).resultado, Retorno.Resultado.OK, "Se agrega ruta entre 1 y 4");
        p.ver(s.agregarRuta(2, 4, 3).resultado, Retorno.Resultado.OK, "Se agrega ruta entre 1 y 4");
        p.ver(s.agregarRuta(2, 3, 5).resultado, Retorno.Resultado.OK, "Se agrega ruta entre 1 y 4");
        p.ver(s.agregarRuta(3, 5, 7).resultado, Retorno.Resultado.OK, "Se agrega ruta entre 1 y 4");
        p.ver(s.agregarRuta(4, 5, 1).resultado, Retorno.Resultado.OK, "Se agrega ruta entre 1 y 4");
        p.ver(s.agregarRuta(3, 6, 8).resultado, Retorno.Resultado.OK, "Se agrega ruta entre 1 y 4");
        p.ver(s.agregarRuta(7, 5, 3).resultado, Retorno.Resultado.OK, "Se agrega ruta entre 1 y 4");

        //mostrar mapa
        p.imprimirComentario("AGREGAMOS RUTAS INCORRECTAS AL MAPA");
        p.ver(s.agregarRuta(10, 5, 3).resultado, Retorno.Resultado.ERROR_1, "Se agrega ruta entre 10 y 5");
        p.ver(s.agregarRuta(1, 45, 3).resultado, Retorno.Resultado.ERROR_2, "Se agrega ruta entre 1 y 45");
        p.ver(s.agregarRuta(1, 6, 0).resultado, Retorno.Resultado.ERROR_3, "Se agrega ruta entre 1 y 6 con cero minutos");

        //
        p.imprimirComentario("MODIFICAMOS DEMORAS EN EL MAPA");
        p.ver(s.modificarDemora(1, 4, 1).resultado, Retorno.Resultado.OK, "Modifico demora entre zona 1 y 4");
        p.ver(s.modificarDemora(2, 4, 5).resultado, Retorno.Resultado.OK, "Modifico demora entre zona 2 y 4");
        p.ver(s.modificarDemora(8, 4, 5).resultado, Retorno.Resultado.ERROR_1, "Modifico demora entre zona 8 y 4");
        p.ver(s.modificarDemora(1, 9, 5).resultado, Retorno.Resultado.ERROR_2, "Modifico demora entre zona 1 y 9");
        p.ver(s.modificarDemora(1, 4, 0).resultado, Retorno.Resultado.ERROR_3, "Modifico demora entre zona 1 y 4");
        p.ver(s.modificarDemora(1, 4, 2).resultado, Retorno.Resultado.OK, "Modifico demora entre zona 1 y 4");
        p.ver(s.modificarDemora(2, 4, 3).resultado, Retorno.Resultado.OK, "Modifico demora entre zona 2 y 4");

        //mostrar mapa
        //
        p.imprimirComentario("RUTA MAS RAPIDA CORRECTA");
        p.ver(s.rutaMasRapida(1, 4).resultado, Retorno.Resultado.OK, "Solicito ruta mas rapida entre 1 y 4");
        p.ver(s.rutaMasRapida(1, 2).resultado, Retorno.Resultado.OK, "Solicito ruta mas rapida entre 1 y 2");
        p.ver(s.rutaMasRapida(2, 5).resultado, Retorno.Resultado.OK, "Solicito ruta mas rapida entre 2 y 5");

        p.imprimirComentario("RUTA MAS RAPIDA CON ERROR");
        p.ver(s.rutaMasRapida(9, 4).resultado, Retorno.Resultado.ERROR_2, "Solicito ruta mas rapida entre 9 y 4");
        p.ver(s.rutaMasRapida(1, 9).resultado, Retorno.Resultado.ERROR_3, "Solicito ruta mas rapida entre 1 y 9");
        //
        p.imprimirComentario("REGISTRO DE MOVILES - OK");
        p.ver(s.registrarMovil("PCS101", 1).resultado, Retorno.Resultado.OK, "Registro movil PCS101 en la zona 1");
        p.ver(s.registrarMovil("PCS102", 2).resultado, Retorno.Resultado.OK, "Registro movil PCS102 en la zona 2");
        p.ver(s.registrarMovil("PCS103", 3).resultado, Retorno.Resultado.OK, "Registro movil PCS103 en la zona 3");
        p.ver(s.registrarMovil("PCS104", 4).resultado, Retorno.Resultado.OK, "Registro movil PCS104 en la zona 4");
        p.ver(s.registrarMovil("PCS105", 5).resultado, Retorno.Resultado.OK, "Registro movil PCS105 en la zona 5");
        p.ver(s.registrarMovil("PCS106", 6).resultado, Retorno.Resultado.OK, "Registro movil PCS106 en la zona 6");
        p.ver(s.registrarMovil("PCS108", 1).resultado, Retorno.Resultado.OK, "Registro movil PCS108 en la zona 1");
        p.ver(s.registrarMovil("PCS109", 2).resultado, Retorno.Resultado.OK, "Registro movil PCS109 en la zona 2");
        p.ver(s.registrarMovil("PCS110", 3).resultado, Retorno.Resultado.OK, "Registro movil PCS110 en la zona 3");
        p.ver(s.registrarMovil("PCS111", 4).resultado, Retorno.Resultado.OK, "Registro movil PCS111 en la zona 4");
        p.ver(s.registrarMovil("PCS112", 5).resultado, Retorno.Resultado.OK, "Registro movil PCS112 en la zona 5");
        p.ver(s.registrarMovil("PCS113", 6).resultado, Retorno.Resultado.OK, "Registro movil PCS113 en la zona 6");
        p.ver(s.registrarMovil("PCS115", 1).resultado, Retorno.Resultado.OK, "Registro movil PCS115 en la zona 1");
        p.ver(s.registrarMovil("PCS116", 2).resultado, Retorno.Resultado.OK, "Registro movil PCS116 en la zona 2");

        p.imprimirComentario("REGISTRO DE MOVILES - ERROR");
        p.ver(s.registrarMovil("PCS117", 9).resultado, Retorno.Resultado.ERROR_1, "Registro movil PCS116 en la zona 9");
        p.ver(s.registrarMovil("PCS116", 3).resultado, Retorno.Resultado.ERROR_2, "Registro movil PCS116 en la zona 3");
        //

        p.imprimirComentario("INFORME DE ZONAS");
        p.ver(s.informeZonas().resultado, Retorno.Resultado.OK, "Informe de zonas");
        //

        p.imprimirComentario("ZONAS EN RADIO - OK");
        p.ver(s.zonasEnRadio(1, 6).resultado, Retorno.Resultado.OK, "Solicito informe de zonas en radio de 6 minutos a zona 1");
        p.ver(s.zonasEnRadio(2, 8).resultado, Retorno.Resultado.OK, "Solicito informe de zonas en radio de 8 minutos a zona 2");

        p.imprimirComentario("ZONAS EN RADIO -  ERROR");
        p.ver(s.zonasEnRadio(9, 8).resultado, Retorno.Resultado.ERROR_1, "Solicito informe de zonas en radio de 8 minutos a zona 9");
        p.ver(s.zonasEnRadio(2, 0).resultado, Retorno.Resultado.ERROR_2, "Solicito informe de zonas en radio de 0 minutos a zona 2");
        //

        p.imprimirComentario("REGISTRO DE CHOFERES - OK");
        p.ver(s.registrarChofer("PCS101", "Alberto Pedrosa", "1.554.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS101");
        p.ver(s.registrarChofer("PCS102", "Esteban Gonzalez", "2.554.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS102");
        p.ver(s.registrarChofer("PCS103", "Laura Martinez", "3.554.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS103");
        p.ver(s.registrarChofer("PCS104", "Jacinto Lodeiro", "4.554.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS104");
        p.ver(s.registrarChofer("PCS105", "Martin Jackson", "5.554.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS105");
        p.ver(s.registrarChofer("PCS106", "Maria Ruiz", "6.554.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS106");
        p.ver(s.registrarChofer("PCS108", "Hermenegildo Diaz", "7.554.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS108");
        p.ver(s.registrarChofer("PCS109", "Patricia Beltran", "8.554.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS109");
        p.ver(s.registrarChofer("PCS110", "Marcelo Micino", "9.554.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS110");
        p.ver(s.registrarChofer("PCS111", "Jorge Gentile", "4.154.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS111");
        p.ver(s.registrarChofer("PCS112", "Anibal Feldman", "4.254.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS112");
        p.ver(s.registrarChofer("PCS113", "Leonardo Madrigal", "4.354.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS113");
        p.ver(s.registrarChofer("PCS115", "Leandro Silvera", "4.454.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS115");
        p.ver(s.registrarChofer("PCS116", "Lucia Olivera", "4.554.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS116");
        p.ver(s.registrarChofer("PCS101", "Carlos Larrañaga", "4.654.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS101");
        p.ver(s.registrarChofer("PCS101", "Sebastian Vazquez", "4.754.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS101");
        p.ver(s.registrarChofer("PCS101", "Pablo Rossi", "4.854.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS101");
        p.ver(s.registrarChofer("PCS102", "Susana Rivera", "4.954.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS102");
        p.ver(s.registrarChofer("PCS102", "Bruno Perez", "4.504.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS102");
        p.ver(s.registrarChofer("PCS103", "Luis Suarez", "4.514.89-1").resultado, Retorno.Resultado.OK, " ingreso chofer movil PCS103");
        //choferes con error

        p.imprimirComentario("REGISTRO DE CHOFERES - ERROR");
        p.ver(s.registrarChofer("PCS125", "Luis Suarez", "4.514.19-1").resultado, Retorno.Resultado.ERROR_1, " ingreso chofer movil PCS103");
        p.ver(s.registrarChofer("PCS143", "Luis Suarez", "4.514.29-1").resultado, Retorno.Resultado.ERROR_1, " ingreso chofer movil PCS103");
        p.ver(s.registrarChofer("PCS153", "Luis Suarez", "4.514.89-1").resultado, Retorno.Resultado.ERROR_1, " ingreso chofer movil PCS103");
        //
        p.ver(s.eliminarChofer("PCS101", "4.854.89-1").resultado, Retorno.Resultado.OK, "Elimino el chofer cedula 4.854.89-1 del movil PCS101");
        p.ver(s.eliminarChofer("PCS102", "4.504.89-1").resultado, Retorno.Resultado.OK, "Elimino el chofer cedula 4.504.89-1 del movil PCS102");
        p.ver(s.eliminarChofer("PCS152", "4.504.89-1").resultado, Retorno.Resultado.ERROR_1, "Elimino el chofer cedula 4.504.89-1 del movil PCS152");
        //
        p.imprimirComentario("INFORME  DE CHOFERES");
        p.ver(s.informeChoferes("PCS101").resultado, Retorno.Resultado.OK, "Solicito informe de choferes de PCS101");
        p.ver(s.informeChoferes("PCS102").resultado, Retorno.Resultado.OK, "Solicito informe de choferes de PCS102");
        p.ver(s.informeChoferes("PCS103").resultado, Retorno.Resultado.OK, "Solicito informe de choferes de PCS103");
        p.ver(s.informeChoferes("PCS104").resultado, Retorno.Resultado.OK, "Solicito informe de choferes de PCS104");
        p.ver(s.informeChoferes("PCS134").resultado, Retorno.Resultado.ERROR_1, "Solicito informe de choferes de PCS134");
        //

        p.imprimirComentario("REGISTRO DE ABONADOS - OK");
        p.ver(s.registrarAbonado(2, "Alberto Pedrosa", "Cuareim 1134", "24001115", 1).resultado, Retorno.Resultado.OK, "Registro abonado 2");
        p.ver(s.registrarAbonado(3, "ACIEN ZURUTA ROSA MARIA", "Paraguay 1134", "24001115", 1).resultado, Retorno.Resultado.OK, "Registro abonado 3");
        p.ver(s.registrarAbonado(4, "ALBUSAC TAMARGO DANIEL", "Avenida Italia 1134", "24001115", 1).resultado, Retorno.Resultado.OK, "Registro abonado 4");
        p.ver(s.registrarAbonado(5, "ALONSO BECERRA JOSE", "Carlos Quijano 1134", "24001115", 1).resultado, Retorno.Resultado.OK, "Registro abonado 5");
        p.ver(s.registrarAbonado(6, "AMAT MENA SUSANA", "Canelones 1134", "24001115", 2).resultado, Retorno.Resultado.OK, "Registro abonado 6");
        p.ver(s.registrarAbonado(7, "AMATE GARRIDO IRENE", "Maldonado 1134", "24001115", 3).resultado, Retorno.Resultado.OK, "Registro abonado 7");
        p.ver(s.registrarAbonado(8, "APARICIO GARCIA MAGDALENA", "Cibils 1134", "24001115", 4).resultado, Retorno.Resultado.OK, "Registro abonado 8");
        p.ver(s.registrarAbonado(9, "BENAYAS PEREZ NATALIA", "8 de octubre 1134", "24001115", 5).resultado, Retorno.Resultado.OK, "Registro abonado 9");
        p.ver(s.registrarAbonado(10, "BERNABE CASANOVA FRANCISCO CESAR", "Joanico 1134", "24001115", 6).resultado, Retorno.Resultado.OK, "Registro abonado 10");
        p.ver(s.registrarAbonado(11, "BERNAL RUIZ ENCARNACION", "Arrieta 1134", "24001115", 7).resultado, Retorno.Resultado.OK, "Registro abonado 11");
        p.ver(s.registrarAbonado(12, "CACERES CONTRERAS MARIA DEL MAR", "Boulevard Artigas 1134", "24001115", 7).resultado, Retorno.Resultado.OK, "Registro abonado 12");
        p.ver(s.registrarAbonado(13, "CAMPOS VIQUE MARIA BELEN", "Itapeby 1134", "24001115", 2).resultado, Retorno.Resultado.OK, "Registro abonado 13");
        p.ver(s.registrarAbonado(14, "CARREÑO NAVARRO MONICA", "Gustavo Gallinal 1134", "24001115", 2).resultado, Retorno.Resultado.OK, "Registro abonado 14");
        p.ver(s.registrarAbonado(15, "CARRERA BENITEZ SUSANA", "Convencion 1134", "24001115", 3).resultado, Retorno.Resultado.OK, "Registro abonado 15");
        p.ver(s.registrarAbonado(16, "CASAS GARCIA MARIA ESPERANZA", "Rio Negro 1134", "24001115", 3).resultado, Retorno.Resultado.OK, "Registro abonado 16");
        p.ver(s.registrarAbonado(17, "CASTELLS GALLEGO MARAI DEL TISCAR", "Durazno 1134", "24001115", 4).resultado, Retorno.Resultado.OK, "Registro abonado 17");
        p.ver(s.registrarAbonado(18, "CASTILLO ALARCON ISABEL", "Andes 1134", "24001115", 4).resultado, Retorno.Resultado.OK, "Registro abonado 18");
        p.ver(s.registrarAbonado(19, "CASTILLO GALDEANO ELENA MARIA", "Rincon 1134", "24001115", 4).resultado, Retorno.Resultado.OK, "Registro abonado 19");

        p.imprimirComentario("REGISTRO DE ABONADOS - ERROR");
        p.ver(s.registrarAbonado(20, "CASTELLS GALLEGO MARAI DEL TISCAR", "Durazno 1134", "24001115", 9).resultado, Retorno.Resultado.ERROR_1, "Registro abonado 20");
        p.ver(s.registrarAbonado(19, "CASTILLO GALDEANO ELENA MARIA", "Rincon 1134", "24001115", 2).resultado, Retorno.Resultado.ERROR_2, "Registro abonado 19");
//
        p.imprimirComentario("ELIMINAR  ABONADOS - OK");
        p.ver(s.eliminarAbonado(15).resultado, Retorno.Resultado.OK, "elimino abonado 15");
        p.ver(s.eliminarAbonado(5).resultado, Retorno.Resultado.OK, "elimino abonado 5");

        p.imprimirComentario("ELIMINAR  ABONADOS - ERROR");
        p.ver(s.eliminarAbonado(35).resultado, Retorno.Resultado.ERROR_1, "elimino abonado 35");
        //

        p.imprimirComentario("INFORME  ABONADOS - OK");
        p.ver(s.informeAbonadosZona(1).resultado, Retorno.Resultado.OK, "Solicito informe de abonados zona 1");
        p.ver(s.informeAbonadosZona(2).resultado, Retorno.Resultado.OK, "Solicito informe de abonados zona 2");
        p.ver(s.informeAbonadosZona(3).resultado, Retorno.Resultado.OK, "Solicito informe de abonados zona 3");
        p.ver(s.informeAbonadosZona(4).resultado, Retorno.Resultado.OK, "Solicito informe de abonados zona 4");

        p.imprimirComentario("INFORME  ABONADOS - ERROR");
        p.ver(s.informeAbonadosZona(34).resultado, Retorno.Resultado.ERROR_1, "Solicito informe de abonados zona 34");

        //
        p.ver(s.deshabilitarMovil("PCS101").resultado, Retorno.Resultado.OK, "deshabilito el movil PCS101");
        p.ver(s.deshabilitarMovil("PCS105").resultado, Retorno.Resultado.OK, "deshabilito el movil PCS105");

        //UDF.ViajeEmergencia(7);
        p.imprimirComentario("emergencia asignada a la zona 7");

        p.ver(s.habilitarMovil("PCS101").resultado, Retorno.Resultado.OK, "Habilito movil PCS101");
        p.ver(s.habilitarMovil("PCS112").resultado, Retorno.Resultado.ERROR_3, "Intento habilitar movil PCS112 que esta en emergencia");

        p.ver(s.deshabilitarMovil("PCS112").resultado, Retorno.Resultado.ERROR_3, "Intento deshabilitar movil PCS112 que esta en emergencia");
        p.ver(s.habilitarMovil("PCS141").resultado, Retorno.Resultado.ERROR_1, "Habilito movil PCS141");
        p.ver(s.habilitarMovil("PCS108").resultado, Retorno.Resultado.ERROR_2, "Habilito movil PCS108");
        p.ver(s.deshabilitarMovil("PCS141").resultado, Retorno.Resultado.ERROR_1, "Intento deshabilitar movil PCS141");
        p.ver(s.deshabilitarMovil("PCS105").resultado, Retorno.Resultado.ERROR_2, "Intento deshabilitar movil PCS101");
        p.ver(s.eliminarMovil("PCS115").resultado, Retorno.Resultado.OK, "Elimino movil PCS115");
        p.ver(s.eliminarMovil("PCS141").resultado, Retorno.Resultado.ERROR_1, "Elimino movil PCS141");
        p.ver(s.eliminarMovil("PCS112").resultado, Retorno.Resultado.ERROR_2, "Elimino movil PCS112");
        p.ver(s.cambiarUbicacion("PCS112", 3).resultado, Retorno.Resultado.OK, "muevo el movil PCS112 a la zona 3");
        p.ver(s.cambiarUbicacion("PCS141", 2).resultado, Retorno.Resultado.ERROR_2, "muevo el movil PCS141 que no existe a la zona 2");
        p.ver(s.cambiarUbicacion("PCS111", 40).resultado, Retorno.Resultado.ERROR_1, "Muevo el movil PCS111 a la zona 40 que no existe");
        p.ver(s.informeMovil(1).resultado, Retorno.Resultado.OK, "Solicito informe de moviles en zona 1");
        p.ver(s.informeMovil(2).resultado, Retorno.Resultado.OK, "Solicito informe de moviles en zona 2");
        p.ver(s.informeMovil(3).resultado, Retorno.Resultado.OK, "Solicito informe de moviles en zona 3");
        p.ver(s.informeMovil(4).resultado, Retorno.Resultado.OK, "Solicito informe de moviles en zona 4");
        p.ver(s.informeMovil(5).resultado, Retorno.Resultado.OK, "Solicito informe de moviles en zona 5");
        p.ver(s.informeMovil(6).resultado, Retorno.Resultado.OK, "Solicito informe de moviles en zona 6");
        p.ver(s.informeMovil(7).resultado, Retorno.Resultado.OK, "Solicito informe de moviles en zona 7");
        p.ver(s.informeMovil(9).resultado, Retorno.Resultado.ERROR_1, "Solicito informe de moviles en zona 9");
        p.ver(s.informeMovil(29).resultado, Retorno.Resultado.ERROR_1, "Solicito informe de moviles en zona 29");
        p.ver(s.informeMovil().resultado, Retorno.Resultado.OK, "Solicito informe de moviles");

        p.ver(s.buscarMovil("PCS112").resultado, Retorno.Resultado.OK, "Solicito buscar movil PCS112");

        p.ver(s.buscarMovil("PCS132").resultado, Retorno.Resultado.ERROR_1, "Solicito buscar movil PCS132");

        p.ver(s.movilMasCercano(1).resultado, Retorno.Resultado.OK, "Solicito el movil mas cercano a la zona 1");
        p.ver(s.movilMasCercano(2).resultado, Retorno.Resultado.OK, "Solicito el movil mas cercano a la zona 2");
        p.ver(s.movilMasCercano(3).resultado, Retorno.Resultado.OK, "Solicito el movil mas cercano a la zona 3");
        p.ver(s.movilMasCercano(4).resultado, Retorno.Resultado.OK, "Solicito el movil mas cercano a la zona 4");
        p.ver(s.movilMasCercano(5).resultado, Retorno.Resultado.OK, "Solicito el movil mas cercano a la zona 5");
        p.ver(s.movilMasCercano(6).resultado, Retorno.Resultado.OK, "Solicito el movil mas cercano a la zona 6");
        p.ver(s.movilMasCercano(7).resultado, Retorno.Resultado.OK, "Solicito el movil mas cercano a la zona 7");
        p.ver(s.movilMasCercano(9).resultado, Retorno.Resultado.ERROR_1, "Solicito el movil mas cercano a la zona 97");
        //
        p.imprimirResultadosPrueba();

    }
    
    static void prueba10(Sistema s, Prueba p) {
        p.ver(s.crearSistemaEmergencias(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.agregarZona("Zona 1").resultado, Retorno.Resultado.OK, "Se crea la zona 1");
        p.ver(s.agregarZona("Zona 2").resultado, Retorno.Resultado.OK, "Se crea la zona 2");
        p.ver(s.registrarMovil("MOMO1", 1).resultado, Retorno.Resultado.OK, "Se crea el movil 1");
        p.ver(s.registrarMovil("MOMO2", 2).resultado, Retorno.Resultado.OK, "Se crea el movil 2");
        p.ver(s.registrarMovil("MOMO0", 2).resultado, Retorno.Resultado.OK, "Se crea el movil 0");
        p.ver(s.deshabilitarMovil("MOMO0").resultado, Retorno.Resultado.OK, "Se deshabilita el movil 0");
//        p.ver(s.informeMovil(1).resultado, Retorno.Resultado.OK, "Info m 1.");
//        p.ver(s.informeMovil(2).resultado, Retorno.Resultado.OK, "Info M 2");
        p.ver(s.cambiarUbicacion("MOMO1", 2).resultado, Retorno.Resultado.OK, "cambia ubi ...");
//        //p.ver(s.viaje(1, 2, "MOMO1").resultado, Retorno.Resultado.OK, "Viaja ...");
//        p.ver(s.informeMovil(1).resultado, Retorno.Resultado.OK, "Info m 1.....");
//        p.ver(s.informeMovil().resultado, Retorno.Resultado.OK, "Info M 2.....");
        p.ver(s.informeMovil(2).resultado, Retorno.Resultado.OK, "Info M 2.....");
//        p.ver(s.deshabilitarMovil("MOMO1").resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        
        
        
//        p.imprimirResultadosPrueba();
    }
    
    
}
