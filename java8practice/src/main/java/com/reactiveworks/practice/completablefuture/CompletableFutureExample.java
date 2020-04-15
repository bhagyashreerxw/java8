package com.reactiveworks.practice.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> future=CompletableFuture.supplyAsync(()->"asdff")
				                                           .thenApply(s->s.length())
				                                           .thenApply(s->"asdff"+s);
		
		System.out.println(future.get()+" "+Thread.currentThread());

	}

}
