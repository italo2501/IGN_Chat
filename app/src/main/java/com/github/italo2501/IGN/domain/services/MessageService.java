package com.github.italo2501.IGN.domain.services;

import com.github.italo2501.IGN.domain.model.Message;
import com.github.italo2501.IGN.util.RestClient;

import java.util.List;

public class MessageService {

    private  static final String SERVICE_API = "https://service-api.herokuapp.com/statuses";

    private  static final String QUERY_API = SERVICE_API+"?1=1";

    private static final String ORDER_BY_CREATION_DESC = "&_sort=created_at&_order=DESC";

    private final RestClient rest = new RestClient();

    public List<Message> getLastStatuses() {
        return rest.getAll(QUERY_API + ORDER_BY_CREATION_DESC, Message[].class);
    }

    public Message publish(Message message) {
        return rest.post(SERVICE_API, message, Message.class);
    }
}
