public static class Main{
  public static void main(String[] args){
    generateMap();
    while(!dead){
      displayMap();
      move();
    }
  }

  public static void move(){
    pos = readInput();
    char next = readAhead();
    updateMap(posx, posy, ‘X’); //or whatever we want the player to be /
    updateMap(oldPosx, oldPosy, next);
    runEvent(next);
    increment();
    oldPos=pos;
    updateDead();
  }

  public static void updateMap(int posx, int posy, char c){
    map[posx][posy] = c;
  }
}
