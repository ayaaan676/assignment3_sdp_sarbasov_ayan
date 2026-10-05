public class Circle extends Shape {
    private final double radius;

    public Circle(int id, double radius, Renderer renderer) {
        super(id, renderer);
        this.radius = radius;
    }

    @Override
    public String execute() {
        return renderer.renderCircle(radius);
    }
}