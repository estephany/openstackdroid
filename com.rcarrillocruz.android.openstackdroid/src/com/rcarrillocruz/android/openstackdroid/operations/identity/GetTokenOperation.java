package com.rcarrillocruz.android.openstackdroid.operations.identity;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.rcarrillocruz.android.openstackdroid.json.identity.AuthObject;
import com.rcarrillocruz.android.openstackdroid.json.identity.GetTokenRequest;
import com.rcarrillocruz.android.openstackdroid.json.identity.PasswordCredentialsObject;
import com.rcarrillocruz.android.openstackdroid.operations.ApiOperation;

public class GetTokenOperation implements ApiOperation {
	private Gson gson;
	private static final String urlTail = "/v2.0/tokens";
	private static final String TAG = "com.rcarrillocruz.android.openstackdroid.operations.identity.GetTokenOperation";
	
	public GetTokenOperation() {
		super();	
		gson = new Gson();
	}
	
	public HttpRequestBase invoke(Uri endpoint, String token, String tenantId,
			Bundle params) {
		HttpPost httpPost = new HttpPost(endpoint.toString()+urlTail);
		httpPost.setHeader("Content-type", "application/json");
		
		String username = params.getString("username");
		String password = params.getString("password");
		
		GetTokenRequest request = new GetTokenRequest(new AuthObject(new PasswordCredentialsObject(username, password), tenantId));
		
		StringEntity se = null;
		try {
			se = new StringEntity(gson.toJson(request));
		} catch (UnsupportedEncodingException e) {
			Log.e(TAG,Log.getStackTraceString(e)); 
		}
		
		httpPost.setEntity(se);
		
		return httpPost;
	}
}
