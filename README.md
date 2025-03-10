# 🏈 Team Schedule App

📱 **Android Application for Viewing Team Schedules**  

## 📌 Overview
The **Team Schedule App** is an Android application that allows users to view team schedules, including game sections, game details, and team information. The app fetches data from a remote API and presents it in a structured and user-friendly UI.

This project follows **MVVM with Clean Architecture** to ensure **modularity, scalability, and maintainability**.

---

## 🎯 Features
✔️ Fetches and displays team schedules from a remote API.  
✔️ Categorizes games based on their type (**scheduled, final, bye week**).  
✔️ Displays detailed game information, including teams, scores, and dates.  
✔️ Implements **robust error handling** for API failures.  
✔️ Follows **MVVM with Clean Architecture** for separation of concerns.  
✔️ Integrates **Hilt** for dependency injection.  
✔️ Supports **unit and UI testing** using MockK and Jetpack Compose Testing.  

---

## 🛠️ Technologies Used

| **Technology**         | **Purpose**                                   |
|----------------------|-------------------------------------------|
| **Kotlin**           | Primary language for Android development  |
| **Jetpack Compose**  | Declarative UI framework                  |
| **Retrofit**         | Networking library for API calls          |
| **Hilt (Dagger Hilt)** | Dependency injection framework           |
| **Coroutines & Flow** | Asynchronous programming                 |
| **MockK**            | Unit testing framework for mocking dependencies |
| **JUnit**            | Framework for unit testing                |
| **Compose UI Testing** | Framework for UI tests                  |

---

## 🏗️ Architecture

This project follows the **MVVM with Clean Architecture** approach, ensuring a well-structured and maintainable codebase.

### 🔹 Layered Architecture

1️⃣ **Presentation Layer**  
   - Contains **ViewModels** that interact with use cases and manage UI state.  
   - Uses **Jetpack Compose** for UI rendering.  
   - Implements **state management** to update the UI reactively.  

2️⃣ **Domain Layer**  
   - Contains **use cases** that encapsulate business logic.  
   - Defines an **interface** for the repository to enforce dependency inversion.  

3️⃣ **Data Layer**  
   - Implements the **repository interface**.  
   - Uses **Retrofit** to fetch data from a remote API.  
   - Handles **data transformation** before passing it to the domain layer.  

✅ **Why Clean Architecture?**  
- Improves **scalability**, **testability**, and **maintainability**.  
- Ensures **separation of concerns**.  

---

## 🌐 API Integration

✔️ The app fetches **schedule data** from a REST API.  
✔️ Uses **Retrofit** to handle network requests efficiently.  
✔️ Maps API responses to **domain models** for better maintainability.  
✔️ Implements **error handling** to manage network failures gracefully.  

---

## 🛠️ Dependency Injection

The app uses **Hilt (Dagger Hilt)** for dependency injection to:  
- Manage instances of **Retrofit** for API communication.  
- Inject **Repository** for data fetching.  
- Inject **ViewModels** for UI state management.  
- Ensure **loose coupling** and improve testability.

---

## 🧪 Testing Strategy

### ✅ Unit Testing
- **Use Case Testing**: Verifies business logic.  
- **Repository Testing**: Ensures API calls are handled correctly.  
- **ViewModel Testing**: Checks if state updates correctly.  

### ✅ UI Testing
- Uses **Jetpack Compose Testing** to validate UI components.  
- Ensures that the **UI displays correct data** and **handles user interactions**.

---

## 🎯 Future Enhancements
🔹 **Implement caching for offline support.**  
🔹 **Add dark mode support.**  
🔹 **Improve error handling with retry mechanisms.**  

---

## 📸 Screenshots

| Regular Season 1 | Regular Season 2 | Postseason |
|------------------|------------------|------------|
| <img width="337" alt="Screenshot 1" src="https://github.com/user-attachments/assets/23390fd0-76ee-441b-9299-7df3c63a830e" /> | <img width="338" alt="Screenshot 3" src="https://github.com/user-attachments/assets/d3412be7-efba-4534-8184-9e77d2e96cef" /> | <img width="339" alt="Screenshot 2" src="https://github.com/user-attachments/assets/f02e4baa-f2c8-4329-a080-2dea8f27314f" />


## 📺 Demo Video
https://github.com/user-attachments/assets/0545fdc1-7218-4802-aa5f-46fb167e8131

https://github.com/user-attachments/assets/ee6f25c0-416e-4fd5-9453-c541af35293e

---

## 📦 How to Run the Project

1️⃣ Clone the repository:  
```bash
git clone https://github.com/manan86/TeamScheduleApp.git
