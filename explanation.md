## Technical Explanation ##
**`Project Structure`**
```
com.finztrust.githubapi/
- AppRun.java
- views/
  - Viewable.java
  - ViewBuilder.java
  - ProductView.java
  - ConsoleView.java
- models/
  - Users.java
  - UsersDAO.java
- connections/
  - Connectable.java
  - GithubApiConnection.java
  - HttpClientRequest.java
  - HttpUrlRequest.java
- helers/
  - Helpers.java
```

`com.finztrust.githubapi/` 
- **AppRun** Class: contains a main method to run the program. It allows to run program as a Console application (For Development Environment) or as a Production Environment. In this case, we run it as Console application.
```
ViewBuilder.getView(Helpers.DEV_ENVIRONMENT).showView();
```
