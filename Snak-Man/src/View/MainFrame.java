package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        super("Snake Man");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        ImageIcon image = new ImageIcon("/image/logo.png");
        JLabel label = new JLabel(image);
        label.setPreferredSize(new Dimension(275, 183));

        // Crear botón de jugar
        JButton button = new JButton("Jugar");
        button.setPreferredSize(new Dimension(100, 50));
        button.setMaximumSize(new Dimension(80, 50));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir otra ventana
                JFrame SnakeView = new SnakeView();
                SnakeView.setVisible(true);
            }
        });

        JLabel info = new JLabel("Creado por: [David Cubillos ]");
        info.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Configurar GridBagConstraints para los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Agregar componentes a la ventana principal
        add(label, gbc);
        gbc.gridy = 1;
        add(button, gbc);
        gbc.gridy = 2;
        add(info, gbc);

        // Mostrar la ventana principal
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
