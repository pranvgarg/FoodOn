package com.foodon.app.SendNotification;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAuPqdjsE:APA91bGMUMExJG2k6nd8y1eiuduH3UfXFCO-BVe7ZR_YyO8KDRhr5-tu2jNOH3E-QaoWXpr782t4oH-jxl_ynUBtDmz2M2Dr_p-Ayf7f49XoGNhQ4Jb8BoYbZ3k5yPQQMn85Lu5tcPlc"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body NotificationSender body);
}
