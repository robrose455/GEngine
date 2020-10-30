package ge;
//Abstract Class for Controllers -> Creates the ability to set custom control classes in the future once all keys are set up by listeners.
//Currently only have functionality for WASD and Arrow Keys
abstract class Controller {

        public abstract String typeOfController();
        public abstract boolean isMovingUp();
        public abstract boolean isMovingDown();
        public abstract boolean isMovingLeft();
        public abstract boolean isMovingRight();

        public abstract void movingUp();
        public abstract void movingDown();
        public abstract void movingLeft();
        public abstract void movingRight();

        public abstract void ResetKeys();

}
