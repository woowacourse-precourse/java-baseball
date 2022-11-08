---

## Number Baseball Game


### 설명 요약

    - 1~9 까지 서로 다른 수로 이루어진 3자리 수를 맞추는 게임
    - 3 스트라이크하면 게임 종료


<br/>

### 기능 설계

    - Game   (Class)

        Game()               => computer 3자리 수 정의
        Game(String input)   => user 3자리 수 정의, user List 변환
    
        getUserGame          => user 입력 후, 예외사항 없을 시 반환
        getUserNumbers       => input 을 List 로 전환하여 반환      
        getComputerNumbers   => computer 랜덤 입력, List 반환
        getPickNumber        => Randoms.pickNumberInRange() 로 나온 숫자 반환

        runException         => 모든 예외 처리 후 IllegalArgumentException 

        checkAgainGame       => 다시 할지 묻기
        checkSuccess         => 성공했는지 확인

    - Record  (Class)

        setEachRecords       => strikeCount, ballCount 개수 세기
        displayRecord        => 이번 play 기록 출력

    - ValidCheck  (Class)

        checkRangeError      => 각 입력 숫자가 범위를 벗어난 에러 체크
        checkSizeError       => 입력값의 길이가 벗어난 에러 체크
        checkVisitedError    => 중복된 값이 있는 에러 체크
        checkIsContinueError => toBeContinue 값이 옳은지 체크
        checkIsNumberError   => 입력값이 숫자 인지 체크

    - ReferenceValue  (Class)

        SIZE                 => 전체 사이즈, 3자리
        START_RANGE          => 범위 최솟값
        END_RANGE            => 범위 최댓값
        AGAIN                => 다시 시작하는 의미의 정수값
        EXIT                 => 게임 종료하는 의미의 정수값