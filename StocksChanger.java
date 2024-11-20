public class StocksChanger {
  static String[][] stocksData = Stocks.stockData;

  public static String[][] stocksModifier() {
    int random = (int) (Math.random() * 15) + 1;
    for (int i = 0; i < stocksData.length; i++) {
      for (int j = 0; j < stocksData[i].length; j++) {
        int stockPrice = (int) Integer.parseInt(stocksData[i][1]) - random;
        stocksData[i][1] = stockPrice + "";
      }
    }
    return stocksData;
  }
}
