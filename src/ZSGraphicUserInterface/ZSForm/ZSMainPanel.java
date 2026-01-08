package ZSGraphicUserInterface.ZSForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ZSMainPanel extends JPanel {

    private JPanel pnlHeader;
    private JPanel pnlContent;
    private JLabel lblTitle;
    private JLabel lblImage;

    public ZSMainPanel() {
        zsCustomizeComponent();
    }

    private void zsCustomizeComponent() {
        // Configuración general del panel principal
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Panel superior (título o encabezado)
        pnlHeader = new JPanel();
        pnlHeader.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlHeader.setPreferredSize(new Dimension(600, 80));
        pnlHeader.setBackground(new Color(240, 240, 240));

        lblTitle = new JLabel("EXOBOT");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitle.setForeground(Color.DARK_GRAY);

        pnlHeader.add(lblTitle);

        // Panel central (contenido principal)
        pnlContent = new JPanel();
        pnlContent.setLayout(new BorderLayout());
        pnlContent.setBackground(Color.WHITE);

        // Imagen representativa (pantalla Home)
        lblImage = new JLabel();
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblImage.setVerticalAlignment(SwingConstants.CENTER);

        /*
         * Nota:
         * La imagen debe ubicarse dentro del proyecto, por ejemplo:
         * /resources/img/exobot.png
         * Ajusta la ruta según tu estructura real.
         */
        lblImage.setIcon(new ImageIcon("ZSResource/ZSImg/ZSLogo.png"));

        pnlContent.add(lblImage, BorderLayout.CENTER);

        // Agregar paneles al panel principal
        add(pnlHeader, BorderLayout.NORTH);
        add(pnlContent, BorderLayout.CENTER);
    }
}
