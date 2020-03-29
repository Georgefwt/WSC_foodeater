package food_eater;

import javax.swing.JFrame;

public class MainApp {
	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setTitle("Food Eater");
		frame.setSize(500,800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Mypanel panel=new Mypanel();
		frame.add(panel);
		wsc playerWsc=new wsc();
		panel.printWSC(playerWsc);
		
		panel.createHotDogs();
		new Thread(panel).start();
		panel.addMouseMotionListener(panel);
		frame.setVisible(true);
	}
}
