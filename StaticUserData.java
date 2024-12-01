import java.util.*;

class StaticUserData {
  static String[][] userData = {
      { "rahul.verma@example.com", "Pass123@", "9876543210", "rahul_verma", "5000", "Tata Consultancy Services",
          "Reliance Industries" },
      { "meena.sharma@example.com", "Meena#890", "9123456789", "meena_sharma", "7500", "Infosys", "ITC" },
      { "arjun.nair@example.com", "Arjun*007", "9988776655", "arjun_nair", "3200", "Wipro", "Power Grid" },
      { "priya.singh@example.com", "Priya!456", "9876501234", "priya_singh", "8700", "ICICI Bank", "Tata Steel" },
      { "vishal.kumar@example.com", "Vishal@2022", "9123409876", "vishal_kumar", "10000", "Bajaj Finance",
          "Adani Enterprises" }
  };

  public static int userCount = 5;
  // static String[][] rahulStocks = { { " Tata Consultancy Services", "3" }, {
  // "Reliance Industries", "2" } };
  // static String[][] meenaStocks = { { " Infosys", "2" }, { "ITC", "3" } };
  // static String[][] arjunStocks = { { "Wipro", "5" }, { "Power Grid", "3" } };
  // static String[][] priyaStocks = { { " ICICI Bank", "1" }, { "Tata Steel", "3"
  // } };
  // static String[][] vishalStocks = { { " Bajaj Finance", "4" }, { "Adani
  // Enterprises", "15" } };

  // static UserStocks rahul = new UserStocks(userData[0][3], rahulStocks,
  // userData[0][4]);
  // static UserStocks meena = new UserStocks(userData[1][3], rahulStocks,
  // userData[1][4]);
  // static UserStocks arjun = new UserStocks(userData[2][3], rahulStocks,
  // userData[2][4]);
  // static UserStocks priya = new UserStocks(userData[3][3], rahulStocks,
  // userData[3][4]);
  // static UserStocks vishal = new UserStocks(userData[4][3], rahulStocks,
  // userData[4][4]);

  public static String getBalance(String user) {
    for (String[] strings : userData) {
      if (strings[3].equals(user)) {
        return strings[4];
      }
    }
    return "";
  }

  public static void addUser(String finalcontact,String password,String username)
  {
    if(userCount >= userData.length)
    {
      resizeUserData();
    }
    userData[userCount][0] = finalcontact;
    userData[userCount][1] = password;
    userData[userCount][2] = username;
    userCount++;
  }
  public static void resizeUserData(){
    String[][] newUserData = new String[userData.length * 2][7];
    for (int i = 0; i < userData.length; i++) {
      newUserData[i] = userData[i];
    }
    userData = newUserData;
  }
  public static String[][] updateUserData(String[][] newUserData) {
    StaticUserData.userData = newUserData;
    return StaticUserData.userData;
  }

  public static void modifyAccountBalance(String priceOfStocks, String username) {
    int stocksPrice = Integer.parseInt(priceOfStocks);
    for (String[] strings : userData) {
      if (strings[3].equals(username)) {
        int price = Integer.parseInt(strings[4]);
        int finalPrice = price - stocksPrice;
        strings[4] = finalPrice + "";
      }
    }
  }
  public static void UpdateAccountBalance(int addBalance, String username) {
    for (String[] strings : userData) {
      if (strings[3].equals(username)) {
        int balance = Integer.parseInt(strings[4]);
        int finalPrice = balance + addBalance;
        strings[4] = finalPrice + "";
      }
    }
  }
}
