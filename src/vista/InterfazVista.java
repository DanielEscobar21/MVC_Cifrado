package vista;

import controlador.Controlador;

public interface InterfazVista {
    void setControlador(Controlador c);
    public String getFileName();
    public String getText();
    public void setText(String s);
    static final String ABRIR = " Abrir ";
    static final String ENCRYPT = "Encriptar";
    static final String DECRYPT = "Decencriptar";
    static final String GUARDAR = " Guardar ";
}
