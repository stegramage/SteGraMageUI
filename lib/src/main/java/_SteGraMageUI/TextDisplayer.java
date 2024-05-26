package _SteGraMageUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextDisplayer extends JPanel implements Displayer {

	private JLabel _lblImage;
	private static final long serialVersionUID = 1L;
	
	public TextDisplayer() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		_lblImage = new JLabel("");
		add(_lblImage);
	}
	
	public void setImage(String image) {
		try {
			FileReader fr = new FileReader(new File(image));
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line;
			while (( line = br.readLine()) != null) {
                sb.append(line);
            }
			
			_lblImage.setText(sb.toString());
			br.close();
		}
		catch (IOException e) {
			System.out.println("Error: " + e);
		}
		
		repaint();
	}
	
	public void clear() {
		_lblImage.setText("");
		repaint();
	}

}
