package objects.forms;

import commandManagement.*;
import objects.Coordinates;

/**
 * Класс для формирования объекта класса {@link Coordinates}.
 * @author dllnnx
 */
public class CoordinatesForm extends Form<Coordinates>{
    public CoordinatesForm(Printable console) {
        super(console);
    }

    /**
     * Собирает новый объект класса {@link Coordinates}
     * @return Объект класса {@link Coordinates}
     */
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
