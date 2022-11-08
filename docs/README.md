# 기능 정의

***

## 기능 구현 과정 블로깅

***

[[우테코 프리코스] 2주차 미션 : 숫자 야구 게임 회고록](https://velog.io/@rg970604/%EC%9A%B0%ED%85%8C%EC%BD%94-%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-2%EC%A3%BC%EC%B0%A8-%EB%AF%B8%EC%85%98-%EC%88%AB%EC%9E%90-%EC%95%BC%EA%B5%AC-%EA%B2%8C%EC%9E%84-%ED%9A%8C%EA%B3%A0%EB%A1%9D)

## 패키지 구조 정리

***

- domain
    - BallCount.java (1회 시도에 대한 볼, 스트라이크 정보와 볼카운트 정보 출력 결과 반환)
    - Numbers.java (유저 혹은 컴퓨터가 제시하는 리스트에 대해 검증 후 올바른 리스트를 반환)
    - Ball.java (볼에 대한 정보 및 카운트 추가를 관리)
    - Strike.java (스트라이크에 대한 정보 및 카운트 추가를 관리)
- gamePlay
    - GamePlay.java (게임 진행에 대한 로직을 담당)
- rule
    - EndRule.java (게임 종료에 대한 규칙을 담당)
    - JudgeMentRule.java (유저가 제시한 번호와 컴퓨터가 생성한 번호에 대한 볼, 스트라이크 판정을 담당)
- strategy
    - NumberProducingStrategy.java (컴퓨터가 각 게임에서 사용하는 번호 생성 전략을 명시하는 인터페이스)
    - RamdomNumberProducingStrategy.java (NumberProducingStrategy.java 를 상속받아 랜덤으로 1에서 9사이의 중복되지 않는
      세 수를 생성)
- view
    - PrintResult.java (결과 값을 전달받아 화면에 출력하는 역할 담당)
    - UserInput.java (게임 진행에 필요한 유저 입력값을 받아 변환, 게임 시작 및 종료 여부 입력을 받음)
- util
    - Validator.java (검증 로직들을 담당)
- Application.java (실제 게임 실행을 담당)

## 클래스별 기능 정리

***

- view
    - UserInput.java :
        1. 유저로부터 컴퓨터 숫자와 비교할 문자열을 입력 받는다
        2. 사용자가 입력한 문자열을 정수형 리스트로 변환
        3. 유저로부터 게임 종료 여부를 결정할 문자열을 입력 받는다
    - PrintResult.java :
        1. 유저의 입력에 대한 볼카운트 정보를 출력한다
        2. 유저가 모든 숫자를 맞추면(3스트라이크) 경기 종료 멘트를 출력한다
- domain
    - Numbers.java :
        1. 비교를 위한 세 자릿 수 번호 목록을 저장한다
    - BallCount.java :
        1. 볼-스트라이크 판단이 완료된 결과를 담는다
        2. 본 객체의 카운트 정보를 응답한다
    - Ball.java :
        1. 볼의 카운트 정보를 관리한다
        2. 볼 카운트를 추가한다.
    - Strike.java :
        1. 스트라이크의 카운트 정보를 관리한다
        2. 스트라이크 카운트를 추가한다.
- strategy
    - NumberProducingStrategy.java :
        1. 컴퓨터가 정수형 리스트를 생성한다
    - RandomNumberProducingStrategy.java
        1. 컴퓨터가 1~9 사이의 랜덤 수로 이루어진 정수형 리스트를 생성한다
        2. 이미 리스트에 존재하는 정수가 아닌 경우에만 리스트에 정수를 넣는다
- rule
    - EndRule.java :
        1. 게임과 프로그램 종료 여부를 판정한다
        2. 3스트라이크 판정시 게임 종료를 판정한다
        3. 게임 종료 후 1 입력시 새로 시작, 2 입력시 프로그램 종료를 판정한다
    - JudgementRule.java :
        1. 컴퓨터가 생성한 수와, 유저가 제시한 수를 비교하여 볼카운트를 계산한다
- gamePlay
    - GamePlay.java :
        1. 야구 게임 프로그램을 실행한다
        2. 사용자가 종료 버튼을 누르면 프로그램이 종료된다
        3. 게임 1판을 시작한다
        4. 사용자가 정답을 맞출 때 까지 게임을 진행한다
        5. 사용자가 정답을 맞췄는지 판단한다
- util
    - Validator.java :
        1. 중복된 숫자 발견시 예외 처리한다
        2. 숫자가 3개 입력되지 않을 시 예외 처리한다
        3. 0~3 이외의 볼/스크라이크 카운트에 대해 예외 처리한다
        4. 게임 재시작 결정 시 잘못된 입력에 대해 예외 처리한다.