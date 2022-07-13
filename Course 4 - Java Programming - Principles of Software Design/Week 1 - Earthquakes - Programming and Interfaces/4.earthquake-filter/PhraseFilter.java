/**
 * Filter by Phrase
 * 
 * @author Ginny Dang
 * @version July 13rd, 2022
 */

public class PhraseFilter implements Filter {
    private String reqType;
    private String phrase;
    
    public PhraseFilter(String where, String phrase) {
        reqType = where;
        this.phrase = phrase;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        String title = qe.getInfo();
        boolean qualified = false;
        if (reqType.equals("start")) {
            qualified = title.startsWith(phrase);
        } else if (reqType.equals("end")) {
            qualified = title.endsWith(phrase);
        } else if (reqType.equals("any")) {
            /*
            int phraseIndex = title.indexOf(phrase);
            qualified = (phraseIndex != -1);
            */
            qualified = title.contains(phrase);
        }
        return qualified;
    }
    
    public String getName() {
        return "Phrase";
    }
}