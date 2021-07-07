# FoodOn

![Screenshot 2021-07-07 at 1 20 15 PM](https://user-images.githubusercontent.com/70699475/124721359-ad0d1880-df26-11eb-8d01-4d3c92c9db7e.png)

Instruction Guide :
Clone repository

Open the Project in your android studio

IMPORTANT:- Change the PackageName

Create Firebase project.

Connect Firebase with Android Studio.

Download the file google-service.json from firebase project setting and import into your project

IMPORTANT FOR NOTIFICATION:- Copy Server key from Firebase/Project Setting/cloudmessaging/ and paste it in APIService.java class

Alert

If you will not connect with your firebase and try to run this app with mine firebase connection than you will not see any dish etc. Because I have restricted the rules to read and write

Corection in Delivery Panel
After Registering as delivery person , copy UID of that delivery person from firebase and in : 

"/app/src/main/java/com/food_on/app/ChefFoodPanel/ChefPreparedOrderView.java" file at line 65=> String deliveryId = ""; paste here. Similarly, Do this in DeliveryPendingOrderFragment.java file
