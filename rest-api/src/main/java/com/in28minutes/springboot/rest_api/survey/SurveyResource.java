package com.in28minutes.springboot.rest_api.survey;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {

	
	private SurveyService surveyService;
	@Autowired
	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}
	// surveys
	
	
	// /surveys/Survey1
	
	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys(){
		
		
		return surveyService.retrieveAllSurveys();
	}
	
	@RequestMapping("/surveys/{surveyId}")
	public Survey retrieveSurveyById(@PathVariable String surveyId){
		Survey surveyById = surveyService.retrieveSurveyById(surveyId);
		if(surveyById==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return surveyById;
		
	}
	
	@RequestMapping("surveys/{surveyId}/questions")
	public List<Question> retrieveAllSurveyQuestions(@PathVariable String surveyId){
		List<Question> allSurveyQuestions = surveyService.retrieveAllSurveyQuestions(surveyId);
		if(allSurveyQuestions==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return allSurveyQuestions;
	}
	
	@RequestMapping("surveys/{surveyId}/questions/{questionId}")
	public Question retrieveSpecificSurveyQuestion(@PathVariable String surveyId,@PathVariable String questionId) {
		 Question specificSurveyQuestion = surveyService.retrieveSpecificSurveyQuestion(surveyId,questionId);
	
		 if(specificSurveyQuestion==null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			return specificSurveyQuestion;
	
	}
	
	@RequestMapping(value="surveys/{surveyId}/questions", method=RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId,@RequestBody Question q){
		
		String questionId = surveyService.addNewSurveyQuestion(surveyId,q);
		
		//return surveys/{surveyId}/questions/{questionId}
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{questionId}").buildAndExpand(questionId).toUri();
	
		
		return ResponseEntity.created(location).build();
		
		
		
	}
	
	@RequestMapping(value="surveys/{surveyId}/questions/{questionId}",method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String surveyId,@PathVariable String questionId){
		
		String id=surveyService.deleteSurveyQuestion(surveyId,questionId);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="surveys/{surveyId}/questions/{questionId}",method=RequestMethod.PUT)
	public ResponseEntity<Object> updateSurveyQuestion(@PathVariable String surveyId,@PathVariable String questionId,@RequestBody Question question){
		
		
		
		surveyService.updateSurveyQuestion(surveyId,questionId,question);
		return ResponseEntity.ok().build();
		
	}


	
	

	
	
	
}
