package servers;

import abstractions.ResponceMessage;

import java.io.IOException;

public interface AsyncSend {
    public void asyncSend(ResponceMessage resp) throws IOException;
}
