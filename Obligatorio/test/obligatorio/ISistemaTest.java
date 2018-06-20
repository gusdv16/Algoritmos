package obligatorio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alber
 */
public class ISistemaTest {

    ISistema sis;
    Retorno ret;

    @Before
    public void setUp() throws Exception {
        sis = new Sistema();

        sis.crearSistemaEmergencias(20);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCrearSistemaEmergencias() {
        sis = new Sistema();
        assertEquals(Retorno.Resultado.ERROR_1, sis.crearSistemaEmergencias(-5).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.crearSistemaEmergencias(-1).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.crearSistemaEmergencias(0).resultado);
        assertEquals(Retorno.Resultado.OK, sis.crearSistemaEmergencias(1).resultado);
        sis = new Sistema();
        assertEquals(Retorno.Resultado.OK, sis.crearSistemaEmergencias(5).resultado);
    }

    @Test
    public void testDestruirSistemaEmergencias() {
        assertEquals(Retorno.Resultado.OK, sis.destruirSistemaEmergencias().resultado);
    }

    @Test
    public void testRegistrarMovil() {
        assertEquals(Retorno.Resultado.ERROR_1, sis.registrarMovil("MAN1891",1).resultado);
        sis.agregarZona("Zona 1");
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("MAN1891",2).resultado);
        sis.agregarZona("Zona 2");
        assertEquals(Retorno.Resultado.ERROR_2, sis.registrarMovil("MAN1891", 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("MUS0001", 2).resultado);
    }

    @Test
    public void testDeshabilitarMovil() {
        sis.agregarZona("Zona 1");
        assertEquals(Retorno.Resultado.ERROR_1, sis.deshabilitarMovil("MAN1891").resultado);
        sis.registrarMovil("MAN1891", 1);
        assertEquals(Retorno.Resultado.OK, sis.deshabilitarMovil("MAN1891").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.deshabilitarMovil("MAN1891").resultado);
    }

    @Test
    public void testHabilitarMovil() {
        sis.agregarZona("Zona 1");
        assertEquals(Retorno.Resultado.ERROR_1, sis.habilitarMovil("MAN1891").resultado);
        sis.registrarMovil("MAN1891", 1);
        assertEquals(Retorno.Resultado.ERROR_2, sis.habilitarMovil("MAN1891").resultado);
        sis.deshabilitarMovil("MAN1891");
        assertEquals(Retorno.Resultado.OK, sis.habilitarMovil("MAN1891").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.habilitarMovil("MAN1891").resultado);

    }

    @Test
    public void testEliminarMovil() {
        sis.agregarZona("Zona 1");
        assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarMovil("MAN1891").resultado);
        sis.registrarMovil("MAN1891", 1);
        assertEquals(Retorno.Resultado.OK, sis.eliminarMovil("MAN1891").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarMovil("MAN1891").resultado);
    }

    @Test
    public void testBuscarMovil() {
        sis.agregarZona("Zona 1");
        assertEquals(Retorno.Resultado.ERROR_1, sis.buscarMovil("MAN1891").resultado);
        sis.registrarMovil("MAN1891", 1);

        ret = sis.buscarMovil("MAN1891");
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertTrue(ret.valorString.contains("MAN1891"));
        assertTrue(ret.valorString.contains("Estado: DISPONIBLE"));
        assertTrue(ret.valorString.contains("Zona: Zona 1"));

        sis.deshabilitarMovil("MAN1891");
        ret = sis.buscarMovil("MAN1891");
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertTrue(ret.valorString.contains("MAN1891"));
        assertTrue(ret.valorString.contains("Estado: NO_DISPONIBLE"));
        assertTrue(ret.valorString.contains("Zona: Zona 1"));
    }

