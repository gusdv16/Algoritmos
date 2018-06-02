package obligatorio;

import static obligatorio.metodos.*;

public class ZonaMovilChofer {

    public static void main(String[] args) {
        ListaZona lz = new ListaZona();

        //COMPARETO()
//        String val1 = "Lol";
//        String val2 = "Lol";
//        String val3 = "Loa";
//
//        System.out.println("\n" + val1.compareTo(val2));//0 igual
//        System.out.println("\n" + val1.compareTo(val3));//1 mayor
//        System.out.println("\n" + val3.compareTo(val2));//-1 menor
        System.out.println("\n" + "Movil 4".compareTo("Movil 2"));//-1 mayor

        lz.agregarInicio("Zona 1");
        lz.getInicio().getLm().agregarOrd("  Movil 3");
        lz.getInicio().getLm().agregarOrd("  Movil 1");
        lz.getInicio().getLm().agregarOrd("  Mavil 1");
        lz.getInicio().getLm().agregarOrd("  Movil 4");
        lz.getInicio().getLm().agregarOrd("  Movil 2");
        lz.agregarInicio("Zona 2");
        lz.getInicio().getLm().agregarOrd("  Movil 20");
        lz.getInicio().getLm().agregarOrd("  Movil 21");
        lz.agregarInicio("Zona 3");
        lz.getInicio().getLm().agregarOrd("  Movil 31");
        lz.getInicio().getLm().agregarOrd("  Movil 32");

        agregarMovilAZona(lz, "Zona 2", "  Movil 99");
        mostrarZonasCompleto(lz);
        System.out.println("\n-----------------");
        System.out.println("Muevo Zona");
        System.out.println("-----------------");
        viaje(lz, "Zona 2", "Zona 1", "  Movil 99");
        mostrarZonasCompleto(lz);
    }

}
