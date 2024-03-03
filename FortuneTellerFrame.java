import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private ImageIcon fortuneTellerIcon;
    private JTextArea fortuneTextArea;
    private JButton fortuneButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setResizable(false);
        setLayout(new BorderLayout());


        fortuneTellerIcon = new ImageIcon("fortuneteller.png"); // Assuming this is the image file name
        titleLabel = new JLabel("Fortune Teller", fortuneTellerIcon, SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));


        fortuneTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        fortuneTextArea.setEditable(false);
        fortuneTextArea.setFont(new Font("Arial", Font.PLAIN, 14));


        JPanel bottomPanel = new JPanel();
        fortuneButton = new JButton("Read My Fortune!");
        quitButton = new JButton("Quit");
        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);


        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);


        fortunes = new ArrayList<>();
        fortunes.add("Fortune 1: You will find great success in the near future.");
        fortunes.add("Fortune 2: A pleasant surprise awaits you.");
        fortunes.add("Fortune 3: Embrace change, it will lead to new opportunities.");
        // Add more fortunes as needed...


        fortuneButton.addActionListener((ActionEvent e) -> {
            displayFortune();
        });

        quitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);
        setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
    }

    private void displayFortune() {

        int index = new Random().nextInt(fortunes.size());

        while (index == lastIndex) {
            index = new Random().nextInt(fortunes.size());
        }
        lastIndex = index;
        String fortune = fortunes.get(index);
        fortuneTextArea.append(fortune + "\n");
    }
}