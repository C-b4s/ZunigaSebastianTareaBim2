package ZSGraphicUserInterface.ZSForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import ZSBusinessLogic.ZSEstadoCivilBL;
import ZSDataAccess.ZSDTO.ZSEstadoCivilDTO;

public class ZSEstadoCivilPanel extends JPanel{
    // Lógica de negocio
    private ZSEstadoCivilBL zsEstadoCivilBL = new ZSEstadoCivilBL();

    // Componentes de formulario
    private JTextField txtNombre;
    private JTextField txtDescripcion;

    // Tabla
    private JTable zsTblEtnia;
    private DefaultTableModel zsTblModel;

    // Botones
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnEliminar;

    // Control interno
    private Integer idSeleccionado = null;

    public ZSEstadoCivilPanel() {
        zsInitComponent();
        zsLoadData();
    }

    private void zsInitComponent() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // ===== TÍTULO =====
        JLabel lblTitulo = new JLabel("Catálogo de Etnia", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setPreferredSize(new Dimension(600, 60));
        add(lblTitulo, BorderLayout.NORTH);

        // ===== PANEL CENTRAL =====
        JPanel pnlCenter = new JPanel(new BorderLayout());
        pnlCenter.setBackground(Color.WHITE);

        // ===== FORMULARIO =====
        JPanel pnlForm = new JPanel(new GridLayout(2, 2, 10, 10));
        pnlForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 40, 20, 40));

        pnlForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        pnlForm.add(txtNombre);

        pnlForm.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        pnlForm.add(txtDescripcion);

        pnlCenter.add(pnlForm, BorderLayout.NORTH);

        // ===== TABLA =====
        zsTblModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Descripción"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        zsTblEtnia = new JTable(zsTblModel);
        zsTblEtnia.getSelectionModel().addListSelectionListener(e -> zsLoadSelectedRow());

        JScrollPane scroll = new JScrollPane(zsTblEtnia);
        pnlCenter.add(scroll, BorderLayout.CENTER);

        add(pnlCenter, BorderLayout.CENTER);

        // ===== BOTONES =====
        JPanel pnlButtons = new JPanel();
        pnlButtons.setPreferredSize(new Dimension(600, 70));

        btnNuevo = new JButton("Nuevo");
        btnGuardar = new JButton("Guardar");
        btnEliminar = new JButton("Eliminar");

        pnlButtons.add(btnNuevo);
        pnlButtons.add(btnGuardar);
        pnlButtons.add(btnEliminar);

        add(pnlButtons, BorderLayout.SOUTH);

        zsInitActions();
    }

    private void zsInitActions() {

        btnNuevo.addActionListener(e -> zsClearForm());

        btnGuardar.addActionListener(e -> zsSave());

        btnEliminar.addActionListener(e -> zsDelete());
    }

    private void zsLoadData() {
        try {
            zsTblModel.setRowCount(0);
            List<ZSEstadoCivilDTO> lista = zsEstadoCivilBL.zsGetAll();

            for (ZSEstadoCivilDTO s : lista) {
                zsTblModel.addRow(new Object[]{
                    s.getZSIdCatalogo(),
                    s.getZSNombre(),
                    s.getZSDescripcion()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void zsLoadSelectedRow() {
        int fila = zsTblEtnia.getSelectedRow();
        if (fila >= 0) {
            idSeleccionado = (Integer) zsTblModel.getValueAt(fila, 0);
            txtNombre.setText(zsTblModel.getValueAt(fila, 1).toString());
            txtDescripcion.setText(zsTblModel.getValueAt(fila, 2).toString());
        }
    }

    private void zsSave() {
        try {
            if (txtNombre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio");
                return;
            }

            ZSEstadoCivilDTO dto = new ZSEstadoCivilDTO();
            dto.setZSNombre(txtNombre.getText());
            dto.setZSDescripcion(txtDescripcion.getText());

            if (idSeleccionado == null) {
                zsEstadoCivilBL.zsAdd(dto);
            } else {
                dto.setZsIdCatalogo(idSeleccionado);
                zsEstadoCivilBL.zsUpdate(dto);
            }

            zsLoadData();
            zsClearForm();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void zsDelete() {
        try {
            if (idSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un registro");
                return;
            }

            int op = JOptionPane.showConfirmDialog(
                    this,
                    "¿Desea eliminar el registro seleccionado?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION
            );

            if (op == JOptionPane.YES_OPTION) {
                zsEstadoCivilBL.zsDelete(idSeleccionado);
                zsLoadData();
                zsClearForm();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void zsClearForm() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        idSeleccionado = null;
        zsTblEtnia.clearSelection();
    }
}
