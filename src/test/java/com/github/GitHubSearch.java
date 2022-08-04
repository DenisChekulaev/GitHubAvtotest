package com.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSearch {
      @BeforeAll
    static void configure(){
          Configuration.browser ="chrome";
          Configuration.holdBrowserOpen = true;

      }
     @Test
    void searchGithub(){
          open("https://github.com/");
         $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
         $$("ul.repo-list li").first().$("a").click();
         $("#wiki-tab").click();
         $(".markdown-body").shouldHave(text("Soft assertions"));
         $(byText("Show 2 more pages…")).scrollTo().click();
         $(byText("Soft assertions")).click();
         $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

     }


}
