package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.error.ElementsShouldBeExactly;

import java.util.ArrayList;
import java.util.List;


class Computer{
    private int randomNumber;

    public Computer(List<Integer> computerNum){
       makeComputerNum(computerNum);
    }

    void makeComputerNum(List<Integer> computerNum){
        while (computerNum.size() < 3) {
            randomNumber = getRandomNumber();
            addComputerNum(computerNum);
        }
    }

    int getRandomNumber(){
        return Randoms.pickNumberInRange(1, 9);
    }

    void addComputerNum(List<Integer> computerNum){
        if (!computerNum.contains(randomNumber))
            computerNum.add(randomNumber);
    }
}


class User{
    private String userInput;
    private List<Integer> computerNum;
    final String RECEIVE_MESSAGE = "숫자를 입력해주세요 : ";

    public User(List<Integer> computerNum, List<Integer> userNum){
        userNum.clear();
        this.computerNum = computerNum;
        receiveUserInput(userNum);
    }

    void receiveUserInput(List<Integer> userNum){
        printReceiveMessage();
        userInput = Console.readLine();
        checkUserInput(userNum);
    }

    void checkUserInput(List<Integer> userNum){
        checkInputLength();
        checkBeforeAdd(userNum);
        addUserNum(userNum);
        Comparing comparing = new Comparing(computerNum, userNum);
    }

    void checkInputLength(){
        if (userInput.length() != 3)
            throw new IllegalArgumentException( );
    }

    void checkBeforeAdd(List<Integer> userNum) {
        for (int i = 0; i < userInput.length(); i++) {
            int userChar = userInput.charAt(i) - '0';
            checkInputRange(userChar);
            checkDuplicate(userNum, userChar);
        }
    }

    void checkInputRange(int userChar){
        if (userChar <= 0 | userChar > 9)
            throw new IllegalArgumentException();
    }

    void checkDuplicate(List<Integer> userNum, int userChar){
        if (userNum.contains(userChar))
            throw new IllegalArgumentException();
    }

    void addUserNum(List<Integer> userNum){
        for (int i = 0; i < userInput.length(); i++) {
            int userChar = userInput.charAt(i) - '0';
            userNum.add(userChar);
        }
    }

    void printReceiveMessage(){
        System.out.print(RECEIVE_MESSAGE);
    }
}

class Comparing{
    private List<Integer> computerNum;
    private List<Integer> copyUserNum;
    private int strike;

    public Comparing(List<Integer> computerNum, List<Integer> userNum){
        this.computerNum = computerNum;
        checkAnswer(userNum);
    }

    void checkAnswer(List<Integer> userNum){
        if(computerNum.equals(userNum)) {
            Message win = new Message();
        }else {
            checkSameNumber(userNum);
            getMessage(userNum);
        }
    }

    void checkSameNumber(List<Integer> userNum){
        copyUserNum = new ArrayList<>(userNum);
        copyUserNum.retainAll(computerNum);
    }

    void getMessage(List<Integer> userNum){
        if(copyUserNum.isEmpty()) {
            Message nothing = new Message(computerNum, userNum);
        }else{
            checkStrike(userNum);
            Message ballStrike = new Message(strike, copyUserNum.size() - strike, computerNum, userNum);
        }
    }

    void checkStrike(List<Integer> userNum){
        for (Integer integer : copyUserNum) {
            int computer = computerNum.indexOf(integer);
            int user = userNum.indexOf(integer);
            countStrike(computer, user);
        }
    }

    void countStrike(int computer, int user){
        if (computer == user)
            this.strike++;
    }
}

class Message{
    final String ALL_STRIKE_MESSAGE = "3스트라이크";
    final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String NOTHING_MESSAGE = "낫싱";
    final String STRIKE = "스트라이크";
    final String BALL = "볼";
    private List<Integer> computerNum;


    public Message(){
        printWin();
    }

    public Message(List<Integer> computerNum, List<Integer> userNum){
        this.computerNum = computerNum;
       printNothing(userNum);
    }

    public Message(int strike, int ball, List<Integer> computerNum, List<Integer> userNum){
        this.computerNum = computerNum;
        if(ball == 0)
            printStrike(strike, userNum);
        else if(strike == 0)
            printBall(ball, userNum);
        else
            printBallStrike(strike, ball, userNum);
    }

    void printNothing(List<Integer> userNum){
        System.out.println(NOTHING_MESSAGE);
        User user = new User(computerNum, userNum);
    }

    void printWin(){
        System.out.println(ALL_STRIKE_MESSAGE);
        System.out.println(WINNING_MESSAGE);
        chooseCondition();
    }

    void printStrike(int strike, List<Integer> userNum){
        System.out.println(strike + STRIKE);
        User user = new User(computerNum, userNum);
    }

    void printBall(int ball, List<Integer> userNum){
        System.out.println(ball + BALL);
        User user = new User(computerNum, userNum);
    }

    void printBallStrike(int strike, int ball, List<Integer> userNum){
        System.out.println(ball + BALL + " " + strike + STRIKE);
        User user = new User(computerNum, userNum);
    }

    void chooseCondition(){
        Game game = new Game();
        game.chooseGameConditions();
    }
}

class GameCondition{
    String condition;
    String CHOOSE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public GameCondition(){
        System.out.println(CHOOSE_MESSAGE);
        condition = Console.readLine();
        bringCondition();
    }

    void bringCondition() {
        if (condition.equals("1"))
            restart();
        else
           exit();
    }

    void restart(){
        Game restart = new Game();
        restart.start();
    }

    void exit(){
        Game end = new Game();
        end.end();
    }
}


public class Game {
    private List<Integer> computerNum = new ArrayList<>();
    private List<Integer> userNum = new ArrayList<>();

    public Game(){
        Computer baseball = new Computer(computerNum);
    }

    void start(){
        printStartMessage();
        User user = new User(computerNum,userNum);
    }

    void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    void end(){
       printEndMessage();
    }

    void printEndMessage(){
        System.out.println("게임 종료");
    }

    void chooseGameConditions(){
        GameCondition condition = new GameCondition();
    }
}
