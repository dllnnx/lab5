package managers;

import exceptions.NoSuchIdException;
import models.Person;

import java.util.*;

/**
 * Класс для работы с коллекцией
 */
public class CollectionManager {
    private final List<Person> collection = new LinkedList<>();
    private final Date initializationTime = new Date();

    public List<Person> getCollection() {
        return collection;
    }

    public String getCollectionType(){
        return collection.getClass().getName();
    }

    public int getCollectionSize(){
        return collection.size();
    }

    public Date getInitializationTime() {
        return initializationTime;
    }

    public void addElement(Person person){
        collection.add(person);
    }

    public Person getById(long id) throws NoSuchIdException {
        for (Person person : collection) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new NoSuchIdException();
    }

    public void removeById(long id) throws NoSuchIdException{
        try {
            collection.remove(getById(id));
        } catch (NoSuchIdException e){
            System.out.println(e);
        }
    }

    public void clearCollection(){
        collection.clear();
    }

    public void removeFirst(){
        Person firstPerson = (Person) collection.toArray()[0];
        collection.remove(firstPerson);
    }

    public ArrayList<Person> getByHeight(int height){
        ArrayList<Person> people = new ArrayList<>();
        for (Person person: collection){
            if (person.getHeight() == height){
                people.add(person);
            }
        }
        return people;
    }

    public ArrayList<Person> filterContainsName(String name){
        ArrayList<Person> people = new ArrayList<>();
        for (Person person: collection){
            if (person.getName().contains(name)){
                people.add(person);
            }
        }
        return people;
    }

}
