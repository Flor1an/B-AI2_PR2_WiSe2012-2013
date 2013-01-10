/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol;

/**
 *
 * @author birgit
 */
public class StringUtil {

    private StringUtil(){};
    public static String capitalize(String aString) {
        String first = aString.substring(0, 1).toUpperCase();
        String last = aString.substring(1, aString.length()).toLowerCase();
        return first + last;
    }
}
