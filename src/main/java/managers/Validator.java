package managers;

import objects.Coordinates;
import objects.Location;
import objects.Person;

/**
 * Валидатор объектов класса Person.
 * @author dllnnx
 */
public class Validator {

    /**
     * Проверяет экземпляр класса Coordinates на валидность
     * @param coordinates Проверяемый экземпляр
     * @return true, если объект валидный, иначе false
     */
    public boolean validateCoordinates(Coordinates coordinates){
        return coordinates.getX() <= 737 && coordinates.getY() <= 113;
    }

    /**
     * Проверяет экземпляр класса Location на валидность
     * @param location Проверяемый экземпляр
     * @return true, если объект валидный, иначе false
     */
    public boolean validateLocation(Location location){
        return location.getX() != null
                && location.getY() != null
                && (location.getName() == null || location.getName().length() <= 889);
    }

    /**
     * Проверяет экземпляр класса Person на валидность
     * @param person Проверяемый экземпляр
     * @return true, если объект валидный, иначе false
     */
    public boolean validatePerson(Person person){
        return person.getName() != null && !person.getName().isBlank()
                && validateCoordinates(person.getCoordinates())
                && person.getCreationDate() != null
                && person.getHeight() != null && person.getHeight() > 0
                && person.getEyeColor() != null
                && person.getHairColor() != null
                && person.getNationality() != null
                && validateLocation(person.getLocation());

    }
}
