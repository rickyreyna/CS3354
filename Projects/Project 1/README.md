This instructor provided solution is a starting point for project1

## How to use git repositories for project1 submission

0. NetID or TeamID is **ID** in the text below 

1. If you have cloned 2020Fall repo, navigate to local src directory and pull the code 
```
cd 2020Fall
git pull
```
* navigate to src folder
* copy project1 folder 

2. Clone your class inside 2020Fall folder, on the same terminal: 
```
git clone git.txstate.edu/CS3354/NetId.git
cd ID
```
* paste project1 folder here 

3. Note that you have already setup data folder, and you can use it for your project
   * cannot push it to 2020Fall
   * do not need to push it to your project repo 

4. make changes to java code in **ID/project1** folder and save changes using IDE or text editor of choice 
  * Visual Studio Code
  * IntelliJ
  * Eclipse
  * Netbeans
  * Notepad++
  * Atom
  
5. check in changes to  **ID** repository - make sure you are in **ID** folder for git commandline:

```
cd 2020Fall/ID
git add project1/*.java
git commit -m "Project 1 code update comment here"
gitk
```
gitk will show you the status, close it to continue
```
git push origin:<NET_ID>
```

6. Repeat step 5 often to save your work until done. 
  * it allows you to re-trace your steps
  * do not forget to list **ALL** team members under @author javadoc tag

7. Done! 
## Other Class resources 
* [lectures](canvas.txstate.edu)
* [material](git.txstate.edu/CS3354/material)
