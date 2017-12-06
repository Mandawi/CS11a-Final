import java.util.*;
import java.time.Instant;
import java.lang.*;
public class BattleMode {
  public static void main(String[] args) throws InterruptedException {//throws IE lets Thread.sleep() work
    String[] empty=new String[1];
    int rounds=0; //rounds counter
    int CPUHealth=100; //health of computer's ship
    Main mainObject = new Main(); // creates an object to return to to Main's main when done and get player's health
    int PlayerHealth = mainObject.getHealth();
    Scanner scn = new Scanner(System.in);
    //print Battle Mode Title
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
    Thread.sleep(1000); //wait a second before starting
    System.out.println("You will pick one of 3: (A)Attack (damage to CPU from 0 to 50),\n (D)Destructive Attack (different damage to both ships from 0 to 100),\n or (H)Heal (Increase player health by 0 to full)\n");
    System.out.println("Each one of them will produce a somewhat random amount of points (e.g. you could pick heal and get 0 healing points)\n");
    System.out.println("The computer will get to pick as well, after you do, and the points of their choice will also be somewhat random\n\n");
    System.out.println("Battle mode ends after 3 rounds of action\n\n");
    System.out.println("Let the battle start!\n");
    Thread.sleep(10000); //wait ten seconds to let user read instructions first
    PlayerPick(PlayerHealth,CPUHealth, mainObject, rounds);//throw rounds in there and let it increment until it reaches 5
  }
  /**
  * print the rounds, and ask the user for input to play
  * @param CPUHealth health of computer ship
  * @param PlayerHealth health of user ship
  * @param mainObject an object of class Main
  * @param rounds how many rounds have been played
  */
  public static void PlayerPick(int PlayerHealth, int CPUHealth, Main mainObject,int rounds){ //will change to int to return new health. //Should take in CPU health
    String[] empty=new String[1]; //used because Main.java's main class requires a Sting[] args
    rounds+=1;
    if(PlayerHealth<=0){
      //when player dies
      System.out.println("\nGame Over!\nThank you for playing.");
      System.exit(0);
    }else if(CPUHealth<=0){
      ///when CPU dies
      mainObject.setHealth(PlayerHealth);
      mainObject.main(empty); //go back to map
    }else if (rounds==4){ //or CPU/Player health is zero
      //when the rounds are over (3 rounds done)
      mainObject.setHealth(PlayerHealth);
      mainObject.main(empty); //go back to map
    }else{
      // print ROUND
      System.out.printf("\n\n\n\n\n########   #######  ##     ## ##    ## ########");
      System.out.printf("\n##     ## ##     ## ##     ## ###   ## ##     ##");
      System.out.printf("\n##     ## ##     ## ##     ## ####  ## ##     ## ");
      System.out.printf("\n########  ##     ## ##     ## ## ## ## ##     ## ");
      System.out.printf("\n##   ##   ##     ## ##     ## ##  #### ##     ## ");
      System.out.printf("\n##    ##  ##     ## ##     ## ##   ### ##     ## ");
      System.out.printf("\n##    ##  ##     ## ##     ## ##   ### ##     ## ");
      System.out.printf("\n##    ##  #######    #######  ##    ## ########  ");
    }
    //print the number of round
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
    //print the two ships with their health underneath
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
    while((!choice.equals("A"))&&(!choice.equals("D"))&&(!choice.equals("H"))){ //when the user does not enter A, D, or H
      System.out.println("Invalid input");
      System.out.println("User's choice (--(A)Attack, (D)Destructive, (H)Heal--):");
      choice=scn.nextLine();
      choice=choice.toUpperCase();
    }
    while(choice.equals("H")&&PlayerHealth>=100){ //if health is full and player tries to heal
      System.out.println("Health already full");
      System.out.println("User's choice (--(A)Attack, (D)Destructive, (H)Heal--):");
      choice=scn.nextLine();
      choice=choice.toUpperCase();
    }
    if(choice.equals("A")){
      try {
        UserAttack(PlayerHealth,CPUHealth, mainObject, rounds);// go to UserAttack method
      } catch(Exception InterruptedException) { //UserAttack has some Sleep references
        // code to handle the exception not needed
      }
    }else if(choice.equals("D")){
      try {
        UserDestructive(PlayerHealth,CPUHealth, mainObject, rounds);
      } catch(Exception InterruptedException) { //the method has some Sleep references
        // code to handle the exception not needed
      }
    }else if(choice.equals("H")){
      try {
        UserHeal(PlayerHealth,CPUHealth, mainObject, rounds);
      } catch(Exception InterruptedException) { //the method has some Sleep references
        // code to handle the exception not needed
      }
    }
  }


  //*********************************************        Player Interactions         *********************************************************************/

