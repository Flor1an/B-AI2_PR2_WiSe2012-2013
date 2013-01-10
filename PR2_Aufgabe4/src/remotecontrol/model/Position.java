/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol.model;

/**
 *
 * @author birgit
 */
public enum Position {

    OPEN("Offen"), CLOSE("Geschlossen"), HALF("Halb");
    private String name;

    private Position(String name) {
        this.name = name;
    }
    
   public Enum toEnum(String name){
       for(Enum e : this.values()){
          if(e.toString() == name){
              return e;
          }
       }
       return null;
   }

    @Override
    public String toString() {
        return name;
    }

}
