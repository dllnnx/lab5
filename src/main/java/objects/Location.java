package objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Класс локации.
 * @author dllnnx
 */
@Getter
@AllArgsConstructor
public class Location {
    private Float x; //Поле не может быть null
    private Float y; //Поле не может быть null
    private String name; //Длина строки не должна быть больше 889, Поле может быть null


    @Override
    public String toString() {
        return "Location {" +
                "name = " + name + ", " +
                "x = " + x + ", " +
                "y = " + y +
                "}";
    }
}
