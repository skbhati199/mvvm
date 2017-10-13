package com.infoskillstechnology.homeworkout.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Skbhati on 13-10-2017.
 * Info Skills Technology Pvt. Ltd.
 * skbhati199@gmail.com
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
