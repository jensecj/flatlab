package flatlab.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class Matrix3fTest {

    @Test
    public void Matrix3fTest_add_WithZeroMatrix() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Matrix3f result = Matrix3f.add(m, Matrix3f.zero);

        assertTrue(Matrix3f.eq(result, m));
    }

    @Test
    public void Matrix3fTest_add_Matrices() {
        Matrix3f m1 = new Matrix3f(0, 1, 2,
                                   3, 4, 5,
                                   6, 7, 8);

        Matrix3f m2 = new Matrix3f(0, 1, 2,
                                   3, 4, 5,
                                   6, 7, 8);

        Matrix3f result = Matrix3f.add(m1, m2);

        Matrix3f expected = new Matrix3f(0, 2, 4,
                                         6, 8, 10,
                                         12, 14, 16);

        assertTrue(Matrix3f.eq(expected, result));
    }

    @Test
    public void Matrix3fTest_add_Zero() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Matrix3f result = Matrix3f.add(m, 0);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_add_Scalar() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Matrix3f result = Matrix3f.add(m, 7);

        Matrix3f expected = new Matrix3f(7, 8, 9,
                                         10, 11, 12,
                                         13, 14, 15);

        assertTrue(Matrix3f.eq(expected, result));
    }


    @Test
    public void Matrix3fTest_sub_WithZeroMatrix() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Matrix3f result = Matrix3f.sub(m, Matrix3f.zero);

        assertTrue(Matrix3f.eq(result, m));
    }

    @Test
    public void Matrix3fTest_sub_Matrices() {
        Matrix3f m1 = new Matrix3f(0, 1, 2,
                                   3, 4, 5,
                                   6, 7, 8);

        Matrix3f m2 = new Matrix3f(0, 1, 2,
                                   3, 4, 5,
                                   6, 7, 8);

        Matrix3f result = Matrix3f.sub(m1, m2);

        assertTrue(Matrix3f.eq(result, Matrix3f.zero));
    }

    @Test
    public void Matrix3fTest_sub_Zero() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Matrix3f result = Matrix3f.sub(m, 0);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_sub_Scalar() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Matrix3f result = Matrix3f.sub(m, 7);

        Matrix3f expected = new Matrix3f(-7, -6, -5,
                                         -4, -3, -2,
                                         -1, 0, 1);

        assertTrue(Matrix3f.eq(expected, result));
    }

    @Test
    public void Matrix3fTest_sum_ZeroMatrix() {
        Matrix3f m = Matrix3f.zero;

        float sum = Matrix3f.sum(m);

        assertEquals(0, sum, 0.0001f);
    }

    @Test
    public void Matrix3fTest_sum_Matrix() {
        Matrix3f m = new Matrix3f(1, 2, 3,
                                  4, 5, 6,
                                  7, 8, 9);

        float sum = Matrix3f.sum(m);

        assertEquals(45, sum, 0.0001f);
    }

    @Test
    public void Matrix3fTest_Mul_IdentityWithIdentity() {
        Matrix3f m1 = Matrix3f.identity;
        Matrix3f m2 = Matrix3f.identity;

        Matrix3f m = Matrix3f.mul(m1, m2);

        assertTrue(Matrix3f.eq(m, Matrix3f.identity));
    }

    @Test
    public void Matrix3fTest_Mul_WithZero() {
        Matrix3f m1 = new Matrix3f(0, 1, 2,
                                   3, 4, 5,
                                   6, 7, 8);

        Matrix3f m2 = Matrix3f.zero;

        Matrix3f m = Matrix3f.mul(m1, m2);

        assertTrue(Matrix3f.eq(m, Matrix3f.zero));
    }

    @Test
    public void Matrix3fTest_Mul_WithIdentity() {
        Matrix3f m1 = new Matrix3f(0, 1, 2,
                                   3, 4, 5,
                                   6, 7, 8);

        Matrix3f m2 = Matrix3f.identity;

        Matrix3f m = Matrix3f.mul(m1, m2);

        assertTrue(Matrix3f.eq(m, m1));
    }

    @Test
    public void Matrix3fTest_Mul_Matrices() {
        Matrix3f m1 = new Matrix3f(0, 1, 2,
                                   3, 4, 5,
                                   6, 7, 8);

        Matrix3f m2 = new Matrix3f(8,7,6,5,4,3,2,1,0);

        Matrix3f m = Matrix3f.mul(m1, m2);

        Matrix3f result = new Matrix3f(9, 6, 3,
                                       54, 42, 30,
                                       99, 78, 57);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_Mul_NegativeMatrices() {
        Matrix3f m1 = new Matrix3f(-1,-2,-3,-4,-5,-6,-7,-8,-9);
        Matrix3f m2 = new Matrix3f(-9,-8,-7,-6,-5,-4,-3,-2,-1);

        Matrix3f m = Matrix3f.mul(m1, m2);

        Matrix3f result = new Matrix3f(30, 24, 18,
                                       84, 69, 54,
                                       138, 114, 90);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_Mul_MixedMatrices() {
        Matrix3f m1 = new Matrix3f(-1, 2, -3, 4, -5, 6, -7, 8, -9);
        Matrix3f m2 = new Matrix3f(9, -8, 7, -6, 5, -4, 3, -2, 1);

        Matrix3f m = Matrix3f.mul(m1, m2);

        Matrix3f result = new Matrix3f(-30, 24, -18,
                                       84, -69, 54,
                                       -138, 114, -90);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_Mul_Scalar() {
        Matrix3f m1 = new Matrix3f(0, 1, 2,
                                   3, 4, 5,
                                   6, 7, 8);


        Matrix3f m = Matrix3f.mul(m1, 5);

        Matrix3f result = new Matrix3f(0, 5, 10,
                                       15, 20, 25,
                                       30, 35, 40);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_Mul_NegativeScalar() {
        Matrix3f m1 = new Matrix3f(-1,-2,-3,-4,-5,-6,-7,-8,-9);

        Matrix3f m = Matrix3f.mul(m1, -5);

        Matrix3f result = new Matrix3f(5, 10, 15,
                                       20, 25, 30,
                                       35, 40, 45);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_Transpose_Matrix() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Matrix3f result = Matrix3f.transpose(m);

        Matrix3f expected = new Matrix3f(0, 3, 6,
                                         1, 4, 7,
                                         2, 5, 8);

        assertTrue(Matrix3f.eq(result, expected));
    }

    @Test
    public void Matrix3fTest_Transpose_Identity() {
        Matrix3f m = Matrix3f.identity;

        Matrix3f result = Matrix3f.transpose(m);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_Transpose_Twice() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Matrix3f result = Matrix3f.transpose(m);
        result = Matrix3f.transpose(result);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_Translate_ByZero() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Vector2f v = Vector2f.zero;
        Matrix3f result = Matrix3f.translate(m, v);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_Translate_ByVector() {
        // todo
    }

    @Test
    public void Matrix3fTest_Transform_() {
        // todo
    }

    @Test
    public void Matrix3fTest_Scale_ByIdentity() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Vector2f v = Vector2f.one;
        Matrix3f result = Matrix3f.scale(m, v);

        assertTrue(Matrix3f.eq(m, result));
    }

    @Test
    public void Matrix3fTest_Scale_ByVector() {
        // todo
    }

    @Test
    public void Matrix3fTest_Rotate_ByZero() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Matrix3f result = Matrix3f.rotate(m, 0);

        assertTrue(Matrix3f.eq(result, m));
    }

    @Test
    public void Matrix3fTest_Rotate_ByTwoPi() {
        Matrix3f m = new Matrix3f(0, 1, 2,
                                  3, 4, 5,
                                  6, 7, 8);

        Matrix3f result = Matrix3f.rotate(m, Flatmath.PI * 2f);

        // calculate how far our result is from oru original
        Matrix3f error = Matrix3f.sub(result, m);
        float sum = Matrix3f.sum(error);

        assertEquals(0, sum, 0.0001f);
    }

    @Test
    public void Matrix3fTest_Rotate_ByCoordinateSystem() {
        // todo
    }

}
