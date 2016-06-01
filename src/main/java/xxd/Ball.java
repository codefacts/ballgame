package xxd;

/**
 * Created by Shahadat on 6/1/2016.
 */
public class Ball {
    int x, y;
    final int width, height;
    Vector velocity;

    public Ball(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }
}
