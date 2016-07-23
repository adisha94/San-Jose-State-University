public interface Decomposable
{
   /**
      Checks whether this object can be broken down into two smaller
      objects of the same type.
      @return true if this object can be further decomposed.
   */
   boolean isDecomposable();
   /**
      Breaks down this object into two smaller objects of the same type.
      @return an array of length 2, containing the two smaller objects.
   */
   Decomposable[] decompose(); 
}
