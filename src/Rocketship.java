import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	int speed = 5;
		public Rocketship(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			
		}
		void update(){
			
		}
		void draw(Graphics g){
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
			
		}
		
}
