# Finztrust
Finztrust Exercise - GithubAPI Console Program

### INSTALLATION ###
- [x] Basic Installation
    - It is required to download Java Runtime Environment (JRE) 8 or higher.
    You also can download from [here](https://drive.google.com/drive/folders/1ozz5YfijATTswzrxnfg78_c5IRwkNmOD?usp=sharing)
    - Install the downloaded JRE.

### RUN THE PROGRAM ###
  #### I. For user: ####
  - Download the [finztrust.jar](finztrust.jar) file .
  - Open Command-Prompt (for Window), then go to the finztrust.jar directory.
    `example: C:\users\developer\finztrust>`
  - Run command in Command-Prompt: `> java -jar finztrust.jar`
 
  #### II. For Developer: ####
  - Download the project folder and import into Eclipse IDE
  - Run as Java Application
  
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
