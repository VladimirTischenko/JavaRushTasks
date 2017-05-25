package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Vladimir on 20.05.2017.
 */
public class Server {
    static private Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String name = null;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    name = message.getData();
                    if (!name.isEmpty() && !connectionMap.containsKey(name)) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return name;
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (userName != name) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receive = connection.receive();
                if (receive.getType() == MessageType.TEXT) {
                    Message message = new Message(MessageType.TEXT, userName + ": " + receive.getData());
                    sendBroadcastMessage(message);
                } else {
                    System.out.println("Сообщение не является текстом!");
                }
            }
        }

        public void run() {
            String name = null;
            ConsoleHelper.writeMessage("" + socket.getRemoteSocketAddress());
            try {
                Connection connection = new Connection(socket);
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, name));
                sendListOfUsers(connection, name);
                serverMainLoop(connection, name);
            } catch (IOException e) {
                System.out.println("ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException e) {
                System.out.println("ошибка при обмене данными с удаленным адресом");
            } finally {
                if (name != null) {
                    connectionMap.remove(name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, name));
                    System.out.println("соединение с удаленным адресом закрыто");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        Collection<Connection> connections = connectionMap.values();
        for (Connection connection : connections) {
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println("Message was not been send");
            }
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
             serverSocket = new ServerSocket(port);
            System.out.println("server is run");
            while (true) {
                Socket accept = serverSocket.accept();
                Handler handler = new Handler(accept);
                handler.start();
            }
        } catch (IOException e) {
            try {
                System.out.println(e);
                serverSocket.close();
            } catch (IOException e1) {
                System.out.println(e1);
                e1.printStackTrace();
            }
        }
    }
}
