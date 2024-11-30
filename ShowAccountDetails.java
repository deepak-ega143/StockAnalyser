import java.util.*;

public class ShowAccountDetails {
  static Scanner sc = new Scanner(System.in);

  public static void printAccountFunctionalities() {
    System.out.println("1. SHOW BANK BALANCE");
    System.out.println("2. ADD FUNDS");
    System.out.println("3. WITHDRAW MONEY");
  }

  public static void printUserData(int userChoice) {
    String userName = LoginCredentials.username;
    switch (userChoice) {
      case 1:
            System.out.println(StaticUserData.getBalance(userName));
        break;
      case 2:
            System.out.println("EXISTED ACCOUNT BALANCE: " + StaticUserData.getBalance(userName));
            System.out.println("ENTER THE FUNDS AMOUNT");
            int funds = sc.nextInt();
            StaticUserData.UpdateAccountBalance(funds, userName);
            System.out.println("UPDATED ACCOUNT BALANCE: " + StaticUserData.getBalance(userName));
        break;
      case 3:
            System.out.println("EXISTED ACCOUNT BALANCE: " + StaticUserData.getBalance(userName));
            System.out.println("ENTER THE WITHDRAW AMOUNT");
            int withdrawAmount = sc.nextInt();
            if(withdrawAmount>Integer.parseInt(StaticUserData.getBalance(userName))){
                System.out.println("INSUFFICIENT BALANCE TO WITHDRAW PLEASE ADD LESS THAN YOUR ACCOUNT BALANCE");
            }else{
                System.out.println("WITHDRAW AMOUNT: "+withdrawAmount);
                StaticUserData.modifyAccountBalance(withdrawAmount+"", userName);
                System.out.println("REMAINING ACCOUNT BALANCE: " + StaticUserData.getBalance(userName));
            }
        break;
      default:
        System.out.println("GIVE VALID INPUT");
        break;
    }
  }
}
