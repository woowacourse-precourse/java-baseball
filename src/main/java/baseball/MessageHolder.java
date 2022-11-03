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
        int getInput = get_player_game_input();
        return getInput;
    }

    private int get_player_game_input() {
        String playerString = Console.readLine();
        int playerNum = in_game_string_to_int(playerString);
        return playerNum;
    }

    private int in_game_string_to_int(String playerString) {
        String checkIndex = "^[0-9]{3}$";
        int number = -1;
        if (!playerString.matches(checkIndex)) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주십시오.");
        }
        number = string_to_int(playerString);

        return number;
    }

    private int string_to_int(String playerString) {
        int number = -1;
        try {
            number = Integer.parseInt(playerString);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public void print_ball_and_strke(int currentBall, int currentStrike) {
        if(currentBall == 0 && currentStrike == 0)
        {
            System.out.println("낫싱");
        }
        else if(currentStrike == 3)
        {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else
        {
            System.out.printf("%d볼 %d스트라이크", currentBall, currentStrike);
        }
    }

    public int print_ask_restart_and_get_input() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playerInput = get_player_restart_input();
        return playerInput;
    }

    private int get_player_restart_input() {
        String playerInput = Console.readLine();
        
        if (!(playerInput.equalsIgnoreCase("1") || playerInput.equalsIgnoreCase("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }

        int playerNum = string_to_int(playerInput);
        return playerNum;
    }

}
