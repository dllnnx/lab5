package commandManagement;

import exceptions.NoSuchIdException;

public interface CommandInterface {
    void execute(String[] args);
}
