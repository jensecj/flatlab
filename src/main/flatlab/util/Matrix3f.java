package flatlab.util;

import java.lang.Math;

public class Matrix3f {
    public final static Matrix3f identity = new Matrix3f(1, 0, 0,
                                                         0, 1, 0,
                                                         0, 0, 1);

    public final static Matrix3f zero = new Matrix3f(0, 0, 0,
                                                     0, 0, 0,
                                                     0, 0, 0);

    public float _11, _12, _13;
    public float _21, _22, _23;
    public float _31, _32, _33;

    public static boolean eq(Matrix3f m1, Matrix3f m2)  {
        return m1._11 == m2._11 &&
            m1._12 == m2._12 &&
            m1._13 == m2._13 &&
            m1._21 == m2._21 &&
            m1._22 == m2._22 &&
            m1._23 == m2._23 &&
            m1._31 == m2._31 &&
            m1._32 == m2._32 &&
            m1._33 == m2._33;
    }

    public Matrix3f(float _11, float _12, float _13,
                    float _21, float _22, float _23,
                    float _31, float _32, float _33) {
        this._11 = _11;
        this._12 = _12;
        this._13 = _13;
        this._21 = _21;
        this._22 = _22;
        this._23 = _23;
        this._31 = _31;
        this._32 = _32;
        this._33 = _33;
    }

    public static Matrix3f mul(Matrix3f m1, Matrix3f m2) {
        return new Matrix3f((m1._11 * m2._11) + (m1._12 * m2._21) + (m1._13 * m2._31),
                            (m1._11 * m2._12) + (m1._12 * m2._22) + (m1._13 * m2._32),
                            (m1._11 * m2._13) + (m1._12 * m2._23) + (m1._13 * m2._33),

                            (m1._21 * m2._11) + (m1._22 * m2._21) + (m1._23 * m2._31),
                            (m1._21 * m2._12) + (m1._22 * m2._22) + (m1._23 * m2._32),
                            (m1._21 * m2._13) + (m1._22 * m2._23) + (m1._23 * m2._33),

                            (m1._31 * m2._11) + (m1._32 * m2._21) + (m1._33 * m2._31),
                            (m1._31 * m2._12) + (m1._32 * m2._22) + (m1._33 * m2._32),
                            (m1._31 * m2._13) + (m1._32 * m2._23) + (m1._33 * m2._33));
    }

    public static Matrix3f translate(Matrix3f m, Vector2f v) {
        Matrix3f mat = new Matrix3f(1,   0,   0,
                                    0,   1,   0,
                                    v.x, v.y, 1);

        return mul(m, mat);
    }

    public static Vector2f transform(Matrix3f m, Vector2f v) {
        return new Vector2f((m._11 * v.x) + (m._21 * v.y) + (m._31),
                            (m._12 * v.x) + (m._22 * v.y) + (m._32));
    }

    public static Matrix3f scale(Matrix3f m, Vector2f v) {
        Matrix3f mat = new Matrix3f(v.x, 0,   0,
                                    0,   v.y, 0,
                                    0,   0,   1);

        return mul(m, mat);
    }

    public static Matrix3f rotate(Matrix3f m, float rotation) {
        float s = (float)Math.sin(rotation);
        float c = (float)Math.cos(rotation);

        Matrix3f mat = new Matrix3f(c,  s, 0,
                                    -s, c, 0,
                                    0,  0, 1);

        return mul(m, mat);
    }

    public static Matrix3f rotate(Matrix3f m, Vector2f forward, Vector2f side) {
        Matrix3f mat = new Matrix3f(forward.x, forward.y, 0,
                                    side.x,    side.y,    0,
                                    0,         0,         1);

        return mul(m, mat);
    }
}
