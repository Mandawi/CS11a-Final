public class Main{
  static char[][] map = null;
  static int posx, posy;
  static int oldPosx, oldPosy;

  public static void main(String[] args){
    generateMap();
    //while(!dead){
      displayMap();
      //move();
    //}
  }
/*
  public static void move(){
    readInput(); //assigns posx and posy
    char next = readAhead();
    updateMap(posx, posy, ‘X’); //or whatever we want the player to be /
    updateMap(oldPosx, oldPosy, next);
    runEvent(next);
    increment();
    oldPos=pos;
    updateDead();
  }
*/

  public static void generateMap(){
    map  =  {
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', '-', '-', '-', '-', 'X', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', 'E', '-', '-', '-', 'X', 'X', '-', '-', '-', '-', '-' },
              {  '-',  '-', '-', '-', '-', 'X', 'X', 'X', 'X', 'X', '-', '-', '-' },
              {  '-',  '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X', 'X', '-', '-' },
              {  '-',  '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X', '-', '-' },
              {  '-',  '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', '-', '-' },
              {  '-',  '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', '-', '-' },
              {  '-',  '-', '-', 'X', '-', '-', '-', '-', '-', 'X', '-', '-', '-' },
              {  '-',  '-', 'X', 'X', '-', '-', 'P', '-', '-', '-', '-', '-', '-' },
              {  '-',  'X', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', '-', '-', 'X', 'X', '-', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', '-', '-', '-', 'X', 'X', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'E', '-' },
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
              {  '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
            };
  }

  public static void updateMap(int posx, int posy, char c){
    map[posx][posy] = c;
  }

  public static void displayMap(){
    for (char[] mapRow : map){
      for (char i : mapRow){
        System.out.print(i);
      }
      System.out.print("\n");
    }
  }
}
