pipeline {
    agent any
    
    stages {
        /* stage('Checkout') {
            steps {
                // Checkout your source code from version control, for example, Git
                git 'https://github.com/ebasso/maximo-jenkins.git'
            }
        }*/
        
        stage('Compile') {
            steps {
                // Compile Java code using a specific JDK
                sh 'mkdir -p target' // Create the target directory if it doesn't exist
                sh 'find src -name "*.java" > sources.txt' // List all Java files recursively and save to sources.txt
                sh '/opt/IBM/ibm-java-x86_64-80/bin/javac -d target -cp "/opt/IBM/SMP_7613/maximo/applications/maximo/lib/*.jar" @sources.txt' // Compile all Java files listed in sources.txt using the specified JDK and include JAR files from specified directories
            }
        }
        
        stage('Zip') {
            when {
                expression { currentBuild.result == 'SUCCESS' }
            }
            steps {
                // Zip the contents of the target directory
                sh 'cd target && zip --verbose -r ../customization_binaries.zip *'
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
