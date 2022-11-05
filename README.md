# 미션 - [숫자 야구](https://marked-duck-24a.notion.site/f9b3106eeffe488786e3331d12aa2d15?v=61e814e6ba1a48288251dc0e2ac72ce6) 기능별 명세

## 1. public static List<Integer\> getPlaceValuesFromNum(int num) {}

### input
- **int num**
    숫자 야구 과정에서 컴퓨터 혹은 사용자가 선택한 세 자릿수.

### output
- **List<Integer\>** 인덱스마다 num의 각 자리 숫자가 하나씩 저장되어 있는 리스트. 

### 기능 상세
숫자 야구를 진행하기 위해서는 수의 각 자릿수별로 비교하는 과정이 필요하기 때문에, 이를 위해 컴퓨터 또는 사용자가 선택한 수를 자릿수별로 분리하는 기능을 합니다.</br>
각 자릿수는 낮은 자리부터 높은 자리 순으로 저장됩니다.</br>
만약 자릿수 중 0이 존재하거나, num이 세 자릿수가 아닌 경우에는 잘못된 입력으로 게임이 진행될 수 없기 때문에 IllegalArgumentException을 발생시킵니다

## 2. ball, strike count / print result

## 2-1. public static void countBallStrikeFromCurrentInput(List<Integer\> computersInputList, int user) {}

### input
- **List<Integer\> computersInputList**
    컴퓨터가 선택한 숫자의 각 자릿수와 해당 숫자 자체를 저장하고 있는 리스트.
- **int user**
    사용자의 입력값.
- 
### output
- void

### 기능 상세
컴퓨터의 값과 사용자의 값간의 자릿수 비교를 통해 볼과 스트라이크의 개수를 연산하는 기능을 합니다.</br>
사용자의 입력값 user에 대해 getPlaceValuesFromNum()을 호출해서 각 자릿수별로 분리해 리스트에 저장한 후 비교를 수행합니다.

## 2-2. private static void printResult(int strike, int ball) {}

## input
- **int strike**
    현재 사용자의 input 값에 대한 스트라이크 수.
- *int ball*
    현재 사용자의 input 값에 대한 스트라이크 수.

## output
- void

### 기능 상세
ballStrikeCountFromCurrentInput()에서 받아온 strike와 ball의 개수에 따라 형식에 맞춰 결과를 출력하는 기능을 합니다.</br>
만약 3스트라이크라면 결과 메세지 출력뿐 아니라 사용자로 하여금 게임 재시작이나 종료 중 하나를 선택할 수 있게 하는 기능도 필요하기 때문에 exitOrRestart()라는 메소드를 따로 호출해 주었습니다.</br>

## 2-3. private static void exitOrRestart() {}

## input
- void
## output
- void

### 기능 상세
사용자가 컴퓨터의 선택 값을 맞혀 3스트라이크가 된 경우에 수행되어야 할 기능을 지정한 메소드입니다.</br>
우선 결과에 대한 메세지를 출력하고, 사용자로부터 1 또는 2를 입력받아 게임 재시작 여부를 결정합니다.

## 3. public static List<Integer\> getComputersValue() {}

## input
- void

## output
- **List<Integer\>** : 게임 진행을 위해 컴퓨터가 선택한 랜덤한 1~9 범위의 서로 다른 세 숫자.

## 기능 상세
컴퓨터가 사용할 서로 다른 세 자릿수를 랜덤하게 선택해 저장하는 기능을 합니다.</br>
Randoms.pickNumberInRange()를 사용하여 0이 아닌 한 자릿수를 랜덤하게 선택하고, 해당 수가 다른 자릿수에 존재하는 수가 아니라면 리스트에 추가합니다.</br>
리스트에 세 숫자가 모두 추가된 경우 리스트를 반환하고 메소드를 종료합니다.

## 4. 게임 진행 기능

## public static void processBaseballGame() {}

## 기능 상세
위에서 구현한 각 기능들을 가지고 숫자 야구 게임을 순서대로 진행하는 기능을 합니다. main 메소드에서 호출되는 메소드입니다.
