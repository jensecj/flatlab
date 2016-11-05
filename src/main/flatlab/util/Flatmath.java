package flatlab.util;

import java.util.*;
import java.lang.Math;

public class Flatmath {
    private static Random rng = new Random(42);

    public static final float PI = 3.14159265f;

    public static int nexti(int min, int max) {
        return rng.nextInt((max - min) + 1) + min;
    }

    public static float nextf(float min, float max) {
        return rng.nextFloat() * (max - min) + min;
    }

    public static Vector2f PointToWorldSpace(Vector2f point, Vector2f heading, Vector2f side, Vector2f pos) {
        Matrix3f m = Matrix3f.identity;
        m = Matrix3f.rotate(m, heading, side);
        m = Matrix3f.translate(m, pos);

        return Matrix3f.transform(m, point);
    }

    public static Vector2f VectorToWorldSpace(Vector2f v, Vector2f heading, Vector2f side) {
        Matrix3f m = Matrix3f.identity;
        m = Matrix3f.rotate(m, heading, side);

        return Matrix3f.transform(m, v);
    }

    public static Vector2f PointToLocalSpace(Vector2f point, Vector2f heading, Vector2f side, Vector2f pos) {
        float Tx = -Vector2f.dot(pos, heading);
        float Ty = -Vector2f.dot(pos, side);

        Matrix3f m = new Matrix3f(heading.x, side.x, 0,
                                  heading.y, side.y, 0,
                                  Tx,        Ty,     0);

        return Matrix3f.transform(m, point);
    }

    public static Vector2f VectorToLocalSpace(Vector2f v, Vector2f heading, Vector2f side) {
        Matrix3f m = new Matrix3f(heading.x, side.x, 0,
                                  heading.y, side.y, 0,
                                  0,         0,      0);

        return Matrix3f.transform(m, v);
    }

    public static float deg2rad(float deg) {
        return deg * (PI / 180);
    }

    public static float rad2deg(float rad) {
        return (rad / PI) * 180;
    }
}
