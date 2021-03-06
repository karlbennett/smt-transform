package shiver.me.timbers.transform.composite;

import org.junit.Before;
import org.junit.Test;
import shiver.me.timbers.transform.Transformation;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static shiver.me.timbers.transform.FileUtils.testFile;
import static shiver.me.timbers.transform.FileUtils.testFileText;
import static shiver.me.timbers.transform.TransformationTestUtils.EMPTY_TRANSFORMATIONS;

public class NullCompositeFileTransformerTest {

    private static final String TEST_STRING = testFileText();

    private File file;

    @Before
    public void setUp() {

        file = testFile();
    }

    @Test
    public void testCreate() {

        new NullCompositeFileTransformer<Transformation>(EMPTY_TRANSFORMATIONS);
    }

    @Test(expected = AssertionError.class)
    public void testWithNullTransformations() {

        new NullCompositeFileTransformer<Transformation>(null);
    }

    @Test
    public void testTransformWithFileAndNullTransformations() {

        assertEquals("the input string should be returned.", TEST_STRING,
                new NullCompositeFileTransformer<Transformation>(EMPTY_TRANSFORMATIONS).transform(file, null));
    }

    @Test
    public void testTransformWithNullFileAndTransformations() {

        assertNull("null should be returned.",
                new NullCompositeFileTransformer<Transformation>(EMPTY_TRANSFORMATIONS).transform(null, null));
    }

    @Test
    public void testTransformWithFile() {

        assertEquals("the input string should be returned.", TEST_STRING,
                new NullCompositeFileTransformer<Transformation>(EMPTY_TRANSFORMATIONS).transform(file));
    }

    @Test
    public void testTransformWithNullFile() {

        assertNull("null should be returned.",
                new NullCompositeFileTransformer<Transformation>(EMPTY_TRANSFORMATIONS).transform(null));
    }
}
