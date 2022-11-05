package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Application {
    public static void main(String[] args)throws IOException {
        // TODO: 프로그램 구현
        int play=1;
        List <Integer> computernum=new ArrayList<Integer>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(play==1) {
            makecomputernum(computernum);
            baseballgame(computernum);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            play=br.read();
        }
    }
    public static void makecomputernum(List<Integer> computer){
        int randomnum;
        while(computer.size()<3){
            randomnum= Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomnum))
                computer.add(randomnum);
        }
    }
}
