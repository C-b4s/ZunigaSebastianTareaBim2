package ZSGraphicUserInterface.ZSForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ZSLoginPanel extends JPanel {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnLimpiar;

    public ZSLoginPanel() {
        zsInitComponent();
    }

    private void zsInitComponent() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // ===== TÍTULO =====
        JLabel lblTitulo = new JLabel("INICIO DE SESIÓN", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setPreferredSize(new Dimension(600, 60));
        add(lblTitulo, BorderLayout.NORTH);

        // ===== PANEL CENTRAL =====
        JPanel pnlCenter = new JPanel(new GridLayout(2, 2, 15, 15));
        pnlCenter.setBorder(javax.swing.BorderFactory.createEmptyBorder(60, 180, 60, 180));
        pnlCenter.setBackground(Color.WHITE);

        pnlCenter.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        pnlCenter.add(txtUsuario);

        pnlCenter.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        pnlCenter.add(txtPassword);

        add(pnlCenter, BorderLayout.CENTER);

        // ===== BOTONES =====
        JPanel pnlButtons = new JPanel();
        pnlButtons.setPreferredSize(new Dimension(600, 70));
        pnlButtons.setBackground(Color.WHITE);

        btnLogin = new JButton("Ingresar");
        btnLimpiar = new JButton("Limpiar");

        pnlButtons.add(btnLogin);
        pnlButtons.add(btnLimpiar);

        add(pnlButtons, BorderLayout.SOUTH);

        zsInitActions();
    }

    private void zsInitActions() {

        btnLogin.addActionListener(e -> zsValidarLogin());

        btnLimpiar.addActionListener(e -> zsLimpiar());
    }

    private void zsValidarLogin() {

        String usuario = txtUsuario.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Debe ingresar usuario y contraseña",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        /*
         * Validación simulada (contexto académico)
         * Usuario: admin
         * Contraseña: 1234
         */
        if (usuario.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(
                this,
                "Inicio de sesión correcto",
                "Acceso permitido",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Usuario o contraseña incorrectos",
                "Acceso denegado",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void zsLimpiar() {
        txtUsuario.setText("");
        txtPassword.setText("");
        txtUsuario.requestFocus();
    }
}


