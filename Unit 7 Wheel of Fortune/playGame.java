public class playGame
{
    GameWheel wheel;
    WheelOfFortuneGraphics graphics;
    int totalScore;
    int numSpins;
    Slice spinResult;

    //Creates a new GameWheel and uses that GameWheel to create a new graphics winow
    public playGame(GameWheel w)
    {
        wheel = w;
        graphics = new WheelOfFortuneGraphics(w, this);
        graphics.textField.setText("Click the wheel to spin!");
    }

    //Called from WheelOfFortuneGraphics. Runs right after the spin button is pressed and before the spin animation
    public Slice beginSpin()
    {
        numSpins++;
        graphics.textField.setText("Total Prize Money: $" + totalScore);
        graphics.textField2.setText("Spin " + numSpins + " - Prize Amount: $");
        spinResult = wheel.spinWheel();
        
        return spinResult;
    }

    //Called from WheelOfFortuneGraphics. Runs after the spin button is pressed and after the spin animation
    public void endSpin()
    {
        totalScore += spinResult.getPrizeAmount();
        if(numSpins >= 3)
        {
            graphics.textField.setText("Game Over! Total Prize Money: $" + totalScore + ".");
            graphics.textField2.setText("Spin " + numSpins + " - Prize Amount: $" + spinResult.getPrizeAmount());
            numSpins = 0;
            totalScore = 0;
        }
        else
        {
            graphics.textField.setText("Total Prize Money: $" + totalScore);
            graphics.textField2.setText("Spin " + numSpins + " - Prize Amount: $" + spinResult.getPrizeAmount());
        }
    }

    public static void main(String[] args)
    {
        GameWheel wheel1 = new GameWheel();
        new playGame(wheel1);     
    }
}