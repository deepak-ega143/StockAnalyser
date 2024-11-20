import java.util.*;

public class BuyStocks {
  public static String[][] buyStocks() {
    String[][] stocksData = Stocks.stockData;
    double stockManipulator = Math.floor(Math.random());
    if (stockManipulator <= 0.5) {
      for (int i = 0; i < stocksData.length; i++) {
        int data = Integer.parseInt(stocksData[i][1]);
        if (data > 1500) {
          data = (int) ((int) data - (stockManipulator * 100));
        }
        stocksData[i][1] = data + "";
      }
    }
    return stocksData;
  }

  public static String stockSelection(int[] arrayOfSelectionStocks) {
    int sumOfStocksPrice = 0;
    String[][] modifiedStocksData = BuyStocks.buyStocks();
    for (int i : arrayOfSelectionStocks) {
      sumOfStocksPrice += Integer.parseInt(modifiedStocksData[i][1]);
    }
    boolean eligibleToBuy = checkBalance(sumOfStocksPrice);
    if (eligibleToBuy == false) {
      return "UNABLE TO BUY THE STOCKS. INSUFFICIENT BALANCE!";
    } else {
      int lastIndex = 0;
      String[][] newStocksAppend = StaticUserData.userData;
      String[] newUserStocks = null;
      String userName = LoginCredentials.username;
      for (String[] string : newStocksAppend) {
        if (string[3].equals(userName)) {
          newUserStocks = new String[string.length + arrayOfSelectionStocks.length];
          lastIndex = string.length;
        }
      }
      for (int i = 0; i < newStocksAppend.length; i++) {
        for (int j = 0; j < newStocksAppend[i].length; j++) {
          if (newStocksAppend[i][3].equals(userName)) {
            newUserStocks[j] = newStocksAppend[i][j];
          }
        }
      }
      String[][] stocksData = Stocks.stockData;
      int j = 0;
      for (int i = lastIndex; i < newUserStocks.length; i++) {
        newUserStocks[i] = stocksData[arrayOfSelectionStocks[j]][0];
        j++;
      }
      // for (String[] string : newStocksAppend) {
      // if (string[3].equals(userName)) {
      // string = newUserStocks;
      // System.out.println(Arrays.toString(newUserStocks));
      // System.out.println(Arrays.toString(string));
      // break;
      // }
      // }
      for (int i = 0; i < newStocksAppend.length; i++) {
        for (int k = 0; k < newStocksAppend[i].length; k++) {
          if (newStocksAppend[i][3].equals(userName)) {
            newStocksAppend[i] = newUserStocks;
            break;
          }
        }
      }
      String[][] updatedUserData = StaticUserData.updateUserData(newStocksAppend);
      System.out.println(Arrays.toString(updatedUserData[1]));
    }

    return sumOfStocksPrice + "";
  }

  public static boolean checkBalance(int totalStockPrice) {
    String userData = LoginCredentials.username;
    int bankBalance = Integer.parseInt(StaticUserData.getBalance(userData));
    if (bankBalance > totalStockPrice) {
      return true;
    }
    return false;
  }

}
