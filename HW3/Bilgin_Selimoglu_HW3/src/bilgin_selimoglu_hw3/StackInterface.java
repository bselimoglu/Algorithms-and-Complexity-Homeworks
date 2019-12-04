/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilgin_selimoglu_hw3;

/**
 *
 * @author User
 * @param <AnyType>
 */
public interface StackInterface<AnyType> {
    public int size();
    public boolean isEmpty();
    public AnyType peek();
    public AnyType pop();
    public void push(AnyType item);
}