  /**
  * print and decide what happens when the user attacks
  * @param CPUHealth health of computer ship
  * @param PlayerHealth health of user ship
  * @param mainObject an object of class Main
  * @param rounds how many rounds have been played
  */
  public static void UserAttack(int PlayerHealth, int CPUHealth, Main mainObject,int rounds) throws InterruptedException {//throws IE lets Thread.sleep() work //Should take in CPU health
    Thread.sleep(1000); //wait a second
    //print graphics for attack with added explosion ASCII
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
    int damage=(int)(Math.random()*50);// randomize amount of damage
    System.out.print(damage); //show the damage made on the CP
    CPUHealth-=damage;
    Thread.sleep(4000);
    CPUPick(PlayerHealth,CPUHealth, mainObject, rounds);//let the CPU Pick next
  }
  /**
  * print and decide what happens when the user attacks with destructive
  * @param CPUHealth health of computer ship
  * @param PlayerHealth health of user ship
  * @param mainObject an object of class Main
  * @param rounds how many rounds have been played
  */
  public static void UserDestructive(int PlayerHealth, int CPUHealth, Main mainObject,int rounds) throws InterruptedException {//throws IE lets Thread.sleep() work //Should take in CPU health
    Thread.sleep(1000);
    //print graphics
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
    int damage=(int)(Math.random()*100);// randomize damage
    System.out.print(damage);
    CPUHealth-=damage;
    System.out.print("\n\nDamage made on Player: -");
    int damage2=(int)(Math.random()*100);// randomize damage
    System.out.print(damage2);
    PlayerHealth-=damage2;
    Thread.sleep(4000);
    CPUPick(PlayerHealth,CPUHealth, mainObject, rounds);//go to CPU's pick
  }
  /**
  * print and decide what happens when the user chooses to heal their ship
  * @param CPUHealth health of computer ship
  * @param PlayerHealth health of user ship
  * @param mainObject an object of class Main
  * @param rounds how many rounds have been played
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
    int heal=(int)(Math.random()*(100-PlayerHealth));// randomize with max to full health
    System.out.print(heal);
    PlayerHealth+=heal;//increase player's health
    Thread.sleep(4000);
    CPUPick(PlayerHealth,CPUHealth, mainObject, rounds);
  }


  /*********************************************        CPU Interactions         ******************************************************************** */

  /**
  * let CPU choose his play
  * @param CPUHealth health of computer ship
  * @param PlayerHealth health of user ship
  * @param mainObject an object of class Main
  * @param rounds how many rounds have been played
  */
  public static void CPUPick(int PlayerHealth, int CPUHealth, Main mainObject,int rounds) {
    String[] empty=new String[1];
    if(PlayerHealth<=0){
      //player is dead
      System.out.println("\nGame Over!\nThank you for playing.");
      System.exit(0);
    }else if(CPUHealth<=0){
      //CPU is dead
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
      //when the CPU is about to die, he instantly chooses to heal
      try {
        CPUHeal(PlayerHealth,CPUHealth, mainObject, rounds);
      } catch(Exception InterruptedException) {
        // code to handle the exception not needed
      }
    }
    if (PlayerHealth+40<=CPUHealth){
      //when the CPU's health is 40 points higher than the player, he instantly uses a destructive attack
      try {
        CPUDestructive(PlayerHealth,CPUHealth, mainObject, rounds);
      } catch(Exception InterruptedException) {
        // code to handle the exception not needed
      }
    }
    int CPUchoice=(int)(Math.random()*2); //randomize CPU's choice
    if(CPUchoice==0){
      try {
        CPUAttack(PlayerHealth,CPUHealth, mainObject, rounds);
      } catch(Exception InterruptedException) {
        // code to handle the exception not needed
      }
    }else if(CPUchoice==1){
      try {
        CPUDestructive(PlayerHealth,CPUHealth, mainObject, rounds);
      } catch(Exception InterruptedException) {
        // code to handle the exception not needed
      }
    }else if(CPUchoice==2){
      try {
        CPUHeal(PlayerHealth,CPUHealth, mainObject, rounds);
      } catch(Exception InterruptedException) {
        // code to handle the exception not needed
      }
    }
  }
  /**
  * print and decide what happens when the CPU attacks
  * @param CPUHealth health of computer ship
  * @param PlayerHealth health of user ship
  * @param mainObject an object of class Main
  * @param rounds how many rounds have been played
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
    int damage=(int)(Math.random()*50);
    System.out.print(damage);
    PlayerHealth-=damage;//damages player with a random amount
    Thread.sleep(6000);
    PlayerPick(PlayerHealth,CPUHealth, mainObject, rounds);
  }
  /**
  * print and decide what happens when the CPU destructively attacks
  * @param CPUHealth health of computer ship
  * @param PlayerHealth health of user ship
  * @param mainObject an object of class Main
  * @param rounds how many rounds have been played
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
    int damage=(int)(Math.random()*100);
    System.out.print(damage);
    CPUHealth-=damage; //damage the CPU randomly
    System.out.print("\n\nDamage made on Player: -");
    int damage2=(int)(Math.random()*100);
    System.out.print(damage2);
    PlayerHealth-=damage2; //damage the player randomly
    Thread.sleep(6000);
    PlayerPick(PlayerHealth,CPUHealth, mainObject, rounds);
  }
  /**
  * print and decide what happens when the CPU heals
  * @param CPUHealth health of computer ship
  * @param PlayerHealth health of user ship
  * @param mainObject an object of class Main
  * @param rounds how many rounds have been played
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
    int heal=(int)(Math.random()*(100-CPUHealth));// random 0 to full possible
    System.out.print(heal);
    CPUHealth+=heal; //heal the CPU's ship randomly
    Thread.sleep(6000);
    PlayerPick(PlayerHealth,CPUHealth, mainObject, rounds);
  }
}
