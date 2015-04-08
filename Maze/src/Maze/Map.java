package Maze;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class Map {

	private Scanner m;
	private String Map[] = new String[14];
	private Image drum, zid,finish,start;

	public Map() {
		ImageIcon img = new ImageIcon("C:\\Users\\Adriana-Denisa\\Desktop\\grass.png");
		drum = img.getImage();

		img = new ImageIcon("C:\\Users\\Adriana-Denisa\\Desktop\\zid.png");
		zid = img.getImage();
		
		img = new ImageIcon("C:\\Users\\Adriana-Denisa\\Desktop\\finish.png");
		finish = img.getImage();
		
		img = new ImageIcon("C:\\Users\\Adriana-Denisa\\Desktop\\start.png");
		start = img.getImage();
		
		openFile();
		readFile();
		closeFile();
		
	}
	
	public Image getDrum(){
		return drum;
	}
	
	public Image getZid(){
		return zid;
	}
	
	public Image getFinish(){
		return finish;
	}
	
	public Image getStart(){
		return start;
	}
	
	//y=coloana, x=al catalea element pe rand
	public String getMap(int x, int y){
		String index= Map[y].substring(x, x+1);
		return index;
	}
	
	public void openFile() {
		try {
			m = new Scanner( new File("C:\\Users\\Adriana-Denisa\\Documents\\facultate\\Anul2\\sem2\\programare avansata\\map.txt"));
		} catch (Exception e) {
			System.out.println("Eroare la fisier");
		}

	}

	public void readFile() {
		while (m.hasNext()) {
			for (int i = 0; i < 14; i++) {
				Map[i] = m.next();
			}
		}
	}

	public void closeFile() {
		m.close();
	}

}
