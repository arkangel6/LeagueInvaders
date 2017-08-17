import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	final int height = 800;
	final int width = 500;
	GamePanel gamepanel;
	
	
	public static void main(String[] args) {
	LeagueInvaders li = new LeagueInvaders();
}
	public LeagueInvaders(){
		frame = new JFrame();
		gamepanel = new GamePanel();
		setup();
		
	}
	
	void setup(){
		
		frame.setVisible(true);
		
		frame.add(gamepanel);
		frame.setSize(width, height);
		frame.addKeyListener(gamepanel);
		gamepanel.startGame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		
		
	}
	}

