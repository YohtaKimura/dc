package dc1_3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.util.Calendar;

@SuppressWarnings("serial")
class DigitalClockCanvas extends Canvas implements Runnable {

    private static final int REFRESH_INTERVAL = 20;
    private static final int BUFFER_SIZE = 2; // Double buffering
    private static final int CLOCK_BASELINE = 15;
    private static final int MARGIN_LEFT = 20;
    private static final int MARGIN_RIGHT = 10;
    private Font labelFont = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
    private Font clockFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
    private Dimension dimension = new Dimension(370, 80);
    private BufferStrategy bufferStrategy;

    public DigitalClockCanvas(String title) {
        setForeground(new Color(0, 255, 0));
        setBackground(new Color(50, 50, 50));
        new DigitalClockWindow(title, this);
        createBufferStrategy(BUFFER_SIZE);
        bufferStrategy = getBufferStrategy();
        new Thread(this).start();
    }

    private void draw() {
        Graphics graphics = bufferStrategy.getDrawGraphics();
        if (!bufferStrategy.contentsLost()) {
            graphics.clearRect(0, 0, getSize().width, getSize().height);
            ((Graphics2D) graphics).setRenderingHint(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            graphics = updateClock(graphics);
            bufferStrategy.show();
            graphics.dispose();
        }
    }

    private Graphics updateClock(Graphics graphics) {
        graphics.setFont(labelFont);
        graphics.drawString("現在時刻", MARGIN_LEFT, CLOCK_BASELINE);
        graphics.setFont(clockFont);
        graphics.drawString(getTime(), MARGIN_LEFT, CLOCK_BASELINE + clockFont.getSize());
        return graphics;
    }

    Font getClockFont() {
        return clockFont;
    }

    void setClockFont(Font font) {
        clockFont = font;
        // Simulate preferred size
        Label tempLabel = new Label(getTime());
        tempLabel.setFont(font);
        Frame frame = new Frame();
        frame.add(tempLabel);
        frame.pack();
        dimension = frame.getPreferredSize();
        dimension.height += 1;
        dimension.width += MARGIN_LEFT + MARGIN_RIGHT; // add margin
        draw();
    }

    @Override
    public Dimension getPreferredSize() {
        return dimension;
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public void run() {
        while (true) {
            // repaint();
            draw();
            try {
                Thread.sleep(REFRESH_INTERVAL); // Update in 10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getTime() {
        Calendar now = Calendar.getInstance();
        int h = now.get(Calendar.HOUR_OF_DAY);
        int m = now.get(Calendar.MINUTE);
        int s = now.get(Calendar.SECOND);
        int ms = now.get(Calendar.MILLISECOND);
        return String.format("%02d:%02d:%02d:%03d", h, m, s, ms);
    }
}
