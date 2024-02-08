package models.forms;

import commandManagement.Printable;
import models.Coordinates;

public class CoordinatesForm extends Form{
    public CoordinatesForm(Printable console) {
        super(console);
    }

    @Override
    public Coordinates build() {
        return new Coordinates(
                askFloat("координата X", s -> s != null && (float) s <= 737),
                askDouble("координата Y", s -> s!= null && (double) s <= 113)
        );
    }
}
