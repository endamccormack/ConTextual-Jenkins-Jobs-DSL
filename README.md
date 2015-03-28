# ConTextual Jenkins Job DSL

## Overview
This project is going to handle my configuration of Jenkins allowing the ConTextual project to be more automated and easier to transfer from place to place.

I am using the [JenkinsCI job DSL Plugin](https://github.com/jenkinsci/job-dsl-plugin). Its going to manage the creation of my

1. Jobs configuration for each service
2. Dashboard view

## What is this for?

The Jenkins Job DSL plugin allows you to write your jobs as code, this means that you have a versioned history of your jobs as well as your code. This works really well for version tagging as you can tag not only when your code is at a stable point but also your DevOps infrastructure and your Jenkins Job configuration as well.

This gives you a strong level of confidence that a version tag will always work the way you expect should you have to roll back allowing a team more confidence to try new things with a guarantee that should something go wrong that their fallback is a full snapshot of the system all around not just only your code.
