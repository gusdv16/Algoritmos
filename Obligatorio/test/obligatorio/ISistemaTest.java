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

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

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
        assertEquals(Retorno.Resultado.ERROR_1, sis.crearSistemaEmergencias(0).resultado);

        assertEquals(Retorno.Resultado.OK, sis.crearSistemaEmergencias(7).resultado);

        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Pocitos").resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Punta Carretas").resultado);

        assertEquals(Retorno.Resultado.ERROR_2, sis.agregarZona("Punta Carretas").resultado);

        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Parque Rodo").resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Buceo").resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Malvin").resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Colon").resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarZona("Centro").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.agregarZona("Ciudad Vieja").resultado);
        //
        assertEquals(Retorno.Resultado.OK, sis.listarZonas().resultado.OK);
        //

        assertEquals(Retorno.Resultado.OK, sis.agregarRuta(1, 4, 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarRuta(2, 4, 3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarRuta(2, 3, 5).resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarRuta(3, 5, 7).resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarRuta(4, 5, 1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarRuta(3, 6, 8).resultado);
        assertEquals(Retorno.Resultado.OK, sis.agregarRuta(7, 5, 3).resultado);

        //mostrar mapa
        assertEquals(Retorno.Resultado.ERROR_1, sis.agregarRuta(10, 5, 3).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.agregarRuta(1, 45, 3).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.agregarRuta(1, 6, 0).resultado);

        //
        assertEquals(Retorno.Resultado.OK, sis.modificarDemora(1, 4, 1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.modificarDemora(2, 4, 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.modificarDemora(8, 4, 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.modificarDemora(1, 9, 5).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.modificarDemora(1, 4, 0).resultado);
        assertEquals(Retorno.Resultado.OK, sis.modificarDemora(1, 4, 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.modificarDemora(2, 4, 3).resultado);

        //mostrar mapa
        //
        assertEquals(Retorno.Resultado.OK, sis.rutaMasRapida(1, 4).resultado);
        assertEquals(Retorno.Resultado.OK, sis.rutaMasRapida(1, 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.rutaMasRapida(2, 5).resultado);

        assertEquals(Retorno.Resultado.ERROR_2, sis.rutaMasRapida(9, 4).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.rutaMasRapida(1, 9).resultado);
        //
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS101", 1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS102", 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS103", 3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS104", 4).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS105", 5).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS106", 6).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS108", 1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS109", 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS110", 3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS111", 4).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS112", 5).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS113", 6).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS115", 1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarMovil("PCS116", 2).resultado);

        assertEquals(Retorno.Resultado.ERROR_1, sis.registrarMovil("PCS117", 9).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.registrarMovil("PCS116", 3).resultado);
        //

        assertEquals(Retorno.Resultado.OK, sis.informeZonas().resultado);
        //

        assertEquals(Retorno.Resultado.OK, sis.zonasEnRadio(1, 6).resultado);
        assertEquals(Retorno.Resultado.OK, sis.zonasEnRadio(2, 8).resultado);

        assertEquals(Retorno.Resultado.ERROR_1, sis.zonasEnRadio(9, 8).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.zonasEnRadio(2, 0).resultado);
        //

        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS101", "Alberto Pedrosa", "1.554.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS102", "Esteban Gonzalez", "2.554.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS103", "Laura Martinez", "3.554.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS104", "Jacinto Lodeiro", "4.554.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS105", "Martin Jackson", "5.554.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS106", "Maria Ruiz", "6.554.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS108", "Hermenegildo Diaz", "7.554.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS109", "Patricia Beltran", "8.554.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS110", "Marcelo Micino", "9.554.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS111", "Jorge Gentile", "4.154.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS112", "Anibal Feldman", "4.254.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS113", "Leonardo Madrigal", "4.354.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS115", "Leandro Silvera", "4.454.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS116", "Lucia Olivera", "4.554.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS101", "Carlos Larrañaga", "4.654.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS101", "Sebastian Vazquez", "4.754.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS101", "Pablo Rossi", "4.854.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS102", "Susana Rivera", "4.954.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS102", "Bruno Perez", "4.504.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarChofer("PCS103", "Luis Suarez", "4.514.89-1").resultado);
        //choferes con error

        assertEquals(Retorno.Resultado.ERROR_1, sis.registrarChofer("PCS125", "Luis Suarez", "4.514.19-1").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.registrarChofer("PCS143", "Luis Suarez", "4.514.29-1").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.registrarChofer("PCS153", "Luis Suarez", "4.514.89-1").resultado);
        //
        assertEquals(Retorno.Resultado.OK, sis.eliminarChofer("PCS101", "4.854.89-1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.eliminarChofer("PCS102", "4.504.89-1").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarChofer("PCS152", "4.504.89-1").resultado);
        //
        assertEquals(Retorno.Resultado.OK, sis.informeChoferes("PCS101").resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeChoferes("PCS102").resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeChoferes("PCS103").resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeChoferes("PCS104").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.informeChoferes("PCS134").resultado);
        //

        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(2, "Alberto Pedrosa", "Cuareim 1134", "24001115", 1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(3, "ACIEN ZURUTA ROSA MARIA", "Paraguay 1134", "24001115", 1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(4, "ALBUSAC TAMARGO DANIEL", "Avenida Italia 1134", "24001115", 1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(5, "ALONSO BECERRA JOSE", "Carlos Quijano 1134", "24001115", 1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(6, "AMAT MENA SUSANA", "Canelones 1134", "24001115", 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(7, "AMATE GARRIDO IRENE", "Maldonado 1134", "24001115", 3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(8, "APARICIO GARCIA MAGDALENA", "Cibils 1134", "24001115", 4).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(9, "BENAYAS PEREZ NATALIA", "8 de octubre 1134", "24001115", 5).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(10, "BERNABE CASANOVA FRANCISCO CESAR", "Joanico 1134", "24001115", 6).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(11, "BERNAL RUIZ ENCARNACION", "Arrieta 1134", "24001115", 7).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(12, "CACERES CONTRERAS MARIA DEL MAR", "Boulevard Artigas 1134", "24001115", 7).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(13, "CAMPOS VIQUE MARIA BELEN", "Itapeby 1134", "24001115", 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(14, "CARREÑO NAVARRO MONICA", "Gustavo Gallinal 1134", "24001115", 2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(15, "CARRERA BENITEZ SUSANA", "Convencion 1134", "24001115", 3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(16, "CASAS GARCIA MARIA ESPERANZA", "Rio Negro 1134", "24001115", 3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(17, "CASTELLS GALLEGO MARAI DEL TISCAR", "Durazno 1134", "24001115", 4).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(18, "CASTILLO ALARCON ISABEL", "Andes 1134", "24001115", 4).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarAbonado(19, "CASTILLO GALDEANO ELENA MARIA", "Rincon 1134", "24001115", 4).resultado);
        
        assertEquals(Retorno.Resultado.OK, sis.eliminarAbonado(15).resultado);
        assertEquals(Retorno.Resultado.OK, sis.eliminarAbonado(5).resultado);

        assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarAbonado(35).resultado);
        //

        assertEquals(Retorno.Resultado.OK, sis.informeAbonadosZona(1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeAbonadosZona(2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeAbonadosZona(3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeAbonadosZona(4).resultado);

        assertEquals(Retorno.Resultado.ERROR_1, sis.informeAbonadosZona(34).resultado);

        //
        assertEquals(Retorno.Resultado.OK, sis.deshabilitarMovil("PCS101").resultado);
        assertEquals(Retorno.Resultado.OK, sis.deshabilitarMovil("PCS105").resultado);

        //UDF.ViajeEmergencia(7);
        assertEquals(Retorno.Resultado.OK, sis.viaje("PCS112", 3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.habilitarMovil("PCS101").resultado);
        //NUNCA CAMBIA AL ESTADO EMERGENCIA
        assertEquals(Retorno.Resultado.ERROR_3, sis.habilitarMovil("PCS112").resultado);

        assertEquals(Retorno.Resultado.ERROR_3, sis.deshabilitarMovil("PCS112").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.habilitarMovil("PCS141").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.habilitarMovil("PCS108").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.deshabilitarMovil("PCS141").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.deshabilitarMovil("PCS105").resultado);
        assertEquals(Retorno.Resultado.OK, sis.eliminarMovil("PCS115").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.eliminarMovil("PCS141").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.eliminarMovil("PCS112").resultado);
        assertEquals(Retorno.Resultado.OK, sis.cambiarUbicacion("PCS112", 3).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.cambiarUbicacion("PCS141", 2).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.cambiarUbicacion("PCS111", 40).resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeMovil(1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeMovil(2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeMovil(3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeMovil(4).resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeMovil(5).resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeMovil(6).resultado);
        //FALTA EL ORDENAR LISTADO//
        assertEquals(Retorno.Resultado.OK, sis.informeMovil(7).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.informeMovil(9).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.informeMovil(29).resultado);
        assertEquals(Retorno.Resultado.OK, sis.informeMovil().resultado);

        assertEquals(Retorno.Resultado.OK, sis.buscarMovil("PCS112").resultado);

        assertEquals(Retorno.Resultado.ERROR_1, sis.buscarMovil("PCS132").resultado);

        assertEquals(Retorno.Resultado.OK, sis.movilMasCercano(1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.movilMasCercano(2).resultado);
        assertEquals(Retorno.Resultado.OK, sis.movilMasCercano(3).resultado);
        assertEquals(Retorno.Resultado.OK, sis.movilMasCercano(4).resultado);
        assertEquals(Retorno.Resultado.OK, sis.movilMasCercano(5).resultado);
        assertEquals(Retorno.Resultado.OK, sis.movilMasCercano(6).resultado);
        assertEquals(Retorno.Resultado.OK, sis.movilMasCercano(7).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.movilMasCercano(9).resultado);
    }

    /**
     * Test of destruirSistemaEmergencias method, of class ISistema.
     */
    @Test
    public void testDestruirSistemaEmergencias() {
        System.out.println("destruirSistemaEmergencias");
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.destruirSistemaEmergencias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarMovil method, of class ISistema.
     */
    @Test
    public void testRegistrarMovil() {
        System.out.println("registrarMovil");
        String movilID = "";
        int zonaID = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.registrarMovil(movilID, zonaID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deshabilitarMovil method, of class ISistema.
     */
    @Test
    public void testDeshabilitarMovil() {
        System.out.println("deshabilitarMovil");
        String movilID = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.deshabilitarMovil(movilID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of habilitarMovil method, of class ISistema.
     */
    @Test
    public void testHabilitarMovil() {
        System.out.println("habilitarMovil");
        String movilID = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.habilitarMovil(movilID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarMovil method, of class ISistema.
     */
    @Test
    public void testEliminarMovil() {
        System.out.println("eliminarMovil");
        String movilID = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.eliminarMovil(movilID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarMovil method, of class ISistema.
     */
    @Test
    public void testBuscarMovil() {
        System.out.println("buscarMovil");
        String movilID = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.buscarMovil(movilID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of informeMovil method, of class ISistema.
     */
    @Test
    public void testInformeMovil_0args() {
        System.out.println("informeMovil");
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.informeMovil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of informeMovil method, of class ISistema.
     */
    @Test
    public void testInformeMovil_int() {
        System.out.println("informeMovil");
        int zonaID = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.informeMovil(zonaID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarUbicacion method, of class ISistema.
     */
    @Test
    public void testCambiarUbicacion() {
        System.out.println("cambiarUbicacion");
        String movilID = "";
        int zonaID = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.cambiarUbicacion(movilID, zonaID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarZona method, of class ISistema.
     */
    @Test
    public void testAgregarZona() {
        System.out.println("agregarZona");
        String zonaNombre = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.agregarZona(zonaNombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarZonas method, of class ISistema.
     */
    @Test
    public void testListarZonas() {
        System.out.println("listarZonas");
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.listarZonas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarRuta method, of class ISistema.
     */
    @Test
    public void testAgregarRuta() {
        System.out.println("agregarRuta");
        int zonaOrigen = 0;
        int zonaDestino = 0;
        int minutosViaje = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.agregarRuta(zonaOrigen, zonaDestino, minutosViaje);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarDemora method, of class ISistema.
     */
    @Test
    public void testModificarDemora() {
        System.out.println("modificarDemora");
        int zonaOrigen = 0;
        int zonaDestino = 0;
        int minutosViaje = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.modificarDemora(zonaOrigen, zonaDestino, minutosViaje);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of movilMasCercano method, of class ISistema.
     */
    @Test
    public void testMovilMasCercano() {
        System.out.println("movilMasCercano");
        int zonaID = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.movilMasCercano(zonaID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rutaMasRapida method, of class ISistema.
     */
    @Test
    public void testRutaMasRapida() {
        System.out.println("rutaMasRapida");
        int zonaOrigen = 0;
        int zonaDestino = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.rutaMasRapida(zonaOrigen, zonaDestino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of informeZonas method, of class ISistema.
     */
    @Test
    public void testInformeZonas() {
        System.out.println("informeZonas");
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.informeZonas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zonasEnRadio method, of class ISistema.
     */
    @Test
    public void testZonasEnRadio() {
        System.out.println("zonasEnRadio");
        int zonaID = 0;
        int duracionViaje = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.zonasEnRadio(zonaID, duracionViaje);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarChofer method, of class ISistema.
     */
    @Test
    public void testRegistrarChofer() {
        System.out.println("registrarChofer");
        String movilID = "";
        String nombre = "";
        String cedula = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.registrarChofer(movilID, nombre, cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarChofer method, of class ISistema.
     */
    @Test
    public void testEliminarChofer() {
        System.out.println("eliminarChofer");
        String movilID = "";
        String cedula = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.eliminarChofer(movilID, cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of informeChoferes method, of class ISistema.
     */
    @Test
    public void testInformeChoferes() {
        System.out.println("informeChoferes");
        String movilID = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.informeChoferes(movilID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarAbonado method, of class ISistema.
     */
    @Test
    public void testRegistrarAbonado() {
        System.out.println("registrarAbonado");
        int abonadoID = 0;
        String abonadoNombre = "";
        String abonadoDireccion = "";
        String abonadoTel = "";
        int zonaID = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.registrarAbonado(abonadoID, abonadoNombre, abonadoDireccion, abonadoTel, zonaID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAbonado method, of class ISistema.
     */
    @Test
    public void testEliminarAbonado() {
        System.out.println("eliminarAbonado");
        int abonadoID = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.eliminarAbonado(abonadoID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of informeAbonadosZona method, of class ISistema.
     */
    @Test
    public void testInformeAbonadosZona() {
        System.out.println("informeAbonadosZona");
        int zonaID = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.informeAbonadosZona(zonaID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viaje method, of class ISistema.
     */
    @Test
    public void testViaje() {
        System.out.println("viaje");
        String movilID = "";
        int zonaDestino = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.viaje(movilID, zonaDestino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarmapa method, of class ISistema.
     */
    @Test
    public void testMostrarmapa() {
        System.out.println("mostrarmapa");
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.mostrarmapa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ISistemaImpl implements ISistema {

        public Retorno crearSistemaEmergencias(int cantzonas) {
            return null;
        }

        public Retorno destruirSistemaEmergencias() {
            return null;
        }

        public Retorno registrarMovil(String movilID, int zonaID) {
            return null;
        }

        public Retorno deshabilitarMovil(String movilID) {
            return null;
        }

        public Retorno habilitarMovil(String movilID) {
            return null;
        }

        public Retorno eliminarMovil(String movilID) {
            return null;
        }

        public Retorno buscarMovil(String movilID) {
            return null;
        }

        public Retorno informeMovil() {
            return null;
        }

        public Retorno informeMovil(int zonaID) {
            return null;
        }

        public Retorno cambiarUbicacion(String movilID, int zonaID) {
            return null;
        }

        public Retorno agregarZona(String zonaNombre) {
            return null;
        }

        public Retorno listarZonas() {
            return null;
        }

        public Retorno agregarRuta(int zonaOrigen, int zonaDestino, int minutosViaje) {
            return null;
        }

        public Retorno modificarDemora(int zonaOrigen, int zonaDestino, int minutosViaje) {
            return null;
        }

        public Retorno movilMasCercano(int zonaID) {
            return null;
        }

        public Retorno rutaMasRapida(int zonaOrigen, int zonaDestino) {
            return null;
        }

        public Retorno informeZonas() {
            return null;
        }

        public Retorno zonasEnRadio(int zonaID, int duracionViaje) {
            return null;
        }

        public Retorno registrarChofer(String movilID, String nombre, String cedula) {
            return null;
        }

        public Retorno eliminarChofer(String movilID, String cedula) {
            return null;
        }

        public Retorno informeChoferes(String movilID) {
            return null;
        }

        public Retorno registrarAbonado(int abonadoID, String abonadoNombre, String abonadoDireccion, String abonadoTel, int zonaID) {
            return null;
        }

        public Retorno eliminarAbonado(int abonadoID) {
            return null;
        }

        public Retorno informeAbonadosZona(int zonaID) {
            return null;
        }

        public Retorno viaje(String movilID, int zonaDestino) {
            return null;
        }

        public Retorno mostrarmapa() {
            return null;
        }
    }

}


