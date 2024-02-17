package managers;

import objects.Coordinates;
import objects.Location;
import objects.Person;

public class Validator {

    public boolean validateCoordinates(Coordinates coordinates){
        return coordinates.getX() <= 737 && coordinates.getY() <= 113;
    }

    public boolean validateLocation(Location location){
        return location.getX() != null
                && location.getY() != null
                && (location.getName() == null || location.getName().length() <= 889);
    }

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
