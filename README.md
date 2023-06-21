# TEST ASSIGNMENT FOR THE JAVA TRAINEE VACANCY


## Project description :

This is a REST API application in the MVC architectural style based on the Spring Boot framework, which implements a one-to-many composition with **Profile** and **Post** models. Profile has fields for personal information about a person. Post contains information about the author, the topic and the text. One profile may have one, several posts, or there may be no posts. Posts cannot exist without a profile.

In **Profile** we have six fields :
* *id*
* *email*
* *name*
* *surname*
* *location*
* *age*

In **Post** we have five fields :
* *id*
* *author*
* *topic*
* *text*
* *profileId*

## List of dependencies :

* spring-boot-starter-data-jpa
* spring-boot-starter-web
* liquibase-core
* postgresql
* lombok
* the Postman collection files are in a file with the name postman_collection.json

## Setting up :

* clone the project from this repository
* make mvn clean install
* in the file "application.properties" type the correct data in the lines:
  * *SPRING_DATASOURCE_URL*
  * *SPRING_DATASOURCE_USERNAME*
  * *SPRING_DATASOURCE_PASSWORD* 
* run the project

## Description of the application features :

* open Postman
* to create a profile you should go to the page *http://localhost:8080/profiles*, choose a POST request and create a profile by entering data in the JSON type (the Id of the profile will be created automatically), for example :

  ````
  {
    "email":"example@gmail.com",
    "name":"John",
    "surname":"Watson",
    "location":"USA",
    "age":"44"
  }
* to make sure that the profile has been created, go to the page *http://localhost:8080/profiles* and choose a GET request
* you should see the profile that you created
* to update the profile go to *http://localhost:8080/profiles*, choose a PUT request enter new information in profile in the JSON type, for example :

  ````
  {
    "id":"*your id*"
    "email":"changeExample@gmail.com",
    "name":"To",
    "surname":"Watson",
    "location":"USA",
    "age":"44"
  }
* to create a post you should go to the page *http://localhost:8080/posts*, choose a POST request and create a post by entering data in the JSON type (the Id of the post will be created automatically), for example :

  ````
  {
    "author": "Ramil",
    "topic":"cinematography",
    "text":"Today I watched Interstellar. It's a really interesting movie",
    "profileId":"*your profile id*"
  }
* next, you can create a few more posts
* to view all posts you should go to the page *http://localhost:8080/posts*, choose a GET request
* you should see the posts that you created
* to view profiles with posts you should go to the page *http://localhost:8080/profiles* and choose a GET request
* to update some post go to *http://localhost:8080/posts*, choose a PUT request enter new information in profile in the JSON type, for example :

  ````
  {
    "id": "*post id*",
    "author": "Ramil",
    "topic":"cinematography",
    "text":"Today I watched Interstellar. It's a really interesting movie, but the ending was disappointing...",
    "profileId":"*your profile id*"
  }
* to delete a post you should write its id in the url path, for example, *http://localhost:8080/posts/post_id* and choose DELETE request
* to make sure that the post has been deleted, go to the page *http://localhost:8080/posts* and choose a GET request
* you should not see the deleted post
* to delete a profile, you need to perform the same steps as to delete a post
* to write profile id in the url path, for example, *http://localhost:8080/profiles/profile_id* and choose DELETE request
* to make sure that the profile with its posts has been deleted, go to the page *http://localhost:8080/profiles* and choose a GET request
* you can also make sure by going to the page *http://localhost:8080/posts* and choose a GET request
* you should not see the posts of the deleted profile
* additionally, was implemented a search by id for the profile and the post
* *http://localhost:8080/profiles/profile_id* and choose GET request - for profiles
* *http://localhost:8080/posts/posts_id* and choose GET request - for posts

###  That's the end. Thanks for your attention!
