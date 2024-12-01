import java.util.*;
class SignUp{
  private String username;
  private String mobileNo;
  private String email;
  private String password;
  private int otp;
  private int generateOTP() 
  {
    Random randotp = new Random();
    return 100000 + randotp.nextInt(900000);
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

    System.out.print("Enter your username: ");
    username = sc.nextLine();

    if(username.isEmpty())
    {
      System.out.println("Username cannot be empty.");
      return;
    }

    while(true)
    {
      System.out.println("Enter your Email id or Mobile Number: ");
      String contact = sc.nextLine();

      if(isValidEmail(contact))
      {
        email = contact;
        System.out.println("OTP sent to eamil: "+email);
        break;
      }
      else if(isValidMobileNo(contact))
      {
        mobileNo = contact;
        System.out.println("OTP sent to mobile number: "+mobileNo);
        break;
      }
      else 
      {
        System.out.println("Please enter a valid email or mobile number.");
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
        System.out.println("Invalid OTP. Please Try again.");
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
        System.out.println("Password must be at least 8 characters long.Please Try again...");
      }
    }

    System.out.println("Registration Successful...!");

    System.out.println("Username: "+username);
    if(email != null)
    {
      System.out.println("Registered email: "+ email);
    }
    else 
    {
      System.out.println("Registered mobile number: "+mobileNo);
    }

    String finalContact = (email != null) ? email : mobileNo;
    StaticUserData.addUser(finalContact,password,username);
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