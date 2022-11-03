# 기능 요구사항 정리

## 입력
* inputNumber (숫자 입력)
    * -> 유효성 확인(checkInputValid / checkCommandValid)
    * -> 숫자 처리 로직

## 처리
* gameStart (시작 처리)
    * -> inputNumber
* gameEnd (종료 처리)
* checkInputValid (input 유효성 확인)
    * -> 유효하다면 숫자 처리 로직
* checkCommandValid (명령어 유효성 확인)
    * -> 유효하다면 명령어 처리
* gameMainLogic (숫자 처리 로직)
    * -> getStrikes
    * -> getBalls
    * -> 결과 출력
* getStrikes (스트라이크 갯수 반환)
* getBalls (볼 갯수 반환)

## 출력
* startMessage (시작 안내 출력)
* endMessage (종료 안내 출력)
* scoreMessage (점수 메시지 출력)
