public class Name implements Comparable<Name>
{
   private String first;
   private String last;
   
   public Name()
   {
      first = "";
      last = "";
   }
   public Name(String f, String l)
   {
      first = f;
      last = l;
   }
   public String getFirst() { return first; }
   
   public String getLast() { return last; }
   
   public String toString() { return last + ", " + first; } 
   
   public int compareTo(Name other)
   {
      if(last.equals(other.getLast()))
         return first.compareTo(other.getFirst());
      else
         return last.compareTo(other.getLast());
      
   }
   public boolean equals(Object other)
   {
      Name temp = (Name)other;
      return first.equals(temp.getFirst()) && last.equals(temp.getLast());
   }
}