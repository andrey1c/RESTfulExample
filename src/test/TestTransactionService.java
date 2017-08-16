import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrey on 15.08.2017.
 */
public class TestTransactionService {
    @Test
    public void test_doTransaction() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:7070/doTrans");
        //positive
        String json = "{\t    \"userSenderId\": 1,\n" +
                "      \"userReciverId\": 2,\n" +
                "      \"accountSenderId\": 1,\n" +
                "      \"accountReciverId\": 2,\n" +
                "      \"amount\":5\n" +
                "}";
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        assertEquals( HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
        //negative test
        json = "{\t    \"userSenderId\": 1,\n" +
                "      \"userReciverId\": 2,\n" +
                "      \"accountSenderId\": 1,\n" +
                "      \"accountReciverId\": 2,\n" +
                "      \"amount\":555\n" +
                "}";
        entity = new StringEntity(json);
        httpPost.setEntity(entity);
        response = client.execute(httpPost);
        assertEquals( HttpStatus.SC_INTERNAL_SERVER_ERROR, response.getStatusLine().getStatusCode());
        client.close();
    }
}
