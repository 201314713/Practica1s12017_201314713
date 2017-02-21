/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddpractica1last;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Ortogonal {
//Nodo base... q va arriba de los años..y la izquierda de las marcas
	private NodoMatriz mBase = new NodoMatriz();
	ArrayList<Object> arreglo = new ArrayList();
	public Ortogonal(){
		
	}
	//metodo para imprimir el resultado
	public void dPrint(){
		//un temportal que este abajo de la base... o sea el q se va a manejar
		//por todas las fechas...
		NodoMatriz temp = mBase.getAbajo();
		NodoMatriz temp2 = null;
		///////////NodoMatriz temp2 = mBase.getDerecha();
		//while de la recorrido de fechas
		while(temp != null){
			System.out.println("FILA[ modelo = " + temp.getModelo() + " ]");
			temp2 = temp.getDerecha();
			//while de recorrido de las marcas
			while(temp2 != null){
				System.out.println("COLUMNA[ marca = " + temp2.getMarca() + " ]");
				temp2.dPrint();
				System.out.println("FINCOLUMNA[ marca = " + temp2.getMarca() + " ]\n" );
				temp2 = temp2.getDerecha();
			}
			System.out.println("FINFILA[ modelo = " + temp.getModelo() + " ]\n" );
			temp = temp.getAbajo();
		}
	}
/////////////////////////////////////////metodo para buscar la marca
	public NodoMatriz buscarPorMarca(String pMarca){
		NodoMatriz temp = mBase.getDerecha();
		
		while( temp != null ){
			if(temp.getMarca().compareToIgnoreCase(pMarca) == 0){
				System.out.println("Marca Encontrada " + pMarca );
				return temp;
			}
                        else{
                            System.out.println("Marca No encontrada " );
                        }
			temp = temp.getDerecha();
		}
		
		return null;
	}
/////////////////////////////////////metodo para buscar el modelo...
	public NodoMatriz buscarPorModelo(int pModelo){
		NodoMatriz temp = mBase.getAbajo();
		
		while(temp != null){
			if(temp.getModelo() == pModelo){
				return temp;
			}
			temp = temp.getAbajo();
		}
		
		return null;
	}
/////////////////////////////////////metodo de insercion
	public void insertar(String pClav, tablero pCarro){
		//Si la entrada viene vacia que no la meta...
		if(pCarro == null){
			return;
		}
		//para el nodo modelo
		int modelo = pCarro.getModelo();
		//para el nodo marca
		String marca = pCarro.getMarca();
		//un temporizador para el nodo base
		NodoMatriz temp = mBase;
		NodoMatriz tempIzq = mBase;
//////----------------------El ingreso de la primera vez------------------\\\\\\
                                 ///caso1///
		if(temp.getDerecha() == null && temp.getAbajo() == null){
			//Se crea el nodo del modelo, el de la marca y el del elemento
			NodoMatriz nodoModelo = new NodoMatriz();
			NodoMatriz nodoMarca = new NodoMatriz();
			NodoMatriz nodoElemento = new NodoMatriz();
			//Se le agregan sus datos a cada nodo
			nodoModelo.setModelo(modelo);
			nodoMarca.setMarca(marca);
			nodoElemento.agregarCarro(pCarro);
			//nodo modelo a punta al elemento y a la base
			nodoModelo.setDerecha(nodoElemento);
			nodoModelo.setArriba(temp);
			//la marca a punta al modelo y a la base
			nodoMarca.setAbajo(nodoElemento);
			nodoMarca.setIzquierda(temp);
			//el elemento a punta a la marca y al modelo
			nodoElemento.setArriba(nodoMarca);
			nodoElemento.setIzquierda(nodoModelo);
			// la base a punta al modelo y a la marca
			temp.setDerecha(nodoMarca);
			temp.setAbajo(nodoModelo);
			
			return;
		}
//------------------------------------------------------------------------------
	//se le pone temporal al nuevo nodo de la fecha...
		temp = mBase.getAbajo();
		//se le pone temporal al nuevo nodo de la marca...
		boolean hayModelo = false;
		//para saber si hay una misma marca ya repetida
		boolean hayMarca = false;
		while(temp != null){
			if(temp.getModelo() == modelo){
				hayModelo = true;
				break;		
			}
			temp = temp.getAbajo();
		}
		
////--------------------------Si hay uno igual.../******************************
	if(hayModelo==true){
		//el temporizador ya no es el modelo si no que el siguiente 
		temp = temp.getDerecha();
		hayMarca = false;
		//los recorre y mientras no sea null 
		while(temp != null){
                    /////Si en cuentra a uno que tambien sea de la misma marca
		    if(temp.getMarca().compareToIgnoreCase(marca) == 0){
			hayMarca = true;
			break;
		    }
		temp = temp.getDerecha();
		}
          ////Si es el mismo modelo y la misma marca..../**************************
                		///Caso2///
	  if(hayMarca==true){
		temp.agregarCarro(pCarro);
		return;
	  }
/***************************************************************************/			
				///Caso3///
	 else{
		NodoMatriz temp2 = mBase.getDerecha();
		NodoMatriz nodoMarca = new NodoMatriz();
		nodoMarca.setMarca(marca);
		NodoMatriz nodoElemento = new NodoMatriz();
                nodoElemento.agregarCarro(pCarro);
		boolean findebusqueda = false;
		while(temp2!=null){
			if(temp2.getDerecha()!=null){
				nodoMarca.setAbajo(nodoElemento);
				nodoMarca.setIzquierda(temp2);
				nodoElemento.setArriba(nodoMarca);
				temp2.setDerecha(nodoMarca);
				break;
			}
		temp2 = temp2.getDerecha();
		}
                temp = mBase.getAbajo();
		boolean hayModelo2 = false;
		NodoMatriz tempo = mBase.getAbajo();			
		while(tempo != null){
			if(tempo.getModelo() == modelo){
				hayModelo2 = true;
				break;		
			}
			tempo = tempo.getAbajo();
		}
		if(hayModelo2==true){
			NodoMatriz tempo2 = tempo.getDerecha();
			while(tempo2 != null){
				if(tempo2.getDerecha() == null){
					tempo2.setDerecha(nodoElemento);
					nodoElemento.setIzquierda(tempo2);
					break;
				}
			tempo2 = tempo2.getDerecha();
			}
		  }	
		  return;
		}
	}else{
		///////////////////////Caso4   y caso 5/////////////////////////
			// no hay modelo
			//temporizador esta en el primer modelo
        	NodoMatriz tempy = mBase.getAbajo();
		NodoMatriz nodoModelo = new NodoMatriz();
		nodoModelo.setModelo(modelo);
		NodoMatriz nodoElemento = new NodoMatriz();
		nodoElemento.agregarCarro(pCarro);		
		while(tempy != null){
			//caso5
			if(tempy.getModelo()>modelo){
				NodoMatriz antetempy = tempy.getArriba();
				nodoModelo.setAbajo(tempy);
				nodoModelo.setArriba(antetempy);
				nodoElemento.setIzquierda(nodoModelo);
				nodoModelo.setDerecha(nodoElemento);
				tempy.setArriba(nodoModelo);
				antetempy.setAbajo(nodoModelo);
				break;
			}else{
			//caso4
			if(tempy.getAbajo() == null){
				tempy.setAbajo(nodoModelo);
				nodoModelo.setArriba(tempy);
				nodoModelo.setDerecha(nodoElemento);
				nodoElemento.setIzquierda(nodoModelo);
				break;		
				}
			}
			tempy = tempy.getAbajo();
		}
		NodoMatriz tempo = mBase.getDerecha();
		while(tempo!=null){
			if(tempo.getMarca().compareToIgnoreCase(marca)==0){
				NodoMatriz tempus = tempo.getAbajo();
				if(tempus!=null){
					while(tempus!=null){
						if(tempus.getModelo()>modelo){
							NodoMatriz antetemp = tempus.getArriba();
							nodoElemento.setAbajo(tempus);
							nodoElemento.setArriba(antetemp);
							antetemp.setAbajo(nodoElemento);
							tempus.setArriba(nodoElemento);
							break;
						}
					tempus = tempus.getAbajo();
					}
					break;
				}else{
					nodoElemento.setArriba(tempus);
					tempus.setAbajo(nodoElemento);
					break;
				}
			}else{
				//caso6
				if(tempo.getDerecha()==null){
					NodoMatriz nodoMarca = new NodoMatriz();
					nodoMarca.setMarca(marca);
					tempo.setDerecha(nodoMarca);
					nodoMarca.setIzquierda(tempo);
					nodoMarca.setAbajo(nodoElemento);
					nodoElemento.setArriba(nodoMarca);
				}
			}
			tempo = tempo.getDerecha();
		}
		}
		return;
	}

public void insertar2(tablero pCarro){
	//Si la entrada viene vacia que no la meta...
	if(pCarro == null){
		return;
	}
	//para el nodo modelo
	int modelo = pCarro.getModelo();
	//para el nodo marca
	String marca = pCarro.getMarca();
	//un temporizador para el nodo base
	NodoMatriz temp = mBase;
	NodoMatriz tempIzq = mBase;
//////----------------------El ingreso de la primera vez------------------\\\\\\
                                ///caso1///
	if(temp.getDerecha() == null && temp.getAbajo() == null){
		//Se crea el nodo del modelo, el de la marca y el del elemento
		NodoMatriz nodoModelo = new NodoMatriz();
		NodoMatriz nodoMarca = new NodoMatriz();
		NodoMatriz nodoElemento = new NodoMatriz();
		//Se le agregan sus datos a cada nodo
		nodoModelo.setModelo(modelo);
		nodoMarca.setMarca(marca);
		nodoElemento.agregarCarro(pCarro);
		//nodo modelo a punta al elemento y a la base
		nodoModelo.setDerecha(nodoElemento);
		nodoModelo.setArriba(temp);
		//la marca a punta al modelo y a la base
		nodoMarca.setAbajo(nodoElemento);
		nodoMarca.setIzquierda(temp);
		//el elemento a punta a la marca y al modelo
		nodoElemento.setArriba(nodoMarca);
		nodoElemento.setIzquierda(nodoModelo);
		// la base a punta al modelo y a la marca
		temp.setDerecha(nodoMarca);
		temp.setAbajo(nodoModelo);
        	return;
	}
//------------------------------------------------------------------------------
        //se le pone temporal al nuevo nodo de la fecha...
	temp = mBase.getAbajo();
	//se le pone temporal al nuevo nodo de la marca...
	boolean hayModelo = false;
	//para saber si hay una misma marca ya repetida
	boolean hayMarca = false;
	while(temp != null){
		if(temp.getModelo() == modelo){
			hayModelo = true;
			break;		
		}
	temp = temp.getAbajo();
	}
////--------------------------Si hay uno igual.../******************************
	if(hayModelo==true){
		//el temporizador ya no es el modelo si no que el siguiente 
		temp = temp.getDerecha();
		hayMarca = false;
		//los recorre y mientras no sea null 
		while(temp != null){
                    /////Si en cuentra a uno que tambien sea de la misma marca
                    if(temp.getMarca().compareToIgnoreCase(marca) == 0){
			hayMarca = true;
			break;
                    }
		temp = temp.getDerecha();
		}
////Si es el mismo modelo y la misma marca..../**************************
							///Caso2///
		if(hayMarca==true){
			temp.agregarCarro(pCarro);
			return;
		}
/***************************************************************************/			
							///Caso3///
	else{
		NodoMatriz temp2 = mBase.getDerecha();
		NodoMatriz nodoMarca = new NodoMatriz();
                nodoMarca.setMarca(marca);
		NodoMatriz nodoElemento = new NodoMatriz();
		nodoElemento.agregarCarro(pCarro);
		boolean findebusqueda = false;
		while(temp2!=null){
			if(temp2.getDerecha()!=null){
        			nodoMarca.setAbajo(nodoElemento);
				nodoMarca.setIzquierda(temp2);
                		nodoElemento.setArriba(nodoMarca);
				temp2.setDerecha(nodoMarca);
				break;
			}
		temp2 = temp2.getDerecha();
		}
		temp = mBase.getAbajo();
		boolean hayModelo2 = false;
		NodoMatriz tempo = mBase.getAbajo();			
		while(tempo != null){
			if(tempo.getModelo() == modelo){
				hayModelo2 = true;
				break;		
			}
		tempo = tempo.getAbajo();
		}
		if(hayModelo2==true){
			NodoMatriz tempo2 = tempo.getDerecha();
			while(tempo2 != null){
                		if(tempo2.getDerecha() == null){
					tempo2.setDerecha(nodoElemento);
					nodoElemento.setIzquierda(tempo2);
					break;
				}
			tempo2 = tempo2.getDerecha();
                	}
		  }	
		  return;
		}
	}else{
		///////////////////////Caso4   y caso 5/////////////////////////
			// no hay modelo
			//temporizador esta en el primer modelo
		NodoMatriz tempy = mBase.getAbajo();
		NodoMatriz nodoModelo = new NodoMatriz();
		nodoModelo.setModelo(modelo);
		NodoMatriz nodoElemento = new NodoMatriz();
		nodoElemento.agregarCarro(pCarro);		
		while(tempy != null){
			//caso5
			if(tempy.getModelo()>modelo){
				NodoMatriz antetempy = tempy.getArriba();
				nodoModelo.setAbajo(tempy);
				nodoModelo.setArriba(antetempy);
				nodoElemento.setIzquierda(nodoModelo);
				nodoModelo.setDerecha(nodoElemento);
				tempy.setArriba(nodoModelo);
				antetempy.setAbajo(nodoModelo);
				break;
			}else{
			//caso4
			if(tempy.getAbajo() == null){
				tempy.setAbajo(nodoModelo);
				nodoModelo.setArriba(tempy);
				nodoModelo.setDerecha(nodoElemento);
				nodoElemento.setIzquierda(nodoModelo);
				break;		
				}
			}
			tempy = tempy.getAbajo();
		}
		NodoMatriz tempo = mBase.getDerecha();
		while(tempo!=null){
			if(tempo.getMarca().compareToIgnoreCase(marca)==0){
				NodoMatriz tempus = tempo.getAbajo();
				if(tempus!=null){
					while(tempus!=null){
						if(tempus.getModelo()>modelo){
							NodoMatriz antetemp = tempus.getArriba();
							nodoElemento.setAbajo(tempus);
							nodoElemento.setArriba(antetemp);
							antetemp.setAbajo(nodoElemento);
							tempus.setArriba(nodoElemento);
							break;
						}
					tempus = tempus.getAbajo();
					}
					break;
				}else{
					nodoElemento.setArriba(tempus);
					tempus.setAbajo(nodoElemento);
					break;
				}
			}else{
				//caso6
				if(tempo.getDerecha()==null){
					NodoMatriz nodoMarca = new NodoMatriz();
					nodoMarca.setMarca(marca);
					tempo.setDerecha(nodoMarca);
					nodoMarca.setIzquierda(tempo);
					nodoMarca.setAbajo(nodoElemento);
					nodoElemento.setArriba(nodoMarca);
				}
			}
			tempo = tempo.getDerecha();
		}
		}
		return;
	}
	public void Buscar(String pmarca, int pmodelo){
		//NodoMatriz temp = mBase.getDerecha();
		NodoMatriz tempo = mBase.getAbajo();
		System.out.println("Se ingreso al metodo");
			while(tempo!=null){
				if(tempo.getModelo()==pmodelo){
					System.out.println("adios");
					break;
				}
			}
	}

}
