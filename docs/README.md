Implement "Count" Class
- hold information about ball/strike counts
  * override toString() to return required string format

Implement "Pitch" Class
- hold information about 3 pitches
  * initialize with default values
  * generate random pitches
  * update with new String pitches
    * validate String: 3-length, unique, numeric
  * compare one Pitch to another Pitch and return "Count" entity

Implement "Game" Class
- hold information about game logic
  * loop below processes
    * read user's guess
    * compare to answer
    * print out result
  * check game over conditions in-between each cycle
    * 3-strike, user's will to play
  * reset answer Pitch