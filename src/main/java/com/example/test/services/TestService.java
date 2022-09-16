package com.example.test.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    private static final String CONTENT_TYPE_KEYWORD = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    public static final String GET_KEYWORD = "GET";
    public static final String POST_KEYWORD = "POST";
    public static final String PUT_KEYWORD = "PUT";
    public static final String DELETE_KEYWORD = "DELETE";
    public static final String PATCH_KEYWORD = "PATCH";

    public static String sendRequest(String url, String methodType, String body, int expectedStatus) {
        String responseBody = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpRequestBase httpRequest = getHttpRequestBase(methodType, url);
            if (httpRequest == null) {
                log.warn("The method type = {} isn't supported", methodType);
                return null;
            }
            httpRequest.setHeader(CONTENT_TYPE_KEYWORD, APPLICATION_JSON);
            if (body != null) {
                ((HttpEntityEnclosingRequestBase) httpRequest).setEntity(new StringEntity(body));
            }
            log.debug("Trying to call the {} API url={} Request body={}, expected status={}", methodType,
                    url, body, expectedStatus);
            CloseableHttpResponse response = httpClient.execute(httpRequest);
            if (response.getStatusLine().getStatusCode() == expectedStatus) {
                responseBody =
                        response.getEntity() == null ? null : EntityUtils.toString(response.getEntity());
            } else {
                log.warn("Unexpected response status while calling {} API, url={} Response status={}",
                        methodType, url, response.getStatusLine().getStatusCode());
            }
            response.close();
        } catch (Exception e) {
            log.error("Unable to call the endpoint {}: {}", url, e.getMessage());
        }
        return responseBody;
    }

    private static HttpRequestBase getHttpRequestBase(String methodType, String url) {
        switch (methodType) {
            case GET_KEYWORD:
                return new HttpGet(url);
            case POST_KEYWORD:
                return new HttpPost(url);
            case PUT_KEYWORD:
                return new HttpPut(url);
            case DELETE_KEYWORD:
                return new HttpDelete(url);
            case PATCH_KEYWORD:
                return new HttpPatch(url);
            default:
                return null;
        }
    }
}
