package chat;

import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndpoint {

     @OnMessage
     public String onMessage(String message, Session session) {
         return message;
     }
}
