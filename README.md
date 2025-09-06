💳 Simple ATM Application (Java Console-based)

A console-based ATM simulation program written in Java. This application allows users to securely login with a PIN and perform basic ATM operations such as depositing, withdrawing, checking balance, and exiting. Designed for educational and software practice purposes.

🧾 Features

🔐 PIN Authentication (default PIN: 1234)

➕ Deposit Money

➖ Withdraw Money

💰 Check Account Balance

🚪 Exit Application

💻 Tech Stack

Language: Java

JDK Version: Java 8 or higher

Interface: Console-based (no GUI)

Packaging: .class & .jar file (optional for deployment)

🏦 Welcome to HDFC Bank ATM
🔐 Enter 4-digit PIN: ****
✅ PIN correct. Welcome!

💼 ATM Main Menu
1. ➕ Deposit
2. ➖ Withdraw
3. 💰 Check Balance
4. 🚪 Exit
Choose an option:
🚀 How to Run
🛠 Compile the code
javac SimpleATM.java

▶️ Run the program
java SimpleATM

📦 Optional: Run JAR file
java -jar SimpleATM.jar

🏗 How to Create a JAR File (Optional)

If you want to create and run a JAR (Java Archive):

javac SimpleATM.java
jar cfe SimpleATM.jar SimpleATM SimpleATM.class


Then run:

java -jar SimpleATM.jar

🛡 Security

This is a simple educational project. The PIN is hardcoded (1234) and stored as plain text in the code. In real-world applications, never store sensitive data like this — always use encryption and secure authentication systems.
