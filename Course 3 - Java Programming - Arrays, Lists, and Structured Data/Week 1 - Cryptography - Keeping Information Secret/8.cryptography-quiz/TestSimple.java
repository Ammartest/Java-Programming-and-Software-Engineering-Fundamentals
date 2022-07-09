
/**
 * Write a description of TestSimple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestSimple {
    public void TestSimple() {
        Simple item = new Simple(3, "blue");
        System.out.println(item);
        //System.out.println(item.mystery(5, "ho")); // This line causes compile error since mystery() is a private method of the class Simple so it cannot be called by the TestSimple class.
    }
}
