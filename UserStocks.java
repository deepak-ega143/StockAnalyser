public class UserStocks {
   String username;
   String[][] stocksWithQuantity;
   String accountBalance;

   UserStocks(String userData, String[][] rahulStocks, String accBalance) {
      this.username = userData;
      this.stocksWithQuantity = rahulStocks;
      this.accountBalance = accBalance;
   }
}
