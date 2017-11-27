public class Main{
  static int posx, posy;
  static int oldPosx, oldPosy;

  public static void main(String[] args){
    char map[][] = generateMap();
    while(!dead){
      displayMap(map);
      move();
    }
  }

  public static void move(){
    readInput(); //assigns posx and posy
    char next = readAhead();
    updateMap(posx, posy, ‘X’); //or whatever we want the player to be /
    updateMap(oldPosx, oldPosy, next);
    runEvent(next);
    oldPosx=posx; oldPosy = posy;
  }


  public static char[][] generateMap(){
    char[][] map  =  {
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-'},
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-'},
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','X','-','-','-','-','-'},
              {  '-',  '-', '-', '-', 'X', '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X','X','-','-','-','-','-'},
              {  '-',  'E', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X','X','X','X','-','-','-'},
              {  '-',  '-', 'X', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X','X','X','X','X','-','-'},
              {  '-',  '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', 'X', 'X','X','-','-','-','-','-'},
              {  '-',  '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', 'X','-','-','-','-','-','-'},
              {  '-',  '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','E','-','-'},
              {  '-',  '-', '-', 'X', 'X', 'X', '-', 'E', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-'},
              {  '-',  '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-'},
              {  '-',  'X', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-'},
              {  '-',  '-', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-'},
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', 'X', '-', '-', '-', '-','-','-','-','-','-','-'},
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', '-', '-', '-','-','-','-','-','-','-'},
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X', '-', '-','-','-','-','-','-','-'},
              {  '-',  '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X', 'X', 'X', '-','-','-','-','-','-','-'},
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X', 'X','-','-','-','-','-','-'},
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', '-', '-','-','-','E','-','-','-'},
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-'},
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-'}
            }; //21 x  21
    return map;
  }

  /**
  * changes the character at the given position on the given 2d char array into the given character
  * @param posx x position of the character to be changed
  * @param posy y position of the character to be changed
  * @param c character to be changed to
  * @param map 2d char array that is being changed
  * @return The 2d char array with the changes
  */
  public static char[][] updateMap(int posx, int posy, char c, char[][] map){
    map[posx][posy] = c;
    return map;
  }

  /**
  * prints out a 2d array of characters
  * @param map the 2d array to be printed
  */
  public static void displayMap(char[][] map){
    for (char[] mapRow : map){
      for (char i : mapRow){
        System.out.print(i);
      }
      System.out.print("\n");
    }
  }

  /**
  * returns the character of the given location on the array
  * @param posx x position of the character to be looked at at
  * @param posy y position of the character to be changed
  * @param map 2d char array that is looked at
  * @return The character at that position of the 2d char array
  */
  public static char readAhead(int pox, int posy, char[][] map){
    return map[posx][posy];
  }
}
