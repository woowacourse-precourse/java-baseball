package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

class input{
    public String input_string;
    public String input_number()
    {
        String input_string = Console.readLine();
        return input_string;
    }
    public void make_integer_arraylist()
    {
        this.input_string = input_number();
        System.out.println(input_string);
    }
}
public class Application {
    public static void main(String[] args) {
        input input = new input();
        input.make_integer_arraylist();
    }
}
