package ZSGraphicUserInterface.ZSForm;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ZSGraphicUserInterface.ZSGUIStyle;

public class ZSMainForm extends JFrame {

    ZSMenuPanel zsPnlMenu = new ZSMenuPanel();
    JPanel zsPnlMain = new ZSMainPanel();

    public ZSMainForm(String titleApp) {
        zsCustomizeComponent(titleApp);

        zsPnlMenu.btnHome.addActionListener(e -> zsSetPanel(new ZSMainPanel()));
        zsPnlMenu.btnLogin.addActionListener(e -> zsSetPanel(new ZSLoginPanel()));
        zsPnlMenu.btnTipoPersona.addActionListener(e -> zsSetPanel(new ZSTipoPersonaPanel()));
        zsPnlMenu.btnSexo.addActionListener(e -> zsSetPanel(new ZSSexoPanel()));
        zsPnlMenu.btnEstadoCvil.addActionListener(e -> zsSetPanel(new ZSEstadoCivilPanel()));
        zsPnlMenu.btnEtnia.addActionListener(e -> zsSetPanel(new ZSEtniaPanel()));
        // agregar
        zsPnlMenu.btnTest.addActionListener(
            e -> {
                ZSGUIStyle.showMsgError("mensaje de error");
            }
        );
    }

    private void zsSetPanel(JPanel zsFormularioPanel) {
        Container zsContainer = getContentPane();
        zsContainer.remove(zsPnlMain);
        zsPnlMain = zsFormularioPanel;
        zsContainer.add(zsPnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    // JOptionPane.showMessageDialog(this, "Seleccionaste Opción 3");

    private void zsCustomizeComponent(String titleApp) {
        setTitle(titleApp);
        setSize(930,800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container zsContainer = getContentPane();
        zsContainer.setLayout(new BorderLayout());

        zsContainer.add(zsPnlMenu, BorderLayout.WEST);
        zsContainer.add(zsPnlMain,BorderLayout.CENTER);
        setVisible(true);
    }
}