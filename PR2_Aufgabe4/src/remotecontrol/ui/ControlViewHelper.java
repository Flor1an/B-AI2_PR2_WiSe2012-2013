/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol.ui;

import remotecontrol.model.Control;
import remotecontrol.model.Position;

/**
 *
 * @author birgit
 */
public class ControlViewHelper {

    static ComponentGroup[] getComponentGroups(ComponentGroupCallback callback, Control control) {


        switch (control) {
            case LIGHT:
                return new ComponentGroup[]{
                            ComponentGroupHelper.getSliderViewGroup(callback, "Red", 0, 100),
                            ComponentGroupHelper.getSliderViewGroup(callback, "Green", 0, 100),
                            ComponentGroupHelper.getSliderViewGroup(callback, "Blue", 0, 100)
                        };
            case BLIND:
                return new ComponentGroup[]{
                        ComponentGroupHelper.getRadioViewGroup(callback, Position.values())
                        };
            case CURTAIN:
                return new ComponentGroup[]{
                            ComponentGroupHelper.getRadioViewGroup(callback, Position.values())
                        };
            case WINDOW:
                return new ComponentGroup[]{
                            ComponentGroupHelper.getSliderViewGroup(callback, "Öffnungswinkel", 0, 100)
                        };
            default:
                return new ComponentGroup[]{};
        }


    }
}
