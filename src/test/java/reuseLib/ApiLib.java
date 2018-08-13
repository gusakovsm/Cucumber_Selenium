package reuseLib;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApiLib {
	String apiURL = "https://demo.uipath.com";

	@SuppressWarnings("unchecked")
	public ApiResponse CallService(String url, String method, HashMap<String,String> parameters, HashMap<String,String> headers) throws Exception {
		url = apiURL + url;
		HashMap<String, Object> collection = new HashMap<String,Object>();
		
		URL urlObj = new URL(url);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		
		HttpsURLConnection conn = (HttpsURLConnection) urlObj.openConnection();
		
		byte[] postData = null;
		
		if (parameters != null) {
			switch (method.toLowerCase()) {
				case "get":
					url += "?";
					for (String key : parameters.keySet()) {
						url += key + "=" + parameters.get(key) + "&";
					}
					break;
				case "post":
					String jsonString = gson.toJson(parameters);
					postData = jsonString.getBytes(StandardCharsets.UTF_8);
					int postDataLength = postData.length;
	
					conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
					conn.setRequestProperty("Content-Type", "application/json");
	
					break;
				default:
					throw new Exception("Not supported");
			}
		}
		
		if (headers != null) {
			for (String key : headers.keySet()) {
				conn.setRequestProperty(key, headers.get(key));
			}
		}
		
		String responseResult = "";
		           
		conn.setDoOutput( true );
		conn.setInstanceFollowRedirects( true );
		conn.setRequestMethod(method.toUpperCase());
		
		conn.setRequestProperty("charset", "utf-8");
		
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
		conn.setRequestProperty("Accept", "*/*");
		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.9");
		conn.setUseCaches(false);
		
		if (postData != null)
			conn.getOutputStream().write(postData);
		
		Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));				
		
        for (int c; (c = in.read()) >= 0;) {
            responseResult += (char)c;
        }
        
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.responseCode = conn.getResponseCode();
        
        if (responseResult.length() > 0)
        	apiResponse.body = (HashMap<String,Object>)(gson.fromJson(responseResult, collection.getClass()));
        	apiResponse.header = conn.getHeaderFields();

		conn.disconnect();
		
		return apiResponse;
	}
	
	public String GetSessionToken(String tenantName, String username, String password) throws Exception {		
		HashMap<String,String> params = new HashMap<String,String>();
		String token;
		
		params.put("tenancyName", tenantName);
		params.put("usernameOrEmailAddress", username);
		params.put("password", password);
	    try{
	    	ApiResponse response = CallService("/api/account/authenticate", "POST", params, null);
		    token = response.body.get("result").toString();
	    }
	    catch(IOException ex){
	    	token = "";
	    }
	    return token;

	}
	
}