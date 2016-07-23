public class TreeTester1
{
    public static void main(String[] args)
    {
        Tree t1 = new Tree("Tom");
        Tree s11 = new Tree("Jerry");
        Tree s12 = new Tree("Kevin");
        t1.addSubtree(s11);
        t1.addSubtree(s12);
        System.out.println(t1.interiorNodes());
        System.out.println("Expected: 1\n");
    }
}
