package _SteGraMageUI;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageDisplayer extends JPanel implements Displayer {

	private JLabel _lblImage;
	private static final long serialVersionUID = 1L;

	public ImageDisplayer() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		_lblImage = new JLabel("");
		add(_lblImage);
	}
	
	public void setImage(String image) {
		_lblImage.setIcon(new ImageIcon(image));
		repaint();
	}
	
	public void clear() {
		_lblImage.setIcon(null);
		repaint();
	}
}
