package com.idle.stuff.data.repository;

import com.idle.stuff.data.db.daos.PostsDao;
import com.idle.stuff.data.network.RetrofitClient;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RepositoryImpl_Factory implements Factory<RepositoryImpl> {
  private final Provider<RetrofitClient> retrofitClientProvider;

  private final Provider<PostsDao> postsDaoProvider;

  public RepositoryImpl_Factory(Provider<RetrofitClient> retrofitClientProvider,
      Provider<PostsDao> postsDaoProvider) {
    this.retrofitClientProvider = retrofitClientProvider;
    this.postsDaoProvider = postsDaoProvider;
  }

  @Override
  public RepositoryImpl get() {
    return newInstance(retrofitClientProvider.get(), postsDaoProvider.get());
  }

  public static RepositoryImpl_Factory create(Provider<RetrofitClient> retrofitClientProvider,
      Provider<PostsDao> postsDaoProvider) {
    return new RepositoryImpl_Factory(retrofitClientProvider, postsDaoProvider);
  }

  public static RepositoryImpl newInstance(RetrofitClient retrofitClient, PostsDao postsDao) {
    return new RepositoryImpl(retrofitClient, postsDao);
  }
}
