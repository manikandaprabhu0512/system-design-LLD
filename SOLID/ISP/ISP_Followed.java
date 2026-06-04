package ISP;


// Separate interface for 2D shapes
interface TwoDimensionalShape {
    double area();
}

// Separate interface for 3D shapes
interface ThreeDimensionalShape {
    double area();
    double volume();
}

// Square implements only the 2D interface
class ISquare implements TwoDimensionalShape {
    private double side;

    public ISquare(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return side * side;
    }
}

// Rectangle implements only the 2D interface
class IRectangle implements TwoDimensionalShape {
    private double length, width;

    public IRectangle(double l, double w) {
        this.length = l;
        this.width  = w;
    }

    @Override
    public double area() {
        return length * width;
    }
}

// Cube implements the 3D interface
class ICube implements ThreeDimensionalShape {
    private double side;

    public ICube(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}

public class ISP_Followed {
    public static void main(String[] args) {
        TwoDimensionalShape square    = new ISquare(5);
        TwoDimensionalShape rectangle = new IRectangle(4, 6);
        ThreeDimensionalShape cube     = new ICube(3);

        System.out.println("Square Area: "    + square.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Cube Area: "      + cube.area());
        System.out.println("Cube Volume: "    + cube.volume());
    }
}
