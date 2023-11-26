import Controller.CreaturemonController;
import Model.CreaturemonModel;
import Views.StarterView;

public class App {
    public static void main(String[] args) throws Exception {
        // new StarterView();
        // MainMenuView mmv = new MainMenuView();
        // InventoryMenuView viv = new InventoryMenuView();
        // SelectAreaMenuView samv = new SelectAreaMenuView();
        // DisplayInventoryView div = new DisplayInventoryView();
        //ChangeActiveCreatureView cacv = new ChangeActiveCreatureView();

        StarterView starterView = new StarterView();
		CreaturemonModel creaturemonModel = new CreaturemonModel();

		new CreaturemonController(starterView, creaturemonModel);
    }
}
