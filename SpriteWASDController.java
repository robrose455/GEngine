package ge;

public class SpriteWASDController extends Controller {

    boolean wPressed;
    boolean sPressed;
    boolean aPressed;
    boolean dPressed;

    public SpriteWASDController() {

    }

    public boolean isWPressed() {
        return wPressed;
    }
    public boolean isSPressed() {
        return sPressed;
    }
    public boolean isAPressed() {
        return aPressed;
    }
    public boolean isDPressed() {
        return dPressed;
    }

    public void WisPressed() {
        wPressed = true;
    }
    public void SisPressed() {
        sPressed = true;
    }
    public void AisPressed() {
        aPressed = true;
    }
    public void DisPressed() {
        dPressed = true;
    }

    public void ResetWASDKeys() {

        wPressed = false;
        sPressed = false;
        aPressed = false;
        dPressed = false;

    }
}
