package flatlab.util;

import org.junit.Test;
import static org.junit.Assert.*;

// a bunch of magic numbers, thanks wolframalpha
public class Vector2fTest {
    public static float delta = 0.00001f;

    // Vector addition
    @Test
    public void TestVector2f_Add_VectorWithVector() {
        Vector2f v1 = new Vector2f(1, 2);
        Vector2f v2 = new Vector2f(3, 4);

        Vector2f result = Vector2f.add(v1, v2);

        assertEquals(v1.x + v2.x, result.x, delta);
        assertEquals(v1.y + v2.y, result.y, delta);
    }

    @Test
    public void TestVector2f_Add_NegativeVectorWithNegativeVector() {
        Vector2f v1 = new Vector2f(-1, -2);
        Vector2f v2 = new Vector2f(-3, -4);

        Vector2f result = Vector2f.add(v1, v2);

        assertEquals(v1.x + v2.x, result.x, delta);
        assertEquals(v1.y + v2.y, result.y, delta);
    }

    @Test
    public void TestVector2f_Add_MixedVectorWithMixedVector() {
        Vector2f v1 = new Vector2f(-1, 2);
        Vector2f v2 = new Vector2f(3, -4);

        Vector2f result = Vector2f.add(v1, v2);

        assertEquals(v1.x + v2.x, result.x, delta);
        assertEquals(v1.y + v2.y, result.y, delta);
    }

