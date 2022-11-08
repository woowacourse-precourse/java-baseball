package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int on = 1;
        System.out.println("start baseball game.");
        while (on == 1) {
            int computerNumber = setRandNum();
            input(computerNumber);
            System.out.println("restart : 1 or exit : 2");
            on = Integer.parseInt(Console.readLine());
        }
    }

    static int setRandNum(){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++){
            int number = getNotDuplicateNum(list, i);
            list.add(number);
        }
        return list.get(0)*100 + list.get(1)*10 + list.get(2);
    }

    static int getNotDuplicateNum(List<Integer> list, int index){
        int number = Randoms.pickNumberInRange(1, 9);

        while(isDuplicate(list, number, index)){
            number = Randoms.pickNumberInRange(1, 9);
        }

        return number;
    }

    static boolean isDuplicate(List<Integer> list, int number, int index){
        for(int i = 0; i < index; i++)
            if(list.get(i) == number)
                return true;
        return false;
    }

    static void input(int computerNumber){
        boolean correct = false;
        System.out.println(computerNumber);

        while(!correct) {
            Score scr = new Score();

            System.out.print("input number : ");
            int userNumber = Integer.parseInt(Console.readLine());

            compare(scr, computerNumber, userNumber);

            if(scr.numberOfStrikes == 3)
                correct = true;
            else if(scr.getNumberOfBalls() != 0 || scr.getNumberOfStrikes() != 0)
                scr.printScore();
            else
                System.out.println("nothing");
        }
    }

//input

    static void compare(Score scr, int num1, int num2) {
        List<Integer> num1List = setList(num1);
        List<Integer> num2List = setList(num2);

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                check(num1List.get(i), num2List.get(j), i, j, scr, num1List, num2List);
        }

    }

    static List<Integer> setList(int num) {
        String numToStr = String.valueOf(num);
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<3; i++) {
            list.add(numToStr.charAt(i) - '0');
        }

        return list;
    }


    static void check(int n1, int n2, int i1, int i2, Score scr, List<Integer> list1, List<Integer> list2){
        if(isStrike(n1, n2, i1, i2)) {
            scr.addNumberOfStrikes();
        } else if(isBall(n1, n2, i1, i2)){
            scr.addNumberOfBalls();
        }
    }


    static boolean isStrike(int n1, int n2, int i1, int i2){
        if(n1 == n2 && i1 == i2)
            return true;
        else return false;
    }

    static boolean isBall(int n1, int n2, int i1, int i2){
        if(n1 == n2 && i1 != i2)
            return true;
        else return false;
    }


    static class Score {
        int numberOfStrikes = 0;
        int numberOfBalls = 0;

        void addNumberOfStrikes() {
            numberOfStrikes++;
        }

        void addNumberOfBalls() {
            numberOfBalls++;
        }

        int getNumberOfStrikes() {
            return numberOfStrikes;
        }

        int getNumberOfBalls() {
            return  numberOfBalls;
        }

        void printScore() {
            System.out.println(numberOfBalls + "ball " + numberOfStrikes + "strike");
        }
    }
}
