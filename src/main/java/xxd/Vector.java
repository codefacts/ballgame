package xxd;

/**
 * Created by Shahadat on 6/1/2016.
 */
public class Vector {
    float angle;
    float val;

    public Vector(float angle, float val) {
        this.angle = angle;
        this.val = val;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }
}
