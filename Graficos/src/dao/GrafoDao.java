package dao;

import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Utilidades.Calculos;
import model.Configuracoes;
import model.Eletrodo;
import model.MatrizAdjacencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GrafoDao {
	private List listaMatrizAdjacencia;
	private List<Eletrodo> eletrodos;
	public GrafoDao(Configuracoes config) {
		eletrodos = new ArrayList<Eletrodo>();
		for(int i=0;i<config.getNodesNumber();i++)
		eletrodos.add(new Eletrodo());
		carregarEletrodosDeArquivo(config);
		listaMatrizAdjacencia = converterDadosEmMatrizAdjacencia(config);
	}
	
	public List converterDadosEmMatrizAdjacencia(Configuracoes config) {
		List listaMatrizAd = new ArrayList();
		Calculos c = new Calculos();
		for(int inicial=0; inicial< eletrodos.get(0).getValores().size();inicial=inicial+config.getRegistrosPorAtualizacao()) {
			int fim = (inicial+(config.getRegistrosPorGrafo()-1) >= eletrodos.get(0).getValores().size())?eletrodos.get(0).getValores().size():inicial+(config.getRegistrosPorGrafo()-1);
		//inicia matriz
			double [][] matriz = new double[config.getNodesNumber()][config.getNodesNumber()];// estava iniciado tudo com 0
			//System.out.println("Inicio Matriz");
			for(int i = 0; i< eletrodos.size();i++) {
				// inicia linha
				double[] linha = new double[config.getNodesNumber()];
				//System.out.println("Inicio Linha");
				for(int z = 0;z < eletrodos.size();z++) {
					linha[z] = c.correlacaoDePearson(eletrodos.get(i).pegarValores(inicial, fim), eletrodos.get(z).pegarValores(inicial, fim), config);
				}
				matriz[i]=linha;
				//System.out.println("Fim Linha");
			}
			MatrizAdjacencia matrizAd = new MatrizAdjacencia();
			matrizAd.setDados(matriz);
			listaMatrizAd.add(matrizAd);
			//System.out.println("Fim Matriz");
		}
		return listaMatrizAd;
	}
	private String[] calcularCARFilter(String[] linha, int tamanho) {
		double media = 0.0;
		String[] retorno = new String[tamanho];
		retorno[0] = "0";
		for(String coluna: linha) {
			media += Double.parseDouble(coluna);
		}
		media = media/linha.length;
		for(int i = 0; i< linha.length; i++) {
			retorno[i+1] = ""+(Double.parseDouble(linha[i]) - media);
		}
		
		return retorno;
	}
	public void carregarEletrodosDeArquivo(Configuracoes config) {
		try {
			
			
		      FileReader arq = new FileReader(config.getArquivoLeitura());
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linha = lerArq.readLine(); // lê a primeira linha
		// a variável "linha" recebe o valor "null" quando o processo
		// de repetição atingir o final do arquivo texto
		     while (linha != null) {
		        String[] arrayLinha = linha.split(",");
		       
		        System.out.println(linha);
		        if(arrayLinha.length>=config.getNodesNumber()+1) {
		        	for(int i = 0; i < config.getNodesNumber()+1; i++) {//tratando casos onde o registro vem "-"
		        		if(arrayLinha[i].equals(" -"))
		    			arrayLinha[i]="0";
		    		}
		        	if(config.isCARfilter()) {
		        		arrayLinha = this.calcularCARFilter(Arrays.copyOfRange(arrayLinha, 1, config.getNodesNumber()+1), config.getNodesNumber()+1);
				     }
		    		System.out.println(java.util.Arrays.toString(arrayLinha));
		    		
		    		for(int i = 0; i<config.getNodesNumber();i++) {
		    			eletrodos.get(i).adicionarValor(Double.parseDouble(arrayLinha[i+1]));
		    		}
		        }
		        linha = lerArq.readLine(); // lê da segunda até a última linha

		      }
		      //System.out.println(linha);
		      arq.close();
		    
		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(null, "Error: Can not open file:\n"+e.getMessage());
		    }
	}
	
	public MatrizAdjacencia geMatrizAdjacencia() throws IndexOutOfBoundsException{	
	MatrizAdjacencia matriz =  (MatrizAdjacencia) this.listaMatrizAdjacencia.get(0);
	this.listaMatrizAdjacencia.remove(0);
	return matriz;
	}
}
