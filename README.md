# ConTextual Jenkins Job DSL

## Overview
This project is going to handle my configuration of Jenkins allowing the ConTextual project to be more automated and easier to transfer from place to place.

I am using the [JenkinsCI job DSL Plugin](https://github.com/jenkinsci/job-dsl-plugin). Its going to manage the creation of my

1. Jobs configuration for each service
2. Dashboard view

## What is this for?

The Jenkins Job DSL plugin allows you to write your jobs as code, this means that you have a versioned history of your jobs as well as your code. This works really well for version tagging as you can tag not only when your code is at a stable point but also your DevOps infrastructure and your Jenkins Job configuration as well.

This gives you a strong level of confidence that a version tag will always work the way you expect should you have to roll back allowing a team more confidence to try new things with a guarantee that should something go wrong that their fallback is a full snapshot of the system all around not just only your code.

## Lets get this party started

To launch the DSL's go to jenkins (normally on http://localhost:8080 on your local machine once launched)

1. We need to install 2 plugins for jenkins,
from the home screen goto "Manage Jenkins" > "Manage Plugins", click on "available", search for and install:
  1. [Git Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Git+Plugin)  
  2. [Job DSL](https://wiki.jenkins-ci.org/display/JENKINS/Job+DSL+Plugin)
2. Create a job
  1. Click "new item" (top left home screen)
    1. Name it
    2. Select freestyle
  2. Set your Git repo
    1. Select the radio button for "git"
    2. Add in your git https link to your DSL repo e.g. [this repo link](https://github.com/endamccormack/ConTextual-Jenkins-Jobs-DSL.git)
  3. Add the build
    1. Click "Add build step" > "Process Job DSLs"
    2. Select the "Look on Filesystem"
    3. In the "DSL Scripts" textbox paste in ``` src/main/groovy/*.groovy ```
  4. Press "save"
  5. Press "build"

You're done, it should add all your jobs set out in the DSL repo. They just need to be ran.
