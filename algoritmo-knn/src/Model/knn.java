package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class knn {

	public caract_knn vo;
	int k=0;
	
	public knn(int k){
		this.k=k;
	}
	
	public String iniciar(){
		setVo();
		
		List<caract_knn> valores_pre = new ArrayList<caract_knn>();
		
		caract_knn c1 = new caract_knn();
		c1.setClase("Clase 1");
		c1.setAtributo(100);
		c1.setAtributo(20);
		
		caract_knn c2 = new caract_knn();
		c2.setClase("Clase 1");
		c2.setAtributo(108);
		c2.setAtributo(15);
		
		caract_knn c3 = new caract_knn();
		c3.setClase("Clase 1");
		c3.setAtributo(121);
		c3.setAtributo(25);
		
		caract_knn c4 = new caract_knn();
		c4.setClase("Clase 2");
		c4.setAtributo(140);
		c4.setAtributo(35);
		
		caract_knn c5 = new caract_knn();
		c5.setClase("Clase 2");
		c5.setAtributo(148);
		c5.setAtributo(42);
		
		
		caract_knn c6 = new caract_knn();
		c6.setClase("Clase 2");
		c6.setAtributo(155);
		c6.setAtributo(30);
		
		
		valores_pre.add(c1);
		valores_pre.add(c2);
		valores_pre.add(c3);
		valores_pre.add(c4);
		valores_pre.add(c5);
		valores_pre.add(c6);
		
		calcular_distancias(vo, valores_pre.get(0));
		calcular_distancias(vo, valores_pre.get(1));
		calcular_distancias(vo, valores_pre.get(2));
		calcular_distancias(vo, valores_pre.get(3));
		calcular_distancias(vo, valores_pre.get(4));
		calcular_distancias(vo, valores_pre.get(5));
	
		Collections.sort(valores_pre);	//ordenamos por la distancia euclidea
		
		int val1=0;
		int val2=0;
		for(int j=0;j<k;j++){
			//valores_pre.get(j).imprimir();
			caract_knn prue = valores_pre.get(j);
			if(prue.clase.equals("Clase 1")){
				val1++;
			}else if (prue.clase.equals("Clase 2")){
				val2++;
			}
		}
		
		
		if (val1>val2){
			return "Clase 1";
		}else{
			return "Clase 2";
		}
		
	}
	

	public void calcular_distancias(caract_knn vo, caract_knn vf){
		
		double suma=0;
		for (int i=0;i<vf.num;i++){
			suma = suma + Math.pow((vo.getAtributo(i)-vf.getAtributo(i)), 2);
		}
		
		double div = Math.sqrt(suma);
		vf.setDistancia(div);
		//System.out.println("la suma es: "+div);
		
		
	}

	public void setVo(){
		vo = new caract_knn();
		vo.setAtributo(110);
		vo.setAtributo(15);
	}
	

}
