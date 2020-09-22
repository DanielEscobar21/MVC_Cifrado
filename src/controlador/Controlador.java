package controlador;

import modelo.Modelo;
import vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vista.InterfazVista;

public class Controlador implements ActionListener {

    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo m, Vista v) {
        modelo = m;
        vista = v;
        vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case InterfazVista.ABRIR:
                modelo.setFileName(vista.getFileName());
                vista.setText(modelo.read());
                break;
            case InterfazVista.ENCRYPT:
                modelo.setContenido(vista.getText());
                vista.setText(modelo.encript());
                break;
            case InterfazVista.DECRYPT:
                modelo.setContenido(vista.getText());
                vista.setText(modelo.decript());
                break;
            case InterfazVista.GUARDAR:
                modelo.setFileName(vista.getFileName());
                modelo.setContenido(vista.getText());
                modelo.write();
                break;
            default:
                System.err.println(" Comando no definido ");
                break;
        }
    }

    public void arrancar() { // Comienza la visualizacion
        vista.setLocationRelativeTo(null);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setSize(500, 250);
        vista.setVisible(true);
    }
}
