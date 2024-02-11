package objects;

import java.time.ZonedDateTime;

public class Person {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer height; //Поле не может быть null, Значение поля должно быть больше 0
    private EyeColor eyeColor; //Поле не может быть null
    private HairColor hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле не может быть null

    private static long nextId = 0;

    public Person(String name, Coordinates coordinates, ZonedDateTime creationDate, Integer height, EyeColor eyeColor, HairColor hairColor, Country nationality, Location location) {
        this.id = incNextId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public Person(long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Integer height, EyeColor eyeColor, HairColor hairColor, Country nationality, Location location) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    private static long incNextId(){
        return nextId++;
    }

    public long getId() {
        return id;
    }

    public Integer getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public Country getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Person {" + "\n" +
                "id = " + id + ",\n" +
                "name = " + name + ",\n" +
                "coordinates = " + coordinates + ",\n" +
                "creation_date = " + creationDate + ",\n" +
                "height = " + height + ",\n" +
                "eye_color = " + eyeColor + ",\n" +
                "hair_color = " + hairColor + ",\n" +
                "nationality = " + nationality + ",\n" +
                "location = " + location + "\n" +
                "}";
    }
}