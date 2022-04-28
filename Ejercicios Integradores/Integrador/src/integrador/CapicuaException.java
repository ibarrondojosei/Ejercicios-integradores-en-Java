/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador;

/**
 *
 * @author Jose Ignacio
 */
public class CapicuaException extends Exception {

    /**
     * Creates a new instance of <code>CapicuaException</code> without detail
     * message.
     */
    public CapicuaException() {
    }

    /**
     * Constructs an instance of <code>CapicuaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CapicuaException(String msg) {
        super(msg);
    }
}
