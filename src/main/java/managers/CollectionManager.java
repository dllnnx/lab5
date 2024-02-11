package managers;

import exceptions.IllegalAmountOfArguments;
import exceptions.NoSuchIdException;
import objects.Person;

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

    public Person getById(long id){
        for (Person person : collection) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new NoSuchIdException();
    }

    public void removeById(long id){
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

    public Person maxByNationality(){
        int maxNat = collection.get(0).getNationality().getThousandsOfArea();
        Person maxPerson = collection.get(0);
        for (Person person: collection){
            if (person.getNationality().getThousandsOfArea() > maxNat){
                maxNat = person.getNationality().getThousandsOfArea();
                maxPerson = person;
            }
        }
        return maxPerson;
    }

    public void shuffle(String[] args){
        if (!(args.length == 0)) throw new IllegalAmountOfArguments();
        Collections.shuffle(collection);
    }

}
