package com.blueasdfg.turling;

import com.blueasdfg.analysis.AnalysisResult;
import com.blueasdfg.turling.answer.AnalysisQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class WebTuLing {

     @RequestMapping(value = "/test/{question}", method = RequestMethod.GET)
     public String testTurling(
             @PathVariable("question") String question
     ) {
          String response = TestApi.result(question);
          return response;
     }


     @RequestMapping(value = "/test1/{text}", method = RequestMethod.GET)
     public String testAnalysis(
             @PathVariable("text") String text
     ) {
          String response = AnalysisResult.result(text);
          return response;
     }

     @Autowired
     private UserRepository userRepository;

     @GetMapping(value = "/users")
     public List<Users> usersList() {
          return userRepository.findAll();
     }

     @RequestMapping(value = "/question/{text}", method = RequestMethod.GET)
     public Users users(
             @PathVariable("text") String text
     ) {
          String response = AnalysisResult.result(text);
          Users user = new Users();
          user.setId(1);
          user.setUsername("tes1t");
          user.setLikeeat(response);
          return userRepository.save(user);
     }


     @RequestMapping(value = "/answer/{text}", method = RequestMethod.GET)
     public String answer(
             @PathVariable("text") String text
     ) {
          Integer id = 1;
          String response = AnalysisQuestion.result(text);
          Users user = userRepository.findOne(id);
          if (user.getLikeeat().equals("")) {
               return TestApi.result(text);
          } else {
               return user.getLikeeat().toString();
          }


     }

}

















