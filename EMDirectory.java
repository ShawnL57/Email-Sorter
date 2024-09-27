import java.io.*;
import java.util.*;
public class EMDirectory
{
  	private Map<Name, String> dir;

  	public EMDirectory()
  	{

      dir = new TreeMap<>();
  	}

  	public EMDirectory(String dirFile)
  	{
    	BinarySearchTree temp = new BinarySearchTree();

    	try
    	{
    		Scanner in = new Scanner(new File(dirFile));
    		while(in.hasNext())
    		{
      			Integer s = 0;
      			if(in.hasNext())
        			   s = (Integer)in.next();       		
               temp.insert(s);
    		}
    	}
    	catch(IOException i)
    	{
    		System.out.println("Error: " + i.getMessage());
    	}
  	}
   
   public void addEntry(Name name, String emailAddr)
   {
      dir.put(name, emailAddr);
   }
   public String lookUp(Name name)
   {
      return dir.get(name);
   }
   public String lookLastName(String lastName) 
   {
      String s = "[";
      for(Name x : dir.keySet())
      {
         if(x.getLast().equals(lastName))
            s += dir.get(x)+", ";
      }
      
      s = s.substring(0, s.length()-2) + "]";
      return s;
   }
   public void listAll()
   {
      for(Name e : dir.keySet())
      {
         System.out.println(e + ": " + dir.get(e));
      }
      System.out.println();
   }
   public boolean updateEmail(Name name, String newEmail)
   {
      if(dir.get(name) == null)
         return false;
      else
         dir.replace(name, newEmail);
         
      return true;

   }
   public boolean removeName(Name name)
   {
      if(dir.get(name) == null)
         return false;
      else
         dir.remove(name);
      return true;
   }
   
   public void removeLastName(String lastName)
   {
      Iterator<Name> itr = dir.keySet().iterator();
      while(itr.hasNext())
      {
         Name temp = itr.next();
         if(temp.getLast().equals(lastName))
            itr.remove();
      }
      
   }
}