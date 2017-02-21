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
public class NodoListaTablero {
 //Clas Nodo
	private tablero mDato = null; //Carro: donde estan todos los datos del carro
	private NodoListaTablero mSiguiente = null; //apuntador siguiente
	private NodoListaTablero mAnterior = null;

    public NodoListaTablero getMAnterior() {
        return mAnterior;
    }

    public void setMAnterior(NodoListaTablero mAtras) {
        this.mAnterior = mAtras;
    }
	
	public NodoListaTablero(){
		//Constructor	
	}
	
	//Set y get del carro..con mDato
	public void setDato( tablero pCarro ){
		mDato = pCarro;
	}
	
	public tablero getDato(){
		return mDato;
	}
	//Set y get de el apuntador siguiente
	public void setSiguiente(NodoListaTablero pSiguiente){
		mSiguiente = pSiguiente;
	}
	
	public NodoListaTablero getSiguiente(){
		return mSiguiente;
	}
	
	//Concatena todos los datos en un String..
	public String toString(){
		if( mDato == null ){
			return "";
		}
		
		StringBuilder b = new StringBuilder();
		b.append( "NodoTablero[ " );
		b.append( mDato.toString() );
		b.append( " ]");
		return b.toString();
	}
}
