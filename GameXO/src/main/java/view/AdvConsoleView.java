package view;

import controller.GameController;

/**
 * Created by Kengoroo_a on 02.04.2017.
 */
public class AdvConsoleView extends ConsoleView {

    public AdvConsoleView(final GameController game) {
        super(game);
    }

    @Override
    public void showGameName() {
        System.out.println("***");
        System.out.println(gameController.getGameName());
    }
}
