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
        return (float) Math.sqrt(Vector2f.dot(v, v));
    }
    public static Vector2f normalize(Vector2f v) {
        float len = length(v);
        return new Vector2f(v.x / len, v.y / len);
    }
    public static Vector2f truncate(Vector2f v, float max) {
        if(Vector2f.length(v) > max)
            return Vector2f.mul(Vector2f.normalize(v), max);

        return v;
    }
    public static float dot(Vector2f a, Vector2f b) {
        return (a.x * b.x) + (a.y * b.y);
    }
    public static Vector2f cross(Vector2f v) {
        return new Vector2f(v.x, -v.y);
    }
    public static float distance(Vector2f a, Vector2f b) {
        return (float) Math.sqrt(((b.x - a.x) * (b.x - a.x)) + ((b.y - a.y) * (b.y - a.y)));
    }
}
