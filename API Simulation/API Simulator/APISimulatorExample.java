/**
 * 
 */
package com.exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * This class performs the Http GET & POST Request and 
 * consumes the API's exposed by API Simulator
 * 
 * @author gssmunej
 * @version 1.0
 *
 */
public class APISimulatorExample {

	public static final String GET_URL="http://localhost:6090/flex/payments/muneer/details.json";
	
	public static final String POST_URL="http://localhost:6090/flex/payments/createPayment";
	
	public static final String PUT_URL="http://localhost:6090/flex/payments";
	
	public static void main(String[] args) throws Exception {

		APISimulatorExample http = new APISimulatorExample();

		System.out.println("Testing API Simulator....");
		
		System.out.println("Testing Http GET request");
		http.sendGet();
		
		System.out.println("Testing Http POST request");
		http.sendPost();
		
		System.out.println("Testing Http PUT request");
		http.sendPut();
	}
	
	/**
	 * This Method performs the Http GET Call
	 * 
	 * @throws Exception
	 */
	private void sendGet() throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(GET_URL);

		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + GET_URL);
		System.out.println("Response Code ::" + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

	}
	
	/**
	 * This Method performs the Http POST Call
	 * 
	 * @throws Exception
	 */
	private void sendPost() throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(POST_URL);

		post.setHeader("Content-Type", "application/json");

		StringEntity params = new StringEntity("{\"payment\":{\"id\":\"1234\",\"name\":\"Muneer\",\"category\":\"Electicity Bill\",\"subCategory\":\"TNEB\",\"Mode\":\"Debit Card\"}}");
		post.setEntity(params);
		
		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + POST_URL);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code :" + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

	}
	
	/**
	 * This Method performs the Http POST Call
	 * 
	 * @throws Exception
	 */
	private void sendPut() throws Exception {

		HttpClient client = HttpClientBuilder.create().build();
		HttpPut putRequest = new HttpPut(PUT_URL);

		putRequest.setHeader("Content-Type", "application/json");

		StringEntity params = new StringEntity("{\"payment\":{\"id\":\"1234\",\"name\":\"Muneer\",\"category\":\"Electicity Bill\",\"subCategory\":\"TNEB\",\"Mode\":\"Debit Card\"}}");
		putRequest.setEntity(params);
		
		HttpResponse response = client.execute(putRequest);
		System.out.println("\nSending 'PUT' request to URL : " + PUT_URL);
		System.out.println("Body parameters : " + putRequest.getEntity());
		System.out.println("Response Code ::" + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

	}
}
