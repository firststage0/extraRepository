package assets;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {
    private TranslateTransition tt;

    public Shake(Node node){

        tt = new TranslateTransition(Duration.millis(100), node);
        tt.setFromX(0);
        tt.setByX(10f);
        tt.setCycleCount(6);
        tt.setAutoReverse(true);
    }
    public void PlayAnim(){
        tt.playFromStart();
    }
}