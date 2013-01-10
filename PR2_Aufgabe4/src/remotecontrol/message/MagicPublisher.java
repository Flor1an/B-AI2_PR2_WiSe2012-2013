/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol.message;

import com.mongodb.MongoException;
import de.hawhamburg.livingplace.messaging.activemq.wrapper.ConnectionSettings;
import de.hawhamburg.livingplace.messaging.activemq.wrapper.LPPublisher;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;

/**
 *
 * @author birgit
 */
public class MagicPublisher implements Runnable {

    private static final String ACTIVE_MQ_IP = "172.16.0.200";
    private static final String MONGO_DB_IP = "172.16.0.200";
    private final String topicOrQueue;
    private final List<Message> messages;

    private MagicPublisher(String topicOrQueue, List<Message> messages) {
       this.topicOrQueue = topicOrQueue;
       this.messages = messages;
    }
   
    public static void publish(final String topicOrQueue, final List<Message> messages) {
                    for (Message msg : messages) {
                        System.out.println(msg);
                    }        
        new Thread(new MagicPublisher(topicOrQueue, messages)).start();
    }
    
    @Override
    public void run() {
        final ConnectionSettings settings = new ConnectionSettings();
        settings.amq_ip = ACTIVE_MQ_IP;
        settings.mongo_ip = MONGO_DB_IP;
                try {
                    LPPublisher publisher = new LPPublisher(topicOrQueue, settings);
                    for (Message msg : messages) {
                        System.out.println(msg);
                        publisher.publish(msg.getMessage());
                    }
                } catch (JMSException ex) {
                    ex.printStackTrace();
                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                } catch (MongoException ex) {
                    ex.printStackTrace();
                }
    }
}
