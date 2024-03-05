pipeline {
    agent any

    environment {
        // Define environment variables here
        JAVA_HOME = '/opt/IBM/ibm-java-x86_64-80'
        LIB_DIR = '/opt/IBM/SMP_7613/maximo/applications/maximo/lib/*'
        CLASS_DIR = '/opt/IBM/SMP_7613/maximo/applications/maximo/businessobjects/classes/*'
        // Add more variables as needed
    }
    
    stages {
        /* stage('Checkout') {
            steps {
                // Checkout your source code from version control, for example, Git
                git 'https://github.com/ebasso/maximo-jenkins.git'
            }
        }*/
        
        // Create the target directory if it doesn't exist
        // List all Java files recursively and save to sources.txt
        // Compile all Java files listed in sources.txt using the specified JDK and include JAR files from specified directories
        stage('Compile') {
            steps {
                // Compile Java code using a specific JDK
                sh 'mkdir -p target' 
                sh 'find src -name "*.java" > sources.txt' 
                sh '$JAVA_HOME/bin/javac -d target -cp "$LIB_DIR:$CLASS_DIR" @sources.txt' 
            }
        }
        
        stage('Zip') {
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
