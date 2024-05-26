package _SteGraMageUI;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextDisplayer extends JPanel implements Displayer{

	private JTextArea _lblImage;
	private static final long serialVersionUID = 1L;
	
	public TextDisplayer() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		_lblImage = new JTextArea(20, 30);
		_lblImage.setFont(new Font("Courier New", Font.BOLD, 24));
		_lblImage.setLineWrap(true);
		_lblImage.setWrapStyleWord(true);
		_lblImage.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(_lblImage);
    add(scrollPane);

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
			
	        if (sb.toString().length() > 600) 
	        	_lblImage.setText(sb.toString().substring(0, 600));
	        else
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
