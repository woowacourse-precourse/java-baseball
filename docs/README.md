---

## Number Baseball Game


### 설명 요약

    - 1~9 까지 서로 다른 수로 이루어진 3자리 수를 맞추는 게임
    - 3 스트라이크하면 게임 종료


<br/>

### 기능 설계
    - playGame          => 게임 실행 (맞출 때까지 반복)

    - targetNumbers     => 맞춰야 할 3자리 수 만들기

    - tryNumbers        => 3자리 수 시도해서 해당 시도

    - playAgain         => 1이면 재시작 & 2이면 종료

    - getBallStrikeLog  => 볼 & 스트라이크 Log 출력

    - checkError        => 잘못된 값을 입력한 경우 IllegalArgumentException 후 종료
    