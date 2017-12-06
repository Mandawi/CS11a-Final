import java.util.*;
public class BattleMode {
  public static void main(String[] args) throws InterruptedException {//throws IE lets Thread.sleep() work
    String[] empty=new String[1];
    int rounds=0; //rounds counter
    int CPUHealth=100;
    Main mainObject = new Main();
    int PlayerHealth = mainObject.getHealth();
    Scanner scn = new Scanner(System.in);
    System.out.println("  .___________________________________________________________________________________________________________________________________________________."); //prints the menu
    System.out.println("  |___________________________________________________________________________________________________________________________________________________|");
    System.out.println("//____________________________________________________________________________________________________________________________________________________\\\\");
    System.out.println("\n\n       :::::::::         :::    :::::::::::  :::::::::::   :::        ::::::::::           :::   :::       ::::::::     :::::::::     :::::::::: ");
    System.out.println("        :+:    :+:      :+: :+:      :+:          :+:       :+:        :+:                 :+:+: :+:+:     :+:    :+:    :+:    :+:    :+:         ");
    System.out.println("       +:+    +:+     +:+   +:+     +:+          +:+       +:+        +:+                +:+ +:+:+ +:+    +:+    +:+    +:+    +:+    +:+          ");
    System.out.println("      +#++:++#+     +#++:++#++:    +#+          +#+       +#+        +#++:++#           +#+  +:+  +#+    +#+    +:+    +#+    +:+    +#++:++#      ");
    System.out.println("     +#+    +#+    +#+     +#+    +#+          +#+       +#+        +#+                +#+       +#+    +#+    +#+    +#+    +#+    +#+            ");
    System.out.println("    #+#    #+#    #+#     #+#    #+#          #+#       #+#        #+#                #+#       #+#    #+#    #+#    #+#    #+#    #+#             ");
    System.out.println("   #########     ###     ###    ###          ###       ########## ##########         ###       ###     ########     #########     ##########       \n\n");
    System.out.println("\\\\____________________________________________________________________________________________________________________________________________________//");
    System.out.println("  |__________________________________________________________________________________________________________________________________________________|");
    System.out.println("  |__________________________________________________________________________________________________________________________________________________|\n\n\n\n");
    Thread.sleep(1000);
    System.out.println("You will pick one of 3: (A)Attack (damage to CPU from 0 to 50),\n (D)Destructive Attack (different damage to both ships from 0 to 100),\n or (H)Heal (Increase player health by 0 to full)\n");
    System.out.println("Each one of them will produce a somewhat random amount of points (e.g. you could pick heal and get 0 healing points)\n");
    System.out.println("The computer will get to pick as well, after you do, and the points of their choice will also be somewhat random\n\n");
    System.out.println("Battle mode ends after 5 rounds of action\n\n");
    System.out.println("Let the battle start!\n");
    Thread.sleep(10000);
    PlayerPick(PlayerHealth,CPUHealth, mainObject, rounds);//throw rounds in there and let it increment until it reaches 5
  }
  /**
  @param CPUHealth health of computer ship
  @param PlayerHealth health of user ship
  @return PlayerHealth health of user ship
  */
  public static void PlayerPick(int PlayerHealth, int CPUHealth, Main mainObject,int rounds){ //will change to int to return new health. //Should take in CPU health
    String[] empty=new String[1];
    rounds+=1;
    if(PlayerHealth<=0){
      System.out.println("Game Over!\nThank you for playing.");
      System.exit(0);
    }else if(CPUHealth<=0){
      mainObject.setHealth(PlayerHealth);
      mainObject.main(empty);
    }else{
      System.out.printf("\n\n\n\n\n########   #######  ##     ## ##    ## ########");
      System.out.printf("\n##     ## ##     ## ##     ## ###   ## ##     ##");
      System.out.printf("\n##     ## ##     ## ##     ## ####  ## ##     ## ");
      System.out.printf("\n########  ##     ## ##     ## ## ## ## ##     ## ");
      System.out.printf("\n##   ##   ##     ## ##     ## ##  #### ##     ## ");
      System.out.printf("\n##    ##  ##     ## ##     ## ##   ### ##     ## ");
      System.out.printf("\n##    ##  ##     ## ##     ## ##   ### ##     ## ");
      System.out.printf("\n##    ##  #######    #######  ##    ## ########  ");
    }
    if (rounds==1){
      System.out.printf("\n\n   ##");
      System.out.printf("\n ####");
      System.out.printf("\n   ##");
      System.out.printf("\n   ##");
      System.out.printf("\n   ##");
      System.out.printf("\n   ##");
      System.out.printf("\n   ##");
      System.out.printf("\n ###### ");
    }else if(rounds==2){
      System.out.printf("\n\n #######  ");
      System.out.printf("\n##     ## ");
      System.out.printf("\n       ## ");
      System.out.printf("\n       ## ");
      System.out.printf("\n       ## ");
      System.out.printf("\n #######  ");
      System.out.printf("\n##  ");
      System.out.printf("\n######### ");
    }
    else if(rounds==3){
      System.out.printf("\n\n ####### ");
      System.out.printf("\n##     ## ");
      System.out.printf("\n##     ##  ");
      System.out.printf("\n       ## ");
      System.out.printf("\n #######  ");
      System.out.printf("\n       ##");
      System.out.printf("\n##     ## ");
      System.out.printf("\n #######  ");
    }
    if (rounds==4){ //or CPU/Player health is zero
      mainObject.setHealth(PlayerHealth);
      mainObject.main(empty);
    }

    System.out.printf("\n\n\n____________________________________________________________________________________________________________________________________________________________________");
    System.out.printf("\n\n\n                 |._");
    System.out.printf("\n                 |._(                                       |");
    System.out.printf("\n        <|.__..-'|.                                         |");
    System.out.printf("\n        ,|      .|)\\                                |    __-__");
    System.out.printf("\n        /|      .|) \\                              __-__ /  | (");
    System.out.printf("\n       /.|)     .|)  \\                            /  | ((   | |\\");
    System.out.printf("\n      / .|)     .|)   \\                          /(   | ||___|_.  .|");
    System.out.printf("\n     /  .|)     .|)    \\                       .' |___|_|`---|-'.' (");
    System.out.printf("\n    /   .|)     .|)WOO! \\                  '-._/_| (   |\\     |.'    \\");
    System.out.printf("\n   /  ,--+---_   |  :)   \\ ,                  '-._|.-.|-.    |'-.____'.");
    System.out.printf("\n '\\==-,,;,,;,,;,,,,,,,-==;;>>>                   |------------------'");
    System.out.printf("\n   \\__...____...__    __/                         `----------------'   ");
    System.out.printf("\n~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~\n");
    System.out.printf("\n~~ ~~~~~~ [Player]~ ~~~~~~ ~~~  ~~~ ~~~~~~~~~~~~~~~~~~~ ~~ [CPU]~~~~~~~~~~~~~~\n");
    System.out.printf("\n~ ~ ~ ~ ~~["+PlayerHealth+"]~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~  ~ ~ ~ ~~~["+CPUHealth+"]~  ~ ~ ~ ~~~ ~~~~~~~~~  ~~~\n\n\n"); //Should display both of their health underneath
    Scanner scn = new Scanner(System.in);
    System.out.println("User's choice (--(A)Attack, (D)Destructive, (H)Heal--):");
    String choice=scn.nextLine();
    choice=choice.toUpperCase();
    while((!choice.equals("A"))&&(!choice.equals("D"))&&(!choice.equals("H"))){
      System.out.println("Invalid input");
      System.out.println("User's choice (--(A)Attack, (D)Destructive, (H)Heal--):");
      choice=scn.nextLine();
      choice=choice.toUpperCase();
    }
    while(choice.equals("H")&&PlayerHealth>=100){ //depends on health is full
      System.out.println("Health already full");
      System.out.println("User's choice (--(A)Attack, (D)Destructive, (H)Heal--):");
      choice=scn.nextLine();
      choice=choice.toUpperCase();
    }
    if(choice.equals("A")){ //can be manipulated to insert health
      try {
        UserAttack(PlayerHealth,CPUHealth, mainObject, rounds); //should give CPU health
      } catch(Exception InterruptedException) {
        // code to handle the exception
      }
    }else if(choice.equals("D")){
      try {
        UserDestructive(PlayerHealth,CPUHealth, mainObject, rounds); //should give CPU health
      } catch(Exception InterruptedException) {
        // code to handle the exception
      }
    }else if(choice.equals("H")){
      try {
        UserHeal(PlayerHealth,CPUHealth, mainObject, rounds); //should give CPU health
      } catch(Exception InterruptedException) {
        // code to handle the exception
      }
    }
  }


