package com.contentstack.sdk;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

class CSBackgroundTask {

    protected CSBackgroundTask() {
    }

    protected CSBackgroundTask(Stack stackInstance, String controller, String url, HashMap<String, Object> headers,
            HashMap<String, Object> urlParams, String requestInfo, ResultCallBack callback) {
        checkHeader(headers);
        String completeUrl = stackInstance.config.getEndpoint() + url;
        CSConnectionRequest csConnectionRequest = new CSConnectionRequest(stackInstance);
        csConnectionRequest.setStackInstance(stackInstance);
        // since some entries of urlParams and headers are being removed by official ContentStack design
        // so we have to keep a separate copy
        csConnectionRequest.setURLQueries(new HashMap<>(urlParams));
        csConnectionRequest.setParams(completeUrl, new LinkedHashMap<>((headers)), controller, requestInfo, callback);
        csConnectionRequest.sendRequest();
    }

    protected CSBackgroundTask(Query queryInstance, Stack stackInstance, String controller, String url,
            LinkedHashMap<String, Object> headers, HashMap<String, Object> urlQueries, String requestInfo,
            ResultCallBack callback) {
        checkHeader(headers);
        String completeUrl = stackInstance.config.getEndpoint() + url;
        CSConnectionRequest csConnectionRequest = new CSConnectionRequest(queryInstance);
        csConnectionRequest.setQueryInstance(queryInstance);
        // since some entries of urlParams and headers are being removed by official ContentStack design
        // so we have to keep a separate copy
        csConnectionRequest.setURLQueries(new HashMap<>(urlQueries));
        csConnectionRequest.setParams(completeUrl, new LinkedHashMap<>(headers), controller, requestInfo, callback);
        csConnectionRequest.sendRequest();
    }

    protected CSBackgroundTask(Entry entryInstance, Stack stackInstance, String controller, String url,
            LinkedHashMap<String, Object> headers, HashMap<String, Object> urlQueries, String requestInfo,
            ResultCallBack callBack) {
        checkHeader(headers);
        String completeUrl = stackInstance.config.getEndpoint() + url;
        CSConnectionRequest csConnectionRequest = new CSConnectionRequest(entryInstance);
        // since some entries of urlParams and headers are being removed by official ContentStack design
        // so we have to keep a separate copy
        csConnectionRequest.setURLQueries(new HashMap<>(urlQueries));
        csConnectionRequest.setParams(completeUrl, new LinkedHashMap<>(headers), controller, requestInfo, callBack);
        csConnectionRequest.sendRequest();
    }

    protected CSBackgroundTask(AssetLibrary assetLibrary, Stack stackInstance, String controller, String url,
            LinkedHashMap<String, Object> headers, HashMap<String, Object> urlQueries, String requestInfo,
            ResultCallBack callback) {
        checkHeader(headers);
        String completeUrl = stackInstance.config.getEndpoint() + url;
        CSConnectionRequest csConnectionRequest = new CSConnectionRequest(assetLibrary);
        // since some entries of urlParams and headers are being removed by official ContentStack design
        // so we have to keep a separate copy
        csConnectionRequest.setURLQueries(new HashMap<>(urlQueries));
        csConnectionRequest.setParams(completeUrl, new LinkedHashMap<>(headers), controller, requestInfo, callback);
        csConnectionRequest.sendRequest();
    }

    protected CSBackgroundTask(Asset asset, Stack stackInstance, String controller, String url,
            LinkedHashMap<String, Object> headers, HashMap<String, Object> urlQueries, String requestInfo,
            ResultCallBack callback) {
        checkHeader(headers);
        String completeUrl = stackInstance.config.getEndpoint() + url;
        CSConnectionRequest csConnectionRequest = new CSConnectionRequest(asset);
        // since some entries of urlParams and headers are being removed by official ContentStack design
        // so we have to keep a separate copy
        csConnectionRequest.setURLQueries(new HashMap<>(urlQueries));
        csConnectionRequest.setParams(completeUrl, new LinkedHashMap<>(headers), controller, requestInfo, callback);
        csConnectionRequest.sendRequest();
    }

    protected CSBackgroundTask(ContentType contentType, Stack stackInstance, String controller, String url,
            HashMap<String, Object> headers, HashMap<String, Object> urlParams, String requestInfo,
            ResultCallBack callback) {
        checkHeader(headers);
        String completeUrl = stackInstance.config.getEndpoint() + url;
        CSConnectionRequest csConnectionRequest = new CSConnectionRequest(contentType);
        // since some entries of urlParams and headers are being removed by official ContentStack design
        // so we have to keep a separate copy
        csConnectionRequest.setURLQueries(new HashMap<>(urlParams));
        csConnectionRequest.setParams(completeUrl, new LinkedHashMap<>(headers), controller, requestInfo, callback);
        csConnectionRequest.sendRequest();
    }

    protected void checkHeader(@NotNull Map<String, Object> headers) {
        final Logger logger = Logger.getLogger("CSBackgroundTask");
        if (headers.size() == 0) {
            try {
                throw new IllegalAccessException("CSBackgroundTask Header Exception");
            } catch (IllegalAccessException e) {
                logger.severe(e.getLocalizedMessage());
            }
        }
    }

}
