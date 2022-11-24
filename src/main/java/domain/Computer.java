package domain;

import Controller.validation;

import java.util.List;

public class Computer {
    public static List<Integer> number_List;

    public static void setNumber() {
        Computer.number_List = validation.get_ThreeRandomNumbers();
    }

    public static String getNumber() {
        StringBuilder numbers = new StringBuilder();

        for (Integer item : Computer.number_List) {
            numbers.append(item);
        }

        return numbers.toString();
    }

    public static List<Integer> getNumber_List() {
        return number_List;
    }
}
