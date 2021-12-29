import java.util.Scanner;
import java.util.Random;

class Main {
    public static StringBuilder firstRow = new StringBuilder("- | - | -\n- | - | -\n- | - | - ");
    public static StringBuilder remIndex = new StringBuilder("123456789");
    public static int userWin = 0;
    public static int compWin = 0;

  public static void makeBoard(int position, String symbol){
    if (position == 1)
    {
      firstRow.replace(0, 1, symbol);
      remIndex.delete(remIndex.indexOf("1"), remIndex.indexOf("1") + 1);
    }
    else if (position == 2)
    {
      firstRow.replace(4, 5, symbol);
      remIndex.delete(remIndex.indexOf("2"), remIndex.indexOf("2") + 1);
    }
    else if (position == 3)
    {
      firstRow.replace(8, 9, symbol);
      remIndex.delete(remIndex.indexOf("3"), remIndex.indexOf("3") + 1);
    }
    else if (position == 4)
    {
      firstRow.replace(10, 11, symbol);
      remIndex.delete(remIndex.indexOf("4"), remIndex.indexOf("4") + 1);
    }
    else if (position == 5)
    {
      firstRow.replace(14, 15, symbol);
      remIndex.delete(remIndex.indexOf("5"), remIndex.indexOf("5") + 1);
    }
    else if (position == 6)
    {
      firstRow.replace(18, 19, symbol);
      remIndex.delete(remIndex.indexOf("6"), remIndex.indexOf("6") + 1);
    }
    else if (position == 7)
    {
      firstRow.replace(20, 21, symbol);
      remIndex.delete(remIndex.indexOf("7"), remIndex.indexOf("7") + 1);
    }
    else if (position == 8)
    {
      firstRow.replace(24, 25, symbol);
      remIndex.delete(remIndex.indexOf("8"), remIndex.indexOf("8") + 1);
    }
    else if (position == 9)
    {
      firstRow.replace(28, 29, symbol);
      remIndex.delete(remIndex.indexOf("9"), remIndex.indexOf("9") + 1);
    }
    
  } 

  public static void placeComp(){
    Random rand = new Random();
    int compPosition = rand.nextInt(9) + 1;
    if(remIndex.length() == 0)
    {
      return;
    }
    else
    {
      while(!(remIndex.toString().contains("" + compPosition)))
      {
      compPosition = rand.nextInt(9) + 1;
      }
      makeBoard(compPosition, "O");
    }
  }

  public static int checkWin(){
      // return 0 if user win
      // return 1 if comp win
      // return -1 for not a win

      if((boolean)firstRow.substring(0,1).equals("X") && (boolean)firstRow.substring(4,5).equals("X") && (boolean)firstRow.substring(8,9).equals("X"))
      {
        return 0;
      }
      else if ((boolean)firstRow.substring(0,1).equals("X") && (boolean)firstRow.substring(10,11).equals("X") && (boolean)firstRow.substring(20,21).equals("X"))
      {
        return 0;
      }
      else if ((boolean)firstRow.substring(0,1).equals("X") && (boolean)firstRow.substring(14,15).equals("X") && (boolean)firstRow.substring(28,29).equals("X"))
      {
        return 0;
      }
      else if((boolean)firstRow.substring(4,5).equals("X") && (boolean)firstRow.substring(14,15).equals("X") && (boolean)firstRow.substring(24,25).equals("X"))
      {
        return 0;
      }
      else if((boolean)firstRow.substring(8,9).equals("X") && (boolean)firstRow.substring(18,19).equals("X") && (boolean)firstRow.substring(28,29).equals("X"))
      {
        return 0;
      }
      else if((boolean)firstRow.substring(10,11).equals("X") && (boolean)firstRow.substring(14,15).equals("X") && (boolean)firstRow.substring(18,19).equals("X"))
      {
        return 0;
      }
      else if((boolean)firstRow.substring(20,21).equals("X") && (boolean)firstRow.substring(24,25).equals("X") && (boolean)firstRow.substring(28,29).equals("X"))
      {
        return 0;
      }
      else if((boolean)firstRow.substring(0,1).equals("O") &&(boolean)firstRow.substring(4,5).equals("O") && (boolean)firstRow.substring(8,9).equals("O"))
      {
        return 1;
      }
      else if ((boolean)firstRow.substring(0,1).equals("O") &&(boolean)firstRow.substring(10,11).equals("O") && (boolean)firstRow.substring(20,21).equals("O"))
      {
        return 1;
      }
      else if ((boolean)firstRow.substring(0,1).equals("O") &&(boolean)firstRow.substring(14,15).equals("O") && (boolean)firstRow.substring(28,29).equals("O"))
      {
        return 1;
      }
      else if((boolean)firstRow.substring(4,5).equals("O") && (boolean)firstRow.substring(14,15).equals("O") && (boolean)firstRow.substring(24,25).equals("O"))
      {
        return 1;
      }
      else if((boolean)firstRow.substring(8,9).equals("O") && (boolean)firstRow.substring(18,19).equals("O") && (boolean)firstRow.substring(28,29).equals("O"))
      {
        return 1;
      }
      else if((boolean)firstRow.substring(10,11).equals("O") && (boolean)firstRow.substring(14,15).equals("O") && (boolean)firstRow.substring(18,19).equals("O"))
      {
        return 1;
      }
      else if((boolean)firstRow.substring(20,21).equals("O") && (boolean)firstRow.substring(24,25).equals("O") && (boolean)firstRow.substring(28,29).equals("O"))
      {
        return 1;
      }
      else
      {
        return -1;
      }
  }

  public static void playGame(){
     Scanner userInput = new Scanner(System.in);
    
    while (true){
      System.out.print("Enter desired position: ");
      int position = userInput.nextInt();
      if (position >= 0 && position <= 9 && remIndex.toString().contains("" + position))
      {
        makeBoard(position, "X");
        placeComp();
        System.out.println(firstRow);
        if(checkWin() == 0)
        {
          System.out.println("Congrats! You Won");
          userWin += 1;
          break;
        }
        else if(checkWin() == 1)
        {
          System.out.println("Darn! Computer Won. Better luck next time!");
          compWin += 1;
          break;
        }
        else if (remIndex.length() == 0 && checkWin() == -1)
        {
          System.out.println("That is a draw!");
          break;
        }
        else
        {
          continue;
        }
      }
      else
      {
        System.out.println("Enter a Valid Position");
      }  
    }
  }
  public static void main(String[] args) {
    System.out.println("Welcome to the Tic Tac Toe Game, you are X: ");
    Scanner userInput = new Scanner(System.in);
    playGame();
    while(true)
    {
      System.out.println();
      System.out.println("Do you want to play again (yes/no)");
      String ans = userInput.nextLine();
      if(ans.equals("yes") || ans.equals("Yes"))
      {
        firstRow = new StringBuilder("- | - | -\n- | - | -\n- | - | - ");
        remIndex = new StringBuilder ("123456789");
        userWin = 0;
        compWin = 0;
        playGame();
      }
      else
      {
        System.out.println("Thank You for playing! Come back soon");
        System.out.println("      Score     ");
        System.out.println("  User |  Comp  ");
        System.out.println("  " + userWin + "    |   " + compWin);
        break;
      }
    } 
  }
}