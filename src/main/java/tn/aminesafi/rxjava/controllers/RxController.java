package tn.aminesafi.rxjava.controllers;

import io.reactivex.rxjava3.core.Observable;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tn.aminesafi.rxjava.models.Todo;
import tn.aminesafi.rxjava.observer.GenericObserver;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("api/rx")
public class RxController {

    private final RestTemplate restTemplate;

    @GetMapping
    @SneakyThrows
    public void fetchTodos() {
        val todos = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", Todo[].class);
        Observable<Todo> observable = Observable.fromArray(todos);

        //Thread.sleep(5000);

        GenericObserver<Todo> observer = new GenericObserver<>();
        observable.subscribe(observer);
    }

    @GetMapping("lazy")
    public void lazyObservable() {
        // lazy observable
        val todos = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos", Todo[].class);
        Observable<Todo> observable = Observable.fromCallable(() -> {

            int x = 9 / 0; // code getting executed only when the observer subscribe and execute the onError() callback
            return todos[0];
        });

        GenericObserver<Todo> observer = new GenericObserver<>();
        observable.subscribe(observer);
    }
}
