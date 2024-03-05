# maximo-jenkins
Working with Maximo and Jenkins

The following is the procedure to create a CI/CD pipeline to compile the custom classes used in IBM Maximo EAM.

P.S.: for MAS it is in progress. :)

As prerequisites I need the IBM Java SDK installed and the Maximo Administrative Workstation directory (/opt/IBM/SMP)

## Create pipeline in Jenkins that:

1) Checkout your source code from this repository

![Pipeline01](readme_images/pipeline01.png)

2) Define the branch

![Pipeline02](readme_images/pipeline02.png)

3) Use the steps in Jenksfile

![Pipeline03](readme_images/pipeline03.png)

## In **Jenkinsfile** will do:

1) Compile: Creates the target directory, lists all Java files recursively, saves the list to sources.txt, and then compiles all Java files listed in sources.txt into the target directory.
2) Zip: Zips the contents of the target directory into a file named customization_binaries.zip.
3) Post-build: Displays a message indicating whether the build succeeded or failed.
