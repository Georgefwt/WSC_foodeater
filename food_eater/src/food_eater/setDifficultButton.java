package food_eater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class setDifficultButton extends JButton{
	public setDifficultButton(Mypanel myJPanel) {
		ImageIcon buttonIcon0= new ImageIcon(Mypanel.class.getResource("/images/button0.png"));
		ImageIcon buttonIcon1= new ImageIcon(Mypanel.class.getResource("/images/button1.png"));
		this.setIcon(buttonIcon0);
		this.setRolloverIcon(buttonIcon1);
		this.setPressedIcon(buttonIcon0);
		//JButton setDifficultButton=new JButton(buttonIcon);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myJPanel.currentSpeed+=5;
			}
		});
		this.setSize(20,40);
		//setDifficultButton.setBackground(Color.blue);
		this.setVerticalAlignment(SwingConstants.BOTTOM);
	}
}
