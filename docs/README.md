# BaseBall 게임 기능 목록

player : 숫자를 비교하기 편하게 입력받은 숫자들의 각 자리를 List에 저장하여 보관하는 역할을 함.
+ Computer.class : User가 맞춰야 할 숫자를 임의로 만들어 저장함.
  + createNonDuplicationRandomThreeNumbers : 랜덤으로 숫자 3개를 1~9의 범위에서 중복없이 뽑아내어 Integer형 List에 저장.
+ User.class : User가 입력한 숫자를 저장함.
  + createValidNumbers : 유효한 범위에서 입력받은 숫자들의 각 자리를 분리해 Integer형 List에 저장.

system :
+ GameSystem.class : 게임을 실행시킴과 동시에, 게임 플레이와 메뉴 선택의 진입점 역할을 함. 처음 실행될 때는 게임이 플레이되며 게임이 끝난 후 메뉴 선택이 가능함.
  + printRunGameText : 게임이 실행되었음을 알리는 문구 출력.
  + startGame : 게임 플레이의 진입점.
  + selectMenu : 메뉴를 선택의 진입점.
+ progress :
  + GamePlay.class : 게임 진행이 시작됨. 3개의 숫자를 입력을 받아 User의 숫자를 설정하고 맞춰야 할 Computer의 숫자와 비교함. 정답을 맞힐 때까지 이 과정을 반복.
    + printInputText : 유추하고 있는 숫자를 입력하라는 안내 문구 출력.
    + InputThreeNumbers : 숫자를 입력받고, 입력받은 숫자를 User의 숫자로 설정해줌.
    + printGameEndText : 정답을 맞추고 게임을 종료되었다는 안내 문구 출력.
  + NumberComparison.class : Computer와 User의 숫자를 비교하여 strike와 ball의 개수를 알려주고 정답인지 확인시켜주는 역할을 함.
    + checkEachDigit : User와 Computer의 같은 위치의 자릿수를 각각 확인하며 strike와 ball의 개수를 셈.
      + countBall : 각 자리를 비교하여 ball(다른 위치에 같은 숫자가 존재)인지 파악함.
      + countStrike : 각자리를 비교하여 strike(같은 위치에 같은 숫자)인지 파악함.
      + isAnswer : strike가 3일시 true를 반환하여 정답임을 알려줌.
      + printStrikeBallCount : strike와 ball의 개수를 출력함.
  + MenuSelection : 정답을 맞춰 게임이 끝난 후, 플레이와 종료 중에서 메뉴를 선택하도록 함.
    + selectNumber : 1,2중 숫자 하나를 입력 받고 Integer형으로 변환하여 startGame에 반환함. 1을 반환하면 리게임, 2를 반환하면 게임이 끝남.
+ exception
  + IllegalArgument : 잘못된 입력이 들어왔을 시, 예외처리 후 상황에 맞는 예외처리 문구를 출력.
    + outOfRange : 입력된 숫자의 각 자리가 지정한 범위를 벗어난 경우에 해당 예외처리 메시지가 나타남.
    + notNNumbers : 입력된 숫자를 분리했을 때 개수가 설정한 N개가 아닌 경우에 해당 예외처리 메세지가 나타남.
    + duplicateNumberExists : 입력된 숫자를 분리했을 때 중복된 숫자가 존재할 시 해당 예외처리 메세지가 나타남.
