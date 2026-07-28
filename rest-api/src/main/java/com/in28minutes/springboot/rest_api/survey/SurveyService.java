package com.in28minutes.springboot.rest_api.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

	
	private static List<Survey> surveys = new ArrayList<>();
	
	static {
		Question question1 = new Question("Question1",
		        "Most Popular Cloud Platform Today", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2",
		        "Fastest Growing Cloud Platform", Arrays.asList(
		                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3",
		        "Most Popular DevOps Tool", Arrays.asList(
		                "Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1,
		        question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey",
		        "Description of the Survey", questions);
		
	

		surveys.add(survey);
		


	}


	public List<Survey> retrieveAllSurveys() {
		// TODO Auto-generated method stub
		return surveys;
	}


	public Survey retrieveSurveyById(String surveyName) {
		// TODO Auto-generated method stub
		Survey s = surveys.stream().filter(survey->survey.getId().equalsIgnoreCase(surveyName)).findFirst().orElse(null);
//		System.out.println(s);
		return s;
	}


	public List<Question> retrieveAllSurveyQuestions(String surveyId) {
		// TODO Auto-generated method stub
		Survey s = retrieveSurveyById(surveyId);
		if(s==null) {
			return null;
		}
		return s.getQuestions();
	}


	public Question retrieveSpecificSurveyQuestion(String surveyId, String questionId) {
		// TODO Auto-generated method stub
		
		List<Question> allSurveyQuestions = retrieveAllSurveyQuestions(surveyId);
		if(allSurveyQuestions==null) {
			return null;
		}
		Question q = allSurveyQuestions.stream().filter(question->question.getId().equalsIgnoreCase(questionId)).findFirst().orElse(null);
		
		if(q==null) {
			return null;
		}
		
		return q;
		
	}


	public String addNewSurveyQuestion(String surveyId, Question question) {
		// TODO Auto-generated method stub
		
		List<Question> allSurveyQuestions = retrieveAllSurveyQuestions(surveyId);
		
		question.setId(generateRandomId());
		
		
		
		allSurveyQuestions.add(question);
		
		return question.getId();
		
	}


	private String generateRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32,secureRandom).toString();
		return randomId;
	}


	


	public String deleteSurveyQuestion(String surveyId, String questionId) {
		// TODO Auto-generated method stub
		
		List<Question> allSurveyQuestions = retrieveAllSurveyQuestions(surveyId);
		if(allSurveyQuestions==null) {
			return null;
		}
		Predicate<? super Question> predicate = question->question.getId().equalsIgnoreCase(questionId);
		
		boolean removeIf = allSurveyQuestions.removeIf(predicate);
		if(!removeIf) {
			return null;
		}
		
		return questionId;
		
	}


	public void updateSurveyQuestion(String surveyId, String questionId, Question question) {
		// TODO Auto-generated method stub
		List<Question> allSurveyQuestions = retrieveAllSurveyQuestions(surveyId);
		allSurveyQuestions.removeIf(q->q.getId().equalsIgnoreCase(questionId));
		question.setId(questionId);
		allSurveyQuestions.add(question);
		
	
		
		
		
	}




	
}
