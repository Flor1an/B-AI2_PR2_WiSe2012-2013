/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol.model;

/**
 *
 * @author michaseverin
 */
public enum Control {

    LIGHT("Licht"),
    BLIND("Rolos"),
    WINDOW("Fenster"),
    CURTAIN("Gardinen");

    private String asString;
    
    private Control(String name){
        this.asString = name;
    }
    
    @Override
    public String toString() {
        return asString;
    }
}
