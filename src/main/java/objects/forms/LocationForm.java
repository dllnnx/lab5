package objects.forms;

import commandManagement.Printable;
import objects.Location;

import java.util.Objects;

public class LocationForm extends Form{
    public LocationForm(Printable console) {
        super(console);
    }

    @Override
    public Location build() {
        return new Location(
                askFloat("координата X", Objects::nonNull, ""),
                askFloat("координата Y", Objects::nonNull, ""),
                askString("название локации", s -> s != null && s.toString().length() <= 889,
                        " Длина строки не может быть больше 889((")
        );
    }

}
