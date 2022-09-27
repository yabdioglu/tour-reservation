package com.yabdioglu.tourreservation.shared;


import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ PARAMETER })
@Retention(RUNTIME)
@AuthenticationPrincipal // User user = (User) authentication.getPrincipal(); bu işlemi bizim yerimize yapacak
public @interface CurrentUser {
}
