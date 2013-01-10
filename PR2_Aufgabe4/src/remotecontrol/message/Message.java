/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol.message;

/**
 *
 * @author birgit
 */
public class Message {

    private final String topicOrQueue;
    private final String type;
    private final String message;

    public Message(String topicOrQueue, String type, String message) {
        this.topicOrQueue = topicOrQueue;
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getClass().getSimpleName(), topicOrQueue, message);
    }

    public String getMessage() {
        return message;
    }
}
