import controller.GameController;
import view.AdvConsoleView;
import view.ConsoleView;

/**
 * Created by Kengoroo_a on 01.04.2017.
 */
public class Main {

    public static void main(String[] args) {

        final GameController game = new GameController(null, null, null);
        final AdvConsoleView advConsoleView = new AdvConsoleView(game);
        final ConsoleView consoleView = new ConsoleView(game);
        startGame(advConsoleView);
    }

    private static void startGame(final ConsoleView advConsoleView) {
        advConsoleView.showGameName();
    }
}
