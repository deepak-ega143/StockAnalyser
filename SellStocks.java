public class SellStocks {
  static String[][] userData = StaticUserData.userData;

  public static String[] userStocks(String userName) {
    String[] userStocks = null;
    for (String[] array : userData) {
      if (array[3].equals(userName)) {
        userStocks = new String[array.length - 5];
        int index = 0;
        for (int j = 5; j < array.length; j++) {
          userStocks[index] = array[j];
          index++;
        }
      }
    }
    return userStocks;
  }
  
  }

