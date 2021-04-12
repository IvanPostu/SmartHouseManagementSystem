package com.ivan.app.l5;

import com.ivan.app.service.AlarmService;
import com.ivan.app.service.AlarmServiceImpl;

public class Main {

    public static void main(String[] args) {
        AlarmService service = new AlarmServiceImpl();
        service.sendAlarmToServer("Casa a luat foc!!!!");
        service.sendAlarmToServer("In casa a intrat un hot!!!!");
    }

}
