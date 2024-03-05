# maximo-jenkins
Working with Maximo and Jenkins


Create pipeline in Jenkins that:
1) Checkout your source code from this repository
2) Use the steps in Jenksfile


In **Jenkinsfile** will do:

On stage **Compile**
1) Create the target directory if it doesn't exist
2) List all Java files recursively and save to sources.txt
3) Compile all Java files listed in sources.txt using the specified JDK and include JAR files from specified directories

On stage **Zip**
4) Zip the contents of the target directory and generate a customization_binaries.zip
