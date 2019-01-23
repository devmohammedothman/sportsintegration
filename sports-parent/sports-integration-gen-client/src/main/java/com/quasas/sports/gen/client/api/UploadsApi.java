package com.quasas.sports.gen.client.api;

import com.quasas.sports.gen.client.invoker.ApiClient;

import com.quasas.sports.gen.client.model.Fault;
import java.io.File;
import com.quasas.sports.gen.client.model.Upload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-20T18:02:14.787+02:00")
@Component("com.quasas.sports.gen.client.api.UploadsApi")
public class UploadsApi {
    private ApiClient apiClient;

    public UploadsApi() {
        this(new ApiClient());
    }

    @Autowired
    public UploadsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Upload Activity
     * Uploads a new data file to create an activity from. Requires activity:write scope.
     * <p><b>201</b> - A representation of the created upload.
     * <p><b>0</b> - Unexpected error.
     * @param file The uploaded file.
     * @param name The desired name of the resulting activity.
     * @param description The desired description of the resulting activity.
     * @param trainer Whether the resulting activity should be marked as having been performed on a trainer.
     * @param commute Whether the resulting activity should be tagged as a commute.
     * @param dataType The format of the uploaded file.
     * @param externalId The desired external identifier of the resulting activity.
     * @return Upload
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Upload createUpload(File file, String name, String description, String trainer, String commute, String dataType, String externalId) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/uploads").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        if (file != null)
            formParams.add("file", new FileSystemResource(file));
        if (name != null)
            formParams.add("name", name);
        if (description != null)
            formParams.add("description", description);
        if (trainer != null)
            formParams.add("trainer", trainer);
        if (commute != null)
            formParams.add("commute", commute);
        if (dataType != null)
            formParams.add("data_type", dataType);
        if (externalId != null)
            formParams.add("external_id", externalId);

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "multipart/form-data"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "strava_oauth" };

        ParameterizedTypeReference<Upload> returnType = new ParameterizedTypeReference<Upload>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get Upload
     * Returns an upload for a given identifier. Requires activity:write scope.
     * <p><b>200</b> - Representation of the upload.
     * <p><b>0</b> - Unexpected error.
     * @param uploadId The identifier of the upload.
     * @return Upload
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Upload getUploadById(Long uploadId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'uploadId' is set
        if (uploadId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'uploadId' when calling getUploadById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("uploadId", uploadId);
        String path = UriComponentsBuilder.fromPath("/uploads/{uploadId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "strava_oauth" };

        ParameterizedTypeReference<Upload> returnType = new ParameterizedTypeReference<Upload>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
