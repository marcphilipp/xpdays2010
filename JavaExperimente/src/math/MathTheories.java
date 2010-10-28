package math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.pholser.junit.parameters.ForAll;

@RunWith(Theories.class)
public class MathTheories {

    @Theory
    public void absoluteValueOfNegatives(@ForAll int n) {
        System.out.println(n);
        assumeTrue(n < 0);
        assertEquals(-n, Math.abs(n));
    }
}
