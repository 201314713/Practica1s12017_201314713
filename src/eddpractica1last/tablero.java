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
public class tablero {
    private int mId = 0;
	private int mModelo = 0;
	private String mMarca = "";
	private String mColor = "";
	
	private String mEstilo = "";
	private int mMotor = 0;
	private String mCombustible = "";
	private String mFechaInicio = "";
	private String mFechaFin = "";
	private String mFoto = "";
	
	public tablero(){
		
	}
	
	public String toString(){
	//Para que una todo en una cadena...
		StringBuilder b = new StringBuilder();
		b.append( "Letras[ " );
		b.append( mId );
		b.append( " , " );
		b.append( mModelo );
		
		b.append( " ]" );
		return b.toString();
	}
	//Todos los set y get de Id, Modelo, Marca y Color
	public void setId(int pId){
		mId = pId;	
	}
	
	public int getId(){
		return mId;	
	}
	
	public void setModelo( int pModelo ){
		mModelo = pModelo;
	}
	
	public int getModelo(){
		return mModelo;
	}
	
	public void setMarca( String pMarca ){
		mMarca = pMarca;
	}
	
	public String getMarca(){
		return mMarca;	
	}
	
	public void setEstilo( String pEstilo ){
		mEstilo = pEstilo;
	}
	
	public String getEstilo(){
		return mEstilo;	
	}
	
	public void setFechaInicio( String pFechaInicio ){
		mFechaInicio = pFechaInicio;
	}
	
	public String getFechaInicio(){
		return mFechaInicio;	
	}
	
	public void setFechaFin( String pFechaFin ){
		mFechaFin = pFechaFin;
	}
	
	public String getFechaFin(){
		return mFechaFin;	
	}
	public void setColor( String pColor ){
		mColor = pColor;
	}
	
	public String getColor(){
		return mColor;	
	}
	public void setMotor( int pMotor ){
		mMotor = pMotor;
	}
	public int getMotor(){
		return mMotor;	
	}
	public void setCombustible( String pCombustible ){
		mCombustible = pCombustible;
	}
	public String getCombustible(){
		return mCombustible;	
	}
	public void setFoto( String pFoto ){
		mFoto = pFoto;
	}
	
	public String getFoto(){
		return mFoto;	
	}
}