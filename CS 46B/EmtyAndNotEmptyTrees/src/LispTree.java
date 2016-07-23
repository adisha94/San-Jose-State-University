public interface LispTree
{
   boolean empty();
   Object data();
   LispTree left();
   LispTree right();
   int height(); // calculates the height of the LispTree
   Object eval(); // performs the operations with the given operator of the LispTree
}