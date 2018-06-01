/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

/**
 *
 * @author alber
 */
public interface IlistaZonas {

    public boolean esVacia();

    public Retorno.Resultado agregarInicio(String dato);

    public void borrarInicio();

    public void agregarFinal(String dato);

    public void borrarFin();

    public void vaciar();

    public void mostrar();

    public NodoZona obtenerElemento(String dato);

    public int cantElementos();
}
