## 📃 기능 목록 정리

### package src.main.java.baseball.user.entity

### class User

> - [ ] 사용자의 입력값을 받는 클래스입니다.

<br>

### package src.main.java.baseball.user.service

### class UserService

> - [ ] 사용자의 입력값과 관련해 처리하는 클래스입니다. (핵심로직 분리)

<br>

### package src.main.java.baseball.user.exception

### class UserExceptionHandler

> - [ ] 게임의 제한 조건에 대한 Exception을 처리하는 클래스입니다.

<br>

1. 예외의 종류
   - [ ] 사용자의 입력 숫자가 3개 이상 입력된 경우 ` IllegalArgumentException`발생
   - [ ] 사용자의 입력 숫자에 0이 들어간 경우 `IllegalArgumentException` 발생
   - [ ] 사용자의 입력 숫자에 중복되는 숫자가 들어간 경우 `IllegalArgumentException` 발생
   - [ ] 사용자의 입력 숫자가 띄어져있거나, 다른 문자가 들어간 경우 `IllegalArgumentException` 발생

<br>

### package src.main.java.baseball.user.convert

### class NumberConvert

> - [ ] 사용자의 입력값과 관련해 변환을 돕는 클래스입니다. (핵심로직 분리)

<br>

### package src.main.java.baseball.game.entity

### class Game

> - [ ] 게임이 진행되는 클래스입니다.

<br>

### package src.main.java.baseball.computer.entity

### class Computer

> - [ ] 컴퓨터의 입력값을 받는 클래스입니다.

<br>

### package src.main.java.baseball.service

### class ComputerService

> - [ ] 컴퓨터의 입력값을 받는 클래스입니다.

<br>

### package test.java.baseball.game

### class GameTest

> - [ ] 게임이 제한 조건에 맞게 잘 동작하는지 확인하는 테스트 클래스입니다.

