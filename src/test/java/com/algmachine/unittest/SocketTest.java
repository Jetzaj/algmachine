package com.algmachine.unittest;

import com.algmachine.AlgMachineApplication;
import com.algmachine.service.socket.GreetClient;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlgMachineApplication.class)
public class SocketTest {
    @Ignore
    @Test
    public void client_test() throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1",6666);
        String response = client.sendMessage("hello server");
        System.out.println(response);
    }

    @Ignore
    @Test
    public void givenClient1_whenServerResponds_thenCorrect() throws IOException {
        GreetClient client1 = new GreetClient();
        client1.startConnection("127.0.0.1", 6669);
        String msg1 = client1.sendMessage("hello");
        String msg2 = client1.sendMessage("world");
        String terminate = client1.sendMessage(".");

    }

    @Ignore
    @Test
    public void givenClient2_whenServerResponds_thenCorrect() throws IOException {
        GreetClient client2 = new GreetClient();
        client2.startConnection("127.0.0.1", 6669);
        String msg1 = client2.sendMessage("hello");
        String msg2 = client2.sendMessage("world");
        String terminate = client2.sendMessage(".");
    }
}
