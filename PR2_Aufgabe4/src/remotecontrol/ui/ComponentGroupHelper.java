/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotecontrol.ui;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import remotecontrol.model.Position;

/**
 *
 * @author birgit
 */
public class ComponentGroupHelper {

    public static ComponentGroup getSliderViewGroup(final ComponentGroupCallback callback, final String label, final int min, final int max) {

        return new ComponentGroup() {
            JLabel myLabel = new JLabel();
            JSlider mySlider = new JSlider();
            JTextField myText = new JTextField(min + "", 2);

            @Override
            public Component[] getComponents() {

                myLabel.setText(label);

                mySlider.setMinimum(min);
                mySlider.setMaximum(max);
                mySlider.setValue(min);
                
                mySlider.addMouseListener(new MouseAdapter(){
                    public void mouseReleased(MouseEvent evt) {
                        myText.setText(mySlider.getValue() + "");
                        callback.valueChanged();
			}
                
                });


                return new Component[]{myLabel, mySlider, myText};
            }

            @Override
            public Object getValue() {
                return mySlider.getValue();
            }
        };

    }

    public static ComponentGroup getRadioViewGroup(final ComponentGroupCallback callback, final Position[] labels) {

        return new ComponentGroup() {
            JRadioButton[] ret = new JRadioButton[labels.length];
            JPanel myPanel = new JPanel();
            ButtonGroup myGroup = new ButtonGroup();

            @Override
            public Component[] getComponents() {

                int i = 0;
                for (Position pos : labels) {
                    final JRadioButton myRadio = new JRadioButton();
                    myRadio.setText(pos.toString());
                    
                    myRadio.addItemListener(new ItemListener(){
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            if(myRadio.isSelected()){
                                callback.valueChanged();
                            }
                        }
                    });
                    
                    
                    myGroup.add(myRadio);
                    myPanel.add(myRadio);
                    ret[i] = myRadio;
                    i++;
                }

                //return new Component[]{myGroup};
                return ret;
            }

            @Override
            public Object getValue(){ 
                Position toRet = null;
                
                
                
                for (JRadioButton com : ret) {
                    if (com.isSelected()) {
                        for (Position p : Position.values()) {
                            if (p.toString() == com.getText().toString()) {
                                //System.out.println(p);
                                toRet = p;
                            }
                        }
                    }
                }
                return Position.CLOSE;// toRet;
            }
        };
    }
}
