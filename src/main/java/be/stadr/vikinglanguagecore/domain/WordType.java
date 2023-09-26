package be.stadr.vikinglanguagecore.domain;

public enum WordType {
    NOUN(1),
    VERB(2)
    ;

    private int number;

    WordType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
