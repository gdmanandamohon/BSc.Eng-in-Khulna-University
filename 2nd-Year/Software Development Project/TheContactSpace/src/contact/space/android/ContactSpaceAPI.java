package contact.space.android;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

public class ContactSpaceAPI {
	JSONObject jsnContactList;
	JSONObject jsnLoginInfo;
	public static final String Encryption_key="123456789012";
	public static  final String Initial_vector= "1234567890123456";
	//{"auth": {"email": "vagabondlab@gmail.com", "password":"12345", "time": {"year":"2013", "month":"04", "day":"22", "hour":"17", "minute":"10", "second":"20" }}}

	public JSONObject convertContactListTosJSON(String[] nameList, String[] numberList){
		jsnContactList = new JSONObject();
		try {
			jsnContactList.put(nameList[0], numberList[0]);
			jsnContactList.getJSONArray("contactlist");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsnContactList;
	}
	
	public JSONObject convertLoginInfoToJson(String username, String password){
		jsnLoginInfo = new JSONObject();
		JSONObject jsnTime = new JSONObject();
		
		try {
			jsnTime.put("year", "2013");
			jsnTime.put("month", "");
			jsnTime.put("day","");
			jsnTime.put("hour","");
			jsnTime.put("minute", "");
			jsnLoginInfo.put("email", username);
			jsnLoginInfo.put("password", password);
			jsnLoginInfo.put("time", "");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsnLoginInfo;
		
	}
	
	public void SendListToServer() throws ClientProtocolException, IOException{
		String url = "http://www.marinerjob.com/thecontactspace/api/login";
		Map<String, String> kvPairs = new HashMap<String, String>();
		kvPairs.put("contactlist", jsnContactList.toString());
		// Normally I would pass two more JSONObjects.....
		HttpResponse re = doPost(url, kvPairs);
		String temp = EntityUtils.toString(re.getEntity());
		if (temp.compareTo("SUCCESS")==0)
		{
		    Toast.makeText(null, "Sending complete!", Toast.LENGTH_LONG).show();
		}
	}
	
	public HttpResponse doPost(String url, Map<String, String> kvPairs) throws ClientProtocolException, IOException 
	{
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(url);
	    if (kvPairs != null && kvPairs.isEmpty() == false) 
	    {
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(kvPairs.size());
	        String k, v;
	        Iterator<String> itKeys = kvPairs.keySet().iterator();
	        while (itKeys.hasNext()) 
	        {
	            k = itKeys.next();
	            v = kvPairs.get(k);
	            nameValuePairs.add(new BasicNameValuePair(k, v));
	        }             
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	    }
	    HttpResponse response;
	    response = httpclient.execute(httppost);
	    return response;
	}
	
	public HttpResponse doPostSecond(String url, JSONObject c) throws ClientProtocolException, IOException 
	{
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost request = new HttpPost(url);
	    HttpEntity entity;
	    StringEntity s = new StringEntity(c.toString());
	    s.setContentEncoding("UTF-8");
	    s.setContentType("application/json");
	    
	    entity = s;
	    request.setEntity(entity);
	    HttpResponse response;
	    response = httpclient.execute(request);
	    return response;
	}
	
	public static String encrypt(final String plainMessage,
	        final String symKeyHex) {
	    final byte[] symKeyData = symKeyHex.getBytes();

	    final byte[] encodedMessage = plainMessage.getBytes();
	    try {
	        final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        final int blockSize = cipher.getBlockSize();

	        // create the key
	        final SecretKeySpec symKey = new SecretKeySpec(symKeyData, "AES");

	        // generate random IV using block size (possibly create a method for
	        // this)
	        final byte[] ivData = new byte[blockSize];
	        final SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG");
	        rnd.nextBytes(ivData);
	        final IvParameterSpec iv = new IvParameterSpec(ivData);

	        cipher.init(Cipher.ENCRYPT_MODE, symKey, iv);

	        final byte[] encryptedMessage = cipher.doFinal(encodedMessage);

	        // concatenate IV and encrypted message
	        final byte[] ivAndEncryptedMessage = new byte[ivData.length
	                + encryptedMessage.length];
	        System.arraycopy(ivData, 0, ivAndEncryptedMessage, 0, blockSize);
	        System.arraycopy(encryptedMessage, 0, ivAndEncryptedMessage,
	                blockSize, encryptedMessage.length);

	        final String ivAndEncryptedMessageBase64 = new String(Base64.encode(ivAndEncryptedMessage,Base64.DEFAULT));

	        return ivAndEncryptedMessageBase64;
	        
	    } catch (InvalidKeyException e) {
	    	Log.w("say","esdf: "+e.toString());
	        throw new IllegalArgumentException(
	                "key argument does not contain a valid AES key");
	    } catch (GeneralSecurityException e) {
	        throw new IllegalStateException(
	                "Unexpected exception during encryption", e);
	    }
	}

	public static String decrypt(final String ivAndEncryptedMessageBase64,
	        final String symKeyHex) {
	    final byte[] symKeyData = symKeyHex.getBytes();

	    final byte[] ivAndEncryptedMessage = Base64.decode(ivAndEncryptedMessageBase64.getBytes(),Base64.DEFAULT);
	
	    try {
	        final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        final int blockSize = cipher.getBlockSize();

	        // create the key
	        final SecretKeySpec symKey = new SecretKeySpec(symKeyData, "AES");

	        // retrieve random IV from start of the received message
	        final byte[] ivData = new byte[blockSize];
	        System.arraycopy(ivAndEncryptedMessage, 0, ivData, 0, blockSize);
	        final IvParameterSpec iv = new IvParameterSpec(ivData);

	        // retrieve the encrypted message itself
	        final byte[] encryptedMessage = new byte[ivAndEncryptedMessage.length
	                - blockSize];
	        System.arraycopy(ivAndEncryptedMessage, blockSize,
	                encryptedMessage, 0, encryptedMessage.length);

	        cipher.init(Cipher.DECRYPT_MODE, symKey, iv);

	        final byte[] encodedMessage = cipher.doFinal(encryptedMessage);

	        // concatenate IV and encrypted message
	        String message="";
			try {
				message = new String(encodedMessage,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Log.w("Dycrypt","message: "+message);
	        return message;
	    
	    } catch (InvalidKeyException e) {
	        throw new IllegalArgumentException("key argument does not contain a valid AES key");
	    } catch (BadPaddingException e) {
	        // you'd better know about padding oracle attacks
	        return null;
	    } catch (GeneralSecurityException e) {
	    	Log.w("dycrypt","msg: "+e.toString());
	        throw new IllegalStateException(
	                "Unexpected exception during decryption", e);
	    }
	}

}
