package ventanas;

import Clases.CCliente;
import Clases.CVendedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class crudVendedor extends JFrame {
    private CVendedor vendedor;
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

    private JButton jbtNuevo = new JButton();
    private JButton jbtGuardar = new JButton();
    private JButton jbtActualizar = new JButton();
    private JButton jbtLimpiar = new JButton();


    public crudVendedor(){
        setSize(650, 650);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        vendedor = new CVendedor();
        inicializarComponentes();
        cargarEventos();

    }
    public crudVendedor(CVendedor pVendedor){
        vendedor = pVendedor;
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
        jlbIdVendedor.setText(vendedor.getIdVendedor()+"");
        jlbIdVendedor.setBounds(30,30, 150,45);

        jlbNombres = new JLabel();
        jlbNombres.setText("Nombres");
        jlbNombres.setBounds(30,90, 150,45);

        jtfNombres = new JTextField();
        jtfNombres.setText(vendedor.getNombres()+"");
        jtfNombres.setBounds(180,90, 150,45);

        jlbApellidos = new JLabel();
        jlbApellidos.setText("Apellidos");
        jlbApellidos.setBounds(30,140, 150,45);

        jtfApellidos = new JTextField();
        jtfApellidos.setText(vendedor.getApellidos()+"");
        jtfApellidos.setBounds(180,140, 150,45);

        jlbTipoDocumento = new JLabel();
        jlbTipoDocumento.setText("Tipo de Documento");
        jlbTipoDocumento.setBounds(30,190, 150,45);

        jtfTipoDocumento = new JTextField();
        jtfTipoDocumento.setText(vendedor.getTipoDocumento()+"");
        jtfTipoDocumento.setBounds(180, 190, 150,45);

        jlbNumDocumento = new JLabel();
        jlbNumDocumento.setText("Numero de Documento");
        jlbNumDocumento.setBounds(30,240, 150,45);

        jtfNumDocumento = new JTextField();
        jtfNumDocumento.setText(vendedor.getNumDocumento()+"");
        jtfNumDocumento.setBounds(180,240, 150,45);

        jlbCorreo = new JLabel();
        jlbCorreo.setText("Correo");
        jlbCorreo.setBounds(30,290, 150,45);

        jtfCorreo = new JTextField();
        jtfCorreo.setText(vendedor.getCorreo()+"");
        jtfCorreo.setBounds(180,290, 150,45);

        jlbComision = new JLabel();
        jlbComision.setText("Comision");
        jlbComision.setBounds(30,340, 150,45);

        jtfComision = new JTextField();
        jtfComision.setText(vendedor.getComision()+"");
        jtfComision.setBounds(180,340, 150,45);

        jlbEstado = new JLabel();
        jlbEstado.setText("Estado");
        jlbEstado.setBounds(30,390, 150,45);

        jtfEstado = new JTextField();
        jtfEstado.setText(vendedor.getEstado()+"");
        jtfEstado.setBounds(180,390, 150,45);

        jbtNuevo.setText("Limpiar Registro");
        jbtNuevo.setBounds(350,90, 150,45);

        jbtGuardar.setText("Guardar");
        jbtGuardar.setBounds(50,440, 150,45);

        jbtActualizar.setText("Mostrar Lista");
        jbtActualizar.setBounds(230,440, 150,45);

        jbtLimpiar.setText("Eliminar");
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

        panel.add(jbtNuevo);
        panel.add(jbtGuardar);
        panel.add(jbtActualizar);
        panel.add(jbtLimpiar);

        this.getContentPane().add(panel);
    }

    public void cargarEventos(){
        jbtGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vendedor.getIdVendedor() == 0){
                    vendedor.setNombres(jtfNombres.getText());
                    vendedor.setApellidos(jtfApellidos.getText());
                    vendedor.setTipoDocumento(jtfTipoDocumento.getText());
                    vendedor.setNumDocumento(jtfNumDocumento.getText());
                    vendedor.setCorreo(jtfCorreo.getText());
                    vendedor.setComision(Double.parseDouble(jtfComision.getText()));
                    vendedor.setEstado(jtfEstado.getText());
                    vendedor.save();
                }else{
                    vendedor.setIdVendedor(Integer.parseInt(jlbIdVendedor.getText()));
                    vendedor.setNombres(jtfNombres.getText());
                    vendedor.setApellidos(jtfApellidos.getText());
                    vendedor.setTipoDocumento(jtfTipoDocumento.getText());
                    vendedor.setNumDocumento(jtfNumDocumento.getText());
                    vendedor.setCorreo(jtfCorreo.getText());
                    vendedor.setComision(Double.parseDouble(jtfComision.getText()));
                    vendedor.setEstado(jtfEstado.getText());
                    vendedor.update();
                }
            }
        });
        jbtActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarVendedores cf = new ListarVendedores();
                cf.setVisible(true);
                cf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                cf.setTitle("Tabla Vendedores");
                dispose();
            }
        });
        jbtLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendedor.setIdVendedor(Integer.parseInt(jlbIdVendedor.getText()));
                vendedor.setNombres(jtfNombres.getText());
                vendedor.setApellidos(jtfApellidos.getText());
                vendedor.setTipoDocumento(jtfTipoDocumento.getText());
                vendedor.setNumDocumento(jtfNumDocumento.getText());
                vendedor.setCorreo(jtfCorreo.getText());
                vendedor.setComision(Double.parseDouble(jtfComision.getText()));
                vendedor.setEstado(jtfEstado.getText());
                vendedor.eliminar();
            }
        });
        jbtNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbIdVendedor.setText("0");
                jtfNombres.setText("");
                jtfApellidos.setText("");
                jtfTipoDocumento.setText("");
                jtfNumDocumento.setText("");
                jtfCorreo.setText("");
                jtfComision.setText("");
                jtfEstado.setText("");
            }
        });
    }

}
