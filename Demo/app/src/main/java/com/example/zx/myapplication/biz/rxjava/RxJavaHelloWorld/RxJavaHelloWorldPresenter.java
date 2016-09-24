package com.example.zx.myapplication.biz.rxjava.RxJavaHelloWorld;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by ex-zhangxiang on 2016/9/23.
 */

public class RxJavaHelloWorldPresenter implements RxJavaHelloWorldContract.presenter{

	RxJavaHelloWorldContract.view view;

	public RxJavaHelloWorldPresenter(RxJavaHelloWorldContract.view view){
		this.view = view;
		view.setPresenter(this);
	}

	private Observable<String> myObservable = Observable.create(
			new Observable.OnSubscribe<String>(){

				@Override
				public void call(Subscriber<? super String> subscriber) {
					subscriber.onNext("Hello World!");
					subscriber.onCompleted();
				}
			}
	);

	private Subscriber<String> mySubscriber = new Subscriber<String>() {
		@Override
		public void onCompleted() {
		}

		@Override
		public void onError(Throwable e) {
		}

		@Override
		public void onNext(String s) {
			view.showLog(s);
		}
	};

	@Override
	public void rxjavaHelloWorld() {
		myObservable.subscribe(mySubscriber);
	}

	@Override
	public void rxjavaHelloWorld2() {
		Observable.just("Hello World!-----2").subscribe(new Action1<String>() {
			@Override
			public void call(String s) {
				view.showLog(s);
			}
		});
	}

	@Override
	public void rxjavaHelloWorld3() {
		Observable.just("Hello World!-----3").subscribe(s -> view.showLog(s));
	}

	@Override
	public void start() {

	}

	@Override
	public void subscribe() {

	}

	@Override
	public void unsubscribe() {

	}

}
