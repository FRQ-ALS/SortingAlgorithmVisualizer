import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    public int[] numbers;
    ToolBox toolBox = new ToolBox();


    BubbleSort bubble;
    InsertionSort insertion;
    QuickSort quickSort;
    HeapSort heapSort;
    MergeSort mergeSort;


    Controller controller = new Controller();
    JButton Randomize = new JButton("RANDOMIZE");
    JButton startSort = new JButton("SORT");
    String[] choices = {"Bubble sort", "Insertion sort", "Quick sort", "Heap sort", "Merge sort"};
    JComboBox<String> choiceBox = new JComboBox<>(choices);
    Timer timer;

    JSlider delaySlider = new JSlider(0, 20, 3);
    JLabel delayLabel = new JLabel("Delay (milliseconds): " + toolBox.getDelay());

    JSlider densitySlider = new JSlider(0, 100, 40);
    JLabel densityLabel = new JLabel("Density: " + toolBox.getNumberOfLines());


    MyPanel() {
        timer = new Timer(1, AL2);
        timer.start();
        this.repaint();
        this.setPreferredSize(new Dimension(1080, 700));
        this.setLayout(null);


        choiceBox.setBounds(160, 450, 175, 30);
        this.add(choiceBox);

        Randomize.setBounds(10, 410, 130, 30);
        Randomize.addActionListener(this);
        this.add(Randomize);

        startSort.setBounds(10, 450, 130, 30);
        startSort.addActionListener(this);
        this.add(startSort);

        delaySlider.setMajorTickSpacing(5);
        delaySlider.setMinorTickSpacing(1);
        delaySlider.setBounds(10, 490, 200, 70);
        delaySlider.setPaintLabels(true);
        delaySlider.setPaintTicks(true);
        delaySlider.setPaintTrack(true);
        delaySlider.addChangeListener(CL);
        this.add(delaySlider);

        delayLabel.setBounds(215, 460, 150, 100);
        this.add(delayLabel);

        densityLabel.setBounds(215, 550, 150, 100);
        this.add(densityLabel);

        densitySlider.setMajorTickSpacing(25);
        densitySlider.setMinorTickSpacing(5);
        densitySlider.setBounds(10, 570, 200, 70);
        densitySlider.setPaintLabels(true);
        densitySlider.setPaintTicks(true);
        densitySlider.setPaintTrack(true);
        densitySlider.addChangeListener(CL);
        this.add(densitySlider);
    }

    public void setArray(int[] numbers) {
        this.numbers = numbers;
    }

    public int[] getArray() {
        return numbers;
    }

    ActionListener AL2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Randomize) {
            numbers = (controller.randomize());
            MyPanel.this.repaint();
        }
        if (e.getSource() == startSort) {
            String currentChoice = (String) this.choiceBox.getSelectedItem();
            switch (currentChoice) {
                case "Bubble sort":
                    bubble = new BubbleSort(getArray());
                    bubble.start();
                    numbers = bubble.getNumbers();
                    break;
                case "Insertion sort":
                    insertion = new InsertionSort(getArray());
                    insertion.start();
                    numbers = insertion.getNumbers();
                    break;
                case "Quick sort":
                    quickSort = new QuickSort(getArray());
                    quickSort.start();
                    numbers = quickSort.getNumbers();
                    break;
                case "Heap sort":
                    heapSort = new HeapSort(getArray());
                    heapSort.start();
                    numbers = heapSort.getNumbers();
                    break;
                case "Merge sort":
                    mergeSort = new MergeSort(getArray());
                    mergeSort.start();
                    numbers = mergeSort.getNumbers();

            }
        }
    }


    ChangeListener CL = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            toolBox.setDelay(delaySlider.getValue());
            delayLabel.setText("Delay (milliseconds): " + delaySlider.getValue());

            toolBox.setNumberOfLines(densitySlider.getValue());
            densityLabel.setText("Density: " + densitySlider.getValue());

        }
    };

    public void paintComponent(Graphics g) {

        int startingPosition = (1080 -(numbers.length *10))/2;
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(1));
        g2D.setPaint(new Color(183, 235, 52));
        g2D.setPaint(Color.black);
        g2D.fillRect(0, 0, 1080, 405);

        for (int i = 0; i < getArray().length; i++) {
            g2D.setPaint(Color.yellow);
            g2D.setStroke(new BasicStroke(4));
            g2D.drawLine(startingPosition + (i * 10), 400, startingPosition + (i * 10), (400 - getArray()[i]));
        }
    }
}

