package objects;

import lombok.Getter;

/**
 * Перечисление стран происхождения человека.
 * @author dllnnx
 */
@Getter
public enum Country{
    RUSSIA(17000),
    UNITED_KINGDOM(243),
    ITALY(302);

    private final int thousandsOfArea;

    Country(int thousandsOfArea) {
        this.thousandsOfArea = thousandsOfArea;
    }

}
