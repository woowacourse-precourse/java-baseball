package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ArrayList<Integer> input_list = new ArrayList<Integer>();
        Data_input input = new Data_input();
        input_list = input.get_input_value();
        Data_processing process = new Data_processing(input_list);

    }
}
