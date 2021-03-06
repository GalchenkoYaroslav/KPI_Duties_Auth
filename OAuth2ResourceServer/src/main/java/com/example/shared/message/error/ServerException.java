package com.example.shared.message.error;

import com.example.shared.message.utils.MainServerWebException;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 11.09.2016
 */
public class ServerException extends MainServerWebException {

    public ServerException() {
        super(500, "Server error.", "Please try again later.");
    }

    public ServerException(String message) {
        super(400, message, message);
    }

}
