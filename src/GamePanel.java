import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	GameObject go;
	Timer timer; 
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Rocketship rocketship = new Rocketship(250, 700, 50, 50);
	public static void main(String[] args) {
	
	}
	public GamePanel() {
		timer = new Timer(1000/60, this);
	titleFont = new Font("Arial", Font.PLAIN, 48);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(currentState == MENU_STATE) {
			updateMenuState();
		}
		else if (currentState == GAME_STATE) {
			updateGameState();
		}
		else if(currentState == END_STATE) {
			updateEndState();
		}
		
	}
	 void startGame() {
		timer.start();
		
	}
	 public void paintComponent(Graphics g) {
		 g.fillRect(10,10,100,100);
		 if(currentState == MENU_STATE) {
				drawMenuState(g);
			}
			else if (currentState == GAME_STATE) {
				drawGameState(g);
			}
			else if(currentState == END_STATE) {
				drawEndState(g);
			}
			
		 
	 }
	 
	 
	 void updateMenuState() {
		 
	 }
	 void updateGameState() {
		 rocketship.update();
	 }
	 void updateEndState() {
		 
	 }
	 void drawMenuState(Graphics g) {
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		 g.setFont(titleFont);
		 g.setColor(Color.WHITE);
		 g.drawString("text", 200, 300);
	 }
	 void drawGameState(Graphics g) {
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		 //g.setColor(Color.BLUE);
		 rocketship.draw(g);
	 }
	 void drawEndState(Graphics g) {
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		 g.setFont(titleFont);
		 g.setColor(Color.WHITE);
		 g.drawString("game over", 200, 300);
	 }
	 
	 
	 
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("hi");
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			
		currentState++;
			if(currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("hii");
		
	}
}
