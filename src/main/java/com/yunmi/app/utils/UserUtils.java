package com.yunmi.app.utils;

import com.yunmi.app.model.system.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 */
public class UserUtils {
    public static User getCurrentUser() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
