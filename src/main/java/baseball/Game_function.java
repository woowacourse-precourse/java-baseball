package baseball;

import java.util.List;

public class Game_function {
    private final Print_function Print = new Print_function();
    private final Input_function Input = new Input_function();
    private final Generate_function Generate = new Generate_function();
    private final Compare_function Compare = new Compare_function();
    private final Check_function Check = new Check_function();

    public Integer play;
    private String generated_number;
    private String input_number;
    private Integer ball = 0;
    private Integer strike = 0;

    Game_function() {
        play = 1;
    }

    public void play() {
        initialize();
        start();
        while(strike != 3) {
            input();
            compare();
        }
        correct();
        restart();
    }

    private void initialize() {
        ball = 0;
        strike = 0;
        generated_number = Generate.generate_numbers();
        Check.check_valid(generated_number);
    }

    private void start() {
        Print.start_sentence();
    }

    private void input() {
        Print.input_sentence();
        input_number = Input.input();
        Print.input_number_sentence(input_number);
        Check.check_valid(input_number);
    }

    private void compare() {
        List<Integer> ball_and_strike = Compare.Compare_number(input_number, generated_number);
        int ball_index = 0;
        int strike_index = 1;

        ball = ball_and_strike.get(ball_index);
        strike = ball_and_strike.get(strike_index);
        Print.result_sentence(ball, strike);
    }

    private void correct() {
        Print.correct_sentence();
    }

    private void restart() {
        Print.restart_sentence();
        Integer input_restart = Integer.valueOf(Input.input());
        Print.restart_integer_sentence(input_restart);
        Check.check_valid(input_restart);
        if(input_restart == 2) play = 0;
    }

    public void end() {
        Print.end_sentence();
    }
}
