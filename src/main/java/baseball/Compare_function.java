package baseball;

import java.util.ArrayList;
import java.util.List;

public class Compare_function {
    public List<Integer> Compare_number(String input_number, String generated_number) {
        List<Integer> ball_and_strike = new ArrayList<>();
        List<String> input_number_list = Transformation_function.String_2_String_list(input_number);
        List<String> generated_number_list = Transformation_function.String_2_String_list(generated_number);
        Integer strike, ball;

        strike = find_strike(input_number_list, generated_number_list);
        ball = find_ball(input_number_list, generated_number_list) - strike;

        ball_and_strike.add(ball);
        ball_and_strike.add(strike);

        return ball_and_strike;
    }

    private Integer find_strike(List<String> input_number_list, List<String> generated_number_list) {
        Integer strike = 0;

        for(int index = 0; index<input_number_list.size(); index++){
            if(Integer.valueOf(input_number_list.get(index)) == Integer.valueOf(generated_number_list.get(index))){
                strike ++;
            }
        }

        return strike;
    }

    private Integer find_ball(List<String> input_number_list, List<String> generated_number_list) {
        Integer ball = 0;

        for(int index = 0; index<input_number_list.size(); index++){
            if(generated_number_list.contains(input_number_list.get(index))){
                ball ++;
            }
        }

        return ball;
    }
}
