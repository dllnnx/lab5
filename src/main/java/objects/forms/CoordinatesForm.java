package objects.forms;

import commandManagement.*;
import managers.ScriptManager;
import objects.Coordinates;

public class CoordinatesForm extends Form<Coordinates>{
    public CoordinatesForm(Printable console) {
        super(console);
    }

    @Override
    public Coordinates build() {
        return new Coordinates(
                askFloat("координата X", ". Значение поля не должно превышать 737",
                        s -> s != null && (float) s <= 737,
                        " Максимально допустимое значение поля: 737."),
                askDouble("координата Y", ". Значение поля не должно превышать 113",
                        s -> s!= null && (double) s <= 113,
                        " Максимально допустимое значение поля: 113.")
        );
    }
}
