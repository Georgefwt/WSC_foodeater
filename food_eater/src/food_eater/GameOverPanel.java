package food_eater;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel{
	public GameOverPanel() {
		// TODO Auto-generated constructor stub
		Icon icon= new ImageIcon(GameOverPanel.class.getResource("/images/background.jpg"));
		JLabel label=new JLabel(icon);
		this.add(label);
//		if (Mypanel.GameOver==false) {
//			this.setVisible(false);
//		}
	}
}
