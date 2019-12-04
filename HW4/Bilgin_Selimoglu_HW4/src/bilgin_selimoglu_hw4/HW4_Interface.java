package bilgin_selimoglu_hw4;
/**
 *
 * @author bilgin
 */
public interface HW4_Interface {
    void BuildHash(String filename, int size);
    long ConvertInt(String mystring);
    int FindHash(long myvalue);
    void InsertHash(String mystring,int order);
    void Display(String Outputfile);
    int NumofWord(String myword);
    String ShowMax ();
    int[] CheckWord(String myword);
    void Sort(String Outfile);    
}
