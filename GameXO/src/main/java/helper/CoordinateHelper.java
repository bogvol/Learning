package helper;

/**
 * Created by Kengoroo_a on 02.04.2017.
 */
public class CoordinateHelper {

    private static int MIN_COORDINATE = 0;

    private static int MAX_COORDINATE = 2;

    public static boolean checkCoordinate(final int coordinate) {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) return false;
        return true;
    }
}
