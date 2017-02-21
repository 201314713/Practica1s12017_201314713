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
public class ListaTablero {
    private NodoListaTablero mBase = null;
	public void borrarPorId(int pId){
		int pos = buscarPorId( pId );
		borrarPorPosicion( pos );
	}
	public void borrarPorPosicion(int pPos){
		NodoListaTablero temp = mBase;
		int pos = 0;
		if(mBase == null){
			return;
		}
		if(mBase.getSiguiente() == null){
			if( pos == pPos ){
				mBase = null;
			}
			return;
		}else{
			if(pPos == pos){
				mBase = mBase.getSiguiente();
					return;
			}
		}
		NodoListaTablero actual = mBase.getSiguiente();
		pos = 1;
		while(actual != null){
			if(pos == pPos){
				temp.setSiguiente(actual.getSiguiente());
				return;
			}
			pos++;
			temp = actual;
			actual = actual.getSiguiente();
		}	
	}
	public int getSize(){
		NodoListaTablero temp = mBase;
		int size = 0;
		while(temp != null){
			size++;
			temp = temp.getSiguiente();
		}
		return size;
	}
	public tablero getCarroPorPosicion(int pPos){
		NodoListaTablero temp = mBase;
		int size = 0;
		while( temp != null )	
		{
			if(size == pPos){
				return temp.getDato();
			}
			size++;
			temp = temp.getSiguiente();
		}	
		return null;
	}
	public int buscarPorId(int pId){
		NodoListaTablero temp = mBase;
		int pos = 0;
		while(temp != null){
			if(temp.getDato().getId() == pId){
				return pos;
			}
			pos++;
			temp = temp.getSiguiente();
		}	
		return -1;
	}
	public void insertarCarro(tablero pCarro){
		if(pCarro == null){
			return;
		}
		NodoListaTablero temp = new NodoListaTablero();
		temp.setDato(pCarro);
		if(mBase == null){
			mBase = temp;
			return;
		}
		temp.setSiguiente(mBase);
		mBase = temp;	
	}
	public void dPrint(){
		System.out.println(toString());
	}
	public String toString(){
		StringBuilder b = new StringBuilder();
		NodoListaTablero temp = mBase;
		
		while(temp != null){
			b.append( temp.toString() );
			b.append( "\n" );
			temp = temp.getSiguiente();
		}
		
		return b.toString();
	}
}