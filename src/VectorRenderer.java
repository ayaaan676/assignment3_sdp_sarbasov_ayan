public class VectorRenderer implements Renderer {

    @Override
    public String renderCircle(double radius) {
        return "VECTOR circle radius=" + format(radius);
    }

    @Override
    public String renderSquare(double side) {
        return "VECTOR square side=" + format(side);
    }

    private String format(double value) {
        return value == (int) value
                ? String.valueOf((int) value)
                : String.valueOf(value);
    }
}