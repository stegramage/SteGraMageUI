package _SteGraMageUI;

import _SteGraMageCore.*;

public class Main {

	public static void main(String[] args) {
		PluginsLoader loader = new PluginsLoader("plugins/");
		
		SteGraMage model = new SteGraMage();
		
		SteGraMageUI view = new SteGraMageUI();
		
		@SuppressWarnings("unused")
		Controller controller = new Controller(model, view, loader);
	}

}
