# 기능 목록

## RandomNumber
클래스 생성시 랜덤한 3숫자를 List로 저장
* variable
  * List/<Integer> randomNumberList
    * 랜덤한 3글자를 저장하는 변수

<details>
<summary> 기능</summary>

| access modifier | method              | 설명                            |
|-----------------|---------------------|-------------------------------|
| public          | RandomNumber        | 랜덤한 3글자를 만들어 클래스에 저장          |
| public          | getNumberOfStrike   | 스트라이크의 갯수를 구한다                |
| public          | getNumberOfBall     | 볼의 갯수를 구한다                    |
| private         | getRandomNumberList | 각자 다른 숫자 3개를 만든다              |


<details>
<summary> RandomNumber</summary>

* parameter
  

* result
  *   클래스 생성 할때 랜덤한 3글자 설정

</details>

<details>
<summary> getRandomNumberList </summary>

랜덤한 3글자를 반환한다
* parameter
  

* result
  * List\<Integer>
    * 랜덤한 3글자가 저장된 List

</details>


<details>
<summary> getNumberOfStrike </summary>

클래스에 저장된 숫자와비교해 Strike의 수를 반환
* parameter
    * List/<Integer> userNumberList
        * 3자리 숫자로 구성된 list

* result
    * int numberOfStrike

</details>

<details>
<summary> getNumberOfBall </summary>

클래스에 저장된 숫자와비교해 Ball의 수를 반환
* parameter
    * List/<Integer> userNumberList
        * 3자리 숫자로 구성된 list

* result
    * int numberOfBall

</details>

</details>

## InputMapping
콘솔 입력을 내부적으로 사용할 int와 list로 변환
* variable
  * List/<Integer> randomNumberList
    * 랜덤한 3글자를 저장하는 변수

<details>
<summary> 기능</summary>

| access modifier | method                | 설명                        |
|-----------------|-----------------------|---------------------------|
| public          | InputMapping          | 콘솔을 통한 입력을 변환하기 위한 클래스    |
| public          | getGameNumberList     | 입력된 int 형 범위값을 list형태로 변환 |
| public          | getConsoleInt         | 입렵된 것이 정수이며 int형 범위값인지 검사 |
| private         | nonValidateGameNumber | 게임의 형식에 맞는지 검사            |

<details>
<summary> getGameNumberList </summary>

입력 조건이 맞는지 검사하고 반환한다

* parameter

* result
    * List/<Integer> getInputNumberList
      * 숫자의 각자리가 list로 저장

</details>

<details>
<summary> getConsoleInt </summary>

Console.readLine()을 통해 콘솔에서 값을 읽어 정수이고 int형 범위일때 int로 반환한다
아니라면 IllegalArgumentException
* parameter

* result
    * int gameNumber

</details>

<details>
<summary> nonValidateGameNumber </summary>

3자리수이며 각자리의 수가 중복되지 않는 수일때 true
아니면 false
* parameter
  * int inputNumber 
    * int형으로 변환된수
* result
    * boolean result
    
</details>

</details>

## GameString
출력을 담당할 클래스
* variable
  * START_COMMENT
    * 시작 멘트
  * INPUT_COMMENT
    * 입력을 요구하는 멘트
  * CORRECT_COMMENT
    * 맞췄을경우 멘트
  * RESTART_COMMENT
    * 다시 시작하는것을 물어보는 멘트
  * BALL_COMMENT
    * 볼을 표현하는 멘트
  * STRIKE_COMMENT
    * 스트라이크를 표현하는 멘트
  * NON_CORRECT
    * 아무것도 없을경우 표현하는 멘트

<details>
<summary> 기능</summary>

| access modifier | method            | 설명                           |
|-----------------|-------------------|------------------------------|
| public          | GameString        | 출력을 위한 String을 관리하는 클래스      |
| public          | getStartComment   | 시작멘트                         |
| public          | getCorrectComment | 정답일 경우 멘트                    |
| public          | getInputComment   | 입력을 요구하는 멘트                  |
| public          | getRestartComment | 게임을 다시 시작하는지 확인하는 멘트         |
| private         | getPlayingString  | 입력한 값의 볼과 스트라이크를 String으로 변환 |

<details>
<summary> getStartComment </summary>

시작멘트를 반환

* parameter

* result
  * String START_COMMENT

</details>

<details>
<summary> getCorrectComment </summary>

정답 멘트를 반환
* parameter

* result
  * String CORRECT_COMMENT

</details>

<details>
<summary> getInputComment </summary>

입력을 요구하는 멘트 반환
* parameter

* result
  * String INPUT_COMMENT

</details>

<details>
<summary> getRestartComment </summary>

다시 게임을 하는지 물어보는 멘트
* parameter

* result~~~~
  * String RESTART_COMMENT

</details>

<details>
<summary> getPlayingString </summary>

게임 진행사항을 String으로 변환
* parameter
  * int numberOfStrike
    * 스트라이크 갯수
  * int numberOfBall
    * 볼 갯수
    
* result
  * String resultString

</details>

</details>