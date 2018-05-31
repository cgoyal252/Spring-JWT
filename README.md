# Spring-Rest-With-JWT
Spring Rest with JWT Authorization

## for storing user details :- mysql server is there
## for token storing :- redis server is there



post 
1 signup :-  http://localhost:8080/api/auth/signup


        {
  "password" : "dsdds"
        }
		
		
	2 signin:-

     	 http://localhost:8080/api/auth/signin
		 
		 {
  "uid" : "86cfeb50-53c6-47d8-8872-47562a35de14",
  "password" : "dsdds"
  
           }
		 
		 
3 post a notification

         http://localhost:8080/api/user/notifications		 
		 
		post 
1 signup :-  http://localhost:8080/api/auth/signup


        {
  "password" : "dsdds"
        }
		
		
	2 signin:-

     	 http://localhost:8080/api/auth/signin
		 
		 {
  "uid" : "86cfeb50-53c6-47d8-8872-47562a35de14",
  "password" : "dsdds"
  
           }
		 
		 
3 post a notification

         http://localhost:8080/api/user/notifications		 
		 
		 
		 {
  "message" : "sdsdsd"
         }
		 
		 
		 4. get a notification
		 
		 http://localhost:8080/api/users/notifications
		 
		 
		 
		 
		 
		 5.delete
		 
		 
		 http://localhost:8080/api/users/del/5
		 
		 4. get a notification
		 
		 http://localhost:8080/api/users/notifications
		 
		 
		 
		 
		 
		 5.delete
		 
		 
		 http://localhost:8080/api/users/del/5
