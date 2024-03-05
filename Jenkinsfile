pipeline {
    agent any
    
    stages {
        /* stage('Checkout') {
            steps {
                // Checkout your source code from version control, for example, Git
                git 'https://github.com/ebasso/java-jenkins.git'
            }
        }*/
        
        stage('Compile') {
            steps {
                // Compile Java code using a specific JDK
                sh 'mkdir -p target' // Create the target directory if it doesn't exist
                sh 'find src -name "*.java" > sources.txt' // List all Java files recursively and save to sources.txt
                sh '/opt/ibm_java/bin/javac -d target -cp "/jar1/jarX.jar:/jar2/*.jar" @sources.txt' // Compile all Java files listed in sources.txt using the specified JDK and include JAR files from specified directories
            }
        }
        
        stage('Zip') {
            when {
                expression { currentBuild.result == 'SUCCESS' }
            }
            steps {
                // Zip the contents of the target directory
                sh 'cd target && zip -r ../compiled_code.zip *'
            }
        }
    }
    
    post {
        success {
            // Do something if the build is successful
            echo 'Java code compiled successfully!'
        }
        failure {
            // Do something if the build fails
            echo 'Failed to compile Java code'
        }
    }
}
