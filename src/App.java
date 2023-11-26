import Controller.CreaturemonController;
import Model.CreaturemonModel;
import Views.CreaturemonView;

public class App {
    public static void main(String[] args) throws Exception {

        CreaturemonView creaturemonView = new CreaturemonView();
		CreaturemonModel creaturemonModel = new CreaturemonModel();

		new CreaturemonController(creaturemonView, creaturemonModel);
    }
}
