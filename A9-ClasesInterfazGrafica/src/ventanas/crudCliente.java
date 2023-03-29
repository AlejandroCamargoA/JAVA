package ventanas;

import Clases.CCliente;
import Clases.CFlor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class crudCliente extends JFrame {
    private CCliente cliente;
    private JPanel panel;
    private JLabel jlbIdCliente;
    private JTextField jtfNombres;
    private JTextField jtfApellidos;
    private JTextField jtfTipoDocumento;
    private JTextField jtfNumDocumento;
    private JTextField jtfCorreo;
    private JTextField jtfTipo;
    private JTextField jtfEstado;

    private JLabel jlbNombres;
    private JLabel jlbApellidos;
    private JLabel jlbTipoDocumento;
    private JLabel jlbNumDocumento;
    private JLabel jlbCorreo;
    private JLabel jlbTipo;
    private JLabel jlbEstado;

    private JButton jbtGuardar = new JButton();
    private JButton jbtActualizar = new JButton();
    private JButton jbtLimpiar = new JButton();
    private JButton jbtNuevo = new JButton();

    public crudCliente(){
        setSize(650, 650);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        cliente = new CCliente();
        inicializarComponentes();
        cargarEventos();
    }

    public crudCliente(CCliente pCliente){
        cliente = pCliente;
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


        jlbIdCliente = new JLabel();
        jlbIdCliente.setText(cliente.getIdCliente()+"");
        jlbIdCliente.setBounds(30,30, 150,45);

        jlbNombres = new JLabel();
        jlbNombres.setText("Nombres");
        jlbNombres.setBounds(30,90, 150,45);

        jtfNombres = new JTextField();
        jtfNombres.setText(cliente.getNombres()+"");
        jtfNombres.setBounds(180,90, 150,45);

        jlbApellidos = new JLabel();
        jlbApellidos.setText("Apellidos");
        jlbApellidos.setBounds(30,140, 150,45);

        jtfApellidos = new JTextField();
        jtfApellidos.setText(cliente.getApellidos()+"");
        jtfApellidos.setBounds(180,140, 150,45);

        jlbTipoDocumento = new JLabel();
        jlbTipoDocumento.setText("Tipo de Documento");
        jlbTipoDocumento.setBounds(30,190, 150,45);

        jtfTipoDocumento = new JTextField();
        jtfTipoDocumento.setText(cliente.getTipoDocumento()+"");
        jtfTipoDocumento.setBounds(180, 190, 150,45);

        jlbNumDocumento = new JLabel();
        jlbNumDocumento.setText("Numero de Documento");
        jlbNumDocumento.setBounds(30,240, 150,45);

        jtfNumDocumento = new JTextField();
        jtfNumDocumento.setText(cliente.getNumDocumento()+"");
        jtfNumDocumento.setBounds(180,240, 150,45);

        jlbCorreo = new JLabel();
        jlbCorreo.setText("Correo");
        jlbCorreo.setBounds(30,290, 150,45);

        jtfCorreo = new JTextField();
        jtfCorreo.setText(cliente.getCorreo()+"");
        jtfCorreo.setBounds(180,290, 150,45);

        jlbTipo = new JLabel();
        jlbTipo.setText("Tipo");
        jlbTipo.setBounds(30,340, 150,45);

        jtfTipo = new JTextField();
        jtfTipo.setText(cliente.getTipo()+"");
        jtfTipo.setBounds(180,340, 150,45);

        jlbEstado = new JLabel();
        jlbEstado.setText("Estado");
        jlbEstado.setBounds(30,390, 150,45);

        jtfEstado = new JTextField();
        jtfEstado.setText(cliente.getEstado()+"");
        jtfEstado.setBounds(180,390, 150,45);

        jbtNuevo.setText("Limpiar Registro");
        jbtNuevo.setBounds(350,90, 150,45);

        jbtGuardar.setText("Guardar");
        jbtGuardar.setBounds(50,440, 150,45);

        jbtActualizar.setText("Mostrar Lista");
        jbtActualizar.setBounds(230,440, 150,45);

        jbtLimpiar.setText("Eliminar");
        jbtLimpiar.setBounds(400,440, 150,45);

        panel.add(jlbIdCliente);
        panel.add(jtfNombres);
        panel.add(jtfApellidos);
        panel.add(jtfTipoDocumento);
        panel.add(jtfNumDocumento);
        panel.add(jtfCorreo);
        panel.add(jtfTipo);
        panel.add(jtfEstado);
        panel.add(jlbNombres);
        panel.add(jlbApellidos);
        panel.add(jlbTipoDocumento);
        panel.add(jlbNumDocumento);
        panel.add(jlbCorreo);
        panel.add(jlbTipo);
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
                if(cliente.getIdCliente() == 0){
                    cliente.setNombres(jtfNombres.getText());
                    cliente.setApellidos(jtfApellidos.getText());
                    cliente.setTipoDocumento(jtfTipoDocumento.getText());
                    cliente.setNumDocumento(jtfNumDocumento.getText());
                    cliente.setCorreo(jtfCorreo.getText());
                    cliente.setTipo(jtfTipo.getText());
                    cliente.setEstado(jtfEstado.getText());
                    cliente.save();
                }else{
                    cliente.setIdCliente(Integer.parseInt(jlbIdCliente.getText()));
                    cliente.setNombres(jtfNombres.getText());
                    cliente.setApellidos(jtfApellidos.getText());
                    cliente.setTipoDocumento(jtfTipoDocumento.getText());
                    cliente.setNumDocumento(jtfNumDocumento.getText());
                    cliente.setCorreo(jtfCorreo.getText());
                    cliente.setTipo(jtfTipo.getText());
                    cliente.setEstado(jtfEstado.getText());
                    cliente.update();
                }
            }
        });
        jbtActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarClientes cf = new ListarClientes();
                cf.setVisible(true);
                cf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                cf.setTitle("Tabla Clientes");
                dispose();
            }
        });
        jbtLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente.setIdCliente(Integer.parseInt(jlbIdCliente.getText()));
                cliente.setNombres(jtfNombres.getText());
                cliente.setApellidos(jtfApellidos.getText());
                cliente.setTipoDocumento(jtfTipoDocumento.getText());
                cliente.setNumDocumento(jtfNumDocumento.getText());
                cliente.setCorreo(jtfCorreo.getText());
                cliente.setTipo(jtfTipo.getText());
                cliente.setEstado(jtfEstado.getText());
                cliente.eliminar();
            }
        });
        jbtNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbIdCliente.setText("0");
                jtfNombres.setText("");
                jtfApellidos.setText("");
                jtfTipoDocumento.setText("");
                jtfNumDocumento.setText("");
                jtfCorreo.setText("");
                jtfTipo.setText("");
                jtfEstado.setText("");
            }
        });
    }


}
