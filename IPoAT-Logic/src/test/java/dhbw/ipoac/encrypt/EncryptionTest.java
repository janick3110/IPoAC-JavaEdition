package dhbw.ipoac.encrypt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EncryptionTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void doEncryption() {

        String teststring = "Peter Pettigrew";
        String result;

        result = Encryption.doEncryption(teststring);
        result = Encryption.doDecrypting(result);



    }

    @Test
    public void doDecrypting() {
    }
}