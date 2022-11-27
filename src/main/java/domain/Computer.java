package domain;

import Controller.validation;

import java.util.List;

public class Computer{
        private static List<Integer> number;

    public static void setNumber(List<Integer> numbers) {
        number = numbers;
    }
    public static String getNumber() {
        StringBuilder numbers = new StringBuilder();

        for (Integer item : Computer.number) {
            numbers.append(item);
        }

        return numbers.toString();
    }

    public static List<Integer> getNumber_List() {
        return number;
    }
}
