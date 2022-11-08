# 미션 - [숫자 야구](https://marked-duck-24a.notion.site/f9b3106eeffe488786e3331d12aa2d15?v=61e814e6ba1a48288251dc0e2ac72ce6) 기능별 명세
# [기능 구현 전 작성한 구현할 기능 목록](https://marked-duck-24a.notion.site/2-7cae4eece5b84c709cedea48bc92ca0a)

## 1. 게임 진행 기능

## public static void processBaseballGame() {}

## 기능 상세
하단에 설명된 각 기능들을 가지고 숫자 야구 게임을 순서대로 진행하는 기능을 합니다. main 메소드에서 호출되는 메소드입니다.

## 2. 컴퓨터의 랜덤 값 생성 기능
## public static String getComputersValue() {}

### input
- **void**

### output
- **String** 컴퓨터가 선택한 세 자릿수를 저장하고 있는 문자열.

### 기능 상세
각 자릿수가 서로 다른 자연수인 세 자리 숫자를 랜덤하게 선택합니다. 그리고 이 값을 사용자가 맞혀야 할 컴퓨터의 값으로 지정하는 기능을 합니다.</br>
각 자릿수는 Randoms.pickNumberInRange(1, 9)를 호출함으로써 1부터 9까지의 수 중 랜덤한 값을 반환받아 정합니다.</br>
각 자릿수는 서로 달라야 하므로 이미 저장되어 있는 수가 중복해서 선택된다면 저장하지 않습니다.</br>
세 개의 한 자릿수가 3번 선택되어 세 자릿수가 완성되면 이 String 데이터를 반환하고 메소드를 종료합니다.

## 3. 사용자의 입력 값 검증 기능
## public static String validateUserInput(String num) {}

### input
- **String num**
  숫자 게임에서 사용자가 입력한 값

### output
- **String num**
  숫자 게임에서 사용자가 입력한 값

### 기능 상세
사용자는 컴퓨터가 선택한 수를 맞힐 때까지 반복적으로 input을 입력합니다.</br>
이 사용자의 input 값은 세자자릿수여야 하며, 각 자릿수가 서로 다른 자연수여야 합니다.</br>
이 메소드는 사용자로부터 input을 받을 때마다 그 값이 이 조건을 만족하는지 검증하고, 조건과 맞지 않는 input 값이 입력된 경우 IllegalArgumentException을 발생시키는 기능을 합니다.


## 4. ball, strike count / print result

## 4-1.
##public static void countBallStrike(String computer, String user) {}

### input
- **String computer**
  컴퓨터가 선택한 숫자 값.
- **String user**
  사용자의 입력값.

### output
- void

### 기능 상세
컴퓨터의 값과 사용자의 값간의 자릿수 비교를 통해 볼과 스트라이크의 개수를 연산하는 기능을 합니다.</br>
사용자의 입력값 user에 대해 validateUserInput()을 호출해서 검증한 후 컴퓨터가 선택한 수와의 비교를 통해 볼과 스트라이트의 개수를 구합니다.</br>
볼과 스트라이크 개수에 대한 계산이 끝난 후에는 결과 출력을 위해 printResult()를 호출합니다.

## 4-2. private static void printResult(int strike, int ball) {}

## input
- **int strike**
  현재 사용자의 input 값에 대한 스트라이크 수.
- **int ball**
  현재 사용자의 input 값에 대한 스트라이크 수.

## output
- void

### 기능 상세
ballStrikeCountFromCurrentInput()에서 받아온 strike와 ball의 개수에 따라 형식에 맞춰 결과를 출력하는 기능을 합니다.</br>
만약 3스트라이크라면 결과 메세지 출력뿐 아니라 사용자로 하여금 게임 재시작이나 종료 중 하나를 선택할 수 있게 하는 기능도 필요하기 때문에 exitOrRestart()라는 메소드를 따로 호출해 주었습니다.</br>

## 4-3. private static void exitOrRestart() {}

## input
- void
## output
- void

### 기능 상세
사용자가 컴퓨터의 선택 값을 맞혀 3스트라이크가 된 경우에 수행되어야 할 기능을 지정한 메소드입니다.</br>
우선 결과에 대한 메세지를 출력하고, 사용자로부터 1 또는 2를 입력받아 게임 재시작 여부를 결정합니다.
