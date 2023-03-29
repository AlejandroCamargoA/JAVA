package ventanas;

import Clases.CCliente;
import Clases.CVendedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ListarVendedores extends JFrame {
    private JPanel panel;
    private JTable tablaFlores;
    private DefaultTableModel modeloTablaFlores;
    private JScrollPane despl;
    private JButton jbtnCerrar;
    public ListarVendedores(){
        setSize(650, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        inicializarComponentes();
        cargarEventos();
    }
    private void inicializarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);

        modeloTablaFlores = new DefaultTableModel();

        modeloTablaFlores.addColumn("id");
        modeloTablaFlores.addColumn("Nombres");
        modeloTablaFlores.addColumn("Apellidos");
        modeloTablaFlores.addColumn("Tipo de Documentos");
        modeloTablaFlores.addColumn("Numero de Documentos");
        modeloTablaFlores.addColumn("Correo");
        modeloTablaFlores.addColumn("Comision");
        modeloTablaFlores.addColumn("Estado");

        tablaFlores = new JTable(modeloTablaFlores);

        tablaFlores.setBounds(30, 50, 600, 350);
        panel.add(tablaFlores);

        despl = new JScrollPane(tablaFlores,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        despl.setBounds(30, 50, 580, 350);
        despl.setAutoscrolls(true);
        panel.add(despl);

        jbtnCerrar = new JButton("Cerrar");
        jbtnCerrar.setBounds(30,450, 120, 35);

        panel.add(jbtnCerrar);

        this.getContentPane().add(panel);

        final List<List<String>> datos = CVendedor.mostrarVendedores("");
        for (List<String> list : datos) {
            modeloTablaFlores.addRow(list.toArray());
        }
    }
    private void cargarEventos(){
        jbtnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CVendedor f = new CVendedor();
                crudVendedor cf = new crudVendedor(f);
                cf.setTitle("CRUD CLIENTES");
                cf.setVisible(true);
                dispose();
            }
        });

        tablaFlores.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int fila = tablaFlores.rowAtPoint(e.getPoint());

                CVendedor f = new CVendedor(
                        tablaFlores.getValueAt(fila,1).toString(),
                        tablaFlores.getValueAt(fila,2).toString(),
                        tablaFlores.getValueAt(fila,3).toString(),
                        tablaFlores.getValueAt(fila,4).toString(),
                        tablaFlores.getValueAt(fila,5).toString(),
                        Double.parseDouble(tablaFlores.getValueAt(fila,6).toString()),
                        tablaFlores.getValueAt(fila,7).toString()
                );
                f.setIdVendedor(Integer.parseInt(tablaFlores.getValueAt(fila,0).toString()));
                crudVendedor cf = new crudVendedor(f);
                cf.setVisible(true);
                cf.setTitle("CRUD VENDEDOR");
                dispose();
            }
        });

    }
}
