import java.util.*;
class SignUp{
  private String username;
  private String mobileNo;
  private String email;
  private String password;
  private int otp;

  static final String def = "\u001b[0;1m";
  static final String blink = "\u001b[5m";
  static final String red =  "\u001b[31;1m";
  static final String green = "\u001b[32;1m";
  static final String yellow = "\u001b[33;1m";
  static final String blue = "\u001b[34;1m";
  static final String purpe = "\u001b[35;1m";
  static final String skblue = "\u001b[36;1m";
  private int generateOTP() 
  {
    Random randotp = new Random();
    return 1000 + randotp.nextInt(9000);
  }
  
  public boolean isValidMobileNo(String mobileNo) 
  {
    if(mobileNo.length() == 10)
    {
      for(int i=0;i<mobileNo.length();i++)
      {
        char ch = mobileNo.charAt(i);
        if(ch < '0' || ch > '9')
        {
          return false;
        }     
      }
      return true;
    }
    else
    {
      return false;
    }
  }
  public boolean isValidEmail(String email)
  {
    if(email == null || email.length() == 0)
    {
      return false;
    }
    
    int atIndex = email.indexOf('@');
    int dotIndex = email.lastIndexOf('.');
    
    if(atIndex <= 0 || atIndex == email.length() - 1) return false;
    
    if(dotIndex <= atIndex + 2 || dotIndex == email.length() - 1) return false;
    
    if(email.contains(" ")) return false;
    
    return true;
    
  }
  public boolean isValidOtp(int eotp)
  {
    return this.otp == eotp;
  }
  public boolean isValidPass(String password)
  {
    return password != null && password.length() >= 8;
  }

  public void signUP() 
  {
    Scanner sc = new Scanner(System.in);
    
    while(true)
    {
      System.out.print("Enter your username: ");
      username = sc.nextLine().trim();

      if(username.isEmpty())
      {
        System.out.println(red+"Please enter a username. It cannot be empty."+def);
      }
      else
      {
        break;
      }
    }

    while(true)
    {
      System.out.println("Enter your Email id: ");
      email = sc.nextLine();

      if(isValidEmail(email))
      {
        System.out.println("OTP sent to eamil: "+email);
        break;
      }
      else 
      {
        System.out.println("That doesn't look like a valid email.Please try again.");
      }
    }

    otp = generateOTP();
    System.out.println("Your OTP: "+otp);

    while (true) 
    {
      System.out.print("Enter the OTP: ");
      int enteredotp = sc.nextInt();
      sc.nextLine();

      if(enteredotp == otp)
      {
        break;
      }
      else
      {
        System.out.println("The OTP you entered is incorrect. Please check and try again.");
      }
    }

    while (true) {
      System.out.print("Enter your Mobile Number: ");
      mobileNo = sc.nextLine();

      if(isValidMobileNo(mobileNo))
      {
        System.out.println("Mobile number registered: "+mobileNo);
        break;
      }
      else
      {
        System.out.println("Please enter a valid mobile number with exactly 10 digits.");
      }
    }

    while(true)
    {
      System.out.print("Enter your password (at least 8 characters): ");
      password = sc.nextLine();

      if(isValidPass(password))
      {
        break;
      }
      else
      {
        System.out.println("Your Password must be at least 8 characters long.Please Try again.");
      }
    }

    System.out.println(green +"You're all set! Registration Successful...!"+ def);

    System.out.println(yellow+"\nHere are your registered details:"+def);
    System.out.println("Username: "+username);
    System.out.println("Email: "+email);
    System.out.println("Mobile Number: "+mobileNo);
    
    StaticUserData.addUser(email,password,mobileNo,username);

    // StaticUserData.displayUserData();
  }
}



























  // String buyStock=null;
   // String sellStock=null;
   // String showStock=null;
   // String profits=null;
   // String losses=null;
   // String accountDetails=null;
   // public void printingDetais(){
   //      System.out.println("1. BUY STOCKS");
   //      System.out.println("2. SELL STOCKS");
   //      System.out.println("3. SHOW STOCKS");
   //      System.out.println("4. PROFITS STOCKS");
   //      System.out.println("5. LOSS STOCKS");
   //      System.out.println("6. ACCOUNT DETAILS");
   // }
   // public SignUp creatingObject(int a){
   //      switch(a){
   //        case 1:
   //           BuyStocks obj = new BuyStocks();
   //           return obj;
   //           break;
   //        case 2:
   //           BuyStocks obj = new BuyStocks();
   //           return obj;
   //           break;
   //        case 3:
   //           BuyStocks obj = new BuyStocks();
   //           return obj;
   //           break;
   //        case 4:
   //           BuyStocks obj = new BuyStocks();
   //           return obj;
   //           break;
   //        case 5:
   //           BuyStocks obj = new BuyStocks();
   //           return obj;
   //           break; 
   //        case 6:
   //           BuyStocks obj = new BuyStocks();
   //           return obj;
   //           break; 
   //      }
   // }