
package bilgin_selimoglu_hw2;

public class Inventory implements InventoryInterface
{

    public class Node {
        public Device element;
        public Node next;
        public Node(){
            next = null;
        }
    }   
        Node front;
        Node end;
        public Inventory (){
            front = null;
            end = null;
        }
    
        public boolean IsEmpty(){
        if (front == null)  return true;
        else  return false;
    }
    
    @Override
    public void addResistor(String val, Integer cnt) {
        boolean IsAdd = true;
        Node yeni = new Node();
        Device ndevice=new Device("resistor","-",val,cnt);
        yeni.element=ndevice;
        Node pointer=front;
        if(IsEmpty()) {
            front = yeni;
            yeni.next=null;
            yeni.element=ndevice;
            yeni.element.setCnt(cnt);
            IsAdd = false;
        }
        while(IsAdd){
                if(pointer.element.getName()!="resistor" && pointer.next!=null )//basa eklemek için bu ve tek eleman degilse transistor
                {    
                    yeni.next=pointer;
                    front=yeni;
                    yeni.element.setCnt(cnt);
                    IsAdd = false;    
                }    
                else if("resistor".equals(pointer.element.getName())&& pointer.element.getVal().equals(val)){
                    pointer.element.setCnt(cnt);
                    IsAdd=false;
                    }
                else if ("resistor".equals(pointer.element.getName())&& pointer.next==null && pointer.element.getVal()!=(val)) {   
                       pointer.next=yeni;
                       yeni.next=null;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                    }
                else if(pointer.element.getName()!="resistor" && pointer.next==null)// resistor olmayanlar tek elemensa
                {
                    yeni.next=pointer;
                    front=yeni;
                    yeni.element.setCnt(cnt);
                    IsAdd=false;
                }                            
                else if (pointer.next==null) {   
                       pointer.next=yeni;
                       yeni.next=null;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                    }
                else if ("capacitor".equals(pointer.next.element.getName()))  {
                       yeni.next=pointer.next;
                       pointer.next=yeni;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                    }
            pointer=pointer.next;
        }
    }

    @Override
    public void addCapacitor(String val, String typ, Integer cnt)  { 
        boolean IsAdd = true;
        Node yeni = new Node();
        Device ndevice=new Device("capacitor",typ,val,cnt);
        yeni.element=ndevice;
        Node pointer=front;
        if(IsEmpty())   {
            front = yeni;
            yeni.next=null;
            yeni.element=ndevice;
            yeni.element.setCnt(cnt);
            IsAdd = false;
        }
        while(IsAdd)   {
                if(((pointer.element.getName()== "transistor")||(pointer.element.getName()=="inductor"))&&pointer.next!=null)//basa eklemek için bu ve tek eleman degilse transistor yada inductor
                {
                    yeni.next=pointer;
                    front=yeni;
                    yeni.element.setCnt(cnt);

                    IsAdd = false;
                }
                else if(pointer.element.getName().equals("capacitor")&&pointer.element.getType().equals(typ)&&pointer.element.getVal().equals(val))   {
                    pointer.element.setCnt(cnt);
                    IsAdd=false;
                    }
                else if(pointer.element.getName().equals("capacitor")&&pointer.next==null&&!pointer.element.getType().equals(typ)&&!pointer.element.getVal().equals(val)) {
                       pointer.next=yeni;
                       yeni.next=null;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                }
                else if(pointer.next==null &&((pointer.element.getName()=="transistor")||(pointer.element.getName()=="inductor")))//inductor ya da transistor tek elemensa
                {
                    yeni.next=pointer;
                    front=yeni;
                    yeni.element.setCnt(cnt);
                    IsAdd=false;   
                } 
                else if (pointer.next==null)   {   
                       pointer.next=yeni;
                       yeni.next=null;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                    }
                else if ("inductor".equals(pointer.next.element.getName()))   {
                       yeni.next=pointer.next;
                       pointer.next=yeni;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                    }
            pointer=pointer.next;
        }
    }

    @Override
    public void addInductor(String val, Integer cnt)     {
        boolean IsAdd = true;
        Node yeni = new Node();
        Device ndevice=new Device("inductor","-",val,cnt);
        yeni.element=ndevice;
        Node pointer=front;
        if(IsEmpty()) {
            front = yeni;
            yeni.next=null;
            yeni.element=ndevice;
            yeni.element.setCnt(cnt);
            IsAdd = false;
        }
        while(IsAdd) {
                if (pointer.element.getName()=="transistor" && pointer.next!=null)//basa eklemek için bu ve tek eleman degilse transistor
                {
                    yeni.next=pointer;
                    front=yeni;
                    yeni.element.setCnt(cnt);
                    
                    IsAdd = false;
                }
                else if("inductor".equals(pointer.element.getName())&& pointer.element.getVal().equals(val))   {
                        pointer.element.setCnt(cnt);
                        IsAdd=false;
                    }
                else if ("inductor".equals(pointer.element.getName())&& pointer.element.getVal()!=val&& pointer.next==null)   {
                       yeni.next=pointer.next;
                       pointer.next=yeni;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                    }
                else if(pointer.next==null && pointer.element.getName()=="transistor")// transistor tek element
                {
                    yeni.next=pointer;
                    front=yeni;
                    yeni.element.setCnt(cnt);
                    IsAdd=false;
                }
                else if (pointer.next==null){   
                       pointer.next=yeni;
                       yeni.next=null;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                    }
                else if ("transistor".equals(pointer.next.element.getName())) {
                       yeni.next=pointer.next;
                       pointer.next=yeni;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                    }
            pointer=pointer.next;
        }
    }

