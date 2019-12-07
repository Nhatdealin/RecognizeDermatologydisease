package com.example.recognizedermatologydisease.api;

import android.content.Context;

import com.example.recognizedermatologydisease.api.exception.ApiException;
import com.example.recognizedermatologydisease.api.models.BaseOutput;
import com.example.recognizedermatologydisease.api.models.PredictionResultOutput;
import com.example.recognizedermatologydisease.api.objects.PredictInput;
import com.example.recognizedermatologydisease.http.HttpApiWithSessionAuth;
import com.example.recognizedermatologydisease.utils.Constants;
import com.example.recognizedermatologydisease.utils.SharedPreferenceHelper;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by dcmen on 08/31/16.
 */
public class TaskApi {
    // URL
    public static final String TASK_WS = "http://http://nhatthao.hoangddt.net/app/";//DEV api
    public static final String PREDICT_API = "upload";


    private static final Logger LOG = Logger
            .getLogger(TaskApi.class.getCanonicalName());
    private HttpApiWithSessionAuth mHttpApi;
    private String mDomain;
    private Context mContext;
    private Gson mGson;

    public TaskApi(Context context) {
        mContext = context;
        mHttpApi = new HttpApiWithSessionAuth(context);
        mGson = new Gson();
        mDomain = TASK_WS;
    }


    public TaskApi setCredentials(String token) {
        if (token == null || token.length() == 0)
            mHttpApi.clearCredentials();
        else
            mHttpApi.setCredentials(token);
        return this;
    }


    public String getFullUrl(String subUrl) {
        return mDomain + subUrl;
    }

