import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is a main class that starting the game.
 */
public class Game {

    /**
     * The main method activate the game.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Game", 800, 600);
        AnimationRunner ar = new AnimationRunner(gui);
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        for (int i = 0; i < args.length; i++) {
            try {
                switch (Integer.parseInt(args[i])) {
                    case 1:
                        levels.add(new Level1());
                        break;
                    case 2:
                        levels.add(new Level2());
                        break;
                    case 3:
                        levels.add(new Level3());
                        break;
                    case 4:
                        levels.add(new Level4());
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        if (levels.isEmpty()) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        }
        GameFlow game = new GameFlow(ar, gui.getKeyboardSensor());
        game.runLevels(levels);
        gui.close();

    }
}
