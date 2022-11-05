구현 기능 목록

## Application 클래스
 - BaseballGame 한 게임 만들기
 - 생성하기만 하면 하나의 게임이 실행되도록 만들기

## BaseballGame 클래스
    strike, ball, status(게임진행상태), correctNum(맞혀야 하는 숫자) 필드 정의
    생성 후 status = true, 랜덤 값 생성
    랜덤 값 생성 메소드 정의
    strike, ball, status - getter 정의
    getCorrectNum - getter 정의
    endGame 메소드 정의

## inputoutput 패키지

#### Inputting 클래스
    서로 다른 3개의 숫자로 입력받는 메소드 정의
    LinkedHashSet 객체로 BaseballGame에 리턴
    게임이 끝나면 '1'과 '2'를 입력받는 메소드 정의

#### Outputting 클래스
    볼, 스트라이크, 낫싱 문자열 입력
    라인 기준으로 출력 처리
    게임 끝 메시지 출력 처리
    게임 종료 출력 처리
    BufferedWriter.close 메소드 정의

## calculate 패키지

#### BaseballCalculator 클래스
    strike 개수 연산 후 반환
    ball 개수 연산 후 반환

## domain 패키지

#### Ball 클래스
    Ball이라는 가상 물체를 대변하는 클래스 정의
    Ball이 가지고 있는 속성(ball)에 대한 +1 정의
    Ball이 가지고 있는 속성 초기화 메소드 정의

#### Strike 클래스
    Strike이라는 가상 물체를 대변하는 클래스 정의
    Strike이 가지고 있는 속성(strike)에 대한 +1 정의
    Strike이 가지고 있는 속성 초기화 메소드 정의

- - -

# 추가 요구 사항

+ indent depth를 3이 넘지 않도록
+ 3항 연산자 쓰지 않는다.
+ 컨벤션에 맞게 쓴다.
+ 함수가 한가지 일만 하도록 최대한 작게 만든다.
+ 내가 스스로 테스트 케이스를 작성해본다.