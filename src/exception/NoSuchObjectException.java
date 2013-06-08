/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Jarrod
 */
public class NoSuchObjectException extends Exception {
    
    public NoSuchObjectException() {
        super();
    }
    
    public NoSuchObjectException(String message) {
        super(message);
    }
}
