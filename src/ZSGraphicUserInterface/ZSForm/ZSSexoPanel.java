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

import ZSBusinessLogic.ZSSexoBL;
import ZSDataAccess.ZSDTO.ZSSexoDTO;

public class ZSSexoPanel extends JPanel {

    // Lógica de negocio
    private ZSSexoBL zsSexoBL = new ZSSexoBL();

    // Componentes de formulario
    private JTextField txtNombre;
    private JTextField txtDescripcion;

    // Tabla
    private JTable tblSexo;
    private DefaultTableModel tblModel;

    // Botones
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnEliminar;

    // Control interno
    private Integer idSeleccionado = null;

    public ZSSexoPanel() {
        zsInitComponent();
        zsLoadData();
    }

    private void zsInitComponent() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // ===== TÍTULO =====
        JLabel lblTitulo = new JLabel("Catálogo de Sexo", SwingConstants.CENTER);
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
        tblModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Descripción"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblSexo = new JTable(tblModel);
        tblSexo.getSelectionModel().addListSelectionListener(e -> zsLoadSelectedRow());

        JScrollPane scroll = new JScrollPane(tblSexo);
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
            tblModel.setRowCount(0);
            List<ZSSexoDTO> lista = zsSexoBL.zsGetAll();

            for (ZSSexoDTO s : lista) {
                tblModel.addRow(new Object[]{
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
        int fila = tblSexo.getSelectedRow();
        if (fila >= 0) {
            idSeleccionado = (Integer) tblModel.getValueAt(fila, 0);
            txtNombre.setText(tblModel.getValueAt(fila, 1).toString());
            txtDescripcion.setText(tblModel.getValueAt(fila, 2).toString());
        }
    }

    private void zsSave() {
        try {
            if (txtNombre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre es obligatorio");
                return;
            }

            ZSSexoDTO dto = new ZSSexoDTO();
            dto.setZSNombre(txtNombre.getText());
            dto.setZSDescripcion(txtDescripcion.getText());

            if (idSeleccionado == null) {
                zsSexoBL.zsAdd(dto);
            } else {
                dto.setZsIdCatalogo(idSeleccionado);
                zsSexoBL.zsUpdate(dto);
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
                zsSexoBL.zsDelete(idSeleccionado);
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
        tblSexo.clearSelection();
    }
}

