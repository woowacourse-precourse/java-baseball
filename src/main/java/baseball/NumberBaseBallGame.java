package baseball;

import java.util.ArrayList;

public class NumberBaseBallGame {
	ArrayList<Integer> targetNumber;
	Computer computer = new Computer(targetNumber);

	public void play(){
		startMessage();
		do{
			gameStart();
		}while (playAgain());
	}

	public void gameStart(){
		computer.generateNumber();
		Judge judge;
		do {
			inputThreeDigitMessage();
			String playerInput = Input.readLine();
			Validate.checkCorrectInput(playerInput);
			judge = Judge.checkScore(computer.getTargetNumber(), makeStringToList(playerInput));
			printScore(judge.printHint());
		}while(!judge.isThreeStrike());
	}

	public void askRestartMessage(){
		System.out.println(Message.RESTART_GAME.getMsg());
	}

	public void inputThreeDigitMessage(){
		System.out.print(Message.INPUT_THREE_DIGIT.getMsg());
	}

	public void startMessage(){
		System.out.println(Message.GAME_START.getMsg());
	}

	public void printScore(String message){
		System.out.println(message);
	}

	public boolean playAgain(){
		askRestartMessage();
		String input = Input.readLine();
		Validate.checkRestartCodeValid(input);
		return input.equals(String.valueOf(Constant.RESTART.getNumber()));
	}


	public static ArrayList<Integer> makeStringToList(String number){
		ArrayList<Integer> playerInputNumber = new ArrayList<>();
		for (int i = 0; i < number.length();i++){
			playerInputNumber.add(Integer.parseInt(String.valueOf(number.charAt(i))));
		}
		return playerInputNumber;
	}
}
