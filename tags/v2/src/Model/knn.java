package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class knn {

	public caract_knn vo; 
	int k=0;
	int numMuestras=0;
	List<caract_knn> valores_pre = new ArrayList<caract_knn>();
	
	public knn(int k){
		this.k=k;
	}
	
	
	public knn(String muestras, String valor,int k){
		this.k=k;
	
	}
	
	
	public String iniciar(){
		
		setVo();
		/*
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
		*/
		
		
		for (int i=0;i<numMuestras;i++){
			calcular_distancias(vo, valores_pre.get(i));
			
		}
		Collections.sort(valores_pre);
		
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
		vo.setAtributo(160);
		vo.setAtributo(40);
	}
	

	public void cargarMuestras(){
		String path = null;
		BufferedReader buffS= null;
		StringTokenizer tok;
		caract_knn c1 = null;
		
		
		int i=0;
		int j=0;
		
		try {
			path = new File("").getCanonicalPath();
			buffS = new BufferedReader(new FileReader(new File(path,"test")));
			String tex;
			
			while((tex=buffS.readLine())!=null){
				
				tok = new StringTokenizer(tex, ",");
				c1 = new caract_knn();
				i=0;
				
				while (tok.hasMoreTokens()){
					
					if(i==0){
						c1.setClase(tok.nextToken());						
					}else{
						//System.out.println(tok.nextToken());
						c1.setAtributo(Double.parseDouble(tok.nextToken()));
					}
					
										
				i++;
				}
				
				valores_pre.add(c1);
				j++;
				c1 = null;
			}
				
			}
	    catch (IOException e) {
			e.printStackTrace();
		}
		
	this.numMuestras = j;	
	}
	
	
	
	public void GUIingresar(){
		
		int i =0;
		String tex = new String();
		StringTokenizer tok;
		caract_knn c1;
		
		while(tex.equals("@")!=true){
		tex = JOptionPane.showInputDialog(null,"Muestras:","Introduce Cantidad",JOptionPane.QUESTION_MESSAGE);		
		
		tok = new StringTokenizer(tex, ",");
		c1 = new caract_knn();
		i=0;
		
		if (tex.equals("@")!=true){
		while (tok.hasMoreTokens()){
			
			if(i==0){
				c1.setClase(tok.nextToken());						
			}else{
				System.out.println(tok.nextToken());
				//c1.setAtributo(Double.parseDouble(tok.nextToken()));
			}
			
								
		i++;
		}
		
		}
		
		
		
		}
		
		if (tex.equals("@")){
			tex = JOptionPane.showInputDialog(null,"Objeto a predecir:","Introduce Cantidad",JOptionPane.QUESTION_MESSAGE);		
			tok = new StringTokenizer(tex, ",");
			c1 = new caract_knn();
			i=0;
			vo = new caract_knn();
			
			while (tok.hasMoreTokens()){
				
					vo.setAtributo(Double.parseDouble(tok.nextToken()));						
			
			}
		}
		
		
	}
	
	
}
