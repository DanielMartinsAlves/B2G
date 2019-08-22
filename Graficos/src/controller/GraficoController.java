package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.jfree.data.category.DefaultCategoryDataset;

import model.Configuracoes;

public class GraficoController {
	
	public GraficoController() {
		
	}
	public void atualizarGrafico(DefaultCategoryDataset ds, Configuracoes config, double[] dados ) {
		int valorFinal = 0;
		if (ds.getColumnCount() > 0) {
			String valorNumero = String.valueOf(ds.getColumnKey(ds.getColumnCount()-1)).replace("instante ", "");
			valorFinal = Integer.parseInt(valorNumero);
		}
		FileReader arq;
		try {
			arq = new FileReader("layouts.txt");
		
	     BufferedReader lerArq = new BufferedReader(arq);
	     String linha = "";
	     int contador = 0;
	     while(contador !=config.getTipoGrafo()+1) {
	    	 linha = lerArq.readLine();
	    	 contador++;
	     }
	     //JOptionPane.showMessageDialog(null, "achou a linha "+linha);
	     String[] nodesNames = linha.split(";");
		
		for(int i = 0; i< dados.length; i++) {
			
			ds.addValue(dados[i], nodesNames[i+1], ""+(valorFinal+1));
			
		}
		if(ds.getColumnCount()>20) {
			ds.removeColumn(0);
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
