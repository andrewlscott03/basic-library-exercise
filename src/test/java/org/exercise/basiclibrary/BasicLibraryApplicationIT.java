package org.exercise.basiclibrary;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.basiclibrary.rest.model.Loans;
import org.exercise.basiclibrary.app.BasicLibraryApplication;
import org.exercise.basiclibrary.utils.AssertUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BasicLibraryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicLibraryApplicationIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }
    
    @Test
    public void getLoans() throws Exception {
    	
    	String expectedJson = readResource("org/exercise/basiclibrary/basiclibraryapplicationit/getLoans.expected.json");
        ResponseEntity<String> response = template.getForEntity(base.toString() + "loansJson?borrowerId=B00000001",
                String.class);
        ObjectMapper mapper = new ObjectMapper();
        Loans expectedLoans = mapper.readValue(expectedJson, Loans.class);
        Loans actualLoans = mapper.readValue(response.getBody(), Loans.class);
        AssertUtils.assertEquals("", expectedLoans, actualLoans);
    }
    
	@Test
	public void contextLoads() {
	}
	
	private String readResource(final String resourceName) throws IOException {
		
		try (InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceName)) {
			String contents = IOUtils.toString(inStream, "UTF-8");
			contents.replaceAll("\\n", "").replaceAll("\\r", "");
			return contents;
		}
	}
}
