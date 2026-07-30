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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
public class SurveyResourceIT {
	
	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";

	private static String GENERIC_QUESTIONS_URL="/surveys/Survey1/questions";
	
	private static String SPECIFIC_SURVEY_URL="/surveys/Survey1";
	
	
	private static String GENERIC_SURVEY_URL="/surveys";

	@Autowired
	private TestRestTemplate template;
	
	//http://localhost:8080/surveys/Survey1/questions/Question1
	



	
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
//		the str is a text block
//		System.out.println(responseEntity.getBody());
//		System.out.println(responseEntity.getHeaders());
		//check response is 200 successful or not
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		//check response type is json or not
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
		
		
	
	}
	
	
	
	@Test
	void retrieveAllSurveyQuestions_basicScenario() throws JSONException {
		
		ResponseEntity<String> responseEntity = template.getForEntity(GENERIC_QUESTIONS_URL, String.class);

		String expectedResponse =
				"""
						[
						  {
						    "id": "Question1"
						  },
						  {
						    "id": "Question2"
						  },
						  {
						    "id": "Question3"
						  }
						]
				
				""";

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
		 
	}
	
	
	
	
	@Test
	void retrieveSurveyById_basicScenario() throws JSONException {
		
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_SURVEY_URL, String.class);

		String expectedResponse =
				"""
						{
						  "id": "Survey1",
						  "title": "My Favorite Survey",
						  "description": "Description of the Survey",
						  "questions": [
						    {
						      "id": "Question1"
						    },
						    {
						      "id": "Question2"
						    },
						    {
						      "id": "Question3"
						    }
						  ]
					   }	
						""";

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
		 
	}
	
	
	@Test
	void retrieveAllSurveys_basicScenario() throws JSONException {
		
		ResponseEntity<String> responseEntity = template.getForEntity(GENERIC_SURVEY_URL, String.class);

		String expectedResponse =
				"""
					[
					  {
					    "id": "Survey1",
					    "title": "My Favorite Survey",
					    "description": "Description of the Survey",
					    "questions": [
					      {
					        "id": "Question1"
					      },
					      {
					        "id": "Question2"
					      },
					      {
					        "id": "Question3"
					      }
					    ]
					  }
					]	
						""";

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
		 
	}
	
	@Test
	void addNewSurveyQuestion_basicScenario() {

		String requestBody = """
					{
					  "description": "Your Favorite Language",
					  "options": [
					    "Java",
					    "Python",
					    "JavaScript",
					    "Haskell"
					  ],
					  "correctAnswer": "Java"
					}
				""";

		
		//
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, headers);
		
		ResponseEntity<String> responseEntity 
			= template.exchange(GENERIC_QUESTIONS_URL, HttpMethod.POST, httpEntity, String.class);
		
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		
		String locationHeader = responseEntity.getHeaders().get("Location").get(0);
		assertTrue(locationHeader.contains("/surveys/Survey1/questions/"));
		
		//DELETE
		//locationHeader
		//here we are deleting the survey question which was created
		template.delete(locationHeader);
		
	}
			
	
	
}