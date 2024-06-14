package _SteGraMageUI;

import _SteGraMageCore.*;

public class Main {

	public static void main(String[] args) {
		SteGraMage.loadPlugins("plugins/");
		
		SteGraMage model = SteGraMage.defaultInstance();
		
		SteGraMageUI view = new SteGraMageUI();
		
		@SuppressWarnings("unused")
		Controller controller = new Controller(model, view);
	}

}
