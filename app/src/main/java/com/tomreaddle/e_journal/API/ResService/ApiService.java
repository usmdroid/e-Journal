package com.tomreaddle.e_journal.API.ResService;

import com.tomreaddle.e_journal.API.Model.AttendanceData;
import com.tomreaddle.e_journal.API.Model.FeedbackData;
import com.tomreaddle.e_journal.API.Model.FeedbackResponse;
import com.tomreaddle.e_journal.API.Model.InfoData;
import com.tomreaddle.e_journal.API.Model.LoginData;
import com.tomreaddle.e_journal.API.Model.TeacherData;
import com.tomreaddle.e_journal.API.Model.TimeTable;
import com.tomreaddle.e_journal.API.Model.TokenData;
import com.tomreaddle.e_journal.Attendance;
import com.tomreaddle.e_journal.Feedback;
import com.tomreaddle.e_journal.Models.model_news_item;
import com.tomreaddle.e_journal.Models.model_today_rank;
import com.tomreaddle.e_journal.Models.model_tomorrow_task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login")
    Call<TokenData> login(@Body LoginData loginData);

    @POST("suggest/faq")
    Call<FeedbackResponse> feedback(@Body FeedbackData feedbackData);


//    @Headers("Accept: application/json")
//    @GET("student/info")
//    Call<InfoData> getInfo(
//            //@Header("Authorization") String Authtoken
//    );

//    @Headers("Accept: application/json")
//    @GET("student/timetable")
//    Call<TimeTable> getTimeTable(
//            @Header("Authorization") String Authtoken
//    );

    @GET("demos/e-journal/studentInfo.json")
    Call<InfoData> getInfo();

    @GET("demos/e-journal/todayinfo.json")
    Call<List<model_today_rank>> getTimeTable();

    @GET("demos/e-journal/teacherData.json")
    Call<List<TeacherData>> getTeacherData();

    @GET("demos/e-journal/AttendanceData")
    Call<List<AttendanceData>> getAttendanceData();

    @GET("demos/e-journal/notification")
    Call<List<model_news_item>> getNotificationData();

    @GET("demos/e-journal/tomorrowTasks")
    Call<List<model_tomorrow_task>> getTomorrowTasks();
}
