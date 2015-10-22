
import java.io.Serializable;

public class Scores implements Serializable {
    
    int score;
    String playerName;
    
    public Scores(String name, int sc)
    {
        score = sc;
        playerName = name;
    }
    
    public int getScore()
    {
        return score;
        
    }
    
    public String getName()
    {
        return playerName;
    }
    
    public void setPlayerName(String name)
    {
        playerName = name;
    }
    
    public void setScore(int sc)
    {
        score = sc;
    }

}
