package com.in28minutes.springboot.rest_api.survey;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
public class SurveyResourceIT {
	
	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";

	
	@Autowired
	private TestRestTemplate template;
	
	//http://localhost:8080/surveys/Survey1/questions/Question1
	String str = """
			
			{
			  "id": "Question1",
			  "description": "Most Popular Cloud Platform Today",
			  "options": [
			    "AWS",
			    "Azure",
			    "Google Cloud",
			    "Oracle Cloud"
			  ],
			  "correctAnswer": "AWS"
			}
			
			""";
//	the str is a text block


	
	@Test
	void retrieveSpecificSurveyQuestion_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);

		String expectedResponse =
				"""
					{
			  "id": "Question1",
			  "description": "Most Popular Cloud Platform Today",
		
			  "correctAnswer": "AWS"
			}
				""";
		
//		System.out.println(responseEntity.getBody());
//		System.out.println(responseEntity.getHeaders());
		//check response is 200 successful or not
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		//check response type is json or not
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
		
		
	
	}
	
	
}