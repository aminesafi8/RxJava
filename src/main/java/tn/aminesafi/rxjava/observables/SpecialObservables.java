package tn.aminesafi.rxjava.observables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SpecialObservables {
    public static void main(String[] args) {
        createSingle();
        createMaybe();
        createCompletable();
    }

    private static void createSingle() {
        Single.just("Hello Amine").subscribe(System.out::println); // SingleObserver
    }

    private static void createMaybe() {
        Maybe.empty().subscribe(new MaybeObserver<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                log.info("onSubscribe");
            }

            @Override
            public void onSuccess(@NonNull Object o) {
                log.info("onSuccess [{}]", o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                log.error("onError");
            }

            @Override
            public void onComplete() {
                log.warn("onComplete");
            }
        });
    }

    private static void createCompletable() {
        Completable.fromSingle(Single.just("Hello Amine")).subscribe(() -> System.out.println("Done"));
    }


}
