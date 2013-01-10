/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol.message;

import java.util.HashMap;
import java.util.Map;
import remotecontrol.model.Control;
import remotecontrol.model.Room;
import sun.applet.Main;

/**
 *
 * @author birgit
 */
class MessageFactory {

    private MessageFactory() {
    }
    ;
    private static final Map<Control, String> msgMap = new HashMap<>();

    static {
        msgMap.put(Control.LIGHT, "{\"action\":\"%s_light_color\","
                + "\"values\":{\"red\":%s,\"green\":%s,\"blue\":%s},"
                + "\"id\":\"prp2\",\"Version\":null}");
        msgMap.put(Control.CURTAIN, "{\"action\":\"%s_curtain_%s\",\"values\":{},\"Id\":\"prp2\",\"Version\":null}");
        msgMap.put(Control.BLIND, "{\"action\":\"blinds_%s_%s\",\"values\":{ },\"Id\":\"prp2\",\"Version\":null}");
        msgMap.put(Control.WINDOW, "{%s:[%s,SLOW]}");
    }
    
    /*
     * {
     * 
     */

    public static Message getInstance(String topicOrQueueName,String type, Control control, String... args) {
        return new Message(topicOrQueueName,type,String.format(msgMap.get(control),(String[])args));
    }
}
