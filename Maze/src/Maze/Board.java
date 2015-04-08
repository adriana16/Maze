package Maze;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JPanel implements ActionListener {
	
	private Timer timer;
	private Map m;
	private Player p;
	private boolean win = false;
	private String mesaj= " ";
	
	private Font font = new Font("Serif", Font.BOLD,48 );
	
	public Board(){
		m= new Map();
		p=new Player();
		
		
		addKeyListener(new ActionListener());
		setFocusable(true);
		
		timer= new Timer(25, this);
		timer.start();
	}
	public void actionPerformed(ActionEvent e){
		if(m.getMap(p.getTileX(), p.getTileY()).equals("f")){
			mesaj = "Ai castigat!";
			win=true;
		}
		repaint();
		}
	
	
	//y rand, x pozitie
	public void paint(Graphics g){
		super.paint(g);
		
		if(!win){
		for(int y=0; y<14;y++){
			for ( int x=0; x<14; x++){
				if(m.getMap(x,y).equals("d")){
					g.drawImage(m.getDrum(), x*32, y*32, null);
				}
				if(m.getMap(x,y).equals("z")){
					g.drawImage(m.getZid(), x*32, y*32, null);
				}
				if(m.getMap(x,y).equals("f")){
					g.drawImage(m.getFinish(), x*32, y*32, null);
				}
				if(m.getMap(x,y).equals("s")){
					g.drawImage(m.getStart(), x*32, y*32, null);
				}
			}
		}
		g.drawImage(p.getOm(), p.getTileX()*32, p.getTileY()*32,null);
		}
		
		if (win) {
			g.setColor(Color.red);
			g.setFont(font);
			g.drawString(mesaj, 130, 200);
		}
		
	}
	

	public class ActionListener extends KeyAdapter{
		
		public void keyPressed(KeyEvent e){
			
			int keycode = e.getKeyCode();
			if (keycode == KeyEvent.VK_UP) {
				if (!m.getMap(p.getTileX(), p.getTileY() - 1).equals("z"))
					p.move(0, -1);

			}
			if (keycode == KeyEvent.VK_DOWN) {
				if (!m.getMap(p.getTileX(), p.getTileY() + 1).equals("z"))
					p.move(0, 1);

			}
			if (keycode == KeyEvent.VK_LEFT) {
				if (!m.getMap(p.getTileX() - 1, p.getTileY()).equals("z"))
					p.move(-1, 0);

			}
			if (keycode == KeyEvent.VK_RIGHT) {
				if (!m.getMap(p.getTileX() + 1, p.getTileY()).equals("z"))
					p.move(1, 0);

			}
		
		}
		
	}
}
