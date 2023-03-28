package ventanas;

import Clases.CVendedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class crudVendedor extends JFrame {

    private JPanel panel;
    private JLabel jlbIdVendedor;
    private JTextField jtfNombres;
    private JTextField jtfApellidos;
    private JTextField jtfTipoDocumento;
    private JTextField jtfNumDocumento;
    private JTextField jtfCorreo;
    private JTextField jtfComision;
    private JTextField jtfEstado;

    private JLabel jlbNombres;
    private JLabel jlbApellidos;
    private JLabel jlbTipoDocumento;
    private JLabel jlbNumDocumento;
    private JLabel jlbCorreo;
    private JLabel jlbComision;
    private JLabel jlbEstado;

    private JButton jbtGuardar = new JButton();
    private JButton jbtActualizar = new JButton();
    private JButton jbtLimpiar = new JButton();


    public crudVendedor(){
        setSize(650, 650);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        inicializarComponentes();
        cargarEventos();

    }

    public void inicializarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);

        jlbIdVendedor = new JLabel();
        jlbIdVendedor.setText("...");
        jlbIdVendedor.setBounds(30,30, 150,45);

        jlbNombres = new JLabel();
        jlbNombres.setText("Nombres");
        jlbNombres.setBounds(30,90, 150,45);

        jtfNombres = new JTextField();
        jtfNombres.setText("Nombres");
        jtfNombres.setBounds(180,90, 150,45);

        jlbApellidos = new JLabel();
        jlbApellidos.setText("Apellidos");
        jlbApellidos.setBounds(30,140, 150,45);

        jtfApellidos = new JTextField();
        jtfApellidos.setText("Apellidos");
        jtfApellidos.setBounds(180,140, 150,45);

        jlbTipoDocumento = new JLabel();
        jlbTipoDocumento.setText("Tipo de Documento");
        jlbTipoDocumento.setBounds(30,190, 150,45);

        jtfTipoDocumento = new JTextField();
        jtfTipoDocumento.setText("Tipo de Documento");
        jtfTipoDocumento.setBounds(180, 190, 150,45);

        jlbNumDocumento = new JLabel();
        jlbNumDocumento.setText("Numero de Documento");
        jlbNumDocumento.setBounds(30,240, 150,45);

        jtfNumDocumento = new JTextField();
        jtfNumDocumento.setText("Numero de Documento");
        jtfNumDocumento.setBounds(180,240, 150,45);

        jlbCorreo = new JLabel();
        jlbCorreo.setText("Correo");
        jlbCorreo.setBounds(30,290, 150,45);

        jtfCorreo = new JTextField();
        jtfCorreo.setText("Correo");
        jtfCorreo.setBounds(180,290, 150,45);

        jlbComision = new JLabel();
        jlbComision.setText("Comision");
        jlbComision.setBounds(30,340, 150,45);

        jtfComision = new JTextField();
        jtfComision.setText("Comision");
        jtfComision.setBounds(180,340, 150,45);

        jlbEstado = new JLabel();
        jlbEstado.setText("Estado");
        jlbEstado.setBounds(30,390, 150,45);

        jtfEstado = new JTextField();
        jtfEstado.setText("Estado");
        jtfEstado.setBounds(180,390, 150,45);

        jbtGuardar.setText("Guardar");
        jbtGuardar.setBounds(50,440, 150,45);

        jbtActualizar.setText("Actualizar");
        jbtActualizar.setBounds(230,440, 150,45);

        jbtLimpiar.setText("limpiar");
        jbtLimpiar.setBounds(400,440, 150,45);

        panel.add(jlbIdVendedor);
        panel.add(jtfNombres);
        panel.add(jtfApellidos);
        panel.add(jtfTipoDocumento);
        panel.add(jtfNumDocumento);
        panel.add(jtfCorreo);
        panel.add(jtfComision);
        panel.add(jtfEstado);
        panel.add(jlbNombres);
        panel.add(jlbApellidos);
        panel.add(jlbTipoDocumento);
        panel.add(jlbNumDocumento);
        panel.add(jlbCorreo);
        panel.add(jlbComision);
        panel.add(jlbEstado);

        panel.add(jbtGuardar);
        panel.add(jbtActualizar);
        panel.add(jbtLimpiar);

        this.getContentPane().add(panel);
    }

    public void cargarEventos(){
        jbtGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CVendedor v = new CVendedor();
                v.setNombres(jtfNombres.getText());
                v.setApellidos(jtfApellidos.getText());
                v.setCorreo(jtfCorreo.getText());
                v.setComision(Integer.parseInt(jtfComision.getText()));
                v.setEstado(jtfEstado.getText());
                v.save();
            }
        });
    }

}
