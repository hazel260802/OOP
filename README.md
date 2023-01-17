# OOP
## IT3103 - Lập trình hướng đối tượng

### Step 1: Basic Initialization
1. Download an IDE : We recommend IntelliJ Edu or Eclipse. You may also use other IDEs that have Maven and Git support
2. Pull this repo to your device using IDE support

**Note** : Choose Maven as project type. It will automatically set up for you

### Step 2: Workflow 
 #### GIT
 1. Create your own branch
```Console
    git branch your_branch_name             # create new branch (you should name it : yourName_purposeOfThisBranch . Ex : tu_createControllers)
    git switch your_branch_name             # use that branch 
    git push -u origin your_branch_name     # make new branch on remote repo
```
 2. Get update from main branch
```Console
    git switch your_branch_name     # make sure you are on right branch 
    git pull origin main            # update with remote main repo
    git merge origin/main           # get master update
```
 2. Commit your work    
```Console
    git add your_updated_files              # add changes to next commit, use `.` to include all files  
    git commit -m 'commit_messsage'         # commit changes from previous `git add`, commit_message should include good info : `finish some_function`, `fix some_bug`
    git push origin your_branch_name        # push changes to remote
```
 3. Delete your old branch after finish your work
```Console
    git switch main                     # go away from deleting branch
    git branch -d old_branch_name       # delete it
```
``note`` Go to step 1 and create new branch

**Note : You mustn't touch main branch**
