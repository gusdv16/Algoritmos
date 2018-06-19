/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private ISistema sis;
    private Retorno r;

    public ISistemaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        sis = new Sistema();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of crearSistemaEmergencias method, of class ISistema.
     */
    @Test
    public void testCrearSistemaEmergencias() {
        assertEquals(Retorno.Resultado.ERROR_1, sis.crearSistemaEmergencias(-5).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.crearSistemaEmergencias(0).resultado);
        assertEquals(Retorno.Resultado.OK, sis.crearSistemaEmergencias(4).resultado);
        sis = new Sistema();
        assertEquals(Retorno.Resultado.OK, sis.crearSistemaEmergencias(4).resultado);
    }

//    /**
//     * Test of destruirSistemaEmergencias method, of class ISistema.
//     */
//    @Test
//    public void testDestruirSistemaEmergencias() {
//        System.out.println("destruirSistemaEmergencias");
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.destruirSistemaEmergencias();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registrarMovil method, of class ISistema.
//     */
//    @Test
//    public void testRegistrarMovil() {
//        System.out.println("registrarMovil");
//        String movilID = "";
//        int zonaID = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.registrarMovil(movilID, zonaID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deshabilitarMovil method, of class ISistema.
//     */
//    @Test
//    public void testDeshabilitarMovil() {
//        System.out.println("deshabilitarMovil");
//        String movilID = "";
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.deshabilitarMovil(movilID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of habilitarMovil method, of class ISistema.
//     */
//    @Test
//    public void testHabilitarMovil() {
//        System.out.println("habilitarMovil");
//        String movilID = "";
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.habilitarMovil(movilID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarMovil method, of class ISistema.
//     */
//    @Test
//    public void testEliminarMovil() {
//        System.out.println("eliminarMovil");
//        String movilID = "";
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.eliminarMovil(movilID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of buscarMovil method, of class ISistema.
//     */
//    @Test
//    public void testBuscarMovil() {
//        System.out.println("buscarMovil");
//        String movilID = "";
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.buscarMovil(movilID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of informeMovil method, of class ISistema.
//     */
//    @Test
//    public void testInformeMovil_0args() {
//        System.out.println("informeMovil");
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.informeMovil();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of informeMovil method, of class ISistema.
//     */
//    @Test
//    public void testInformeMovil_int() {
//        System.out.println("informeMovil");
//        int zonaID = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.informeMovil(zonaID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of cambiarUbicacion method, of class ISistema.
//     */
//    @Test
//    public void testCambiarUbicacion() {
//        System.out.println("cambiarUbicacion");
//        String movilID = "";
//        int zonaID = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.cambiarUbicacion(movilID, zonaID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of agregarZona method, of class ISistema.
//     */
//    @Test
//    public void testAgregarZona() {
//        System.out.println("agregarZona");
//        String zonaNombre = "";
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.agregarZona(zonaNombre);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarZonas method, of class ISistema.
//     */
//    @Test
//    public void testListarZonas() {
//        System.out.println("listarZonas");
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.listarZonas();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of agregarRuta method, of class ISistema.
//     */
//    @Test
//    public void testAgregarRuta() {
//        System.out.println("agregarRuta");
//        int zonaOrigen = 0;
//        int zonaDestino = 0;
//        int minutosViaje = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.agregarRuta(zonaOrigen, zonaDestino, minutosViaje);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of modificarDemora method, of class ISistema.
//     */
//    @Test
//    public void testModificarDemora() {
//        System.out.println("modificarDemora");
//        int zonaOrigen = 0;
//        int zonaDestino = 0;
//        int minutosViaje = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.modificarDemora(zonaOrigen, zonaDestino, minutosViaje);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of movilMasCercano method, of class ISistema.
//     */
//    @Test
//    public void testMovilMasCercano() {
//        System.out.println("movilMasCercano");
//        int zonaID = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.movilMasCercano(zonaID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of rutaMasRapida method, of class ISistema.
//     */
//    @Test
//    public void testRutaMasRapida() {
//        System.out.println("rutaMasRapida");
//        int zonaOrigen = 0;
//        int zonaDestino = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.rutaMasRapida(zonaOrigen, zonaDestino);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of informeZonas method, of class ISistema.
//     */
//    @Test
//    public void testInformeZonas() {
//        System.out.println("informeZonas");
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.informeZonas();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of zonasEnRadio method, of class ISistema.
//     */
//    @Test
//    public void testZonasEnRadio() {
//        System.out.println("zonasEnRadio");
//        int zonaID = 0;
//        int duracionViaje = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.zonasEnRadio(zonaID, duracionViaje);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registrarChofer method, of class ISistema.
//     */
//    @Test
//    public void testRegistrarChofer() {
//        System.out.println("registrarChofer");
//        String movilID = "";
//        String nombre = "";
//        String cedula = "";
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.registrarChofer(movilID, nombre, cedula);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarChofer method, of class ISistema.
//     */
//    @Test
//    public void testEliminarChofer() {
//        System.out.println("eliminarChofer");
//        String movilID = "";
//        String cedula = "";
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.eliminarChofer(movilID, cedula);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of informeChoferes method, of class ISistema.
//     */
//    @Test
//    public void testInformeChoferes() {
//        System.out.println("informeChoferes");
//        String movilID = "";
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.informeChoferes(movilID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registrarAbonado method, of class ISistema.
//     */
//    @Test
//    public void testRegistrarAbonado() {
//        System.out.println("registrarAbonado");
//        int abonadoID = 0;
//        String abonadoNombre = "";
//        String abonadoDireccion = "";
//        String abonadoTel = "";
//        int zonaID = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.registrarAbonado(abonadoID, abonadoNombre, abonadoDireccion, abonadoTel, zonaID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarAbonado method, of class ISistema.
//     */
//    @Test
//    public void testEliminarAbonado() {
//        System.out.println("eliminarAbonado");
//        int abonadoID = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.eliminarAbonado(abonadoID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of informeAbonadosZona method, of class ISistema.
//     */
//    @Test
//    public void testInformeAbonadosZona() {
//        System.out.println("informeAbonadosZona");
//        int zonaID = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.informeAbonadosZona(zonaID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of viaje method, of class ISistema.
//     */
//    @Test
//    public void testViaje() {
//        System.out.println("viaje");
//        int zonaDestino = 0;
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.viaje(zonaDestino);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of mostrarmapa method, of class ISistema.
//     */
//    @Test
//    public void testMostrarmapa() {
//        System.out.println("mostrarmapa");
//        ISistema instance = new ISistemaImpl();
//        Retorno expResult = null;
//        Retorno result = instance.mostrarmapa();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
