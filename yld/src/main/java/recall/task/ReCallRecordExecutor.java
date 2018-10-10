package com.cf.web.order.recall.task;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * 回溯线程池
 * 此线程池不允关闭
 * 不能执行以下操作
 * executor.shutdown()
 * executor.shutdownNow()
 * executor.awaitTermination(timeout, unit)
 * @author yuleidian
 * 2018年1月2日 下午4:16:55
 */
public final class ReCallRecordExecutor implements ListeningExecutorService {

	private final ListeningExecutorService executor;
	
	private ReCallRecordExecutor () {
		executor = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
	}
	
	private static class Singleton {
    	private static ReCallRecordExecutor INSTANCE = new ReCallRecordExecutor();
    }
	
	public static ReCallRecordExecutor getInstance() {
		return Singleton.INSTANCE;
	}

	@Override
	public void execute(Runnable command) {
		executor.execute(command);
	}

	@Override
	@Deprecated
	public void shutdown() {
	}

	@Override
	@Deprecated
	public List<Runnable> shutdownNow() {
		return null;
	}

	@Override
	public boolean isShutdown() {
		return executor.isShutdown();
	}

	@Override
	public boolean isTerminated() {
		return executor.isTerminated();
	}

	@Override
	@Deprecated
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return false;
	}

	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
		return executor.invokeAll(tasks);
	}

	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
		return executor.invokeAll(tasks, timeout, unit);
	}

	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
		return executor.invokeAny(tasks);
	}

	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return executor.invokeAny(tasks, timeout, unit);
	}

	@Override
	public <T> ListenableFuture<T> submit(Callable<T> task) {
		return executor.submit(task);
	}

	@Override
	public ListenableFuture<?> submit(Runnable task) {
		return executor.submit(task);
	}

	@Override
	public <T> ListenableFuture<T> submit(Runnable task, T result) {
		return executor.submit(task, result);
	}
}
