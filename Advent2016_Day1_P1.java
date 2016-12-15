import java.util.Scanner;
public class Advent2016_Day1_P1 {
  public static void main(String[] args){  
    System.out.println("Please input the directions: ");
    Scanner keyboard = new Scanner(System.in);
    
    String direction = keyboard.nextLine();
    String[] directionArray = direction.split(", ",0);
    
    int distanceX = 0;
    int distanceY = 0;
    int angle = 0;
    
    for (int i = 0; i < directionArray.length; i++) {
      String directionString = directionArray[i];
      System.out.print(directionString);
      char checkDirection = directionArray[i].charAt(0);
      String distanceChar = directionString.substring(1);
      if(checkDirection == 'R')
        angle += 90;
      else 
        angle -= 90;
      angle = checkAngle(angle);
      System.out.print(angle);
      
      switch(angle){
        case 0: distanceY += Integer.parseInt(distanceChar);
        break;
        case 90: distanceX += Integer.parseInt(distanceChar);
        break;
        case 180: distanceY -= Integer.parseInt(distanceChar);
        break;
        case 270: distanceX -= Integer.parseInt(distanceChar);
        break;
      }
      System.out.println("( " + distanceX + ", " + distanceY + " )" );
    }
    
    int finalDistance = Math.abs(distanceX) + Math.abs(distanceY);
    System.out.println("The final distance is: " + finalDistance);
  }
      
  public static int checkAngle(int angle){
   if(angle == -90)
     angle = 270;
   else if (angle == 360)
     angle = 0;
   else
     angle = angle;
   return angle;
  }
}