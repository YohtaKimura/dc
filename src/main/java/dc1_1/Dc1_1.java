package dc1_1;

import java.awt.*;
import java.time.LocalDateTime;

public final class Dc1_1 {
    public static void main(String[] args) {
        final Frame frame = new Frame("Clock");
        final Label displayBox = new Label();
        displayBox.setBounds(100,35, 180,30);
        frame.add(displayBox);
        frame.setSize(400,100);
        frame.setLayout(null);
        frame.setVisible(true);
        while (true) {
            displayBox.setText(LocalDateTime.now().toString());
        }
    }
}
