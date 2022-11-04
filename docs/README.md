## NumberMaker 클래스

- 숫자 생성 메서드

        int makeNumberInRange(int min, int max) = min 이상 max 이하의 하나의 숫자를 반환
        List<Integer> makeThreeDifferentNumberListInRange(int min, int max) = min 이상 max 이하의 서로 다른 3개의 숫자를 가진 리스트를 반환

## Message 클래스

- 출력 관련 메서드

        String start() = 게임 시작 문구 반환
        String requestThreeNumbers() = 숫자 입력 요청 문구 반환
        String result(int ball, int strike) = 입력에 대한 결과를 반환
        String success() = 성공 문구 반환
        String requestNewOrStop() = 새 게임 진행 여부 문구 반환

## Referee 클래스

- 판정 관련 메서드

        void setAnswer(List<Integer> answer) = 정답을 저장한다.
        List judgeList(List<Integer> userInput) = 판정하여 strike, ball 의 갯수를 담은 리스트를 반환해준다.
        int judgeNumber(int num, int index) = strike, ball, nothing 을 판정하여 반환

## NumberBaseballGameMachine 클래스

- 게임 진행 메서드

        void makeNewAnswer() = 새로운 정답을 만듬
        void play() = 종료를 입력받기 전까지 게임을 계속 진행
        void gameProgress() = 게임을 하나를 진행
        boolean getInputResult = 입력을 요구하고 입력을 받아 결과를 출력하고 반환
        boolean askNewGameOrStop() = 게임을 지속할지 멈출지 입력을 요구하고 여부를 반환
        boolean isAnswer(List<Integer> judge) = 판정을 받아서 정답인지 (3 스트라이크) 인지 여부를 반환

- 출력 관련 메서드

        void display(String message) = message 를 출력

- 입력 관련 메서드

        String getInputLine() = enter 이전까지 입력된 문자열을 반환
        List<Integer> getThreeNumberInput() = 숫자 입력을 검증하고 리스트로 변환하여 반환
        int getNewGameOrStop() = 새로운 게임 진행 여부를 검증하고 숫자로 변환하여 반환
        void validateIndividualThreeNumber(String input) = 입력값이 1 ~ 9 사이의 서로다른 숫자 3개인지 검증
        void validateNewGameInput(String input) = 입력값이 1, 2 중 하나인지 검증
