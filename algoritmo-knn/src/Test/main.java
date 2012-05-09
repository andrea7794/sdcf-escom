package Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import Model.caract_knn;
import Model.knn;

public class main {

	
	public static void main(String[] args) {
		System.out.println("Inicio");
		knn ini = new knn(3);
		ini.cargarMuestras();
		//ini.GUIingresar();
		System.out.println(ini.iniciar());
		
		
		
		
		
		
		
		
	}

}
