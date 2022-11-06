package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int play=1;
        List <Integer> computernum=new ArrayList<Integer>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(play==1) {
            makecomputernum(computernum);
            baseballgame(computernum);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            play=Integer.parseInt(Console.readLine());
            computernum.clear();
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
    public static void baseballgame(List<Integer> computer){
        System.out.println("숫자 야구 게임을 시작합니다.");
        int strike=0;
        int ball=0;
        String usernum;
        int count[]=new int[2];//0인덱스는 스트라이크 1인덱스는 볼
        while(count[0]<3){
            Arrays.fill(count,0);
            System.out.print("숫자를 입력해주세요 :");
            usernum=Console.readLine();
            System.out.println(usernum);
            Errorcheck(usernum);
            for(int i=0;i<usernum.length();i++) {
                pitch((usernum.charAt(i)-'0'), computer, i, count);
            }
            if(count[0]==0&&count[1]==0)
                System.out.println("낫싱");
            if(count[1]!=0)
                System.out.print(count[1]+"볼 ");
            if(count[0]!=0)
                System.out.println(count[0]+"스트라이크");
        }
    }
    public static void pitch(int usernum,List<Integer> computernum,int index,int[] count){
        if(computernum.contains(usernum)){
            if(index==computernum.indexOf(usernum))
                count[0]=count[0]+1;
            else
                count[1]=count[1]+1;
        }
    }
    public static void Errorcheck(String usernum){
        if(usernum.length()!=3)
            throw new IllegalArgumentException();
        for(int i=0;i<usernum.length();i++){
            if(!(usernum.charAt(i)<='9'&&usernum.charAt(i)>='1'))
                throw new IllegalArgumentException();
        }
    }
}
