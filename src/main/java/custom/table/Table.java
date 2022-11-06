package custom.table;

public class Table {

    private String number;

    private Table(String number) {
        this.number = number;
    }

    public static Table init(String number) {
        return new Table(number);
    }

    public char get(int index) {
        return number.charAt(index);
    }

    public boolean contains(char character) {
        for (char elem : number.toCharArray()) {
            if (elem == character) {
                return true;
            }
        }
        return false;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
