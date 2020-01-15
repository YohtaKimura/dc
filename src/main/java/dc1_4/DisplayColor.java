package dc1_4;

import java.awt.Color;

/** List of colors. */
public enum DisplayColor {
    /* @formatter:off */
    BLACK(new Color(0, 0, 0)),
    SILVER(new Color(192, 192, 192)),
    GRAY(new Color(128, 128, 128)),
    WHITE(new Color(255, 255, 255)),
    MAROON(new Color(128, 0, 0)),
    RED(new Color(255, 0, 0)),
    PURPLE(new Color(128, 0, 128)),
    FUCHSIA(new Color(255, 0, 255)),
    GREEN(new Color(0, 128, 0)),
    LIME(new Color(0, 255, 0)),
    OLIVE(new Color(128, 128, 0)),
    YELLOW(new Color(255, 255, 0)),
    NAVY(new Color(0, 0, 128)),
    BLUE(new Color(0, 0, 255)),
    TEAL(new Color(0, 128, 128)),
    AQUA(new Color(0, 255, 255)),
    DARKGRAY(new Color(50, 50, 50));
    /* @formatter:on */

    private final Color color;

    DisplayColor(Color color) {
        this.color = color;
    }

    /** Get name of color with lower case. e.g. "red", "green", and "blue". */
    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public Color getValue() {
        return color;
    }

    public static DisplayColor nameOf(String color) {
        for (DisplayColor c : values()) {
            String name = c.toString();
            if (name.equals(color) || name.toLowerCase().equals(color))
                return c;
        }
        throw new IllegalArgumentException("Undefined color: " + color);
    }

    public static DisplayColor valueOf(Color color) {
        if (color == null)
            throw new NullPointerException();
        for (DisplayColor c : values()) {
            if (c.getValue().equals(color))
                return c;
        }
        throw new IllegalArgumentException("Undefined color: " + color);
    }
}
