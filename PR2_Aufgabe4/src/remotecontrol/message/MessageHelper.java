/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol.message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static remotecontrol.Constants.*;
import remotecontrol.StringUtil;
import remotecontrol.model.Control;
import static remotecontrol.model.Control.*;
import remotecontrol.model.Room;
import static remotecontrol.model.Room.*;

/**
 *
 * @author birgit
 */
public abstract class MessageHelper {

    private static final String WIN_PREFIX = "win";
    private static final String NUM_WINDOWS = "numWindows";
    private static final int NUM_WINDOWS_LOUNGE = 5;
    private static final int NUM_WINDOWS_DINING = 2;
    private static final int NUM_WINDOWS_KITCHEN = 2;
    private static final int NUM_WINDOWS_SLEEPING = 0;
    private static final String ACTION_PARTS_LIGHT = "action.parts";
    private static final String KITCHEN_MAIN = "_main";
    private static final String KITCHEN_COOKING = "_cooking";
    private static final Map<Control, MessageHelper> msgHelperMap = new HashMap<>();
    private static final Map<Room, Map<String, Object>> roomInfo = new HashMap<>();

    static {

        Map<String, Object> info = new HashMap<>();
        info.put(ACTION_PART_BLINDS, LOUNGE.name().toLowerCase());
        info.put(ACTION_PART_CURTAINS, new String[]{LOUNGE.name().toLowerCase()});
        info.put(NUM_WINDOWS, NUM_WINDOWS_LOUNGE);
        info.put(ACTION_PARTS_LIGHT, new String[]{LOUNGE.name().toLowerCase()});
        roomInfo.put(LOUNGE, info);


        info = new HashMap<>();
        info.put(ACTION_PART_BLINDS, DINING.name().toLowerCase() + "_" + KITCHEN.name().toLowerCase());
        info.put(ACTION_PART_CURTAINS, new String[]{});
        info.put(NUM_WINDOWS, NUM_WINDOWS_DINING);
        info.put(ACTION_PARTS_LIGHT, new String[]{DINING.name().toLowerCase()});
        roomInfo.put(DINING, info);

        info = new HashMap<>();
        info.put(ACTION_PART_BLINDS, SLEEPING.name().toLowerCase());
        info.put(ACTION_PART_CURTAINS, new String[]{SLEEPING_WINDOW,
                    SLEEPING_HALL});
        info.put(NUM_WINDOWS, NUM_WINDOWS_SLEEPING);
        info.put(ACTION_PARTS_LIGHT, new String[]{SLEEPING.name().toLowerCase()});
        roomInfo.put(SLEEPING, info);

        info = new HashMap<>();
        info.put(ACTION_PART_BLINDS, DINING.name().toLowerCase() + "_" + KITCHEN.name().toLowerCase());
        info.put(ACTION_PART_CURTAINS, new String[]{});
        info.put(NUM_WINDOWS, NUM_WINDOWS_KITCHEN);
        info.put(ACTION_PARTS_LIGHT, new String[]{KITCHEN.name().toLowerCase() + KITCHEN_MAIN, KITCHEN.name().toLowerCase() + KITCHEN_COOKING});
        roomInfo.put(KITCHEN, info);

        msgHelperMap.put(LIGHT, new MessageHelper() {
            @Override
            public List<Message> getMessages(Room room, String... args) {
                List<Message> msgList = new ArrayList<>();
                String[] newArgs;
                String[] action_parts_light = (String[]) roomInfo.get(room).get(ACTION_PARTS_LIGHT);
                for (String part : action_parts_light) {
                    newArgs = new String[args.length + 1];
                    System.arraycopy(args, 0, newArgs, 1, args.length);
                    newArgs[0] = part;
                    msgList.add(MessageFactory.getInstance(LP_LIGHTCONTROL, TOPIC, LIGHT, newArgs));
                }
                return msgList;
            }
        });

        msgHelperMap.put(WINDOW, new MessageHelper() {
            @Override
            public List<Message> getMessages(Room room, String... args) {
                String[] windowIds = windowIds(room);
                List<Message> msgList = new ArrayList<>();
                for (String id : windowIds) {
                    String[] newArgs = new String[args.length + 1];
                    System.arraycopy(args, 0, newArgs, 1, args.length);
                    newArgs[0] = id;
                    msgList.add(MessageFactory.getInstance(LP_WINDOWCONTROL, TOPIC, WINDOW, newArgs));
                }
                return msgList;
            }
        });

        msgHelperMap.put(CURTAIN, new MessageHelper() {
            @Override
            public List<Message> getMessages(Room room, String... args) {
                String[] actionParts = (String[]) roomInfo.get(room).get(ACTION_PART_CURTAINS);
                List<Message> msgList = new ArrayList<>();
                for (String part : actionParts) {
                    String[] newArgs = new String[args.length + 1];
                    System.arraycopy(args, 0, newArgs, 1, args.length);
                    newArgs[0] = part;
                    msgList.add(MessageFactory.getInstance(LP_LIGHTCONTROL, TOPIC, CURTAIN, newArgs));
                }
                return msgList;
            }
        });

        msgHelperMap.put(BLIND, new MessageHelper() {
            @Override
            public List<Message> getMessages(Room room, String... args) {
                String blindPart = (String) roomInfo.get(room).get(ACTION_PART_BLINDS);

                String[] newArgs = new String[args.length + 1];
                System.arraycopy(args, 0, newArgs, 1, args.length);
                newArgs[0] = blindPart;
                return Arrays.asList(new Message[]{MessageFactory.getInstance(LP_BLINDCONTROL, TOPIC, BLIND, newArgs)});
            }
        });

    }

    private static String[] windowIds(Room room) {
        String prefix = WIN_PREFIX;
        String roomName = StringUtil.capitalize(room.name().toString());
        int numWindows = getNumWindows(room);
        String[] ids = new String[numWindows];
        for (int i = 0; i < numWindows; i++) {
            ids[i] = prefix + roomName + i;
        }
        return ids;
    }

    private static int getNumWindows(Room room) {
        return (Integer) roomInfo.get(room).get(NUM_WINDOWS);
    }

    public abstract List<Message> getMessages(Room room, String... args);

    public static MessageHelper getMessageHelper(Room room, Control control) {
        return msgHelperMap.get(control);
    }
}
