package vpn

import java.net.ServerSocket
import java.net.Socket


fun main(args: Array<String>) {
    val serverSocket = ServerSocket(12345)


        val clientSocket = serverSocket.accept()
        print(clientSocket.receiveBufferSize)
        print("Got connection from client..")

    val socket = Socket("127.0.0.1", 12345)
    socket.getOutputStream().write(12)
}

