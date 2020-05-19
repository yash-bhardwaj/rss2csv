package com.yash.gst.rssClient;

import com.yash.gst.rssClient.model.RssTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RssFeedClient {

    @Value("${com.eric.gst.rss.url}")
    private String rssFeederUrl;

    /**
     * The api template.
     */
    @Autowired
    private RestTemplate apiTemplate;

    public RssTag getNextAccreditedDate(final String gcid) {

        final UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString( rssFeederUrl );
//        urlBuilder.
        //final Map<String, String> urlParams = new HashMap<>();
        //urlParams.put("jobGroup", JobGroup.PENDING_TO_ACCREDITED_CONVERSION_JOB.toString());
        try {
            final ResponseEntity<RssTag> response =
                    apiTemplate.exchange(urlBuilder.build ().toUriString(), HttpMethod.GET,
                            RequestEntity.EMPTY, RssTag.class);
            if ( HttpStatus.OK.value() == response.getStatusCodeValue() && response.getBody() != null
                    && response.getBody() != null) {
                System.out.println("Success returned from scheduler");
                return response.getBody();
            } else {
                System.out.println("Failed to fetch date of conversion from scheduler with status code:{}" +
                        response.getStatusCodeValue());
                throw new RuntimeException ( "Unable to fetch" );
            }
        } catch (final RestClientException e) {
            System.out.println("Failed to connect to scheduler service:{}" + e);
            throw new RuntimeException ( e.getMessage () );
        }
    }
}
