package objects.forms;

import commandManagement.*;
import managers.CollectionManager;
import objects.*;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Класс для формирования объектов типа {@link Person}.
 * @author dllnnx
 */
public class PersonForm extends Form<Person>{
    private final Printable console;

    public PersonForm(Printable console) {
        super(console);
        this.console = (Console.isFileMode()) ? new FileConsole() : console;
    }


    /**
     * Собирает новый объект класса {@link Person}
     * @return Объект класса {@link Person}
     */
    @Override
    public Person build() {
        return new Person(
                CollectionManager.getFreeId(),
                askString("имя","", s -> s != null && !s.isBlank(),
                        " Имя не может быть пустым(("),
                askCoordinates(),
                ZonedDateTime.now(),
                askInteger("рост", ". Значение поля должно быть больше 0",
                        s -> s != null && s > 0, " Минимальное значение поля: 1."),
                askEyeColor(),
                askHairColor(),
                askCountry(),
                askLocation()
        );
    }

    public Person build(long id) {
        return new Person(
                id,
                askString("имя", "", s -> s != null && !s.isBlank(),
                        " Имя не может быть пустым(("),
                askCoordinates(),
                ZonedDateTime.now(),
                askInteger("рост", ". Значение поля должно быть больше 0",
                        s -> s != null && s > 0, " Минимальное значение поля: 1."),
                askEyeColor(),
                askHairColor(),
                askCountry(),
                askLocation()
        );
    }


    private Coordinates askCoordinates(){
        return new CoordinatesForm(console).build();
    }

    private EyeColor askEyeColor(){
        return (EyeColor) askEnum(EyeColor.values(), "цвета глаз", Objects::nonNull);
    }

    private HairColor askHairColor(){
        return (HairColor) askEnum(HairColor.values(), "цвета волос", Objects::nonNull);
    }

    private Country askCountry(){
        return (Country) askEnum(Country.values(), "страны происхождения", Objects::nonNull);
    }

    private Location askLocation(){
        return new LocationForm(console).build();
    }
}
