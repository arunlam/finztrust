## EXPLANATION ##
#### Introduction ####
**`Finztrust`** is a console program built for pulling data from API [_Github Users_](https://api.github.com/users).
It allows to get data of the first 20 Github users, and displays the information `(Login Name, Link to user's profile, number of repos, number of followers, number of following)` of the Github user by typing an `ID`.
This program does not store the data in the file system or hard disk.

#### Technical Explanation ####
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
