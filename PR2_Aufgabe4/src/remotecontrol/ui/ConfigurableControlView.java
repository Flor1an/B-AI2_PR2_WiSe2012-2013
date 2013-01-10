/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol.ui;

import java.awt.Component;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import remotecontrol.Constants;
import remotecontrol.message.MagicPublisher;
import remotecontrol.message.MessageHelper;
import remotecontrol.model.Control;
import remotecontrol.model.Room;
import remotecontrol.model.Position;

/**
 *
 * @author birgit
 */
public abstract class ConfigurableControlView extends JPanel implements ComponentGroupCallback {

    private static final int HORIZONTAL_GAP = 30;
    private static final int VERTICAL_GAP = 10;
    protected Room context;
    protected ComponentGroup[] groups;
    private static final Map<Control, Class<? extends ConfigurableControlView>> map = new HashMap<>();

    static {
        map.put(Control.LIGHT, ConfigurableLightView.class);
        map.put(Control.CURTAIN, ConfigurableCurtainView.class);
        map.put(Control.WINDOW, ConfigurableWindowView.class);
        map.put(Control.BLIND, ConfigurableBlindView.class);
    }

    public static ConfigurableControlView createInstance(Control control, Room room) throws InstantiationException, IllegalAccessException {
        ConfigurableControlView ccp = map.get(control).newInstance();
        ccp.setContext(room);
        return ccp;
    }

    public ConfigurableControlView(Control control) {
        this(false, control);

    }

    public ConfigurableControlView(boolean isDoubleBuffered, Control control) {
        super(isDoubleBuffered);
        addComponents(control);
    }

    protected void setContext(Room room) {
        this.context = room;
    }

    private void addComponents(Control control) {

        this.groups = ControlViewHelper.getComponentGroups(this, control);

        if (groups.length == 0) {
            return;
        }

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        Component[][] c = new Component[groups.length][groups[0].getComponents().length];
        for (int i = 0; i < groups.length; i++) {
            System.arraycopy(groups[i].getComponents(), 0, c[i], 0, groups[i].getComponents().length);
        }

        GroupLayout.SequentialGroup gsg = layout.createSequentialGroup().addGap(HORIZONTAL_GAP, HORIZONTAL_GAP, HORIZONTAL_GAP);

        for (int horz = 0; horz < c[0].length; horz++) {
            GroupLayout.ParallelGroup gpgIn = layout.createParallelGroup().addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP);
            int maxHorSize = 0;
            for (int vert = 0; vert < c.length; vert++) {
                maxHorSize = (int) Math.max(maxHorSize, c[vert][horz].getPreferredSize().getWidth());
            }
            for (int vert = 0; vert < c.length; vert++) {
                gpgIn.addComponent(c[vert][horz], GroupLayout.PREFERRED_SIZE, maxHorSize, Short.MAX_VALUE);
            }
            gsg.addGroup(gpgIn);
            gsg.addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP);
        }
        layout.setHorizontalGroup(gsg);
        gsg.addGap(HORIZONTAL_GAP, HORIZONTAL_GAP, HORIZONTAL_GAP);

        GroupLayout.SequentialGroup gsgVert = layout.createSequentialGroup().addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP);
        for (int vert = 0; vert < c.length; vert++) {
            GroupLayout.ParallelGroup gpgVert = layout.createParallelGroup().addGap(HORIZONTAL_GAP, HORIZONTAL_GAP, HORIZONTAL_GAP);
            int maxVertSize = 0;
            for (int horz = 0; horz < c[0].length; horz++) {
                maxVertSize = (int) Math.max(maxVertSize, c[vert][horz].getPreferredSize().getHeight());
            }
            for (int horz = 0; horz < c[0].length; horz++) {
                gpgVert.addComponent(c[vert][horz], GroupLayout.PREFERRED_SIZE, maxVertSize, maxVertSize);
            }
            gsgVert.addGroup(gpgVert);
        }
        gsgVert.addGap(VERTICAL_GAP, VERTICAL_GAP, VERTICAL_GAP);
        layout.setVerticalGroup(gsgVert);
    }

    @Override
    public abstract void valueChanged();

    public static class ConfigurableLightView extends ConfigurableControlView {

        public ConfigurableLightView() {
            this(false);
        }

        public ConfigurableLightView(boolean isDoubleBuffered) {
            super(isDoubleBuffered, Control.LIGHT);
        }

        @Override
        public void valueChanged() {

            int i = 0;
            String[] vals = new String[this.groups.length];
            ComponentGroup[] cg = this.groups;
            for (ComponentGroup comgro : cg) {
                vals[i] = comgro.getValue().toString();
                i++;
            }

            MessageHelper mh = MessageHelper.getMessageHelper(this.context, Control.LIGHT);

            // mh.getMessages(this.context, vals)
            MagicPublisher.publish(Constants.LP_LIGHTCONTROL, mh.getMessages(this.context, vals));

        }
    }

    public static class ConfigurableWindowView extends ConfigurableControlView {

        public ConfigurableWindowView() {
            this(false);
        }

        public ConfigurableWindowView(boolean isDoubleBuffered) {
            super(isDoubleBuffered, Control.WINDOW);
        }

        @Override
        public void valueChanged() {


            int i = 0;
            String[] vals = new String[this.groups.length];
            ComponentGroup[] cg = this.groups;
            for (ComponentGroup comgro : cg) {

                vals[i] = comgro.getValue().toString();
                i++;
            }



            MessageHelper mh = MessageHelper.getMessageHelper(this.context, Control.WINDOW);
            // mh.getMessages(this.context, vals)
            MagicPublisher.publish(Constants.LP_WINDOWCONTROL, mh.getMessages(this.context, vals));
        }
    }

    public static class ConfigurableCurtainView extends ConfigurableControlView {

        public ConfigurableCurtainView() {
            this(false);
        }

        public ConfigurableCurtainView(boolean isDoubleBuffered) {
            super(isDoubleBuffered, Control.CURTAIN);
        }

        @Override
        public void valueChanged() {






            int i = 0;
            String[] vals = new String[this.groups.length];
            ComponentGroup[] cg = this.groups;
            for (ComponentGroup comgro : cg) {


                vals[i] = ((Position)comgro.getValue()).name().toLowerCase();
                i++;
            }

            MessageHelper mh = MessageHelper.getMessageHelper(this.context, Control.CURTAIN);

            // mh.getMessages(this.context, vals)
            MagicPublisher.publish(Constants.LP_CURTAINCONTROL, mh.getMessages(this.context, vals));
        }
    }

    public static class ConfigurableBlindView extends ConfigurableControlView {

        public ConfigurableBlindView() {
            this(false);
        }

        public ConfigurableBlindView(boolean isDoubleBuffered) {
            super(isDoubleBuffered, Control.BLIND);
        }

        @Override
        public void valueChanged() {

            int i = 0;
            String[] vals = new String[this.groups.length];
            ComponentGroup[] cg = this.groups;
            for (ComponentGroup comgro : cg) {
                vals[i] = ((Position)comgro.getValue()).name().toLowerCase();//.toString();
                i++;
            }

            MessageHelper mh = MessageHelper.getMessageHelper(this.context, Control.BLIND);
            MagicPublisher.publish(Constants.LP_BLINDCONTROL, mh.getMessages(this.context, vals));
        }
    }
}
