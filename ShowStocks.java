public class ShowStocks {
    public static void userInput() {
        System.out.println("1. LIST OF STOCKS");
        System.out.println("2. STOCKS HISTORY");
    }

    public static void userChoice() {
        System.out.println("1. MY STOCKS");
        System.out.println("2. SOLD STOCKS");
    }

    public static void userPresentStocks(String userName) {
        String[][] userData = StaticUserData.userData;
        int i = 5;
        for (String[] strings : userData) {
            if (strings[3].equals(userName)) {
                for (int j = i; j < strings.length; j++) {
                    System.out.println(strings[j] + " ");
                }
            }
        }
    }

    public static void printListOfStocks() {
        String[][] data = Stocks.stockData;
        for (String[] strings : data) {
            System.out.println("Stocks Name: " + strings[0] + "   Stocks Price: " + strings[1]);
        }
    }
}
