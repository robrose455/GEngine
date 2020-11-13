package ge;

public class NullController extends Controller {

    NullController() {


    }

    @Override
    public String typeOfController() {
        return "null";
    }

    @Override
    public boolean isMovingUp() {
        return false;
    }

    @Override
    public boolean isMovingDown() {
        return false;
    }

    @Override
    public boolean isMovingLeft() {
        return false;
    }

    @Override
    public boolean isMovingRight() {
        return false;
    }

    @Override
    public void movingUp() {

    }

    @Override
    public void movingDown() {

    }

    @Override
    public void movingLeft() {

    }

    @Override
    public void movingRight() {

    }

    @Override
    public void ResetKeys() {

    }
}
