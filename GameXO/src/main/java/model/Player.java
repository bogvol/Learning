package model;

/**
 * Created by Kengoroo_a on 01.04.2017.
 */
public class Player {

    private final String name;

    private final String figure;

    public Player(final String name, final String figure) {

        assert name != null;
        assert figure != null;

        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public String getFigure() {
        return figure;
    }
}
