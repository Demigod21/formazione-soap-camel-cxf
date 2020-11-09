package org.example.formazione.soapcamelcxf;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class SoapCodeFirstTest {

    private static final Logger LOG = LoggerFactory.getLogger(SoapCodeFirstTest.class);

    private static void copyInputStream(InputStream in, OutputStream out) throws Exception {
        int c = 0;
        try {
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            in.close();
        }
    }

    private static String getStringFromInputStream(InputStream in) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        copyInputStream(in, bos);
        bos.close();
        return bos.toString();
    }

    @Test
    public void sendRequest() throws Exception {

        String res;
        /*
         * Set up the URL connection to the web service address
         */
        URLConnection connection = new URL("http://localhost:8181/cxf/person").openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);

        /*
         * We have prepared a SOAP request in an XML file, so we send the contents of that file to our web service...
         */
        OutputStream os = connection.getOutputStream();
        InputStream fis = SoapCodeFirstTest.class.getResourceAsStream("/request.xml");
        copyInputStream(fis, os);

        /*
         * ... and afterwards, we just read the SOAP response message that is sent back by the server.
         */
        InputStream is = connection.getInputStream();
        LOG.info(String.valueOf(is));
        LOG.info("the response is ====> ");
        res = getStringFromInputStream(is);
        LOG.info(res);
        Assert.assertTrue(res.contains("COGNOME"));
    }
}
