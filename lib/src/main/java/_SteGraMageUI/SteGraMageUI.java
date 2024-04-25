package _SteGraMageUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class SteGraMageUI {

	private JFrame _frame;
	private Controls _controls;
	private JPanel _display;
	private ImageDisplayer _imgIn;
	private ImageDisplayer _imgOut;

	public SteGraMageUI() {
		makeView();
		setFrame();
	}

	private void makeView() {
		_imgIn = new ImageDisplayer();
		_imgOut = new ImageDisplayer();
		_display = new JPanel();
		_display.setLayout(new GridLayout(0, 2, 0, 0));
		_display.add(_imgIn);
		_display.add(_imgOut);
		_controls = new Controls();
		_frame = new JFrame();
		
	}

	private void setFrame() {
		_frame.setName("SteGraMage");
		_frame.setBounds(100, 100, 450, 300);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(new BorderLayout(5, 5));
		_frame.setTitle("SteGraMage");
		_frame.setIconImage(Toolkit.getDefaultToolkit().getImage(SteGraMageUI.class.getResource("/resources/logo.png")));
		
		_frame.getContentPane().add(_display, BorderLayout.CENTER);
		_frame.getContentPane().add(_controls, BorderLayout.SOUTH);
		
		_frame.setVisible(true);
	}
		
	public void addHideButtonListener(ActionListener listener){
		_controls.addHideButtonListener(listener);
	}
	
	public void addUnhideButtonListener(ActionListener listener){
		_controls.addUnhideButtonListener(listener);
	}
	
	public void addClearButtonListener(ActionListener listener){
		_controls.addClearButtonListener(listener);
	}
	
	public String getMessage( ) {
		return _controls.getMessage();
	}
	
	public String getChannel( ) {
		return _controls.getChannel();
	}

	public void displayChannel(String channel) {
		if (channel.endsWith("_out.png"))
			_imgOut.setImage(channel);
		else
			_imgIn.setImage(channel);
	}

	public void setMessage(String messageUnhided) {
		_controls.setMessage(messageUnhided);
		
	}

	public void setChannel(String channel) {
		_controls.setChannel(channel);
		
	}

	public void clear() {
		_imgIn.clear();
		_imgOut.clear();
		_controls.setMessage("");
		_controls.setChannel("");
		_frame.getContentPane().repaint();
	}
}
