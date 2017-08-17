import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	
	Timer timer; 
	public static void main(String[] args) {
	
	}
	public GamePanel() {
		timer = new Timer(1000/60, this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
	 void startGame() {
		timer.start();
		
	}
	 public void paintComponent(Graphics g) {
		 g.fillRect(10,10,100,100);
		 
	 }
	 
	 
	 
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("hi");
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("hiii");
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("hii");
		
	}
}
