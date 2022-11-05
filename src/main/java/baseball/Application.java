package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        int answer = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(111,999);
        int userInput = getUserInput();

        System.out.println(userInput);
    }

    public static int getUserInput(){
        System.out.print("숫자를 입력해주세요 : ");

        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        int userGuess = validateUserInput(userInput);

        return userGuess;
    }

    private static int validateUserInput(String userInput) throws IllegalArgumentException{
        try{
            int userGuess = Integer.parseInt(userInput);

            if (userInput.length()!=3){
                throw new IllegalArgumentException("Wrong input length");
            }
            return userGuess;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Input should be 3 digit numbers in the range of 111~999");
        }
    }
}
