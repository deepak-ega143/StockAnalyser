public class Stocks {
  static String[][] stockData = {
      { "Reliance Industries", "2650", "true" },
      { "Tata Consultancy Services", "3500", "true" },
      { "Infosys", "1470", "true" },
      { "HDFC Bank", "1600", "true" },
      { "ICICI Bank", "960", "true" },
      { "State Bank of India", "620", "true" },
      { "Bharti Airtel", "900", "true" },
      { "Kotak Mahindra Bank", "1800", "true" },
      { "ITC", "470", "true" },
      { "Hindustan Unilever", "2400", "true" },
      { "Adani Enterprises", "2300", "true" },
      { "Tata Steel", "120", "true" },
      { "Power Grid", "240", "true" },
      { "Wipro", "400", "true" },
      { "Tech Mahindra", "1150", "true" },
      { "Bajaj Finance", "8200", "true" },
      { "Asian Paints", "3300", "true" },
      { "UltraTech Cement", "7700", "true" },
      { "Nestle India", "23500", "true" },
      { "Maruti Suzuki", "10100", "true" }
  };

  public static String[][] stocksChanger() {
    String[][] data = StocksChanger.stocksModifier();
    Stocks.stockData = data;
    return stockData;
  }
}
