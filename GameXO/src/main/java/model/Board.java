package model;

import helper.CoordinateHelper;

/**
 * Created by Kengoroo_a on 01.04.2017.
 */
public class Board {

    public static final int SIZE_FIELD = 3;

    private Figure[][] figures = new Figure[SIZE_FIELD][SIZE_FIELD];

    public Figure getFigure(final int x, final int y) {
        if (!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y)) ;
        return figures[x][y];
    }

    public boolean setFigure(final int x, final int y, final Figure figure) {
        if (!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y))
            return false;

        if (figures[x][y] != null) return false;

        figures[x][y] = figure;
        return true;
    }
}


