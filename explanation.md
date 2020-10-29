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
> ``` ViewBuilder.getView(Helpers.DEV_ENVIRONMENT).showView(); ```

`com.finztrust.githubapi.views/`
- **Viewable** interface: allows the View classes (ConsoleView or ProductView class) to implement the function `showView()`;
- **ViewBuilder** class: a builder class contains a static function `getView()` which returns the `Viewable` type in case of user wants to run a program as Dev_Environment or Prod_Environment.
- **ConsoleView** class: a class to display the program. It get Input by user typing. And it also validates an input whether the input was typed in the correct format, or contains in the downloaded data or not.
