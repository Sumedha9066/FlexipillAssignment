# FlexipillAssignment

1. Project Structure
Copy code
project-root/
FlexiPill_Test_Cases/
├── README.md                    
├── pom.xml (or build.gradle)     
├── src/
│   └── test/
│       ├── java/
│       │   ├── flexipilltests/
│       │   │   ├── AddToCart.java                
│       │   │   ├── CreateOrderTests.java  
│       │   │   ├── LoginPage.java   
│       │   │   ├── LogInTests.java  
│       │   │   └── PlaceOrder.java
│       └── resources/
│           └── config.properties
└── test-output/
    └── reports/


2. Installation and Setup Instructions
     Clone the repository
     git clone : https://github.com/Sumedha9066/FlexipillAssignment
     Good to terminal and go to project folder
     mvn install
3. Running the Tests
    To execute the tests, use the following command:
     1.mvn clean
     2.mvn install
     3.mvn test

4. Test Cases Documentation
     Login Test Cases:
       Positive: Verify login with correct credentials (1111111111, 1111).
       Negative: Verify login with incorrect credentials(222235567)

   Add to Cart Test Cases:
       Positive: Verify adding an item to the cart with valid drugCode and increaseQuantityBy.
       Positive: Verify placing an order with valid patient details and COD payment type.

   Create Order/place order
      Positive:verifying  the cash on delivery process with placing order
      Positive:verifying the order Details for after creating successful placing order
