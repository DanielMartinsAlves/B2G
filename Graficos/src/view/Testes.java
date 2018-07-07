package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.graphstream.algorithm.BetweennessCentrality;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import com.sun.glass.ui.Window.Level;
import com.sun.istack.internal.logging.Logger;

import Utilidades.Calculos;

public class Testes {

	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	            "Text Files(*.txt)", "txt");
	    fileChooser.setFileFilter(filter);
	    fileChooser.setCurrentDirectory(new File(System
	            .getProperty("user.home")));
	    int result = fileChooser.showOpenDialog(new JFrame());
	    if (result == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();
	        BufferedReader br = null;
	        try {
	            br = new BufferedReader(new FileReader(selectedFile));
	            StringBuilder sb = new StringBuilder();
	            String line = br.readLine();

	            while (line != null) {
	                sb.append(line);
	                sb.append(System.lineSeparator());
	                line = br.readLine();
	            }
	            String all = sb.toString();
	           System.out.println(all);
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally {
	            try {
	                br.close();
	            } catch (IOException ex) {
	            }
	        }
	    }
		
	}

}
