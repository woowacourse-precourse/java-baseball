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
