package com.school.shared.event;

import java.time.LocalDateTime;
import java.util.Map;

public interface Event {

    LocalDateTime moment();
    EventTpe type();
    Map<String, Object> information();
}
