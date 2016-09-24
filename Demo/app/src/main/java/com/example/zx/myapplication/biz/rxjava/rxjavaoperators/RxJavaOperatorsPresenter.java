package com.example.zx.myapplication.biz.rxjava.rxjavaoperators;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by ex-zhangxiang on 2016/9/23.
 */

public class RxJavaOperatorsPresenter implements RxjavaOperatorsContract.presenter {

	private RxjavaOperatorsContract.view view;

	public RxJavaOperatorsPresenter(RxjavaOperatorsContract.view view){
		this.view = view;
		view.setPresenter(this);
	}

	@Override
	public void rxjavaOperators() {
		Observable.just("operators")
				.map(new Func1<String, String>() {
					@Override
					public String call(String s) {
						return "map---" + s;
					}
				})
				.subscribe(s -> view.showtip(s));
	}

	@Override
	public void rxjavaOperators2() {
		Observable.just("operators2")
				.map(s -> "map2---" + s)
				.subscribe(s -> view.showtip(s));
	}

	@Override
	public void rxjavaOperators3() {
		Observable.just("operators3")
				.map(s -> "operators3 hashcode:" + s.hashCode())
				.subscribe(s -> view.showtip(s+""));
	}

	@Override
	public void rxjavaOperators4() {
		Observable.just("operators4")
				.map(s -> s.hashCode())
				.map(s -> Integer.toString(s))
				.subscribe(s -> view.showtip(s));
	}

	private Observable<List<String>> query(String text) {
		List<String> urls = new ArrayList<String>();
		urls.add("url1---" + text);
		urls.add("url2---" + text);
		urls.add("url3---" + text);

		return Observable.just(urls);
	}

	@Override
	public void rxjavaFlatMap() {
		query("test")
				.subscribe(urls -> {
					for (String url : urls) {
						view.showtip(url);
					}
				});
	}

	/**
	 * Observable.from()方法，它接收一个集合作为输入，然后每次输出一个元素给subscriber
	 */
	@Override
	public void rxjavaFlatMap2() {
		query("test2")
				.subscribe(urls -> Observable.from(urls)
					.subscribe(url -> view.showtip(url)))
				;
	}

	@Override
	public void rxjavaFlatMap3() {
		query("test3").flatMap(new Func1<List<String>, Observable<String>>() {
			@Override
			public Observable<String> call(List<String> strings) {
				return Observable.from(strings);
			}
		}).subscribe(s -> view.showtip(s+""));
	}

	@Override
	public void rxjavaFlatMap4() {
		query("test4")
				.flatMap(strings -> Observable.from(strings))
				.subscribe(s -> view.showtip(s));
	}

	private Observable<String> getTitle(String URL){
		return Observable.just("getTitle---:  " + URL);
	}

	@Override
	public void rxjavaFlatMap5() {
		query("test5")
				.flatMap(strings -> Observable.from(strings))
				.flatMap(strings -> getTitle(strings))
				.subscribe(s -> view.showtip(s));
	}

	@Override
	public void rxjavaFlatMap6() {

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
