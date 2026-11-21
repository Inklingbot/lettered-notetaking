package com.notetaking.lettered.client;


import java.util.UUID;

public record Note (String title,
        String body,
        UUID id) {

}
