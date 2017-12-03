import java.awt.*;
import java.awt.event.*;

public class KeyEvents { //extends game implements KeyListener
  int posx = 0;
  int posy = 0;

  public static void main(String[] args) {
  }
  public void displayInfo(KeyEvent e, String keyStatus){

        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
        }
    }

  public void keyTyped(KeyEvent e) {

    int key = e.getKeyCode();

    if (key == KeyEvent.VK_W) {
      if (posy>0) { // also add in if statements ensuring compatible readAhead
        posy -= 1;
      } else {
        System.out.println("You can't go there! You'll fall off the edge of the map!");
      }
    } else if (key == KeyEvent.VK_A) {
      if (posx>0) {
        posx -= 1;
      } else {
        System.out.println("You can't go there! You'll fall off the edge of the map!");
      }
    } else if (key == KeyEvent.VK_S) {
      if (posy<20) { // or whatever the maximum posy is
        posy += 1;
      } else {
        System.out.println("You can't go there! You'll fall off the edge of the map!");
      }
    } else if (key == KeyEvent.VK_D) {
      if (posx<20) { // or whatever the maximum posy is
        posx += 1;
      } else {
        System.out.println("You can't go there! You'll fall off the edge of the map!");
      }
    }
  }
}
