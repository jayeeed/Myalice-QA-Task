package models;

import lombok.Getter;

@Getter
public class EnvData {
    private final String host;
    private final int wait;

    public EnvData(String host, int wait) {
        this.host = host;
        this.wait = wait;
    }
}
