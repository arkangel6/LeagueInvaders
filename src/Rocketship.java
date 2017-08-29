import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocketship extends GameObject{

	int speed = 5;
	
		public Rocketship(int x, int y, int width, int height) {
			super(x, y, width, height);
			
		}
		void update(String direction){
			
			if(direction.equals("right")) {
				
				x+=speed;
			}
			else if(direction.equals("left")) {
				x-=speed;
			}
			
		}
		
		void draw(Graphics g){
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
			
		}
		
}
