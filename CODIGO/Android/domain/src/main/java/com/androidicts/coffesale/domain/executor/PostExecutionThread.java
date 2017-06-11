package com.androidicts.coffesale.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by alejandro on 10/06/17.
 * Androidicts.com
 */

public interface PostExecutionThread {
  Scheduler getScheduler();
}
