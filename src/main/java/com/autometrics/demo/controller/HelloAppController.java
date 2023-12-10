package com.autometrics.demo.controller;

import dev.autometrics.bindings.Autometrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloAppController {

    private static final Logger log =
            LoggerFactory.getLogger(HelloAppController.class);

    @RequestMapping(method= RequestMethod.GET, value="/hello")
    @Autometrics
    public Response hello() {
        Response response = buildResponse();

        if (response.isValid()) {
            log.info("The response is valid.");
        }
        return response;
    }


    @Autometrics
    private Response buildResponse() {
        return new Response("Hello from Autometrics!");
    }

    private record Response (String message) {
        private Response {
            Objects.requireNonNull(message);
        }
        private boolean isValid() {
            return true;
        }
    }

}

