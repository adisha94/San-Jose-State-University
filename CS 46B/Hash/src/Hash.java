import java.util.*;

public class Hash
{
    public static void main(String[] args)
    {
        TreeMap<Integer, TreeSet<String>> myTreeMap = new TreeMap<Integer, TreeSet<String>>();
        Scanner in = new Scanner(System.in);
        // storing
        while (in.hasNext())
        {
            String word = in.next();
            TreeSet<String> myHash = myTreeMap.get(word.hashCode());
            
            if (myHash == null)
            {
                myHash = new TreeSet<String>();
            }
            myHash.add(word);
            myTreeMap.put(word.hashCode(), myHash);
        }
        // printing
        for (int hashcode: myTreeMap.keySet())
        {
            TreeSet<String> myTree = myTreeMap.get(hashcode);
            if(myTree == null)
                continue;
            if (myTree.size() > 1)
            {
                System.out.print(hashcode + ": ");
                String myhashList = "";
                for (String hash: myTree)
                {
                    if(myhashList.length() > 0)
                        myhashList = myhashList + ", " + hash;
                    else
                        myhashList = hash;
                }
                System.out.println(myhashList);
            }
        }
        in.close(); 
    }
}