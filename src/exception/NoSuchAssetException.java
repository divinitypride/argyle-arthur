/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Jarrod
 */
public class NoSuchAssetException extends Exception {
    
    public NoSuchAssetException() {
        super();
    }
    
    public NoSuchAssetException(String message) {
        super(message);
    }
}
