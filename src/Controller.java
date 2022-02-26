import java.util.Random;

public class Controller{
    ToolBox toolBox = new ToolBox();
    public int[] randomize() {
        Random rd = new Random();
        int[] randomArray = new int[toolBox.getNumberOfLines()];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rd.nextInt(390);
        }
        return randomArray;
    }
}