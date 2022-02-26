import javax.swing.*;

public class MyFrame extends JFrame {
    MyPanel panel;
    int[] numbers;

    MyFrame(int[] numbers) {
        this.setSize(500, 500);
        this.numbers = numbers;
        panel = new MyPanel();
        panel.setArray(numbers);
        this.add(panel);



        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setLayout(null);  *No need to
        this.setVisible(true);
    }
}
