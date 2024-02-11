package objects;

public class Location {
    private Float x; //Поле не может быть null
    private Float y; //Поле не может быть null
    private String name; //Длина строки не должна быть больше 889, Поле может быть null

    public Location(Float x, Float y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location {" +
                "name = " + name + ", " +
                "x = " + x + ", " +
                "y = " + y +
                "}";
    }
}
