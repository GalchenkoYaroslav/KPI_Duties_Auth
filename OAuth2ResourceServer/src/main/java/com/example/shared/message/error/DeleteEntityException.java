package com.example.shared.message.error;


import com.example.shared.message.utils.MainServerWebException;

/**
 * @author Olexandr Shevchenko
 * @version 1.0
 * @since 03.10.2016
 * <p>
 * Delete entity exception
 */
public class DeleteEntityException extends MainServerWebException {

    public DeleteEntityException() {
        super(400, "Delete entity exception.", "");
    }

    public DeleteEntityException(String msg) {
        super(400, msg, msg);
    }
}
