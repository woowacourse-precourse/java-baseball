package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Input {
    private String input_string;

    Input()
    {
        this.input_string = input_number();
    }

    private String input_number() {
        String input_string = Console.readLine();
        return input_string;
    }

    private ArrayList<Integer> make_integer_list() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int tmp = 0;

        for (int i = 0; i < this.input_string.length(); i++) {
            tmp = Character.getNumericValue(this.input_string.charAt(i));
            result.add(tmp);
        }
        return result;
    }

    public ArrayList<Integer> get_input_value() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Error_check num_check = new Error_check(this.input_string);

        if (num_check.launch_input_check() == false) {
            throw new IllegalArgumentException();
        }
        result = make_integer_list();
        return result;
    }
}