    @Test
    public void testInformeMovil() {
        sis.agregarZona("Zona 1");
        sis.agregarZona("Zona 2");
        sis.agregarZona("Zona 3");
        sis.agregarZona("Zona 4");
        sis.registrarMovil("MATADOR0011", 1);
        sis.registrarMovil("CEBOLLA0007", 3);
        sis.registrarMovil("MAN1891", 1);
        sis.registrarMovil("LUCHO0009", 2);

        ret = sis.informeMovil();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        boolean estaOrdenado = ret.valorString
                .equals("CEBOLLA0007;DISPONIBLE;Zona 3|LUCHO0009;DISPONIBLE;Zona 2|MAN1891;DISPONIBLE;Zona 1|MATADOR0011;DISPONIBLE;Zona 1")
                || ret.valorString.equals(
                        "MATADOR0011;DISPONIBLE;Zona 1|MAN1891;DISPONIBLE;Zona 1|LUCHO0009;DISPONIBLE;Zona 2|CEBOLLA0007;DISPONIBLE;Zona 3");
        assertTrue(estaOrdenado);

        sis.deshabilitarMovil("CEBOLLA0007");
        ret = sis.informeMovil();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        estaOrdenado = ret.valorString
                .equals("CEBOLLA0007;NO_DISPONIBLE;Zona 3|LUCHO0009;DISPONIBLE;Zona 2|MAN1891;DISPONIBLE;Zona 1|MATADOR0011;DISPONIBLE;Zona 1")
                || ret.valorString.equals(
                        "MATADOR0011;DISPONIBLE;Zona 1|MAN1891;DISPONIBLE;Zona 1|LUCHO0009;DISPONIBLE;Zona 2|CEBOLLA0007;NO_ISPONIBLE;Zona 3");
        assertTrue(estaOrdenado);

    }

    @Test
    public void testInformeMovilInt() {
        sis.agregarZona("Zona 1");
        sis.agregarZona("Zona 2");
        sis.agregarZona("Zona 3");
        sis.agregarZona("Zona 4");
        sis.registrarMovil("MATADOR0011", 1);
        sis.registrarMovil("CEBOLLA0007", 3);
        sis.registrarMovil("MAN1891", 1);
        sis.registrarMovil("GOD0003", 1);
        sis.registrarMovil("MUS0001", 1);
        sis.registrarMovil("LUCHO0009", 2);

        ret = sis.informeMovil(1);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("GOD0003;MAN1891;MATADOR0011;MUS0001|Total móviles disponibles: 4", ret.valorString);

        sis.deshabilitarMovil("CEBOLLA0007");
        sis.deshabilitarMovil("GOD0003");
        ret = sis.informeMovil(1);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("GOD0003;MAN1891;MATADOR0011;MUS0001|Total móviles disponibles: 3", ret.valorString);
    }

