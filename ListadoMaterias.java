/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Pc
 */
public enum ListadoMaterias {
    Pociones(1,"Pociones"),
    Artes(2,"Defensa Contra las Artes Oscuras"),
    Adivinacion(3,"Adivinación"),
    Astro(4,"Astronomía"),
    Historia(5,"Historia de la Magia"),
    Herbo(6,"Herbología"),
    Encantamiento(7,"Encantamientos"),
    Vuelo(8,"Vuelo");
    
    private final int num;
    private final String materia;
    
    private ListadoMaterias(int num, String materia) {
        this.num = num;
        this.materia = materia;
    }
    
    @Override
    public String toString(){
    return num+"."+" "+materia;
    }  
}