  /*********************************************        Player Interactions         *********************************************************************/

  /**
  @param CPUHealth health of computer ship
  @param PlayerHealth health of player ship
  */
  public static void UserAttack(int PlayerHealth, int CPUHealth, Main mainObject,int rounds) throws InterruptedException {//throws IE lets Thread.sleep() work //Should take in CPU health
    Thread.sleep(1000);
    System.out.printf("\n\n\n                 |._");
    System.out.printf("\n                 |._(                                       |");
    System.out.printf("\n        <|.__..-'|.            Player Attacks!              |");
    System.out.printf("\n        ,|      .|)\\                           . : .    __-__");
    System.out.printf("\n        /|      .|) \\                        '.  :  .'  /  | (");
    System.out.printf("\n       /.|)     .|)  \\                      .  '.:.'  .((   | |\\");
    System.out.printf("\n      / .|)     .|)   \\                     .  .':'.  . ||___|_.  .|");
    System.out.printf("\n     /  .|)     .|)    \\                     .'  :  '.  |`---|-'.' (");
    System.out.printf("\n    /   .|)     .|)WOO! \\                      ' : '   |\\     |.'    \\");
    System.out.printf("\n   /  ,--+---_   |  :)   \\ ,                     _|.-.|-.    |'-.____'.");
    System.out.printf("\n '\\==-,,;,,;,,;,,,,,,,-==;;>>>                   |------------------'");
    System.out.printf("\n   \\__...____...__    __/                         `----------------'   ");
    System.out.printf("\n~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~\n");
    System.out.printf("\n~~ ~~~~~~ [Player]~ ~~~~~~ ~~~  ~~~ ~~~~~~~~~~~~~~~~~~~ ~~ [CPU]~~~~~~~~~~~~~~\n");
    System.out.printf("\n~ ~ ~ ~ ~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~ ~~~~  ~ ~ ~ ~~~ ~~~~~~~~~  ~~~\n\n\n"); //Should display both of their health underneath

    System.out.print("Damage made on CPU: -");
    int damage=(int)(Math.random()*50);// modify based on health scale
    System.out.print(damage);
    CPUHealth-=damage;
    Thread.sleep(4000);
    CPUPick(PlayerHealth,CPUHealth, mainObject, rounds);
  }
  /**
  @param CPUHealth health of computer ship
  @param PlayerHealth health of player ship
  */
  public static void UserDestructive(int PlayerHealth, int CPUHealth, Main mainObject,int rounds) throws InterruptedException {//throws IE lets Thread.sleep() work //Should take in CPU health
    Thread.sleep(1000);
    System.out.printf("\n\n\n                 |._");
    System.out.printf("\n                 |._(          _.-^^---....,,--             |");
    System.out.printf("\n        <|.__..-'|.        Player Chose Destruction!        |");
    System.out.printf("\n        ,|      .|)\\    <                        >) |    __-__");
    System.out.printf("\n        /|      .|) \\    |                         | -__ /  | (");
    System.out.printf("\n       /.|)     .|)  \\    \\._                   _./ | ((   | |\\");
    System.out.printf("\n      / .|)     .|)   \\       ```--. . , ; .--'''/(   | ||___|_.  .|");
    System.out.printf("\n     /  .|)     .|)    \\           | |   |     .' |___|_|`---|-'.' (");
    System.out.printf("\n    /   .|)     .|)WOO! \\       .-=||  | |=-.._/_| (   |\\     |.'    \\");
    System.out.printf("\n   /  ,--+---_   |  :)   \\ ,    `-=#$|||$#=-' '-._|.-.|-.    |'-.____'.");
    System.out.printf("\n '\\==-,,;,,;,,;,,,,,,,-==;;>>>     | ;  :|       |------------------'");
    System.out.printf("\n   \\__...____...__    __/_____.,-##&$@##&#~,._____`----------------'   ");
    System.out.printf("\n~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~\n");
    System.out.printf("\n~~ ~~~~~~ [Player]~ ~~~~~~ ~~~  ~~~ ~~~~~~~~~~~~~~~~~~~ ~~ [CPU]~~~~~~~~~~~~~~\n");
    System.out.printf("\n~ ~ ~ ~ ~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~ ~~~~  ~ ~ ~ ~~~ ~~~~~~~~~  ~~~\n\n\n"); //Should display both of their health underneath
    System.out.print("Damage made on CPU: -");
    int damage=(int)(Math.random()*100);// modify based on health scale
    System.out.print(damage);
    CPUHealth-=damage;
    System.out.print("\n\nDamage made on Player: -");
    int damage2=(int)(Math.random()*100);// modify based on health scale
    System.out.print(damage2);
    PlayerHealth-=damage2;
    Thread.sleep(4000);
    CPUPick(PlayerHealth,CPUHealth, mainObject, rounds);
  }
  /**
  @param CPUHealth health of computer ship
  @param PlayerHealth health of player ship
  */
  public static void UserHeal(int PlayerHealth, int CPUHealth, Main mainObject,int rounds) throws InterruptedException {//throws IE lets Thread.sleep() work //Should take in CPU health
    Thread.sleep(1000);
    System.out.printf("\n\n\n                 |._");
    System.out.printf("\n                 |._(                                       |");
    System.out.printf("\n        <|.__..-'|.         Player Heals Ship               |");
    System.out.printf("\n        ,|      .|)\\      +++                       |    __-__");
    System.out.printf("\n        /|      .|) \\    ++X++                     __-__ /  | (");
    System.out.printf("\n       /.|)     .|)  \\    +++                     /  | ((   | |\\");
    System.out.printf("\n      / .|)     .|)   \\    +                     /(   | ||___|_.  .|");
    System.out.printf("\n     /  .|)     .|)    \\   +                   .' |___|_|`---|-'.' (");
    System.out.printf("\n    /   .|)     .|)WOO! \\  +               '-._/_| (   |\\     |.'    \\");
    System.out.printf("\n   /  ,--+---_   |  :)   \\ ,                  '-._|.-.|-.    |'-.____'.");
    System.out.printf("\n '\\==-,,;,,;,,;,,,,,,,-==;;>>>                   |------------------'");
    System.out.printf("\n   \\__...____...__    __/                         `----------------'   ");
    System.out.printf("\n~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~\n");
    System.out.printf("\n~~ ~~~~~~ [Player]~ ~~~~~~ ~~~  ~~~ ~~~~~~~~~~~~~~~~~~~ ~~ [CPU]~~~~~~~~~~~~~~\n");
    System.out.printf("\n~ ~ ~ ~ ~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~ ~~~~  ~ ~ ~ ~~~ ~~~~~~~~~  ~~~\n\n\n"); //Should display both of their health underneath

    System.out.print("Health gained by player: +");
    int heal=(int)(Math.random()*100);// change 100 to full
    System.out.print(heal);
    PlayerHealth+=heal;
    Thread.sleep(4000);
    CPUPick(PlayerHealth,CPUHealth, mainObject, rounds);
  }


