import java.util.*;
import java.time.Instant;
import java.lang.*;

public class Main{
  static int posx, posy;
  static int oldPosx, oldPosy;
  static Boolean dead = false;
  static int[][] enemies = {
      {5, 2},
      {19 ,18},
      {9 ,20}
    };  //3 enemies, each with an x and y pos, this is the first map

  public static void main(String[] args){
    char[][] map = generateMap(1);
    char map[][] = generateMap(1);//we can have the menu input which map here somehow
    while(!dead){
      displayMap(map);
      movePlayer(map);
      map = moveEnemies(map);
    }
  }

/*
  public static void movePlayer(){
    readInput(); //assigns posx and posy
    char next = readAhead();
    updateMap(posx, posy, 'X'); //or whatever we want the player to be
    updateMap(oldPosx, oldPosy, next);
    runEvent(next);
    oldPosx=posx; oldPosy = posy;
  }*/


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
      try
      {
        Thread.sleep(1000);
      }
      catch(InterruptedException e)
      {
        // this part is executed when an exception (in this example InterruptedException) occurs
      }
      String direction = getDirection();
      char ahead = readDirectionEnemies(direction, map, i);
      while(ahead == 'X' || ahead == '|' || ahead == '_'){
        try
        {
          Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
          // this part is executed when an exception (in this example InterruptedException) occurs
        }
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
  * @return  the map array
  */
  public static char[][] replaceEnemies(String direction, char[][] map, int i){
    if (direction.equals("left")){
      updateMap(enemies[i][0], enemies[i][1]-1, 'E', map);
      updateMap(enemies[i][0], enemies[i][1], '-', map);
      enemies[i][1] = enemies[i][1] -1;
    } else if (direction.equals("right")){
      updateMap(enemies[i][0], enemies[i][1]+1, 'E', map);
      updateMap(enemies[i][0], enemies[i][1], '-', map);
      enemies[i][1] = enemies[i][1]+1;
    } else if (direction.equals("up")){
      updateMap(enemies[i][0]-1, enemies[i][1], 'E', map);
      updateMap(enemies[i][0], enemies[i][1], '-', map);
      enemies[i][0] = enemies[i][0]-1;
    } else {
      updateMap(enemies[i][0]+1, enemies[i][1], 'E', map);
      updateMap(enemies[i][0], enemies[i][1], '-', map);
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
