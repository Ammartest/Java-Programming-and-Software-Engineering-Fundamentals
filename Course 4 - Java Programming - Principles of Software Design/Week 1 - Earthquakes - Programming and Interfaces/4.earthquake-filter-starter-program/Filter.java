/**
 * Write a description of interface Filter here.
 * 
 * @author Ginny Dang
 * @version July 13rd, 2022
 */

public interface Filter {
    public boolean satisfies(QuakeEntry qe);
    public String getName();
}