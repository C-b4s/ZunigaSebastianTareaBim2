package ZSGraphicUserInterface;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class ZSIAStyle {
    public static final Color ZSCOLOR_FONT = new Color(200, 100, 50); // (218, 8, 40)
    public static final Color ZSCOLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color ZSCOLOR_CURSOR = Color.black;
    public static final Color ZSCOLOR_BORDER = Color.LIGHT_GRAY;

    public static final Font ZSFONT =
            new Font("JetBrains Mono", Font.PLAIN, 14);
    public static final Font ZSFONT_BOLD =
            new Font("JetBrains Mono", Font.BOLD | Font.PLAIN, 14);
    public static final Font ZSFONT_SMALL =
            new Font("JetBrains Mono", Font.PLAIN | Font.PLAIN, 10);

    public static final int ZSALIGNMENT_LEFT   = SwingConstants.LEFT;
    public static final int ZSALIGNMENT_RIGHT  = SwingConstants.RIGHT;
    public static final int ZSALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor ZSCURSOR_HAND =
            new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor ZSCURSOR_DEFAULT =
            new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL ZSURL_MAIN =
            ZSIAStyle.class.getResource("/ZSGraphicUserInterface/ZSResource/ZSImg/ZSIABot.png");
    public static final URL ZSURL_LOGO =
            ZSIAStyle.class.getResource("/ZSGraphicUserInterface/ZSResource/ZSImg/ZSLogo.png");
    public static final URL ZSURL_SPLASH =
            ZSIAStyle.class.getResource("/ZSGraphicUserInterface/ZSResource/ZSImg/ZSSplash.png");
    public static final CompoundBorder createBorderRect() {
        return BorderFactory.createCompoundBorder(
                new LineBorder(Color.LIGHT_GRAY),
                new EmptyBorder(5, 5, 5, 5));
    }
}