    @Override
    public void addTransistor(String typ, Integer cnt){
        
        boolean IsAdd = true;
        Node yeni = new Node();
        Device ndevice=new Device("transistor",typ,"-",cnt);
        yeni.element=ndevice;
        Node pointer=front;
        if(IsEmpty()){
            front = yeni;
            yeni.next=null;
            yeni.element=ndevice;
            yeni.element.setCnt(cnt);
            IsAdd = false;
        }
        while(IsAdd) {
                if("transistor".equals(pointer.element.getName()) && pointer.element.getType().equals(typ)){
                        pointer.element.setCnt(cnt);
                        IsAdd=false;
                    }
                else if("transistor".equals(pointer.element.getName())&&!pointer.element.getType().equals(typ)&&pointer.next==null){
                       pointer.next=yeni;
                       yeni.next=null;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                }
                else if (pointer.next==null) {   
                       pointer.next=yeni;
                       yeni.next=null;
                       yeni.element.setCnt(cnt);
                       IsAdd=false;
                    }
            pointer=pointer.next;
        }
    }
    @Override
    public int deleteResistor(String val, Integer cnt){   
        Node yenii = new Node();
        Device nndevice=new Device("resistor","-",val,cnt);
        yenii.element=nndevice;
        Node pointerr=front;
        Integer remain=0;
        if(IsEmpty()){
        System.out.println("There is no inventory...");
        }
        else{
            while(pointerr!=null){
                if(pointerr.element.getVal().equals(val) && "resistor".equals(pointerr.element.getName())){
                    boolean IsPosorzero = pointerr.element.delCnt(cnt);
                    if(IsPosorzero){
                    remain=pointerr.element.getCnt();
                    System.out.println("New amount of that resistor = "+pointerr.element.getCnt());
                    }
                }
            pointerr=pointerr.next;
            }
        } 
        return remain;
    }
    @Override
    public int deleteCapacitor(String val, String typ, Integer cnt){
        Node yenii = new Node();
        Device nndevice=new Device("capacitor",typ,val,cnt);
        yenii.element=nndevice;
        Node pointerr=front;
        Integer remain=0;
        if(IsEmpty()){
        System.out.println("There is no inventory...");
        }
        else{
            while(pointerr!=null){
                if(pointerr.element.getName()=="capacitor"&&pointerr.element.getVal()==val&&pointerr.element.getType()==typ){
                    boolean IsPosorzero=pointerr.element.delCnt(cnt);
                    if(IsPosorzero){
                        remain=pointerr.element.getCnt();
                    }
                }
            pointerr=pointerr.next;
            }
        } 
        return remain;
    }
    @Override
    public int deleteInductor(String val, Integer cnt){
        Node yenii = new Node();
        Device nndevice=new Device("inductor","-",val,cnt);
        yenii.element=nndevice;
        Node pointerr=front;
        Integer remain=0;
        if(IsEmpty()){
        System.out.println("There is no inventory...");
        }
        else {
            while(pointerr!=null){
                if("inductor".equals(pointerr.element.getName()) && pointerr.element.getVal().equals(val)){
                    boolean IsPosorzero=pointerr.element.delCnt(cnt);
                    if(IsPosorzero) {
                        remain=pointerr.element.getCnt();
                    }
                }
            pointerr=pointerr.next;
            }
        } 
        return remain;
    }
   @Override
    public int deleteTransistor(String typ, Integer cnt){
        Node yenii = new Node();
        Device nndevice=new Device("transistor",typ,"-",cnt);
        yenii.element=nndevice;
        Node pointerr=front;
        Integer remain=0;
        if(IsEmpty()){
        System.out.println("There is no inventory...");
        }
        else{
            while(pointerr!=null){
                if(pointerr.element.getName()=="transistor" && pointerr.element.getType()==typ){
                    boolean IsPosorzero=pointerr.element.delCnt(cnt);
                    if(IsPosorzero){   
                        remain=pointerr.element.getCnt();
                    }
                }
                pointerr=pointerr.next;
            }
        }
        return remain;
    }
    @Override
    public void printInventory() {
        Node pointer=front;
        while(pointer!=null){
            pointer.element.yazdır();
            pointer=pointer.next;
        }
    }
}
