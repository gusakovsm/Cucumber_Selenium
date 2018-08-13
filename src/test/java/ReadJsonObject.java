import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;

import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
//import net.sf.json.JSONObject;
import reuseLib.ApiLib;
import reuseLib.ApiResponse;

public class ReadJsonObject {

	
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	@Test
	public void test() throws Exception {
		ApiLib api = new ApiLib();
		System.out.println(api.GetSessionToken("TA_Andromeda", "admin", "Qwerty123"));
		HashMap<String,String> header = new HashMap<String,String>();
		header.put("Authorization", "Bearer " + api.GetSessionToken("TA_Andromeda", "admin", "Qwerty123"));
		ApiResponse odata = api.CallService("/odata/Assets", "get", null, header);
//		System.out.println(odata.responseCode);
//		System.out.println(odata.body.get("@odata.context"));
//		System.out.println(odata.body.get("@odata.count"));
		System.out.println(odata.body.get("value").getClass());
		System.out.println(((List<String>)odata.body.get("value")).size());
		System.out.println(((List<String>)odata.body.get("value")));
		
//		List<String> tgest = ((List<String>)odata.body.get("value"));
//		
//		Gson gson = new Gson();
//		String daysJson = gson.toJson(tgest);
//		System.out.println(daysJson.getClass());
		


		
		ArrayList<LinkedTreeMap>  res = (ArrayList<LinkedTreeMap>) (odata.body.get("value"));
		System.out.println(res.getClass());
//		System.out.println(res.get(0).get("Name")); 
		for (LinkedTreeMap linkedTreeMap : res) {
			System.out.println(linkedTreeMap.get("Name"));
			System.out.println(linkedTreeMap.get("Value"));
			System.out.println(linkedTreeMap.get("Id"));
}

//		JSONObject jObj = new JSONObject(daysJson);
		

//      System.out.println(daysJson);
//      System.out.println(daysJson.getClass());
		
//		for (Map.Entry<String, Object> entry : ((Map) tgest).entrySet()) {
//            FeatureDetails featureDetails = entry.getValue();
//}
//		int size = ((List<String>)odata.body.get("value")).size();
//		
//        Gson gson = new Gson();
//        for (int i=0; i<size; i++) {
//
//		}
//    	JSONArray[] stockArr = new JSONArray[((List<String>)odata.body.get("value")).size()];
//    	stockArr = ((List<String>)odata.body.get("value")).toArray(stockArr);
//    	for(JSONArray s : stockArr)
//    	    System.out.println(s);
    	
//        String daysJson = gson.toJson((List<String>)odata.body.get("value"));
//        System.out.println(daysJson);
//        System.out.println(daysJson.getClass());
//		
//		
//		System.out.println("------1------------------------------------------");
//		List<String> stockList = (List<String>) odata.body.get("value");
//		System.out.println(stockList);
//		System.out.println("------2------------------------------------------");
//		String[] stockArr = new String[stockList.size()];
//		System.out.println(stockList.size());
//		System.out.println("------3------------------------------------------");
//		stockArr = stockList.toArray(stockArr);
//		System.out.println("------4------------------------------------------");
//		for(String s : stockArr)
//		    System.out.println(s);
//		
//		System.out.println("------5------------------------------------------");
//
//        
//
//


	}
}



