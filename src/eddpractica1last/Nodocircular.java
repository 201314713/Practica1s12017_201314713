/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddpractica1last;

/**
 *
 * @author dell
 */
public class Nodocircular {
    // Variable en la cual se va a guardar el valor.
    private String valor;
    // Variable para enlazar los nodos.
    private Nodocircular siguiente;
    /**
     * Constructor que inicializamos el valor de las variables.
     */
    public void Nodo(){
     //   this.valor = 0;
        this.siguiente = null;
    }
    
    // Métodos get y set para los atributos.
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Nodocircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodocircular siguiente) {
        this.siguiente = siguiente;
    }   
}