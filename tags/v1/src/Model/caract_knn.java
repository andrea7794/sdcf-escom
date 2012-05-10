package Model;

import java.util.ArrayList;
import java.util.List;

public class caract_knn implements Comparable{
	
	List<Double> caracteristicas;
	String clase;
	int num;
	String distancia;	//Se dejo esta valiable como String ya que es mejor ordenarla de esa forma
	

	public caract_knn(){
	
		caracteristicas = new ArrayList<Double>();
		num=0;
		clase = "n/a";
	}
	
	public caract_knn(List cara, String clase, int num){
		this.caracteristicas = cara;
		this.clase = clase;
		this.num = num;
	}
	
	public void setAtributo(double at){
		caracteristicas.add(at);
		num++;
	}
	
	public void setClase(String clas){
		this.clase = clas;
		
	}
	
	public void setDistancia(double dis){
		
		this.distancia = String.valueOf(dis);
	}
	
	public String getDistancia(){
		return this.distancia;
	}
	
	public double getAtributo(int id){
		return caracteristicas.get(id);
	}
	
	public void imprimir(){
		
		System.out.print(clase+" = ");
		for(int i=0;i<num;i++){
			System.out.print(caracteristicas.get(i));
			System.out.print(", ");
		}
		System.out.println();
	}

	@Override
	public int compareTo(Object o) {
		caract_knn cara= (caract_knn)o;
		
		return this.distancia.compareTo(cara.distancia);
		
	}
	
	
}
