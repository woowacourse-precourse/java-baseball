package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

class error_check
{
    public boolean check_input_lenght(String target)
    {
        if (target.length() != 3)
        {
            return false;
        }
        return true;
    }
    public boolean check_isnum(String target)
    {
        for(int i = 0; i < target.length(); i++)
        {
            if ((!Character.isDigit(target.charAt(i))))
            {
                return false;
            }
        }
        return true;
    }
    public boolean check_duplicate(String target)
    {
        int[] check_array = new int[10];
        int now_value = 0;
        for (int i = 0; i < target.length(); i++)
        {
            now_value = Character.getNumericValue(target.charAt(i));
            check_array[now_value] += 1;
            if (check_array[now_value] > 1)
            {
                return false;
            }
        }
        return true;
    }
    public boolean launch_input_check(String target)
    {
        if (!check_input_lenght(target)) {
            return false;
        }
        if (!check_isnum(target)){
            return false;
        }
        if (!check_duplicate(target)){
            return false;
        }
        return true;
    }
}
class input{
    private String input_string;
    private String input_number()
    {
        String input_string = Console.readLine();
        return input_string;
    }
    public void make_integer_arraylist()
    {
        error_check check = new error_check();

        this.input_string = input_number();
        System.out.println(input_string);
        System.out.println(check.launch_input_check(input_string));
    }
}
public class Application {
    public static void main(String[] args) {
        input input = new input();
        input.make_integer_arraylist();
    }
}