    @Test
    public void TestVector2f_Add_VectorWithScalar() {
        Vector2f v = new Vector2f(1, 2);
        float scalar = 5;

        Vector2f result = Vector2f.add(v, scalar);

        assertEquals(v.x + scalar, result.x, delta);
        assertEquals(v.y + scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Add_VectorWithNegativeScalar() {
        Vector2f v = new Vector2f(1, 2);
        float scalar= -5;

        Vector2f result = Vector2f.add(v, scalar);

        assertEquals(v.x + scalar, result.x, delta);
        assertEquals(v.y + scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Add_NegativeVectorWithScalar() {
        Vector2f v = new Vector2f(-1, -2);
        float scalar = 5;

        Vector2f result = Vector2f.add(v, scalar);

        assertEquals(v.x + scalar, result.x, delta);
        assertEquals(v.y + scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Add_NegativeVectorWithNegativeScalar() {
        Vector2f v = new Vector2f(-1, -2);
        float scalar= -5;

        Vector2f result = Vector2f.add(v, scalar);

        assertEquals(v.x + scalar, result.x, delta);
        assertEquals(v.y + scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Add_MixedVectorWithScalar() {
        Vector2f v = new Vector2f(1, -2);
        float scalar = 5;

        Vector2f result = Vector2f.add(v, scalar);

        assertEquals(v.x + scalar, result.x, delta);
        assertEquals(v.y + scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Add_MixedVectorWithNegativeScalar() {
        Vector2f v = new Vector2f(-1, 2);
        float scalar= -5;

        Vector2f result = Vector2f.add(v, scalar);

        assertEquals(v.x + scalar, result.x, delta);
        assertEquals(v.y + scalar, result.y, delta);
    }

    // Vector subtraction
    @Test
    public void TestVector2f_Sub_VectorWithVector() {
        Vector2f v1 = new Vector2f(1, 2);
        Vector2f v2 = new Vector2f(3, 4);

        Vector2f result = Vector2f.sub(v1, v2);

        assertEquals(v1.x - v2.x, result.x, delta);
        assertEquals(v1.y - v2.y, result.y, delta);
    }

    @Test
    public void TestVector2f_Sub_NegativeVectorWithNegativeVector() {
        Vector2f v1 = new Vector2f(-1, -2);
        Vector2f v2 = new Vector2f(-3, -4);

        Vector2f result = Vector2f.sub(v1, v2);

        assertEquals(v1.x - v2.x, result.x, delta);
        assertEquals(v1.y - v2.y, result.y, delta);
    }

    @Test
    public void TestVector2f_Sub_MixedVectorWithMixedVector() {
        Vector2f v1 = new Vector2f(-1, 2);
        Vector2f v2 = new Vector2f(3, -4);

        Vector2f result = Vector2f.sub(v1, v2);

        assertEquals(v1.x - v2.x, result.x, delta);
        assertEquals(v1.y - v2.y, result.y, delta);
    }

    @Test
    public void TestVector2f_Sub_VectorWithScalar() {
        Vector2f v = new Vector2f(1, 2);
        float scalar = 5;

        Vector2f result = Vector2f.sub(v, scalar);

        assertEquals(v.x - scalar, result.x, delta);
        assertEquals(v.y - scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Sub_VectorWithNegativeScalar() {
        Vector2f v = new Vector2f(1, 2);
        float scalar= -5;

        Vector2f result = Vector2f.sub(v, scalar);

        assertEquals(v.x - scalar, result.x, delta);
        assertEquals(v.y - scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Sub_NegativeVectorWithScalar() {
        Vector2f v = new Vector2f(-1, -2);
        float scalar = 5;

        Vector2f result = Vector2f.sub(v, scalar);

        assertEquals(v.x - scalar, result.x, delta);
        assertEquals(v.y - scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Sub_NegativeVectorWithNegativeScalar() {
        Vector2f v = new Vector2f(-1, -2);
        float scalar= -5;

        Vector2f result = Vector2f.sub(v, scalar);

        assertEquals(v.x - scalar, result.x, delta);
        assertEquals(v.y - scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Sub_MixedVectorWithScalar() {
        Vector2f v = new Vector2f(1, -2);
        float scalar = 5;

        Vector2f result = Vector2f.sub(v, scalar);

        assertEquals(v.x - scalar, result.x, delta);
        assertEquals(v.y - scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Sub_MixedVectorWithNegativeScalar() {
        Vector2f v = new Vector2f(-1, 2);
        float scalar= -5;

        Vector2f result = Vector2f.sub(v, scalar);

        assertEquals(v.x - scalar, result.x, delta);
        assertEquals(v.y - scalar, result.y, delta);
    }

    // Vector multiplication
    @Test
    public void TestVector2f_Mul_VectorWithScalar() {
        Vector2f v = new Vector2f(1, 2);
        float scalar= 5;

        Vector2f result = Vector2f.mul(v, scalar);

        assertEquals(v.x * scalar, result.x, delta);
        assertEquals(v.y * scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Mul_NegativeVectorWithScalar() {
        Vector2f v = new Vector2f(-1, -2);
        float scalar= 5;

        Vector2f result = Vector2f.mul(v, scalar);

        assertEquals(v.x * scalar, result.x, delta);
        assertEquals(v.y * scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Mul_MixedVectorWithScalar() {
        Vector2f v = new Vector2f(-1, 2);
        float scalar= 5;

        Vector2f result = Vector2f.mul(v, scalar);

        assertEquals(v.x * scalar, result.x, delta);
        assertEquals(v.y * scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Mul_VectorWithNegativeScalar() {
        Vector2f v = new Vector2f(1, 2);
        float scalar= -5;

        Vector2f result = Vector2f.mul(v, scalar);

        assertEquals(v.x * scalar, result.x, delta);
        assertEquals(v.y * scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Mul_NegativeVectorWithNegativeScalar() {
        Vector2f v = new Vector2f(-1, -2);
        float scalar= -5;

        Vector2f result = Vector2f.mul(v, scalar);

        assertEquals(v.x * scalar, result.x, delta);
        assertEquals(v.y * scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Mul_MixedVectorWithNegativeScalar() {
        Vector2f v = new Vector2f(-1, 2);
        float scalar= -5;

        Vector2f result = Vector2f.mul(v, scalar);

        assertEquals(v.x * scalar, result.x, delta);
        assertEquals(v.y * scalar, result.y, delta);
    }

    // Vector division
    @Test
    public void TestVector2f_Div_VectorWithScalar() {
        Vector2f v = new Vector2f(1, 2);
        float scalar= 5;

        Vector2f result = Vector2f.div(v, scalar);

        assertEquals(v.x / scalar, result.x, delta);
        assertEquals(v.y / scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Div_NegativeVectorWithScalar() {
        Vector2f v = new Vector2f(-1, -2);
        float scalar= 5;

        Vector2f result = Vector2f.div(v, scalar);

        assertEquals(v.x / scalar, result.x, delta);
        assertEquals(v.y / scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Div_MixedVectorWithScalar() {
        Vector2f v = new Vector2f(-1, 2);
        float scalar= 5;

        Vector2f result = Vector2f.div(v, scalar);

        assertEquals(v.x / scalar, result.x, delta);
        assertEquals(v.y / scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Div_VectorWithNegativeScalar() {
        Vector2f v = new Vector2f(1, 2);
        float scalar= -5;

        Vector2f result = Vector2f.div(v, scalar);

        assertEquals(v.x / scalar, result.x, delta);
        assertEquals(v.y / scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Div_NegativeVectorWithNegativeScalar() {
        Vector2f v = new Vector2f(-1, -2);
        float scalar= -5;

        Vector2f result = Vector2f.div(v, scalar);

        assertEquals(v.x / scalar, result.x, delta);
        assertEquals(v.y / scalar, result.y, delta);
    }

    @Test
    public void TestVector2f_Div_MixedVectorWithNegativeScalar() {
        Vector2f v = new Vector2f(-1, 2);
        float scalar= -5;

        Vector2f result = Vector2f.div(v, scalar);

        assertEquals(v.x / scalar, result.x, delta);
        assertEquals(v.y / scalar, result.y, delta);
    }

    // Vector length
    @Test
    public void TestVector2f_length_Vector() {
        Vector2f v = new Vector2f(12, 34);

        float result = Vector2f.length(v);

        assertEquals(36.05551f, result, delta);
    }

    @Test
    public void TestVector2f_length_NegativeVector() {
        Vector2f v = new Vector2f(-56, -78);

        float result = Vector2f.length(v);

        assertEquals(96.02083f, result, delta);
    }

    @Test
    public void TestVector2f_length_MixedVector() {
        Vector2f v = new Vector2f(-91, 12);

        float result = Vector2f.length(v);

        assertEquals(91.78779f, result, delta);
    }

    // Vector squared length
    @Test
    public void TestVector2f_lengthSq_Vector() {
        Vector2f v = new Vector2f(12, 34);

        float result = Vector2f.lengthSq(v);

        assertEquals(1300, result, delta);
    }

    @Test
    public void TestVector2f_lengthSq_NegativeVector() {
        Vector2f v = new Vector2f(-56, -78);

        float result = Vector2f.lengthSq(v);

        assertEquals(9220, result, delta);
    }

    @Test
    public void TestVector2f_lengthSq_MixedVector() {
        Vector2f v = new Vector2f(-91, 12);

        float result = Vector2f.lengthSq(v);

        assertEquals(8425, result, delta);
    }

    // Vector normalization
    @Test
    public void TestVector2f_Normalize_Vector() {
        Vector2f v = new Vector2f(12, 34);

        Vector2f result = Vector2f.normalize(v);

        assertEquals(0.33282f, result.x, delta);
        assertEquals(0.94299f, result.y, delta);
    }

    @Test
    public void TestVector2f_Normalize_NegativeVector() {
        Vector2f v = new Vector2f(-56, -78);

        Vector2f result = Vector2f.normalize(v);

        assertEquals(-0.583207f, result.x, delta);
        assertEquals(-0.812324f, result.y, delta);
    }

    @Test
    public void TestVector2f_Normalize_MixedVector() {
        Vector2f v = new Vector2f(-91, 12);

        Vector2f result = Vector2f.normalize(v);

        assertEquals(-0.991417f, result.x, delta);
        assertEquals(0.130736f, result.y, delta);
    }

    // Vector truncation
    @Test
    public void TestVector2f_Truncate_ShorterVector() {
        Vector2f v = new Vector2f(12, 34);

        Vector2f result = Vector2f.truncate(v, 40);
        float len = Vector2f.length(result);

        assertEquals(36.05551f, len, delta);
    }

    @Test
    public void TestVector2f_Truncate_Vector() {
        Vector2f v = new Vector2f(12, 34);

        Vector2f result = Vector2f.truncate(v, 10);
        float len = Vector2f.length(result);

        assertTrue(len <= 10 + delta);
    }

    @Test
    public void TestVector2f_Truncate_NegativeVector() {
        Vector2f v = new Vector2f(-56, -78);

        Vector2f result = Vector2f.truncate(v, 30);
        float len = Vector2f.length(result);

        assertTrue(len <= 30 + delta);
    }

    @Test
    public void TestVector2f_Truncate_MixedVector() {
        Vector2f v = new Vector2f(-91, 12);

        Vector2f result = Vector2f.truncate(v, 40);
        float len = Vector2f.length(result);

        assertTrue(len <= 40 + delta);
    }

    // Vector dot product
    @Test
    public void TestVector2f_Dot_Vectors() {
        Vector2f v1 = new Vector2f(12, 34);
        Vector2f v2 = new Vector2f(56, 78);

        float result = Vector2f.dot(v1, v2);

        assertEquals(3324, result, delta);
    }

    @Test
    public void TestVector2f_Dot_NegativeVectors() {
        Vector2f v1 = new Vector2f(-12, -34);
        Vector2f v2 = new Vector2f(-56, -78);

        float result = Vector2f.dot(v1, v2);

        assertEquals(3324, result, delta);
    }

    @Test
    public void TestVector2f_Dot_ofMixedVectors() {
        Vector2f v1 = new Vector2f(-12, 34);
        Vector2f v2 = new Vector2f(56, 78);

        float result = Vector2f.dot(v1, v2);

        assertEquals(1980, result, delta);
    }

    // Vector perpendicular
    @Test
    public void TestVector2f_Perp_Vector() {
        Vector2f v = new Vector2f(12, 34);

        Vector2f result = Vector2f.perp(v);
        float d = Vector2f.dot(v, result);

        assertEquals(0, d, delta);
    }

    @Test
    public void TestVector2f_Perp_NegativeVector() {
        Vector2f v = new Vector2f(-12, -34);

        Vector2f result = Vector2f.perp(v);
        float d = Vector2f.dot(v, result);

        assertEquals(0, d, delta);
    }

    @Test
    public void TestVector2f_Perp_MixedVector() {
        Vector2f v = new Vector2f(12, -34);

        Vector2f result = Vector2f.perp(v);
        float d = Vector2f.dot(v, result);

        assertEquals(0, d, delta);
    }

    // Vector perpendicular dot product
    @Test
    public void TestVector2f_PerpDot_Vector() {
    }

    @Test
    public void TestVector2f_PerpDot_NegativeVector() {
    }

    @Test
    public void TestVector2f_PerpDot_MixedVector() {
    }


    // Vector distance
    @Test
    public void TestVector2f_Distance_Vectors() {
        Vector2f v1 = new Vector2f(12,34);
        Vector2f v2 = new Vector2f(56,78);

        float d = Vector2f.distance(v1,v2);

        assertEquals(62.2254f, d, delta);
    }

    @Test
    public void TestVector2f_Distance_NegativeVectors() {
        Vector2f v1 = new Vector2f(-9,-10);
        Vector2f v2 = new Vector2f(-11,-12);

        float d = Vector2f.distance(v1,v2);

        assertEquals(2.82843f, d, delta);
    }

    @Test
    public void TestVector2f_Distance_MixedVectors() {
        Vector2f v1 = new Vector2f(-12,34);
        Vector2f v2 = new Vector2f(56,-78);

        float d = Vector2f.distance(v1,v2);

        assertEquals(131.026714f, d, delta);
    }

    // Vector squared distance
    @Test
    public void TestVector2f_DistanceSq_Vectors() {
        Vector2f v1 = new Vector2f(12,34);
        Vector2f v2 = new Vector2f(56,78);

        float d = Vector2f.distanceSq(v1,v2);
        float dd = Vector2f.distance(v1,v2);

        assertEquals(dd*dd, d, delta*100);
    }

    @Test
    public void TestVector2f_DistanceSq_NegativeVectors() {
        Vector2f v1 = new Vector2f(-12,-34);
        Vector2f v2 = new Vector2f(-56,-78);

        float d = Vector2f.distanceSq(v1,v2);
        float dd = Vector2f.distance(v1,v2);

        assertEquals(dd*dd, d, delta*100);
    }

    @Test
    public void TestVector2f_DistanceSq_MixedVectors() {
        Vector2f v1 = new Vector2f(12,-34);
        Vector2f v2 = new Vector2f(-56,78);

        float d = Vector2f.distanceSq(v1,v2);
        float dd = Vector2f.distance(v1,v2);

        assertEquals(dd*dd, d, delta*100);
    }

    // Vector reversal
    @Test
    public void TestVector2f_Reverse_Vector() {
        Vector2f v = new Vector2f(12,34);

        Vector2f r = Vector2f.reverse(v);

        assertTrue(Vector2f.is_parallel(v,r));

        r = Vector2f.reverse(r);

        assertEquals(v.x, r.x, delta);
        assertEquals(v.y, r.y, delta);
    }

    @Test
    public void TestVector2f_Reverse_NegativeVector() {
        Vector2f v = new Vector2f(-12,-34);

        Vector2f r = Vector2f.reverse(v);

        assertTrue(Vector2f.is_parallel(v,r));

        r = Vector2f.reverse(r);

        assertEquals(v.x, r.x, delta);
        assertEquals(v.y, r.y, delta);
    }

    @Test
    public void TestVector2f_Reverse_MixedVector() {
        Vector2f v = new Vector2f(12,-34);

        Vector2f r = Vector2f.reverse(v);

        assertTrue(Vector2f.is_parallel(v,r));

        r = Vector2f.reverse(r);

        assertEquals(v.x, r.x, delta);
        assertEquals(v.y, r.y, delta);
    }

    // Vector reflection
    @Test
    public void TestVector2f_Reflect_Vector() {
        
    }

    @Test
    public void TestVector2f_Reflect_NegativeVector() {
    }

    @Test
    public void TestVector2f_Reflect_MixedVector() {
    }

    // Vector angle
    @Test
    public void TestVector2f_Angle_Vectors() {
        Vector2f v1 = new Vector2f(0, 1);
        Vector2f v2 = new Vector2f(1, 0);

        float a = Vector2f.angle(v1, v2);

        a = Flatmath.rad2deg(a);

        assertEquals(90, a, delta);
    }

    @Test
    public void TestVector2f_Angle_NegativeVectors() {
        Vector2f v1 = new Vector2f(-1, -1);
        Vector2f v2 = new Vector2f(-1, -1);

        float a = Vector2f.angle(v1, v2);

        a = Flatmath.rad2deg(a);

        assertEquals(0, a, delta);
    }

    @Test
    public void TestVector2f_Angle_MixedVectors() {
        Vector2f v1 = new Vector2f(-1, 0);
        Vector2f v2 = new Vector2f(1, 0);

        float a = Vector2f.angle(v1, v2);
        a = Flatmath.rad2deg(a);

        assertEquals(180, a, delta);
    }

    // Vector is_perp
    @Test
    public void TestVector2f_IsPerp_PerpVectors() {
        Vector2f v1 = new Vector2f(1, 0);
        Vector2f v2 = new Vector2f(0, 1);

        boolean b = Vector2f.is_perp(v1, v2);

        assertTrue(b);
    }

    @Test
    public void TestVector2f_IsPerp_NonPerpVectors() {
        Vector2f v1 = new Vector2f(1, 0);
        Vector2f v2 = new Vector2f(1, 1);

        boolean b = Vector2f.is_perp(v1, v2);

        assertFalse(b);
    }

    // Vector is_parallel
    @Test
    public void TestVector2f_IsParallel_ParallelVectors() {
        Vector2f v1 = new Vector2f(1, 2);
        Vector2f v2 = new Vector2f(-33, -66);

        boolean b = Vector2f.is_parallel(v1, v2);

        assertTrue(b);
    }

    @Test
    public void TestVector2f_IsParallel_NonParallelVectors() {
        Vector2f v1 = new Vector2f(1, 1);
        Vector2f v2 = new Vector2f(33, 15);

        boolean b = Vector2f.is_parallel(v1, v2);

        assertFalse(b);
    }
}
