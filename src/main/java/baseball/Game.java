package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    final static String GAME_START_GUIDE_MESSAGE = "숫자 야구 게임을 시작합니다.";
    final static String PLAYER_INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
    final static String WIN_CONDITION = "3스트라이크";
    final static String WIN_GUIDE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final static int NUMBER_LENGTH = 3;
    String gamePlayerInput;
    private Computer computer;

    Game() {
        this.computer = new Computer();
    }

    public void play() {
        printGuideMessage(GAME_START_GUIDE_MESSAGE);
        while (true) {
            printGuideMessage(PLAYER_INPUT_GUIDE_MESSAGE);
            gamePlayerInput = getGamePlayerInput();
            checkGamePlayerNumberInput(gamePlayerInput);
            String result = getResult(computer.getRandomNumbers().toString(), gamePlayerInput);
            System.out.println(result);
            if (result == WIN_CONDITION) {
                printGuideMessage(WIN_GUIDE_MESSAGE);
                break;
            }
        }
    }

    public void printGuideMessage(String guideMessage) {
        System.out.println(guideMessage);
    }

    public void printGuideMessage(String guideMessage, String guideMessage2) {
        System.out.println(guideMessage);
        System.out.println(guideMessage2);
    }

    public String getGamePlayerInput() {
        printGuideMessage(PLAYER_INPUT_GUIDE_MESSAGE);

        return Console.readLine();
    }

    public void checkGamePlayerNumberInput(String gamePlayerNumberInput) {
        checkNumberLength(gamePlayerNumberInput);
        hasSameNumber(gamePlayerNumberInput);
        hasCharacters(gamePlayerNumberInput);
        hasZero(gamePlayerNumberInput);
    }

    public String getResult(String computerRandomNumbers, String gamePlayerInput) {
        Integer strikes = countStrikes(computerRandomNumbers, gamePlayerInput);
        Integer balls = countBalls(computerRandomNumbers, gamePlayerInput );
        StringBuilder result = new StringBuilder();

        if (strikes > 0) {
            result.append(strikes + "스트라이크 ");
        }

        if (balls > 0) {
            result.append((balls - strikes) + "볼 ");
        }

        if (strikes == balls && balls == 0) {
            result.append("낫싱");
        }

        return result.toString();
    }

    private Integer countStrikes(String computerRandomNumbers, String gamePlayerInput) {
        int strikes = 0;
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (computerRandomNumbers.charAt(stringIndex) == gamePlayerInput.charAt(stringIndex)) {
                strikes++;
            }
        }
        return strikes;
    }

    private Integer countBalls(String computerRandomNumbers, String gamePlayerInput) {
        int balls = 0;
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (computerRandomNumbers.contains(Character.toString(gamePlayerInput.charAt(stringIndex)))) {
                balls++;
            }
        }
        return balls;
    }

    private void checkNumberLength(String stringGamePlayerInput) {
        int stringLength =  stringGamePlayerInput.length();
        if (stringLength > NUMBER_LENGTH || stringLength < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void hasSameNumber(String gamePlayerInput) {
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (gamePlayerInput.lastIndexOf(gamePlayerInput.charAt(stringIndex)) != stringIndex) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void hasCharacters(String gamePlayerInput) {
        String regex = "^[0-9]*$";
        if (!gamePlayerInput.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    private void hasZero(String gamePlayerInput) {
        if (gamePlayerInput.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

}