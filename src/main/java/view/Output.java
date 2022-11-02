package view;

public class Output {

    public static void printStartOrEndInputError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
