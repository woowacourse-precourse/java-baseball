package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {

    private static FastReader scan = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer> targetNumber = null;
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

        gameStartFunc();

    }

    public static void gameStartFunc() {
        try {
            System.out.println("숫자야구를 시작합니다.");
            setTargetNumber();
            input();

            System.out.println(targetNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(inputStr);
        }

    }

    private static void setTargetNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        targetNumber = computer;
    }

    private static void input() {
        try {
            inputStr = scan.next();
            inputValidation(inputStr);
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
