package baseball;

import camp.nextstep.edu.missionutils.Console;

public class MessageHolder {

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printAskGameInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public String GetGameInput() {
        String playerString = Console.readLine();
        return playerString;
    }

    public int playerGameInputToInt(String playerString) {
        int playerNum = inGameStringToInt(playerString);
        return playerNum;
    }

    private int inGameStringToInt(String playerString) {
        int number = -1;
        
        errorThrow(playerString);

        number = stringToInt(playerString);

        return number;
    }

    private void errorThrow(String playerString) {
        String checkIndex = "^[0-9]{3}$";
        if (!playerString.matches(checkIndex) || checkHasSameCharacter(playerString)) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력해주십시오.");
        }
    }

    private boolean checkHasSameCharacter(String playerString) {
        boolean hasSameCharacter = false;
        if(playerString.charAt(0) == playerString.charAt(1) ||
                playerString.charAt(0) == playerString.charAt(2) ||
                        playerString.charAt(1) == playerString.charAt(2))
            hasSameCharacter = true;
            
        return hasSameCharacter;
    }

    private int stringToInt(String playerString) {
        int number = -1;
        try {
            number = Integer.parseInt(playerString);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public void printBallAndStrike(int currentBall, int currentStrike) {
        if (currentBall == 0 && currentStrike == 0) {
            System.out.println("낫싱");
        } else if (currentStrike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            System.out.printf("%d볼 %d스트라이크\n", currentBall, currentStrike);
        }
    }

    public void printAskRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public int getPlayerRestartInput() {
        int playerInput = playerRestartinputToInt();
        return playerInput;
    }

    private int playerRestartinputToInt() {
        String playerInput = Console.readLine();

        if (!(playerInput.equalsIgnoreCase("1") || playerInput.equalsIgnoreCase("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }

        int playerNum = stringToInt(playerInput);
        return playerNum;
    }

}
