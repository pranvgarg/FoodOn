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


![3](https://user-images.githubusercontent.com/70699475/124749953-82c95400-df42-11eb-8f84-f0512e38efa4.png)
![5](https://user-images.githubusercontent.com/70699475/124749976-8957cb80-df42-11eb-90f9-24181e7ebd03.png)
![7](https://user-images.githubusercontent.com/70699475/124749982-8a88f880-df42-11eb-9c51-507c809bfcc1.png)
![8](https://user-images.githubusercontent.com/70699475/124749983-8b218f00-df42-11eb-919a-96fead250546.png)
![11](https://user-images.githubusercontent.com/70699475/124749986-8bba2580-df42-11eb-9922-99adf258cc16.png)
