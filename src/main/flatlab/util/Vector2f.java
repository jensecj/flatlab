package flatlab.util;

import java.lang.Math;

public class Vector2f {
    public static Vector2f zero = new Vector2f(0, 0);

    public float x;
    public float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f(Vector2f v) {
        this.x = v.x;
        this.y = v.y;
    }

    public static Vector2f add(Vector2f a, Vector2f b) {
        return new Vector2f(a.x + b.x, a.y + b.y);
    }
    public static Vector2f add(Vector2f v, float scalar) {
        return new Vector2f(v.x + scalar, v.y + scalar);
    }
    public static Vector2f sub(Vector2f a, Vector2f b) {
        return new Vector2f(a.x - b.x, a.y - b.y);
    }
    public static Vector2f sub(Vector2f a, float scalar) {
        return new Vector2f(a.x - scalar, a.y - scalar);
    }
    public static Vector2f mul(Vector2f a, float scalar) {
        return new Vector2f(a.x * scalar, a.y * scalar);
    }
    public static Vector2f div(Vector2f a, float scalar) {
        return new Vector2f(a.x / scalar, a.y / scalar);
    }
    public static float length(Vector2f v) {
        return (float) Math.sqrt(dot(v, v));
    }
    public static float lengthSq(Vector2f v) {
        return dot(v, v);
    }
    public static Vector2f normalize(Vector2f v) {
        float len = length(v);
        return new Vector2f(v.x / len, v.y / len);
    }
    public static Vector2f truncate(Vector2f v, float max) {
        if(length(v) > max)
            return mul(normalize(v), max);

        return v;
    }
    public static float dot(Vector2f a, Vector2f b) {
        return (a.x * b.x) + (a.y * b.y);
    }
    public static Vector2f perp(Vector2f v) {
        return new Vector2f(-v.y, v.x);
    }
    public static float perpdot(Vector2f v1, Vector2f v2) {
        return dot(perp(v1), v2);
        // return (v1.x * v2.y) - (v1.y * v2.x); // these are the same
    }
    public static float distance(Vector2f a, Vector2f b) {
        return (float) Math.sqrt(((b.x - a.x) * (b.x - a.x)) + ((b.y - a.y) * (b.y - a.y)));
    }
    public static float distanceSq(Vector2f a, Vector2f b) {
        return ((b.x - a.x) * (b.x - a.x)) + ((b.y - a.y) * (b.y - a.y));
    }
    public static boolean sign(Vector2f v1, Vector2f v2) {
        return v1.y * v2.x > v1.x * v2.y;
    }
    public static Vector2f reverse(Vector2f v) {
        return new Vector2f(-v.x, -v.y);
    }
    public static Vector2f reflect(Vector2f v1, Vector2f v2) {
        float angle = dot(v1, v2) * 2.0f;
        Vector2f rev = reverse(v2);

        return mul(rev, angle);
    }
    public static float angle(Vector2f v1, Vector2f v2) {
        return (float)-Math.atan2(perpdot(v1, v2), dot(v1, v2));
    }
    public static boolean is_perp(Vector2f v1, Vector2f v2) {
        return dot(v1, v2) == 0f;
    }
    public static boolean is_parallel(Vector2f v1, Vector2f v2) {
        return perpdot(v1, v2) == 0f;
        // float d = dot(v1, v2);
        // float ll = length(v1) * length(v2);
        // return d == ll;

        // return angle(v1, v2) == 0f;
    }

    public static boolean eq(Vector2f v1, Vector2f v2) {
        return v1.x == v2.x && v1.y == v2.y;
    }
}