    @Test
    public void testCambiarUbicacion() {
        assertEquals(Retorno.Resultado.ERROR_1, sis.cambiarUbicacion("MAN1891", 1).resultado);
        sis.agregarZona("Zona 1");
        sis.agregarZona("Zona 2");
        sis.agregarZona("Zona 3");
        sis.agregarZona("Zona 4");
        assertEquals(Retorno.Resultado.ERROR_2, sis.cambiarUbicacion("MAN1891", 1).resultado);
        sis.registrarMovil("MAN1891", 1);
        assertEquals(Retorno.Resultado.OK, sis.cambiarUbicacion("MAN1891", 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.cambiarUbicacion("MAN1891", 3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.cambiarUbicacion("MAN1891", 4).resultado);
        assertEquals(Retorno.Resultado.OK, sis.cambiarUbicacion("MAN1891", 3).resultado);
    }

    @Test
    public void testAgregarZona() {
        sis = new Sistema();
        sis.crearSistemaEmergencias(4);
        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Zona 1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Zona 2").resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Zona 3").resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Zona 4 Ultima!").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.agregarZona("Zona 5").resultado);
    }

    @Test
    public void testListarZonas() {
        ret = sis.listarZonas();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("", ret.valorString);

        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");
        ret = sis.listarZonas();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("1;Zona unoh|2;Zona doh|3;Zona treh|4;Zona kuatroh", ret.valorString);
    }

    @Test
    public void testAgregarRuta() {
        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");

        assertEquals(Retorno.Resultado.ERROR_1, sis.agregarRuta(5, 1, 10).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.agregarRuta(1, 5, 10).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.agregarRuta(1, 2, 0).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.agregarRuta(1, 2, -1).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.agregarRuta(1, 2, -5).resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarRuta(1, 2, 10).resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarRuta(1, 3, 10).resultado);
    }

    @Test
    public void testModificarDemora() {
        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");

        sis.agregarRuta(1, 2, 10);
        sis.agregarRuta(1, 3, 10);
        assertEquals(Retorno.Resultado.ERROR_1, sis.modificarDemora(5, 1, 10).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.modificarDemora(1, 5, 10).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.modificarDemora(1, 2, 0).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.modificarDemora(1, 2, -1).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.modificarDemora(1, 2, -5).resultado);
        assertEquals(Retorno.Resultado.OK, sis.modificarDemora(1, 2, 10).resultado);
        assertEquals(Retorno.Resultado.OK, sis.modificarDemora(1, 2, 18).resultado);
        assertEquals(Retorno.Resultado.OK, sis.modificarDemora(3, 1, 15).resultado);

    }

    @Test
    public void testMovilMasCercano() {
        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");

        sis.registrarMovil("CEBOLLA0007", 3);

        sis.agregarRuta(1, 2, 10);
        sis.agregarRuta(1, 3, 15);
        sis.agregarRuta(1, 4, 20);

        assertEquals(Retorno.Resultado.ERROR_1, sis.movilMasCercano(5).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.movilMasCercano(6).resultado);

        ret = sis.movilMasCercano(1);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("CEBOLLA0007;15", ret.valorString);
        sis.registrarMovil("LUCHO0009", 2);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("LUCHO0009;10", ret.valorString);
        sis.registrarMovil("MATADOR0011", 1);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("MATADOR0011;0", ret.valorString);

    }

    @Test
    public void testRutaMasRapida() {
        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");

        assertEquals(Retorno.Resultado.ERROR_1, sis.rutaMasRapida(5, 1).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.rutaMasRapida(1, 5).resultado);

        sis.agregarRuta(1, 2, 10);
        sis.agregarRuta(1, 3, 15);
        sis.agregarRuta(2, 4, 10);
        sis.agregarRuta(3, 4, 4);

        ret = sis.rutaMasRapida(1, 2);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertTrue(ret.valorString.contains("Zona unoh;0|Zona doh;10"));
        assertTrue(ret.valorString.contains("Demora total: 10"));

        ret = sis.rutaMasRapida(1, 4);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertTrue(ret.valorString.contains("Zona unoh;0|Zona treh;15|Zona kuatroh;4"));
        assertTrue(ret.valorString.contains("Demora total: 19"));

    }

    @Test
    public void testInformeZonas() {
        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");

        sis.registrarMovil("MATADOR0011", 1);
        sis.registrarMovil("CEBOLLA0007", 3);
        sis.registrarMovil("MAN1891", 1);
        sis.registrarMovil("GOD0003", 1);
        sis.registrarMovil("MUS0001", 1);
        sis.registrarMovil("LUCHO0009", 2);

        sis.deshabilitarMovil("GOD0003");
        sis.deshabilitarMovil("CEBOLLA0007");

        sis.agregarRuta(1, 2, 10);
        sis.agregarRuta(2, 3, 15);

        ret = sis.informeZonas();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertTrue(ret.valorString.contains("1|2;10|MóvilesDisponibles:3|MóvilesNoDisponibles:1"));
        assertTrue(ret.valorString.contains("2|1;10|3;15|MóvilesDisponibles:1|MóvilesNoDisponibles:0")
                || ret.valorString.contains("2|3;15|1;10|MóvilesDisponibles:1|MóvilesNoDisponibles:0"));
        assertTrue(ret.valorString.contains("3|2;15|MóvilesDisponibles:0|MóvilesNoDisponibles:1"));

    }

    @Test
    public void testZonasEnRadio() {
        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");

        sis.agregarRuta(1, 2, 10);
        sis.agregarRuta(1, 3, 15);
        sis.agregarRuta(2, 4, 10);
        sis.agregarRuta(3, 4, 4);

        assertEquals(Retorno.Resultado.ERROR_1, sis.zonasEnRadio(5, 50).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.zonasEnRadio(1, 0).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.zonasEnRadio(1, -1).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.zonasEnRadio(1, -5).resultado);

        ret = sis.zonasEnRadio(1, 9);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("", ret.valorString);
        ret = sis.zonasEnRadio(1, 10);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Zona doh;10", ret.valorString);
        ret = sis.zonasEnRadio(1, 14);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Zona doh;10", ret.valorString);
        ret = sis.zonasEnRadio(1, 15);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertTrue(ret.valorString.equals("Zona doh;10|Zona treh;15")
                || ret.valorString.equals("Zona treh;15|Zona doh;10"));
        ret = sis.zonasEnRadio(1, 19);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertTrue(ret.valorString.contains("Zona doh;10")
                || ret.valorString.contains("Zona treh;15")
                || ret.valorString.contains("Zona kuatroh;19"));

    }

    @Test
    public void testRegistrarChofer() {
        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");

        assertEquals(Retorno.Resultado.ERROR_1, sis.registrarChofer("CEBOLLA0007", "Cebolla Rodríguez", "1234567-8").resultado);
        sis.registrarMovil("CEBOLLA0007", 3);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("CEBOLLA0007", "Cebolla Rodríguez", "1234567-8").resultado);
    }

