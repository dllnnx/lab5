package objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class Person implements Comparable<Person> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer height; //Поле не может быть null, Значение поля должно быть больше 0
    private EyeColor eyeColor; //Поле не может быть null
    private HairColor hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле не может быть null


    @Override
    public String toString() {
        return "Person {" + "\n" +
                "id = " + id + ",\n" +
                "name = " + name + ",\n" +
                "coordinates = " + coordinates + ",\n" +
                "creation_date = " + creationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")) + ",\n" +
                "height = " + height + ",\n" +
                "eye_color = " + eyeColor + ",\n" +
                "hair_color = " + hairColor + ",\n" +
                "nationality = " + nationality + ",\n" +
                "location = " + location + "\n" +
                "}";
    }


    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}