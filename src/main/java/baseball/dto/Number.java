package baseball.dto;

import baseball.dao.ComputerNumber;
import java.util.LinkedList;
import java.util.List;

public class Number {
    private static Number number;
    private static final List<ComputerNumber> database = new LinkedList<>();

    private Number() {

    }

    public static Number getInstance() {
        if (number == null) {
            number = new Number();
        }

        return number;
    }

    public boolean insert(ComputerNumber computerNumber) {
        return database.add(computerNumber);
    }

    public boolean delete(ComputerNumber computerNumber) {
        return database.remove(computerNumber);
    }

    public boolean deleteAll(List<ComputerNumber> computerNumbers) {
        return database.retainAll(computerNumbers);
    }

    public List<ComputerNumber> getAll() {
        return database;
    }

    public ComputerNumber first() {
        return database.get(0);
    }
    public ComputerNumber latest() {
        return database.get(database.size() - 1);
    }
}