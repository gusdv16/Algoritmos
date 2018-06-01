package obligatorio;

public class Obligatorio {

    public static void main(String[] args) {
        Sistema s = new Sistema();
        Prueba p = new Prueba();

        prueba1(s, p);
//        prueba2(s, p);
//        prueba3(s, p);
//        prueba4(s, p);
//        prueba5(s, p);

    }

    static void prueba1(Sistema s, Prueba p) {
        p.imprimirComentario("Ingresamos los sistemas de emergencia");
        p.ver(s.crearSistemaEmergencias(3).resultado, Retorno.Resultado.OK, "Se crea el sistema de emergencia");
        p.imprimirComentario("ingresamos las zonas");
        p.ver(s.agregarZona("Marconi").resultado, Retorno.Resultado.OK, "se agrega Marconi como Zona");
        p.ver(s.agregarZona("Maroñas").resultado, Retorno.Resultado.OK, "Maroñas");
        p.imprimirResultadosPrueba();
    }

    static void prueba2(Sistema s, Prueba p) {
        p.ver(s.registrarMovil("id", 1).resultado, Retorno.Resultado.OK, "Mensaje registrarMovil()");
        p.ver(s.deshabilitarMovil("id").resultado, Retorno.Resultado.OK, "Mensaje deshabilitarMovil()");
        p.ver(s.habilitarMovil("id").resultado, Retorno.Resultado.OK, "Mensaje habilitarMovil()");
        p.ver(s.eliminarMovil("id").resultado, Retorno.Resultado.OK, "Mensaje eliminarMovil()");
        p.ver(s.buscarMovil("id").resultado, Retorno.Resultado.OK, "Mensaje buscarMovil()");
        p.ver(s.informeMovil().resultado, Retorno.Resultado.OK, "Mensaje informeMovil()");
        p.ver(s.informeMovil(1).resultado, Retorno.Resultado.OK, "Mensaje informeMovil()");
        p.ver(s.cambiarUbicacion("id", 1).resultado, Retorno.Resultado.OK, "Mensaje cambiarUbicacion()");

        p.imprimirResultadosPrueba();
    }

    static void prueba3(Sistema s, Prueba p) {

        p.ver(s.agregarZona("nombre").resultado, Retorno.Resultado.OK, "Mensaje agregarZona()");
        p.ver(s.listarZonas().resultado, Retorno.Resultado.OK, "Mensaje listarZonas()");
        p.ver(s.agregarRuta(2, 3, 5).resultado, Retorno.Resultado.OK, "Mensaje agregarRuta()");
        p.ver(s.modificarDemora(2, 3, 5).resultado, Retorno.Resultado.OK, "Mensaje modificarDemora()");
        p.ver(s.movilMasCercano(1).resultado, Retorno.Resultado.OK, "Mensaje movilMasCercano()");
        p.ver(s.rutaMasRapida(2, 3).resultado, Retorno.Resultado.OK, "Mensaje rutaMasRapida()");
        p.ver(s.informeZonas().resultado, Retorno.Resultado.OK, "Mensaje informeZonas()");
        p.ver(s.zonasEnRadio(1, 6).resultado, Retorno.Resultado.OK, "Mensaje zonasEnRadio()");
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