    @Test
    public void testEliminarChofer() {
        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");

        assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarChofer("CEBOLLA0007", "1234567-8").resultado);
        sis.registrarMovil("CEBOLLA0007", 3);
        sis.registrarChofer("CEBOLLA0007", "Cebolla Rodríguez", "1234567-8");
        assertEquals(Retorno.Resultado.OK, sis.eliminarChofer("CEBOLLA0007", "1234567-8").resultado);
    }

    @Test
    public void testInformeChoferes() {
        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");

        assertEquals(Retorno.Resultado.ERROR_1, sis.informeChoferes("CEBOLLA0007").resultado);
        sis.registrarMovil("CEBOLLA0007", 3);
        sis.registrarChofer("CEBOLLA0007", "Cebolla Rodríguez", "1234567-8");
        sis.registrarChofer("CEBOLLA0007", "Paolo Montero", "2345678-9");
        sis.registrarChofer("CEBOLLA0007", "Gianluigi Buffon", "3456789-0");

        ret = sis.informeChoferes("CEBOLLA0007");
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertTrue(ret.valorString.contains("Cebolla Rodríguez;1234567-8"));
        assertTrue(ret.valorString.contains("Paolo Montero;2345678-9"));
        assertTrue(ret.valorString.contains("Gianluigi Buffon;3456789-0"));

    }

    @Test
    public void testRegistrarAbonadol() {
        sis.agregarZona("Zona unoh");

        assertEquals(Retorno.Resultado.ERROR_1, sis.registrarAbonado(1, "Francisco Bouza", "Av. Fracaso 1234", "099123456", 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(1, "Francisco Bouza", "Av. Fracaso 1234", "099123456", 1).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.registrarAbonado(1, "Francisco Bouza", "Av. Fracaso 1234", "099123456", 1).resultado);
    }

    @Test
    public void testEliminarAbonado() {
        sis.agregarZona("Zona unoh");

        assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarAbonado(1).resultado);
        sis.registrarAbonado(1, "Francisco Bouza", "Av. Fracaso 1234", "099123456", 1);
        assertEquals(Retorno.Resultado.OK, sis.eliminarAbonado(1).resultado);
    }

    @Test
    public void testInformeAbonadosZona() {
        sis.agregarZona("Zona unoh");
        sis.agregarZona("Zona doh");
        sis.agregarZona("Zona treh");
        sis.agregarZona("Zona kuatroh");

        sis.registrarAbonado(1, "Francisco Bouza", "Av. Fracaso 1234", "099123456", 1);
        sis.registrarAbonado(2, "Juan Manuel Sobral", "Av. Fracaso 5678", "099111111", 1);
        sis.registrarAbonado(3, "Federico Sendra", "Av. Fracaso 9012", "099222222", 1);
        sis.registrarAbonado(4, "Lucía Nemmer", "Av. Fracaso 3456", "099333333", 1);
        sis.registrarAbonado(5, "Esteban Quito", "Av. Fracaso 7890", "099444444", 1);
        sis.registrarAbonado(6, "Rigoberta Menchú", "Av. Fracaso 1111", "099555555", 1);

        assertEquals(Retorno.Resultado.ERROR_1, sis.informeAbonadosZona(5).resultado);

        ret = sis.informeAbonadosZona(1);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("1;Zona unoh|3|1|2|4|Total_abonados_disponibles: 4", ret.valorString);

    }

}
