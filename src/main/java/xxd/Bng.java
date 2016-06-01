package xxd;

/**
 * Created by Shahadat on 6/1/2016.
 */
public class Bng {
    final float timeDelta = 9;
    final Ball ball;
    final Bar bar;
    final Rectangle rectangle;

    public Bng(Ball ball, Bar bar, Rectangle rectangle) {
        this.ball = ball;
        this.bar = bar;
        this.rectangle = rectangle;
    }

    public void gotoNextFrame() {
        ball.x = (int) calX2(ball.x, ball.getVelocity());
        ball.y = (int) calY2(ball.y, ball.getVelocity());

        bar.x = (int) calX2(bar.x, bar.getVelocity());
        bar.y = (int) calY2(bar.y, bar.getVelocity());


    }

    public void moveLeft() {

    }

    public void moveRight() {

    }

    float calX2(float x1, Vector vector) {
        return (float) (x1 + vector.val * Math.cos(vector.angle));
    }

    float calY2(float y1, Vector vector) {
        return (float) (y1 + vector.val * Math.sin(vector.angle));
    }
}
