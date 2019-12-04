
package bilgin_selimoglu_hw2;

public class Device 
{
    private String Name;
    private String Type;
    private String Value;
    private Integer Count;
    public Device(String n, String t, String v, Integer c)
    {
        this.Name = n;
        this.Type = t;
        this.Value = v;
        this.Count = c=0;
    }
    public void yazdır()
    {
        System.out.println("Name :" + Name);
        System.out.println("Type :" + Type);
        System.out.println("Value :" + Value);
        System.out.println("Count : " + Count);
    }
    public String getName()
    {
        return Name;
    }
    public String getVal()
    {
        return Value;
    }
    public String getType()
    {
        return Type;
    }
    public int getCnt()
    {
        return Count;
    }
    public int setCnt(int Cnt)
    {
        if(Count==0)
        {
            Count=Cnt;
            return Count;
        }
        else
        {
            Count=Count+Cnt;
            return Count;
        }
    }
    public boolean delCnt(int Cnt)
    {
        if (Count==0)
        {
        Count=0;
        return false;
        }
        else if(Count<Cnt){
            Count=0;
            return false;
        }
        else 
            Count=Count-Cnt;
        return true;
    }   
            
}