package com.quasas.sports.gen.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import com.quasas.sports.gen.client.invoker.ApiClient;
import com.quasas.sports.gen.client.model.StreamSet;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-20T18:02:14.787+02:00")
@Component("com.quasas.sports.gen.client.api.StreamsApi")
public class StreamsApi {
    private ApiClient apiClient;

    public StreamsApi() {
        this(new ApiClient());
    }

    @Autowired
    public StreamsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Activity Streams
     * Returns the given activity&#39;s streams. Requires activity:read scope. Requires activity:read_all scope for Only Me activities.
     * <p><b>200</b> - The set of requested streams.
     * <p><b>0</b> - Unexpected error.
     * @param id The identifier of the activity.
     * @param keys Desired stream types.
     * @param keyByType Must be true.
     * @return StreamSet
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StreamSet getActivityStreams(Long id, List<String> keys, Boolean keyByType) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getActivityStreams");
        }
        
        // verify the required parameter 'keys' is set
        if (keys == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keys' when calling getActivityStreams");
        }
        
        // verify the required parameter 'keyByType' is set
        if (keyByType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyByType' when calling getActivityStreams");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/activities/{id}/streams").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase()), "keys", keys));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "key_by_type", keyByType));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "strava_oauth" };

        ParameterizedTypeReference<StreamSet> returnType = new ParameterizedTypeReference<StreamSet>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get segment effort streams
     * Returns a set of streams for a segment effort completed by the authenticated athlete. Requires read_all scope.
     * <p><b>200</b> - The set of requested streams.
     * <p><b>0</b> - Unexpected error.
     * @param id The identifier of the segment effort.
     * @param keys The types of streams to return.
     * @param keyByType Must be true.
     * @return StreamSet
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StreamSet getSegmentEffortStreams(Long id, List<String> keys, Boolean keyByType) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getSegmentEffortStreams");
        }
        
        // verify the required parameter 'keys' is set
        if (keys == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keys' when calling getSegmentEffortStreams");
        }
        
        // verify the required parameter 'keyByType' is set
        if (keyByType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyByType' when calling getSegmentEffortStreams");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/segment_efforts/{id}/streams").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase()), "keys", keys));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "key_by_type", keyByType));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "strava_oauth" };

        ParameterizedTypeReference<StreamSet> returnType = new ParameterizedTypeReference<StreamSet>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get Segment Streams
     * Returns the given segment&#39;s streams. Requires read_all scope for private segments.
     * <p><b>200</b> - The set of requested streams.
     * <p><b>0</b> - Unexpected error.
     * @param id The identifier of the segment.
     * @param keys The types of streams to return.
     * @param keyByType Must be true.
     * @return StreamSet
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StreamSet getSegmentStreams(Long id, List<String> keys, Boolean keyByType) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getSegmentStreams");
        }
        
        // verify the required parameter 'keys' is set
        if (keys == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keys' when calling getSegmentStreams");
        }
        
        // verify the required parameter 'keyByType' is set
        if (keyByType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'keyByType' when calling getSegmentStreams");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/segments/{id}/streams").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("csv".toUpperCase()), "keys", keys));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "key_by_type", keyByType));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "strava_oauth" };

        ParameterizedTypeReference<StreamSet> returnType = new ParameterizedTypeReference<StreamSet>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
