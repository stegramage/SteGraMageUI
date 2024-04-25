package _SteGraMageUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Controls extends JPanel{

	private JPanel _buttons;
	private JLabel _lblPath;
	private JLabel _lblMessage;
	private JTextField _txtFieldPath;
	private JTextField _txtFieldMessage;
	private JButton _btnHide;
	private JButton _btnUnhide;
	private JButton _btnClear;
	private static final long serialVersionUID = 1L;
	
	public Controls() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	
		createComponents();
		addComponents();
	}

	private void createComponents() {
		_lblPath = new JLabel("Path to image");
		_lblPath.setAlignmentX(Component.CENTER_ALIGNMENT);
		_txtFieldPath = new JTextField();
		_txtFieldPath.setMaximumSize(new Dimension(2147483647, 200));
		_txtFieldPath.setFont(new Font("Dialog", Font.PLAIN, 20));
		_txtFieldPath.setColumns(10);
		
		_lblMessage = new JLabel("Message");
		_lblMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
		_txtFieldMessage = new JTextField();
		_txtFieldMessage.setMaximumSize(new Dimension(2147483647, 200));
		_txtFieldMessage.setFont(new Font("Dialog", Font.PLAIN, 20));
		_txtFieldMessage.setColumns(10);
		
		_buttons = new JPanel();
		_buttons.setLayout(new FlowLayout());
		_btnHide = new JButton("Hide");
		_btnUnhide = new JButton("Unhide");
		_btnClear = new JButton("Clear");
	}
	
	private void addComponents() {
		add(_lblPath);
		add(_txtFieldPath);
		add(_lblMessage);
		add(_txtFieldMessage);
		_buttons.add(_btnHide);
		_buttons.add(_btnUnhide);
		_buttons.add(_btnClear);
		add(_buttons);
	}
	
	void addHideButtonListener(ActionListener listener) {
        _btnHide.addActionListener(listener);
    }
	
	void addUnhideButtonListener(ActionListener listener) {
        _btnUnhide.addActionListener(listener);
    }
	
	void addClearButtonListener(ActionListener listener) {
        _btnClear.addActionListener(listener);
    }
	
	String getMessage() {
		return _txtFieldMessage.getText();
	}
	
	String getChannel() {
		return _txtFieldPath.getText();
	}

	void setMessage(String messageUnhided) {
		_txtFieldMessage.setText(messageUnhided);
	}

	void setChannel(String channel) {
		_txtFieldPath.setText(channel);
	}
}
