public class ProfitsAndLosses {
  static String[][] existeduserData = null;
  static String[] stocksData = null;

  public static void profitOrLoss(String userName, boolean profitOrLoss) {
    existeduserData = Stocks.stockData;
    stocksData = userStocks(LoginCredentials.username);
    for (int i = 0; i < stocksData.length; i++) {
      int existedPrice = existedAndModifiedPrice(existeduserData, stocksData[i]);
      stockStatusPrinter(existedPrice, stocksData[i], profitOrLoss);
    }
  }

  public static void stockStatusPrinter(int existedPrice, String stockName, boolean profitOrLoss) {
    int increaseOrDecrease = (int) (Math.random() * 15) + 1;
    int modifiedPrice = 0;
    if (increaseOrDecrease > 8) {
      modifiedPrice = existedPrice + ((int) (Math.random() * 15) + 1);
    } else {
      modifiedPrice = existedPrice - ((int) (Math.random() * 15) + 1);
    }
    if (existedPrice > modifiedPrice && profitOrLoss == false) {
      System.out.println(stockName + " this stock is at loss.");
    } else if (modifiedPrice > existedPrice && profitOrLoss == true) {
      System.out.println(stockName + " this stock is at profit.");
    }
  }

  public static String[] userStocks(String userName) {
    String[][] userData = StaticUserData.userData;
    int i = 5;
    int index = 0;
    String[] stocksData = null;
    for (String[] strings : userData) {
      if (strings[3].equals(userName)) {
        stocksData = new String[strings.length - 5];
        for (int j = i; j < strings.length; j++) {
          stocksData[index++] = strings[j];
        }
      }
    }
    return stocksData;
  }

  public static int existedAndModifiedPrice(String[][] existedUserData, String stockName) {
    int n = 0;
    for (String[] strings : existedUserData) {
      if (strings[0].equals(stockName)) {
        n = Integer.parseInt(strings[1]);
      }
    }
    return n;
  }

}
