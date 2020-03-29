package food_eater;

import java.awt.Image;
import java.util.List;
import java.awt.Toolkit;
import java.util.Random;

public class HotDog {
	private int x;
	private int y;
	private int movespeed;
	private Image image;
	private Random random = new Random();
	private List<HotDog> list;
	boolean isGameOverfood;
	
	public HotDog(List<HotDog> list,int speed) {
		if (Mypanel.isGameOver==false) {	
			image=Toolkit.getDefaultToolkit().getImage(HotDog.class.getResource("/images/HotDog.png"));
			this.isGameOverfood=false;
		}
		else {
			image=Toolkit.getDefaultToolkit().getImage(HotDog.class.getResource("/images/GameOver.png"));
			this.isGameOverfood=true;
		}
		this.list=list;
		y=0;
		x=random.nextInt(430);
		list.add(this);
		movespeed=speed;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getImage() {
		return image;
	}
	public int move() {
		y+=movespeed;
		if(y>=800&&this.isGameOverfood==false) {
			this.list.remove(this);
			return 1;
		}
		return 0;
	}
	public void setmovespeed(int speed) {
		this.movespeed=speed;
	}
	public int eatclear(wsc wsc) {
		int dogxleft=x;
		int dogxright=x+50;
		int dogybottom=y+72;
		
		int wsctop=wsc.getY();
		int wscleft=wsc.getX();
		int wscright=wsc.getX()+100;
		
		if(dogybottom>=wsctop&&dogybottom<=wsctop+20&&wscleft<=dogxleft&&wscright>=dogxright) {
			boolean IfRemoved=this.list.remove(this);
			if (IfRemoved) {
				if (this.isGameOverfood) {
					if (Mypanel.isGameOver==true) return 1;
					return 0;
				}
				return 1;
			}
		}
		return 0;
	}
	
}
