import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaCadastro3 extends JFrame implements ActionListener, ItemListener {
    JLabel cpf, rg, nome, logradouro, endereco, cep, numero, complemento, sexo;
    JTextField txtCpf, txtRg, txtNome, txtLogradouro, txtEndereco;
    JTextField txtCep, txtNumero, txtComplemento;
    JButton btGravar, btCancelar;
    JComboBox<String> combo;
    private JRadioButton masculino, feminino;
    private ButtonGroup radioGrupo;
    private RadioButtonTratar tratarRB;

    public TelaCadastro3() {
        setTitle("Cadastro");
        setSize(800, 400);
        getContentPane().setLayout(null);
        int distTopo = 10;
        int linha = 40;

        cpf = criarJLabel("CPF", 10, distTopo, 100, linha);
        txtCpf = criarTexto(110, distTopo, 250, linha);
        rg = criarJLabel("RG", 460, distTopo, 100, linha);
        txtRg = criarTexto(490, distTopo, 265, linha);

        nome = criarJLabel("NOME", 10, distTopo += 50, 100, linha);
        txtNome = criarTexto(110, distTopo, 650, linha);

        cep = criarJLabel("CEP", 10, distTopo += 50, 130, linha);
        txtCep = criarTexto(110, distTopo, 100, linha);
        numero = criarJLabel("Número", 250, distTopo, 80, linha);
        txtNumero = criarTexto(320, distTopo, 100, linha);
        complemento = criarJLabel("Complemento", 430, distTopo, 150, linha);
        txtComplemento = criarTexto(560, distTopo, 200, linha);

        logradouro = criarJLabel("Logr.", 10, distTopo += 50, 100, linha);
        String logr[] = {"Alameda", "Rua", "Avenida", "Praça", "Viela"};
        combo = criarCombo(logr, 110, distTopo, 140, linha);
        endereco = criarJLabel("Endereço", 260, distTopo, 90, linha);
        txtEndereco = criarTexto(350, distTopo, 410, linha);

        tratarRB = new RadioButtonTratar();
        radioGrupo = new ButtonGroup();
        JLabel sexo = criarJLabel("Sexo:", 10, distTopo += 50, 100, linha);
        feminino = criarRadio("Feminino", false, 100, distTopo, 100, linha);
        masculino = criarRadio("Masculino", false, 210, distTopo, 100, linha);

        int rodape = 300;
        btGravar = criarBotao("Gravar", 'G', 300, rodape, 130, linha);
        btCancelar = criarBotao("Cancelar", 'C', 430, rodape, 130, linha);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JRadioButton criarRadio(String nome, boolean b, int i, int j, int k, int linha) {
        JRadioButton radioBot = new JRadioButton(nome, b);
        radioBot.setBounds(i, j, k, linha);
        radioBot.addItemListener(tratarRB);
        add(radioBot);
        radioGrupo.add(radioBot);
        return radioBot;
    }

    private JComboBox<String> criarCombo(String[] logr, int desq, int distTopo, int larg, int linha) {
        JComboBox<String> combo = new JComboBox<>(logr);
        combo.addItemListener(this);
        combo.setFont(new Font("Arial", Font.BOLD, 15));
        combo.setBounds(desq, distTopo, larg, linha);
        add(combo);
        return combo;
    }

    private JButton criarBotao(String texto, char atalho, int dEsq, int rodape, int larg, int linha) {
        JButton botao = new JButton(texto);
        botao.setBounds(dEsq, rodape, larg, linha);
        botao.setMnemonic(atalho);
        botao.addActionListener(this);
        add(botao);
        return botao;
    }

    public JTextField criarTexto(int distEsq, int distTopo, int larg, int altura) {
        JTextField txt = new JTextField();
        txt.setBounds(distEsq, distTopo, larg, altura);
        txt.setForeground(Color.BLUE);
        txt.setFont(new Font("Courier new", Font.BOLD, 18));
        add(txt);
        return txt;
    }

    public JLabel criarJLabel(String texto, int distEsq, int distTopo, int larg, int altura) {
        JLabel jl = new JLabel(texto);
        jl.setBounds(distEsq, distTopo, larg, altura);
        jl.setFont(new Font("Courier new", Font.BOLD, 18));
        add(jl);
        return jl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btGravar) {
            String cpf = txtCpf.getText().replaceAll("\\D", "");
            String rg = txtRg.getText().replaceAll("\\D", "");

            if (!validarCPF(cpf)) {
                JOptionPane.showMessageDialog(this, "CPF inválido!");
                return;
            }

            if (rg.length() < 7) {
                JOptionPane.showMessageDialog(this, "RG inválido!");
                return;
            }

            JOptionPane.showMessageDialog(this, "Dados enviados com sucesso!");
        }

        if (e.getSource() == btCancelar) {
            System.exit(0);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED)
            JOptionPane.showMessageDialog(null, "Selecionado: " + combo.getSelectedItem());
    }

    private class RadioButtonTratar implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == feminino)
                System.out.println("Sexo " + feminino.getText());
            else if (e.getSource() == masculino)
                System.out.println("Sexo " + masculino.getText());
        }
    }

    public static boolean validarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

        try {
            int soma = 0;
            for (int i = 0; i < 9; i++)
                soma += (cpf.charAt(i) - '0') * (10 - i);
            int dig1 = 11 - (soma % 11);
            if (dig1 > 9) dig1 = 0;

            soma = 0;
            for (int i = 0; i < 10; i++)
                soma += (cpf.charAt(i) - '0') * (11 - i);
            int dig2 = 11 - (soma % 11);
            if (dig2 > 9) dig2 = 0;

            return dig1 == (cpf.charAt(9) - '0') && dig2 == (cpf.charAt(10) - '0');
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new TelaCadastro3();
    }
}
