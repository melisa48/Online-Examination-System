package models;

public class Question {
     private String questionText;
     private String optionA;
     private String optionB;
     private String optionC;
     private String optionD;
     private String correctOption;
 
     public Question(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
         this.questionText = questionText;
         this.optionA = optionA;
         this.optionB = optionB;
         this.optionC = optionC;
         this.optionD = optionD;
         this.correctOption = correctOption;
     }
 
     public String getQuestionText() {
         return questionText;
     }
 
     public String getOptionA() {
         return optionA;
     }
 
     public String getOptionB() {
         return optionB;
     }
 
     public String getOptionC() {
         return optionC;
     }
 
     public String getOptionD() {
         return optionD;
     }
 
     public String getCorrectOption() {
         return correctOption;
     }
 }
 