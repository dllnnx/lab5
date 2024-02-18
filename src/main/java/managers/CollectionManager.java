package managers;

import exceptions.IllegalAmountOfArguments;
import exceptions.NoSuchIdException;
import lombok.Getter;
import objects.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс для работы с коллекцией
 */
@Getter
public class CollectionManager {
    private static final List<Person> collection = new LinkedList<>();
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


    public static long getFreeId(){
        if (collection.isEmpty()) return 0;
        List<Long> ids = collection.stream().map(Person::getId).collect(Collectors.toList());
        for (long i = 0; i < Collections.max(ids); i++){
            if (!ids.contains(i)) return i;
        }
        return Collections.max(ids) + 1;
    }

    public void addElement(Person person){
        collection.add(person);
    }


    public Person getById(long id){
        return collection.stream()
                .filter(x -> x.getId() == id)
                .findAny().orElse(null);
    }

    public void removeById(long id){
        if (getById(id) != null){
            collection.remove(getById(id));
        } else {
            throw new NoSuchIdException();
        }
    }

    public void clearCollection(){
        collection.clear();
    }

    public void removeFirst(){
        Person firstPerson = (Person) collection.toArray()[0];
        collection.remove(firstPerson);
    }

    public List<Person> getByHeight(int height){
        return collection.stream()
                .filter(x -> x.getHeight() == height)
                .collect(Collectors.toList());
    }

    public List<Person> filterContainsName(String name){
        return collection.stream()
                .filter(x -> x.getName().contains(name)).collect(Collectors.toList());
    }

    public Person maxByNationality(){
        return collection.stream()
                .max(Comparator.comparing(x -> x.getNationality().getThousandsOfArea()))
                .orElse(null);
    }

    public void shuffle(){
        Collections.shuffle(collection);
    }

}
