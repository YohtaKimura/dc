package dc1_3;

import java.awt.event.ActionEvent;

public class ChangeBackgroundColorActionListener extends
        ChangeFontColorActionListener {


    public ChangeBackgroundColorActionListener(DigitalClockCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvas.setBackground(findColorByName(e.getActionCommand()));
    }

}
