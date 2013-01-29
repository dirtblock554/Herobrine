package com.kreckin.herobrine.impl;

import com.kreckin.herobrine.api.IActionResult;

public class ActionResult implements IActionResult {

    private final String data, message;
    
    public ActionResult(String message) {
        this(message, null);
    }
    
    public ActionResult(String message, String data) {
        this.message = message;
        this.data = data;
    }

    @Override
    public String getData() {
        return this.data;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
