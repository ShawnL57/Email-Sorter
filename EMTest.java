public class EMTest
{
   public static void main(String[] args)
   {
      EMDirectory emails = new EMDirectory("emdir.txt");  
      emails.listAll();
      
      
      emails.addEntry(new Name("Shawn","Lin"),"shawnlin916@gmail.com");
      emails.addEntry(new Name("Jonathan","Chpolasky"),"jonathanchpolansky@gmail.com");
      emails.addEntry(new Name("Alexis","Bell"),"bunnyandlamby@gmail.com");
      emails.addEntry(new Name("Ella","Morris"),"ellapmorris@gmail.com");
      emails.addEntry(new Name("Edward","Lin"),"edward@gmail.com");
      
      emails.listAll();
      
      System.out.println(emails.lookUp(new Name("Ted", "Teacher")));
      System.out.println();
      
      System.out.println(emails.lookUp(new Name("Alexis","Bell")));
      System.out.println();
      
      System.out.println(emails.lookUp(new Name("Destiny", "Vasquez")));
      System.out.println();
      
      System.out.println(emails.lookLastName("Binary"));
      System.out.println();
      
      System.out.println(emails.lookLastName("Bell"));
      System.out.println();
      
      emails.updateEmail(new Name("Edward", "Lin"), "edwardlin@gmail.com");
      
      emails.updateEmail(new Name("Shawns", "Lin"), "monekytype@gmail.com");
      
      emails.listAll();
      
      emails.removeName(new Name("Jerry", "Java"));
      
      emails.removeName(new Name("Ella", "Morris"));
      
      emails.removeName(new Name("Alexander", "Mashhour"));
      
      emails.listAll();
      
      emails.removeLastName("Binary");
      
      emails.removeLastName("Bell");
      
      emails.removeLastName("Squarepants");
      
      emails.listAll();
      
      
      
      
   
      
      
   }
}
