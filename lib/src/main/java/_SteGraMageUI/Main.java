package _SteGraMageUI;

import _SteGraMageCore.*;

public class Main {

	public static void main(String[] args) {
		
		SteGraMage model = new SteGraMage();
		model.configure();
		SteGraMageUI view = new SteGraMageUI();
		
		@SuppressWarnings("unused")
		Controller controller = new Controller(model, view);
	}

}