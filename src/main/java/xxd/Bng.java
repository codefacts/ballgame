package xxd;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Shahadat on 6/1/2016.
 */
public class Bng {
    private static final float BAR_VELOCITY = 9;
    final float timeDelta = 9;
    final Ball ball;
    final Bar bar;
    final Rectangle rectangle;
    final AtomicInteger atomicInteger = new AtomicInteger(0);

    public Bng(Ball ball, Bar bar, Rectangle rectangle) {
        this.ball = ball;
        this.bar = bar;
        this.rectangle = rectangle;
        this.bar.getVelocity().angle = (float) Math.PI;
    }

    public void gotoNextFrame() {
        ball.x = (int) calX2(ball.x, ball.getVelocity());
        ball.y = (int) calY2(ball.y, ball.getVelocity());

        if (ball.x > rectangle.width) {
            ball.x = rectangle.width - (ball.x - rectangle.width);
            ball.velocity.angle = (float) (Math.PI - ball.velocity.angle);
        } else if (ball.x < 0) {
            ball.x = -ball.x;
            ball.velocity.angle = (float) (Math.PI - ball.velocity.angle);
        }

        if (ball.y > rectangle.height) {
            ball.y = rectangle.height - (ball.y - rectangle.height);
            ball.velocity.angle = (float) (Math.PI - ball.velocity.angle);
        } else if (ball.y < 0) {
            ball.y = -ball.y;
            ball.velocity.angle = (float) (Math.PI - ball.velocity.angle);
        }

        if (atomicInteger.get() == 0) {
            bar.getVelocity().val = 0;
        } else if (atomicInteger.get() == 1) {
            bar.getVelocity().val = BAR_VELOCITY;
        } else if (atomicInteger.get() == -1) {
            bar.getVelocity().val = -BAR_VELOCITY;
        }

        bar.x = (int) calX2(bar.x, bar.getVelocity());
        bar.y = (int) calY2(bar.y, bar.getVelocity());

        if (bar.x > rectangle.width) {
            bar.x = rectangle.width;
        } else if (bar.x < 0) {
            bar.x = 0;
        }
    }

    public void moveLeft() {
        atomicInteger.set(-1);
    }

    public void moveRight() {
        atomicInteger.set(1);
    }

    float calX2(float x1, Vector vector) {
        return (float) (x1 + vector.val * Math.cos(vector.angle));
    }

    float calY2(float y1, Vector vector) {
        return (float) (y1 + vector.val * Math.sin(vector.angle));
    }
}
