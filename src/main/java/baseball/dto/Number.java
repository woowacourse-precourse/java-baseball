package baseball.dto;

import baseball.dao.ComputerNumber;
import java.util.ArrayList;
import java.util.List;

public class Number {
    private static Number number;
    private final List<ComputerNumber> database = new ArrayList<>();

    private Number() {

    }

    public static Number getInstance() {
        if (Number.number == null) {
            Number.number = new Number();
        }

        return Number.number;
    }

    public boolean insert(ComputerNumber computerNumber) {
        return database.add(computerNumber);
    }

    public boolean delete(ComputerNumber computerNumber) {
        return database.remove(computerNumber);
    }

    public List<ComputerNumber> getAll() {
        return database;
    }

    public ComputerNumber latest() {
        return database.get(database.size() - 1);
    }
}