
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 021.888496
 */
public class Operacoes {

    static boolean win = false;
    String simbolo = "O";
    static int contajog = 0;

    public String jogada(JButton btn) {
        if (btn.getText().equals("")) {
            if (simbolo.equals("X")) {
                simbolo = "O";
            } else if (simbolo.equals("O")) {
                simbolo = "X";
            }
            contajog += 1;
            return simbolo;

        } else {
            JOptionPane.showMessageDialog(null, "Opcao invalida", "Erro", 1);
            return btn.getText();

        }

    }

    public void checavitoria() {
        jogo_velha.jogadas.setText(Integer.toString(contajog));
        if (contajog >= 5) {

            vitoria(jogo_velha.B1, jogo_velha.B2, jogo_velha.B3);
            vitoria(jogo_velha.B4, jogo_velha.B5, jogo_velha.B6);
            vitoria(jogo_velha.B7, jogo_velha.B8, jogo_velha.B9);

            vitoria(jogo_velha.B1, jogo_velha.B4, jogo_velha.B7);
            vitoria(jogo_velha.B2, jogo_velha.B5, jogo_velha.B8);
            vitoria(jogo_velha.B3, jogo_velha.B6, jogo_velha.B9);

            vitoria(jogo_velha.B1, jogo_velha.B5, jogo_velha.B9);
            vitoria(jogo_velha.B3, jogo_velha.B5, jogo_velha.B7);
        }

        if ((contajog == 9) && (win == false)) {
            JOptionPane.showMessageDialog(null, "O jogo empatou!", "EMPATE", 1);
            jogarnovamente();
        }

    }

    static public void vitoria(JButton B1, JButton B2, JButton B3) {

        if ((B1.getText().equals("X")) && (B2.getText().equals("X")) && (B3.getText().equals("X"))) {
            JOptionPane.showMessageDialog(null, "O jogador X ganhou!", "vitória", 1);
            win = true;
            jogarnovamente();
        }

        if ((B1.getText().equals("O")) && (B2.getText().equals("O")) && (B3.getText().equals("O"))) {
            JOptionPane.showMessageDialog(null, "O jogador O ganhou!", "vitória", 1);
            win = true;
            jogarnovamente();
        }

    }

    static public void jogarnovamente() {
        int playagain = JOptionPane.showConfirmDialog(null, "Quer jogar novamente?");
        if (playagain == 0) {
            reset();
            jogo_velha.jogadas.setText(Integer.toString(0));
        } else {
            System.exit(0);
        }
    }

    static public void reset() {
        jogo_velha.B1.setText("");
        jogo_velha.B2.setText("");
        jogo_velha.B3.setText("");
        jogo_velha.B4.setText("");
        jogo_velha.B5.setText("");
        jogo_velha.B6.setText("");
        jogo_velha.B7.setText("");
        jogo_velha.B8.setText("");
        jogo_velha.B9.setText("");
        contajog = 0;
        win = false;

    }

}
