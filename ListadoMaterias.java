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
//Clase Especial enum ListadoMaterias
public enum ListadoMaterias {
    Pociones(1,"Pociones"),
    Artes(2,"Defensa Contra las Artes Oscuras"),
    Adivinacion(3,"Adivinación"),
    Astro(4,"Astronomía"),
    Historia(5,"Historia de la Magia"),
    Herbo(6,"Herbología"),
    Encantamiento(7,"Encantamientos"),
    Vuelo(8,"Vuelo");
    
	//Declaracion de atributos
    private final int num;
    private final String materia;
    
	//Método ListadoMaterias
    private ListadoMaterias(int num, String materia) {
        this.num = num;
        this.materia = materia;
    }
	
	//Declaracion de los get and set de los atributos 
    public String getMateria() {
		return materia;
	}

    public int getNumero() {
            return num;
    }	
	
	//Sobreescribiendo el método toString
    @Override
    public String toString(){
    return num+"."+" "+materia;
    }  
}
