Overview
This Android application demonstrates proficiency in API integration, user interface design, and Android development best practices. The app consists of three main screens: Login, Dashboard, and Details. It interacts with the vu-nit3213-api to authenticate users and retrieve data.

Features
Login Screen: Allows users to authenticate with their credentials.
Dashboard Screen: Displays a list of entities fetched from the API.
Details Screen: Shows detailed information about a selected entity.

Technologies
Kotlin for Android development.
Retrofit for API integration.
Hilt for dependency injection.
RecyclerView for displaying lists.
ConstraintLayout for flexible and elegant UI design.

Setup
Prerequisites
Android Studio installed on your machine.
Basic knowledge of Android development and Kotlin.

git clone https://github.com/sakshamkhurana16/SakshamApp.git
cd your-repository

API Configuration
Update the ApiService interface in ApiService.kt to use the appropriate endpoint based on your class location (/footscray/auth, /sydney/auth, or /ort/auth).

Build and Run
Sync Project: Click "Sync Now" in Android Studio to sync your project with Gradle files.
Run the App: Click the "Run" button in Android Studio or use ./gradlew installDebug from the command line.

Usage
Login Screen
Enter your username and password.
Click the "Login" button.
On successful authentication, you'll be redirected to the Dashboard screen.
Dashboard Screen
View a list of entities.
Click on an item to view its details on the Details screen.
Details Screen
View detailed information about the selected entity, including a description.