  /*********************************************        CPU Interactions         ******************************************************************** */

  /**
  @param CPUHealth health of computer ship
  @param PlayerHealth health of player ship
  */
  public static void CPUPick(int PlayerHealth, int CPUHealth, Main mainObject,int rounds) {
    String[] empty=new String[1];
    if(PlayerHealth<=0){
      System.out.println("Game Over!\nThank you for playing.");
      System.exit(0);
    }else if(CPUHealth<=0){
      mainObject.setHealth(PlayerHealth);
      mainObject.main(empty);
    }
    System.out.printf("\n\n\n____________________________________________________________________________________________________________________________________________________________________");
    System.out.printf("\n\n\n                 |._");
    System.out.printf("\n                 |._(                                       |");
    System.out.printf("\n        <|.__..-'|.                                         |");
    System.out.printf("\n        ,|      .|)\\                                |    __-__");
    System.out.printf("\n        /|      .|) \\                              __-__ /  | (");
    System.out.printf("\n       /.|)     .|)  \\                            /  | ((   | |\\");
    System.out.printf("\n      / .|)     .|)   \\                          /(   | ||___|_.  .|");
    System.out.printf("\n     /  .|)     .|)    \\                       .' |___|_|`---|-'.' (");
    System.out.printf("\n    /   .|)     .|)WOO! \\                  '-._/_| (   |\\     |.'    \\");
    System.out.printf("\n   /  ,--+---_   |  :)   \\ ,                  '-._|.-.|-.    |'-.____'.");
    System.out.printf("\n '\\==-,,;,,;,,;,,,,,,,-==;;>>>                   |------------------'");
    System.out.printf("\n   \\__...____...__    __/                         `----------------'   ");
    System.out.printf("\n~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~\n");
    System.out.printf("\n~~ ~~~~~~ [Player]~ ~~~~~~ ~~~  ~~~ ~~~~~~~~~~~~~~~~~~~ ~~ [CPU]~~~~~~~~~~~~~~\n");
    System.out.printf("\n~ ~ ~ ~ ~~["+PlayerHealth+"]~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~  ~ ~ ~ ~~~["+CPUHealth+"]~  ~ ~ ~ ~~~ ~~~~~~~~~  ~~~\n\n\n");//Should display both of their health underneath
    Scanner scn = new Scanner(System.in);
    System.out.print("\n\nCPU's choice\n");
    if (CPUHealth<=20){
      try {
        CPUHeal(PlayerHealth,CPUHealth, mainObject, rounds);
      } catch(Exception InterruptedException) {
        // code to handle the exception
      }
    }
    if (PlayerHealth+40<=CPUHealth){
      try {
        CPUDestructive(PlayerHealth,CPUHealth, mainObject, rounds);
      } catch(Exception InterruptedException) {
        // code to handle the exception
      }
    }
    int CPUchoice=(int)(Math.random()*2);
    if(CPUchoice==0){ //can be manipulated to insert health
      try {
        CPUAttack(PlayerHealth,CPUHealth, mainObject, rounds); //should give CPU health
      } catch(Exception InterruptedException) {
        // code to handle the exception
      }
    }else if(CPUchoice==1){
      try {
        CPUDestructive(PlayerHealth,CPUHealth, mainObject, rounds);
      } catch(Exception InterruptedException) {
        // code to handle the exception
      }
    }else if(CPUchoice==2){//and CPU's health not full
    try {
      CPUHeal(PlayerHealth,CPUHealth, mainObject, rounds);
    } catch(Exception InterruptedException) {
      // code to handle the exception
    }
  }
}
/**
@param CPUHealth health of computer ship
@param PlayerHealth health of player ship
*/
public static void CPUAttack(int PlayerHealth, int CPUHealth, Main mainObject,int rounds) throws InterruptedException {//throws IE lets Thread.sleep() work //Should take in CPU health
  Thread.sleep(4000);
  System.out.printf("\n\n\n                 |._");
  System.out.printf("\n                 |._(                                       |");
  System.out.printf("\n        <|.__..-'|.            CPU Attacks!                 |");
  System.out.printf("\n        ,|      .|)\\                                |    __-__");
  System.out.printf("\n        /|      .|) \\                              __-__ /  | (");
  System.out.printf("\n       /.|)     .|)  \\                            /  | ((   | |\\");
  System.out.printf("\n      / .|)     .|)   \\                          /(   | ||___|_.  .|");
  System.out.printf("\n     /  .|)       '.\\|/.'                      .' |___|_|`---|-'.' (");
  System.out.printf("\n    /   .|)       (\\   /)                  '-._/_| (   |\\     |.'    \\");
  System.out.printf("\n   /  ,--+---_    - -O- -\\ ,                  '-._|.-.|-.    |'-.____'.");
  System.out.printf("\n '\\==-,,;,,;,,;,,(/   \\)=;;>>>                  |------------------'");
  System.out.printf("\n   \\__...____..._,'/|\\'./                        `----------------'   ");
  System.out.printf("\n~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~\n");
  System.out.printf("\n~~ ~~~~~~ [Player]~ ~~~~~~ ~~~  ~~~ ~~~~~~~~~~~~~~~~~~~ ~~ [CPU]~~~~~~~~~~~~~~\n");
  System.out.printf("\n~ ~ ~ ~ ~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~ ~~~~  ~ ~ ~ ~~~ ~~~~~~~~~  ~~~\n\n\n"); //Should display both of their health underneath

  System.out.print("Damage made on Player: -");
  int damage=(int)(Math.random()*50);// modify based on health scale
  System.out.print(damage);
  PlayerHealth-=damage;
  Thread.sleep(6000);
  PlayerPick(PlayerHealth,CPUHealth, mainObject, rounds);//with all updated variables
}
/**
@param CPUHealth health of computer ship
@param PlayerHealth player of computer ship
*/
public static void CPUDestructive(int PlayerHealth, int CPUHealth, Main mainObject,int rounds) throws InterruptedException {//throws IE lets Thread.sleep() work //Should take in CPU health
  Thread.sleep(4000);
  System.out.printf("\n\n\n                 |._");
  System.out.printf("\n                 |._(          _.-^^---....,,--             |");
  System.out.printf("\n        <|.__..-'|.         CPU Chose Destruction!          |");
  System.out.printf("\n        ,|      .|)\\    <                        >) |    __-__");
  System.out.printf("\n        /|      .|) \\    |                         | -__ /  | (");
  System.out.printf("\n       /.|)     .|)  \\    \\._                   _./ | ((   | |\\");
  System.out.printf("\n      / .|)     .|)   \\       ```--. . , ; .--'''/(   | ||___|_.  .|");
  System.out.printf("\n     /  .|)     .|)    \\           | |   |     .' |___|_|`---|-'.' (");
  System.out.printf("\n    /   .|)     .|)WOO! \\       .-=||  | |=-.._/_| (   |\\     |.'    \\");
  System.out.printf("\n   /  ,--+---_   |  :)   \\ ,    `-=#$|||$#=-' '-._|.-.|-.    |'-.____'.");
  System.out.printf("\n '\\==-,,;,,;,,;,,,,,,,-==;;>>>     | ;  :|       |------------------'");
  System.out.printf("\n   \\__...____...__    __/_____.,-##&$@##&#~,._____`----------------'   ");
  System.out.printf("\n~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~\n");
  System.out.printf("\n~~ ~~~~~~ [Player]~ ~~~~~~ ~~~  ~~~ ~~~~~~~~~~~~~~~~~~~ ~~ [CPU]~~~~~~~~~~~~~~\n");
  System.out.printf("\n~ ~ ~ ~ ~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~ ~~~~  ~ ~ ~ ~~~ ~~~~~~~~~  ~~~\n\n\n"); //Should display both of their health underneath
  System.out.print("Damage made on CPU: -");
  int damage=(int)(Math.random()*100);// modify based on health scale
  System.out.print(damage);
  CPUHealth-=damage;
  System.out.print("\n\nDamage made on Player: -");
  int damage2=(int)(Math.random()*100);// modify based on health scale
  System.out.print(damage2);
  PlayerHealth-=damage2;
  Thread.sleep(6000);
  PlayerPick(PlayerHealth,CPUHealth, mainObject, rounds);
}
/**
@param CPUHealth health of computer ship
@param PlayerHealth health of player ship
*/
public static void CPUHeal(int PlayerHealth, int CPUHealth, Main mainObject,int rounds) throws InterruptedException {//throws IE lets Thread.sleep() work //Should take in CPU health
  Thread.sleep(4000);
  System.out.printf("\n\n\n                 |._");
  System.out.printf("\n                 |._(                                       |");
  System.out.printf("\n        <|.__..-'|.            CPU Heals Ship               |");
  System.out.printf("\n        ,|      .|)\\                         +      |    __-__");
  System.out.printf("\n        /|      .|) \\                       +++    __-__ /  | (");
  System.out.printf("\n       /.|)     .|)  \\                     ++Xs++  /  | ((   | |\\");
  System.out.printf("\n      / .|)     .|)   \\                      +   /(   | ||___|_.  .|");
  System.out.printf("\n     /  .|)     .|)    \\                     + .' |___|_|`---|-'.' (");
  System.out.printf("\n    /   .|)     .|)WOO! \\                  '-._/_| (   |\\     |.'    \\");
  System.out.printf("\n   /  ,--+---_   |  :)   \\ ,                  '-._|.-.|-.    |'-.____'.");
  System.out.printf("\n '\\==-,,;,,;,,;,,,,,,,-==;;>>>                   |------------------'");
  System.out.printf("\n   \\__...____...__    __/                         `----------------'   ");
  System.out.printf("\n~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~~~ ~~~~~~~~~~~\n");
  System.out.printf("\n~~ ~~~~~~ [Player]~ ~~~~~~ ~~~  ~~~ ~~~~~~~~~~~~~~~~~~~ ~~ [CPU]~~~~~~~~~~~~~~\n");
  System.out.printf("\n~ ~ ~ ~ ~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~ ~~~~  ~ ~ ~ ~~~ ~~~~~~~~~  ~~~\n\n\n"); //Should display both of their health underneath

  System.out.print("Health gained by CPU: +");
  int heal=(int)(Math.random()*100);// change 100 to full
  System.out.print(heal);
  CPUHealth+=heal;
  Thread.sleep(6000);
  PlayerPick(PlayerHealth,CPUHealth, mainObject, rounds);
}












/*System.out.printf("\n                 |._");
System.out.printf("\n                 |._(");
System.out.printf("\n        <|.__..-'|.");
System.out.printf("\n        ,|      .|)\\");
System.out.printf("\n        /|      .|) \\");
System.out.printf("\n       /.|)     .|)  \\");
System.out.printf("\n      / .|)     .|)   \\");
System.out.printf("\n     /  .|)     .|)    \\");
System.out.printf("\n    /   .|)     .|)     \\");
System.out.printf("\n   /  ,--+---_   |       \\ ,");
System.out.printf("\n '\\==-,,;,,;,,;,,,,,,,-==;;>>>");
System.out.printf("\n   \\__...____...__    __/ ");
System.out.printf("\n~~ ~~~~~~~~~~~ ~~~~~~ ~~~~~ ~~~~\n");*/
/*Thread.sleep(1000);
System.out.printf("\n                 |._");
System.out.printf("\n                 |._(");
System.out.printf("\n        <|.__..-'|.");
System.out.printf("\n        ,|      .|)\\");
System.out.printf("\n        /|      .|) \\");
System.out.printf("\n       /.|)     .|)  \\");
System.out.printf("\n      / .|)     .|)   \\");
System.out.printf("\n     /  .|)       '.\\|/.'");
System.out.printf("\n    /   .|)       (\\   /)");
System.out.printf("\n   /  ,--+---_    - -O- -\\ ,");
System.out.printf("\n '\\==-,,;,,;,,;,,(/   \\)=;;>>>");
System.out.printf("\n   \\__...____..._,'/|\\'./ ");
System.out.printf("\n-- - - - -- - - - -- - --- - -- - -\n");
Thread.sleep(1000);
System.out.printf("\n     _.-^^---....,,--     ");
System.out.printf("\n _--                  --_  ");
System.out.printf("\n<                        >)");
System.out.printf("\n|                         |");
System.out.printf("\n \\._                   _./ ");
System.out.printf("\n    ```--. . , ; .--'''   ");
System.out.printf("\n          | |   |   ");
System.out.printf("\n       .-=||  | |=-. ");
System.out.printf("\n       `-=#$|||$#=-'  ");
System.out.printf("\n          | ;  :|  ");
System.out.printf("\n _____.,-##&$@##&#~,._____\n");*/

}
