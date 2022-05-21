package tn.aminesafi.rxjava.observer;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class GenericObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        log.info("onSubscribe");
    }

    @Override
    @SneakyThrows
    public void onNext(@NonNull T t) {
        log.info("onNext [{}]", t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        log.error("onError [{}]", e.getLocalizedMessage());
    }

    @Override
    public void onComplete() {
        log.warn("onComplete");
    }
}
