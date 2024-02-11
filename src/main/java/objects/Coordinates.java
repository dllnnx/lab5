package objects;

public class Coordinates {
    private float x; //Максимальное значение поля: 737
    private double y; //Максимальное значение поля: 113

    public Coordinates(float x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}