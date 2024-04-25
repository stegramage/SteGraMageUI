package _SteGraMageUI;

import _SteGraMageCore.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements Observer {

	private SteGraMage _model;
	private SteGraMageUI _view;
	private boolean _hiding;
	
	public Controller(SteGraMage model, SteGraMageUI view) {
		_model = model;
		_model.register(this);
		_view = view;
		setButtonActions();
    }

	private void setButtonActions() {
		_view.addHideButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	_hiding = true;
            	hide(_view.getMessage(), _view.getChannel());
            }
        });
		
		_view.addUnhideButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	_hiding = false;
            	unhide(_view.getChannel());
            }
        });
		
		_view.addClearButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	clear();
            }
        });
	}
	
	private void hide(String message, String channel) {
		_model.hide(message, channel);		
	}

	private void unhide(String channel) {
		_model.unhide(channel);
	}
	
	private void clear() {
		_model.clearMessageUnhided();
		_view.clear();
	}

	@Override
	public void update(SteGraMage st) {
		if (_hiding) {
			_view.displayChannel(_view.getChannel());
			_view.setMessage("");
			_view.setChannel(_view.getChannel().replaceFirst("\\.png", "_out.png"));
		} else {
			_view.displayChannel(_view.getChannel());
			_view.setMessage(st.getMessageUnhided());
		}
	}
}
