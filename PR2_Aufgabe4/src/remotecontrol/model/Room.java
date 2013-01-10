/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol.model;

/**
 *
 * @author michaseverin
 */
public enum Room {

    LOUNGE("Lounge"){
        @Override
        public Control[] getControls() {
            return new Control[]{Control.LIGHT, Control.BLIND, Control.WINDOW, Control.CURTAIN};
        }
    },
    DINING("Esszimmer"){
        @Override
        public Control[] getControls() {
            return new Control[]{Control.LIGHT, Control.BLIND, Control.WINDOW};
        }
    },
    SLEEPING("Schlafzimmer"){
        @Override
        public Control[] getControls() {
            return new Control[]{Control.LIGHT, Control.BLIND, Control.CURTAIN};         
        }
    },
    KITCHEN("Kochbereich"){
        @Override
        public Control[] getControls() {
            return new Control[]{Control.LIGHT, Control.BLIND, Control.WINDOW};
        }
    };
    
    private String asString;

    private Room(String name) {
        this.asString = name;
    }

    public abstract Control[] getControls();

    @Override
    public String toString() {
        return asString;
    }
}
