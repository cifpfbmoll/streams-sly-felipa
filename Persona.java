/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionarpractica7;

import java.io.Serializable;

/**
 *
 * @author sly
 */
public class Persona implements Serializable{
    
    private static final long serialVersionUID =1L;
    private String nombre;
    private int edad;
    private String dni;
    public Persona (String nombre, int edad, String dni){
    super();
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }
    
    
}
