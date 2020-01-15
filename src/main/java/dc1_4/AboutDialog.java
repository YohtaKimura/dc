package dc1_4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AboutDialog extends Dialog implements ActionListener {
    AboutDialog(Frame owner) {
        super(owner);
        setLayout(new BorderLayout());

        Label aboutLabel = new Label("Digital Clock");
        aboutLabel.setAlignment(Label.CENTER);
        aboutLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        add(aboutLabel, BorderLayout.NORTH);

        Button okButton = new Button("OK");
        okButton.addActionListener(this);
        add(okButton, BorderLayout.SOUTH);

        setTitle("About");
        pack();
        setLocationRelativeTo(null);
        addWindowListener(new DialogCloseAdapter(this));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
