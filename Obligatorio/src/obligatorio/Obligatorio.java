package obligatorio;

import static obligatorio.metodos.*;

public class Obligatorio {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Prueba p = new Prueba();

//        prueba1(s, p);
//        prueba2(s, p);
        prueba3(s, p);
//        prueba4(s, p);
//        prueba5(s, p);
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
           p.ver(s.agregarZona("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Se intentoagregar Montevideo que ya existe");
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
        p.ver(s.agregarZona("New York").resultado, Retorno.Resultado.OK, "Se ingresa New York");
   
        p.imprimirComentario("INGRESAMOS CIUDAD REPETIDA");
        p.ver(s.agregarZona("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        
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
        
        p.ver(s.listarZonas().resultado, Retorno.Resultado.OK, "Lista de Zonas");
        //p.ver(s.registrarMovil("PCS123", 1).resultado, Retorno.Resultado.OK, "Agrego movil PCS123 a Pocitos ");
//        p.ver(s.registrarMovil("PCS123", 1).resultado, Retorno.Resultado.ERROR_2, "Agrego movil PCS123 que ya existe en Pocitos ");
//        p.ver(s.registrarMovil("PCS123", 20).resultado, Retorno.Resultado.ERROR_1, "Agrego movil PCS123 a zona que no existe ");
//        
//        p.ver(s.deshabilitarMovil("PCS123").resultado, Retorno.Resultado.OK, "Se deshabilita PCS123");
//        p.ver(s.deshabilitarMovil("PCS123").resultado, Retorno.Resultado.ERROR_2, "Se deshabilita PCS123 que ya estaba deshabilitado");
//        p.ver(s.habilitarMovil("PCS123").resultado, Retorno.Resultado.OK, "se habilita movil PCS123");
//        p.ver(s.eliminarMovil("PCS123").resultado, Retorno.Resultado.OK, "Se elimina mobil PCS123");
         p.imprimirResultadosPrueba(); 
    }

    static void prueba4(Sistema s, Prueba p) {
        p.ver(s.registrarChofer("1", "nombre", "cedula").resultado, Retorno.Resultado.OK, "Mensaje registrarChofer()");
        p.ver(s.eliminarChofer("1", "cedula").resultado, Retorno.Resultado.OK, "Mensaje eliminarChofer()");
        p.ver(s.informeChoferes("1").resultado, Retorno.Resultado.OK, "Mensaje informeChoferes()");
        p.imprimirResultadosPrueba();
    }

    static void prueba5(Sistema s, Prueba p) {
        //p.ver(s.registrarAbonadol(2, "abonadoNombre", "abonadoDireccion," "abonadoTel", 1).resultado, Retorno.Resultado.OK, "Mensaje registrarAbonadol()");
        p.ver(s.eliminarAbonado(2).resultado, Retorno.Resultado.OK, "Mensaje eliminarAbonado()");
        p.ver(s.informeAbonadosZona(1).resultado, Retorno.Resultado.OK, "Mensaje informeAbonadosZona()");
        p.imprimirResultadosPrueba();
    }
}
