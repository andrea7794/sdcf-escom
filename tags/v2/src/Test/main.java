package Test;
import Model.knn;
/*
Algoritmo Knn

Este algoritmo nos sirve al tener un conjunto de caracteristicas de varias empresas, poderlas procesar
y obtener la distancia de cada una de ellas en base al un valor que se le manda. Ese valor es que queremos
que nos diga en donde quedaria más acorde.

Constructor knn:
knn(String muestras,String valor,int k)

String muestras: son un conjunto de muestras que se seleccionan para que el algoritmo trabaje con ellas.
Formato: b,i,e,-,b,i,e,-,b,i,e,-,...

Donde:	

b = bandera
i= ingreso
e = egreso
- = es un separador "-"

String valor: son los valores que queremos evaluar
Formato: i,e

Donde: 
i = ingreso
e = egreso

int k: este valor nos indica el numero de distancias que va tomar en cuenta para la decisión
NOTA: este valor debe ser siempre menor a la cantidad de elementos de muestras.

Ejemplo:

muestras:0,234,342,-,0,325,24,-,1,535,646,-,1,567,345,-

Si le agregamos k=5 no podrá ejecutar ya que las distancias que va obtener seran de cuatro elementos




*/
public class main {

	
	public static void main(final String[] args) {
		System.out.println("Inicio");
		String muestras = "1,100,20,-,1,108,15,-,1,121,25,-,0,148,35,-,0,140,42,-,0,155,30,-";
		String valor = "100,20";
		knn ini = new knn(muestras,valor,3);
		System.out.println(ini.iniciar());
		
		
		
		
		
		
		
		
	}

}
