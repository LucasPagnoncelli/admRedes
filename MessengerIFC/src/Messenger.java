
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Messenger extends JFrame implements ActionListener {

    public JRadioButton serverRB = new JRadioButton();
    public JRadioButton clienteRB = new JRadioButton();
    public JTextField hostTF = new JTextField();
    public JTextField portaTF = new JTextField();
    public JTextField loggerTA = new JTextField();
    public JTextField messangeTF = new JTextField();
    public JButton iniciarBTN = new JButton("Iniciar");
    public JButton fecharBTN = new JButton("Fechar");
    public JButton enviarBTN = new JButton("Enviar");

    private int porta = 0;
    private ServerSocket servidor = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.iniciarBTN) {
            if (serverRB.isSelected()) {
                if (!portaTF.getText().isBlank()) {
                    porta = Integer.parseInt(portaTF.getText());
                    try {
                        servidor = new ServerSocket(porta);
                        loggerTA.setText(loggerTA.getText() + ("\n \n Iniciano o servidor: " + servidor.getLocalPort()));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                }
            }
        }
    }

    public Messenger(String titulo) {
        super(titulo);

        iniciarBTN.addActionListener(this);
        fecharBTN.addActionListener(this);
        enviarBTN.addActionListener(this);
    }

    public static void main(String[] args) {
        Messenger janela = new Messenger("Messeger IFC");
        janela.setSize(300, 400);
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));

        //MessageType
        JPanel messageType = new JPanel();
        messageType.setBackground(Color.red);
        messageType.setLayout(new BoxLayout(messageType, BoxLayout.LINE_AXIS));
        messageType.add(janela.serverRB);
        messageType.add(new JLabel("Servidor"));
        messageType.add(janela.clienteRB);
        messageType.add(new JLabel("Cliente"));

        main.add(messageType);

        //SocketInfo
        JPanel socketsInfo = new JPanel();
        socketsInfo.setBackground(Color.green);
        socketsInfo.setLayout(new BoxLayout(socketsInfo, BoxLayout.LINE_AXIS));
        socketsInfo.add(new JLabel("Host: "));
        socketsInfo.add(janela.hostTF);
        socketsInfo.add(new JLabel("Porta: "));
        socketsInfo.add(janela.portaTF);

        main.add(socketsInfo);

        //Logger
        JPanel logger = new JPanel();
        //JScrollPane scroll = new JScrollPane(janela.loggerTA);
        //logger.setBackground(Color.blue);
        //logger.add(scroll);

        main.add(logger);

        //Message
        JPanel messange = new JPanel();
        messange.setBackground(Color.yellow);
        messange.setLayout(new BoxLayout(messange, BoxLayout.PAGE_AXIS));
        messange.add(new JLabel("Mensagem"));
        messange.add(janela.messangeTF);

        main.add(messange);

        //Buttons
        JPanel buttons = new JPanel();
        buttons.setBackground(Color.magenta);
        main.add(buttons);
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
        buttons.add(janela.iniciarBTN);
        buttons.add(janela.fecharBTN);
        buttons.add(janela.enviarBTN);

        janela.getContentPane().add(main);
        janela.setVisible(true);
    }
}
