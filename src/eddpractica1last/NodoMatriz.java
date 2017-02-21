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
public class NodoMatriz {
//Direccionamiento de la matriz con el movimiento de los nodos...
	private NodoMatriz mArriba = null;
	private NodoMatriz mAbajo = null;
	private NodoMatriz mDerecha = null;
	private NodoMatriz mIzquierda = null;
	
	private String mMarca = "";
	private int mModelo = 0;
	
	private ListaTablero mElementos = null;
	
	public NodoMatriz(){
		//Constructor
	}
		//Los set y gets...
	public void setMarca(String pMarca){
		mMarca = pMarca;
	}
	
	public String getMarca(){
		return mMarca;	
	}
	
	public void setModelo(int pModelo){
		mModelo = pModelo;
	}
	
	public int getModelo(){
		return mModelo;
	}
	
		
	public void dPrint(){
		if(mElementos != null){
			mElementos.dPrint();
		}
	}
	//agragar los carros...pero como nodos.. nodo donde estan los datos mElementos
	//nodo donde esta el modelo
	//nodo donde esta la marca
	public void agregarCarro(tablero pCarro){
		
		if(pCarro == null){
			return;
		}
		
		if(mElementos == null){
			mModelo = pCarro.getModelo();
			mMarca = pCarro.getMarca();
			mElementos = new ListaTablero();
		}
		
		mElementos.insertarCarro(pCarro);
	}
	
	//set y gets....
	public void setElementos(ListaTablero pElementos){
		mElementos = pElementos;
	}
	
	public ListaTablero getElementos(){
		return mElementos;
	}
	
	public void setArriba(NodoMatriz pArriba){
		mArriba = pArriba;
	}
	
	public void setAbajo(NodoMatriz pAbajo){
		mAbajo = pAbajo;
	}
	
	public void setDerecha(NodoMatriz pDerecha){
		mDerecha = pDerecha;
	}
	
	public void setIzquierda(NodoMatriz pIzquierda){
		mIzquierda = pIzquierda;
	}
	
	public NodoMatriz getArriba(){
		return mArriba;
	}
	
	public NodoMatriz getAbajo(){
		return mAbajo;
	}
	
	public NodoMatriz getDerecha(){
		return mDerecha;
	}
	
	public NodoMatriz getIzquierda(){
		return mIzquierda;
	}

}
