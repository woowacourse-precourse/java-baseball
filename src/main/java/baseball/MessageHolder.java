package baseball;

import camp.nextstep.edu.missionutils.Console;

public class MessageHolder {

    public void init() {
    }

    public void print_start_messege() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public int print_get_game_input() {
        System.out.print("숫자를 입력해주세요 : ");
        int getInput = get_player_input();
        return getInput;
    }

    private int get_player_input() {
        String playerString = Console.readLine();
        int playerNum = string_to_int(playerString);
        return playerNum;
    }

    private int string_to_int(String playerString) {
        String checkIndex = "^[0-9]{3}$";
        int number = -1;
        if (!playerString.matches(checkIndex)) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주십시오.");
        }
        try{
            number = Integer.parseInt(playerString);
            System.out.println(number); // output = 25
        }
        catch (NumberFormatException ex){
            throw new IllegalArgumentException("세자리 숫자를 입력해주십시오.");
        }

        return number;
    }

    public void print_ball_and_strke(int currentBall, int currentStrike) {
    }

    public void print_congrate() {
    }

    public void print_game_end() {
    }

    public int print_ask_restart() {
        return 0;
    }

}
