package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url; // 서버 url

    // 접속 url 출력
    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    // url은 외부에서 주입
    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    // 서비스 연결이 된 상태에서 호출할 수 있음
    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }

    // 의존 관계 주입이 끝나면 호출
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    // 빈이 종료되기 직전에 호츨됨.
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
