package escom.tds.algoritmo;

import java.util.ArrayList;
import java.util.List;

public class caract_knn implements Comparable{
	
	List<Double> caracteristicas;
	String clase;
	int num;
	String distancia;	//Se dejo esta variable como String ya que es mejor ordenarla de esa forma
	

	//Constructor 1
	public caract_knn(){
		caracteristicas = new ArrayList<Double>();
		num=0;
		clase = "n/a";
	}
	
	//Constructor 2
	public caract_knn(List<Double> cara, String clase, int num){
		this.caracteristicas = cara;
		this.clase = clase;
		this.num = num;
	}
	
	//Agrega los atributos
	public void setAtributo(double at){
		caracteristicas.add(at);
		num++;
	}
	
	//Agrega el nombre de la clase
	public void setClase(String clas){
		this.clase = clas;
		
	}
	
	//Agrega Distancia
	public void setDistancia(double dis){
		
		this.distancia = String.valueOf(dis);
	}
	
	//Obtiene distancia
	public String getDistancia(){
		return this.distancia;
	}
	
	//Obtiene Atributo
	public double getAtributo(int id){
		return caracteristicas.get(id);
	}
	
	//Imprime todos los argumentos de la clase
	public void imprimir(){
		
		System.out.print(clase+" = ");
		for(int i=0;i<num;i++){
			System.out.print(caracteristicas.get(i));
			System.out.print(", ");
		}
		System.out.println();
	}

	//metodo sobreescrito para poder compararla en base a la distancia
	@Override
	public int compareTo(Object o) {
		caract_knn cara= (caract_knn)o;
		
		return this.distancia.compareTo(cara.distancia);
		
	}
	
	
}
