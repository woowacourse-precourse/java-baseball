package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ArrayList<Integer> input_list = new ArrayList<Integer>();
        Input input = new Input();

        input_list = input.get_input_value();
        System.out.println(input_list);
    }
}
