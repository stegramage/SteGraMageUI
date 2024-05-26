package _SteGraMageUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;

public class Controls extends JPanel{

	private JPanel _buttons;
	private JLabel _lblPath;
	private JLabel _lblMessage;
	private JTextField _txtFieldPath;
	private JFileChooser _fileChooser;
	private JButton _btnSearch;
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
		createPathComponents();
		createMessageComponents();
		createButtonsComponents();
	}

	private void createPathComponents() {
		_lblPath = new JLabel("Path to file");
		_lblPath.setFont(new Font("Dialog", Font.BOLD, 15));
		_lblPath.setAlignmentX(Component.CENTER_ALIGNMENT);
		_txtFieldPath = new JTextField();
		_txtFieldPath.setMaximumSize(new Dimension(2147483647, 200));
		_txtFieldPath.setFont(new Font("Dialog", Font.PLAIN, 20));
		_txtFieldPath.setColumns(10);
		_btnSearch = new JButton("Search file");
		_fileChooser = new JFileChooser();
		_fileChooser.setAcceptAllFileFilterUsed(false);
		_fileChooser.setDialogTitle("Select a file");
		FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only txt or png files", "txt", "png");
        _fileChooser.addChoosableFileFilter(restrict);
	}
	
	private void createMessageComponents() {
		_lblMessage = new JLabel("Message");
		_lblMessage.setFont(new Font("Dialog", Font.BOLD, 15));
		_lblMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
		_txtFieldMessage = new JTextField();
		_txtFieldMessage.setMaximumSize(new Dimension(2147483647, 200));
		_txtFieldMessage.setFont(new Font("Dialog", Font.PLAIN, 20));
		_txtFieldMessage.setColumns(10);
	}

	private void createButtonsComponents() {
		_buttons = new JPanel();
		_buttons.setLayout(new FlowLayout());
		_btnHide = new JButton("Hide");
		_btnUnhide = new JButton("Unhide");
		_btnClear = new JButton("Clear");
	}
	
	private void addComponents() {
		addPathComponents();
		addMessageComponets();
		addButtons();
	}

	private void addPathComponents() {
		JPanel path = new JPanel();
		path.setLayout(new BorderLayout(5, 0));
		path.add(_txtFieldPath,BorderLayout.CENTER);
		path.add(_btnSearch,BorderLayout.EAST);
		add(_lblPath);
		add(path);
	}

	private void addMessageComponets() {
		add(_lblMessage);
		add(_txtFieldMessage);
	}

	private void addButtons() {
		_buttons.add(_btnHide);
		_buttons.add(_btnUnhide);
		_buttons.add(_btnClear);
		add(_buttons);
	}
	
	void addSearchButtonListener(ActionListener listener) {
        _btnSearch.addActionListener(listener);
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
	
	JFileChooser getFileChooser() {
		return _fileChooser;
	}

	void setMessage(String messageUnhided) {
		_txtFieldMessage.setText(messageUnhided);
	}

	void setChannel(String channel) {
		_txtFieldPath.setText(channel);
	}
}
