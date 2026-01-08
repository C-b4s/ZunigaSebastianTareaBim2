package ZSGraphicUserInterface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ZSGUIStyle {

    /* =========================
     * COLORES DEL SISTEMA
     * ========================= */
    public static final Color COLOR_FONDO_PRINCIPAL = Color.WHITE;
    public static final Color COLOR_MENU = new Color(45, 45, 45);
    public static final Color COLOR_BOTON = new Color(70, 70, 70);
    public static final Color COLOR_TEXTO_MENU = Color.WHITE;
    public static final Color COLOR_TITULO = Color.DARK_GRAY;

    /* =========================
     * FUENTES
     * ========================= */
    public static final Font FONT_TITULO = new Font("Arial", Font.BOLD, 22);
    public static final Font FONT_MENU = new Font("Arial", Font.PLAIN, 14);
    public static final Font FONT_NORMAL = new Font("Arial", Font.PLAIN, 13);

    /* =========================
     * MÉTODOS DE ESTILO
     * ========================= */

    public static void setTitleStyle(JLabel label) {
        label.setFont(FONT_TITULO);
        label.setForeground(COLOR_TITULO);
    }

    public static void setMenuLabelStyle(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(COLOR_TEXTO_MENU);
    }

    public static void setMenuButtonStyle(JButton button) {
        button.setFont(FONT_MENU);
        button.setBackground(COLOR_BOTON);
        button.setForeground(COLOR_TEXTO_MENU);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }

    public static void setFormTextFieldStyle(JTextField textField) {
        textField.setFont(FONT_NORMAL);
    }

    public static void setFormPasswordFieldStyle(JPasswordField passwordField) {
        passwordField.setFont(FONT_NORMAL);
    }

    public static void setPanelPadding(JPanel panel, int top, int left, int bottom, int right) {
        panel.setBorder(new EmptyBorder(top, left, bottom, right));
    }

    /* =========================
     * MENSAJES AL USUARIO
     * ========================= */

    public static void showMsgInfo(String msg) {
        JOptionPane.showMessageDialog(
                null,
                msg,
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void showMsgWarning(String msg) {
        JOptionPane.showMessageDialog(
                null,
                msg,
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void showMsgError(String msg) {
        JOptionPane.showMessageDialog(
                null,
                msg,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static boolean showConfirm(String msg) {
        int option = JOptionPane.showConfirmDialog(
                null,
                msg,
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );
        return option == JOptionPane.YES_OPTION;
    }
}

