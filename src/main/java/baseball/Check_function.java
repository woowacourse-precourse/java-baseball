package baseball;

import java.util.List;

public class Check_function {
    public void check_valid(String input_number) {
        List<String> input_number_list = Transformation_function.String_2_String_list(input_number);

        check_input_number_length(input_number_list);
        check_input_number_form(input_number_list);
        check_input_number_duplicated(input_number_list);
    }

    public void check_valid(Integer input_restart) {
        if(input_restart != 1 && input_restart != 2) throw new IllegalArgumentException();
    }

    private void check_input_number_length(List<String> input_number_list) {
        if(input_number_list.size() != 3) throw new IllegalArgumentException();
    }

    private void check_input_number_form(List<String> input_number_list) {
        Integer number_length = 3;

        for(int index = 0; index<number_length; index++){
            if(Integer.valueOf(input_number_list.get(index)) < 1 || Integer.valueOf(input_number_list.get(index)) > 9)
                throw new IllegalArgumentException();
        }
    }

    private void check_input_number_duplicated(List<String> input_number_list) {
        Integer index = 0;

        if(input_number_list.get(index).equals(input_number_list.get(index+1)) || input_number_list.get(index).equals(input_number_list.get(index+2)))
            throw new IllegalArgumentException();
        else if(input_number_list.get(index+1).equals(input_number_list.get(index+2)))
            throw new IllegalArgumentException();
    }
}
