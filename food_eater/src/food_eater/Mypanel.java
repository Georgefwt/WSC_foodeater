package food_eater;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Mypanel extends JPanel implements Runnable,MouseMotionListener{
//	private BufferedImage image;
	private List<HotDog> hotDogs = new ArrayList<HotDog>();
	private wsc wsc;
	public static int currentSpeed=5;
	int summissed=0;
	int sumeated=0;
	static boolean isGameOver=false;
	
	public void printWSC(wsc wsc) {
		this.wsc=wsc;
		repaint();
	}
	
	public void printHotDog() {
		super.repaint();   //父类调用重绘方法
		
	}
	public Mypanel() {
		setDifficultButton setDifficultButton=new setDifficultButton(this);
		this.add(setDifficultButton);
		Icon icon= new ImageIcon(Mypanel.class.getResource("/images/background.jpg"));
		JLabel label=new JLabel(icon);
		this.add(label);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (wsc!=null) {
			g.drawImage(wsc.getImage(), wsc.getX(), wsc.getY(), null);
		}
		
		for (int i = 0; i < hotDogs.size(); i++) {
			HotDog hotDog=hotDogs.get(i);
			summissed+=hotDog.move();
			sumeated+=hotDog.eatclear(wsc);
			g.drawImage(hotDog.getImage(), hotDog.getX(), hotDog.getY(), null);
		}
		Font axesFont = new Font("Arial",Font.BOLD, 15);
		g.setFont(axesFont);
		g.drawString("you eat "+sumeated+" foods", 10, 20);
		g.drawString("missed "+summissed+" foods", 10, 40);
		g.drawString("current speed is: "+currentSpeed, 320, 20);
		if (sumeated>=5&&sumeated<10) {
			g.drawString("guuuuud!",320, 40);
		}
		else if (sumeated>=20&&sumeated<50) g.drawString("excellent!!",320, 40);
		else if (sumeated>=50&&sumeated<150) g.drawString("incredible!!!",320, 40);
		else if (sumeated>=150) {g.drawString("Stop wasting your time",320, 40);
		g.drawString("Do sth more meaningful",320, 60);}
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getX()<=380&&arg0.getX()>=0) {
			wsc.setX(arg0.getX());
		}
		else if (arg0.getX()>380) {
			wsc.setX(380);
		}
		else if (arg0.getX()<0) {
			wsc.setX(0);
		}
		if (arg0.getY()<=650&&arg0.getY()>=0) {
			wsc.setY(arg0.getY());
		}
		else if (arg0.getY()>650) {
			wsc.setY(650);
		}
		else if (arg0.getY()<0) {
			wsc.setY(0);
		}
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//wsc.setX(arg0.getX());
	}
	public void createHotDogs() {
		TimerTask timerTask =new TimerTask() {
			@Override
			public void run() {
				HotDog dog=new HotDog(hotDogs,currentSpeed);
			}
		};
		java.util.Timer timer=new java.util.Timer();
		long delay=0;
		long intervalPeriod=1000;
		timer.schedule(timerTask, delay, intervalPeriod);
	}
	
	public void paintWSC(wsc myWsc) {
		this.wsc=myWsc;
		repaint();
	}
	
	private void reset() {
		this.isGameOver=false;
		this.summissed=0;
		this.sumeated=0;
	}
	
	@Override
	public void run() {
		int eatrecorder=5000;
		while (true) {
			if (summissed>=5) {
				isGameOver=true;
				currentSpeed=5;
				if (eatrecorder >sumeated) {
					eatrecorder=sumeated;					
				}
				if (eatrecorder<sumeated) {
					this.reset();
				}
			}
			this.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
