package com.androidicts.coffesale.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by alejandro on 11/06/17.
 * Androidicts.com
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
