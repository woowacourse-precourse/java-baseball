package baseball;

public class Parse {

    public static Numbers StringToNumbers(String beforeString) {
        int input = Integer.parseInt(beforeString);
        return new Numbers(input);
    }

}
