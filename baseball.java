public class BaseBall {
    private static int strikeCnt;
    private static int ballCnt;
    
    public void run() {
        String generate = RandomNumberGenerator.generate();
        while(strikeCnt != 3) {
            computed(Input.number(), generate);
            Output.print();
        }
        restart();
    }
    
    private void restart() {
        int trigger = Input.restartQuestion();
        if(trigger == 1) {
            new BaseBall().run();
        }
        if(trigger == 0) {
            System.out.println("게임을 종료합니다");
            System.exit(0);
        }
    }
    
    private void computed(String inputs, String generate) {
        strikeCnt = 0;
        ballCnt = 0;
        
        for(int i = 0; i < inputs.length(); i++) {
            isBall(inputs, generate, i);
            isStrike(inputs, generate, i);
        }
    }
    
    private void isBall(String inputs, String generate, int idx) {
        if(inputs.charAt(idx) != generate.charAt(idx) && generate.contains(Character.toString(inputs.charAt(idx)))) {
            ballCnt++;
        }
    }
    
    private void isStrike(String inputs, String generate, int idx) {
        if(inputs.charAt(idx) == generate.charAt(idx)) {
            strikeCnt++;
        }
    }
    
    private static class RandomNumberGenerator {
        private static final int MIN = 1;
        private static final int MAX = 9;
        
        private static String generate() {
            Set<Integer> set = new HashSet<>();
            Random random = new Random();
            
            while(set.size() < 3) {
                set.add(random.nextInt(MAX) + MIN);
            }
            
            StringBuilder stringBuilder = new StringBuilder();
            set.forEach(stringBuilder::append);
            
            return stringBuilder.toString();
        }
    }
    
    private static class Input {
        private static String number() {
            System.out.print("\n숫자를 입력해 주세요 : ");
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        }
        
        private static int restartQuestion() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        }
    }
    
    private static class Output {
        private static void print() {
            if(ballCnt != 0) {
                System.out.print(ballCnt + "볼 ");
            }
            if(strikeCnt != 0) {
                System.out.print(strikeCnt + "스트라이크");
            }
            if(strikeCnt == 0 && ballCnt == 0) {
                System.out.print("낫싱");
            }
            if(strikeCnt == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }
}
