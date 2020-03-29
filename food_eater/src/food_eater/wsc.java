package food_eater;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class wsc {
	private int x;
	private int y;
	private BufferedImage image;
	
	public wsc() {
		try {
			x=200;
			y=650;
			image=ImageIO.read(wsc.class.getResource("/images/wsc.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getX() {
		return x;
	}
	public void setX(int X) {
		this.x=X;
	}
	public int getY() {
		return y;
	}
	public void setY(int Y) {
		this.y=Y;
	}
	public BufferedImage getImage() {
		return image;
	}
}
