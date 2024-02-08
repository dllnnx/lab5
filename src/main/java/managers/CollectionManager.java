package managers;

import models.Person;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для работы с коллекцией
 */
public class CollectionManager {
    private final List<Person> collection = new LinkedList<>();

    public List<Person> getCollection() {
        return collection;
    }

    public String collectionType(){
        return collection.getClass().getName();
    }

    public int collectionSize(){
        return collection.size();
    }

    public void addElement(Person person){
        collection.add(person);
    }

    public void addElements(Collection<Person> persons){
        if (collection == null) return;
        collection.addAll(persons);
    }

}
