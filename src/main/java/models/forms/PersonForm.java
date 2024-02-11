package models.forms;

import commandManagement.*;
import models.*;

import java.time.ZonedDateTime;
import java.util.Objects;

public class PersonForm extends Form<Person>{
    private final Printable console;
    private final UserInput scanner;

    public PersonForm(Printable console) {
        super(console);
        this.console = (Console.isFileMode()) ? new BlankConsole() : console;
        this.scanner = new ConsoleInput(); // добавить сканер с файлов
    }


    @Override
    public Person build() {
        return new Person(
                askString("имя", s -> s != null && s.isEmpty()),
                askCoordinates(),
                ZonedDateTime.now(),
                askInteger("рост", s -> s != null && s > 0),
                askEyeColor(),
                askHairColor(),
                askCountry(),
                askLocation()
        );
    }

    public Person build(long id) {
        return new Person(
                id,
                askString("имя", s -> s != null && s.isEmpty()),
                askCoordinates(),
                ZonedDateTime.now(),
                askInteger("рост", s -> s != null && s > 0),
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
