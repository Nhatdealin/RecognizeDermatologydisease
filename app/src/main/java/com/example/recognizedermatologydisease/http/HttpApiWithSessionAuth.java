package com.example.recognizedermatologydisease.http;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.recognizedermatologydisease.api.TaskApi;
import com.example.recognizedermatologydisease.api.exception.ApiException;
import com.example.recognizedermatologydisease.utils.Constants;
import com.example.recognizedermatologydisease.utils.SharedPreferenceHelper;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class HttpApiWithSessionAuth extends AbstractHttpApi {
    private String mToken;
    private Context mContext;

    public Context getContext() {
        return mContext;
    }

    public HttpApiWithSessionAuth(Context context) {
        super();
        mContext = context;
    }

    public void setCredentials(String token) {
        mToken = token;
    }

    public void clearCredentials() {
        mToken = null;
    }

    public boolean hasCredentials() {
        return !TextUtils.isEmpty(mToken);
    }

    private Map<String, String> createHeaderWithAuthorization() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Content-Type", "application/json");
        map.put("Accept", "application/json");
        if (hasCredentials()) {
            map.put("Authorization","Bearer "+ mToken);
            return map;
        } else {
            return null;
        }
    }

    @Override
    public JSONObject doHttpPost(@NonNull String requestUrl, String jsonObject)
            throws ApiException, JSONException, IOException {
//        try {
            JSONObject jsonResult = new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), jsonObject));
            try {
                if(jsonResult.getInt("ErrorCode") == Constants.FAILURE_SESSION_EXPIRED){
//                    if(getNewSession()) {
//                        return new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), jsonObject));
//                    } else {
                        return jsonResult;
//                    }
                }
            } catch (JSONException ex){

            }
            return jsonResult;
//        } catch (ApiException e) {
//            if (e.getErrorCode() == Constants.FAILURE_SESSION_EXPIRED) {
//                getNewSession();
//                return new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), jsonObject));
//            } else
//            throw e;
//        }
    }



    @Override

    public JSONObject doHttpPost(@NonNull String requestUrl, JSONObject jsonObject)
            throws ApiException, JSONException, IOException {
//        try {
        JSONObject jsonResult = new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), jsonObject));
        try {
            if(jsonResult.getInt("ErrorCode") == Constants.FAILURE_SESSION_EXPIRED){
//                if(getNewSession()) {
//                    return new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), jsonObject));
//                } else {
                    return jsonResult;
//                }
            }
        } catch (JSONException ex){

        }
        return jsonResult;
//        } catch (ApiException e) {
//            if (e.getErrorCode() == Constants.FAILURE_SESSION_EXPIRED) {
//                getNewSession();
//                return new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), jsonObject));
//            } else
//                throw e;
//        }

    }

    @Override
    public JSONObject doHttpPost(@NonNull String requestUrl, Map<String, String> params)
            throws ApiException, JSONException, IOException {
//        try {
        JSONObject jsonResult = new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), params));
        try {
            if(jsonResult.getInt("ErrorCode") == Constants.FAILURE_SESSION_EXPIRED){
//                if(getNewSession()) {
//                    return new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), params));
//                } else {
                    return jsonResult;
//                }
            }
        } catch (JSONException ex){

        }
        return jsonResult;
