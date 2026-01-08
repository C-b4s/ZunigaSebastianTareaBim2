package ZSGraphicUserInterface.ZSForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ZSMenuPanel extends JPanel {

    // Botones públicos para ser accedidos desde ZSMainForm
    public JButton btnHome;
    public JButton btnLogin;
    public JButton btnTipoPersona;
    public JButton btnSexo;
    public JButton btnEstadoCvil;
    public JButton btnEtnia;
    public JButton btnTest;

    private JLabel lblTitle;
    private JLabel lblFooter;

    public ZSMenuPanel() {
        zsCustomizeComponent();
    }

    private void zsCustomizeComponent() {

        // Configuración general del menú
        setLayout(new GridLayout(9, 1, 0, 8));
        setPreferredSize(new Dimension(220, 800));
        setBackground(new Color(45, 45, 45));

        // Título del menú
        lblTitle = new JLabel("EXOBOT", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);

        // Inicialización de botones
        btnHome         = zsCreateButton("Home");
        btnLogin        = zsCreateButton("Login");
        btnTipoPersona  = zsCreateButton("Tipo Persona");
        btnSexo         = zsCreateButton("Sexo");
        btnEstadoCvil   = zsCreateButton("Estado Civil");
        btnEtnia        = zsCreateButton("Etnia");
        btnTest         = zsCreateButton("Test");

        // Footer
        lblFooter = new JLabel("© 2024 Exobot", SwingConstants.CENTER);
        lblFooter.setFont(new Font("Arial", Font.PLAIN, 11));
        lblFooter.setForeground(Color.LIGHT_GRAY);

        // Agregar componentes al menú
        add(lblTitle);
        add(btnHome);
        add(btnLogin);
        add(btnTipoPersona);
        add(btnSexo);
        add(btnEstadoCvil);
        add(btnEtnia);
        add(btnTest);
        add(lblFooter);
    }

    private JButton zsCreateButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(70, 70, 70));
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        return button;
    }
}
