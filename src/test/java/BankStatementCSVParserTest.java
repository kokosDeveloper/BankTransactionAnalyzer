import org.example.parser.BankStatementCSVParser;
import org.example.parser.BankStatementParser;
import org.example.domen.BankTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;


public class BankStatementCSVParserTest {
    private final BankStatementParser parser = new BankStatementCSVParser();
    @Test
    public void shouldParseOneCorrectLine(){
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = parser.parseFrom(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, 01, 30), -50.0d, "Tesco");
        final double tolerance = 0.0d;

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }
}
