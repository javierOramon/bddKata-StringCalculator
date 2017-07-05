package oramon.saiyans.stringcalculator.calculate;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class NumbersExtractorTest {

    private NumbersExtractor extractor;

    @Before
    public void setUp(){
        this.extractor = new NumbersExtractor();
    }

    @Test
    public void extractWithSubstractOperationAndNegativeNumbers(){
        //Arrange
        Collection<Double> numbers = Arrays.asList(-2d, 3d);
        //Act
        Collection<Double> resultNumbers = extractor.extract("-2 - 3", "-");
        //Assert
        assertEquals("Numbers haven't been processed", numbers, resultNumbers);
    }

}