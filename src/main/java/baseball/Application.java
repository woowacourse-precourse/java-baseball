package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

class error_check
{
    private String target;
    private boolean check_input_lenght()
    {
        if (this.target.length() != 3)
        {
            return false;
        }
        return true;
    }
    private boolean check_isnum()
    {
        int temp_num = 0;
        for(int i = 0; i < this.target.length(); i++)
        {
            temp_num = Character.getNumericValue(this.target.charAt(i));
            if (!(temp_num > 0 && temp_num < 10))
            {
                return false;
            }
        }
        return true;
    }
    private boolean check_duplicate()
    {
        int[] check_array = new int[10];
        int now_value = 0;
        for (int i = 0; i < this.target.length(); i++)
        {
            now_value = Character.getNumericValue(this.target.charAt(i));
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
        this.target = target;

        if (check_input_lenght() == false) {
            return false;
        }
        if (check_isnum() == false){
            return false;
        }
        if (check_duplicate() == false){
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
    private ArrayList<Integer> make_integer_list()
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int tmp = 0;
        for (int i = 0; i < this.input_string.length(); i++)
        {
            tmp = Character.getNumericValue(this.input_string.charAt(i));
            result.add(tmp);
        }
        return result;
    }
    public ArrayList<Integer> get_input_value() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        error_check num_check = new error_check();
        this.input_string = input_number();

        if (num_check.launch_input_check(this.input_string) == false)
        {
            throw new IllegalArgumentException();
        }
        result = make_integer_list();
        return result;
    }
}


public class Application {
    public static void main(String[] args) {
        ArrayList<Integer> input_list = new ArrayList<Integer>();
        input input = new input();
        input_list = input.get_input_value();
        System.out.println(input_list);
    }
}
