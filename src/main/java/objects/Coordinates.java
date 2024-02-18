package objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coordinates {
    private float x; //Максимальное значение поля: 737
    private double y; //Максимальное значение поля: 113

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}