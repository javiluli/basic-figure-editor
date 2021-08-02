
/**
* @author javiluli (github)
*/

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Canvas;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Main {

  private JFrame    frame;
  private JPanel    panelCanvas;
  private Canvas    canvas;
  private JLabel    lblAncho;
  private JLabel    lblAlto;
  private JLabel    lblRed;
  private JLabel    lblGreen;
  private JLabel    lblBlue;
  private JSlider   sliderAncho;
  private JSlider   sliderAlto;
  private JSlider   sliderRed;
  private JSlider   sliderGreen;
  private JSlider   sliderBlue;
  private final int minValorColor = 0;
  private final int maxValorColor = 255;
  private final int tamDefecto    = 100;
  private int       ancho         = tamDefecto, alto = tamDefecto, rojo = maxValorColor, verde = maxValorColor,
      azul = maxValorColor;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Main window = new Main();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public Main() {
    initialize();
  }

  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 670, 301);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    panelCanvas = new JPanel();
    panelCanvas.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    panelCanvas.setBounds(239, 11, 400, 150);
    frame.getContentPane().add(panelCanvas);
    panelCanvas.setLayout(null);

    canvas = new Canvas();
    canvas.setBounds(0, 0, 100, 100);
    panelCanvas.add(canvas);
    canvas.setForeground(Color.WHITE);
    canvas.setBackground(new Color(rojo, verde, azul));

    lblAncho = new JLabel("Anchura de la figura: " + ancho + " px");
    lblAncho.setFont(new Font("Arial", Font.BOLD, 12));
    lblAncho.setBounds(10, 11, 200, 14);
    frame.getContentPane().add(lblAncho);

    sliderAncho = new JSlider(JSlider.HORIZONTAL, 0, panelCanvas.getWidth(), tamDefecto);
    sliderAncho.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        ancho = sliderAncho.getValue();
        lblAncho.setText("Anchura de la figura " + ancho + " px");
        canvas.setBounds(0, 0, ancho, alto);
      }
    });
    sliderAncho.setBounds(10, 36, 200, 26);
    frame.getContentPane().add(sliderAncho);

    lblAlto = new JLabel("Altura de la figura: " + alto + " px");
    lblAlto.setFont(new Font("Arial", Font.BOLD, 12));
    lblAlto.setBounds(10, 73, 200, 14);
    frame.getContentPane().add(lblAlto);

    sliderAlto = new JSlider(JSlider.HORIZONTAL, 0, panelCanvas.getHeight(), tamDefecto);
    sliderAlto.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        alto = sliderAlto.getValue();
        lblAlto.setText("Altura de la figura " + alto + " px");
        canvas.setBounds(0, 0, ancho, alto);
      }
    });
    sliderAlto.setBounds(10, 98, 200, 26);
    frame.getContentPane().add(sliderAlto);

    lblRed = new JLabel("Grado de Rojo " + rojo);
    lblRed.setFont(new Font("Arial", Font.BOLD, 12));
    lblRed.setBounds(13, 196, 160, 14);
    frame.getContentPane().add(lblRed);

    sliderRed = new JSlider(JSlider.HORIZONTAL, minValorColor, maxValorColor, rojo);
    sliderRed.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        rojo = sliderRed.getValue();
        lblRed.setText("Grado de Rojo " + rojo);
        canvas.setBackground(new Color(rojo, verde, azul));
      }
    });
    sliderRed.setBounds(13, 221, 200, 26);
    frame.getContentPane().add(sliderRed);

    lblGreen = new JLabel("Grado de Verde " + verde);
    lblGreen.setFont(new Font("Arial", Font.BOLD, 12));
    lblGreen.setBounds(226, 196, 160, 14);
    frame.getContentPane().add(lblGreen);

    sliderGreen = new JSlider(JSlider.HORIZONTAL, minValorColor, maxValorColor, verde);
    sliderGreen.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        verde = sliderGreen.getValue();
        lblGreen.setText("Grado de Verde " + verde);
        canvas.setBackground(new Color(rojo, verde, azul));
      }
    });
    sliderGreen.setBounds(226, 221, 200, 26);
    frame.getContentPane().add(sliderGreen);

    lblBlue = new JLabel("Grado de Azul " + azul);
    lblBlue.setFont(new Font("Arial", Font.BOLD, 12));
    lblBlue.setBounds(439, 196, 160, 14);
    frame.getContentPane().add(lblBlue);

    sliderBlue = new JSlider(JSlider.HORIZONTAL, minValorColor, maxValorColor, azul);
    sliderBlue.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        azul = sliderBlue.getValue();
        lblBlue.setText("Grado de Azul " + verde);
        canvas.setBackground(new Color(rojo, verde, azul));
      }
    });
    sliderBlue.setBounds(439, 221, 200, 26);
    frame.getContentPane().add(sliderBlue);

  }
}
