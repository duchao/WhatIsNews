package com.chatgame.whatisnews.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by duchao on 2016/12/7.
 */
@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