    public PredictionResultOutput predict(PredictInput input) throws ApiException, JSONException, IOException {
        JSONObject data = mHttpApi.doHttpMultipartImages(getFullUrl(PREDICT_API), new HashMap<String, String>(), input.getFiles());
        PredictionResultOutput output = mGson.fromJson(data.toString(), PredictionResultOutput.class);
        return output;
    }
//
//    public BaseOutput logout() throws ApiException, JSONException, IOException {
//        JSONObject data = mHttpApi.doHttpPost(getFullUrl(LOGOUT_API), "");
//        BaseOutput output = mGson.fromJson(data.toString(), BaseOutput.class);
//        return output;
//    }
//
//    public LoginOutput loginUsername(LoginInput loginInput) throws ApiException, JSONException, IOException {
//        JSONObject data = mHttpApi.doHttpPost(getFullUrl(LOGIN_API), new Gson().toJson(loginInput));
//        LoginOutput output = mGson.fromJson(data.toString(), LoginOutput.class);
//
//        return output;
//    }
//    public ForgotPasswordOutput forgotPassword(ForgotPasswordInput forgotPasswordInput) throws ApiException, JSONException, IOException {
//        JSONObject data = mHttpApi.doHttpPost(getFullUrl(FORGOT_PASSWORD_API), new Gson().toJson(forgotPasswordInput));
//        ForgotPasswordOutput output = mGson.fromJson(data.toString(), ForgotPasswordOutput.class);
//        return output;
//    }
//
//
//
//    public SignupOutput signUpAccount(SignupInput signupInput) throws ApiException, JSONException, IOException {
//        JSONObject data = (JSONObject) mHttpApi.doHttpPost(getFullUrl(SIGNUP_API), new Gson().toJson(signupInput));
//        SignupOutput output = (SignupOutput) mGson.fromJson(data.toString(), SignupOutput.class);
//        return output;
//    }
//    public ChangePasswordOutput changePassword(ChangePasswordInput changePasswordInput) throws ApiException, JSONException, IOException {
//        JSONObject data = (JSONObject) mHttpApi.doHttpPut(getFullUrl(CHANGE_PASSWORD_API), new Gson().toJson(changePasswordInput));
//        ChangePasswordOutput output = (ChangePasswordOutput) mGson.fromJson(data.toString(), ChangePasswordOutput.class);
//        return output;
//    }
//    public ProfileOutput getProfile() throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//        JSONObject data = mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(PROFILE_API)));
//        ProfileOutput output = mGson.fromJson(data.toString(), ProfileOutput .class);
//        return output;
//    }
//    public ProfileOutput updateProfile(UpdateProfileInput updateProfileInput) throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//        JSONObject data = (JSONObject) mHttpApi.doHttpPut(getFullUrl(PROFILE_API), new Gson().toJson(updateProfileInput));
//        ProfileOutput output = (ProfileOutput) mGson.fromJson(data.toString(), ProfileOutput .class);
//        return output;
//    }
//    public AvatarOutput updateAvatar(File updateFile) throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//        JSONObject data = (JSONObject) mHttpApi.doHttpPostImages(getFullUrl(UPLOAD_AVATAR_API), new HashMap<String, String>(), updateFile);
//        AvatarOutput output = (AvatarOutput) mGson.fromJson(data.toString(), AvatarOutput .class);
//        return output;
//    }
//
//    public ProjectsOutput getProjects(int page,int pagesize) throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//        JSONObject data = (JSONObject) mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(PROJECT_API),page +"",5+""));
//        ProjectsOutput output = (ProjectsOutput) mGson.fromJson(data.toString(), ProjectsOutput .class);
//        return output;
//    }
//    public SignupOutput signUpVolunteer(VolunteerInput volunteerInput,Long eventId) throws ApiException, JSONException, IOException {
//        JSONObject data = (JSONObject) mHttpApi.doHttpPost(String.format(getFullUrl(SIGNUP_VOLUNTEER_API),eventId +""), new Gson().toJson(volunteerInput));
//        SignupOutput output = (SignupOutput) mGson.fromJson(data.toString(), SignupOutput.class);
//        return output;
//    }
//    public EventOutput getEventById(Long id ) throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//        JSONObject data = (JSONObject) mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(EVENT_BY_ID_API),id +""));
//        EventOutput output = (EventOutput) mGson.fromJson(data.toString(), EventOutput .class);
//        return output;
//    }
//
//    public EventsOutput getEvents(int page, int pagesize) throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//        JSONObject data = (JSONObject) mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(EVENT_API),page +"",5+""));
//        EventsOutput output = (EventsOutput) mGson.fromJson(data.toString(), EventsOutput .class);
//        return output;
//    }
//    public ProjectOutput getProjectById(Long id ) throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//        JSONObject data = (JSONObject) mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(PROJECT_BY_ID_API),id +""));
//        ProjectOutput output = (ProjectOutput) mGson.fromJson(data.toString(), ProjectOutput .class);
//        return output;
//    }
//    public BlogPostsOutput getBlogPostsByIdTopic(Long idtopic,int page, int pagesize) throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//        JSONObject data = (JSONObject) mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(BLOGPOSTS_TOPIC_ID_API),idtopic+"",page +"",pagesize+""));
//        BlogPostsOutput output = (BlogPostsOutput) mGson.fromJson(data.toString(), BlogPostsOutput .class);
//        return output;
//    }
//    public BlogPostsOutput getBlogPosts(int page, int pagesize) throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//        JSONObject data = (JSONObject) mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(BLOGPOSTS_ALL_API),page +"",pagesize+""));
//        BlogPostsOutput output = (BlogPostsOutput) mGson.fromJson(data.toString(), BlogPostsOutput .class);
//        return output;
//    }
//    public BlogPostTopicsOutput getBlogPostsTopics(int page, int pagesize) throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//        JSONObject data = (JSONObject) mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(BLOGPOST_TOPIC_API),page +"",pagesize+""));
//        BlogPostTopicsOutput output = (BlogPostTopicsOutput) mGson.fromJson(data.toString(), BlogPostTopicsOutput .class);
//        return output;
//    }
//    public BlogPostOutput getBlogPostById(Long id ) throws ApiException, JSONException, IOException {
//        mHttpApi.setCredentials(SharedPreferenceHelper.getInstance(this.mContext).get(Constants.EXTRAX_TOKEN_CODE));
//
//        JSONObject data = (JSONObject) mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(BLOGPOSTS_BY_ID_API),id +""));
//        BlogPostOutput output = (BlogPostOutput) mGson.fromJson(data.toString(), BlogPostOutput .class);
//        return output;
//    }
//
//    public PaypalDonationOutput donatePaypal(PaypalDonationInput paypalDonationInput) throws ApiException, JSONException, IOException {
//        JSONObject data = (JSONObject) mHttpApi.doHttpPost(getFullUrl(PAYPAL_DONATION_API), new Gson().toJson(paypalDonationInput));
//        PaypalDonationOutput output = (PaypalDonationOutput) mGson.fromJson(data.toString(), PaypalDonationOutput.class);
//        return output;
//    }
//    public ResultDonateOutput resultDonatePaypal(Long projectId, String paymentId, String token,String PayerID) throws ApiException, JSONException, IOException {
//        String link = String.format(getFullUrl(PAYPAL_DONATION_RESULT_API),projectId +"",paymentId,token,PayerID);
//        JSONObject data = (JSONObject) mHttpApi.doHttpPost(String.format(getFullUrl(PAYPAL_DONATION_RESULT_API),projectId +"",paymentId,token,PayerID),new Gson().toJson(null));
//        ResultDonateOutput output = (ResultDonateOutput) mGson.fromJson(data.toString(), ResultDonateOutput.class);
//        return output;
//    }
}
