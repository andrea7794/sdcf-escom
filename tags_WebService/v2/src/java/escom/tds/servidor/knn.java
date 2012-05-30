package escom.tds.servidor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class knn {

	public caract_knn vo; 
	int k=0;
	int numMuestras=0;
	List<caract_knn> valores_pre = new ArrayList<caract_knn>();
	String muestras;
	String valor;
	
	
	//Constructor de knn
	public knn(String muestras, String valor,int k){
		this.k=k;
		this.muestras = muestras;
		this.valor = valor;
	}
	
	
	//Metodo que inicia el algoritmo
	public String iniciar(){
		
		setVo(valor);	//Metodo que carga el String de los valores a evaluar
		cargarMuestras(muestras);	//Metodo que carga las muestras 
		
		for (int i=0;i<numMuestras;i++){
			calcular_distancias(vo, valores_pre.get(i));	//Se calculan distancias
			
		}
		Collections.sort(valores_pre);	//Se ordena en base en la distancia calculada
		
		int val1=0;	
		//int val2=0;
	
		for(int j=0;j<k;j++){
			//valores_pre.get(j).imprimir();
			caract_knn prue = valores_pre.get(j);
			if(prue.clase.equals("1")){
				val1++;
			}
			
			//else if (prue.clase.equals("0")){
				//val2++;
			//}
		}
		//System.out.print(val1);
		//Comparamos que muestra se le acerco mucho
		if (val1==3){
			return "Banco en Operación";
		}else if (val1==2){
			return "Banco en Operación regular ";
		}else if(val1== 1){
			return "Banco en riesgo";
		}else {
			return"banco en banca rota";
		}
		
	}
	
	//metodo que calcula las distancias de un valor con todos las muestras que existen
	public void calcular_distancias(caract_knn vo, caract_knn vf){
		
		double suma=0;
		for (int i=0;i<vf.num;i++){
			suma = suma + Math.pow((vo.getAtributo(i)-vf.getAtributo(i)), 2);	//se suman los cuadrados de cada atributo
		}
		
		double div = Math.sqrt(suma);	//se realiza la raiz cadrada para obtener la distancia
		vf.setDistancia(div);	//se guarda la distancia en cada muestra
		
		
	}

	//Metodo que separa la cadena y lo mete en la clase de los valores
	public void setVo(String val){
		
		StringTokenizer tok = null;
		vo = new caract_knn();
		int i=0;
		
		tok = new StringTokenizer(val, ",");
		
		while (tok.hasMoreTokens()){
				vo.setAtributo(Double.parseDouble(tok.nextToken()));			
		}
		

	}
	
	//Metodo que carga las muestras y las agregar en una lista de tipo caract_knn
	public void cargarMuestras(String mue){
		
		StringTokenizer tok;
		caract_knn c1 = null;
		
		int i=0;
		int j=0;
		
		c1 = new caract_knn();	
		tok = new StringTokenizer(mue, ",");	//indico el separador de los tokens
		String aux;
		
		while (tok.hasMoreTokens()){
			i++;
			
			aux = tok.nextToken();
			if(aux.equals("-")){	// si es "-" se inicializa el contador y se agrega la muestra
				i=0;
				j++;
				valores_pre.add(c1);
				c1=null;
				c1 = new caract_knn();
			}
			
			if(i==1){	//se agregan el nombre de la clase
				c1.setClase(aux);	
			}else if(i>1){	//se agregan sus caracteristicas pueden ser n
				c1.setAtributo(Double.parseDouble(aux));
			}
			
		}
		this.numMuestras=j;
	
	}
	
	
	
}