//        } catch (ApiException e) {
//            if (e.getErrorCode() == Constants.FAILURE_SESSION_EXPIRED) {
//                getNewSession();
//                return new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), params));
//            } else
//            throw e;
//        }

    }


    @Override
    public JSONObject doHttpPut(@NonNull String requestUrl, String jsonObject)
            throws ApiException, JSONException, IOException {
//        try {
        JSONObject jsonResult = new JSONObject(executeHttpPut(requestUrl, createHeaderWithAuthorization(), jsonObject));
        try {
            if(jsonResult.getInt("ErrorCode") == Constants.FAILURE_SESSION_EXPIRED){
//                if(getNewSession()) {
//                    return new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), jsonObject));
//                } else {
                    return jsonResult;
//                }
            }
        } catch (JSONException ex){

        }
        return jsonResult;
//        } catch (ApiException e) {
//            if (e.getErrorCode() == Constants.FAILURE_SESSION_EXPIRED) {
//                getNewSession();
//                return new JSONObject(executeHttpPost(requestUrl, createHeaderWithAuthorization(), jsonObject));
//            } else
//            throw e;
//        }
    }



    @Override
    public JSONObject doHttpGet(@NonNull String requestUrl, Map<String, String> params)
            throws ApiException, JSONException, IOException {
//        try {
        JSONObject jsonResult = new JSONObject(executeHttpGet(requestUrl, createHeaderWithAuthorization(), params));
        try {
            if(jsonResult.getInt("ErrorCode") == Constants.FAILURE_SESSION_EXPIRED){
//                if(getNewSession()) {
//                    return new JSONObject(executeHttpGet(requestUrl, createHeaderWithAuthorization(), params));
//                } else {
                    return jsonResult;
//                }
            }
        } catch (JSONException ex){

        }
        return jsonResult;
//        } catch (ApiException e) {
//            if (e.getErrorCode() == Constants.FAILURE_SESSION_EXPIRED) {
//                getNewSession();
//                return new JSONObject(executeHttpGet(requestUrl, createHeaderWithAuthorization(), params));
//            } else
//            throw e;
//        }
    }




    public JSONObject doHttpGetWithHeader(@NonNull String requestUrl)
            throws ApiException, JSONException, IOException {
//        try {
        JSONObject jsonResult = new JSONObject(executeHttpGet(requestUrl, createHeaderWithAuthorization()));
        try {
            if(jsonResult.getInt("ErrorCode") == Constants.FAILURE_SESSION_EXPIRED){
//                if(getNewSession()) {
//                    return new JSONObject(executeHttpGet(requestUrl, createHeaderWithAuthorization()));
//                } else {
                    return jsonResult;
//                }
            }
        } catch (JSONException ex){

        }
        return jsonResult;
//        } catch (ApiException e) {
//            if (e.getErrorCode() == Constants.FAILURE_SESSION_EXPIRED) {
//                getNewSession();
//                return new JSONObject(executeHttpGet(requestUrl, createHeaderWithAuthorization()));
//            } else
//            throw e;
//        }
    }

    @Override
    public JSONObject doHttpGet(@NonNull String requestUrl)
            throws ApiException, JSONException, IOException {
//        try {
        JSONObject jsonResult = new JSONObject(executeHttpGet(requestUrl, createHeaderWithAuthorization()));
        try {
            if(jsonResult.getInt("ErrorCode") == Constants.FAILURE_SESSION_EXPIRED){
//                if(getNewSession()) {
//                    return new JSONObject(executeHttpGet(requestUrl, createHeaderWithAuthorization()));
//                } else {
                    return jsonResult;
//                }
            }
        } catch (JSONException ex){

        }
        return jsonResult;
//        } catch (ApiException e) {
//            if (e.getErrorCode() == Constants.FAILURE_SESSION_EXPIRED) {
//                getNewSession();
//                return new JSONObject(executeHttpGet(requestUrl, createHeaderWithAuthorization()));
//            } else
//            throw e;
//        }
    }

    @Override
    public JSONObject doHttpMultipart(@NonNull String requestUrl, Map<String, String> params, Map<String, File> files)
            throws ApiException, JSONException, IOException {
//        try {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Content-Disposition", "form-data");
        map.put("Accept", "application/json");
        if (hasCredentials()) {
            map.put("Lang", "en");
            map.put("Authorization", mToken);
        }
        JSONObject jsonResult = new JSONObject(executeHttpMultipart(requestUrl, map, params, files));
        try {
            if(jsonResult.getInt("ErrorCode") == Constants.FAILURE_SESSION_EXPIRED){
//                if(getNewSession()) {
//                    map = new LinkedHashMap<>();
//                    map.put("Content-Disposition", "form-data");
////                    map.put("Content-Type", "application/json");
//                    map.put("Accept", "application/json");
//                    if (hasCredentials()) {
//                        map.put("Lang", "en");
//                        map.put("Authorization", mToken);
//                    }
//                    return new JSONObject(executeHttpMultipart(requestUrl, map, params, files));
//                } else {
                    return jsonResult;
//                }
            }
        } catch (JSONException ex){

        }
        return jsonResult;
//        } catch (ApiException e) {
//            if (e.getErrorCode() == Constants.FAILURE_SESSION_EXPIRED) {
//                getNewSession();
//                return new JSONObject(executeHttpMultipart(requestUrl, createHeaderWithAuthorization(), params, files));
//            } else
//            throw e;
//        }
    }

    public JSONObject doHttpPostImages(@NonNull String requestUrl, Map<String, String> params, File files)
            throws ApiException, JSONException, IOException {
//        try {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Content-Disposition", "form-data");
        map.put("Accept", "application/json");
        if (hasCredentials()) {
            map.put("Lang", "en");
            map.put("Authorization", mToken);
        }
        JSONObject jsonResult = new JSONObject(executeHttpPostImages(requestUrl, map, params, files));
        try {
            if(jsonResult.getInt("ErrorCode") == Constants.FAILURE_SESSION_EXPIRED){
//                if(getNewSession()) {
//                    map = new LinkedHashMap<>();
//                    map.put("Content-Disposition", "form-data");
////                    map.put("Content-Type", "application/json");
//                    map.put("Accept", "application/json");
//                    if (hasCredentials()) {
//                        map.put("Lang", "en");
//                        map.put("Authorization", mToken);
//                    }
//                    return new JSONObject(executeHttpPostImages(requestUrl, map, params, files));
//                } else {
                    return jsonResult;
//                }
            }
        } catch (JSONException ex){

        }
        return jsonResult;
//        } catch (ApiException e) {
//            if (e.getErrorCode() == Constants.FAILURE_SESSION_EXPIRED) {
//                getNewSession();
//                return new JSONObject(executeHttpMultipart(requestUrl, createHeaderWithAuthorization(), params, files));
//            } else
//            throw e;
//        }
    }


    @Override
    public JSONObject doHttpMultipartImages(@NonNull String requestUrl, Map<String, String> params, ArrayList<File> files)
            throws ApiException, JSONException, IOException {
//        try {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("Content-Disposition", "form-data");
        map.put("Accept", "application/json");
        if (hasCredentials()) {
            map.put("Lang", "en");
            map.put("Authorization", mToken);
        }
        JSONObject jsonResult = new JSONObject(executeHttpMultipartImages(requestUrl, map, params, files));
        try {
            if(jsonResult.getInt("ErrorCode") == Constants.FAILURE_SESSION_EXPIRED){
//                if(getNewSession()) {
//                    map = new LinkedHashMap<>();
//                    map.put("Content-Disposition", "form-data");
////                    map.put("Content-Type", "application/json");
//                    map.put("Accept", "application/json");
//                    if (hasCredentials()) {
//                        map.put("Lang", "en");
//                        map.put("Authorization", mToken);
//                    }
//                    return new JSONObject(executeHttpMultipartImages(requestUrl, map, params, files));
//                } else {
                    return jsonResult;
//                }
            }
        } catch (JSONException ex){

        }
        return jsonResult;
//        } catch (ApiException e) {
//            if (e.getErrorCode() == Constants.FAILURE_SESSION_EXPIRED) {
//                getNewSession();
//                return new JSONObject(executeHttpMultipart(requestUrl, createHeaderWithAuthorization(), params, files));
//            } else
//            throw e;
//        }
    }





    //    /**
//     * YeahShip will get new session by api login if current session is expired.
//     * So, just login and get new session, do not touch another data
//     */

}
