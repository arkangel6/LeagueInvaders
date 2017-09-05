import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	int xx;
	ObjectManager manager;
	Rocketship rocketship = new Rocketship(250, 700, 50, 50);
	Projectile projectile;
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;

		int score;
	public static void main(String[] args) {
	
	}
	public GamePanel() {
		timer = new Timer(1000/60, this);
	titleFont = new Font("Arial", Font.PLAIN, 48);
	manager = new ObjectManager();
	manager.addObject(rocketship);
	
	try {
		alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
		rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
		bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

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
		 manager.setScore(0);
	 }
	 void updateGameState() {
		//rocketship.update();
		 manager.update();
		 manager.manageEnemies();
		 manager.checkCollision();
		 if(rocketship.isAlive==false) {
			 currentState = END_STATE;
			 manager.reset();
			 rocketship = new Rocketship(250, 700, 50, 50);
			 manager.addObject(rocketship);
		 }
		 
		
	 }
	 void updateEndState() {
		 
	 }
	 void drawMenuState(Graphics g) {
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		 g.setFont(titleFont);
		 g.setColor(Color.WHITE);
		 g.drawString("League Invaders", 100, 300);
		 
	 }
	 void drawGameState(Graphics g) {
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		 //g.setColor(Color.BLUE);
		 manager.draw(g);
		 g.setColor(Color.WHITE);
		 score = manager.getScore();
		 g.drawString("SCORE: " + manager.getScore(), 100, 50);
		 
	 }
	 void drawEndState(Graphics g) {
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		 g.setFont(titleFont);
		 g.setColor(Color.WHITE);
		 g.drawString("game over", 100, 300);
		 score = manager.getScore();
		g.drawString("SCORE: " + score, 100, 500);
	 }
	 
	 
	 
	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("hi");
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			
		currentState++;
			if(currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			rocketship.update("right");
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			rocketship.update("left");
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			manager.addObject(projectile = new Projectile(rocketship.x+20, rocketship.y, 10,10));
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("hii");
		
	}
}
