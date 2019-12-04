
package bilgin_selimoglu_hw3;

import java.util.EmptyStackException;

/*
 * @param <AnyType>
 */
public class ArrayStack<AnyType> implements StackInterface<AnyType> {
    public AnyType[] data;
    public int top = -1;
    public static int DEFAULT_CAPACITY ;
    
    public ArrayStack(int syze){
        this.DEFAULT_CAPACITY = syze*syze; 
        data = (AnyType[]) new Object[DEFAULT_CAPACITY];
        System.out.println ("stack size is = " +DEFAULT_CAPACITY +  "\n***********************************");
        
        }

//    ArrayStack() {
//        data = (AnyType[]) new Object[DEFAULT_CAPACITY];
//            }
    
    @Override
    public int size() {
        return (top+2);
    }

    @Override
    public boolean isEmpty() {
        if(top==-1){return true;}
        else return false;
    }

    @Override
    public AnyType peek() {
if (!isEmpty()){
            AnyType result = data[top];
            return result;
        }
        else throw new EmptyStackException();
    }

    @Override
    public AnyType pop() {
        if (!isEmpty()){
            AnyType result = data[top];
            data[top] = null;
            top= top-1;
            return result;
        }
        else throw new EmptyStackException();
}    
        

    @Override
    public void push(AnyType item) {
    if (top < DEFAULT_CAPACITY-1){
        top++;
        data[top] = item;
        }
    else try {
    throw new FullStackException("Alo Önemli");
        } catch (FullStackException ex) {
        ex.printStackTrace();
        }
    }

    private static class FullStackException extends Exception {
        public FullStackException(String alo_Önemli) {
        super(alo_Önemli);
        }
    }
       
        
        
    
}
