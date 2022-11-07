package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.*;
import java.util.*;

public class Application {

    private static FastReader scan = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static Map<Integer, Integer> targetNumber = null;
    private static String status = "start";
    private static List<Integer> inputNumber = null;
    private static String inputStr = null;

    public static void main(String[] args) {
        /*
         * 1. 타겟 랜덤 3자리 숫자 set
         * 2. input String validation
         *   1) status : start / end
         *   2) start : 숫자3개 말고는 다 exception
         *   3) end : 1/2 말고는 다 exception
         * 3. 진행
         *   1) 볼
         *   2) 스트라이크
         *   3) 낫싱
         *   5) 정답
         * */
        System.out.println("숫자야구를 시작합니다.");
        while("start".equals(status)){
            gameStartFunc();
        }
    }

    public static void gameStartFunc() {
        try {
            setTargetNumber();
            /*System.out.print("targetNumber : ");
            System.out.println(targetNumber);*/
            while("start".equals(status)){
                System.out.println("숫자를 입력해주세요 : ");
                input();
                compareNumber();
                System.out.println(sb.toString());
                sb.setLength(0);
            }
            gameEndFunc();
        } catch (Exception e) {
            throw new IllegalArgumentException(inputStr);
        }
    }

    public static void gameEndFunc(){
        if("end".equals(status)){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input();
            if("1".equals(inputStr)){
                status = "start";
            }
        }
    }

    private static void setTargetNumber() {
        Map<Integer, Integer> computer = new HashMap<>();
        int idx = -1;
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.containsKey(randomNumber)) {
                computer.put(randomNumber, ++idx);
            }
        }
        targetNumber = computer;
    }

    private static void input() {
        try {
            inputStr = scan.next();
            inputValidation(inputStr);
            inputNumber = new ArrayList<>();
            for(char c : inputStr.toCharArray()){
                inputNumber.add((int)c - '0');
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void inputValidation(String input) {
        if ( !validateNumber(input) || !validateStartNumber(input) || !validateEndNumber(input)){
            throw new IllegalArgumentException();
        }
    }

    private static boolean validateNumber(String str) {
        boolean rtn = true;
        for (char c : str.toCharArray()) {
            if (String.valueOf(c).matches("[^0-9]")) {
                rtn = false;
                break;
            }
        }
        return rtn;
    }

    private static boolean validateStartNumber(String str) {
        boolean rtn = true;
        if("start".equals(status) && str.length() != 3){
            rtn = false;
        }
        return rtn;
    }

    private static boolean validateEndNumber(String str) {
        boolean rtn = true;
        if("end".equals(status) && !("1".equals(str) || "2".equals(str))){
            rtn = false;
        }
        return rtn;
    }

    private static void compareNumber(){
        int[] ballStrikeList = new int[2];
        for(int num : inputNumber){
            if(targetNumber.containsKey(num)){
                checkBallOrStrike(num, ballStrikeList);
            }
        }
        setCompareResult(ballStrikeList);
    }

    private static void checkBallOrStrike(int num, int[] ballStrikeList){
        if(targetNumber.get(num) == inputNumber.indexOf(num)){
            ++ballStrikeList[1];
        }else{
            ++ballStrikeList[0];
        }
    }

    private static void setCompareResult(int[] ballStrikeList){
        if(ballStrikeList[1] == 3){
            status = "end";
        }
        if(ballStrikeList[0] > 0){
            sb.append(ballStrikeList[0]).append("볼").append(" ");
        }
        if(ballStrikeList[1] > 0){
            sb.append(ballStrikeList[1]).append("스트라이크");
        }
        if(sb.toString().length() == 0){
            sb.append("낫싱");
        }
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
