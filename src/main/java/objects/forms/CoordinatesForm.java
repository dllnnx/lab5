package objects.forms;

import commandManagement.Printable;
import objects.Coordinates;

public class CoordinatesForm extends Form{
    public CoordinatesForm(Printable console) {
        super(console);
    }

    @Override
    public Coordinates build() {
        return new Coordinates(
                askFloat("координата X", s -> s != null && (float) s <= 737,
                        " Максимально допустимое значение поля: 737."),
                askDouble("координата Y", s -> s!= null && (double) s <= 113,
                        " Максимально допустимое значение поля: 113.")
        );
    }
}
