package _SteGraMageUI;

import _SteGraMageCore.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFileChooser;

public class Controller implements Observer {

    private SteGraMage _model;
    private SteGraMageUI _view;
    private Set<Class<?>> _plugins;
    private Set<String> _pluginsNames;
    private boolean _hiding;

    public Controller(SteGraMage model, SteGraMageUI view, PluginsLoader loader) {
        _model = model;
        _model.register(this);
        _plugins = loader.getPlugins();
        _pluginsNames = getPluginsNames(loader.getPlugins());
        _view = view;
        setButtonActions();
        setNameListPanelActions();
    }

    private Set<String> getPluginsNames(Set<Class<?>> plugins) {
		Set<String> ret = new HashSet<String>();
		for (Class<?> c : plugins)
			ret.add(c.getName());
		return ret;
	}

	private void setButtonActions() {
        _view.addSearchButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = _view.getFileChooser().showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    // set the text field to the path of the selected file
                    _view.setChannel(_view.getFileChooser().getSelectedFile().getAbsolutePath());
                    _view.displayChannel(_view.getChannel());
                }
            }
        });

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

    private void setNameListPanelActions() {
       for (String s : _pluginsNames)
    	   _view.getNameListPanel().addName(s);
       _view.getNameListPanel().repaint();
    }

    private void hide(String message, String channel) {
    	Configurator.configure(_model, _plugins, _view.getCodecs(), _view.getConverters());
        _model.hide(message, channel);        
    }

    private void unhide(String channel) {
    	Configurator.configure(_model, _plugins, _view.getCodecs(), _view.getConverters());
        _model.unhide(channel);
    }

    private void clear() {
        _model.clearMessageUnhided();
        _view.clear();
        setNameListPanelActions();
    }

    @Override
    public void update(SteGraMage st) {
        if (_hiding) {
            _view.setMessage("");
            _view.setChannel(_view.getChannel().replaceFirst("\\.txt", "_out.txt"));
            _view.displayChannel(_view.getChannel());
        } else {
            _view.setChannel("");
            _view.setMessage(st.getMessageUnhided());
        }
    }
}
