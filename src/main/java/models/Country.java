package models;

public enum Country{
    RUSSIA(17000),
    UNITED_KINGDOM(243),
    ITALY(302);

    private int thousandsOfArea;

    Country(int thousandsOfArea) {
        this.thousandsOfArea = thousandsOfArea;
    }

    public int getThousandsOfArea() {
        return thousandsOfArea;
    }
}
