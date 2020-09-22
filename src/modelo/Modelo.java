package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Modelo {

    private String contenido;
    private String fileName;
    final char up = (char) 3;
    final char down = (char) 1;

    public void setContenido(String texto) {
        contenido = texto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setFileName(String nombre) {
        fileName = nombre;
    }

    public String encript() {
        String ctext = "";
        for (String linea : contenido.split("\n")) {
            StringBuilder cadena = new StringBuilder();
            for (char c : linea.toCharArray()) {
                if (Character.isLetter(c)) {
                    c += up;
                }
                cadena.append(c);
            }
            StringBuilder shift_cadena = new StringBuilder();
            String shifttext = cadena.reverse().toString();
            int h = shifttext.length() / 2;
            for (char c : shifttext.substring(h,
                    shifttext.length()).toCharArray()) {
                if (Character.isLetter(c)) {
                    c -= down;
                }
                shift_cadena.append(c);
            }
            ctext = ctext + shifttext.substring(0, h) + shift_cadena.toString() + "\n";
        }
        contenido = ctext;
        return ctext;
    }

    public String decript() {
        String texto = "";
        for (String ctext : contenido.split("\n")) {
            int h = ctext.length() / 2;
            StringBuilder shift_cadena = new StringBuilder(ctext.substring(0, h));
            for (char c : ctext.substring(h, ctext.length()).toCharArray()) {
                if (Character.isLetter(c)) {
                    c += down;
                }
                shift_cadena.append(c);
            }
            String shifttext = shift_cadena.reverse().toString();
            StringBuilder cadena = new StringBuilder();
            for (char c : shifttext.toCharArray()) {
                if (Character.isLetter(c - 3)) {
                    c -= up;
                }
                cadena.append(c);
            }
            texto = texto + cadena.toString() + "\n";
        }
        contenido = texto;
        return texto;
    }

    public String read() {
        String cad;
        String content = "";
        File file = new File(fileName);
        try {
            if (file.exists()) {
                BufferedReader b = new BufferedReader(new FileReader(file));
                while ((cad = b.readLine()) != null) {
                    content = content + cad + "\n";
                    b.close();
                }
            }
        } catch (IOException e) {
            System.err.println("Error"+e);
        } 
        contenido = content;
        return content;
    }

    public void write() {
        try {
            File archivo = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    archivo));;
            bw.write(contenido);
            bw.close();
        } catch (IOException e) {
            System.err.println("Error"+e);
        }
    }
}
