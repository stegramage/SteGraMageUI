package _SteGraMageUI;

import _SteGraMageCore.*;

public class Main {

	public static void main(String[] args) {
		
		SteGraMage model = new SteGraMage();
		model.configure(new MokingConverter(), new ASCIIMessageInterpreter());
		SteGraMageUI view = new SteGraMageUI("TXT");
		
		@SuppressWarnings("unused")
		Controller controller = new Controller(model, view);
	}

}
