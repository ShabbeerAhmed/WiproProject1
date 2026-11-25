pipeline {
    agent any

    environment {
        DOCKER_USER = 'shabbeershariff'
        DOCKER_CREDS = credentials('dockerhub-creds')
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com'
            }
        }

        stage('Build Maven JARs') {
            steps {
                sh '''
                    cd naming-server && mvn clean package -DskipTests
                    cd ../coupon-app && mvn clean package -DskipTests
                    cd ../product-app && mvn clean package -DskipTests
                '''
            }
        }

        stage('Build Docker Images') {
            steps {
                sh '''
                    docker build -t $DOCKER_USER/naming-server:latest ./naming-server
                    docker build -t $DOCKER_USER/coupon-app:latest ./coupon-app
                    docker build -t $DOCKER_USER/product-app:latest ./product-app
                '''
            }
        }

        stage('Push to Docker Hub') {
            steps {
                sh '''
                    echo $DOCKER_CREDS_PSW | docker login -u $DOCKER_USER --password-stdin
                    docker push $DOCKER_USER/naming-server:latest
                    docker push $DOCKER_USER/coupon-app:latest
                    docker push $DOCKER_USER/product-app:latest
                '''
            }
        }
    }
}
