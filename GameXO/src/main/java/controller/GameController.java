package controller;

import helper.CoordinateHelper;
import model.Board;
import model.Player;

/**
 * Created by Kengoroo_a on 01.04.2017.
 */
public class GameController {

    private final String gameName;

    private final Board board;

    private Player[] players;

    public GameController(final String gameName, final Player[] players, final Board board) {
        this.players = players;
        this.board = board;
        if (gameName == null || gameName.isEmpty()) {
            this.gameName = "XO";
        } else {
            this.gameName = gameName;
        }
    }

    public String getGameName() {
        return gameName;
    }

    public Player currentPlayer() {
        return null;
    }

    public Board getBoard() {
        return board;
    }

    public boolean move(final int x, final int y) {

        assert x >= 0;
        assert y >= 0;

        if (!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y)) {
            return false;
        }

        // TODO logic for move

        return true;
    }

    public Player[] getPlayers() {
        return players;
    }
}
