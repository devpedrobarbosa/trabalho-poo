/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.util;

import java.awt.Component;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Pedro
 */
//Classe criada para conter métodos complexos e muito utilizados afim de evitar repetição de código
// e trabalho desnecessário
public class Util {
    
    //Conta a quantidade de fields declarados em uma classe, afim de saber quantos atributos tem um modelo
    public static int countClassFields(Class<?> c) {
        int count = c.getDeclaredFields().length;
        if(c.getSuperclass() != null) //Caso esteja herdando outra classe, considera também os fields declarados nela
            count += c.getSuperclass().getDeclaredFields().length;
        return count;
    }
    
    //Verifica nome válido
    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Z][a-zA-Z' -]+(?: [A-Z][a-zA-Z' -]+)*$");
    }
    
    //Verifica login válido
    public static boolean isValidLogin(String login) {
        return login != null && login.matches("^[a-zA-Z][a-zA-Z0-9._-]{4,19}$");
    }
    
    //Verifica senha válida
    public static boolean isValidPassword(String password) {
        return password != null && password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }
    
    //Verifica CPF válido
    public static boolean isValidCPF(String cpf) {
        return cpf != null && cpf.length() >= 11 && cpf.length() <= 14 && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11}");
    }
    
    //Verifica CNPJ válido
    public static boolean isValidCNPJ(String cnpj) {
        return cnpj != null && cnpj.length() >= 14 && cnpj.length() <= 18 && cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}|\\d{14}");
    }
    
    //Verifica endereço válido
    public static boolean isValidAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }
    
    //Verifica telefone válido
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^\\+\\d{2} \\(\\d{2}\\) (\\d{4}-\\d{4}|9 \\d{4}-\\d{4})$");
    }

    //Verifica integridade do email
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
    
    //Método que valida de uma vez uma série de fields
    public static String validateFields(JTextField name, JTextField cpf, JTextField cnpj, JTextField address, JTextField phone, JTextField email, JTextField login, JTextField password, JTextField representative) {
        if (name != null && !Util.isValidName(name.getText()))
            return "Insira um nome válido: primeira letra dos nomes deve ser maiúscula, pode-se utilizar ' e -";
        if (cpf != null && !Util.isValidCPF(replaceDocumentMask(cpf.getText())))
            return "Insira um CPF válido: 11 dígitos numéricos";
        if (cnpj != null && !Util.isValidCNPJ(replaceDocumentMask(cnpj.getText())))
            return "Insira um CNPJ válido: 14 dígitos numéricos";
        if (address != null && !Util.isValidAddress(address.getText()))
            return "Insira um endereço válido";
        if (phone != null && !Util.isValidPhone(phone.getText()))
            return "Insira um telefone válido";
        if (email != null && !Util.isValidEmail(email.getText()))
            return "Insira um e-mail válido";
        if (login != null && !Util.isValidLogin(login.getText()))
            return "Insira um login válido: deve ter 5 a 20 caracteres contendo somente letras, números, pontos e underlines";
        if (password != null && !Util.isValidPassword(password.getText()))
            return "Insira uma senha válida: pelo menos 8 caracteres sendo\n- uma letra\n- um número\n- um caractere especial";
        if (representative != null && !Util.isValidName(representative.getText()))
            return "Insire um nome de representante válido: primeira letra dos nomes deve ser maiúscula, pode-se utilizar ' e -";
        return null;
    }
    
    //Método que mostra uma janela de erro padrão, pedindo apenas o texto do erro
    public static void showError(Component root, String text) {
        JOptionPane.showMessageDialog(root, text, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static String replaceDocumentMask(String s) {
        return s.replace("-", "").replace(".", "").replace("/", "");
    }
    
    //Método que pergunta se o usuário quer realmente confirmar uma ação, e retorna um boolean dizendo se sim ou não, para prosseguir ou não com a ação
    public static boolean askForConfirmation(Component root, String text) {
        return JOptionPane.showConfirmDialog(root, text, "Confirmação", JOptionPane.YES_NO_OPTION) != 1;
    }
    
    public static String generateId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}