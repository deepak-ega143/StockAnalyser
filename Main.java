import java.util.*;

class Main {
  static final String def = "\u001b[0;1m";
  static final String blink = "\u001b[5m";
  static final String red =  "\u001b[31;1m";
  static final String green = "\u001b[32;1m";
  static final String yellow = "\u001b[33;1m";
  static final String blue = "\u001b[34;1m";
  static final String purpe = "\u001b[35;1m";
  static final String skblue = "\u001b[36;1m";
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(green + "          ********************  Welcome to STOCK ANALYZER  ********************          " +def);
    System.out.println("Enter 1 for Login");
    System.out.println("Enter 2 for SignUp");
    System.out.println("Enter 3 for DeleteAccount");
    System.out.println("Enter your choice: " + def);
    int n = sc.nextInt();
    if (n == 1) {
      boolean vaildUser = false;
      int loginCount = 0;
      LoginCredentials obj = new LoginCredentials();
      String loginInformation = obj.login();
      if (loginInformation.equals("Invaild Credentials")) {
        while (loginCount < 3 && !loginInformation.equals("Login Successfull")) {
          loginInformation = obj.login();
          loginCount++;
        }
      }
      if (loginInformation.equals("Invaild Credentials")) {
        System.out.println("Limit Reached Please Try Again Later!");
      } else {
        System.out.println(loginInformation);
      }
      if (loginInformation.equals("Login Successfull")) {
        vaildUser = true;
      }
      if (vaildUser) {
        System.out.println("1. BUY STOCKS");
        System.out.println("2. SELL STOCKS");
        System.out.println("3. SHOW STOCKS");
        System.out.println("4. PROFITS STOCKS");
        System.out.println("5. LOSS STOCKS");
        System.out.println("6. ACCOUNT DETAILS");
      } else {
        return;
      }
      int categorySelection = sc.nextInt();
      int stockSelection = 0;
      switch (categorySelection) {
        case 1:
          String[][] buyStocksData = BuyStocks.buyStocks();
          for (String[] strings : buyStocksData) {
            System.out.print(stockSelection + ". ");
            for (String strings2 : strings) {
              System.out.print(strings2 + "  ");
            }
            stockSelection++;
            System.out.println();
          }
          System.out.println(yellow+"HOW MANY STOCKS WOULD YOU LIKE TO BUY ? PLEASE ENTER THE QUANTITY BELOW:"+def);
          int numberOfStocks = sc.nextInt();
          System.out.println(blink+purpe+"PLEASE ENTER THE INDEX OF THE STOCKS YOU WOULD LIKE TO PURCHASE:"+def);
          int[] arrayOfSelectionStocks = new int[numberOfStocks];
          for (int i = 0; i < numberOfStocks; i++) {
            arrayOfSelectionStocks[i] = sc.nextInt();
          }
          String sumOfStocksPrice = BuyStocks.stockSelection(arrayOfSelectionStocks);
          if (sumOfStocksPrice.equals("UNABLE TO BUY THE STOCKS. INSUFFICIENT BALANCE!")) {
            System.out.println(sumOfStocksPrice);
          } else {
            System.out.println("TOTAL PRICE OF STOCKS IS:");
            System.out.println(sumOfStocksPrice);
            StaticUserData.modifyAccountBalance(sumOfStocksPrice, LoginCredentials.username);
            System.out.println(StaticUserData.userData[0][4]);
          }
          break;
        case 2:
          // String[] stocksData = SellStocks.userStocks(LoginCredentials.username);
          String[][] existedStockPrice = Stocks.stockData;
          String[][] updatedStockPrice = Stocks.stocksChanger();
          String[] userStocks = SellStocks.userStocks(LoginCredentials.username);

        case 3:
          ShowStocks.userInput();
          int userInput = sc.nextInt();
          if (userInput == 1) {
            ShowStocks.printListOfStocks();
          } else {
            ShowStocks.userChoice();
            int stocksSelection = sc.nextInt();
            if (stocksSelection == 1) {
              ShowStocks.userPresentStocks(LoginCredentials.username);
            }
          }
        case 4:
          ProfitsAndLosses.profitOrLoss(LoginCredentials.username, true);
          break;
        case 5:
          ProfitsAndLosses.profitOrLoss(LoginCredentials.username, false);
          break;
        case 6:
          ShowAccountDetails.printAccountFunctionalities();
          int accountDetailsInput = sc.nextInt();
          ShowAccountDetails.printUserData(accountDetailsInput);
        default:
          break;
      }
    }
    else if(n==2)
    {
      SignUp signup = new SignUp();
      signup.signUP();
    }
  }
}
