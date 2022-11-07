package baseball;

//import  camp.nextstep.edu.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Application {
    static ArrayList<Integer> computerNumberList;

    public static void main(String[] args) {

        try {
            gameStart();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        return;
    }

    static ArrayList<Integer> computerGetRandom3Number() {

        ArrayList<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    static void gameStart() throws IllegalArgumentException, IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //전역변수로 수정
        //게임 재시작을 위해 위치 옮김
        computerNumberList = computerGetRandom3Number();

        while (true) {

            String strInput[] = Console.readLine().split("");

            ArrayList<Integer> input = new ArrayList<Integer>();
            for(int i=0; i<strInput.length; i++){
                input.add(Integer.parseInt(strInput[i]));
            }

            //예외처리
            if(!(input.size()==3)){
                throw new IllegalArgumentException();
            }

            int strikeNum = strikeNumber(input);
            int ballNum = ballNumber(input, strikeNum);

            if(strikeNum >0 && ballNum >0){
                bw.append(ballNum + "볼 " +strikeNum +"스트라이크");
                bw.newLine();
            }
            else if(strikeNum >0 ){
                bw.append(strikeNum +"스트라이크");
                bw.newLine();
                if(strikeNum == 3){
                    //게임종료
                    bw.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    bw.newLine();
                    bw.flush();
                    break;
                }
            }
            else if(ballNum >0){
                bw.append(ballNum + "볼");
                bw.newLine();
            }
            else {
                bw.append("낫싱");
                bw.newLine();
            }
            bw.flush();
        }
        //게임 재시작 or 종료
        gameRestartOrEnd();
        bw.close();
    }

    static int strikeNumber(ArrayList<Integer> input){

        int result=0;

        for(int i=0; i<computerNumberList.size(); i++){
            if(computerNumberList.get(i) == input.get(i)){
                result += 1;
            }
        }
        return result ;
    }

    static int ballNumber(ArrayList<Integer> input, int strike){

        int result=0;

        for(int i=0; i<computerNumberList.size(); i++){
            if(input.contains(computerNumberList.get(i))){
                result += 1;
            }
        }
        //contains 개수에서 스트라이크 개수를 빼면 ball 개수가 됨
        return result - strike;
    }

    static void gameRestartOrEnd() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        bw.newLine();
        bw.flush();
        int input = Integer.parseInt(Console.readLine());

        //재시작
        if(input == 1){
            try {
                computerNumberList.clear();
                gameStart();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        //종료
        else if(input == 2){
            return;
        }
        else {
            //잘못 입력시 종료
            throw new IllegalArgumentException("");
        }
    }
}


