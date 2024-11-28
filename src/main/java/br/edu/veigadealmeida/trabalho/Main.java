/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.veigadealmeida.trabalho;

import br.edu.veigadealmeida.trabalho.view.LoginView;
import java.awt.Color;
import java.awt.EventQueue;

/**
 *
 * @author suporte
 */
public class Main {
    
    //Variáveis criadas afim de centralizar a informação e reaproveitar código
    private static final Color buttonBackgroundColor, darkerButtonBackgroundColor;
    
    static {
        buttonBackgroundColor = new Color(122, 178, 211);
        darkerButtonBackgroundColor = new Color(112, 168, 201);
    }
    
    public static Color getButtonBackgroundColor() {
        return buttonBackgroundColor;
    }

    public static Color getDarkerButtonBackgroundColor() {
        return darkerButtonBackgroundColor;
    }
    
    //Início do programa
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true); //Primeira coisa que acontece, chamar tela de Login
            }
        });
    }
    
    //Funções específicas criadas para auxiliar o desenvolvimento
    public static interface Func<T> {
        T make();
    }
    
    public static interface Func2<T, T2, R> {
        R make(T t, T2 t2);
    }
}