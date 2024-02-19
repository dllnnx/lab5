package objects.forms;

import commandManagement.*;
import objects.Location;

import java.util.Objects;

public class LocationForm extends Form<Location>{

    public LocationForm(Printable console) {
        super(console);
    }

    @Override
    public Location build() {
        return new Location(
                askFloat("координата X", "", Objects::nonNull, ""),
                askFloat("координата Y", "", Objects::nonNull, ""),
                askString("название локации", ". Длина строки не должна превышать 889",
                        s -> s.toString().length() <= 889,
                        " Длина строки не может быть больше 889((")
        );
    }

}
