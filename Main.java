import java.util.*;
import java.time.Instant;
import java.lang.*;

public class Main{
  static int posx = 1;
  static int posy = 1;
  static int oldPosx = 1;
  static int oldPosy = 1;

  static char player = 'O';
  static Boolean dead = false;

  static int health = 100;

  static int[][] enemies = {
      {5, 2},
      {19 ,18},
      {9 ,19}
    };  //3 enemies, each with an x and y pos, this is the first map

  public static void main(String[] args){
    char[][] map = generateMap(1);
    while(!dead){
      displayMap(map);
      getInput(map);
      updateMapPlayer(posx, posy, player, map);
      map = moveEnemies(map);
    }
    System.out.println("Thank you for playing.");
  }

  /**
  * returns a map to char[][]
  * @param which is which map we use
  * @return the now-full 2d char array of the map
  */
  public static char[][] generateMap(int which){
    if (which == 1){
      char[][] map  =  new char[][]{
                {  '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_' },
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|' },
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','X','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', 'X', '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X','X','-','-','-','-','-', '|'},
                {  '|', '-',  'E', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X','X','X','X','-','-','-', '|'},
                {  '|', '-',  '-', 'X', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X','X','X','X','X','-','-', '|'},
                {  '|', '-',  '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', 'X', 'X','X','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', 'X','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','E','-','-', '|'},
                {  '|', '-',  '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  'X', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', 'X', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X', 'X', 'X', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', 'X', 'X','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', '-', '-','-','-','E','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_' }
              }; //23 x  23
      return map;
    } else if (which == 2){
        char[][] map  =  new char[][]{
                {  '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_' },
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|' },
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','X','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X','X','X','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', 'E', '-', '-', '-', '-', '-', '-', 'X','X','X','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','X','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','E','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', 'X', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', 'X', 'X', 'X', 'X', '-', '-', '-', 'X', 'X', 'X', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', 'X', 'X', '-', '-', 'X', 'X', 'X', 'X', 'X','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', 'X', 'X', '-', '-', '-', 'X', 'X', 'X', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', 'X', '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  'X', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  'X', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  'X', 'X', '-', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','E','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                {  '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_' }
              };
      return map;
    } else {
        char[][] map  =  new char[][]{
                  {  '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_' },
                  {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'X','-','-','-','-','-','-', '|' },
                  {  '|', '-',  '-', '-', '-', 'X', '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', 'X', 'X', 'X','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', 'X', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', 'X', 'X','X','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', 'X','X','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', '-', '-', 'X', 'X', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', '-', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', '-', 'X', 'X', '-', '-', '-', '-', '-', '-', 'X','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', '-', '-', 'X', '-', '-', '-', '-', '-', '-', 'X','-','-','-','-','-','-', '|'},
                  {  '|', '-',  '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'X', 'X','X','X','-','-','-','-', '|'},
                  {  '|', '-',  '-', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'X','X','X','-','-','-','-', '|'},
                  {  '|', '-',  '-', 'X', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-','X','X','-','-','-','-', '|'},
                  {  '|', '-',  'X', 'X', 'X', 'X', 'X', '-', '-', '-', '-', '-', '-', '-', '-', '-','-','-','-','-','-','-', '|'},
                  {  '_', '_', 'X', 'X', 'X', 'X', 'X', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_' }
                };
        return map;
      }
  }

  /**
  * changes the character at the given position on the given 2d char array into the given character
  * @param posx x position of the character to be changed
  * @param posy y position of the character to be changed
  * @param c character to be changed to
  * @param map 2d char array that is being changed
  * @return The 2d char array with the changes
  */
  public static char[][] updateMapPlayer(int posx, int posy, char c, char[][] map){
    c = player;
    map[posy][posx] = c;
    map[oldPosy][oldPosx] = '-';
    oldPosy = posy;
    oldPosx = posx;
    return map;
  }


  public static char[][] updateMapEnemies(int posx, int posy, char c, char[][] map){
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
  * reads player input
  * @param input the character input by the user
  */
  public static void getInput(char[][] map) {
    System.out.println("Input a character to move.");
    char input = TextIO.getlnChar();
    readInput(input, posy, posx, map);
  }



  /**
  * accepts teh players input to change posy and posx so they can be modified later
  * @param input the character the user inputted
  * @param y the y value
  * @param x the x value
  * @param map the map file
  */
  public static void readInput(char input, int y, int x, char[][] map){
    int thisY = y; //placeholder for the new y and x values
    int thisX = x;
    char c = ' ';
    if (input == 'w') {
      thisY = y-1;
      c = readAhead(thisY, x, map);
      if (c == '-') {
        posy = thisY;
      } else {
        System.out.println("You can't go there!");
      }
    } else if (input == 'a') {
      thisX = x-1;
      c = readAhead(y, thisX, map);
      if (c == '-') {
        posx = thisX;
      } else {
        System.out.println("You can't go there!");
      }
    } else if (input == 's') {
      thisY = y+1;
      c = readAhead(thisY, x, map);
      if (c == '-') {
        posy = thisY;
      } else {
        System.out.println("You can't go there!");
      }
    } else if (input == 'd') {
      thisX = x+1;
      c = readAhead(y, thisX, map);
      if (c == '-') {
        posx = thisX;
      } else {
        System.out.println("You can't go there!");
      }
    } else if (input == 'x') {
      dead = true;
    } else {
      System.out.println("Please enter W, A, S, or D to move.");
    }
  }


  /**
  * reads the given pos on the map string
  * @return the char at that po
  */
  public static char readAhead(int y, int x, char[][] map){
    return map[y][x];
  }

  /**
  * reads the given direction on the 2d array for the given enemy
  * @param direction the string of the direction
  * @param map the 2d array
  * @param i the enemy
  * @return the char of what is at that spot
  */
  public static char readDirectionEnemies(String direction, char[][] map, int i){
    if (direction.equals("left")){
      return readAhead(enemies[i][0], enemies[i][1]-1, map);
    } else if (direction.equals("right")){
      return readAhead(enemies[i][0], enemies[i][1]+1, map);
    } else if (direction.equals("up")){
      return readAhead(enemies[i][0]-1, enemies[i][1], map);
    } else {
      return readAhead(enemies[i][0]+1, enemies[i][1], map);
    }
  }

  /**
  * Runs operations so that all the (3) enemies on the map move forward in a random directions
  * @param map the map array
  * @return the map string
  */
  public static char[][] moveEnemies(char[][] map){
    for(int i = 0; i < enemies.length; i++){
      String direction = getDirection();
      char ahead = readDirectionEnemies(direction, map, i);
      while(ahead == 'X' || ahead == '|' || ahead == '_'){
        direction = getDirection();
        ahead = readDirectionEnemies(direction, map, i);
      }
      map = replaceEnemies(direction, map, i);
    }
    return map;
  }

  /**
  * actually moves the enemies on the map
  * @param direction the string of the direction the enemy is moving
  * @param map the map 2d array
  * @param i which enemy is moving
  * @return the new map array
  */
  public static char[][] replaceEnemies(String direction, char[][] map, int i){
    if (direction.equals("left")){
      updateMapEnemies(enemies[i][0], enemies[i][1]-1, 'E', map);
      updateMapEnemies(enemies[i][0], enemies[i][1], '-', map);
      enemies[i][1] = enemies[i][1] -1;
    } else if (direction.equals("right")){
      updateMapEnemies(enemies[i][0], enemies[i][1]+1, 'E', map);
      updateMapEnemies(enemies[i][0], enemies[i][1], '-', map);
      enemies[i][1] = enemies[i][1]+1;
    } else if (direction.equals("up")){
      updateMapEnemies(enemies[i][0]-1, enemies[i][1], 'E', map);
      updateMapEnemies(enemies[i][0], enemies[i][1], '-', map);
      enemies[i][0] = enemies[i][0]-1;
    } else {
      updateMapEnemies(enemies[i][0]+1, enemies[i][1], 'E', map);
      updateMapEnemies(enemies[i][0], enemies[i][1], '-', map);
      enemies[i][0] = enemies[i][0]+1;
    }
    return map;
  }

  /**
  * gives a random direction - left, right, up, down
  * @return the direction
  */
  public static String getDirection(){
    Instant instant = Instant.now();
    Random rand = new Random(instant.toEpochMilli());
    int x = rand.nextInt(4) + 1;//for the 4 directions
    if(x == 1){
      return "left";
    } else if (x == 2){
      return "right";
    } else if (x == 3){
      return "up";
    } else {
      return "down";
    }
  }
}
