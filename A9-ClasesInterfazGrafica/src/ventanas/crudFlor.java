package ventanas;

import Clases.CFlor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class crudFlor extends JFrame {
    private CFlor flor;
    private JPanel panel;
    private JLabel jlbIdFlor;
    private JTextField jtfNombre;
    private JTextField jtfAroma;
    private JTextField jtfColor;
    private JTextField jtfPrecio;
    private JTextField jtfStock;
    private SpinnerDateModel fcreacion;
    private JTextField jtfEstado;

    private JLabel jlbNombre;
    private JLabel lbAroma;
    private JLabel jlbColor;
    private JLabel lbPrecio;
    private JLabel jlbStock;
    private JLabel lbfcreacion;
    private JLabel jlbEstado;

    private JButton jbtNuevo = new JButton();
    private JButton jbtGuardar = new JButton();
    private JButton jbtActualizar = new JButton();
    private JButton jbtLimpiar = new JButton();
    public crudFlor(){
        setSize(700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        flor = new CFlor();
        inicializarComponentes();
        cargarEventos();
    }

    public crudFlor(CFlor pFlor){
        flor = pFlor;
        setSize(700, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        inicializarComponentes();
        cargarEventos();
    }
    public void inicializarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);


        jlbIdFlor = new JLabel();
        jlbIdFlor.setText(flor.getIdflor()+"");
        jlbIdFlor.setBounds(30,30, 150,45);

        jlbNombre = new JLabel();
        jlbNombre.setText("Nombre");
        jlbNombre.setBounds(30,90, 150,45);

        jtfNombre = new JTextField();
        jtfNombre.setText(flor.getNombre()+"");
        jtfNombre.setBounds(180,90, 150,45);

        lbAroma = new JLabel();
        lbAroma.setText("Aroma");
        lbAroma.setBounds(30,140, 150,45);

        jtfAroma = new JTextField();
        jtfAroma.setText(flor.getAroma()+"");
        jtfAroma.setBounds(180,140, 150,45);

        jlbColor = new JLabel();
        jlbColor.setText("Color");
        jlbColor.setBounds(30,190, 150,45);

        jtfColor = new JTextField();
        jtfColor.setText(flor.getColor()+"");
        jtfColor.setBounds(180, 190, 150,45);

        lbPrecio = new JLabel();
        lbPrecio.setText("Precio");
        lbPrecio.setBounds(30,240, 150,45);

        jtfPrecio = new JTextField();
        jtfPrecio.setText(flor.getPrecio()+"");
        jtfPrecio.setBounds(180,240, 150,45);

        jlbStock = new JLabel();
        jlbStock.setText("Stock");
        jlbStock.setBounds(30,290, 150,45);

        jtfStock = new JTextField();
        jtfStock.setText(flor.getStock()+"");
        jtfStock.setBounds(180,290, 150,45);

        fcreacion = new SpinnerDateModel();

        jlbEstado = new JLabel();
        jlbEstado.setText("Estado");
        jlbEstado.setBounds(30,340, 150,45);

        jtfEstado = new JTextField();
        jtfEstado.setText(flor.getEstado()+"");
        jtfEstado.setBounds(180,340, 150,45);

        jbtNuevo.setText("Limpiar Registro");
        jbtNuevo.setBounds(350,90, 150,45);

        jbtGuardar.setText("Guardar");
        jbtGuardar.setBounds(50,390, 150,45);

        jbtActualizar.setText("Mostrar Lista");
        jbtActualizar.setBounds(230,390, 150,45);

        jbtLimpiar.setText("Eliminar");
        jbtLimpiar.setBounds(400,390, 150,45);

        panel.add(jlbIdFlor);
        panel.add(jtfNombre);
        panel.add(jtfAroma);
        panel.add(jtfColor);
        panel.add(jtfPrecio);
        panel.add(jtfStock);
        panel.add(jlbNombre);
        panel.add(lbAroma);
        panel.add(jlbColor);
        panel.add(lbPrecio);
        panel.add(jlbStock);
        panel.add(jtfEstado);
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
                if(flor.getIdflor() == 0){
                    flor.setNombre(jtfNombre.getText());
                    flor.setAroma(jtfAroma.getText());
                    flor.setColor(jtfColor.getText());
                    flor.setPrecio(Double.parseDouble(jtfPrecio.getText()));
                    flor.setStock(Integer.parseInt(jtfStock.getText()));
                    flor.setEstado(jtfEstado.getText());
                    flor.save();
                }else{
                    flor.setIdflor(Integer.parseInt(jlbIdFlor.getText()));
                    flor.setNombre(jtfNombre.getText());
                    flor.setAroma(jtfAroma.getText());
                    flor.setColor(jtfColor.getText());
                    flor.setPrecio(Double.parseDouble(jtfPrecio.getText()));
                    flor.setStock(Integer.parseInt(jtfStock.getText()));
                    flor.setEstado(jtfEstado.getText());
                    flor.update();
                }
            }
        });
        jbtActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarFlores lf = new ListarFlores();
                lf.setVisible(true);
                lf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                lf.setTitle("Tabla Flores");
                dispose();
            }
        });
        jbtLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flor.setIdflor(Integer.parseInt(jlbIdFlor.getText()));
                flor.setNombre(jtfNombre.getText());
                flor.setAroma(jtfAroma.getText());
                flor.setColor(jtfColor.getText());
                flor.setPrecio(Double.parseDouble(jtfPrecio.getText()));
                flor.setStock(Integer.parseInt(jtfStock.getText()));
                flor.setEstado(jtfEstado.getText());
                flor.eliminar();
            }
        });
        jbtNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbIdFlor.setText("0");
                jtfNombre.setText("");
                jtfAroma.setText("");
                jtfColor.setText("");
                jtfPrecio.setText("");
                jtfStock.setText("");
                jtfEstado.setText("");
            }
        });
    }
}
